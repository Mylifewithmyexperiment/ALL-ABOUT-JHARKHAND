package ca.blogspot.sjatyourservice.allaboutjharkhand.Newnews;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

/**
 * Created by SHASHI on 11-Dec-17.
 */

public class Newnews extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener {


	private static final String URL_DATA = "http://www.onlinepadhailikhai.com/news/news.txt";




	private RecyclerView recyclerView;

	private Handler handler = new Handler();
	private SwipeRefreshLayout refreshLayout;
	private RecyclerView.Adapter adapter;

	private List<Listitem> listitems;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.csecontact);








		recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
		recyclerView.setNestedScrollingEnabled(false);
		refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
		refreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);


		refreshLayout.setOnRefreshListener(this);

		refreshLayout.post(new Runnable() {
							   @Override
							   public void run() {
								   refreshLayout.setRefreshing(true);

								   listitems.clear();
								   loaddata();
							   }
						   }
		);



		recyclerView.setHasFixedSize(true);

		final LinearLayoutManager layoutParams = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutParams);
		//recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


		recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

			@Override
			public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

			}

			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
				refreshLayout.setEnabled(layoutParams.findFirstCompletelyVisibleItemPosition() == 0);
			}
		});


		listitems= new ArrayList<>();

		loaddata();


	}


	@Override
	public void onRefresh() {

		listitems.clear();
		loaddata();
	}

	private void loaddata() {


		refreshLayout.setRefreshing(true);


		StringRequest stringRequest = new StringRequest(Request.Method.GET,

				URL_DATA,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String s) {



						try {
							JSONObject jsonObject = new JSONObject(s);
							JSONArray array = jsonObject.getJSONArray("heroes");

							for(int i= 0;i<array.length(); i++){

								JSONObject o = array.getJSONObject(i);
								Listitem item = new Listitem(
										o.getString("name"),
										o.getString("about"),
										o.getString("image"),
										o.getString("puru")
								);

								listitems.add(item);


							}


							adapter = new Myadapter(listitems,getApplicationContext());
							recyclerView.setAdapter(adapter);


						} catch (JSONException e) {
							e.printStackTrace();
						}


						refreshLayout.setRefreshing(false);


					}
				},
				new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError volleyError) {


						Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG);

					}
				}
		);


		RequestQueue requestQueue = Volley.newRequestQueue(this);
		requestQueue.add(stringRequest);
	}



}

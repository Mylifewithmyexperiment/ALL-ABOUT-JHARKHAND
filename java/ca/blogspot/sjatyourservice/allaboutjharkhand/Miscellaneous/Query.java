package ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import ca.blogspot.sjatyourservice.allaboutjharkhand.ABOUT;
import ca.blogspot.sjatyourservice.allaboutjharkhand.MySingleton;
import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

public class Query extends AppCompatActivity {


	Button b;
	EditText e1, e2, e3, e4;
	String Name, Email, Phone, Query;
	private Toolbar toolbar;

	AlertDialog.Builder builder;

	//String reg_url="http://172.16.10.116/register_Query.php";
	//String reg_url="http://192.168.43.38/register_Query.php";

	String reg_url="https://sjatyourservice.000webhostapp.com/www/register_Query.php";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_query);


		b=(Button)findViewById(R.id.btn_baidh2);

		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		e4=(EditText)findViewById(R.id.editText4);

		builder=new AlertDialog.Builder(Query.this);

		b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Name=e1.getText().toString();
				Email=e2.getText().toString();
				Phone=e3.getText().toString();
				Query=e4.getText().toString();


				if(Name.equals("")||Email.equals("")||Phone.equals("")||Query.equals(""))
				{
					builder.setTitle("Something went Wrong");
					builder.setMessage("Please fill all fields !!!");
					displayAlert("input_error");
				}


				else
				{
					StringRequest stringRequest=new StringRequest(Request.Method.POST, reg_url,
							new Response.Listener<String>() {
								@Override
								public void onResponse(String response) {

									try {
										JSONArray jsonArray=new JSONArray(response);
										JSONObject jsonObject=jsonArray.getJSONObject(0);

										String code=jsonObject.getString("code");
										String message=jsonObject.getString("message");

										builder.setTitle("Server Response......");
										builder.setMessage(message);
										displayAlert(code);

										Toast.makeText(Query.this,"Query Submitted " +
												"to government. Thank you.!!",Toast.LENGTH_SHORT).show();
									} catch (JSONException e) {
										e.printStackTrace();
									}

								}
							}, new Response.ErrorListener() {
						@Override
						public void onErrorResponse(VolleyError error) {
							Toast.makeText(Query.this,"Query Submitted " +
									"to government. Thank you.!!",Toast.LENGTH_SHORT).show();
							error.printStackTrace();

						}
					})
					{
						@Override
						protected Map<String, String> getParams() throws AuthFailureError {

							Map<String,String> params=new HashMap<String, String>();
							params.put("Name",Name);
							params.put("Email",Email);
							params.put("Phone",Phone);
							params.put("Query", Query);


							return params;
						}
					}
							;
					MySingleton.getMinstance(getApplicationContext()).AddtoRq(stringRequest);
					// MySingleton.getMinstance(Register.this).AddtoRq(stringRequest);
				}
			}
		});

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
	/**
	 @Override
	 public void onBackPressed() {
	 DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
	 if (drawer.isDrawerOpen(GravityCompat.START)) {
	 drawer.closeDrawer(GravityCompat.START);
	 } else {
	 super.onBackPressed();
	 }
	 }
	 **/
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.homeoption, menu);

		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			default:
				finish();
				break;

			case R.id.item1:
				Intent localIntent = new Intent("android.intent.action.SEND");
				localIntent.setType("text/plain");
				//  localIntent.addFlags(524288);
				localIntent.putExtra("android.intent.extra.SUBJECT", "ALL ABOUT JHARKHAND");
				localIntent.putExtra("android.intent.extra.TEXT", "Now know your Jharkhand 	with " +
						"more updated information on its demographic and non-demographic " +
						"information.Also u can play quiz on Jharkhand information get " +
						"location map.U can give your feedback to government or can ask " +
						"query, just click here to visit app "+
						"https://play.google.com/store/apps/details?id=ca.blogspot.sjatyourservice.allaboutjharkhand&hl=en"
				);
				startActivity(Intent.createChooser(localIntent, "ALL ABOUT JHARKHAND!"));
				break;

			case R.id.item2:
				Intent localIntent1 = new Intent("android.intent.action.VIEW");
				localIntent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=ca.blogspot.sjatyourservice.allaboutjharkhand&hl=en"));
				startActivity(localIntent1);
				break;

			case R.id.item3:
				Intent i = new Intent(this,About_Developer.class);
				startActivity(i);
				break;

			case R.id.item4:
				Toast.makeText(Query.this,"WELCOME TO APP INFORMATION",Toast
						.LENGTH_LONG).show();
				Intent i1 = new Intent(this,About_App.class);
				startActivity(i1);
				break;

			case R.id.item5:
				finishAffinity();
				break;

			case R.id.home:
				Intent i4 = new Intent(this,ABOUT.class);
				startActivity(i4);
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void displayAlert(final String code)
	{
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

				if(code.equals("input_error"))
				{
					e4.setText("");

				}
				else if(code.equals("reg_success"))
				{
					finish();
				}
				else if(code.equals("reg_failed"))
				{
					e1.setText("");
					e2.setText("");
					e3.setText("");
					e4.setText("");

				}

			}

		});
		AlertDialog alertDialog= builder.create();
		alertDialog.show();
	}
}


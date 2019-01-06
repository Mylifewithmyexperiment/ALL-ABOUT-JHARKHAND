package ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

public class Weather extends AppCompatActivity {
 TextView tempr, des, citie; TextView dat;ImageView iv;
 EditText et1; Button b;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.activity_weather);

	 tempr = (TextView) findViewById(R.id.temp);
	 des = (TextView) findViewById(R.id.descr);
	 citie = (TextView) findViewById(R.id.city);
	 dat = (TextView) findViewById(R.id.date);
	 iv = (ImageView) findViewById(R.id.imageView1);
	 et1 = (EditText) findViewById(R.id.editText1);
	 // temp.setText("0");
	 dat.setText(getDate());


 }

	public void onClick(View v){



		String ci=et1.getText().toString();


		String url = "http://api.openweathermap.org/data/2.5/weather?q="+ci+"&units=metric&appid=97ba5c2139f4fd537fa91d90e6176bc9";

		JsonObjectRequest jsObjRequest = new JsonObjectRequest
				(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject responseobj) {
						// temp.setText("Response: " + response.toString());
						Log.v("WEATHER","Response: " + responseobj.toString());

						try {
							JSONObject main=responseobj.getJSONObject("main");
							String tem=  Integer.toString((int) Math.round(main.getDouble("temp")));
							tempr.setText(tem);

							JSONArray wetarray=responseobj.getJSONArray("weather");
							JSONObject firstobj=wetarray.getJSONObject(0);



							String weatdesc=  firstobj.getString("description");
							String citiee= responseobj.getString("name");


							des.setText(weatdesc);
							citie.setText(citiee);

							int iconresourceid=getResources().getIdentifier("icon_"+weatdesc.replace(" ",""),"drawable",getPackageName());
							iv.setImageResource(iconresourceid);

						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub

					}
				});


		RequestQueue requestQueue= Volley.newRequestQueue(this);
		requestQueue.add(jsObjRequest);
	}

  // iv.setImageResource(R.drawable.sunny);


 private String getDate()
 {
  Calendar calendar=Calendar.getInstance();
  SimpleDateFormat dateFormat=new SimpleDateFormat("EEEE, MMM dd");
  String formattedDate=dateFormat.format(calendar.getTime());

  return formattedDate;
 }
}

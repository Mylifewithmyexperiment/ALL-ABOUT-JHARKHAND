package ca.blogspot.sjatyourservice.allaboutjharkhand;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.pm.ActivityInfo;
/**
import android.annotation.TargetApi;
import android.app.ProgressDialog;

import android.os.AsyncTask;
import android.os.Build;

import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
**/
public class Fetching_Feebback_List extends AppCompatActivity {

	//String Name2,Email2;
//private ListView Email, Name;
	private TextView Email, Name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fetching_feebback__list);
		Email = (TextView) findViewById(R.id.tv_Email);
		Name = (TextView) findViewById(R.id.tv_Name);
		// Email=(ListView) findViewById(R.id.tv_Email);
		//Name=(ListView) findViewById(R.id.tv_Name);
		//String Name2=Name.getText().toString();
		//	String Email2=Email.getText().toString();
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		//new AsyncJsonObject().execute("http://172.16.10.116/getdata.php");
	}
}

/**
	private void loadIntoListView(String json) throws JSONException {


	}





	private  class  AsyncJsonObject extends AsyncTask<String, Void, String>
	{

		private ProgressDialog progressDialog;

		@Override
		protected String doInBackground(String... params)
		{

			HttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());
			//  HttpPost httpPost = new HttpPost("http://10.0.2.2/androidlogin/index.php");
			HttpPost httpPost = new HttpPost(params[0]);

			String jsonResult = "";

			try {
				HttpResponse response = httpClient.execute(httpPost);
				jsonResult = inputStreamToString(response.getEntity().getContent()).toString();
				System.out.println("Returned Json object " + jsonResult.toString());

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return jsonResult;
		}


		JSONObject jsonObj  ;
		JSONArray peoples;
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressDialog = ProgressDialog.show(Fetching_Feebback_List.this, "Downloading Quiz","Wait....",
					true);
		}


		@TargetApi(Build.VERSION_CODES.CUPCAKE)
		@Override
		protected void onPostExecute(String result)
		{
			super.onPostExecute(result);
			progressDialog.dismiss();
			Toast.makeText(getApplicationContext(),"Resulted Value: " + result,Toast.LENGTH_LONG).show();
			// parsedObject = returnParsedJsonObject(result);

			try {
				jsonObj = new JSONObject(result);
				peoples = jsonObj.getJSONArray("Details");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if(result == null){
				return;
			}
			// quizCount = parsedObject.size();

			JSONArray jsonArray=peoples;

			//creating a string array for listview
			// String[] heroes = new String[jsonArray.length()];

			//looping through all the elements in json array
			for (int i = 0; i < jsonArray.length(); i++) {

				//getting json object from the json array
				JSONObject obj=null;
				try {
					obj = jsonArray.getJSONObject(i);
				} catch (JSONException e) {
					e.printStackTrace();
				}

				try {

				    Name.setText(obj.get("Name").toString());
					Email.setText(obj.get("Email").toString());

				} catch (JSONException e) {
					e.printStackTrace();
				}

				//getting the name from the json object and putting it inside string array
			}

		}

		private StringBuilder inputStreamToString(InputStream is) {
			String rLine = "";
			StringBuilder answer = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			try {
				while ((rLine = br.readLine()) != null) {
					answer.append(rLine);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return answer;
		}
	}

}

**/
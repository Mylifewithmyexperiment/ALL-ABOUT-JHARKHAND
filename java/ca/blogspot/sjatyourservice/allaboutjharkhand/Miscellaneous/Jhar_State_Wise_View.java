package ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

public class Jhar_State_Wise_View extends AppCompatActivity {

private WebView MAP;
private Toolbar toolbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jhar__state__wise__view);

		MAP =(WebView)findViewById(R.id.webViewJharkhand_map);
		//this.MAP.loadUrl("file:///android_res/drawable/home_bg_jhar.png");
		MAP.getSettings().setAllowFileAccessFromFileURLs(true);
		MAP.getSettings().setAllowUniversalAccessFromFileURLs(true);
		MAP.setWebViewClient(new myWebClient());
		MAP.loadUrl("file:///android_asset/home_bg_jhar.png");
		MAP.setHorizontalScrollBarEnabled(false);
		MAP.getSettings().setJavaScriptEnabled(true);
		MAP.getSettings().setBuiltInZoomControls(true);
		MAP.getSettings().setSupportZoom(true);
		MAP.getSettings().setDisplayZoomControls(true);
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
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
				Toast.makeText(Jhar_State_Wise_View.this,"WELCOME TO APP INFORMATION",Toast
						.LENGTH_LONG).show();
				Intent i1 = new Intent(this,About_App.class);
				startActivity(i1);
				break;

			case R.id.item5:
				finishAffinity();
				break;
		}
		return super.onOptionsItemSelected(item);
	}





	private class myWebClient extends WebViewClient {
		public myWebClient() {

	}
		public void onPageFinished(WebView paramWebView,String paramString){
			super.onPageFinished(paramWebView, paramString);


		}



		public void onPageStarted (WebView paramWebView,String paramString,Bitmap paramBitmap  )
	{
		super.onPageStarted(paramWebView, paramString ,paramBitmap);
	}


	public boolean shouldOverrideUrlLoading (WebView paramWebView, String paramString)
	{
		paramWebView.loadUrl(paramString);
		return true;
	}


}

}

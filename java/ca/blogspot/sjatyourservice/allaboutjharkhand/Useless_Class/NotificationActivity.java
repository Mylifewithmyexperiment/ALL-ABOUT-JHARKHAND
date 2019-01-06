package ca.blogspot.sjatyourservice.allaboutjharkhand.Useless_Class;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import ca.blogspot.sjatyourservice.allaboutjharkhand.ABOUT;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.About_App;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.About_Developer;
import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

public class NotificationActivity extends AppCompatActivity {
	private Toolbar toolbar;
	private AdView mAdView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);

		WebView web_view_Redirecting =(WebView) findViewById(R.id.web_view_redirecting_site);

		web_view_Redirecting.getSettings().setJavaScriptEnabled(true);
		web_view_Redirecting.setWebViewClient(new WebViewClient());
		web_view_Redirecting.loadUrl("http://www.jharkhand.gov.in/");

		MobileAds.initialize(this, "ca-app-pub-5278704802151871~2335007935");
		mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.build();
		mAdView.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {
				mAdView.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAdFailedToLoad(int i) {
				mAdView.setVisibility(View.GONE);
			}
		});
		mAdView.loadAd(adRequest);

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
				Toast.makeText(NotificationActivity.this,"WELCOME TO APP INFORMATION",Toast
						.LENGTH_LONG).show();
				Intent i1 = new Intent(this,About_App.class);
				startActivity(i1);
				break;

			case R.id.item5:
				finishAffinity();
				break;
			case R.id.home:
				Intent i11 = new Intent(this,ABOUT.class);
				startActivity(i11);
				break;
		}
		return super.onOptionsItemSelected(item);
	}

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


/**

 http://www.jharkhand.gov.in/state-agency


 http://jharkhandtourism.gov.in/eventsFestivalsDetails/8

 http://www.jharkhand.gov.in/
 **/
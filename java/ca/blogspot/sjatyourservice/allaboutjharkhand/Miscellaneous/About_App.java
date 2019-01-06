package ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous;

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
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

public class About_App extends AppCompatActivity {
private  Toolbar toolbar;
private  AdView mAdView;
private InterstitialAd interstitialAd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about__app);
		InitUi();


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

		interstitialAd = new InterstitialAd(this);
		interstitialAd.setAdUnitId("ca-app-pub-5278704802151871/1122469080");
		interstitialAd.loadAd(new AdRequest.Builder().build());



	}


	@Override
	public boolean onCreateOptionsMenu(final android.view.Menu menu)
	{


		interstitialAd.loadAd(new AdRequest.Builder().build());
		interstitialAd.setAdListener(new AdListener()
									 {
										 @Override
										 public void onAdClosed()
										 {
											 MenuInflater inflater = getMenuInflater();
											 inflater.inflate(R.menu.homeoption, menu);
											 interstitialAd.loadAd(new AdRequest.Builder().build());
										 }

									 }


		);
		if(interstitialAd.isLoaded())
		{
			interstitialAd.show();
		}

		else
		{
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.homeoption, menu);
		}

		return super.onCreateOptionsMenu(menu);

	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			default:
				finish();
				break;

			case R.id.item1:

				interstitialAd.loadAd(new AdRequest.Builder().build());
				interstitialAd.setAdListener(new AdListener() {
					@Override
					public void onAdClosed() {

						Intent localIntent = new Intent("android.intent.action.SEND");
						localIntent.setType("text/plain");
						//  localIntent.addFlags(524288);
						localIntent.putExtra("android.intent.extra.SUBJECT", "ALL ABOUT JHARKHAND");
						localIntent.putExtra("android.intent.extra.TEXT", "Now know your Jharkhand 	with " +
								"more updated information on its demographic and non-demographic " +
								"information.Also u can play quiz on Jharkhand information get " +
								"location map.U can give your feedback to government or can ask " +
								"query, just click here to visit app " +
								"https://play.google.com/store/apps/details?id=ca.blogspot.sjatyourservice.allaboutjharkhand&hl=en"
						);
						startActivity(Intent.createChooser(localIntent, "ALL ABOUT JHARKHAND!"));

						interstitialAd.loadAd(new AdRequest.Builder().build());
					}
				});
				if(interstitialAd.isLoaded())
				{
					interstitialAd.show();
				}
				else
				{
					Intent localIntent = new Intent("android.intent.action.SEND");
					localIntent.setType("text/plain");
					//  localIntent.addFlags(524288);
					localIntent.putExtra("android.intent.extra.SUBJECT", "ALL ABOUT JHARKHAND");
					localIntent.putExtra("android.intent.extra.TEXT", "Now know your Jharkhand 	with " +
							"more updated information on its demographic and non-demographic " +
							"information.Also u can play quiz on Jharkhand information get " +
							"location map.U can give your feedback to government or can ask " +
							"query, just click here to visit app " +
							"https://play.google.com/store/apps/details?id=ca.blogspot.sjatyourservice.allaboutjharkhand&hl=en"
					);
					startActivity(Intent.createChooser(localIntent, "ALL ABOUT JHARKHAND!"));
				}
				break;

			case R.id.item2:

			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener() {
				@Override
				public void onAdClosed() {
					Intent localIntent1 = new Intent("android.intent.action.VIEW");
					localIntent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=ca.blogspot.sjatyourservice.allaboutjharkhand&hl=en"));
					startActivity(localIntent1);

					interstitialAd.loadAd(new AdRequest.Builder().build());
				}
			});

			if(interstitialAd.isLoaded())

			{
				interstitialAd.show();
			}
			else
			{
				Intent localIntent1 = new Intent("android.intent.action.VIEW");
				localIntent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=ca.blogspot.sjatyourservice.allaboutjharkhand&hl=en"));
				startActivity(localIntent1);
			}

				break;


			case R.id.item3:

				interstitialAd.loadAd(new AdRequest.Builder().build());
				interstitialAd.setAdListener(new AdListener()

											 {

											 	@Override
												 public void onAdClosed()
												{
													Intent i = new Intent(About_App.this,
															About_Developer.class);
													startActivity(i);
													interstitialAd.loadAd(new AdRequest.Builder()
															.build());
												}

											 }

				);


				if(interstitialAd.isLoaded())
				{
					interstitialAd.show();
				}
				else
				{
					Intent i = new Intent(About_App.this,
							About_Developer.class);
					startActivity(i);
					interstitialAd.loadAd(new AdRequest.Builder()
							.build());
				}
				break;

			case R.id.item4:
				interstitialAd.loadAd(new AdRequest.Builder().build());
				interstitialAd.setAdListener(new AdListener()
											 {
											 	@Override
												 public void onAdClosed()
												 {
													 Toast.makeText(About_App.this,"WELCOME TO APP INFORMATION",Toast
															 .LENGTH_LONG).show();
													 Intent i1 = new Intent(About_App.this,About_App
															 .class);
													 startActivity(i1);
													 interstitialAd.loadAd(new AdRequest.Builder
															 ().build());
												 }
											 }

				);

				if(interstitialAd.isLoaded())

				{
					interstitialAd.show();
				}
				else
				{
					Toast.makeText(About_App.this,"WELCOME TO APP INFORMATION",Toast
							.LENGTH_LONG).show();
					Intent i1 = new Intent(About_App.this,About_App
							.class);
					startActivity(i1);
					interstitialAd.loadAd(new AdRequest.Builder
							().build());
				}

				break;

			case R.id.item5:

				interstitialAd.loadAd(new AdRequest.Builder().build());
				interstitialAd.setAdListener(new AdListener()
											 {
											 	@Override
												 public void onAdClosed()
												{
													finishAffinity();
													interstitialAd.loadAd(new AdRequest.Builder().build());
												}
											 }

				);
				if(interstitialAd.isLoaded())
				{
				interstitialAd.show();
				}
				else
				{
					finishAffinity();
				}
				break;
		}
		return super.onOptionsItemSelected(item);



	}



	private void InitUi() {


		WebView view50 = (WebView) findViewById(R.id.text50);
		String text50;
		text50 = "<html><body><p align=\"justify\"><br>";
		text50 += getResources().getString(R.string.text50);
		text50 += "</br></p></body></html>";
		view50.loadData(text50, "text/html", "utf-8");
		view50.setBackgroundColor(0);


		WebView view60 = (WebView) findViewById(R.id.text60);
		String text60;
		text60 = "<html><body><p align=\"justify\"><br>";
		text60 += getResources().getString(R.string.text60);
		text60 += "</br></p></body></html>";
		view60.loadData(text60, "text/html", "utf-8");
        view60.setBackgroundColor(0);

	}
}
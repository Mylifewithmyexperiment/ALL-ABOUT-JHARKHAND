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
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

public class Faq extends AppCompatActivity {
private Toolbar toolbar;
private AdView mAdView;
private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
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

		interstitialAd = new InterstitialAd(this);
		interstitialAd.setAdUnitId("ca-app-pub-5278704802151871/1122469080");
		interstitialAd.loadAd(new AdRequest.Builder().build());



		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
													 Intent i = new Intent(Faq.this,
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
					Intent i = new Intent(Faq.this,
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
													 Toast.makeText(Faq.this,"WELCOME TO APP INFORMATION",Toast
															 .LENGTH_LONG).show();
													 Intent i1 = new Intent(Faq.this,About_App
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
					Toast.makeText(Faq.this,"WELCOME TO APP INFORMATION",Toast
							.LENGTH_LONG).show();
					Intent i1 = new Intent(Faq.this,About_App
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


	private void InitUi(){


		WebView view1 = (WebView) findViewById(R.id.text1);
		String text1;
		text1 = "<html><body><p align=\"justify\"><br><font size=3dp,type=bold,face=Times New " +
				"Roman" +
				" >";
		text1+= getResources().getString(R.string.text1);
		text1+= "</font></br></p></body></html>";
		view1.loadData(text1, "text/html", "utf-8");
		view1.setBackgroundColor(0);
        //view1.setBackgroundResource(Color.TRANSPARENT);

	   WebView view2 = (WebView) findViewById(R.id.text2);
	   String text2;
	   text2 = "<html><body><p align=\"justify\">";
	   text2+= getResources().getString(R.string.text2);
	   text2+= "</p></body></html>";
	   view2.loadData(text2, "text/html", "utf-8");
	   view2.setBackgroundColor(0);

	   WebView view3=(WebView) findViewById(R.id.text3);
	   String text3;
	   text3= "<html><body><p aling=\"justify\">";
	   text3+=getResources().getString(R.string.text3);
	   text3+="</p></body></html>";
	   view3.loadData(text3,"text/html", "utf-8");
	   view3.setBackgroundColor(0);

	   WebView view4=(WebView) findViewById(R.id.text4);
	   String text4;
	   text4= "<html><body><p aling=\"justify\">";
	                                          text4+=getResources().getString(R.string.text4);
	   text4+="</p></body></html>";

	   view4.loadData(text4,"text/html", "utf-8");
	   view4.setBackgroundColor(0);

	   WebView view5=(WebView) findViewById(R.id.text5);
	   String text5;
	   text5= "<html><body><p aling=\"justify\">";
	   text5+=getResources().getString(R.string.text5);
	   text5+="</p></body></html>";
	   view5.loadData(text5,"text/html", "utf-8");
	   view5.setBackgroundColor(0);


	   WebView view6=(WebView) findViewById(R.id.text6);
	   String text6;
	   text6= "<html><body><p aling=\"justify\">";
	   text6+=getResources().getString(R.string.text6);
	   text6+="</p></body></html>";
	   view6.loadData(text6,"text/html", "utf-8");
	   view6.setBackgroundColor(0);


	   WebView view7=(WebView) findViewById(R.id.text7);
	   String text7;
	   text7= "<html><body><p aling=\"justify\">";
	   text7+=getResources().getString(R.string.text7);
	   text7+="</p></body></html>";
	   view7.loadData(text7,"text/html", "utf-8");
	   view7.setBackgroundColor(0);


	   WebView view8=(WebView) findViewById(R.id.text8);
	   String text8;
	   text8= "<html><body><p aling=\"justify\">";
	   text8+=getResources().getString(R.string.text8);
	   text8+="</p></body></html>";
	   view8.loadData(text8,"text/html", "utf-8");
	   view8.setBackgroundColor(0);

	   WebView view9=(WebView) findViewById(R.id.text9);
	   String text9;
	   text9= "<html><body><p aling=\"justify\">";
	   text9+=getResources().getString(R.string.text9);
	   text9+="</p></body></html>";
	   view9.loadData(text9,"text/html", "utf-8");
	   view9.setBackgroundColor(0);

	   WebView view10=(WebView) findViewById(R.id.text10);
	   String text10;
	   text10= "<html><body><p aling=\"justify\">";
	   text10+=getResources().getString(R.string.text10);
	   text10+="</p></body></html>";
	   view10.loadData(text10,"text/html", "utf-8");
	   view10.setBackgroundColor(0);

   }

}

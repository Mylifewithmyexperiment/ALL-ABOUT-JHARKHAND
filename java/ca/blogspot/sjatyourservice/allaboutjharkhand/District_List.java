package ca.blogspot.sjatyourservice.allaboutjharkhand;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayBokaro;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayChatra;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayDeoghar;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayDhanbad;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayDumka;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayEast_Singhbhum;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayGiridih;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayGodda;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayGumla;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayHazaribagh;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayJamtara;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayKhunti;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayKoderma;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayLatehar;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayLohardaga;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayPakur;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayPalamu;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayRamgarh;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayRanchi;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplaySahebganj;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplaySaraikela_Kharsawan;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplaySimdega;
import ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class.DisplayWest_Singhbhum;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.About_App;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.About_Developer;

public class District_List extends AppCompatActivity {
private 	Toolbar toolbar;
private InterstitialAd interstitialAd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_district__list);

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
													 Intent i = new Intent(District_List.this,
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
					Intent i = new Intent(District_List.this,
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
													 Toast.makeText(District_List.this,"WELCOME TO APP INFORMATION",Toast
															 .LENGTH_LONG).show();
													 Intent i1 = new Intent(District_List.this,About_App
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
					Toast.makeText(District_List.this,"WELCOME TO APP INFORMATION",Toast
							.LENGTH_LONG).show();
					Intent i1 = new Intent(District_List.this,About_App
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









	public void PalamauActivity(View view) {
		startActivity(new Intent( this, DisplayPalamu.class));
	}

	public void LateharActivity(View view) {
		startActivity(new Intent(this, DisplayLatehar.class));
	}
	public void GarhwaActivity(View view) {
		startActivity(new Intent(this, DisplayLatehar.class));
	}

	public void ChatraActivity(View view) {
		startActivity(new Intent(this, DisplayChatra.class));
	}

	public void HazaribaghActivity(View view) {
		startActivity(new Intent(this, DisplayHazaribagh.class));
	}

	public void KodermaActivity(View view) {
		startActivity(new Intent(this, DisplayKoderma.class));
	}

	public void GiridihActivity(View view) {
		startActivity(new Intent(this, DisplayGiridih.class));
	}
	public void RamgarhActivity(View view) {
		startActivity(new Intent(this, DisplayRamgarh.class));
	}

	public void BokaroActivity(View view) {
		startActivity(new Intent(this, DisplayBokaro.class));
	}

	public void DhanbadActivity(View view) {
		startActivity(new Intent(this, DisplayDhanbad.class));
	}

	public void LohardagaActivity(View view) {
		startActivity(new Intent(this, DisplayLohardaga.class));
	}

	public void GumlaActivity(View view) {
		startActivity(new Intent(this, DisplayGumla.class));
	}
   public void SimdegaActivity(View view) {
		startActivity(new Intent(this, DisplaySimdega.class));
	}

	public void RanchiActivity(View view) {
		startActivity(new Intent(this, DisplayRanchi.class));
	}




	public void KhuntiActivity(View view) {
		startActivity(new Intent(this, DisplayKhunti.class));
	}

	public void West_SinghbhumActivity(View view) {
		startActivity(new Intent(this, DisplayWest_Singhbhum.class));
	}

	public void Saraikela_KharsawanActivity(View view) {
		startActivity(new Intent(this, DisplaySaraikela_Kharsawan.class));
	}

	public void East_SinghbhumActivity(View view) {
		startActivity(new Intent(this, DisplayEast_Singhbhum.class));
	}


	public void JamtaraActivity(View view) {
		startActivity(new Intent(this, DisplayJamtara.class));
	}


	public void DeogharActivity(View view) {
		startActivity(new Intent(this, DisplayDeoghar.class));
	}

	public void DumkaActivity(View view) {
		startActivity(new Intent(this, DisplayDumka.class));
	}

	public void PakurActivity(View view) {
		startActivity(new Intent(this, DisplayPakur.class));
	}

	public void GoddaActivity(View view) {
		startActivity(new Intent(this, DisplayGodda.class));
	}

	public void SahebganjActivity(View view) {
		startActivity(new Intent(this, DisplaySahebganj.class));
	}





}

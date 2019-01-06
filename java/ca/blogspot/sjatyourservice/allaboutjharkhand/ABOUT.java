package ca.blogspot.sjatyourservice.allaboutjharkhand;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import ca.blogspot.sjatyourservice.allaboutjharkhand.Google_Location.MapsActivity;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Jharkhand_Quiz.JHARKHAND_Quiz;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.About_App;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.About_Developer;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.Faq;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.Feedback;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.Jhar_State_Wise_View;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.Query;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.Weather;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Newnews.Newnews;


public class ABOUT extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener ,AdapterView.OnItemClickListener

{
	GridView gv1;
	Toolbar toolbar;
	private InterstitialAd interstitialAd;

	String[] arr = {"State Details","Districts Details", " Play Quiz" ,"Places near you",
					"Weather Information", "About Developer"};
	int[] icon = { R.drawable.icon_state_detail, R.drawable.icon_jharkhand,R.drawable.quiz_icon ,R.drawable.map_loc,R.drawable.weather_icon1,R.drawable
			.icon_about_app };


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		gv1 = (GridView) findViewById(R.id.grid_view1);
		ArrayAdapter adapter1 = new MyAdapter1(this, arr, icon);
		gv1.setAdapter(adapter1);
		gv1.setOnItemClickListener(this);


		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent feedback =new Intent(ABOUT.this,Feedback.class);
				startActivity(feedback);

			}
		});

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);

		interstitialAd = new InterstitialAd(this);
		interstitialAd.setAdUnitId("ca-app-pub-5278704802151871/1122469080");
		interstitialAd.loadAd(new AdRequest.Builder().build());




	}




	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
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
													 Intent i = new Intent(ABOUT.this,
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
					Intent i = new Intent(ABOUT.this,
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
													 Toast.makeText(ABOUT.this,"WELCOME TO APP INFORMATION",Toast
															 .LENGTH_LONG).show();
													 Intent i1 = new Intent(ABOUT.this,About_App
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
					Toast.makeText(ABOUT.this,"WELCOME TO APP INFORMATION",Toast
							.LENGTH_LONG).show();
					Intent i1 = new Intent(ABOUT.this,About_App
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

	//navigation bar code
	//@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if (id == R.id.nav_state_map)
		{


			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {
				Intent reg=new Intent(ABOUT.this,Jhar_State_Wise_View.class);
				startActivity(reg);
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
				Intent reg=new Intent(ABOUT.this,Jhar_State_Wise_View.class);
				startActivity(reg);
			}

		}


		else if (id == R.id.more_about_jharkhand)
		{


			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {
												 Intent more=new Intent(ABOUT.this,MoreAboutJharkhand.class);
												 startActivity(more);

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
				Intent more=new Intent(ABOUT.this,MoreAboutJharkhand.class);
				startActivity(more);

			}




		}


		else if (id == R.id.purunews)
		{

			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {
												 Intent nore=new Intent(ABOUT.this,Newnews.class);
												 startActivity(nore);
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
				Intent nore=new Intent(ABOUT.this,Newnews.class);
				startActivity(nore);
			}




		}


		else if (id == R.id.nav_map_gps)
		{

			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {
												 Intent reg=new Intent(ABOUT.this,MapsActivity.class);
												 startActivity(reg);
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
				Intent reg=new Intent(ABOUT.this,MapsActivity.class);
				startActivity(reg);
			}





		}

		else if (id == R.id.nav_que)
		{


			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {

												 Intent que=new Intent(ABOUT.this,Query.class);
												 startActivity(que);
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

				Intent que=new Intent(ABOUT.this,Query.class);
				startActivity(que);
			}





		} else if (id == R.id.nav_fed) {


			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {

												 Intent fed =new Intent(ABOUT.this,Feedback.class);
												 startActivity(fed);
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

				Intent fed =new Intent(ABOUT.this,Feedback.class);
				startActivity(fed);
			}




		}
		else if (id == R.id.nav_weat) {


			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {

												 Toast.makeText(ABOUT.this,"GET WEATHER INFORMATION ",Toast
														 .LENGTH_LONG).show();
												 Intent wea =new Intent(ABOUT.this,Weather.class);
												 startActivity(wea);
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
				Toast.makeText(ABOUT.this,"GET WEATHER INFORMATION ",Toast
						.LENGTH_LONG).show();
				Intent wea =new Intent(ABOUT.this,Weather.class);
				startActivity(wea);
			}





		}
		else if (id == R.id.nav_quiz) {

			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {

												 Toast.makeText(ABOUT.this,"Test your Skill and play Quiz ",Toast
														 .LENGTH_LONG).show();
												 Intent quiz =new Intent(ABOUT.this,JHARKHAND_Quiz.class);
												 startActivity(quiz);
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
				Toast.makeText(ABOUT.this,"Test your Skill and play Quiz ",Toast
						.LENGTH_LONG).show();
				Intent quiz =new Intent(ABOUT.this,JHARKHAND_Quiz.class);
				startActivity(quiz);
			}





		}


		else if (id == R.id.nav_share) {



			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {

												 shareit();

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
				shareit();

			}





		}

		else if (id == R.id.nav_rate) {



			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {



												 openAppInPlayStore();

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


				openAppInPlayStore();

			}





		}
		else if (id == R.id.nav_abt_app) {



			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {
												 Intent state =new Intent(ABOUT.this,About_App.class);
												 startActivity(state);

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

				Intent state =new Intent(ABOUT.this,About_App.class);
				startActivity(state);

			}








		}

		else if (id == R.id.nav_faq) {



			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {


												 Intent faq =new Intent(ABOUT.this,Faq.class);
												 startActivity(faq);

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


				Intent faq =new Intent(ABOUT.this,Faq.class);
				startActivity(faq);

			}










		}
		else if (id == R.id.nav_dev) {


			interstitialAd.loadAd(new AdRequest.Builder().build());
			interstitialAd.setAdListener(new AdListener()
										 {
											 @Override
											 public void onAdClosed()
											 {



												 Intent dev =new Intent(ABOUT.this,About_Developer.class);
												 startActivity(dev);

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



				Intent dev =new Intent(ABOUT.this,About_Developer.class);
				startActivity(dev);


			}





		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	// share and rate us it message <code> codes are here </code>

	//sharing activities method are kept out of the bundled saves instances method
	protected void shareit(){
		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");
		sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Now know your Jharkhand 	with " +
				"more updated information on its demographic and non-demographic " +
				"information.Also u can play quiz on Jharkhand information get " +
				"location map.U can give your feedback to government or can ask " +
				"query, just click here to visit app "+
				"https://play.google.com/store/apps/details?id=ca.blogspot.sjatyourservice.allaboutjharkhand&hl=en"
		);
		startActivity(Intent.createChooser(sharingIntent, "Share via"));


	}

	//for opening app in play store
	public  void openAppInPlayStore() {

		final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
		try {
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=ca.blogspot.sjatyourservice.allaboutjharkhand&hl=en" + appPackageName)));
		} catch (android.content.ActivityNotFoundException anfe) {
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=ca.blogspot.sjatyourservice.allaboutjharkhand&hl=en" + appPackageName)));
		}



		//  paramContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play
		// .google.com/store/apps/details?id=ca.blogspot.sjatyourservice.allaboutjharkhand")));
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

		switch (i) {
			case 0:
				Toast.makeText(ABOUT.this, "State Details", Toast.LENGTH_SHORT).show();
				Intent stdel = new Intent(ABOUT.this,Fragment_Collection.class);
				startActivity(stdel);
				break;

			case 1:
				Toast.makeText(ABOUT.this, "Districts Details ", Toast.LENGTH_SHORT).show();
				Intent list_of_state = new Intent(ABOUT.this,District_List.class);
				startActivity(list_of_state);
				break;

			case 2:

				Toast.makeText(ABOUT.this, " play Quiz", Toast.LENGTH_SHORT).show();
				Intent i1 = new Intent(ABOUT.this,JHARKHAND_Quiz.class);
				startActivity(i1);
				break;

			case 3:

				Toast.makeText(ABOUT.this, "Get your current location", Toast.LENGTH_SHORT).show();
				Intent map = new Intent(ABOUT.this,MapsActivity.class);
				startActivity(map);
				break;


			case 4:
				Toast.makeText(ABOUT.this, "Get Weather Details", Toast.LENGTH_SHORT).show();
				Intent weather = new Intent(ABOUT.this,Weather.class);
				startActivity(weather);
				break;

			case 5:
				Toast.makeText(ABOUT.this,"ABout Developer", Toast.LENGTH_LONG).show();
				Intent about = new Intent(ABOUT.this, About_Developer.class);
				startActivity(about);






		}

	}




	class MyAdapter1 extends ArrayAdapter {
		int[] imageArray;
		String[] titleArray;

		public MyAdapter1(Context c, String[] branch1, int[] icon1) {
			super(c,R.layout.menulist1,R.id.textView,branch1);
			this.imageArray=icon1;
			this.titleArray=branch1;
		}

		@NonNull
		@Override
		public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = inflater.inflate(R.layout.menulist1,parent,false);
			TextView tv = (TextView) v.findViewById(R.id.textView);
			ImageView iv = (ImageView) v.findViewById(R.id.imageView);
			tv.setText(titleArray[position]);
			iv.setImageResource(imageArray[position]);
			return v;

		}
	}





}



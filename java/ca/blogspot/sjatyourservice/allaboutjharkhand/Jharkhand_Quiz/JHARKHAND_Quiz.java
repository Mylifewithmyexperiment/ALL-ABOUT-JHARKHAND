package ca.blogspot.sjatyourservice.allaboutjharkhand.Jharkhand_Quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;


import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.About_App;
import ca.blogspot.sjatyourservice.allaboutjharkhand.Miscellaneous.About_Developer;
import ca.blogspot.sjatyourservice.allaboutjharkhand.MainActivity;
import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

import static ca.blogspot.sjatyourservice.allaboutjharkhand.R.id.time;
public class JHARKHAND_Quiz extends AppCompatActivity {


	Button answer1, answer2, answer3, answer4;
	TextView question1, score,tv_Level;
	Button start,over;    //start time and stop timer
	TextView tv;         //current time display
	private AdView mAdView;
	private Toolbar toolbar;

	private  Questions mQuestion = new Questions();
	private  Question11 mQuestion11=new Question11();
	private  Question101 mQuestion101=new Question101();
	private  Question1001 mQuestion1001=new Question1001();
	private String mAnswer;
	private int mScore = 0;
	CountDownT  countDownTimer;              // = new CountDownT(100000,1000);

	private int mQuestionsLength = mQuestion.mQuestion.length;
	private int mQuestionsLength11 = mQuestion11.mQuestion11.length;
	private int mQuestionsLength101 = mQuestion101.mQuestion101.length;
	private int mQuestionsLength1001 = mQuestion1001.mQuestion1001.length;
	Random r;

	private InterstitialAd interstitialAd;


	private void start()
	{
		countDownTimer.start();
		Toast.makeText(this, "Timer started", Toast.LENGTH_SHORT).show();
	}
	private void stop()
	{
		countDownTimer.cancel();
		Toast.makeText(this, "Quiz Stopped", Toast.LENGTH_SHORT).show();
		gameOver();
	}

	public class CountDownT extends CountDownTimer
	{
		public CountDownT(long millisInFuture, long TimeGap)
		{
			super(millisInFuture,TimeGap);
		}

		@Override
		public void onTick(long l)
		{
			tv.setText("         Time left: "+(l/1000)+"s ");
		}

		@Override
		public void onFinish()
		{
			tv.setText("      TIME OUT!!!!!");
			gameOver();
		}
	}



	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jharkhand__quiz);


		MobileAds.initialize(this,"ca-app-pub-5278704802151871~2335007935");
		mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.build();
		mAdView.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {
				mAdView.setVisibility(View.VISIBLE);
			}
			@Override
			public void onAdFailedToLoad (int i)
			{
				mAdView.setVisibility(View.GONE);
			}
		});
		mAdView.loadAd(adRequest);

		interstitialAd = new InterstitialAd(this);
		interstitialAd.setAdUnitId("ca-app-pub-5278704802151871/1122469080");
		interstitialAd.loadAd(new AdRequest.Builder().build());


		r = new Random();

		answer1 = (Button) findViewById(R.id.answer1);
		answer2 = (Button) findViewById(R.id.answer2);
		answer3 = (Button) findViewById(R.id.answer3);
		answer4 = (Button) findViewById(R.id.answer4);

		question1 = (TextView) findViewById(R.id.question1);
		score = (TextView) findViewById(R.id.score);
		tv_Level=(TextView) findViewById(R.id.tv_Level);

		start=(Button)findViewById(R.id.start);
		over=(Button)findViewById(R.id.over);

		tv=(TextView)findViewById(time);
		tv.setText(  "      You have 250 seconds!      ");

		countDownTimer = new CountDownT(250000,1000);

		start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				start();
			}
		});

		over.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				stop();
			}
		});

		score.setText("Score: " + mScore);

		if(mScore<=3)
		{

			updateQuestion(r.nextInt(mQuestionsLength));
			tv_Level.setText("Level 1");

		}
		else if(mScore>3 && mScore<=6)
		{

			updateQuestion11(r.nextInt(mQuestionsLength11));
			tv_Level.setText("Level 2");
		}
		else if(mScore>6 && mScore<=9 )
		{

			updateQuestion101(r.nextInt(mQuestionsLength101));
			tv_Level.setText("Level 3");
		}
		else if(mScore>9 )
		{

			updateQuestion1001(r.nextInt(mQuestionsLength1001));
			tv_Level.setText("Level 4");
		}

		answer1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				if (answer1.getText() == mAnswer) {
					mScore++;
					score.setText("Score: " + mScore);
					if(mScore<=3) {
						tv_Level.setText("Level 1");
						updateQuestion(r.nextInt(mQuestionsLength));

					}else if(mScore>3 && mScore<=6)
					{
						tv_Level.setText("Level 2");
						updateQuestion11(r.nextInt(mQuestionsLength11));
					}
					else if(mScore>6 && mScore<=9 )
					{
						tv_Level.setText("Level 3");
						updateQuestion101(r.nextInt(mQuestionsLength101));
					}
					else if(mScore>9 )
					{
						tv_Level.setText("Level 4");
						updateQuestion1001(r.nextInt(mQuestionsLength1001));
					}
				}
				else {
					gameOver();
				}

			}
		});


		answer2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (answer2.getText() == mAnswer) {
					mScore++;
					score.setText("Score: " + mScore);
					if(mScore<=3) {
						tv_Level.setText("Level 1");
						updateQuestion(r.nextInt(mQuestionsLength));

					}else if(mScore>3 && mScore<=6)
					{
						tv_Level.setText("Level 2");
						updateQuestion11(r.nextInt(mQuestionsLength11));
					}
					else if(mScore>6 && mScore<=9 )
					{
						tv_Level.setText("Level 3");
						updateQuestion101(r.nextInt(mQuestionsLength101));
					}
					else if(mScore>9 )
					{
						tv_Level.setText("Level 4");
						updateQuestion1001(r.nextInt(mQuestionsLength1001));
					}
				}
				else {
					gameOver();
				}

			}
		});


		answer3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (answer3.getText() == mAnswer) {
					mScore++;
					score.setText("Score: " + mScore);
					if(mScore<=3) {
						tv_Level.setText("Level 1");
						updateQuestion(r.nextInt(mQuestionsLength));

					}else if(mScore>3 && mScore<=6)
					{
						tv_Level.setText("Level 2");
						updateQuestion11(r.nextInt(mQuestionsLength11));
					}
					else if(mScore>6 && mScore<=9 )
					{
						tv_Level.setText("Level 3");
						updateQuestion101(r.nextInt(mQuestionsLength101));
					}
					else if(mScore>9 )
					{
						tv_Level.setText("Level 4");
						updateQuestion1001(r.nextInt(mQuestionsLength1001));
					}
				}
				else {
					gameOver();
				}

			}
		});


		answer4.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view) {
				if (answer4.getText() == mAnswer) {
					mScore++;
					score.setText("Score: " + mScore);
					if(mScore<=3) {
						tv_Level.setText("Level 1");
						updateQuestion(r.nextInt(mQuestionsLength));

					}else if(mScore>3 && mScore<=6)
					{
						tv_Level.setText("Level 2");
						updateQuestion11(r.nextInt(mQuestionsLength11));
					}
					else if(mScore>6 && mScore<=9 )
					{
						tv_Level.setText("Level 3");
						updateQuestion101(r.nextInt(mQuestionsLength101));
					}
					else if(mScore>9 )
					{
						tv_Level.setText("Level 4");
						updateQuestion1001(r.nextInt(mQuestionsLength1001));
					}
				}
				else {
					gameOver();
				}

			}
		});

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
													 Intent i = new Intent(JHARKHAND_Quiz.this,
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
					Intent i = new Intent(this,
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
													 Toast.makeText(JHARKHAND_Quiz.this,"WELCOME " +
															 "TO " +
															 "APP " +
															 "INFORMATION",Toast
															 .LENGTH_LONG).show();
													 Intent i1 = new Intent(JHARKHAND_Quiz.this,
															 About_App
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
					Toast.makeText(this,"WELCOME TO APP INFORMATION",Toast
							.LENGTH_LONG).show();
					Intent i1 = new Intent(this,About_App
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


	private void updateQuestion(int num) {
		question1.setText(mQuestion.getQuestion(num));
		answer1.setText(mQuestion.getChoice1(num));
		answer2.setText(mQuestion.getChoice2(num));
		answer3.setText(mQuestion.getChoice3(num));
		answer4.setText(mQuestion.getChoice4(num));

		mAnswer= mQuestion.getCorrectAnswer(num);
	}


	private void updateQuestion11(int num) {
		question1.setText(mQuestion11.getQuestion(num));
		answer1.setText(mQuestion11.getChoice1(num));
		answer2.setText(mQuestion11.getChoice2(num));
		answer3.setText(mQuestion11.getChoice3(num));
		answer4.setText(mQuestion11.getChoice4(num));

		mAnswer= mQuestion11.getCorrectAnswer11(num);
	}


	private void updateQuestion101(int num) {
		question1.setText(mQuestion101.getQuestion(num));
		answer1.setText(mQuestion101.getChoice1(num));
		answer2.setText(mQuestion101.getChoice2(num));
		answer3.setText(mQuestion101.getChoice3(num));
		answer4.setText(mQuestion101.getChoice4(num));

		mAnswer= mQuestion101.getCorrectAnswer101(num);
	}

	private void updateQuestion1001(int num) {
		question1.setText(mQuestion1001.getQuestion(num));
		answer1.setText(mQuestion1001.getChoice1(num));
		answer2.setText(mQuestion1001.getChoice2(num));
		answer3.setText(mQuestion1001.getChoice3(num));
		answer4.setText(mQuestion1001.getChoice4(num));

		mAnswer= mQuestion1001.getCorrectAnswer1001(num);
	}





	private  void gameOver (){
		AlertDialog.Builder alertDialogBuilder =new AlertDialog.Builder(JHARKHAND_Quiz.this);
		alertDialogBuilder.setMessage("Game over your score is "+mScore+ " points").setCancelable(false)
				.setPositiveButton("" +
						"New game", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						startActivity(new Intent(getApplicationContext(), MainActivity.class));
					}

				})
				.setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						finish();
					}
				});
		AlertDialog alertDialog= alertDialogBuilder.create();
		alertDialog.show();
	}
}

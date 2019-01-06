package ca.blogspot.sjatyourservice.allaboutjharkhand;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

	TextView  tv2;
	Intent i;
	Random rand = new Random();
	int x = rand.nextInt(12);
	private final int SPLASH_DISPLAY_LENGTH =4000;


    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		//for full Screen  of splash code
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		MobileAds.initialize(this, "ca-app-pub-5278704802151871~2335007935");
// app id remains constant only unit id changes
//ca-app-pub-5278704802151871/3653804946



		tv2 = (TextView) findViewById(R.id.textView2);
		TextView tv_quote_animation = (TextView) findViewById(R.id.tv_quote_animation);

		Animation anim = AnimationUtils.loadAnimation(this, R.anim.move1);
		tv_quote_animation.startAnimation(anim);


		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent shashi=new Intent(MainActivity.this,ABOUT.class);
				MainActivity.this.startActivity(shashi);
				MainActivity.this.finish();
			}
		}, SPLASH_DISPLAY_LENGTH);

		switch (x)
		{
			case 0:
				tv2.setText("When was Jharkhand established?\n" +
						"15 November 2000.");
				break;
			case 1:
				tv2.setText("How many Districts are their in Jharkhand?\n" +
						"\t24 Districts.");
				break;
			case 2:
				tv2.setText("\"Which is the Largest City of Jharkhand?\n" +
						"\t\t- Jamshedpur");
				break;
			case 3:
				tv2.setText("What is the population of this State?\n" +
						"  32,988,134.");
				break;
			case 4:
				tv2.setText("Where is 'Indian Institute of Mines' situated?\n" +
						"   Dhanbad");
				break;
			case 5:
				tv2.setText("Which city of Jharkhand is known as the steel city?\n" +
						" Tata Nagar");
				break;
			case 6:
				tv2.setText("What is the capital of Jharkhand?\n" +
						"Ranchi ");
				break;
			case 7:
				tv2.setText("In which part of Jharkhand is the minimum temperature in winter " +
						"found?\n" +
						"  Neterhat plateau");
				break;
			case 8:
				tv2.setText("In which part of Jharkhand is maximum rainfall being recorded ?\n" +
						 "Neterhat plateau ");
				break;
			case 9:
				tv2.setText("Who is the author of Jharkhand : Castel over Graves?\n" +
						"Victor Das");
				break;
			case 10:
				tv2.setText("Which of the following tribs is famous for truth and to sacrifice all for truth?" +
						"Kharbar");
				break;
			case 11:
				tv2.setText("Who started the famous TISCO factory in Jharkhand? \n" +
						"Jamshedji Tata ");
				break;

		}






	}
}




/**
 * new ad created on 20th nov,17
 * App ID: ca-app-pub-5278704802151871~2335007935
 Ad unit ID: ca-app-pub-5278704802151871/8805449802
 *
 *
 *
 */
/**
 Thread t =new Thread(){
 public void run(){

 try {
 i = new Intent(MainActivity.this,ABOUT.class);
 Thread.sleep(5500);
 startActivity(i);
 } catch (InterruptedException e) {
 startActivity(i);

 }
 }
 };
 t.start();
 **/






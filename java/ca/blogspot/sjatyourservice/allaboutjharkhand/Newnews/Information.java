package ca.blogspot.sjatyourservice.allaboutjharkhand.Newnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;


import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

/**
 * Created by SHASHI on 11-Dec-17.
 */

public class Information extends AppCompatActivity {


	private  String p,q,r;
	ImageLoader imageLoader = new ImageLoader(this);
	public    Listitem listitem;




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.information);

		Intent intent = getIntent();


		if (intent !=null){

			p = intent.getExtras().getString("Title");
			q = intent.getExtras().getString("SubTitle");
			r = intent.getExtras().getString("Image");
			Log.d("Purutext", p);
			Log.d("Purutext", q);
			Log.d("Purutext", r);

		}




		TextView t = (TextView) findViewById(R.id.title);
		TextView u = (TextView) findViewById(R.id.subtitle);
		t.setText(p);
		u.setText(q);

		ImageView image = (ImageView) findViewById(R.id.imageview);

		//Loading Image from URL
		Picasso.with(this).load(r).into(image);


	}
}

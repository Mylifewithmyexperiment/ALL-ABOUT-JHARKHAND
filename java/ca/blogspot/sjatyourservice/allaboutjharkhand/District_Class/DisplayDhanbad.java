package ca.blogspot.sjatyourservice.allaboutjharkhand.District_Class;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

/**
 * Created by SHASHI on 03-Nov-17.
 */

public class DisplayDhanbad extends AppCompatActivity  {


	GridView lv2;
	Toolbar toolbar;

	String[] data = { "Headquarter\t- Dhanbad",
					  "Formation\t- 1956",
					  "Area\t- 2,40sq.km",
					  "Total Population\t-26,84,487 ",
					  "Sex Ratio\t- 909",
					  "Total Literacy\t-74.52 %",
					  "Population Density\t-1,316",
					  "Tourist places \t-Maithan Dam, Panchet, Topchanchi Lake   "};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_dhanbad);
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		lv2 = (GridView) findViewById(R.id.lv2);
		MyAdapter adapter = new MyAdapter(this,data);
		lv2.setAdapter(adapter);
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

				localIntent.putExtra("android.intent.extra.SUBJECT", "ALL ABOUT JHARKHAND");
				localIntent.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=ca.blogspot.sjatyourservice.allaboutjharkhand&hl=en");
				startActivity(Intent.createChooser(localIntent, "Share ALL ABOUT JHARKHAND "));
				break;

			case R.id.item2:
				Intent localIntent1 = new Intent("android.intent.action.VIEW");
				localIntent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=ca.blogspot.sjatyourservice.allaboutjharkhand&hl=en"));
				startActivity(localIntent1);
				break;

			case R.id.item3:
				Toast.makeText(this,"About Developer Clicked",Toast.LENGTH_SHORT).show();
				break;

			case R.id.item4:
				Toast.makeText(this,"About App Clicked",Toast.LENGTH_SHORT).show();
				break;

			case R.id.item5:
				finishAffinity();
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	class MyAdapter extends ArrayAdapter {
		String[] titleArray;

		public MyAdapter(Context c, String[] sem1) {
			super(c, R.layout.list1, R.id.textView, sem1);
			this.titleArray = sem1;
		}

		@NonNull
		@Override
		public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = inflater.inflate(R.layout.list1, parent, false);
			TextView tv = (TextView) v.findViewById(R.id.textView);
			tv.setText(titleArray[position]);
			return v;

		}
	}
}
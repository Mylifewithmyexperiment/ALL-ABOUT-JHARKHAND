package ca.blogspot.sjatyourservice.allaboutjharkhand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SHASHI on 27-Nov-17.
 */

public class GridAdapter extends BaseAdapter {

	private int icons[];
	private String letters[];
	private Context context;
	private LayoutInflater inflater;



	public GridAdapter(Context context, int icons[], String letters[])
	{
		this.context=context;
		this.icons=icons;
		this.letters=letters;

	}

	@Override
	public int getCount() {
		return letters.length;
	}

	@Override
	public Object getItem(int i) {
		return letters[i];
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {

		View gridView1=view;

		if(view ==null )
		{
			inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			gridView1=inflater.inflate(R.layout.menulist1,null);


		}

		//ImageView icon= (ImageView) gridView1.findViewById(R.id.icons);
	///	TextView letter= (TextView) gridView1.findViewById(R.id.letters);


		//icon.setImageResource(icons[i]);
		//letter.setText(letters[i]);

		return gridView1;
	}
}

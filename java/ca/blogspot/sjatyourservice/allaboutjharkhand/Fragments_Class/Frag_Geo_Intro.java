package ca.blogspot.sjatyourservice.allaboutjharkhand.Fragments_Class;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ca.blogspot.sjatyourservice.allaboutjharkhand.R;


public class Frag_Geo_Intro extends Fragment {

	public Frag_Geo_Intro() {
		// Required empty public constructor
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment

		View v = inflater.inflate(R.layout.frag_gen_listview, container, false);


		String[] details={
				"Literary meaning of Jharkhand \t-  Area of Forest  ",
				"Shape  \t - Quadrilateral ",
				" Area    \t- 79,714 km² ",
				"Rular area  \t - 77,922 km² ",
				"Urban area   \t - 1079   km² ",
				"Area wise position in India  \t- 15th  ",
				"Area wise rank of Jharkhand in India   \t-  16th "
				,};


		ListView listViewX= (ListView) v.findViewById(R.id.frag_gen_listview);

		ArrayAdapter<String> abc= new ArrayAdapter<String>(getActivity(),android.R.layout
				.simple_list_item_1,details);
		listViewX.setAdapter(abc);


		return v;

	}


}

package ca.blogspot.sjatyourservice.allaboutjharkhand.Fragments_Class;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

public class Frag_history extends Fragment {

    public Frag_history() {
		// Required empty public constructor
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.frag_gen_listview, container, false);



		String[] details={
				"Literal meaning of Jharkhand  \t -Area of Forest  ",
				"First name of Jharkhand mentioned in \t-   Aitarary Brahaman   ",
				" Name of Jharkhand mentioned in Vayu Purana   \t - Murand  ",
				"Name of Jharkhand in 'Digvijay parb' of Mahabharata \t -  Pundrik Desh  ",
				"Potelmy mentioned the name of Jharkhand as   \t - Mundal ",
				"Chota Nagpur is known in the pre-Medieval Sanskrit Literature as \t - Kalind Desh",
				};


		ListView listViewX= (ListView) v.findViewById(R.id.frag_gen_listview);

		ArrayAdapter<String> abc= new ArrayAdapter<String>(getActivity(),android.R.layout
				.simple_list_item_1,details);
		listViewX.setAdapter(abc);


		return v;

	}

}


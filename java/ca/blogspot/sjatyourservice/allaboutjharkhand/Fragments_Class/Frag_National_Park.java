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


public class Frag_National_Park extends Fragment {


	public Frag_National_Park() {
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


				"National Park \t Location",
				"Belta National Park- \t Latehar  ",
				"Hazaribagh Santuary-  \t Hazaribagh ",
				"Palamau Santuary - \t Latehar ",
				"Mahuatand Santuary- \t  Latehar ",
				"Parasnath Santuary-  \t  Giridih ",
				" Palkot Santuary- \t  Gumla",
				"Dalma Santuary-  \t East Singhbhum ",
				};



		ListView listViewX= (ListView) v.findViewById(R.id.frag_gen_listview);

		ArrayAdapter<String> abc= new ArrayAdapter<String>(getActivity(),android.R.layout
				.simple_list_item_1,details);
		listViewX.setAdapter(abc);


		return v;

	}


}

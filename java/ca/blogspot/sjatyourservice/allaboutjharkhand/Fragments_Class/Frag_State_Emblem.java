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


public class Frag_State_Emblem extends Fragment {


	public Frag_State_Emblem() {
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
				"State Animal-  \t Elephant ",
				"State bird-  \t Koel(Cuckoo)  ",
				"State tree - \t sal  ",
				"State flower-  \t  Palash ",

				"State logo -  \t  Ashok-chakra between four J letters",

				};


		ListView listViewX= (ListView) v.findViewById(R.id.frag_gen_listview);

		ArrayAdapter<String> abc= new ArrayAdapter<String>(getActivity(),android.R.layout
				.simple_list_item_1,details);
		listViewX.setAdapter(abc);


		return v;

	}


}

package ca.blogspot.sjatyourservice.allaboutjharkhand.Fragments_Class;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdView;

import ca.blogspot.sjatyourservice.allaboutjharkhand.R;


public class Frag_rivers extends Fragment {


    public Frag_rivers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      ;



		View v = inflater.inflate(R.layout.frag_gen_listview, container, false);



		String[] details={
				"River name -\t location",
				"Damodar - \t  Latehar district  ",
				" Swanrekha- \t  Negari Ranchi ",
				" Barakar- \t northern Chota Nagpur Plateau   ",
				" South Koyal -\t Chota Nagpur Plateau   ",
				" Panchanan -\t Chota Nagpur Plateau   ",
				 };


		ListView listViewX= (ListView) v.findViewById(R.id.frag_gen_listview);

		ArrayAdapter<String> abc= new ArrayAdapter<String>(getActivity(),android.R.layout
				.simple_list_item_1,details);
		listViewX.setAdapter(abc);


		return v;







    }

}

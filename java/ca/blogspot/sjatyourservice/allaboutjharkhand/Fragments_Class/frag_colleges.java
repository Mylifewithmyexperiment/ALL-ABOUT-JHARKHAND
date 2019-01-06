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


public class frag_colleges extends Fragment {



    public frag_colleges() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.frag_gen_listview, container, false);



		String[] details={
				"Ranchi University- \t1960     ",
				"Sido-Kanhu University- \t 1992    ",
				"Vinoba Bhave University hazaribagh- \t1992   ",
				"Indian schools of mines, Dhanbad- \t 1962     ",
				"Hindi Vidyapith,Deoghar-  \t  19290  ",
				" Xavier labour research Institute (XLRI)-\t  Jamshedpur  ",
				" Xavier Institute of social service (XISS)-\t Ranchi  ",
				"B I T Mesra,Ranchi -\t 1929    ",
				 };



		ListView listViewX= (ListView) v.findViewById(R.id.frag_gen_listview);

		ArrayAdapter<String> abc= new ArrayAdapter<String>(getActivity(),android.R.layout
				.simple_list_item_1,details);
		listViewX.setAdapter(abc);


		return v;

	}

}

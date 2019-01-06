package ca.blogspot.sjatyourservice.allaboutjharkhand.Newnews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ca.blogspot.sjatyourservice.allaboutjharkhand.R;

/**
 * Created by SHASHI on 11-Dec-17.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {


	private List<Listitem>listitems;
	public Context context;
	public    Listitem listitem;



	public Myadapter(List<Listitem>listitems,Context context){

		this.listitems =listitems;
		this.context = context;


	}




	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview,parent,false);
		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, final int position) {


		listitem = listitems.get(position);


		holder.title.setText(listitem.getTitle());
		holder.kumar.setText(listitem.getPk());
		holder.subtitle.setText(listitem.getSubtitle());
		Picasso.with(context).load(listitem.getImage()).into(holder.imageview);

		holder.linearLayout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				listitem = listitems.get(position);

				String p =listitem.getTitle().toString();
				String q =listitem.getSubtitle().toString();
				String r =listitem.getImage().toString();
				Log.d("Perror",p);
				Intent puru = new Intent(context,Information.class);
				puru.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				puru.putExtra("Title", p);
				puru.putExtra("SubTitle",q);
				puru.putExtra("Image",r);
				context.startActivity(puru);

			}
		});

	}

	@Override
	public int getItemCount() {
		return listitems.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		public TextView title,subtitle,kumar;
		public ImageView imageview;
		public LinearLayout linearLayout;


		public ViewHolder(View itemView) {
			super(itemView);


			title = (TextView)itemView.findViewById(R.id.title);
			kumar = (TextView)itemView.findViewById(R.id.kumar);

			subtitle = (TextView)itemView.findViewById(R.id.subtitle);
			imageview = (ImageView) itemView.findViewById(R.id.imageview);
			linearLayout= (LinearLayout)itemView.findViewById(R.id.l1);


		}
	}
}

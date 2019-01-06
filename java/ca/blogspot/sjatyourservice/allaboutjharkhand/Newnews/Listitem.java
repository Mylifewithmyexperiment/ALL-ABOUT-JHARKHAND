package ca.blogspot.sjatyourservice.allaboutjharkhand.Newnews;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SHASHI on 11-Dec-17.
 */

class 	Listitem implements Parcelable {


	private String title;
	private String subtitle;
	private String image;
	private String puru;

	public Listitem(String title, String subtitle, String image,String puru) {
		this.title = title;
		this.subtitle = subtitle;
		this.image= image;
		this.puru = puru;
	}

	protected Listitem(Parcel in) {
		title = in.readString();
		subtitle = in.readString();
		image = in.readString();
		puru = in.readString();
	}

	public static final Creator<Listitem> CREATOR = new Creator<Listitem>() {
		@Override
		public Listitem createFromParcel(Parcel in) {
			return new Listitem(in);
		}

		@Override
		public Listitem[] newArray(int size) {
			return new Listitem[size];
		}
	};

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public String getImage() {
		return image;
	}

	public String getPk(){
		return puru;
	}

	public void setPk(String puru) {
		this.puru = puru;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(title);
		parcel.writeString(subtitle);
		parcel.writeString(image);
		parcel.writeString(puru);
	}

}

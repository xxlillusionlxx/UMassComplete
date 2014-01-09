package com.example.umasscomplete;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BusListingAdapter extends BaseAdapter {
	
	ArrayList<Info> busses = new ArrayList<Info>();
	private LayoutInflater mInflater;

	BusListingAdapter(Context context, ArrayList<Info> results) {
		busses = results;
		mInflater = LayoutInflater.from(context);
	}
	
	public Object getItem(int position) {
		return busses.get(position);
	}
	
	public int getCount(){
		return busses.size();
	}
	
	public long getItemId(int position) {
		return position;
	}
	
	public View getView(int position, View view, ViewGroup vGroup) {
		ViewHolder holder;
		if(view == null) {
			view = mInflater.inflate(R.layout.bus_text, null);
			holder = new ViewHolder();
			holder.name = (TextView) view.findViewById(R.id.bus_item);
			
			view.setTag(holder);
		}
		else {
			holder = (ViewHolder) view.getTag();
		}
		
		holder.name.setText(busses.get(position).getName());
		
		return view;
	}
	
	
	static class ViewHolder {
		TextView name;
	}

}

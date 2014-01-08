package com.example.gridviewtest;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListingBaseAdapter extends BaseAdapter {
	 private static ArrayList<SearchResults> searchArrayList;
	 private boolean fDelivery = false;
	 private String name = null;
	 private LayoutInflater mInflater;

	 public ListingBaseAdapter(Context context, ArrayList<SearchResults> results) {
	  searchArrayList = results;
	  mInflater = LayoutInflater.from(context);
	 }

	 public int getCount() {
	  return searchArrayList.size();
	 }

	 public Object getItem(int position) {
	  return searchArrayList.get(position);
	 }

	 public long getItemId(int position) {
	  return position;
	 }

	 public View getView(int position, View convertView, ViewGroup parent) {
	  ViewHolder holder;
	  if (convertView == null) {
	   convertView = mInflater.inflate(R.layout.custom_row_view, null);
	   holder = new ViewHolder();
	   holder.txtName = (TextView) convertView.findViewById(R.id.name);
	   holder.txtStoreHours = (TextView) convertView.findViewById(R.id.storeHours);
	   holder.txtStoreHoursTwo = (TextView) convertView.findViewById(R.id.storeHoursTwo);
	   holder.txtPhone = (TextView) convertView.findViewById(R.id.phone);

	   convertView.setTag(holder);
	  } else {
	   holder = (ViewHolder) convertView.getTag();
	  }
	  
	  holder.txtName.setText(searchArrayList.get(position).getName());
	  
	  /**
	   * These if-statement additions and name/fDelivery variable additions
	   * are to check food delivery is what is being set up.
	   * 
	   * If delivery establishments are being loaded in, then fDelivery is set to true
	   * fDelivery set to true allows for a 4th line (An extra TextView with id storeHoursTwo added in the XML)
	   * so all store hours are guaranteed to be within the width of the bluebg images used in the list,
	   * separating each establishment from each other
	   * 
	   */
	  if(name == null) {
		  name = searchArrayList.get(position).getName();
	  }
	  holder.txtStoreHours.setText(searchArrayList.get(position).getStoreHours());
	  if(name.equals("Southest Express")) {
		  if(fDelivery == false) {
			  fDelivery = true;
		  }
	  }
	  
	  if(fDelivery) {
		  holder.txtStoreHoursTwo.setText(searchArrayList.get(position).getStoreHoursTwo());
	  }
	  else {
		  //View view = convertView.findViewById(R.id.storeHoursTwo);
		  holder.txtStoreHoursTwo.setVisibility(holder.txtStoreHoursTwo.GONE);
	  }
	  holder.txtPhone.setText(searchArrayList.get(position).getPhone());

	  return convertView;
	 }

	 static class ViewHolder {
	  TextView txtName;
	  TextView txtStoreHours;
	  TextView txtStoreHoursTwo;
	  TextView txtPhone;
	 }
	}
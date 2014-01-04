package com.example.gridviewtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FoodDelivery extends Fragment {
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.delivery_food, container, false);
        
        ArrayList<SearchResults> searchResults = new ArrayList<SearchResults> ();
		try {
			searchResults = getDeliveryOffering();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        final ListView lv1 = (ListView) rootView.findViewById(R.id.ListView01);
        lv1.setAdapter(new ListingBaseAdapter(container.getContext(), searchResults));
        
        lv1.setOnItemClickListener(new OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
          Object o = lv1.getItemAtPosition(position);
          SearchResults fullObject = (SearchResults)o;
          String hotline = fullObject.getPhone();
          Intent tocall = new Intent(Intent.ACTION_CALL);
          tocall.setData(Uri.parse("tel:"+hotline ));
           startActivity(tocall);
         }  
        });
        
        return rootView;
    }
    
    private ArrayList<SearchResults> getDeliveryOffering() throws IOException {
     ArrayList<SearchResults> results = new ArrayList<SearchResults>();
     InputStream is = this.getResources().openRawResource(R.raw.places);
     BufferedReader d = new BufferedReader(new InputStreamReader(is));
     String x;
     int count = 0;
     SearchResults sr1 = new SearchResults();
     
     while((x = d.readLine()) != null) {
    	 
    	 count++;
    	 
    	 if(count == 1) {
    			 sr1.setName(x);
    	 }
    	 else if(count == 2) {
    			 sr1.setStoreHours(x);
    	 }
    	 else {
    			 sr1.setPhone(x);
    			 results.add(sr1);
    			 sr1 = new SearchResults();
    			 count = 0;
    	 }

     }
     d.close();
     
     return results;
    }
}
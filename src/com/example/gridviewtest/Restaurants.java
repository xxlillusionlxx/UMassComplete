package com.example.gridviewtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class Restaurants extends Fragment {
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.restaurants_layout, container, false);
         
        ArrayList<SearchResults> searchResults = new ArrayList<SearchResults> ();
		try {
			searchResults = getDeliveryOffering();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        final ListView lv1 = (ListView) rootView.findViewById(R.id.ListView02);
        lv1.setAdapter(new ListingBaseAdapterTwo(container.getContext(), searchResults));
        
        lv1.setOnItemClickListener(new OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
          //Object o = lv1.getItemAtPosition(position);
          //SearchResults fullObject = (SearchResults)o;
          //Toast.makeText(lv1.getContext(), "You have chosen: " + " " + fullObject.getName(), Toast.LENGTH_LONG).show();
         }  
        });
        
        return rootView;
    }
    
    private ArrayList<SearchResults> getDeliveryOffering() throws IOException {
     ArrayList<SearchResults> results = new ArrayList<SearchResults>();
     InputStream is = this.getResources().openRawResource(R.raw.restaurants);
     BufferedReader d = new BufferedReader(new InputStreamReader(is));
     String x;
     int count = 0;
     SearchResults sr1 = new SearchResults();;
     
     while((x = d.readLine()) != null) {
    	 count++;
    	 if(x == "") {
    		 continue;
    	 }
    	 else {
    		 if(count == 1)
    			 sr1.setName(x);
    		 else if(count == 2)
    			 sr1.setStoreHours(x);
    		 else
    			 sr1.setPhone(x);
    	 }
    	 
    	 if(count == 3) {
    		 results.add(sr1);
    		 sr1 = new SearchResults();
    		 count = 0;
    	 }

     }
     d.close();
     
     return results;
    }
}
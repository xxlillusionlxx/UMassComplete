package com.example.umasscomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CabDisplay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cab_display);
		ArrayList<SearchResults> searchResults = new ArrayList<SearchResults> ();
		try {
			searchResults = getDeliveryOffering();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        final ListView lv1 = (ListView) findViewById(R.id.ListView03);
        lv1.setAdapter(new ListingBaseAdapter(this, searchResults));
        
        lv1.setOnItemClickListener(new OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
          Object o = lv1.getItemAtPosition(position);
          SearchResults fullObject = (SearchResults)o;
          Toast.makeText(lv1.getContext(), "You have chosen: " + " " + fullObject.getName(), Toast.LENGTH_LONG).show();
         }  
        });
        
    }
    
    private ArrayList<SearchResults> getDeliveryOffering() throws IOException {
     ArrayList<SearchResults> results = new ArrayList<SearchResults>();
     InputStream is = this.getResources().openRawResource(R.raw.cabs);
     BufferedReader d = new BufferedReader(new InputStreamReader(is));
     String x;
     int count = 0;
     SearchResults sr1 = new SearchResults();;
     
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
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cab_display, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    		ExecDialog.runDialog(this);
		
	            return super.onOptionsItemSelected(item);
	    }
}
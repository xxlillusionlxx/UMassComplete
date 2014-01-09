package com.example.umasscomplete;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NightlifeDisplay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nightlife_display);
		
		 ArrayList<SearchResults> searchResults = new ArrayList<SearchResults> ();
			try {
				searchResults = getDeliveryOffering();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        final ListView lv1 = (ListView) findViewById(R.id.ListView4);
	        lv1.setAdapter(new ListingBaseAdapter(this, searchResults));
	        
	        lv1.setOnItemClickListener(new OnItemClickListener() {
	         @Override
	         public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
	        	 Object o = lv1.getItemAtPosition(position);
	        	 SearchResults fullObject = (SearchResults)o;
	          
	        	 System.out.println(fullObject.getName());
	        	 
	          
	         }  
	        });

	    }
	    
	    private ArrayList<SearchResults> getDeliveryOffering() throws IOException {
	    	ArrayList<SearchResults> results = new ArrayList<SearchResults>();
	    	SearchResults sr1 = new SearchResults();
	    	sr1.setName("Stackers");
	    	sr1.setPhone("(413) 253-5141");
	    	sr1.setStoreHours("57 N Pleasant St, Amherst, MA");
	    	results.add(sr1);
	    	
	    	sr1 = new SearchResults();
	    	sr1.setName("McMurphy's");
	    	sr1.setStoreHours("37 N Pleasant St, Amherst, MA");
	    	sr1.setPhone("(413) 253-0170");
	    	results.add(sr1);
	    	
	    	sr1 = new SearchResults();
	    	sr1.setName("High Horse");
	    	sr1.setStoreHours("24 N Pleasant St, Amherst, MA");
	    	sr1.setPhone("413) 230-3034");
	    	results.add(sr1);
	    	
	    	sr1 = new SearchResults();
	    	sr1.setName("Monkey Bar");
	    	sr1.setStoreHours("63 N. Pleasant St., Amherst");
	    	sr1.setPhone("(413) 259-1600");
	    	results.add(sr1);
	    	
	    	sr1 = new SearchResults();
	    	sr1.setName("Rafters");
	    	sr1.setStoreHours("422 Amity St, Amherst, MA");
	    	sr1.setPhone("(413) 549-4040");
	    	results.add(sr1);
	    	
	    	sr1 = new SearchResults();
	    	sr1.setName("Amherst Brewing Company");
	    	sr1.setStoreHours("10 University Drive, Amherst, MA");
	    	sr1.setPhone("(413) 253-4400");
	    	results.add(sr1);
	    	
	    	sr1 = new SearchResults();
	    	sr1.setName("The Spoke");
	    	sr1.setStoreHours("35 E Pleasant St, Amherst, MA");
	    	sr1.setPhone("(413) 549-7140");
	    	results.add(sr1);
	    	
	    	sr1 = new SearchResults();
	    	sr1.setName("Moan and Dove");
	    	sr1.setStoreHours("460 West St, Ste 6, Amherst, MA");
	    	sr1.setPhone("(413) 256-1710");
	    	results.add(sr1);
	     	     
	     return results;
	    }
	    
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.nightlife_display, menu);
			return true;
		}
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    // Handle presses on the action bar items
		    		ExecDialog.runDialog(this);
			
		            return super.onOptionsItemSelected(item);
		    }
	   
}
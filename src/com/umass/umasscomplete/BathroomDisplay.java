package com.umass.umasscomplete;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

public class BathroomDisplay extends Activity {
	
	   // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] location;
    String[] location_two;
    String[] keywords;
    ArrayList<SearchResults> arraylist = new ArrayList<SearchResults>();
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab_display);
 
        // Generate sample data
        location = new String[] { "Campus Center", "Dorm Bathrooms", "Machmer West", "New Africa House", "ISB", "Elab II", "Herter" };
 
        location_two = new String[] { "Basement, behind ATMs", "1st Floor", "Basement",
                "1st and 4th Floors", "All Floors", "All Floors", "Gallery side, near bus stop" };
 
        keywords = new String[] { "Secluded, Clean, Newer", "Clean",
                "Secluded, Clean", "Clean, Newer", "Clean, Newer", "Clean, Newer, Secluded",
                "Secluded, Clean (old though)" };
 
        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.ListView03);
 
        for (int i = 0; i < location.length; i++) 
        {
        	SearchResults wp = new SearchResults();
        	wp.setName(location[i]);
        	wp.setStoreHours(location_two[i]);
        	wp.setPhone(keywords[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }
 
        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);
 
        // Binds the Adapter to the ListView
        list.setAdapter(adapter);
        
    }
 
    // Not using options menu in this tutorial
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    		ExecDialog.runDialog(this);
		
	            return super.onOptionsItemSelected(item);
	    }
}
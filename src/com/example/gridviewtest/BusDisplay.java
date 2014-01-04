package com.example.gridviewtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class BusDisplay extends ListActivity  {

		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bus_list);
		
		TextView t2 = (TextView) findViewById(R.id.bTextId);
	    t2.setMovementMethod(LinkMovementMethod.getInstance());
		
		ArrayList<Info> busInfo = new ArrayList<Info> ();
		try {
			busInfo = getBusListing();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        final ListView lv1 = (ListView) findViewById(android.R.id.list);
        lv1.setAdapter(new BusListingAdapter(this, busInfo));
        
        lv1.setOnItemClickListener(new OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> a, View v, int position, long id) { 

          Intent intent = new Intent(BusDisplay.this, BusScheduleDisplay.class);
          switch(position) {
          case 0:
        	  intent.putExtra("bus", 0); break;
          case 1:
        	  intent.putExtra("bus", 1); break;
          case 2:
        	  intent.putExtra("bus", 2); break;
          case 3:
        	  intent.putExtra("bus", 3); break;
          case 4:
        	  intent.putExtra("bus", 4); break;
          case 5:
        	  intent.putExtra("bus", 5); break;
          case 6:
        	  intent.putExtra("bus", 6); break;
          case 7:
        	  intent.putExtra("bus", 7); break;
          case 8:
        	  intent.putExtra("bus", 8); break;
          case 9:
        	  intent.putExtra("bus", 9); break;
          case 10:
        	  intent.putExtra("bus", 10); break;
          case 11:
        	  intent.putExtra("bus", 11); break;
          case 12:
        	  intent.putExtra("bus", 12); break;
          case 13:
        	  intent.putExtra("bus", 13); break;
          case 14:
        	  intent.putExtra("bus", 14); break;
          }
          startActivity(intent);
         }  
        });
        
    }
	
	public ArrayList<Info> getBusListing() throws IOException {
		ArrayList<Info> results = new ArrayList<Info>();
		
		InputStream is = this.getResources().openRawResource(R.raw.routes);
	     BufferedReader d = new BufferedReader(new InputStreamReader(is));
	     String x;
	     Info sr1 = new Info();;
	     
	while((x = d.readLine()) != null) {
	    	 sr1.setName(x);
	    	 results.add(sr1);
	    	 sr1 = new Info();
	     }
	     d.close();
	     
		return results;
	}
    
}
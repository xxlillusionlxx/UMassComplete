package com.example.gridviewtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	//private Info info;
	private Intent intent;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageAdapter obj = new ImageAdapter(this);
		
		GridView grid = (GridView) findViewById(R.id.gridview);
		grid.setAdapter(obj);
		
	    grid.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {	        	
	        	switch(position) {
	        	case 0:
	        		intent = new Intent(MainActivity.this, DisplayInfo.class);
	        		startActivity(intent);
	        		break;     	
	        	case 1:
	        		intent = new Intent(MainActivity.this, BusDisplay.class);
	        		startActivity(intent);
	        		break;
	        	case 2:
	        		intent = new Intent(MainActivity.this, NightlifeDisplay.class);
	        		startActivity(intent);	
	        		break;
	        	case 3:
	        		intent = new Intent(MainActivity.this, CabDisplay.class);
	        		startActivity(intent);
	        		break;
	        	case 4:
	        		intent = new Intent(MainActivity.this, MailActivity.class);
	        		startActivity(intent);
	        		break;
	        	case 5:
	        		intent = new Intent(MainActivity.this, SpireActivity.class);
	        		startActivity(intent);
	        		break;
	        	case 6:
	        		intent = new Intent(MainActivity.this, MoodleActivity.class);
	        		startActivity(intent);
	        		break;
	        	case 7:
	        		intent = new Intent(MainActivity.this, CampusMapActivity.class);
	        		startActivity(intent);
	        		break;
	        	}
	        	
	        }
	    });
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

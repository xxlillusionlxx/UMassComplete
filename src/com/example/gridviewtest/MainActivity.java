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
	        	if(position == 0) {
	        		//info = new Info(position, id, v.getContext(), "food", v);
	        		intent = new Intent(MainActivity.this, DisplayInfo.class);
	        		//intent.putExtra(EXTRA_MESSAGE, info);
	        		startActivity(intent);
	        	}
	        	else if(position == 1) {
	        		//info = new Info(position, id, v.getContext(), "bus", v);
	        		intent = new Intent(MainActivity.this, BusDisplay.class);
	        		//intent.putExtra(EXTRA_MESSAGE, info);
	        		startActivity(intent);
	        	}
	        	else if(position == 2){
	        		//info = new Info(position, id, v.getContext(), "night", v);
	        		intent = new Intent(MainActivity.this, NightlifeDisplay.class);
	        		//intent.putExtra(EXTRA_MESSAGE, info);
	        		startActivity(intent);	
	        	}
	        	else {
	        		//info = new Info(position, id, v.getContext(), "cab", v);
	        		intent = new Intent(MainActivity.this, CabDisplay.class);
	        		//intent.putExtra(EXTRA_MESSAGE, info);
	        		startActivity(intent);
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

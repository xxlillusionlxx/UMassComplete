package com.example.gridviewtest;

import android.app.Activity;
//import android.content.Intent;
import android.os.Bundle;

public class BarDisplay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/*Intent intent = getIntent();
		Info info = (Info) intent.getSerializableExtra("bam"); */
		
		setContentView(R.layout.stackers);	
	}


}

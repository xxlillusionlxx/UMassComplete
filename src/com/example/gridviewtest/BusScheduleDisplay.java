package com.example.gridviewtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.touch.TouchImageView;

public class BusScheduleDisplay extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TouchImageView tImg = new TouchImageView(this);
		Intent intent = getIntent();
		int id = intent.getIntExtra("bus", 0);
		
		
		switch(id) {
			case 0:
				tImg.setImageResource(R.drawable.g30); break;
			case 1:
				tImg.setImageResource(R.drawable.p31); break;
			case 2:
				tImg.setImageResource(R.drawable.g32); break;
			case 3:
				tImg.setImageResource(R.drawable.b34); break;
			case 4:
				tImg.setImageResource(R.drawable.b35); break;
			case 5:
				tImg.setImageResource(R.drawable.b37); break;
			case 6:
				tImg.setImageResource(R.drawable.o38); break;
			case 7:
				tImg.setImageResource(R.drawable.o39); break;
			case 8:
				tImg.setImageResource(R.drawable.o39e); break;
			case 9:
				tImg.setImageResource(R.drawable.m40); break;
			case 10:
				tImg.setImageResource(R.drawable.b43); break;
			case 11:
				tImg.setImageResource(R.drawable.b43summer); break;
			case 12:
				tImg.setImageResource(R.drawable.g45); break;
			case 13:
				tImg.setImageResource(R.drawable.g46); break;
			case 14:
				tImg.setImageResource(R.drawable.b48); break;
		}
		
		setContentView(tImg);
		
	}
	
}

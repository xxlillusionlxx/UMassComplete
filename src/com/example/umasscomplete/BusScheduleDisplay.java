package com.example.umasscomplete;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.g30, 512, 384));
				break;
			case 1:
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.p31, 512, 384));
				break;
			case 2: 
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.g32, 512, 384));
				break;
			case 3:
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.b34, 512, 384));
				break;
			case 4: 
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.b35, 512, 384));
				break;
			case 5:
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.b37, 512, 384));
				break;
			case 6: 
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.o38, 512, 384));
				break;
			case 7: 
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.o39, 512, 384));
				break;
			case 8: 
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.o39e, 512, 384));
				break;
			case 9: 
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.m40, 512, 384));
				break;
			case 10:
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.b43, 512, 384));
				break;
			case 11:
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.b43summer, 512, 384));
				break;
			case 12:
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.g45, 512, 384));
				break;
			case 13: 
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.g46, 512, 384));
				break;
			case 14: 
				tImg.setImageBitmap( decodeSampledBitmapFromResource(getResources(), R.drawable.b48, 512, 384));	
				break;
				
		} 
		
		setContentView(tImg);
		
	}
	
	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        final int halfHeight = height / 2;
        final int halfWidth = width / 2;

        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
            inSampleSize *= 2;
        }
    }

    return inSampleSize;
}
	
	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);

	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	    
	}
	
	@Override
	public void onDestroy () {
		super.onDestroy();
	}
	
}

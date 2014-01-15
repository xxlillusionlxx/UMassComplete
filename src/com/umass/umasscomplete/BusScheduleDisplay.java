package com.umass.umasscomplete;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.webkit.WebView;

public class BusScheduleDisplay extends Activity {
	String data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		WebView webview = new WebView(this);
		webview.getSettings().setBuiltInZoomControls(true);
		webview.getSettings().setLoadWithOverviewMode(true);
		webview.getSettings().setUseWideViewPort(true);
		
		
		Intent intent = getIntent();
		int id = intent.getIntExtra("bus", 0);
		
		switch(id) {
			case 0:
				data = "<body>" + "<img src=\"g30.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 1:
				data = "<body>" + "<img src=\"p31.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 2: 
				data = "<body>" + "<img src=\"g32.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 3:
				data = "<body>" + "<img src=\"b34.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 4: 
				data = "<body>" + "<img src=\"b35.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 5:
				data = "<body>" + "<img src=\"b37.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 6: 
				data = "<body>" + "<img src=\"o38.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 7:
				data = "<body>" + "<img src=\"o39.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 8: 
				data = "<body>" + "<img src=\"o39e.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 9: 
				data = "<body>" + "<img src=\"m40.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 10:
				data = "<body>" + "<img src=\"b43b.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 11:
				data = "<body>" + "<img src=\"b43summer.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 12:
				String data = "<body>" + "<img src=\"g45.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 13: 
				data = "<body>" + "<img src=\"g46.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
			case 14:
				data = "<body>" + "<img src=\"b48.jpg\"/></body>";
				webview.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);
				break;
				
		} 
		setContentView(webview);
		
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

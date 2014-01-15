package com.umass.umasscomplete;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

public class ExecDialog extends Activity {

	//Context context;
	
	private ExecDialog() {
		
	}
	
	public static void runDialog(Context con) {
		
		final Dialog iDialog = new Dialog(con);
		iDialog.setTitle(R.string.about);
		iDialog.setContentView(R.layout.info_d);
		Button dButton = (Button) iDialog.findViewById(R.id.dialog_button);
		dButton.setOnClickListener( new OnClickListener () {
			
			@Override
			public void onClick(View v) {
				iDialog.dismiss();
			}
			
			
		} );
		
		iDialog.show();
		
	}
	
}

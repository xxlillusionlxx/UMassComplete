package com.example.umasscomplete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
    	View view = convertView;
        ViewHolder vh = new ViewHolder();
        
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	
        	LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        	view = inflater.inflate(R.layout.text_under_img, parent, false);
        	vh.imgV = (ImageView) view.findViewById(R.id.image);
            vh.imgV.setPadding(8, 8, 8, 8);
            vh.txt = (TextView) view.findViewById(R.id.img_text);
            
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        switch(position) {
        case 0:
        	vh.txt.setText("Food"); break;
        case 1: 
        	vh.txt.setText("Bus Schedules"); break;
        case 2: 
        	vh.txt.setText("Night Life"); break;
        case 3:
        	vh.txt.setText("Cabs"); break;
        case 4:
        	vh.txt.setText("UMail"); break;
        case 5:
        	vh.txt.setText("Spire"); break;
        case 6:
        	vh.txt.setText("Moodle"); break;
        case 7:
        	vh.txt.setText("Campus Map"); break;
        }
        
        vh.imgV.setImageResource(mThumbIds[position]);
        return view;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.pizza, R.drawable.bus,
            R.drawable.beer, R.drawable.taxi,
            R.drawable.mail_icon, R.drawable.spire_icon,
            R.drawable.moodle_icon, R.drawable.map_icon
    };
    
    static class ViewHolder {
    	ImageView imgV;
    	TextView txt;
    }
}

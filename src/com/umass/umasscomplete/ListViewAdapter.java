package com.umass.umasscomplete;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
 
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.view.View.OnClickListener;
 
public class ListViewAdapter extends BaseAdapter {
 
    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<SearchResults> worldpopulationlist = null;
    private ArrayList<SearchResults> arraylist;
 
    public ListViewAdapter(Context context, List<SearchResults> worldpopulationlist) {
        mContext = context;
        this.worldpopulationlist = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<SearchResults>();
        this.arraylist.addAll(worldpopulationlist);
    }
 
    public class ViewHolder {
        TextView rank;
        TextView country;
        TextView population;
    }
 
    @Override
    public int getCount() {
        return worldpopulationlist.size();
    }
 
    @Override
    public SearchResults getItem(int position) {
        return worldpopulationlist.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.filter_view, null);
            // Locate the TextViews in listview_item.xml
            holder.rank = (TextView) view.findViewById(R.id.name);
            holder.country = (TextView) view.findViewById(R.id.storeHours);
            holder.population = (TextView) view.findViewById(R.id.phone);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.rank.setText(worldpopulationlist.get(position).getName());
        holder.country.setText(worldpopulationlist.get(position).getStoreHours());
        holder.population.setText(worldpopulationlist.get(position).getPhone());
 
        // Listen for ListView Item Click
       /* view.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, SingleItemView.class);
                // Pass all data rank
                intent.putExtra("rank",(worldpopulationlist.get(position).getRank()));
                // Pass all data country
                intent.putExtra("country",(worldpopulationlist.get(position).getCountry()));
                // Pass all data population
                intent.putExtra("population",(worldpopulationlist.get(position).getPopulation()));
                // Pass all data flag
                // Start SingleItemView Class
                mContext.startActivity(intent);
            }
        });
 
        return view;
    } */
        return view;
    }
 
    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        worldpopulationlist.clear();
        if (charText.length() == 0) {
            worldpopulationlist.addAll(arraylist);
        } 
        else
        {
            for (SearchResults wp : arraylist) 
            {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) 
                {
                    worldpopulationlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
 
}

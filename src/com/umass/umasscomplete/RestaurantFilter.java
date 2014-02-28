package com.umass.umasscomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass. Activities that
 * contain this fragment must implement the
 * {@link RestaurantFilter.OnFragmentInteractionListener} interface to handle
 * interaction events. Use the {@link RestaurantFilter#newInstance} factory
 * method to create an instance of this fragment.
 * 
 */
public class RestaurantFilter extends Fragment {
	
	// Declare Variables
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    ArrayList<SearchResults> arraylist = new ArrayList<SearchResults>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.restaurant_filter, container, false);
		// Generate sample data
       
		try {
			arraylist = getDeliveryOffering();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		  // Locate the ListView in listview_main.xml
        list = (ListView) rootView.findViewById(R.id.listview);
		
        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(container.getContext(), arraylist);
 
        // Binds the Adapter to the ListView
        list.setAdapter(adapter);
        
        // Locate the EditText in listview_main.xml
        editsearch = (EditText) rootView.findViewById(R.id.search);
        
              
        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {
 
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }
 
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                    int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
 
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
                // TODO Auto-generated method stub
            }
        });
        
        return rootView;
    }

	
	 private ArrayList<SearchResults> getDeliveryOffering() throws IOException {
	     ArrayList<SearchResults> results = new ArrayList<SearchResults>();
	     InputStream is = this.getResources().openRawResource(R.raw.restaurants);
	     BufferedReader d = new BufferedReader(new InputStreamReader(is));
	     String x;
	     int count = 0;
	     SearchResults sr1 = new SearchResults();;
	     
	     while((x = d.readLine()) != null) {
	    	 count++;
	    	 if(x == "") {
	    		 continue;
	    	 }
	    	 else {
	    		 if(count == 1)
	    			 sr1.setName(x);
	    		 else if(count == 2)
	    			 sr1.setStoreHours(x);
	    		 else
	    			 sr1.setPhone(x);
	    	 }
	    	 
	    	 if(count == 3) {
	    		 results.add(sr1);
	    		 sr1 = new SearchResults();
	    		 count = 0;
	    	 }

	     }
	     d.close();
	     
	     return results;
	    }
	

}

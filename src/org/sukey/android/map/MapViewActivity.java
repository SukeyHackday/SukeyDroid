package org.sukey.android.map;

import org.sukey.android.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MapViewActivity extends MapActivity {
    /** Called when the activity is first created. */
	@Override
	protected boolean isRouteDisplayed() {
	    return false;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		MapView mapView = (MapView) findViewById(R.id.mapview);
	    mapView.setBuiltInZoomControls(true);
	    Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=http://sukey.org/mapview.kml")); 
	    Uri uri1 = Uri.parse("geo:0,0?q=http://sukey.org/mapview.kml"); //this line works!
	    mapIntent.setData(uri1); 
	    startActivity(Intent.createChooser(mapIntent, "Sukey Live Map")); 	    
	}
}
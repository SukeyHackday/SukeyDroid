package org.sukey.android.map;

import java.util.List;

import org.sukey.android.R;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapViewActivity extends MapActivity {
    /** Called when the activity is first created. */
	@Override
	protected boolean isRouteDisplayed() {
	    return false;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_view);
		MapView mapView = (MapView) findViewById(R.id.mapview);
	    mapView.setBuiltInZoomControls(true);
	    List<Overlay> mapOverlays = mapView.getOverlays();
	    Drawable drawable = this.getResources().getDrawable(R.drawable.icon);
	    
	    MapItemizedOverlay itemizedoverlay = new MapItemizedOverlay(drawable, this);
	    
	    GeoPoint point = new GeoPoint(51530309,-76459);
	    OverlayItem overlayitem = new OverlayItem(point, "Hello London Hackspace!", "How do I turn this thing on?");
	     
	    itemizedoverlay.addOverlay(overlayitem);
	    mapOverlays.add(itemizedoverlay);
	    
	}
}
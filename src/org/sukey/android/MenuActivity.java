package org.sukey.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuActivity extends Activity implements OnClickListener {
	protected ImageButton mCascadeButton;
	protected ImageButton mMapButton;
	protected ImageButton mCompassButton;
	protected ImageButton mReportButton;
	protected ImageButton mSettingsButton;
	protected ImageButton mAboutButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mCascadeButton = (ImageButton)findViewById(R.id.cascade);
		mMapButton = (ImageButton)findViewById(R.id.map);
		mCompassButton = (ImageButton)findViewById(R.id.compass);
		mReportButton = (ImageButton)findViewById(R.id.report);
		mSettingsButton = (ImageButton)findViewById(R.id.settings);
		mAboutButton = (ImageButton)findViewById(R.id.about);
		
		mCascadeButton.setOnClickListener(this);
		mMapButton.setOnClickListener(this);
		mCompassButton.setOnClickListener(this);
		mReportButton.setOnClickListener(this);
		mSettingsButton.setOnClickListener(this);
		mAboutButton.setOnClickListener(this);
		
	}

	public void onClick(View view) {
		if (view == mCascadeButton) {
			Intent intent = new Intent(this, org.sukey.android.cascade.CascadeViewSettingsActivity.class);
			startActivity(intent);
			Toast.makeText(this, R.string.toast_cascade, 500).show();
		}
		
		if (view == mMapButton) {
			Intent intent = new Intent(this, org.sukey.android.map.MapViewActivity.class);
			startActivity(intent);
			Toast.makeText(this, R.string.toast_map, 500).show();
		}
		
		if (view == mCompassButton) {
			Intent intent = new Intent(this, org.sukey.android.compass.CompassViewActivity.class);
			startActivity(intent);
			Toast.makeText(this, R.string.toast_compass, 500).show();
		}
		if (view == mReportButton) {
			Intent intent = new Intent(this, org.sukey.android.report.ReportViewActivity.class);
			startActivity(intent);
			Toast.makeText(this, R.string.toast_report, 500).show();
		}
		if (view == mSettingsButton) {
			Intent intent = new Intent(this, org.sukey.android.settings.SettingsMenuActivity.class);
			startActivity(intent);
			Toast.makeText(this, R.string.toast_settings, 500).show();
		}
		
		if (view == mAboutButton) {
			Intent intent = new Intent(this, org.sukey.android.about.AboutWindowActivity.class);
			startActivity(intent);
			Toast.makeText(this, R.string.toast_about, 500).show();
		}
	}
}

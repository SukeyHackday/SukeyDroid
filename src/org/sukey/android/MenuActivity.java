package org.sukey.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MenuActivity extends Activity implements OnClickListener {
	protected ImageButton mCascadeButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		mCascadeButton = (ImageButton)findViewById(R.id.cascade);
		mCascadeButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if (view == mCascadeButton) {
			Intent intent = new Intent(this, org.sukey.android.cascade.SettingsActivity.class);
			startActivity(intent);
		}
	}

}

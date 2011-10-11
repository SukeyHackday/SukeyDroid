package org.sukey.android.about;

import org.sukey.android.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AboutWindowActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }
    public void support(View view) {
    	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:sukey.org@gmail.com")));
    }

    public void website(View view) {
    	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sukey.org/")));
    }

    public void facebook(View view) {
    	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/sukey.org")));
    }

    public void twitter(View view) {
    	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com/sukeyData")));
    }
}
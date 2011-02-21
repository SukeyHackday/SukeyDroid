package org.sukey.android.cascade;

import org.sukey.android.cascade.helpers.ContactAccessor;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceClickListener;

public class SettingsActivity extends PreferenceActivity implements
		OnPreferenceClickListener {
	Preference mSelectContacts;
	ContactAccessor mContactAccessor = ContactAccessor.getInstance();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefs);

		mSelectContacts = (Preference) findPreference("buddy_list");
		mSelectContacts.setOnPreferenceClickListener(this);
	}

	@Override
	public boolean onPreferenceClick(Preference preference) {
		if (preference == mSelectContacts) {
			startActivity(new Intent(this, SelectContactsActivity.class));
			return true;
		}
		return false;
	}
}
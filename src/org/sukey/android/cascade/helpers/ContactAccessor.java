package org.sukey.android.cascade.helpers;

import java.util.List;

import org.sukey.android.cascade.Contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;

public abstract class ContactAccessor {
	private static ContactAccessor sInstance;

	public static ContactAccessor getInstance() {
		if (sInstance == null) {
			int sdkVersion = Integer.parseInt(Build.VERSION.SDK);
			if (sdkVersion < Build.VERSION_CODES.ECLAIR) {
				sInstance = new ContactAccessorOldApi();
			} else {
				sInstance = new ContactAccessorNewApi();
			}
		}
		return sInstance;
	}

	public abstract Intent getContactPickerIntent();

	public abstract List<Contact> getContactList(Activity activity);
}

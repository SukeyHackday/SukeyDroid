package org.sukey.android.cascade.helpers;

import java.util.ArrayList;
import java.util.List;

import org.sukey.android.cascade.Contact;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.provider.Contacts.People;
//import android.util.Log;

@SuppressWarnings("deprecation")
public class ContactAccessorOldApi extends ContactAccessor {

	@Override
	public Intent getContactPickerIntent() {
		return new Intent(Intent.ACTION_PICK, People.CONTENT_URI);
	}

	@Override
	public List<Contact> getContactList(Activity activity) {
		List<Contact> contacts = new ArrayList<Contact>();
		String query = People.NUMBER + " is not null";;
		Cursor managedCursor = activity
				.managedQuery(People.CONTENT_URI, new String[] { People._ID,
						People.NAME, People.TYPE, People.NUMBER }, query, null,
						People.DEFAULT_SORT_ORDER);
		while (managedCursor.moveToNext()) {
			Contact contact = new Contact(managedCursor.getString(managedCursor
					.getColumnIndexOrThrow(People._ID)),
					managedCursor.getString(managedCursor
							.getColumnIndexOrThrow(People.NAME)), managedCursor
							.getInt(managedCursor
									.getColumnIndexOrThrow(People.TYPE)),
					managedCursor.getString(managedCursor
							.getColumnIndexOrThrow(People.NUMBER)));
			contacts.add(contact);
		}

		return contacts;
	}

}

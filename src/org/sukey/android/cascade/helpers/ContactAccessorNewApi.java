package org.sukey.android.cascade.helpers;

import java.util.ArrayList;
import java.util.List;

import org.sukey.android.cascade.Contact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
//import android.util.Log;

public class ContactAccessorNewApi extends ContactAccessor {

	@Override
	public Intent getContactPickerIntent() {
		return new Intent(Intent.ACTION_PICK, Contacts.CONTENT_URI);
	}

	@Override
	public List<Contact> getContactList(Activity activity) {
		List<Contact> contacts = new ArrayList<Contact>();

		ContentResolver cr = activity.getContentResolver();
		Cursor managedCursor = activity.managedQuery(Contacts.CONTENT_URI,
				null, Contacts.HAS_PHONE_NUMBER + " = 1", null,
				Contacts.DISPLAY_NAME);
		while (managedCursor.moveToNext()) {
			String id = managedCursor.getString(managedCursor
					.getColumnIndex(Contacts._ID));
			String name = managedCursor.getString(managedCursor
					.getColumnIndex(Contacts.DISPLAY_NAME));
			Cursor pCur = cr.query(
					ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
					ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
					new String[] { id }, null);
			while (pCur.moveToNext()) {
				String number = pCur
						.getString(pCur
								.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				int type = pCur
						.getInt(pCur
								.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));

				Contact contact = new Contact(id, name, type, number);
				contacts.add(contact);
			}
			pCur.close();
		}
		managedCursor.close();

		return contacts;
	}
}

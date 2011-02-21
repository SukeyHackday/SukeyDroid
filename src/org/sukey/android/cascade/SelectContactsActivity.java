package org.sukey.android.cascade;

import java.util.List;

import org.sukey.android.cascade.helpers.ContactAccessor;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class SelectContactsActivity extends ListActivity {
	ContactAccessor mContactAccessor = ContactAccessor.getInstance();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		populateContactsLayout();
	}

	/** 
	 * 
	 */
	private void populateContactsLayout() {
		ListView listView = getListView();
		listView.setItemsCanFocus(false);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setTextFilterEnabled(true);
		queryContacts();
	}

	/**
	 * Utility method for querying contacts and displaying them
	 * 
	 * @param nameClause
	 */
	private void queryContacts() {
		List<Contact> contacts = mContactAccessor.getContactList(this);
		ArrayAdapter<Contact> arrayAdapter = new ContactItemArrayAdapter(this,
				R.layout.select_contacts, contacts);
		setListAdapter(arrayAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Contact contact = (Contact) l.getItemAtPosition(position);
		CheckBox checkBox = (CheckBox) v.findViewById(R.id.selected);
		Log.e("SelectContacts", checkBox.getTag().toString());
		checkBox.setChecked(!checkBox.isChecked());
		Log.e("SelectContacts", "contact with name " + contact.getName()
				+ " and position " + position + " was clicked");
	}

	private static class ContactItemArrayAdapter extends ArrayAdapter<Contact> {
		private final int resource;

		/**
		 * 
		 * @param context
		 * @param resource
		 * @param textViewResourceId
		 * @param objects
		 */
		public ContactItemArrayAdapter(Context context, int resource,
				int textViewResourceId, List<Contact> objects) {
			super(context, resource, textViewResourceId, objects);
			this.resource = resource;
		}

		/**
		 * 
		 * @param context
		 * @param textViewResourceId
		 * @param objects
		 */
		public ContactItemArrayAdapter(Context context, int textViewResourceId,
				List<Contact> objects) {
			super(context, textViewResourceId, objects);
			this.resource = textViewResourceId;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			if (view == null)
				view = View.inflate(getContext(), resource, null);
			Contact contact = (Contact) getItem(position);
			TextView nameView = (TextView) view.findViewById(R.id.name);
			nameView.setText(contact.getName());
			TextView labelView = (TextView) view.findViewById(R.id.label);
			labelView.setText(contact.getLabel() + ":");
			TextView numberView = (TextView) view.findViewById(R.id.number);
			numberView.setText(contact.getNumber());
			CheckBox checkBox = (CheckBox) view.findViewById(R.id.selected);
			checkBox.setTag(contact.getId());
			return view;
		}
	}
}
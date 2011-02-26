package org.sukey.android.cascade;

import android.content.res.Resources;
import android.provider.ContactsContract;

public final class Contact {
	protected String mId;
	protected int mType;
	protected String mName;
	protected String mNumber;
	protected boolean mSelected;

	public Contact(String id, String name, int type, String number) {
		this(id, name, type, number, false);
	}

	public Contact(String id, String name, int type, String number,
			boolean selected) {
		mId = id;
		mName = name;
		mType = type;
		mNumber = number;
		mSelected = selected;
	}

	public boolean getSelected() {
		return mSelected;
	}

	public void setSelected(boolean selected) {
		mSelected = selected;
	}

	public String getId() {
		return mId;
	}

	public void setId(String id) {
		mId = id;
	}

	public String getLabel() {
		return Resources.getSystem().getString(
				ContactsContract.CommonDataKinds.Phone
						.getTypeLabelResource(mType));
	}

	public int getType() {
		return mType;
	}

	public void setType(int type) {
		mType = type;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public String getNumber() {
		return mNumber;
	}

	public void setNumber(String number) {
		mNumber = number;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[Contact: ").append(mId).append(", \"").append(mName)
				.append("\", ").append(mType).append(", ").append(mNumber)
				.append("]");
		return sb.toString();
	}
}

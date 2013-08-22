package com.emilsjolander.components.stickylistheaders.test;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.emilsjolander.components.stickylistheaders.StickyListHeadersAdapter;

/**
 * @author Emil Sjölander
 */
public class TestBaseAdapter extends BaseAdapter implements
		StickyListHeadersAdapter {

	private String[] countries;
	private LayoutInflater inflater;
	private Context context;

	public TestBaseAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(context);
		countries = context.getResources().getStringArray(R.array.countries);
	}


	@Override
	public int getCount() {
		return countries.length;
	}

	@Override
	public Object getItem(int position) {
		return countries[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.test_list_item_layout,
					parent, false);
			holder.text = (TextView) convertView.findViewById(R.id.text);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.text.setText(countries[position]);

		return convertView;
	}

	@Override
	public View getHeaderView(int position, View convertView, ViewGroup parent) {
		HeaderViewHolder holder;
		if (convertView == null) {
			holder = new HeaderViewHolder();
			convertView = inflater.inflate(R.layout.header, parent, false);
			holder.text1 = (TextView) convertView.findViewById(R.id.text1);
			convertView.setTag(holder);
		} else {
			holder = (HeaderViewHolder) convertView.getTag();
		}
		holder.text1.setText("1");
		return convertView;
	}

	// remember that these have to be static, postion=1 should walys return the
	// same Id that is.
	@Override
	public long getHeaderId(int position) {
		// return the first character of the country as ID because this is what
		// headers are based upon
		return countries[1].subSequence(0, 1).charAt(0);
	}

	class HeaderViewHolder {
		TextView text1;
	}

	class ViewHolder {
		TextView text;
	}

}

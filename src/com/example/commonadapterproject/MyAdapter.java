package com.example.commonadapterproject;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	
	private Context mContext;
	List<Bean> datas;
	public MyAdapter(Context context) {
		mContext = context;
	}
	
	public void setData(List<Bean> datas) {
		this.datas = datas;
	}
	
	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(mContext);
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.list_item, parent, false);
			holder = new ViewHolder();
			holder.titleView = (TextView)convertView.findViewById(R.id.title);
			holder.descView = (TextView)convertView.findViewById(R.id.desc);
			holder.timeView = (TextView)convertView.findViewById(R.id.time);
			holder.phoneView = (TextView)convertView.findViewById(R.id.phone);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder)convertView.getTag();
		}
		Bean bean = (Bean)getItem(position);
		holder.titleView.setText(bean.getTitle());
		holder.descView.setText(bean.getDesc());
		holder.timeView.setText(bean.getTime());
		holder.phoneView.setText(bean.getPhone());
		return convertView;
	}
	static class ViewHolder {
		TextView titleView;
		TextView descView;
		TextView timeView;
		TextView phoneView;
	}

}

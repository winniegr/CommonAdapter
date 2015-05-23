package com.example.commonadapterproject;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommonAdapter<T> extends BaseAdapter {
	Context mContext;
	List<T>datas;
	private int resId;
	
	public CommonAdapter(Context context, int resId) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
		this.resId = resId;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public T getItem(int position) {
		// TODO Auto-generated method stub
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = ViewHolder.getViewHolder(mContext, resId, position, convertView, parent);
		T data = getItem(position);
		convert(holder, data);
		return holder.getConvertView();
	}
	public abstract void convert(ViewHolder holder, T data);
}

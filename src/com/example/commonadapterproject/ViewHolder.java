package com.example.commonadapterproject;

import java.util.List;

import android.R.integer;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewHolder {
	private SparseArray<View> viewMap;
	private View convertView;
	private int position;

	public ViewHolder(Context context, int layoutId, int position,
			ViewGroup parent) {
		// TODO Auto-generated constructor stub
		this.position = position;
		viewMap = new SparseArray<>();
		convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
		convertView.setTag(this);
	}

	public static ViewHolder getViewHolder(Context context, int layoutId,
			int position, View convertView, ViewGroup parent) {
		
		if (convertView != null) {
			ViewHolder holder = (ViewHolder)convertView.getTag();
			holder.setPostion(position);
			return holder;
		}
		else {
			ViewHolder holder= new ViewHolder(context, layoutId, position, parent);
			return holder;
		}
	}

	public View getView(int id) {
		View view = viewMap.get(id);
		if (view == null) {
			view = convertView.findViewById(id);
			viewMap.append(id, view);
		}
		return view;
	}
	public View getConvertView() {
		return convertView;
	}
	public ViewHolder setText(int resId, String text){
		((TextView)getView(resId)).setText(text);
		return this;
	}
	public int getPostion() {
		return position;
	}
	public void setPostion(int positon) {
		this.position = positon;
	}
}

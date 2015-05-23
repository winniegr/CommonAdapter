package com.example.commonadapterproject;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView list = (ListView) findViewById(R.id.list);
		List<Bean> datas = new ArrayList<>();
		datas.add(new Bean("标题1", "犬夜叉犬夜叉犬夜叉犬夜叉犬夜叉犬夜叉犬夜叉犬夜叉", "2015-4-18",
				"10086"));
		datas.add(new Bean("标题2", "樱桃小丸子樱桃小丸子樱桃小丸子樱桃小丸子樱桃小丸子", "2015-4-18",
				"10086"));
		datas.add(new Bean("标题3", "夏目友人帐夏目友人帐夏目友人帐夏目友人帐夏目友人帐", "2015-4-18",
				"10086"));
		datas.add(new Bean("标题4", "网球王子网球王子网球王子网球王子网球王子网球王子", "2015-4-18",
				"10086"));
		datas.add(new Bean("标题5", "蜡笔小新蜡笔小新蜡笔小新蜡笔小新蜡笔小新蜡笔小新", "2015-4-18",
				"10086"));
		datas.add(new Bean("标题6", "叮当猫叮当猫叮当猫叮当猫叮当猫叮当猫叮当猫叮当猫", "2015-4-18",
				"10086"));
		datas.add(new Bean("标题7", "海贼王海贼王海贼王海贼王海贼王海贼王海贼王海贼王", "2015-4-18",
				"10086"));
		datas.add(new Bean("标题8", "灌篮高手灌篮高手灌篮高手灌篮高手灌篮高手灌篮高手", "2015-4-18",
				"10086"));
		datas.add(new Bean("标题9", "名侦探柯南名侦探柯南名侦探柯南名侦探柯南名侦探柯南", "2015-4-18",
				"10086"));
		// MyAdapter adapter = new MyAdapter(this);
		CommonAdapter<Bean> adapter = new CommonAdapter<Bean>(this, R.layout.list_item) {
			
			private List<Integer> positions = new ArrayList<Integer>();

			@Override
			public void convert(final ViewHolder holder, final Bean data) {
				// TODO Auto-generated method stub
				holder.setText(R.id.title, data.getTitle())
						.setText(R.id.desc, data.getDesc())
						.setText(R.id.time, data.getTime())
						.setText(R.id.phone, data.getPhone());
				final CheckBox cb = ((CheckBox)holder.getView(R.id.check));
				cb.setChecked(positions.contains(holder.getPostion()));
				cb.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if (cb.isChecked()) {
							positions.add(holder.getPostion());
						} else {
							positions.remove(((Integer)holder.getPostion()));
						}
					}
				});
				

			}
		};
		adapter.setDatas(datas);
		list.setAdapter(adapter);
	}

}

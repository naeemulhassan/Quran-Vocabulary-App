package com.quranicwords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

public class LearnQuizFragment extends Fragment {

	private Cursor cursor;
	private int word_per_level = 150;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		try {
			ModifyDatabase.createDatabaseIfNotExists(this.getActivity());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cursor = ModifyDatabase.getResult();

		View view = inflater.inflate(R.layout.learnquiz_layout, container,
				false);

		Button level_1 = (Button) view.findViewById(R.id.level_1);
		Button level_2 = (Button) view.findViewById(R.id.level_2);
		Button level_3 = (Button) view.findViewById(R.id.level_3);
		Button level_4 = (Button) view.findViewById(R.id.level_4);
		Button level_5 = (Button) view.findViewById(R.id.level_5);
		Button level_6 = (Button) view.findViewById(R.id.level_6);
		Button level_7 = (Button) view.findViewById(R.id.level_7);
		Button level_8 = (Button) view.findViewById(R.id.level_8);
		Button level_9 = (Button) view.findViewById(R.id.level_9);
		Button level_10 = (Button) view.findViewById(R.id.level_10);

		ArrayList<Button> buttons = new ArrayList<Button>();
		buttons.add(level_1);
		buttons.add(level_2);
		buttons.add(level_3);
		buttons.add(level_4);
		buttons.add(level_5);
		buttons.add(level_6);
		buttons.add(level_7);
		buttons.add(level_8);
		buttons.add(level_9);
		buttons.add(level_10);
		
		final List<String> index  = new ArrayList<String>();
		final List<Integer> results  = new ArrayList<Integer>();		

		cursor.moveToFirst();
		for (int j = 0; j < 10; j++) {			
			int correct = 0;
			for (int i = 0; i < word_per_level; i++) {
				correct = cursor.getInt(2) == 1 ? correct++ : correct;
				index.add(cursor.getString(1));
				results.add(cursor.getInt(2));
				cursor.moveToNext();
			}
			if (correct == 0)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.zero));
			else if (correct < 10)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.one));
			else if (correct < 20)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.two));
			else if (correct < 30)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.three));
			else if (correct < 40)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.four));
			else if (correct < 50)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.five));
			else if (correct < 60)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.six));
			else if (correct < 70)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.seven));
			else if (correct < 80)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.eight));
			else if (correct < 90)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.nine));
			else if (correct < 100)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.ten));
			else if (correct < 110)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.eleven));
			else if (correct < 120)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.twelve));
			else if (correct < 130)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.thirteen));
			else if (correct < 140)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.fourteen));
			else if (correct < 150)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.fifteen));
		}
		
		level_1.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), SetLayout.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(0, 150)));
				i.putIntegerArrayListExtra("results", new ArrayList<Integer>( results.subList(0, 150)));
				startActivity(i);				
			}
		});
		
		level_2.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), SetLayout.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(150, 300)));
				i.putIntegerArrayListExtra("results", new ArrayList<Integer>( results.subList(150, 300)));
				startActivity(i);				
			}
		});
		
		level_3.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), SetLayout.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(300, 450)));
				i.putIntegerArrayListExtra("results", new ArrayList<Integer>( results.subList(300, 450)));
				startActivity(i);				
			}
		});
		
		level_4.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), SetLayout.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(450, 600)));
				i.putIntegerArrayListExtra("results", new ArrayList<Integer>( results.subList(450, 600)));
				startActivity(i);				
			}
		});
		
		level_5.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), SetLayout.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(600, 750)));
				i.putIntegerArrayListExtra("results", new ArrayList<Integer>( results.subList(600, 750)));
				startActivity(i);				
			}
		});
		
		level_6.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), SetLayout.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(750, 900)));
				i.putIntegerArrayListExtra("results", new ArrayList<Integer>( results.subList(750, 900)));
				startActivity(i);				
			}
		});
		
		level_7.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), SetLayout.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(900, 1050)));
				i.putIntegerArrayListExtra("results", new ArrayList<Integer>( results.subList(900, 1050)));
				startActivity(i);				
			}
		});
		
		level_8.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), SetLayout.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(1050, 1200)));
				i.putIntegerArrayListExtra("results", new ArrayList<Integer>( results.subList(1050, 1200)));
				startActivity(i);				
			}
		});
		
		level_9.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), SetLayout.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(1200, 1350)));
				i.putIntegerArrayListExtra("results", new ArrayList<Integer>( results.subList(1200, 1350)));
				startActivity(i);				
			}
		});
		
		level_10.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), SetLayout.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(1350, 1500)));
				i.putIntegerArrayListExtra("results", new ArrayList<Integer>( results.subList(1350, 1500)));
				startActivity(i);				
			}
		});

		return view;
	}
}

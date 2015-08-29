package com.quranicwords;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SetLayout extends Activity{
	private int word_per_set = 15;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_layout);
		final List<String> index = getIntent().getStringArrayListExtra("index");
		ArrayList<Integer> results = getIntent().getIntegerArrayListExtra("results");
		
		Button set_1 = (Button) findViewById(R.id.set_1);
		Button set_2 = (Button) findViewById(R.id.set_2);
		Button set_3 = (Button) findViewById(R.id.set_3);
		Button set_4 = (Button) findViewById(R.id.set_4);
		Button set_5 = (Button) findViewById(R.id.set_5);
		Button set_6 = (Button) findViewById(R.id.set_6);
		Button set_7 = (Button) findViewById(R.id.set_7);
		Button set_8 = (Button) findViewById(R.id.set_8);
		Button set_9 = (Button) findViewById(R.id.set_9);
		Button set_10 = (Button) findViewById(R.id.set_10);

		ArrayList<Button> buttons = new ArrayList<Button>();
		buttons.add(set_1);
		buttons.add(set_2);
		buttons.add(set_3);
		buttons.add(set_4);
		buttons.add(set_5);
		buttons.add(set_6);
		buttons.add(set_7);
		buttons.add(set_8);
		buttons.add(set_9);
		buttons.add(set_10);

		for (int j = 0, k = 0; j < 10; j++) {
			int correct = 0;
			for (int i = 0; i < word_per_set; i++) {
				correct = results.get(k++) == 1 ? correct++ : correct;
			}
			
			if (correct == 0)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.zero));
			else if (correct < 1)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.one));
			else if (correct < 2)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.two));
			else if (correct < 3)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.three));
			else if (correct < 4)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.four));
			else if (correct < 5)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.five));
			else if (correct < 6)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.six));
			else if (correct < 7)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.seven));
			else if (correct < 8)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.eight));
			else if (correct < 9)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.nine));
			else if (correct < 10)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.ten));
			else if (correct < 11)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.eleven));
			else if (correct < 12)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.twelve));
			else if (correct < 13)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.thirteen));
			else if (correct < 14)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.fourteen));
			else if (correct < 15)
				buttons.get(j).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.fifteen));
		}
		
		set_1.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), Learn.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(0, 15)));
				startActivity(i);				
			}
		});
		
		set_2.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), Learn.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(15, 30)));
				startActivity(i);				
			}
		});
		
		set_3.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), Learn.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(30, 45)));
				startActivity(i);				
			}
		});
		
		set_4.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), Learn.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(45, 60)));
				startActivity(i);				
			}
		});
		
		set_5.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), Learn.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(60, 75)));
				startActivity(i);				
			}
		});
		
		set_6.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), Learn.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(75, 90)));
				startActivity(i);				
			}
		});
		
		set_7.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), Learn.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(90, 105)));
				startActivity(i);				
			}
		});
		
		set_8.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), Learn.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(105, 120)));
				startActivity(i);				
			}
		});
		
		set_9.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), Learn.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(120, 135)));
				startActivity(i);				
			}
		});
		
		set_10.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), Learn.class);
				i.putStringArrayListExtra("index", new ArrayList<String>( index.subList(135, 150)));
				startActivity(i);				
			}
		});

	}

}

package com.quranicwords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Learn extends Activity {
	
	private Cursor cursor;
	private MySimpleCursorAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_layout);
		
		ArrayList<String> index_string = getIntent().getStringArrayListExtra("index");
		final ArrayList<Integer> index = new ArrayList<Integer>();
		
		for(int i = 0; i < index_string.size(); i++)
		{
			index.add(Integer.parseInt(index_string.get(i)));
		}
		
		Collections.sort(index);
		
		
		try {
			ModifyDatabase.createDatabaseIfNotExists(getBaseContext());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cursor = ModifyDatabase.getSet(index);
		String[] columns = { ModifyDatabase.COLUMN_ARABIC_FORM,
				ModifyDatabase.COLUMN_ENGLISH_FORM };
		adapter = new MySimpleCursorAdapter(getBaseContext(),
				R.layout.list_item, cursor, columns, new int[] {
						R.id.arabic_form, R.id.english_form }, 0);
		
		ListView listview = (ListView) findViewById(R.id.setlist);
		listview.setAdapter(adapter);
		listview.setScrollbarFadingEnabled(false);
		
		listview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent i = new Intent(getBaseContext(), ItemDetail.class);
				System.out.println("Inside ListClick: " + position + " " + index.get(position));
				i.putExtra("position", index.get(position)-1);
				startActivity(i);
			}
		});
		
		Button start_quiz = (Button) findViewById(R.id.start_quiz);
		
		start_quiz.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), Quiz.class);
				i.p
				startActivity(i);
			}
		});
	}
}

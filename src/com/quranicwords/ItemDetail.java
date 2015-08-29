package com.quranicwords;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetail extends Activity {
	public Cursor cursor;
	public GridView gridview;
	public TextView textview;
	public TextView textview2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_detail);
		int position = getIntent().getExtras().getInt("position");
		System.out.println("inside ItemDetail: " + position);

		Cursor item_cursor = ModifyDatabase.getDetail(position);
		item_cursor.moveToFirst();

		textview = (TextView) findViewById(R.id.item_detail);
		textview.setText("Arabic Form: "
				+ item_cursor.getString(item_cursor
						.getColumnIndex(ModifyDatabase.COLUMN_ARABIC_FORM))
				+ "\nEnglish Form: "
				+ item_cursor.getString(item_cursor
						.getColumnIndex(ModifyDatabase.COLUMN_ENGLISH_FORM))
				+ "\nArabic Root: "
				+ item_cursor.getString(item_cursor
						.getColumnIndex(ModifyDatabase.COLUMN_ARABIC_ROOT))				
				+ "\nFrequency: "
				+ item_cursor.getString(item_cursor
						.getColumnIndex(ModifyDatabase.COLUMN_FREQUENCY)));

		int chapter = item_cursor.getInt(item_cursor
				.getColumnIndex(ModifyDatabase.COLUMN_CHAPTER));
		int verse = item_cursor.getInt(item_cursor
				.getColumnIndex(ModifyDatabase.COLUMN_VERSE));
		System.out.println(chapter + " " + verse);
		ArrayList location = ModifyDatabase.getText(chapter, verse);
		
		textview2 = (TextView) findViewById(R.id.location);
		textview2.setText("\n\nChapter: " + location.get(0) + "\nVerse No: "
				+ verse + "\n\n" + location.get(1) + "\n\n" + location.get(2));
	}
}

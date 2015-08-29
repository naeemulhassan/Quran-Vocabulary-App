package com.quranicwords;

import java.io.IOException;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView.OnQueryTextListener;

public class WordListFragment extends Fragment {

	public Cursor cursor;
	public View view;
	public MySimpleCursorAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		try {
			ModifyDatabase.createDatabaseIfNotExists(this.getActivity());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cursor = ModifyDatabase.getBasic();
		String[] columns = { ModifyDatabase.COLUMN_ARABIC_FORM,
				ModifyDatabase.COLUMN_ENGLISH_FORM };
		adapter = new MySimpleCursorAdapter(this.getActivity(),
				R.layout.list_item, cursor, columns, new int[] {
						R.id.arabic_form, R.id.english_form }, 0);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater
				.inflate(R.layout.wordlist_layout, container, false);
		ListView listview = (ListView) view.findViewById(R.id.wordlist);

		listview.setAdapter(adapter);
		listview.setScrollbarFadingEnabled(false);

		listview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent i = new Intent(getActivity(), ItemDetail.class);
				i.putExtra("position", position);
				startActivity(i);
			}
		});

		return view;
	}	
}

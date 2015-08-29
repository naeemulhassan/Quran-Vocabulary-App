package com.quranicwords;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost myTabHost;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        myTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        myTabHost.setup(this, getSupportFragmentManager(), R.id.tabcontent);
        myTabHost.addTab(myTabHost.newTabSpec("wordlist").setIndicator("WORD LIST"), WordListFragment.class, null);
        myTabHost.addTab(myTabHost.newTabSpec("learnquiz").setIndicator("LEARN & QUIZ"), LearnQuizFragment.class, null);
        myTabHost.addTab(myTabHost.newTabSpec("bookmark").setIndicator("BOOKMARKS"), BookmarkFragment.class, null);        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    
}

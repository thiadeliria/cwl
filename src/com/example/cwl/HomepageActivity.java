package com.example.cwl;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomepageActivity extends Activity {
	public static Context appContext;
	private Button teacher = null;
	private Button myFavTeacher = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_homepage);
		
		teacher = (Button) findViewById(R.id.teacher_button_1);
		myFavTeacher = (Button) findViewById(R.id.fave_button_1);
		
		// ActionBar is initiated
		ActionBar actionBar = getActionBar();
		
		// Tell the ActionBar we want to use Tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		// Initiating 4 tabs and set text to it (to be replaced by icons + text) for icons use setIcon(R.drawable.image)
		ActionBar.Tab homepageTab = actionBar.newTab().setText("首页");
		ActionBar.Tab profileTab = actionBar.newTab().setText("个人主页");
		ActionBar.Tab notifTab = actionBar.newTab().setText("消息");
		ActionBar.Tab settingsTab = actionBar.newTab().setText("设置");
		
		// create the 4 fragments to display content
		Fragment homepageFragment = new Fragment();
		Fragment profileFragment = new Fragment();
		Fragment notifFragment = new Fragment();
		Fragment settingsFragment = new Fragment();
		
		// set the Tab listener. Now we can listen for clicks
		homepageTab.setTabListener(new ATabListener(homepageFragment));
		profileTab.setTabListener(new ATabListener(profileFragment));
		notifTab.setTabListener(new ATabListener(notifFragment));
		settingsTab.setTabListener(new ATabListener(settingsFragment));
		
		// add the two tabs to the action bar
		actionBar.addTab(homepageTab);
		actionBar.addTab(profileTab);
		actionBar.addTab(notifTab);
		actionBar.addTab(settingsTab);
		
		// Click the button
		teacher.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(HomepageActivity.this, PresentBio.class);
				
				startActivity(intent);
			}
		});
		
		myFavTeacher.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(HomepageActivity.this, PresentBio.class);
				
				startActivity(intent);
			}
		});
	}
}

class ATabListener implements ActionBar.TabListener {
	public Fragment fragment;

	public ATabListener(Fragment fragment) {
		this.fragment = fragment;
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		//ft.replace(R.id.fragment_container, fragment);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.remove(fragment);
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// nothing, but below is a possible text message
		// Toast.makeText(HomepageActivity.appContext, "Reselected!",
		// Toast.LENGTH_LONG).show();
	}
}

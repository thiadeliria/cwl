package com.example.cwl;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	public static Context appContext;

	List<Fragment> frags;
	Fragment homepageFragment, profileFragment, notifFragment, settingsFragment;
	ActionBar actionBar;
	ViewPager vp;

	private boolean isExit = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpager);

		initView();
		
		// ActionBar is initiated
		actionBar = getActionBar();

		// Declaration a ViewPager
		vp = (ViewPager) findViewById(R.id.viewpager);
		
		// Tell the ActionBar we want to use Tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// actionBar.addTab(actionBar.newTab().setText("Ê×Ò³").setTabListener(this));
//		ActionBar.Tab homepageTab = actionBar.newTab().setText(R.string.homePage);
//		ActionBar.Tab profileTab = actionBar.newTab().setText(R.string.personalPage);
//		ActionBar.Tab notifTab = actionBar.newTab().setText(R.string.msgs);
//		ActionBar.Tab settingsTab = actionBar.newTab().setText(R.string.settings);
		ActionBar.Tab homepageTab = actionBar.newTab().setIcon(R.drawable.ic_home);
		ActionBar.Tab profileTab = actionBar.newTab().setIcon(R.drawable.ic_profile);
		ActionBar.Tab notifTab = actionBar.newTab().setIcon(R.drawable.ic_notif);
		ActionBar.Tab settingsTab = actionBar.newTab().setIcon(R.drawable.ic_settings);

		// set the Tab listener. Now we can listen for clicks
		homepageTab.setTabListener(this);
		profileTab.setTabListener(this);
		notifTab.setTabListener(this);
		settingsTab.setTabListener(this);

		// add the tabs to the action bar
		actionBar.addTab(homepageTab);
		actionBar.addTab(profileTab);
		actionBar.addTab(notifTab);
		actionBar.addTab(settingsTab);

		// Set a adapter for ViewPager
		vp.setAdapter(pagerAdapter);
		vp.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}
		});
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exitByDoubleClick();
		}
		return false;
	}

	private void exitByDoubleClick() {
		Timer timer = null;
		if (isExit == false) {
			isExit = true; // Prepare to exit
			Toast.makeText(this, R.string.pressAgain, Toast.LENGTH_LONG).show();
			timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					isExit = false;
				}
			}, 2000);
		} else {
			finish();
			System.exit(0);
		}
	}

	private void initView() {
		frags = new ArrayList<Fragment>();

		// create the 4 fragments to display content
		homepageFragment = new HomepageFragment();
		profileFragment = new ProfileFragment();
		notifFragment = new NotifFragment();
		settingsFragment = new SettingsFragment();

		frags.add(homepageFragment);
		frags.add(profileFragment);
		frags.add(notifFragment);
		frags.add(settingsFragment);

	}

	FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
		@Override
		public Fragment getItem(int position) {
			return frags.get(position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return frags.size();
		}
	};

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		vp.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
	}
}

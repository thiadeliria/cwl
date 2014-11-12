package com.example.cwl;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;

public class MyFavStudsList extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_fave_students);
	}
}

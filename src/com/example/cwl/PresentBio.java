package com.example.cwl;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class PresentBio extends ActionBarActivity {
	private Button addToFav = null;
	private Button submit = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragment_profile_template);
		
		//addToFav = (Button) findViewById(R.id.add_to_favourites);
		//submit = (Button) findViewById(R.id.request_teacher);
		
		// Add to favorites
		addToFav.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(PresentBio.this, R.string.collectSucess, Toast.LENGTH_LONG).show();
			}
		});
		
		// Submit my request
		submit.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(PresentBio.this, R.string.submitSucess, Toast.LENGTH_LONG).show();
			}
		});
	}
}

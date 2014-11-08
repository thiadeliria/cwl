package com.example.cwl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class HomepageFragment extends Fragment {
	View content;
	
	private Button mySchedule = null;
	private Button recTeachers = null;
	private Button myTeachers = null;
	private Button myFavTeachers = null;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		content = inflater.inflate(R.layout.fragment_homepage, null);
		initView();

		return content;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	private void initView() {
		mySchedule = (Button) content.findViewById(R.id.my_schedule);
		recTeachers = (Button) content.findViewById(R.id.recommended_teachers);
		myTeachers = (Button) content.findViewById(R.id.my_teachers);
		myFavTeachers = (Button) content.findViewById(R.id.fave_teachers);
		
		// Click the button
		myTeachers.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), PresentBio.class);

				startActivity(intent);
			}
		});

		myFavTeachers.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), PresentBio.class);

				startActivity(intent);
			}
		});
	}
}

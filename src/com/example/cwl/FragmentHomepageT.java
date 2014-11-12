package com.example.cwl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class FragmentHomepageT extends Fragment {
	View content;
	
	private ImageButton myStudents = null;
	private ImageButton myFavStudents = null;
	
	private Button mySchedule = null;
	private Button myStuds = null;
	private Button myFavStuds = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		content = inflater.inflate(R.layout.fragment_homepage_teacher, null);
		initView();

		return content;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	private void initView() {
		mySchedule = (Button) content.findViewById(R.id.my_schedule);
		myStuds = (Button) content.findViewById(R.id.my_students);
		myFavStuds = (Button) content.findViewById(R.id.my_fave_students);
		
		myStudents = (ImageButton) content.findViewById(R.id.student_button_1);
		myFavStudents = (ImageButton) content.findViewById(R.id.fave_button_1);
		
		// Click the button
		mySchedule.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), MySchedule.class);
				
				startActivity(intent);
			}
		});
		
		myStuds.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), MyStudentsList.class);
				
				startActivity(intent);
			}
		});
		 
		myFavStuds.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), MyFavStudsList.class);
				
				startActivity(intent);
			}
		});
		
		// Click the Image button
		myStudents.setOnClickListener(new ImageButton.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), PresentBioT.class);

				startActivity(intent);
			}
		});

		myFavStudents.setOnClickListener(new ImageButton.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), PresentBioT.class);

				startActivity(intent);
			}
		});
	}
}

package com.example.cwl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomepageFragment extends Fragment {
	View content;
	
	private Button teacher = null;
	private Button myFavTeacher = null;
	
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
		teacher = (Button) content.findViewById(R.id.teacher_button_1);
		myFavTeacher = (Button) content.findViewById(R.id.fave_button_1);
		
		// Click the button
		teacher.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), PresentBio.class);

				startActivity(intent);
			}
		});

		myFavTeacher.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), PresentBio.class);

				startActivity(intent);
			}
		});
	}
}

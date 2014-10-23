package com.example.cwl;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.afragment, container, false);
	}

}
// public View onCreateView(LayoutInflater inflater, ViewGroup container,
// Bundle savedInstanceState) {
// // Inflate layout
// View view = inflater.inflate(R.layout.tab, container, false);
// TextView textview = (TextView) view.findViewById(R.id.tabtextview);
// textview.setText(R.string.One);
// return view;
// }

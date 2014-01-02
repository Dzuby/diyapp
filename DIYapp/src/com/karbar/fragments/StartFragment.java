package com.karbar.fragments;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.karbar.diyapp.R;
import com.karbar.diyapp.utils.Constant;
import com.karbar.diyapp.utils.HorizontalListView;
import com.karbar.diyapp.utils.MenuListViewAdapter;
import com.karbar.service.Execute;

import dbPack.DbMethods;

public class StartFragment extends Fragment{
	
	
	private View mainView;
	private Button button;
	private ListView listView;
	ConditionsFragment conditions;
	private long id;
	DbMethods dbMethods;
	private Intent intent;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
	 mainView = inflater.inflate(R.layout.start_view, container, false);
	 dbMethods = new DbMethods(getActivity());
	 intent = new Intent(getActivity(), Execute.class);
	 
		
	 if(!dbMethods.isServiceRunning()){
			getActivity().startService(intent);
			dbMethods.setServiceRunning(true);
	 }
	 button = (Button)mainView.findViewById(R.id.addNewDiya);
	 button.setOnClickListener(change);
	 listView = (ListView)mainView.findViewById(R.id.diyaList);
	 return mainView;
	 }

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		
		super.onActivityCreated(savedInstanceState);
	}	
	View.OnClickListener change= new OnClickListener() {
	    public void onClick(View v) {
	    	FragmentTransaction ft = getFragmentManager().beginTransaction();
	    	//ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
	    	Bundle bundle = new Bundle();

	    	id = dbMethods.getNewDIYaID();   
	    	
	    	bundle.putLong(Constant.KEY_DIYAID, id );
	    	Log.d("kkams", "Nadaje nowe id dla DIYi: "+ id);
			 conditions = new ConditionsFragment();
			 conditions.setArguments(bundle);
	    	ft.replace(R.id.contentFrag, conditions);

	    	// Start the animated transition.
	    	ft.commit();
	    	/*
	    	 FragmentManager mFragmentManager = getFragmentManager(); 

			 conditions = new ConditionsFragment();

	    	 mFragmentManager.beginTransaction().replace(R.id.contentFrag, conditions).commit();
*/
	    	 
	    }
	};	
	 
}
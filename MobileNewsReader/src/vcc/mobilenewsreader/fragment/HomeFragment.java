package vcc.mobilenewsreader.fragment;

import vcc.mobilenewsreader.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
	
	  
	public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
		super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
		View localView = paramLayoutInflater.inflate(R.layout.layout_main, paramViewGroup, false);
		
		return localView;
	}
}

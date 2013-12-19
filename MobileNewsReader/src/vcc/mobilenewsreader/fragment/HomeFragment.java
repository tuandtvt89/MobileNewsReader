package vcc.mobilenewsreader.fragment;

import vcc.mobilenewsreader.activity.MainActivity;
import vcc.mobilenewsreader.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableRow;

public class HomeFragment extends Fragment {
	
	  private String currentDetailUrl = null;
	  private String currentHomeUrl = null;
	  private ImageButton imbHomePage;
	  public ImageView imvNotifyCache;
	  public boolean isFirstLoad = true;
	  public LinearLayout lilBtnClose;
	  private LinearLayout lilLogoHeader;
	  public Button mBtnComment;
	  public Button mBtnShare;
	  private MainActivity mHostActivity;
	  TableRow.LayoutParams mLayoutParamsAutoFit;
	  public LinearLayout mainMainMenuTab;
	  public LinearLayout mainWebview;
	  public LinearLayout pageDetail;
	  public LinearLayout pageHome;
	  public ProgressBar progressBarDetail;
	  
	public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
		super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
		View localView = paramLayoutInflater.inflate(R.layout.layout_main, paramViewGroup, false);
		
		return localView;
	}
}

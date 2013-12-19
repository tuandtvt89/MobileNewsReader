package vcc.mobilenewsreader.activity;

import vcc.mobilenewsreader.R;
import vcc.mobilenewsreader.fragment.HomeFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends FragmentActivity {
	public HomeFragment mHomeContent;

	@Override
	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		if (paramBundle != null) {
			this.mHomeContent = ((HomeFragment) getSupportFragmentManager()
					.getFragment(paramBundle, "mContent"));
		}
		if (this.mHomeContent == null) {
			this.mHomeContent = new HomeFragment();
		}
		setContentView(R.layout.layout_content_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, this.mHomeContent).commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
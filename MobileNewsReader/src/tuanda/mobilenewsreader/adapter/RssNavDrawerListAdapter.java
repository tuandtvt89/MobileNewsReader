package tuanda.mobilenewsreader.adapter;

import java.util.ArrayList;

import tuanda.mobilenewsreader.R;
import tuanda.mobilenewsreader.model.RssNavDrawerItem;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RssNavDrawerListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<RssNavDrawerItem> rssNavDrawerItems;

	public RssNavDrawerListAdapter(Context context,
			ArrayList<RssNavDrawerItem> navDrawerItems) {
		this.context = context;
		this.rssNavDrawerItems = navDrawerItems;
	}

	@Override
	public int getCount() {
		return rssNavDrawerItems.size();
	}

	@Override
	public Object getItem(int position) {
		return rssNavDrawerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater
					.inflate(R.layout.rss_drawer_list_item, null);
		}

		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
		TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        if(rssNavDrawerItems.get(position).isCheckBox())
        	imgIcon.setImageResource(R.drawable.button_check_on);
        else
        	imgIcon.setImageResource(R.drawable.button_check_off);
        txtTitle.setText(rssNavDrawerItems.get(position).getTitle());
		return convertView;
	}

}

package tuanda.mobilenewsreader.adapter;

import java.util.ArrayList;

import tuanda.mobilenewsreader.R;
import tuanda.mobilenewsreader.helper.ImageLoader;
import tuanda.mobilenewsreader.model.RssItem;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RssLazyAdapter extends BaseAdapter {
	private Activity activity;
	private ArrayList<RssItem> data;
	private static LayoutInflater inflater = null;
	public ImageLoader imageLoader;

	public RssLazyAdapter(Activity a, ArrayList<RssItem> d) {
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		imageLoader = new ImageLoader(activity.getApplicationContext());
	}

	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.rss_list_row, null);

		TextView title = (TextView) vi
				.findViewById(R.id.article_headline_classic); // title
		TextView date = (TextView) vi
				.findViewById(R.id.article_hour_date_classic); // artist name
		TextView description = (TextView) vi
				.findViewById(R.id.article_lead_classic); // duration
		ImageView articleImage = (ImageView) vi
				.findViewById(R.id.article_type_image); // thumb image

		// HashMap<String, String> song = new HashMap<String, String>();
		RssItem song = new RssItem();
		song = data.get(position);

		// Setting all values in listview
		title.setText(song.getTitle());
		date.setText(song.getDate());
		description.setText(song.getDescription());
		imageLoader.DisplayImage(song.getImageUrl(), articleImage);
		return vi;
	}
}

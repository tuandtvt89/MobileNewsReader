package tuanda.mobilenewsreader.fragment;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import tuanda.mobilenewsreader.R;
import tuanda.mobilenewsreader.adapter.RssLazyAdapter;
import tuanda.mobilenewsreader.helper.AlertDialogManager;
import tuanda.mobilenewsreader.helper.XMLParser;
import tuanda.mobilenewsreader.model.RssItem;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class HomeFragment extends Fragment {
	// All static variables
	static final String URL = "http://api.androidhive.info/music/music.xml";
	static final String RSS_URL = "http://ngoisao.net/rss/hau-truong.rss";
	ArrayList<RssItem> rssItemList;
	// Alert dialog manager
	AlertDialogManager alert = new AlertDialogManager();
	// Progress Dialog
	private ProgressDialog pDialog;
	// XML node keys
	public static final String KEY_ITEM = "item"; // parent node
	public static final String KEY_TITLE = "title";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_DATE = "pubDate";
	public static final String KEY_LINK = "link";
	ListView list;
	RssLazyAdapter adapter;

	public HomeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_home, container,
				false);
		list = (ListView) rootView.findViewById(R.id.list);
		rssItemList = new ArrayList<RssItem>();
		// Loading tracks in Background Thread
		new LoadTracks().execute();
		return rootView;
	}

	/**
	 * Background Async Task to Load all tracks under one album
	 * */
	class LoadTracks extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Đang tải ...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		/**
		 * getting tracks json and parsing
		 * */
		protected String doInBackground(String... args) {

			XMLParser parser = new XMLParser();
			String xml = parser.getXmlFromUrl(RSS_URL); // getting XML from URL
			Document doc = parser.getDomElement(xml); // getting DOM element
			NodeList nl = doc.getElementsByTagName("item");
			for (int i = 0; i < nl.getLength(); i++) {
				RssItem item = new RssItem();
				Element e = (Element) nl.item(i);
				item.setTitle(parser.getValue(e, KEY_TITLE));
				Log.d("title: ", "" + parser.getValue(e, KEY_TITLE));
				item.setDate(parser.getValue(e, KEY_DATE));
				Log.d("date: ", "" + parser.getValue(e, KEY_DATE));
				item.setLink(parser.getValue(e, KEY_LINK));
				Log.d("link: ", "" + parser.getValue(e, KEY_LINK));
				Matcher matcherUrl = Pattern.compile("src=\"([^\"]+)").matcher(
						e.getElementsByTagName("description").item(0)
								.getFirstChild().getNodeValue().toString());
				Matcher matcherTitle = Pattern.compile("</br>([^<]*).")
						.matcher(
								e.getElementsByTagName("description").item(0)
										.getFirstChild().getNodeValue()
										.toString());
				while (matcherUrl.find()) {
					Log.d("img url: ", "" + matcherUrl.group(1));
					item.setImageUrl(matcherUrl.group(1));

				}
				while (matcherTitle.find()) {
					Log.d("description: ", "" + matcherTitle.group(1));
					item.setDescription(matcherTitle.group(1));
				}
				rssItemList.add(item);
			}
			Log.d("total", rssItemList.size() + "");
			return null;
		}

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			// dismiss the dialog after getting all tracks
			pDialog.dismiss();
			// updating UI from Background Thread
			getActivity().runOnUiThread(new Runnable() {
				public void run() {
					// Getting adapter by passing xml data ArrayList
					adapter = new RssLazyAdapter(getActivity(), rssItemList);
					list.setAdapter(adapter);

					// Click event for single list row
					list.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> parent,
								View view, int position, long id) {
							Toast.makeText(getActivity(), "Hello",
									Toast.LENGTH_LONG).show();
						}
					});
				}
			});
		}

	}
}

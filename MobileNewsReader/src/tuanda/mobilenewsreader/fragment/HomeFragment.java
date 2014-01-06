package tuanda.mobilenewsreader.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import tuanda.mobilenewsreader.R;
import tuanda.mobilenewsreader.adapter.LazyAdapter;
import tuanda.mobilenewsreader.helper.AlertDialogManager;
import tuanda.mobilenewsreader.helper.XMLParser;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Debug;
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
	ArrayList<HashMap<String, String>> songsList;
	// Alert dialog manager
	AlertDialogManager alert = new AlertDialogManager();
	// Progress Dialog
	private ProgressDialog pDialog;
	// XML node keys
	public static final String KEY_SONG = "song"; // parent node
	public static final String KEY_ID = "id";
	public static final String KEY_TITLE = "title";
	public static final String KEY_ARTIST = "artist";
	public static final String KEY_DURATION = "duration";
	public static final String KEY_THUMB_URL = "thumb_url";
	ListView list;
	LazyAdapter adapter;

	public HomeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_home, container,
				false);
		list = (ListView) rootView.findViewById(R.id.list);
		songsList = new ArrayList<HashMap<String, String>>();
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
			pDialog.setMessage("Loading songs ...");
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
			/*
			 * NodeList nl = doc.getElementsByTagName(KEY_SONG); // looping
			 * through all song nodes <song> for (int i = 0; i < nl.getLength();
			 * i++) { // creating new HashMap HashMap<String, String> map = new
			 * HashMap<String, String>(); Element e = (Element) nl.item(i); //
			 * adding each child node to HashMap key => value map.put(KEY_ID,
			 * parser.getValue(e, KEY_ID)); map.put(KEY_TITLE,
			 * parser.getValue(e, KEY_TITLE)); map.put(KEY_ARTIST,
			 * parser.getValue(e, KEY_ARTIST)); map.put(KEY_DURATION,
			 * parser.getValue(e, KEY_DURATION)); map.put(KEY_THUMB_URL,
			 * parser.getValue(e, KEY_THUMB_URL));
			 * 
			 * // adding HashList to ArrayList songsList.add(map); }
			 */
			NodeList nl = doc.getElementsByTagName("item");
			Log.d("length", nl.getLength() + "");
			for (int i = 0; i < nl.getLength(); i++) {
				Element e = (Element) nl.item(i);
				//Log.d("description", e.getElementsByTagName("description")
					//	.item(0).getFirstChild().getNodeValue().toString());
				Matcher matcher = Pattern.compile("src=\"([^\"]+)")
						.matcher(
								e.getElementsByTagName("description").item(0)
										.getFirstChild().getNodeValue()
										.toString());
				while (matcher.find()) {
					Log.d("img url: ", "" + matcher.group(1));
				}
				// Log.d("description", parser.getValue(e, "description"));
			}
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
					adapter = new LazyAdapter(getActivity(), songsList);
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

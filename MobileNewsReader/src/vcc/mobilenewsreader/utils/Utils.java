package vcc.mobilenewsreader.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {

	public static boolean is3gOrWifiAvaiable(Context paramContext) {
		return (isInternetAvailable(paramContext))
				|| (isWifiAvailable(paramContext));
	}

	private static boolean isInternetAvailable(Context paramContext) {
		NetworkInfo[] arrayOfNetworkInfo = ((ConnectivityManager) paramContext
				.getSystemService("connectivity")).getAllNetworkInfo();
		int i = 0;
		if ((arrayOfNetworkInfo != null) && (arrayOfNetworkInfo.length > 0))
			i = arrayOfNetworkInfo.length;
		for (int j = 0;; j++) {
			if (j >= i)
				return false;
			if (arrayOfNetworkInfo[j].isConnected())
				return true;
		}
	}

	public static boolean isWifiAvailable(Context paramContext) {
		NetworkInfo localNetworkInfo = ((ConnectivityManager) paramContext
				.getSystemService("connectivity")).getNetworkInfo(1);
		return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
	}
}

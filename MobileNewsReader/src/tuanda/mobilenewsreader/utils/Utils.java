package tuanda.mobilenewsreader.utils;

import java.io.InputStream;
import java.io.OutputStream;
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
	public static String getURLContent(int index) {
		String content = null;
		switch (index) {
		case 0:
			content = "hau-truong.rss";
			break;
		case 1:
			content = "the-thao.rss";
			break;
		case 2:
			content = "thoi-cuoc.rss";
			break;
		case 3:
			content = "phong-cach.rss";
			break;
		case 4:
			content = "thu-gian.rss";
			break;
		case 5:
			content = "goc-doc-gia.rss";
			break;
		case 6:
			content = "cuoi-hoi.rss";
			break;
		case 7:
			content = "showbiz-viet.rss";
			break;
		case 8:
			content = "chau-a.rss";
			break;
		case 9:
			content = "hollywood.rss";
			break;
		case 10:
			content = "ben-le.rss";
			break;
		case 11:
			content = "clip.rss";
			break;
		case 12:
			content = "khoe-dep.rss";
			break;
		case 13:
			content = "24h.rss";
			break;
		case 14:
			content = "chuyen-la.rss";
			break;
		case 15:
			content = "hinh-su.rss";
			break;
		case 16:
			content = "thuong-truong.rss";
			break;
		case 17:
			content = "thoi-trang.rss";
			break;
		case 18:
			content = "tam-tinh.rss";
			break;
		case 19:
			content = "lam-dep.rss";
			break;
		case 20:
			content = "trac-nghiem.rss";
			break;
		case 21:
			content = "an-choi.rss";
			break;
		case 22:
			content = "dan-choi.rss";
			break;
		case 23:
			content = "cuoi.rss";
			break;
		case 24:
			content = "game.rss";
			break;
		case 25:
			content = "choi-blog.rss";
			break;
		case 26:
			content = "choi-blog.rss";
			break;
		case 27:
			content = "thi-anh.rss";
			break;
		case 28:
			content = "miss.rss";
			break;
		case 29:
			content = "co-dau.rss";
			break;
		case 30:
			content = "cam-nang.rss";
			break;
		case 31:
			content = "anh-cuoi.rss";
			break;
		case 32:
			content = "chia-se.rss";
			break;
		default:
			break;
		}
		return content;
	}

	public static boolean isWifiAvailable(Context paramContext) {
		NetworkInfo localNetworkInfo = ((ConnectivityManager) paramContext
				.getSystemService("connectivity")).getNetworkInfo(1);
		return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
	}

	public static void CopyStream(InputStream is, OutputStream os) {
		final int buffer_size = 1024;
		try {
			byte[] bytes = new byte[buffer_size];
			for (;;) {
				int count = is.read(bytes, 0, buffer_size);
				if (count == -1)
					break;
				os.write(bytes, 0, count);
			}
		} catch (Exception ex) {
		}
	}
}

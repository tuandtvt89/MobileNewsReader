package vcc.mobilenewsreader.utils;

import vcc.mobilenewsreader.R;

public class Constant {
	public static String APPLICATION_KEY;
	public static String APP_BG_COLOR;
	public static int APP_COUNT_SEPARATOR;
	public static String APP_FACEBOOK_ID;
	public static int APP_LOGO_HOME;
	public static int APP_LOGO_LOADING;
	public static int APP_LOGO_LOGIN;
	public static int APP_MENU_FB_CYCLE = 2131034114;
	public static String CATEGORIES_EXTRA_PARAM_IMAGELINK;
	public static String CATEGORIES_EXTRA_PARAM_LINKURL;
	public static String CMD_CONFIG;
	public static String CMD_DETAIL;
	public static String CMD_LIST_NEWS;
	public static int DIMEN_PADDING_LOGO_TOP;
	public static String DYNAMIC_MENU;
	public static String HOST;
	public static String HOST_API;
	public static int LARGE_WIDTH_SCREEN;
	public static String LINKHAY_CONSUMER_KEY;
	public static String LINKHAY_SECRET_KEY;
	public static String NAME_APP;
	public static int NORMAL_WIDTH_SCREEN;
	public static long ONE_DAY_TO_MILISECOND;
	public static String SHARE_PACKAGE;
	public static String SHARE_PACKAGE_FACEBOOK;
	public static String SHARE_PACKAGE_LINKHAY;
	public static int SMALL_WIDTH_SCREEN;
	public static int TIME_OUT;
	public static String TIME_OUT_STR;
	public static String VIETID_APP_KEY;
	public static String VIETID_CHECK_LOGIN;
	public static String VIETID_CHECK_NEW_SESSION;
	public static String VIETID_CHECK_SESSION;
	public static String VIETID_COMMENT;
	public static String VIETID_HOMEPAGE;
	public static String VIETID_LOGIN;
	public static String VIETID_LOGIN_SUCCESS;
	public static String VIETID_LOGOUT;
	public static int XLARGE_WIDTH_SCREEN;

	static {
		APP_COUNT_SEPARATOR = 4;
		ONE_DAY_TO_MILISECOND = 86400000L;
		LARGE_WIDTH_SCREEN = 640;
		SMALL_WIDTH_SCREEN = 240;
		NORMAL_WIDTH_SCREEN = 480;
		XLARGE_WIDTH_SCREEN = 720;
		TIME_OUT = 20000;
		TIME_OUT_STR = "time-out-error";
		DIMEN_PADDING_LOGO_TOP = 15;
		DYNAMIC_MENU = "http://mobile.todo.vn/api_v2/menu/39.html";
		APP_BG_COLOR = "#fb9600";
		APP_LOGO_HOME = 2130837689;
		APP_LOGO_LOADING = R.drawable.app_splash_kenh14;
		APP_LOGO_LOGIN = 2130837645;
		NAME_APP = "Kenh14";
		HOST = "http://app.kenh14.vn/";
		HOST_API = "http://app.kenh14.vn/api/app.ashx?";
		APPLICATION_KEY = "d9c694bd04eb35d96f1d71a84141d075";
		LINKHAY_CONSUMER_KEY = "017ade79e5d0c8b23512d966d4a323bd";
		LINKHAY_SECRET_KEY = "75171bd1db01aefc2b7e22894c91e30e";
		APP_FACEBOOK_ID = "333775306751616";
		SHARE_PACKAGE = "vcc.mobilenewsreader.kenh14";
		SHARE_PACKAGE_FACEBOOK = "vcc.mobilenewsreader.activity.FacebookShare";
		SHARE_PACKAGE_LINKHAY = "vcc.mobilenewsreader.activity.LinkHayShareScreen";
		VIETID_APP_KEY = "5a5173e2ab6a8a44c5e4367b6f791ad3";
		VIETID_HOMEPAGE = "http://m.vietid.net/OauthMobileV3/Login";
		VIETID_CHECK_SESSION = "http://m.vietid.net/OauthMobile/checkSession";
		VIETID_CHECK_NEW_SESSION = "http://m.vietid.net/Login/Checksession4App?app_key=%s&app=true";
		VIETID_CHECK_LOGIN = "http://m.vietid.net/Login/Checksession4App?email=%s&&app_key=%s&app=true&token=%s";
		VIETID_LOGOUT = "http://m.vietid.net/Login/AppLogout";
		VIETID_LOGIN = "http://m.vietid.net/OauthMobileV3/Login";
		VIETID_LOGIN_SUCCESS = "http://m.vietid.net/OauthMobileV3/successLogin";
		VIETID_COMMENT = "http://m.comment.vietid.net/comments";
		CMD_CONFIG = "sourceinfo2";
		CMD_DETAIL = "detail";
		CMD_LIST_NEWS = "listNews";
		CATEGORIES_EXTRA_PARAM_LINKURL = "vcc.mobile.news.reader.linkurl";
		CATEGORIES_EXTRA_PARAM_IMAGELINK = "vcc.mobile.news.reader.imagelink";
	}
}
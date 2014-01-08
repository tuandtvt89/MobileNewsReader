package tuanda.mobilenewsreader.model;

public class RssNavDrawerItem {
	
	private String title;
	
	private boolean checkBox;
    
	public RssNavDrawerItem(String title, boolean checkBox) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.checkBox = checkBox;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCheckBox() {
		return checkBox;
	}

	public void setCheckBox(boolean checkBox) {
		this.checkBox = checkBox;
	}

}

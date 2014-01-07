package tuanda.mobilenewsreader.model;


public class RssItem {

	private String title;

	private String date;

	private String description;

	private String imageUrl;

	private String link;

	public RssItem() {
		// TODO Auto-generated constructor stub
	}

	public RssItem(String title, String date, String description,
			String imageUrl, String link) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.date = date;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}

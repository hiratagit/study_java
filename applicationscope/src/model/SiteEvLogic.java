package model;

public class SiteEvLogic {

	public void like(SiteEv site) {
		int count = site.getLike();
		site.setLike(count + 1);
	}

	public void disLike(SiteEv site) {
		int count = site.getDislike();
		site.setDislike(count + 1);
	}
}
package model;

public class Reservation {
	private String userId;
	private String productId;
	private String productNm;
	private String makerNm;
	private int price;
	private String imgfileNm;

	public Reservation(String productId, String productNm, String makerNm, int price, String imgfileNm, String userId) {
		this.productId = productId;
		this.productNm = productNm;
		this.makerNm = makerNm;
		this.price = price;
		this.imgfileNm = imgfileNm;
		this.userId = userId;
	}

	public Reservation(String userId, String productId) {
		this.userId = userId;
		this.productId = productId;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getProductId() {
		return this.productId;
	}

	public String getProductNm() {
		return this.productNm;
	}

	public String getMakerNm() {
		return this.makerNm;
	}

	public int getPrice() {
		return this.price;
	}

	public String getImgfileNm() {
		return this.imgfileNm;
	}
}

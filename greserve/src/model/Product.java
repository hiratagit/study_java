package model;

public class Product {
	private String productId;
	private String productNm;
	private String makerNm;
	private int makerId;
	private int price;
	private int reservation;
	private String imgfileNm;

	public Product(String productId, String productNm, String makerNm, int price, int reservation, String imgfileNm) {
		this.productId = productId;
		this.productNm = productNm;
		this.makerNm = makerNm;
		this.price = price;
		this.reservation = reservation;
		this.imgfileNm = imgfileNm;
	}

	public Product(String productId, String productNm, int makerId, int price, int reservation, String imgfileNm) {
		this.productId = productId;
		this.productNm = productNm;
		this.makerId = makerId;
		this.price = price;
		this.reservation = reservation;
		this.imgfileNm = imgfileNm;
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

	public int getMakerId() {
		return this.makerId;
	}

	public int getPrice() {
		return this.price;
	}

	public int getReservation() {
		return this.reservation;
	}

	public String getImgfileNm() {
		return this.imgfileNm;
	}
}
package test;

import java.util.ArrayList;
import java.util.List;

import model.GetAllProductLogic;
import model.GetAllReservationLogic;
import model.GetProductLogic;
import model.GetReservationLogic;
import model.Product;
import model.ProductEditLogic;
import model.ProductRegisterLogic;
import model.Reservation;
import model.SetReservationLogic;

public class ProductDAOTest {

	public static void main(String[] args ){

    //  testGetAllProductLogic();
	//	testGetProductLogic();
	//  testSetReservationLogic();
	//  testGetReservationLogic();
	//  testGetAllReservation();
    //	testProductRegister();
		testProductEdit();

	}

	public static void testGetAllProductLogic() {

		List<Product> productList = new ArrayList<Product>();
		GetAllProductLogic logic = new GetAllProductLogic();

		productList = logic.execute();
		if(productList != null) {

			for(Product product : productList) {
				System.out.println(product.getProductId());
				System.out.println(product.getMakerNm());
				System.out.println(product.getProductNm());
				System.out.println(String.format("%,d", product.getPrice()));
				System.out.println(product.getReservation());
				System.out.println(product.getImgfileNm());
				System.out.println("---------------------------");
			}

		}else {
			System.out.println("失敗しました");
		}
	}

	public static void testGetProductLogic() {

		GetProductLogic logic = new GetProductLogic();
		Product product = logic.execute("G-001");

		if(product != null) {

			System.out.println(product.getProductId());
			System.out.println(product.getMakerNm());
			System.out.println(product.getProductNm());
			System.out.println(String.format("%,d", product.getPrice()));
			System.out.println(product.getReservation());
			System.out.println(product.getImgfileNm());
			System.out.println("---------------------------");


		}else {
			System.out.println("失敗しました");
		}
	}

	public static void testSetReservationLogic() {

		SetReservationLogic logic = new SetReservationLogic();
		Reservation reservaton = new Reservation("hirata", "GR-0001");
		boolean result = logic.execute(reservaton);

		if(result) {
			System.out.println("予約処理が成功しました");
		} else {
			System.out.println("予約処理が失敗しました");
		}
	}

	public static void testGetReservationLogic() {
		List<Product> reserveProductList = new ArrayList<Product>();
		GetReservationLogic logic = new GetReservationLogic();
		reserveProductList = (List<Product>) logic.execute("honoka");

		if(reserveProductList == null || reserveProductList.size() == 0) {
			System.out.println("予約状況を取得出来ませんでした");
		} else {
			for(Product product : reserveProductList) {
				System.out.println("リストの長さは"+ reserveProductList.size());
				System.out.println(product.getProductId());
				System.out.println(product.getMakerNm());
				System.out.println(product.getProductNm());
				System.out.println(String.format("%,d", product.getPrice()));
				System.out.println(product.getReservation());
				System.out.println(product.getImgfileNm());
				System.out.println("---------------------------");
			}
		}
	}

	public static void testGetAllReservation() {
		List<Reservation> reservationList = new ArrayList<>();
		GetAllReservationLogic logic = new GetAllReservationLogic();
		reservationList = logic.execute();

		if(reservationList == null || reservationList.size() == 0) {
			System.out.println("予約状況を取得出来ませんでした");
		} else {
			for(Reservation rv : reservationList) {
				System.out.println("リストの長さは"+ reservationList.size());
				System.out.println(rv.getProductId());
				System.out.println(rv.getProductNm());
				System.out.println(rv.getMakerNm());
				System.out.println(String.format("%,d", rv.getPrice()));
				System.out.println(rv.getImgfileNm());
				System.out.println(rv.getUserId());
				System.out.println("---------------------------");
			}
		}
	}

	public static void testProductRegister() {

		Product product = new Product("H-001", "HISTORY CZ-TV/SP Vintage Natural", "", 96800, 0, "product_history01.jpg");
		ProductRegisterLogic logic = new ProductRegisterLogic();
		boolean result = logic.execute(product, 6);

		if(result) {
			System.out.println("正しく登録されました");
		}else {
			System.out.println("登録に失敗しました");
		}
	}

	public static void testProductEdit() {

		ProductEditLogic logic = new ProductEditLogic();
		Product editProduct = new Product("H-001", "HISTORY CZ-TV/SP Vintage Natural", 6, 96800, 0, "product_history01.jpg" );
		boolean result = logic.execute("H-001", editProduct);

		if(result) {
			System.out.println("正しく登録されました");
		}else {
			System.out.println("登録に失敗しました");
		}
	}

}
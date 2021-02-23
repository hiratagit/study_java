package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Reservation;

public class ProductDAO {

	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Product> getAllProduct() {

		List<Product> productList = new ArrayList<Product>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT P.PRODUCT_ID, M.MAKER_NM, P.PRICE, P.RESERVATION, P.PRODUCT_NM, P.IMGFILE_NM  "
					   + "FROM PRODUCT P JOIN MAKER M ON P.MAKER_ID = M.MAKER_ID";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet re = pStmt.executeQuery();

			while(re.next()) {
				String productId = re.getString("PRODUCT_ID");
			    String makerNm = re.getString("MAKER_NM");
			    int price = re.getInt("PRICE");
			    int reservation = re.getInt("RESERVATION");
			    String productNm = re.getString("PRODUCT_NM");
			    String imgfileNm = re.getString("IMGFILE_NM");

				Product product = new Product(productId, productNm, makerNm, price, reservation, imgfileNm);
				productList.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return productList;
	}

	public Product getProduct(String id) {

		Product product = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT P.PRODUCT_ID, M.MAKER_NM, P.PRICE, P.RESERVATION, P.PRODUCT_NM, P.IMGFILE_NM  "
					   + "FROM PRODUCT P JOIN MAKER M ON P.MAKER_ID = M.MAKER_ID WHERE P.PRODUCT_ID = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet re = pStmt.executeQuery();

			if(re.next()) {
			    String productId = re.getString("PRODUCT_ID");
			    String makerNm = re.getString("MAKER_NM");
			    int price = re.getInt("PRICE");
			    int reservation = re.getInt("RESERVATION");
			    String productNm = re.getString("PRODUCT_NM");
			    String imgfileNm = re.getString("IMGFILE_NM");
			    product = new Product(productId, productNm, makerNm, price, reservation, imgfileNm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return product;
	}

	public boolean setReservation(Reservation reservation) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "INSERT INTO RESERVATION ( USER_ID, PRODUCT_ID) VALUES ( ?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, reservation.getUserId());
			pStmt.setString(2, reservation.getProductId());

			int result = pStmt.executeUpdate();

			if(result != 1) { return false; }

			String sql2 = "UPDATE PRODUCT SET RESERVATION = 1 WHERE PRODUCT_ID = ?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			pStmt2.setString(1, reservation.getProductId());
			int result2 = pStmt2.executeUpdate();

			if(result2 != 1) { return false; }

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Product> getReservation(String userId) {

		List<Product> reserveProductList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT P.PRODUCT_ID, P.PRODUCT_NM, M.MAKER_NM, P.PRICE, P.RESERVATION, P.IMGFILE_NM "
					   + "FROM PRODUCT P JOIN MAKER M ON P.MAKER_ID = M.MAKER_ID "
					   + "WHERE P.PRODUCT_ID IN ( SELECT PRODUCT_ID FROM RESERVATION WHERE USER_ID = ? )";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);
			ResultSet re = pStmt.executeQuery();

			while(re.next()) {
			    String productId = re.getString("PRODUCT_ID");
			    String makerNm = re.getString("MAKER_NM");
			    int price = re.getInt("PRICE");
			    int reservation = re.getInt("RESERVATION");
			    String productNm = re.getString("PRODUCT_NM");
			    String imgfileNm = re.getString("IMGFILE_NM");
			    Product product = new Product(productId, productNm, makerNm, price, reservation, imgfileNm);
			    reserveProductList.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return reserveProductList;

	}

	public List<Reservation> getAllReservation() {

		List<Reservation> reservationAccountList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT P.PRODUCT_ID, P.PRODUCT_NM, M.MAKER_NM, P.PRICE, P.IMGFILE_NM, R.USER_ID "
					   + "FROM PRODUCT P "
					   + "JOIN MAKER M "
					   + "ON P.MAKER_ID = M.MAKER_ID "
					   + "JOIN RESERVATION R "
					   + "ON P.PRODUCT_ID = R.PRODUCT_ID "
					   + "WHERE P.RESERVATION = 1 "
					   + "ORDER BY R.USER_ID";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet re = pStmt.executeQuery();

			while(re.next()) {
			    String productId = re.getString("PRODUCT_ID");
			    String productNm = re.getString("PRODUCT_NM");
			    String makerNm = re.getString("MAKER_NM");
			    int price = re.getInt("PRICE");
			    String imgfileNm = re.getString("IMGFILE_NM");
			    String userId = re.getString("USER_ID");

			    Reservation reservation = new Reservation(productId, productNm, makerNm, price, imgfileNm, userId);
			    reservationAccountList.add(reservation);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return reservationAccountList;
	}

	public boolean productRegister(Product product, int makerId) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "INSERT INTO PRODUCT ( PRODUCT_ID, MAKER_ID, PRICE, RESERVATION, PRODUCT_NM, IMGFILE_NM) "
					   + "VALUES ( ?, ?, ?, ?, ?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, product.getProductId());
			pStmt.setInt(2, makerId);
			pStmt.setInt(3, product.getPrice());
			pStmt.setInt(4, product.getReservation());
			pStmt.setString(5, product.getProductNm());
			pStmt.setString(6, product.getImgfileNm());

			int result = pStmt.executeUpdate();

			if(result != 1) { return false; }

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean productDelete(String deleteProductId) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "DELETE PRODUCT WHERE PRODUCT_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, deleteProductId);

			int result = pStmt.executeUpdate();
			if(result != 1) { return false; }

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean productEdit(String targetProductId, Product editProduct) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			String sql = "UPDATE PRODUCT SET PRODUCT_ID = ?, MAKER_ID = ?, PRICE = ?, RESERVATION = ?, PRODUCT_NM = ?, IMGFILE_NM = ?  "
					   + "WHERE PRODUCT_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, editProduct.getProductId());
			pStmt.setInt(2, editProduct.getMakerId());
			pStmt.setInt(3, editProduct.getPrice());
			pStmt.setInt(4, editProduct.getReservation());
			pStmt.setString(5, editProduct.getProductNm());
			pStmt.setString(6, editProduct.getImgfileNm());
			pStmt.setString(7, targetProductId);

			int result = pStmt.executeUpdate();

			if(result != 1) { return false; }

		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
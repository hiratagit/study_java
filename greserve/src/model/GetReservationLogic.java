package model;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;

public class GetReservationLogic {

	public List<Product> execute(String userId) {
		List<Product> reserveProductList = new ArrayList<Product>();
		ProductDAO dao = new ProductDAO();
		reserveProductList = (List<Product>) dao.getReservation(userId);
		return reserveProductList;
	}


}
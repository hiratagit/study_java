package model;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;

public class GetAllProductLogic {

	public List<Product> execute() {
		List<Product> productList = new ArrayList<Product>();

		ProductDAO dao = new ProductDAO();
		productList = dao.getAllProduct();

		return productList;
	}
}
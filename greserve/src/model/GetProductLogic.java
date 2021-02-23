package model;

import dao.ProductDAO;
public class GetProductLogic {

	public Product execute(String productId) {
		ProductDAO dao = new ProductDAO();
		Product product = dao.getProduct(productId);
		return product;
	}
}
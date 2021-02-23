package model;
import dao.ProductDAO;

public class ProductDeleteLogic {

	public boolean execute(String deleteProductId) {
		ProductDAO dao = new ProductDAO();
		return dao.productDelete(deleteProductId);
	}
}
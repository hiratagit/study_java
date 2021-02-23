package model;
import dao.ProductDAO;

public class ProductEditLogic {
	public boolean execute(String targetProductId, Product editProduct) {

		ProductDAO dao = new ProductDAO();
		return dao.productEdit(targetProductId, editProduct);
	}
}
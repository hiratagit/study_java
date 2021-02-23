package model;

import dao.ProductDAO;
public class ProductRegisterLogic {

	public boolean execute(Product product, int makerId) {

		ProductDAO dao = new ProductDAO();
		return (boolean) dao.productRegister(product, makerId);
	}
}
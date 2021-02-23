package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.ProductDeleteLogic;

@WebServlet("/ProductDelete")
public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String adminLoginId = (String) session.getAttribute("adminLoginId");
		Product deleteProduct = (Product) session.getAttribute("targetProduct");

		if(adminLoginId != null && deleteProduct != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productDeleteConfirm.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("/greserve/Admin");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String errMsg = null;

		HttpSession session = request.getSession();
		String adminLoginId = (String) session.getAttribute("adminLoginId");
		String deleteProductId = (String) request.getParameter("deleteProductId");
		Product targetProduct = (Product) session.getAttribute("targetProduct");

		if(adminLoginId != null && deleteProductId != null && deleteProductId.length() > 0) {

			ProductDeleteLogic logic = new ProductDeleteLogic();
			boolean result = logic.execute(deleteProductId);

			if(result) {
				targetProduct = null;
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productDeleteDone.jsp");
				dispatcher.forward(request, response);
			} else {
				errMsg = "アイテムが正しく削除されませんでした";
				request.setAttribute("errMsg", errMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productDeleteConfirm.jsp");
				dispatcher.forward(request, response);
			}

		}else {
			response.sendRedirect("/greserve/Admin");
		}
	}

}

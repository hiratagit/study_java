package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetProductLogic;
import model.Product;
import model.ProductEditLogic;

@WebServlet("/ProductEdit")
public class ProductEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String adminLoginId = (String) session.getAttribute("adminLoginId");

		if(adminLoginId != null) {
			String targetProductId = request.getParameter("productId");
			request.setAttribute("targetProductId", targetProductId);

			GetProductLogic logic = new GetProductLogic();
			Product product = logic.execute(targetProductId);
			session.setAttribute("targetProduct", product);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productEdit.jsp");
			dispatcher.forward(request, response);

		}else {
			response.sendRedirect("/greserve/Admin");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Product targetProduct = (Product) session.getAttribute("targetProduct");
		String targetProductId = targetProduct.getProductId();

		String errMsg = null;

		if(request.getParameter("productId") == null || request.getParameter("productId").length() == 0 ||
		   request.getParameter("productNm") == null || request.getParameter("productNm").length() == 0 ||
		   request.getParameter("makerId") == null || request.getParameter("makerId").length() == 0 ||
		   request.getParameter("price") == null || request.getParameter("price").length() == 0 ||
		   request.getParameter("imgfileNm") == null || request.getParameter("imgfileNm").length() == 0  ) {

				errMsg = "入力に誤りがあります";
				request.setAttribute("errMsg", errMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productEdit.jsp");
				dispatcher.forward(request, response);

		} else {

			String edit_productId = request.getParameter("productId");
			String edit_productNm = request.getParameter("productNm");
			int edit_makerId = Integer.parseInt(request.getParameter("makerId"));
			int edit_price = Integer.parseInt(request.getParameter("price"));
			String edit_imgfileNm = request.getParameter("imgfileNm");
			int reservation = 0;

			Product editProduct = new Product(edit_productId, edit_productNm, edit_makerId, edit_price, reservation, edit_imgfileNm);
			ProductEditLogic logic = new ProductEditLogic();
			boolean result = logic.execute(targetProductId, editProduct);

			if(result) {
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productEditDone.jsp");
	        	dispatcher.forward(request, response);
	        } else {
	        	errMsg = "登録に失敗しました";
	        	request.setAttribute("errMsg", errMsg);
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productEdit.jsp");
	        	dispatcher.forward(request, response);
	        }

		}
	}

}

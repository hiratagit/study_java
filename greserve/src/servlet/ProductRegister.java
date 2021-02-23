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
import model.ProductRegisterLogic;


@WebServlet("/ProductRegister")
public class ProductRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String adminLoginId = (String) session.getAttribute("adminLoginId");

		//管理者としてログイン中なら
		if(adminLoginId != null && adminLoginId.length() > 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productRegister.jsp");
		    dispatcher.forward(request, response);
		}else {
			response.sendRedirect("/greserve/Admin");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String errMsg = null;


		if(request.getParameter("productId") == null || request.getParameter("productId").length() == 0 ||
			request.getParameter("productNm") == null || request.getParameter("productNm").length() == 0 ||
			request.getParameter("makerId") == null || request.getParameter("makerId").length() == 0 ||
			request.getParameter("price") == null || request.getParameter("price").length() == 0 ||
			request.getParameter("imgfileNm") == null || request.getParameter("imgfileNm").length() == 0  ) {

			errMsg = "入力に誤りがあります";
			request.setAttribute("errMsg", errMsg);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productRegister.jsp");
        	dispatcher.forward(request, response);

		} else {

			String productId = request.getParameter("productId");
			String productNm = request.getParameter("productNm");
			int makerId = Integer.parseInt(request.getParameter("makerId"));
			int price = Integer.parseInt(request.getParameter("price"));
			int reservation = 0;
			String imgfileNm = request.getParameter("imgfileNm");

	        Product product = new Product(productId, productNm, "", price, reservation, imgfileNm);
	        ProductRegisterLogic logic = new ProductRegisterLogic();
	        boolean result = logic.execute(product, makerId);

	        if(result) {
	        	session.setAttribute("registeredProductId", productId);
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productRegisterDone.jsp");
	        	dispatcher.forward(request, response);
	        } else {
	        	errMsg = "登録に失敗しました";
	        	request.setAttribute("errMsg", errMsg);
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productRegister.jsp");
	        	dispatcher.forward(request, response);
	        }
		}

	}

}

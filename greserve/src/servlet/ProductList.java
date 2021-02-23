package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetAllProductLogic;
import model.Product;

@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String adminLoginId = (String) session.getAttribute("adminLoginId");

		//ログイン中でなければリダイレクト
		if(userId == null && adminLoginId == null) {
			response.sendRedirect("/greserve/index.jsp");
		}else {

			List<Product> productList = new ArrayList<>();
			GetAllProductLogic logic = new GetAllProductLogic();
			productList = logic.execute();
			session.setAttribute("productList", productList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productList.jsp");
			dispatcher.forward(request, response);
		}

	}

}

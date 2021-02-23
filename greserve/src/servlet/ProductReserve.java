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
import model.Reservation;
import model.SetReservationLogic;


@WebServlet("/ProductReserve")
public class ProductReserve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String adminLoginId = (String) session.getAttribute("adminLoginId");

		//ログイン中でなければリダイレクト
		if(userId == null && adminLoginId == null) {
			response.sendRedirect("/greserve/index.jsp");
		} else {

			String productId = request.getParameter("productId");
			GetProductLogic logic = new GetProductLogic();
			Product product = logic.execute(productId);

			session.setAttribute("product", product);


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productReserve.jsp");
			dispatcher.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		Reservation reservation = new Reservation(userId, productId);

		SetReservationLogic logic = new SetReservationLogic();
		boolean result = logic.execute(reservation);

		if(!result) {
			String errMsg = "予約処理が失敗しました";
			request.setAttribute("errMsg", errMsg);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productReserveDone.jsp");
		dispatcher.forward(request, response);

	}

}


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

import model.Account;
import model.GetAccountLogic;
import model.GetReservationLogic;
import model.Product;

@WebServlet("/MemberInfo")
public class MemberInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginUserId = (String) session.getAttribute("userId");

		//ログイン中でなければリダイレクト
		if(loginUserId == null) {
			response.sendRedirect("/greserve/index.jsp");
		}else {

		    Account account = null;
		    List<Product> reservationList = new ArrayList<>();

		    GetAccountLogic getAccount = new GetAccountLogic();
		    account = getAccount.execute(loginUserId);

		    GetReservationLogic getReservation = new GetReservationLogic();
		    reservationList = getReservation.execute(loginUserId);

		    session.setAttribute("account", account);
		    session.setAttribute("reservationList", reservationList);

		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/memberInfo.jsp");
		    dispatcher.forward(request, response);
		}
	}

}

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
import model.FindAllLogic;
import model.Login;
import model.LoginLogic;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");

		Login login = new Login(userId, pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);

		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);

			//一覧表示のための追加プログラム
			List<Account> accountList = new ArrayList<>();
			FindAllLogic findAllLogic = new FindAllLogic();
			accountList = findAllLogic.execute();
			session.setAttribute("accountList", accountList);


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOk.jsp");
			dispatcher.forward(request, response);

		} else {
			response.sendRedirect("/login/LoginServlet");
		}



	}

}

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.RegisterAccountLogic;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String errMsg = null;

		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");

		if(  userId == null || userId.length() == 0
		    || pass == null || pass.length() ==0
		    || name == null || name.length() == 0 ) {


			errMsg = "入力が正しくありません";
			request.setAttribute("errMsg", errMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);

		} else {

			Account account = new Account(userId, pass, name, mail, 0);

			RegisterAccountLogic register = new RegisterAccountLogic();
			boolean result = register.execute(account);

			if(result) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerDone.jsp");
				dispatcher.forward(request, response);
			} else {

				errMsg = "登録に失敗しました";
				request.setAttribute("errMsg", errMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
				dispatcher.forward(request, response);
			}
		}

	}

}

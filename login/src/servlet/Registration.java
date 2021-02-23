package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.RegistrationLogic;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Registration.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		if((userId !=null && userId.length() != 0) &&
		   (pass !=null && pass.length() != 0) &&
		   (mail !=null && mail.length() != 0) &&
		   (name !=null && name.length() != 0) &&
		   (age >= 0) ) {
			Account account = new Account(userId, pass, mail, name, age);
			RegistrationLogic registrationLogic = new RegistrationLogic();
			registrationLogic.execute(account);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistrationDone.jsp");
			dispatcher.forward(request, response);

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Registration.jsp");
			dispatcher.forward(request, response);
		}
	}

}

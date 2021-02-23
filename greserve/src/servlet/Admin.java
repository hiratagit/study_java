package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminLoginLogic;
import model.LoginAdmin;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String loginId = request.getParameter("adminId");
		String loginPass = request.getParameter("pass");
		String errMsg = null;

		LoginAdmin loginAdmin = new LoginAdmin(loginId, loginPass);

		AdminLoginLogic loginAdminLogic = new AdminLoginLogic();
		boolean result = loginAdminLogic.execute(loginAdmin);

		if(result) {
			session.setAttribute("adminLoginId", loginId);

		} else {
			errMsg = "入力情報が正しくありません";
			request.setAttribute("errMsg", errMsg);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
		dispatcher.forward(request, response);
	}

}

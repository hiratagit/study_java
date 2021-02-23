package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.RegisterAdminLogic;

@WebServlet("/RegisterAdmin")
public class RegisterAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String adminLoginId = (String) session.getAttribute("adminLoginId");

		if(adminLoginId == null || adminLoginId.length() == 0 ) { //非ログインなら管理画面トップへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerAdmin.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errMsg = null;

		String adminId = request.getParameter("adminId");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");

		if( adminId == null || adminId.length() == 0 ||
			 pass == null   || pass.length() == 0 ||
			 name == null   || name.length() == 0 ) {

			errMsg = "入力に誤りがあります。";
			request.setAttribute("errMsg", errMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerAdmin.jsp");
			dispatcher.forward(request, response);

		} else {

			Admin newAccount = new Admin(adminId, pass, name, 1);
			RegisterAdminLogic registerAdminLogic = new RegisterAdminLogic();
			boolean result = registerAdminLogic.execute(newAccount);

			if(result) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerAdminDone.jsp");
				dispatcher.forward(request, response);
			}else {
				errMsg = "登録に失敗しました";
				request.setAttribute("errMsg", errMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerAdmin.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}

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
import model.Admin;
import model.GetAccountListLogic;
import model.GetAdminListLogic;


@WebServlet("/MemberAdminList")
public class MemberAdminList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String adminLoginId = (String) session.getAttribute("adminLoginId");

		//管理者としてログイン中なら
		if(adminLoginId != null && adminLoginId.length() > 0) {

			//管理者一覧取得＆セッションへ保存
			List<Admin> adminList = new ArrayList<>();
			GetAdminListLogic getAdminList = new GetAdminListLogic();
			adminList = getAdminList.execute();

			if(adminList != null) {
				session.setAttribute("adminList", adminList);
			}

			//会員一覧取得＆セッションへ保存
			List<Account> accountList = new ArrayList<>();
			GetAccountListLogic getAccountList = new GetAccountListLogic();
			accountList = (List<Account>) getAccountList.execute();

			if(accountList != null ) {
				session.setAttribute("accountList", accountList);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/memberAdminList.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/greserve/Admin");
		}



	}

}

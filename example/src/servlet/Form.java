package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form
 */
@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Form() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String qtype = request.getParameter("qtype");
		String body = request.getParameter("body");

	    String errorMsg = "";

		if(name == null || name.length() == 0) {
			errorMsg += "名前が入力されていません<br>";
		}
		if(qtype == null || qtype.length() == 0) {
			errorMsg += "お問い合わせの種類が選択されていません<br>";
		}else if(qtype.equals("company")) {
			qtype = "会社について";
		}else if(qtype.equals("product")) {
			qtype = "製品について";
		}else if(qtype.equals("support")) {
			qtype = "アフターサポートについて";
		}

		if(body == null || body.length() == 0) {
			errorMsg += "お問い合わせ内容が入力されていません。<br>";
		}

		if(errorMsg.length() != 0) {
			errorMsg = "<div style=\"background: green; color: white; \">" + errorMsg + "</div>";
		}


		response.setContentType("text/himl; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>ユーザー登録結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>名前: " + name + "</p>");
		out.println("<p>お問い合わせ種類: " + qtype + "</p>");
		out.println("<p>お問い合わせ内容: " + body + "</p>");
		out.println(errorMsg);
		out.println("</body>");
		out.println("</html>");
	}

}

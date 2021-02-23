package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SiteEv;
import model.SiteEvLogic;

@WebServlet("/MinatoIndex")
public class MinatoIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MinatoIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		SiteEv siteEv = (SiteEv) application.getAttribute("siteEv");

		if(siteEv == null) {
			siteEv = new SiteEv();
		}

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		SiteEvLogic siteEvLogic = new SiteEvLogic();

		if(action != null && action.equals("like")) {
			siteEvLogic.like(siteEv);
		}else if(action != null && action.equals("dislike")) {
			siteEvLogic.disLike(siteEv);
		}

		application.setAttribute("siteEv", siteEv);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/minatoIndex.jsp");
		dispatcher.forward(request, response);

	}

}

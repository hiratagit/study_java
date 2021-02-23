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

import model.GetAllReservationLogic;
import model.Reservation;


@WebServlet("/ReservationStatus")
public class ReservationStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String adminLoginId = (String) session.getAttribute("adminLoginId");

		//管理者としてログイン中なら
		if(adminLoginId != null && adminLoginId.length() > 0) {

			List<Reservation> reservationList = new ArrayList<>();
			GetAllReservationLogic logic = new GetAllReservationLogic();
			reservationList = (List<Reservation>) logic.execute();
			session.setAttribute("reservationList", reservationList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reservationStatus.jsp");
			dispatcher.forward(request, response);

		} else {
			response.sendRedirect("/greserve/Admin");
		}
	}


}

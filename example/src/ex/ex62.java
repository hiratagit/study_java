package ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex62")
public class ex62 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ex62() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int r = (int)(Math.random() * 10);

		if(r % 2 == 0) {
			response.sendRedirect("forwarded.jsp?random=" + r);
		}else {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("rredirected.jsp?random=" + r);
			dispatcher.forward(request, response);
		}
	}

}

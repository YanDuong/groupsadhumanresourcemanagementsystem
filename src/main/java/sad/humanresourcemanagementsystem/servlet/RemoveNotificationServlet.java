package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.service.NotificationService;

/**
 * Servlet implementation class RemoveNotificationServlet
 */

@WebServlet(name = "RemoveNotificationServlet", urlPatterns = "/RemoveNotificationServlet")
public class RemoveNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveNotificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		String error = "";
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			if(new NotificationService().deleteNotification(id)) {
				message += "Remove successfully!";
			} else {
				error += "Remove failed!";
			}
			if(message.length() > 0) {
				request.setAttribute("message", message);
			}			
			if(error.length() > 0) {
				request.setAttribute("error", error);
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("ManageNotificationServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

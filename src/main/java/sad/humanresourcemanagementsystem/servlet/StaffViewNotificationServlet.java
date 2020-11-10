package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.model.Notification;
import sad.humanresourcemanagementsystem.service.NotificationService;


/**
 * Servlet implementation class StaffViewNotificationServlet
 */

@WebServlet(name = "StaffViewNotificationServlet", urlPatterns = "/StaffViewNotificationServlet")
public class StaffViewNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffViewNotificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String error = "";
		try {
			List<Notification> notifications = new NotificationService().getNotifications();
			if(notifications != null) {
				request.setAttribute("notifications", notifications);				
			} else {
				error += "There is no notification!";			
			}
			if(error.length() > 0) {
				request.setAttribute("error", error);
			}
			request.getRequestDispatcher("staff_view_notification.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

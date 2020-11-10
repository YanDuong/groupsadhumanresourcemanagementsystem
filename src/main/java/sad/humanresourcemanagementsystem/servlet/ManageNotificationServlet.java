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
 * Servlet implementation class ManageNotificationServlet
 */

@WebServlet(name = "ManageNotificationServlet", urlPatterns = "/ManageNotificationServlet")
public class ManageNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageNotificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		try {		 
			 List<Notification> list = (new NotificationService()).getNotifications();
			 if(list.isEmpty()) {
				error += "There is no new notification!";
			 } else {
				 request.setAttribute("notifications", list);
			 }			
				if(error.length() > 0) {
					 request.setAttribute("error", error);
				 }
				request.getRequestDispatcher("admin_manage_notification.jsp").forward(request, response);
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

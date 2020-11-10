package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.service.StaffService;

/**
 * Servlet implementation class RemoveStaffServlet
 */

@WebServlet(name = "RemoveStaffServlet", urlPatterns = "/RemoveStaffServlet")
public class RemoveStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveStaffServlet() {
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
			if(new StaffService().removeStaff(id)) {
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
			response.sendRedirect("ManageStaffServlet");
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

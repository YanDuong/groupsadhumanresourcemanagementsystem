package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.model.EmployeeFee;
import sad.humanresourcemanagementsystem.service.EmployeeFeeService;

/**
 * Servlet implementation class UpdateEmployeeFeeServlet
 */

@WebServlet(name = "UpdateEmployeeFeeServlet", urlPatterns = "/UpdateEmployeeFeeServlet")
public class UpdateEmployeeFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeFeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String message = "";
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String kpi = request.getParameter("kpi");
			String travel = request.getParameter("travel");
			String equipment = request.getParameter("equipment");
			String bonus = request.getParameter("bonus");
			String inssurance = request.getParameter("inssurance");
			String tax = request.getParameter("tax");
			String other = request.getParameter("other");
			if(new EmployeeFeeService().update(new EmployeeFee(id, kpi, travel, equipment, bonus, inssurance, tax, other))) {
				message += "Update successully!";
			} else {
				error += "Update failed!";
			}
			if(message.length() > 0) {
				request.setAttribute("message", message);
			}
			if(error.length() > 0) {
				request.setAttribute("error", error);
			}
			response.sendRedirect("ManageEmployeeFeeServlet");
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

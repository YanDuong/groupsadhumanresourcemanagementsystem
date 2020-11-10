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
 * Servlet implementation class ViewEmployeeFeeServlet
 */

@WebServlet(name = "ViewEmployeeFeeServlet", urlPatterns = "/ViewEmployeeFeeServlet")
public class ViewEmployeeFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployeeFeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeFee fee = new EmployeeFeeService().getEmployeeFeeById(id);
			request.setAttribute("EmployeeFee", fee);
			request.getRequestDispatcher("admin_view_employee_fee.jsp").forward(request, response);				
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

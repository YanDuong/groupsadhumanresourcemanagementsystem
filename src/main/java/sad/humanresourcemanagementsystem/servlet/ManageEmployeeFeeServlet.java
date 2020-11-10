package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.model.EmployeeFee;
import sad.humanresourcemanagementsystem.service.EmployeeFeeService;


/**
 * Servlet implementation class ManageEmployeeFeeServlet
 */

@WebServlet(name = "ManageEmployeeFeeServlet", urlPatterns = "/ManageEmployeeFeeServlet")
public class ManageEmployeeFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageEmployeeFeeServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String month;
		List<EmployeeFee> list;
		String error = "";
		try {
			month = request.getParameter("month");
			if(month != null) {
				list = new EmployeeFeeService().getEmployeeFeeListByMonth(month);
			} else {
				list = new EmployeeFeeService().getEmployeeFeeList();
			}						
			if(list != null) {
				request.setAttribute("list", list);
			} else {
				error += "No Record Existed!";
			}	
			if(error.length() > 0) {
				request.setAttribute("error", error);
			}
			request.getRequestDispatcher("admin_manage_employee_fee.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

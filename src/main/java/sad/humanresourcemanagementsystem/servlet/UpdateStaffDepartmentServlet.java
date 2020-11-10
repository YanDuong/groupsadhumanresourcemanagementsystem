package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.service.DepartmentService;


/**
 * Servlet implementation class UpdateStaffDepartmentServlet
 */

@WebServlet(name = "UpdateStaffDepartmentServlet", urlPatterns = "/UpdateStaffDepartmentServlet")
public class UpdateStaffDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStaffDepartmentServlet() {
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
				String employeeCode = request.getParameter("employeeCode");
				String departmentName = request.getParameter("departmentName");
				int departmentId = new DepartmentService().getDepartmentIdByName(departmentName);
				if(new DepartmentService().updateStaffDepartment(departmentId, employeeCode)) {
					message += "Update successfully!";
				} else {
					error += "Update failed!";
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
		response.sendRedirect("ManageDepartmentServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

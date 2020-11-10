package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.model.Department;
import sad.humanresourcemanagementsystem.model.Staff;
import sad.humanresourcemanagementsystem.service.DepartmentService;
import sad.humanresourcemanagementsystem.service.StaffService;

/**
 * Servlet implementation class ManageDepartmentServlet
 */
public class ManageDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageDepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		try {
			List<Department> departmentInforList = new DepartmentService().getDepartmentInfoList();
			List<Department> departments = new DepartmentService().getDepartments();
			List<Staff> staffs = new StaffService().getStaffs();
			if(departments.isEmpty()) {
				error += "There is no department!";
			}	
			request.setAttribute("departmentInfoList", departmentInforList);
			request.setAttribute("departments", departments);
			request.setAttribute("staffs", staffs);
			if(error.length() > 0) {
				request.setAttribute("error", error);
			}
			request.getRequestDispatcher("admin_manage_department.jsp").forward(request, response);
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

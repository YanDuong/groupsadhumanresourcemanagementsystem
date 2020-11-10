package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.model.Staff;
import sad.humanresourcemanagementsystem.service.DepartmentService;
import sad.humanresourcemanagementsystem.service.StaffService;

/**
 * Servlet implementation class UpdateStaffServlet
 */

@WebServlet(name = "UpdateStaffServlet", urlPatterns = "/UpdateStaffServlet")
public class UpdateStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StaffService service = new StaffService();
			int id = Integer.parseInt(request.getParameter("id"));
			String departmentName = request.getParameter("departmentName");
			int departmentId = new DepartmentService().getDepartmentIdByName(departmentName);
			int status = Integer.parseInt(request.getParameter("status"));
			String role = request.getParameter("role");
			String employeeCode = request.getParameter("employeeCode");
			String cmnd = request.getParameter("cmnd");
			String fullname = request.getParameter("fullname");			
			String dob = request.getParameter("dob");					
			int sex = Integer.parseInt(request.getParameter("sex"));
			int statusMarriage = Integer.parseInt(request.getParameter("statusMarriage"));
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String contact = request.getParameter("contact");
			int activity = Integer.parseInt(request.getParameter("activity"));
			int profileStatus = Integer.parseInt(request.getParameter("profileStatus"));
			String graduateInstitution = request.getParameter("graduateInstitution");
			String major = request.getParameter("major");
			String graduateYear = request.getParameter("graduateYear");
			String overseaEducation = request.getParameter("overseaEducation");
			String degree = request.getParameter("degree");
			service.updateStaff(new Staff(id, departmentId, role, status, employeeCode, fullname, cmnd, sex, email, phone, dob, address, statusMarriage, contact, activity, profileStatus, graduateInstitution, major, degree, graduateYear, overseaEducation));
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

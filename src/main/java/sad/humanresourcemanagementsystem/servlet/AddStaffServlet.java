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
 * Servlet implementation class AddStaffServlet
 */
@WebServlet(name = "AddStaffServlet", urlPatterns = "/addStaffServlet")
public class AddStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int row = 0;
		String error = "";
		String message = "";
		try {				
			StaffService service1 = new StaffService();
			if(service1.checkExistStaff(request.getParameter("employeeCode"))) {
				error += "Staff already existed!\n";				
			} else {			
			StaffService service2 = new StaffService();			
			String fullname = request.getParameter("fullname");
			String departmentName = request.getParameter("departmentName");
			int departmentId = new DepartmentService().getDepartmentIdByName(departmentName);
			String role = request.getParameter("role");
			int status = Integer.parseInt(request.getParameter("status"));
			String employeeCode = request.getParameter("employeeCode");		
			String dob = request.getParameter("dob");
			String cmnd = request.getParameter("cmnd");
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
			row = service2.addNewStaff(new Staff(departmentId, role, status, employeeCode, fullname, cmnd, sex, email, phone, dob, address, statusMarriage, contact, activity, profileStatus, graduateInstitution, major, degree, graduateYear, overseaEducation));
			if(row != -1) {
				message += "Add successfully!";
			} else {
				error += "Add failed!";
			}		
			
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

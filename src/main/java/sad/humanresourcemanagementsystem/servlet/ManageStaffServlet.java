package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.model.Staff;
import sad.humanresourcemanagementsystem.service.StaffService;

@WebServlet(name="ManageStaffServlet", urlPatterns="/ManageStaffServlet")
public class ManageStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String error = "";
		
		try {			
			StaffService service = new StaffService();
			List<Staff> staffs = service.getStaffs();
			if(staffs.isEmpty()) {
				error += "Staff list is empty!";
			} else {
				request.setAttribute("staffs", staffs);
			}
			if(error.length() > 0) {
				request.setAttribute("error", error);
			}
			request.getRequestDispatcher("admin_sidebar.jsp").forward(request, response);
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

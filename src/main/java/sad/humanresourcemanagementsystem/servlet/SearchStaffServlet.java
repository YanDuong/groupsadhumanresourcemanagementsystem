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

/**
 * Servlet implementation class SearchStaffServlet
 */

@WebServlet(name = "SearchStaffServlet", urlPatterns = "/SearchStaffServlet")
public class SearchStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Staff> searchedStaffs = null;
		String error = "";
		try {
			String searchKey = request.getParameter("search");
			if(searchKey != null) {
				searchedStaffs = new StaffService().getStaffByName(searchKey);
				if(searchedStaffs != null) {
					request.setAttribute("staffs", searchedStaffs);
				} else {
					error += "No Staff Found!";
				}
			} else {
				error += "Search keyword can not be empty!";
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

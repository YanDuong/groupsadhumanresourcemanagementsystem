package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sad.humanresourcemanagementsystem.model.Account;
import sad.humanresourcemanagementsystem.model.Staff;
import sad.humanresourcemanagementsystem.service.AuthenticationService;
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Account account = new AuthenticationService().getStaffAccount(username, password);
			if(account != null) {
				Staff staff = account.getStaff();
				String role = staff.getRole();
				request.setAttribute("role", role);
				HttpSession session = request.getSession(true);
				session.setAttribute("name", staff.getFullName());
				session.setAttribute("staffId", staff.getId());
				session.setMaxInactiveInterval(30 * 60);
				if(role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("administrator") ) {
					response.sendRedirect("ManageStaffServlet");					
				} else {
					System.out.println("Manage Staff");
					request.getRequestDispatcher("staff_attendance.jsp").forward(request, response);
				}
			} else {
				error += "Account not existed!";
			}
			if(error.length() > 0) {
				request.setAttribute("error", error);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				System.out.println(error);
			}
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	}


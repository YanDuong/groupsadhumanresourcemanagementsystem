package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sad.humanresourcemanagementsystem.Helper.Helper;
import sad.humanresourcemanagementsystem.model.Attendance;
import sad.humanresourcemanagementsystem.model.Staff;
import sad.humanresourcemanagementsystem.service.AttendanceService;

import java.sql.Date;
import java.sql.Time;
/**
 * Servlet implementation class StaffStartWorkingServlet
 */

@WebServlet(name = "StaffStartWorkingServlet", urlPatterns = "/StaffStartWorkingServlet")
public class StaffStartWorkingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int WORKING_STATUS = 1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffStartWorkingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		try {
			HttpSession session = request.getSession(false);
			int staffId = (Integer) session.getAttribute("staffId");
			Date currentDate = Helper.getCurrentDate();
			Time currentTime = Helper.getCurrentTime();
			Staff staff = new Staff();
			staff.setId(staffId);
			Attendance attendance = new Attendance();
			attendance.setStaff(staff);
			attendance.setDate(currentDate);
			attendance.setStatus(WORKING_STATUS);
			attendance.setStartAt(currentTime);
			if(new AttendanceService().saveAttedance(attendance) != -1) {
				message += "Record successfully!";
			}
			if(message.length() > 0) {
				request.setAttribute("message", message);
			}
			request.getRequestDispatcher("staff_attendance.jsp").forward(request, response);
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

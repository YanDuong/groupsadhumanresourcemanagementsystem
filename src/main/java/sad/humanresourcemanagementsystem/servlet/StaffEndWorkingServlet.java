package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sad.humanresourcemanagementsystem.Helper.Helper;
import sad.humanresourcemanagementsystem.model.Attendance;
import sad.humanresourcemanagementsystem.model.Staff;
import sad.humanresourcemanagementsystem.service.AttendanceService;

/**
 * Servlet implementation class StaffEndWorkingServlet
 */

@WebServlet(name = "StaffEndWorkingServlet", urlPatterns = "/StaffEndWorkingServlet")
public class StaffEndWorkingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffEndWorkingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		try {
			int staffId = (Integer) request.getSession(false).getAttribute("staffId");
			Time endTime = Helper.getCurrentTime();
			Date currentDate = Helper.getCurrentDate();		
			Staff staff = new Staff();
			staff.setId(staffId);
			Attendance attendance = new Attendance();
			attendance.setStaff(staff);
			attendance.setDate(currentDate);
			attendance.setEndAt(endTime);
			if(new AttendanceService().updateAttendance(attendance)) {
				message += "Record work successfully!";
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

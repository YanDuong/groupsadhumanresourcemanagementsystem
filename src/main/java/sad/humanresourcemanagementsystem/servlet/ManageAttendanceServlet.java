package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.Helper.Helper;
import sad.humanresourcemanagementsystem.model.Attendance;
import sad.humanresourcemanagementsystem.service.AttendanceService;


/**
 * Servlet implementation class ManageAttendanceServlet
 */

@WebServlet(name = "ManageAttendanceServlet", urlPatterns = "/ManageAttendanceServlet")
public class ManageAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int WORKING_STAFF = 1;
	private static final int NON_WORKING_STAFF = 0;

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageAttendanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = null;
		List<Attendance> attendanceList = null;
		List<Attendance> workingList = null;
		List<Attendance> nonWorkingList = null;
		int totalStaff = 0;
		int workingStaff = 0;
		int nonWorkingStaff = 0;
		try {				
			String dateString = request.getParameter("selectedDate");
			if(dateString != null) {
				date = Helper.stringToDate2(dateString);
				attendanceList = new AttendanceService().getStaffAttendanceByDate(date);
			} else {
				 attendanceList  = new AttendanceService().getAllStaffAttendance();	
			}
			
			if(attendanceList != null) {
				workingList = populateWorkingList(attendanceList);
				nonWorkingList = populateNonWorkingList(attendanceList);
				request.setAttribute("nonWorkingList", nonWorkingList);	
				request.setAttribute("workingList", workingList);			
				totalStaff = attendanceList.size();
				workingStaff = workingList.size();
				nonWorkingStaff = nonWorkingList.size();
			} 				
			request.setAttribute("date", date);	
			request.setAttribute("totalStaffNumber", totalStaff);		
			request.setAttribute("nonWorkingNumber", nonWorkingStaff);
			request.setAttribute("workingNumber", workingStaff);			
			request.getRequestDispatcher("admin_manage_attendance.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private  List<Attendance> populateWorkingList(List<Attendance> attendanceList) {
		List<Attendance> workingList = new ArrayList<>();
		for(Attendance attendance: attendanceList) {
			if(attendance.getStatus() == WORKING_STAFF) {
				workingList.add(attendance);
			}
		}
		return workingList;
	}
	
private List<Attendance> populateNonWorkingList(List<Attendance> attendanceList) {
	List<Attendance> nonWorkingList = new ArrayList<>();
	for(Attendance attendance: attendanceList) {
		if(attendance.getStatus() == NON_WORKING_STAFF) {
			nonWorkingList.add(attendance);
		}
	}
	return nonWorkingList;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

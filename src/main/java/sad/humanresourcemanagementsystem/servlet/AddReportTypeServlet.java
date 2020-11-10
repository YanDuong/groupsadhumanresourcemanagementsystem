package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.service.ReportTypeService;


/**
 * Servlet implementation class AddReportTypeServlet
 */

@WebServlet(name = "AddReportTypeServlet", urlPatterns = "/AddReportTypeServlet")
public class AddReportTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReportTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		int row = 0;
		try {
			String name = request.getParameter("reportTypeName");
			ReportTypeService service1 = new ReportTypeService();			
			if(service1.checkReportType(name)) {
				message += "Report Type already existed!";
			} else {
				ReportTypeService service2 = new ReportTypeService();	
				row = service2.insertReportType(name);
				if(row != -1) {
					message += "Add Report Type Successfully!";
				} else {
					message += "Add Report Type failed!";
				}
				
			}	
			
			request.setAttribute("message", message);
			response.sendRedirect("ManageReportServlet");
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

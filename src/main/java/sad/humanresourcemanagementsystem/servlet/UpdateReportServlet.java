package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.model.Report;
import sad.humanresourcemanagementsystem.service.ReportService;
/**
 * Servlet implementation class UpdateReportServlet
 */

@WebServlet(name = "UpdateReportServlet", urlPatterns = "/UpdateReportServlet")
public class UpdateReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String message = request.getParameter("message");
			int status = Integer.parseInt(request.getParameter("status"));
			new ReportService().updateReport(new Report(id, message, status));
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

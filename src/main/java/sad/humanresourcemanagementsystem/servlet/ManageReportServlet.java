package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.model.ReportInfo;
import sad.humanresourcemanagementsystem.model.ReportType;
import sad.humanresourcemanagementsystem.service.ReportService;
import sad.humanresourcemanagementsystem.service.ReportTypeService;


/**
 * Servlet implementation class ManageReportServlet
 */

@WebServlet(name = "ManageReportTypeServlet", urlPatterns = "/ManageReportTypeServlet")
public class ManageReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ReportService service = new ReportService();
			ReportTypeService reportTypeService = new ReportTypeService();
			List<ReportInfo> reportInfoList = service.getReportInfoList();
			List<ReportType> reportTypeList =  reportTypeService.getReportTypeList();
			request.setAttribute("reportInfoList", reportInfoList);
			request.setAttribute("reportTypeList", reportTypeList);
			request.getRequestDispatcher("admin_manage_report.jsp").forward(request, response);
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

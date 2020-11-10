package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadReportTypeServlet02
 */

@WebServlet(name = "UploadContractFileServlet02", urlPatterns = "/UploadContractFileServlet02")
public class UploadContractFileServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private FileUploader fileUploader;
       private ServletFileUpload uploader;
       private ServletContext context;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadContractFileServlet02() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() {
    	context = getServletContext();
    	uploader = new ServletFileUpload();
    	fileUploader = new FileUploader(context, uploader);
    	fileUploader.initialize();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fileUploader.setHttpServletRequest(request);
		fileUploader.uploadFile();
		String cttypeName = "";
		String filePath = fileUploader.getFilePath();
		String fileName = fileUploader.getFileName();
		
		request.setAttribute("message", "Upload file successfully!");
		response.sendRedirect("ManageContractServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

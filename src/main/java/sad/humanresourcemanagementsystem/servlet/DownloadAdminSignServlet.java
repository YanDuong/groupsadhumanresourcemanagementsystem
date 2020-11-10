package sad.humanresourcemanagementsystem.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sad.humanresourcemanagementsystem.model.Signature;
import sad.humanresourcemanagementsystem.service.SignatureService;

/**
 * Servlet implementation class DownloadAdminSignServlet
 */

@WebServlet(name = "DownloadAdminSignServlet", urlPatterns = "/DownloadAdminSignServlet")
public class DownloadAdminSignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadAdminSignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mess = "";
		try {
		int id = Integer.parseInt(request.getParameter("id"));			
		Signature signature = new SignatureService().getSignatureByContractId(id);
		String adminFileDir =  signature.getAdminSignDirectory();
		if(adminFileDir.isEmpty()) {
			mess += "File not existed!";
		}
		String fileName = signature.getAdminFileName();
		File file = new File(adminFileDir);
		FileInputStream fis = new FileInputStream(file);		
		response.setContentType("image/jpeg");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");				
		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int numByteRead = -1;
		while((numByteRead  = fis.read(buffer)) > 0) 
		{
			os.write(buffer, 0, numByteRead);
		}			
		fis.close();
		os.close();
		if(mess.length() > 0) {
			request.setAttribute("error", mess);			
		}
		response.sendRedirect("ManageSignatureServlet");
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

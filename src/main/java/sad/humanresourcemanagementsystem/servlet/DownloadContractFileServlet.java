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

import sad.humanresourcemanagementsystem.model.Contract;

import sad.humanresourcemanagementsystem.service.ContractService;


/**
 * Servlet implementation class DownloadContractFileServlet
 */
@WebServlet(name = "DownloadContractFileServlet", urlPatterns = "/DownloadContractFileServlet")
public class DownloadContractFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadContractFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {			
			String mess = "";
			int id = Integer.parseInt(request.getParameter("id"));			
			Contract contract = new ContractService().getContractById(id);
			String fileDirectory = contract.getFileLocation();
			if(fileDirectory.isEmpty()) {
				mess += "File not existed!";
			}
			String fileName = contract.getFileName();
			File file = new File(fileDirectory);
			FileInputStream fis = new FileInputStream(file);		
			response.setContentType("application/msword");
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
				request.setAttribute("message", mess);			
			}
			response.sendRedirect("ManageContractServlet");
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

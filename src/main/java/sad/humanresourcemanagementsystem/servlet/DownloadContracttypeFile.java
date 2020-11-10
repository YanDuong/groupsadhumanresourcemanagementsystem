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

import sad.humanresourcemanagementsystem.model.ContractType;
import sad.humanresourcemanagementsystem.service.ContractTypeService;

/**
 * Servlet implementation class DownloadContracttypeFile
 */


@WebServlet(name = "DownloadContractTypeServlet", urlPatterns = "/DownloadContractTypeServlet")
public class DownloadContracttypeFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadContracttypeFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			int id = Integer.parseInt(request.getParameter("id"));
			ContractType type = new ContractTypeService().getContractTypeById(id);
			String fileDirectory = type.getFileLocation();
			String fileName = type.getFileName();
			System.out.println(fileDirectory);
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

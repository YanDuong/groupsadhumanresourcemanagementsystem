package sad.humanresourcemanagementsystem.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sad.humanresourcemanagementsystem.model.Contract;

import sad.humanresourcemanagementsystem.service.ContractService;



/**
 * Servlet implementation class UploadContractFileServlet
 */
@WebServlet(name = "UploadContractFileServlet", urlPatterns = "/UploadContractFileServlet")
public class UploadContractFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int SIZE_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAXIMUM_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAXIMUM_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    private ServletFileUpload uploader = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadContractFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void init() throws ServletException{
   		DiskFileItemFactory factory = new DiskFileItemFactory();
   		factory.setSizeThreshold(SIZE_THRESHOLD);
           // sets temporary location to store files
           factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
    
           ServletFileUpload upload = new ServletFileUpload(factory);
            
           // sets maximum size of upload file
           upload.setFileSizeMax(MAXIMUM_FILE_SIZE);
            
           // sets maximum size of request (include file + form data)
           upload.setSizeMax(MAXIMUM_REQUEST_SIZE);
   		File filesDir = (File) getServletContext().getAttribute("contractFile");
   		factory.setRepository(filesDir);
   		uploader = new ServletFileUpload(factory);
   	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = "";		
		String fileName = "";
		int id = 0;
		 if (!ServletFileUpload.isMultipartContent(request)) {
	           throw new ServletException("Request form is not correct!");
	        }			   		      
	    	  try {
	            // parses the request's content to extract file data		          
	            List<FileItem> formItems = uploader.parseRequest(request);		 
	            if (formItems != null && formItems.size() > 0) {
	                // iterates over form's fields
	                for (FileItem item : formItems) {
	                    // processes only fields that are not form fields
	                    if (!item.isFormField()) {
	                       fileName = new File(item.getName()).getName();	
	                        filePath = request.getServletContext().getAttribute("contractFileDir") + File.separator + fileName;
	                        File file = new File(filePath);		                      		 		                        // saves the file on disk
	                        item.write(file);                     
	                  
	                        request.setAttribute("message",
	                            "Upload has been done successfully!");
	                    }  else {
	                    	String name = item.getFieldName();
	                    	if(name.equals("id")) {
	                    		id = Integer.parseInt(item.getString());
	                    		System.out.println(id);
	                    	}
	                    }
	                }
	            }
	        } catch (Exception ex) {
	            request.setAttribute("message",
	                    "There was an error: " + ex.getMessage());
	        }
		System.out.print(filePath);
		Contract contract = new Contract();
		contract.setFileLocation(filePath);
		contract.setFileName(fileName);	
		contract.setId(id);
		new ContractService().insertContractFile(contract);
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

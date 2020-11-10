package sad.humanresourcemanagementsystem.servlet;


import java.io.File;
import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sad.humanresourcemanagementsystem.model.ContractType;

import sad.humanresourcemanagementsystem.service.ContractTypeService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class AddContractTypeServlet
 */

@WebServlet(name = "AddContractTypeServlet", urlPatterns = "/AddContractTypeServlet")
@MultipartConfig( fileSizeThreshold = 1024 * 10,  // 10 KB
        maxFileSize = 1024 * 300,       // 300 KB
        maxRequestSize = 1024 * 1024)
public class AddContractTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int SIZE_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAXIMUM_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAXIMUM_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    private ServletFileUpload uploader = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContractTypeServlet() {
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
		File filesDir = (File) getServletContext().getAttribute("cttFile");
		factory.setRepository(filesDir);
		uploader = new ServletFileUpload(factory);
	}
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String filePath = "";
		
			String fileName = "";
			 String cttypeName = "";
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
		                        filePath = request.getServletContext().getAttribute("cttFileDir") + File.separator + fileName;
		                        File file = new File(filePath);		                      		 		                        // saves the file on disk
		                        item.write(file);
		                     
		                      System.out.print("Contract type " + cttypeName);
		                        request.setAttribute("message",
		                            "Upload has been done successfully!");
		                    } else {
		                    	String fieldName = item.getFieldName();
		                    	if(fieldName.equals("contractTypeName")) {
		                    		cttypeName = item.getString();
		                    	}
		                		                    	
		                    }
		                }
		            }
		        } catch (Exception ex) {
		            request.setAttribute("message",
		                    "There was an error: " + ex.getMessage());
		        }
			System.out.print(filePath);
			new ContractTypeService().insertContractType(new ContractType(cttypeName, filePath, fileName));
			request.setAttribute("message", "Upload file successfully!");
			response.sendRedirect("ManageContractTypeServlet");
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

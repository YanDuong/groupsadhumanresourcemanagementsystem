package sad.humanresourcemanagementsystem.servlet;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploader {
	private ServletContext context;
	private ServletFileUpload uploader;
	private HttpServletRequest request;
	private String fileName;
	private String filePath;
	private static final int SIZE_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAXIMUM_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAXIMUM_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
public FileUploader(ServletContext context, ServletFileUpload uploader) {
	this.context = context;
	this.uploader = uploader;
}

public void setHttpServletRequest(HttpServletRequest request) {
	this.request = request;
}

public  void initialize() {
	DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(SIZE_THRESHOLD);
       // sets temporary location to store files
       factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

       ServletFileUpload upload = new ServletFileUpload(factory);
        
       // sets maximum size of upload file
       upload.setFileSizeMax(MAXIMUM_FILE_SIZE);
        
       // sets maximum size of request (include file + form data)
       upload.setSizeMax(MAXIMUM_REQUEST_SIZE);
		File filesDir = (File) context.getAttribute("contractFile");
		factory.setRepository(filesDir);
		uploader = new ServletFileUpload(factory);
}

public void uploadFile() throws ServletException {	 
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
                     this.fileName = new File(item.getName()).getName();	
                      this.filePath = request.getServletContext().getAttribute("contractFileDir") + File.separator + fileName;
                      File file = new File(filePath);		                      		 		                        // saves the file on disk
                      item.write(file);                                  
                      request.setAttribute("mess",
                          "Upload has been done successfully!");
                  } 
              }
          }
      } catch (Exception ex) {
          request.setAttribute("mess",
                  "There was an error: " + ex.getMessage());
      }
}

public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public String getFilePath() {
	return filePath;
}

public void setFilePath(String filePath) {
	this.filePath = filePath;
}




}

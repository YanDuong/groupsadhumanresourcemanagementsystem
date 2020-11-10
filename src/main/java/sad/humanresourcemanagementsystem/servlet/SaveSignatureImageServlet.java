package sad.humanresourcemanagementsystem.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import sad.humanresourcemanagementsystem.model.Signature;
import sad.humanresourcemanagementsystem.service.ContractService;
import sad.humanresourcemanagementsystem.service.SignatureService;

/**
 * Servlet implementation class SaveSignatureImageServlet
 */

@WebServlet(name = "SaveSignatureImageServlet", urlPatterns = "/SaveSignatureImageServlet")
public class SaveSignatureImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int ADMIN_SIGNED = 1;

   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveSignatureImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		try {		
			String signer = request.getParameter("signer");
			int id = Integer.parseInt(request.getParameter("id"));
			String image = request.getParameter("image").trim().replace("data:image/png;base64,", "");			
			String fileName =  "administrator " + signer +  ".png";
			byte[] bytes = DatatypeConverter.parseBase64Binary(image);
			String directory = request.getServletContext().getAttribute("adminSignFileDir") + File.separator + fileName;
			Path path = Paths.get(directory);
			Files.write(path,  bytes);
			Signature signature = new Signature();
			signature.setUserName(signer);
			signature.setAdminSignDirectory(directory);
			signature.setAdminFileName(fileName);
			signature.setContractId(id);
			
			if(new SignatureService().insert(signature)) {
				new ContractService().updateAdminSign(ADMIN_SIGNED, id);
				message += "Upload signature successfully!";
			} else {
				message += "Upload signature failed!";
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		response.sendRedirect("ManageSignatureServlet");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

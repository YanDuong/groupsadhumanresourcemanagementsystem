package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sad.humanresourcemanagementsystem.model.Contract;
import sad.humanresourcemanagementsystem.service.ContractService;

/**
 * Servlet implementation class ManageSignatureServlet
 */

@WebServlet(name="ManageSignatureServlet", urlPatterns="/ManageSignatureServlet")
public class ManageSignatureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageSignatureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		try {
			List<Contract> list = new ContractService().getEmployeeContractList();
			if(list.isEmpty()) {
				error += "There is no signature!";
			} else {
				request.setAttribute("list", list);
			}
			if(error.length() > 0) {
				request.setAttribute("error", error);
			}
			request.getRequestDispatcher("admin_manage_signature.jsp").forward(request, response);
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

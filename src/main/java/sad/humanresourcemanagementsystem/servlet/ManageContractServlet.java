package sad.humanresourcemanagementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sad.humanresourcemanagementsystem.model.ContractInfo;
import sad.humanresourcemanagementsystem.model.ContractType;
import sad.humanresourcemanagementsystem.model.Staff;
import sad.humanresourcemanagementsystem.service.ContractService;
import sad.humanresourcemanagementsystem.service.ContractTypeService;
import sad.humanresourcemanagementsystem.service.StaffService;

import java.util.List;
/**
 * Servlet implementation class ManageContractServlet
 */
@WebServlet(name = "ManageContractServlet", urlPatterns = "/ManageContractServlet")
public class ManageContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageContractServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		List<ContractInfo> list = new ContractService().getContractInforList();
		List<Staff> staffs = new StaffService().getStaffsWithoutContract();
		List<ContractType> contracttypeList = new ContractTypeService().getContractTypeList();
		request.setAttribute("list", list);
		request.setAttribute("staffs", staffs);
		request.setAttribute("contracttypeList", contracttypeList);
		request.getRequestDispatcher("admin_manage_contract.jsp").forward(request, response);
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

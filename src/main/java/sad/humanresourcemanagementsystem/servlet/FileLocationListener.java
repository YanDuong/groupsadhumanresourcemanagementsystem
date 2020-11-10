package sad.humanresourcemanagementsystem.servlet;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class FileLocationListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String rootPath = System.getProperty("catalina.home");
		ServletContext context = sce.getServletContext();
		String ctRelativePath = context.getInitParameter("contracttype.directory");
		String contractRelativePath = context.getInitParameter("contract.directory");
		String adminSignaturePath = context.getInitParameter("adminsignature.directory");
		String staffSignaturePath = context.getInitParameter("staffsignature.directory");
		File file1 = new File(rootPath + File.separator + ctRelativePath);
		if(!file1.exists()) {
			file1.mkdirs();		
		}
		File file2 = new File(rootPath + File.separator + contractRelativePath);
		if(!file2.exists()) {
			file2.mkdirs();		
		}
		
		File adminSignatureFile = new File(rootPath + File.separator + adminSignaturePath);
		if(!adminSignatureFile.exists()) {
			adminSignatureFile.mkdirs();		
		}
		
		File staffSignatureFile = new File(rootPath + File.separator + staffSignaturePath);
		if(!staffSignatureFile.exists()) {
			staffSignatureFile.mkdirs();		
		}
		context.setAttribute("cttFile", file1);
		context.setAttribute("contractFile", file2);
		context.setAttribute("adminSignFile", adminSignatureFile);
		context.setAttribute("staffSignFile", staffSignatureFile);
		context.setAttribute("cttFileDir", rootPath + File.separator + ctRelativePath);
		context.setAttribute("contractFileDir", rootPath + File.separator + contractRelativePath);
		context.setAttribute("adminSignFileDir", rootPath + File.separator + adminSignaturePath);
		context.setAttribute("staffSignFileDir", rootPath + File.separator + staffSignaturePath);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}

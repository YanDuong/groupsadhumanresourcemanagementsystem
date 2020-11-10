<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Signature</title>
 <jsp:include page = "admin_resources.jsp"></jsp:include>
<script src='resources/js/jquery.js' type='text/javascript'></script>
<script src="resources/js/jSignature.min.js"></script>
<script src="resources/js/modernizr.js"></script>
 <script type="text/javascript" src="resources/js/flashcanvas.js"></script>
</head>
<body>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<div style="width:80%;margin:auto">
		<table class="table table-bordered" id="myTable">
            <thead>
                <tr class="ex">
                    <th>Employee Code</th>
                    <th>Full name</th>
                    <th>Contract Type</th>
                    <th>Start Day</th>
                    <th>End Day</th>
                     <th>Salary Per Hours</th>
                      <th>Base Salary</th>
                    <th>Staff Sign</th>
                    <th>Admin Sign</th>
                    <th>View</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="contract" items="${list}">
            <tr>
			 <td style="text-align: center">
                                        <c:out value="${contract.employeeCode}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                        <c:out value="${contract.fullname}" />
                                    </td>
                                     <td style="text-align: center; color: black">
                                        <c:out value="${contract.getType().getName()}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                    <fmt:formatDate value="${contract.startDate}" pattern="dd-MMM-yyyy" />
                                    </td>                                                  
                                    <td style="text-align: center; color: black">
                                    <fmt:formatDate value="${contract.endDate}" pattern="dd-MMM-yyyy" />
                                    </td>                                    
                                     <td style="text-align: center; color: black">
                                        <c:out value="${contract.salaryHour}" />
                                    </td>      
                                    <td style="text-align: center; color: black">
                                        <c:out value="${contract.baseSalary}" />
                                    </td>   
                                  
                                      <td style="text-align: center; color: black">
                                        <c:if test="${contract.staffSign == 0}">
                                      No
                                        </c:if>
                                         <c:if test="${contract.staffSign != 0}">
                                      <a href="DownloadStaffSignServlet?id=<c:out value='${contract.id}' />" class="btn btn-outline-primary btn-sm m-0 waves-effect"><i class = "material-icons">&#xE147;</i>Download </a>
                                        </c:if>
                                    </td>    
                                     <td style="text-align: center; color: black">
                                      <c:if test="${contract.adminSign == 0}">
                                   <a href="CreateAdminSignServlet?id=<c:out value='${contract.id}' />" class="btn btn-outline-primary btn-sm m-0 waves-effect"><i class = "material-icons">&#xE147;</i>Sign Contract</a>       
                                    </c:if>
                                    <c:if test="${contract.adminSign != 0}">
                                  <a href="DownloadAdminSignServlet?id=<c:out value='${contract.id}' />" class="btn btn-outline-primary btn-sm m-0 waves-effect"><i class = "material-icons">&#xE147;</i>Download</a>
                                    </c:if>                                
                                    </td>                                                                                                            
                    <td style = "white-space: nowrap; margin:auto;width:fit-content">                                                                                                                              
                    </td>
                    </tr>
                    </c:forEach>
            </tbody>
        </table>
</div>
                </body>
<jsp:include page = "admin_footer.jsp"></jsp:include>
</html>
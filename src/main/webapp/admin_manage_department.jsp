<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department</title>
 <jsp:include page = "admin_resources.jsp"></jsp:include>
 <script>
    var element = document.getElementById("managestaff");
  element.classList.add("activemenu");
    </script>
</head>
<body>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<c:if test="${error != null}">
 <p style ="color:red"> <c:out value="${error}" /></p>
 </c:if> 
<c:if test="${message != null}">
 <p style ="color:green"> <c:out value="${message}" /></p>
 </c:if>
<div style="width:50%;float:left">

        <table class="table table-bordered" id="myTable">
            <thead>
            <h4>List User with Department</h4>
                <tr class="ex">
                    <th>Employee Code</th>
                    <th>Name</th>
					<th>Department</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach var="departmentInfo" items="${departmentInfoList}">
               <tr>
                  <td style="text-align: center">
                                        <c:out value="${departmentInfo.employeeCode}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                        <c:out value="${departmentInfo.employeeName}" />
                                    </td>
                                     <td style="text-align: center; color: black">
                                        <c:out value="${departmentInfo.name}" />
                                    </td>                                                                                                                      
                          </tr> 
                       </c:forEach> 
            </tbody>
        </table>
		</div>
		<div id="pageNavPosition" class="text-right" style="float:left;">
		<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
   Add New Department
  </button>
  <div class="collapse" id="collapseExample">
  <div class="card card-body">
    <form class="form-inline" action="AddDepartmentServlet" method="post">
  <div class="form-group mx-sm-3 mb-2">
    <input type="text" class="form-control" name="name" placeholder="Name">
  </div>
  <button type="submit" name="addrt" class="btn btn-primary mb-2">Add</button>
</form>
  </div>
</div>
		</div>
		<div style="width:40%;float:right">
		<b>List Department</b>
		<table class="table table-bordered">
            <thead>
                <tr class="ex">
                    <th>Name</th>
					<th>Change</th>
                </tr>
            </thead>
            <tbody>
			  <c:forEach var="department" items="${departments}">
               <tr>
                  <td style="text-align: center">
                                        <c:out value="${department.name}" />
                                    </td>                                                                                                                                                                 
                  <td>
                        <a href="EditDepartmentFormServlet?id=<c:out value='${department.id}'/>"><i class="fas fa-pencil-alt"></i> &nbsp;&nbsp;</a>
                        <a href="RemoveDepartmentServlet?id=<c:out value='${department.id}' />" onclick="return confirm('Are you sure you want to delete this item?');"> <i class="fas fa-trash"></i></a>
                    </td>
                          </tr> 
                       </c:forEach> 
            </tbody>
        </table>
		<b>Modified Department</b>
		<form class="form-inline" method="POST">
  <div class="form-group mx-sm-3 mb-2">
    <input type="text" class="form-control" name="namedepartment" placeholder="Department name">
  </div>
  <button type="submit" name="adddepartment" class="btn btn-primary mb-2">Add</button>
</form>	
        <b>Set Department to user</b>   
        <form class="form-inline" method="POST">
  <div class="form-group mx-sm-3 mb-2">
   <select name="employeeCode" class="form-control">
 			 <c:forEach var="staff" items="${staffs}">
 			 <label>Select Staff By Employee Code</label>
  				  <c:if test="${!staff.employeeCode.isEmpty()}">
   					 <option selected> <c:out value="${staff.employeeCode}" /></option> 
    		  </c:if>  
    		 </c:forEach>       
  			</select>          
  <select name="departmentName" class="form-control">
 			 <c:forEach var="department" items="${departments}">
 			 <label>Select Department</label>
  				  <c:if test="${!department.name.isEmpty()}">
   					 <option selected> <c:out value="${department.name}" /></option> 
    		  </c:if>  
    		 </c:forEach>       
  			</select>          
  </div>
  <button type="submit" name="setdepartment" class="btn btn-primary mb-2">Add</button>
</form> 
</div>
 <jsp:include page = "admin_content_footer.jsp"></jsp:include>  
</body>
                <script type="text/javascript">
                    var pager = new Pager('myTable', 5);
                    pager.init();
                    pager.showPageNav('pager', 'pageNavPosition');
                    pager.showPage(1);
                </script>
               
<jsp:include page = "admin_footer.jsp"></jsp:include>

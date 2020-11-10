<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MANAGE STAFF</title>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="ADMIN PAGE SIDEBAR">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <jsp:include page = "admin_resources.jsp"></jsp:include>  
</head>
<body>
  <jsp:include page = "admin_content_header.jsp"></jsp:include>
		<div class="card card-cascade narrower">
		<c:if test="${error != null}">
 <p style ="color:red"> <c:out value="${error}" /></p>
 </c:if> 
<c:if test="${message != null}">
 <p style ="color:green"> <c:out value="${message}" /></p>
 </c:if>
  <div class="view view-cascade gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">
	<h2>
	Manage <b>Staff</b>
	</h2>
		 <div class="col">
              <a href="NewStaffFormServlet" class="btn btn-outline-primary btn-sm m-0 waves-effect"><i class = "material-icons">&#xE147;</i> <span>Add New Staff</span></a>             
            </div> 
            <div class = "col-sm-6">
            	 <form class="form-inline my-2 my-lg-0" action="SearchStaffServlet" method = "POST">
      					<input class="form-control mr-sm-2" type="search" name = "search" placeholder="Search" aria-label="Search">
     					 <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
   				 </form>
            </div>         
            </div>  
            <div class="card-body">       

    <div class="table-wrapper">
        <table class="table table-bordered" id="myTable">
            <thead>
                <tr class="ex">
                    <th>Staff Code</th>
                    <th>Full Name</th>
					<th>Department</th>
                    <th>Gender</th>                   
					<th style="width:200px">Email</th>
					<th>Phone</th>
					<th>Date Of Birth</th>
					<th>Address</th>
					<th>Status Marriage</th>
					<th>Necessary Contact</th>
					<th>Graduate Insutitution</th>
					<th>Major</th>
					<th>Degree</th>
					<th>Gratduate Year</th>
					<th>Oversea education</th>
					<th>Setting</th>
                </tr>
            </thead>
            <tbody>
              <c:forEach var="staff" items="${staffs}">
                <tr>
                  <td style="text-align: center">
                                        <c:out value="${staff.getEmployeeCode()}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                        <c:out value="${staff.getFullName()}" />
                                    </td>
                                    <td style="text-align: center; color: green">
                                        <c:out value="${staff.departmentName}" />
                                    </td>
                                    <td style="text-align: center; color: red">
                                        <c:out value="${staff.sex}" />
                                    </td>
                                     <td style="text-align: center; color: green">
                                        <c:out value="${staff.email}" />
                                    </td>
                                     <td style="text-align: center; color: red">
                                        <c:out value="${staff.phone}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                    <c:out value = "${staff.dateOfBirth}"/>
                                    </td>
                                    <td style="text-align: center; color: green">
                                    <c:out value = "${staff.address}"/>
                                    </td>
                                     <td style="text-align: center; color: green">
                                    <c:out value = "${staff.marriageStatus}"/>
                                    </td>
                                    <td style="text-align: center; color: red">
                                    <c:out value = "${staff.contact}"/>
                                    </td>
                                    <td style="text-align: center; color: red">
                                    <c:out value = "${staff.graduateInstitution}"/>
                                    </td>
                                    <td style="text-align: center; color: red">
                                    <c:out value = "${staff.major}"/>
                                    </td>
                                    <td style="text-align: center; color: red">
                                    <c:out value = "${staff.degree}"/>
                                    </td>
                                    <td style="text-align: center; color: red">
                                    <c:out value = "${staff.graduateYear}"/>
                                    </td>
                                      <td style="text-align: center; color: red">
                                    <c:out value = "${staff.overseaEducation}"/>
                                    </td>
                    <td>
                        <a href="EditStaffFormServlet?id=<c:out value='${staff.id}'/>"><i class="fas fa-pencil-alt"></i> &nbsp;&nbsp;</a>
                        <a href="RemoveStaffServlet?id=<c:out value='${staff.id}' />" onclick="return confirm('Are you sure you want to delete this item?');"> <i class="fas fa-trash"></i></a>
                    </td>
            

                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
        </div>
		</div>

			
                
			
     <jsp:include page = "admin_content_footer.jsp"></jsp:include>
</body>
<jsp:include page = "admin_footer.jsp"></jsp:include>
</html>
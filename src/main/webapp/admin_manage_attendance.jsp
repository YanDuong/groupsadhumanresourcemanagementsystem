<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Attendance</title>
 <link rel="stylesheet" href="resources/attendance_circle.css">
 <jsp:include page = "admin_resources.jsp"></jsp:include>

</head>
<body>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<script>
$(function () {
	  $("#datepicker").datepicker({ 
	        autoclose: true, 
	        todayHighlight: true
	  }).datepicker('update', new Date());
	});
</script>
<%
java.sql.Date sqlDate = null;
java.util.Date utilDate = new java.util.Date();
SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
formatter.format(utilDate);
sqlDate = new java.sql.Date(utilDate.getTime());
System.out.println(sqlDate);
%>
<div class="container">
    <div class="row">
        <div class="col-md-6 mx-auto">
          
            <div class="form-group mb-4">
             <form action="ManageAttendanceServlet" method="post" id="manageAttendance">    
                <label>Get Attendance By Date: </label>    
				<div id="datepicker" class="input-group date" data-date-format="mm-dd-yyyy">
   					 <input class="form-control" type="text" value="<c:out value='${date}' />" name = "selectedDate"/>
   				 <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
   				 </div>
   				 <div style = "display: flex; justify-content: flex-end">
				<button type="submit" class="btn btn-outline-success" style="margin-top:10px">Get</button>	
				</div>	
				</form>			
            </div>
        </div>
    </div>
</div>
<div class ="row"> 
<div class="player">
  <div class="progress">
    <div class="right-side"></div>
    <div class="left-side" style="transform: rotate(189deg)"></div>
  </div>
  <div class="player-text" style="color:red"><c:out value="${nonWorkingNumber}" /></div>
</div> 
<div class="player">
  <div class="player-icon"></div>
  <div class="progress">
    <div class="right-side"></div>
    <div class="left-side" style="transform: rotate(189deg)"></div>
  </div>
  <div class="player-text" style="color:green"><c:out value="${totalStaffNumber}" /></div>
</div>
<div class="player">
  <div class="player-icon"></div>
  <div class="progress">
    <div class="right-side"></div>
    <div class="left-side" style="transform: rotate(189deg)"></div>
  </div>
  <div class="player-text" style="color:blue"><c:out value="${workingNumber}" /></div>
</div>
    </div> 
        <table class="table table-bordered" id="attendanceTable" style="width:50%;float:left">	
            <thead>
			<tr class="ex">
				<th colspan="3">Staff in work</th>
			</tr>
                <tr class="ex">
                 	<th>Staff Code</th>
                    <th>Full name</th>
					<th>Department</th>				
                </tr>
            </thead>

            <tbody>
<c:forEach var="workingStaff" items="${workingList}">
               <tr>
                  <td style="text-align: center">
                                        <c:out value="${workingStaff.employeeCode}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                        <c:out value="${workingStaff.staffName}" />
                                    </td>
                                     <td style="text-align: center; color: black">
                                        <c:out value="${workingStaff.departmentName}" />
                                    </td>
                                 
                                                                                                                                                                                            
                          </tr> 
                       </c:forEach>      
            </tbody>
        </table>
		
        <table class="table table-bordered" id="myTable" style="width:50%;float:left">	
            <thead>
				<tr class="ex">
					<th colspan="3">Staff Offline</th>
				</tr>
                <tr class="ex">
                	<th>Staff Code</th>
                    <th>Full name</th>
					<th>Department</th>
					
                </tr>
            </thead>
            <tbody>
			<c:forEach var="nonWorkingStaff" items="${nonWorkingList}">
               <tr>
                  <td style="text-align: center">
                                        <c:out value="${nonWorkingStaff.employeeCode}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                        <c:out value="${nonWorkingStaff.staffName}" />
                                    </td>
                                     <td style="text-align: center; color: black">
                                        <c:out value="${nonWorkingStaff.departmentName}" />
                                    </td>
                                 
                                                                                                                                                                                                 
                          </tr> 
                       </c:forEach>      
            </tbody>
        </table>
        </body>
<jsp:include page="admin_footer.jsp"></jsp:include>
</html>

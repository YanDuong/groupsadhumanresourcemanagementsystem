<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Staff</title>
<jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>
<script>
$('.datepicker').pickadate();
</script>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
         <c:if test="${staff != null}">
            <form action="UpdateStaffServlet" method="post" id="updateprofile">
                </c:if>
                <c:if test="${staff == null}">
                <form action="AddStaffServlet" method="post" id="updateprofile">
                    </c:if>
                    <caption>
                        <h2>
                            <c:if test="${staff != null}">
                                Edit Staff
                            </c:if>
                            <c:if test="${staff == null}">
                                Add New Staff
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${staff != null}">
                        <input type="hidden" name="id" value="<c:out value='${staff.id}' />" />
                    </c:if>		           
                <div class="form-group">  
                <select name="departmentName" class="form-control">
 			 <c:forEach var="department" items="${departments}"> 			
  				  <c:if test="${!department.name.isEmpty()}">
   					 <option selected> <c:out value="${department.name}" /></option> 
    		  </c:if>  
    		 </c:forEach>       
  			</select>                                               
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="first_name">Full name</label>
                              <input type="text"  value="<c:out value='${staff.fullName}' />" class="form-control" name="fullname" id="fullname">
                          </div>
                      </div>
                      <div class="form-group">  
               			<select name="role" class="form-control">
 							 <c:forEach var="role" items="${roles}"> 			 								 
   					 				<option selected> <c:out value="${role}" /></option>     		  					  
    		 				</c:forEach>       
  						</select>                                               
                      </div>
                       <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="first_name">Status</label>
                              <input type="number"  value="<c:out value='${staff.status}' />" class="form-control" name="status" id="status">
                          </div>
                      </div>
                     <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="employee_cde">Employee Code</label>
                              <input type="text"  value="<c:out value='${staff.employeeCode}' />" class="form-control" name="employeeCode" id="employeeCode">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="employee_cde">CMND</label>
                              <input type="text"  value="<c:out value='${staff.cmnd}' />" class="form-control" name="cmnd" id="cmnd">
                          </div>
                      </div>
                                <div class="form-group">       
                          <div class="col-xs-6">
                              <label for="date">Date Of Birth</label>
                              <input type="text"  value="<c:out value='${staff.dateOfBirth}' />" placeholder="Day/Month/Year" class="form-control" name="dob" id="dob">
                          </div>
                                   </div>                   			 
                      <div class="form-group">                     
                          <div class="col-xs-6">
                            <label for="last_name">Sex</label>
                              <select id="sex" name="sex" class="form-control">
								<option value="0">Male</option>
								<option value="1">Female</option>
							  </select>
                          </div>
                      </div>
                      <div class="form-group">                       
                          <div class="col-xs-6">
                              <label for="text">Status Marriage</label>
                              <select id="sm1" class="form-control" name="statusMarriage">
								<option value="0">Married</option>
								<option value="1">Not married</option>
							  </select>
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email">Email</label>
                              <input type="email" class="form-control" name="email"  value="<c:out value='${staff.email}' />" id="email">
                          </div>
                      </div>
          
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label for="phone">Phone</label>
                              <input type="phone" class="form-control" name="phone"  value="<c:out value='${staff.phone}' />" id="phone">
                          </div>
                      </div>
                      
                      <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="address">Address</label>
                              <input type="text" class="form-control" name="address"  value="<c:out value='${staff.address}' />" id="address">
                          </div>
                      </div>
					  
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="nc">Necessary contact</label>
                              <input type="text" class="form-control" name="contact"  value="<c:out value='${staff.contact}' />" id="contact" >
                          </div>
                      </div>
                      <div class="form-group">                       
                          <div class="col-xs-6">
                              <label for="text">Activity</label>
                              <select id="sm1" class="form-control" name="activity">
								<option value="0">0</option>
								<option value="1">1</option>
							  </select>
                          </div>
                      </div>
                      
                      <div class="form-group">                       
                          <div class="col-xs-6">
                              <label for="text">Profile Status</label>
                              <select id="sm1" class="form-control" name="profileStatus">
								<option value="0">0</option>
								<option value="1">1</option>
							  </select>
                          </div>
                      </div>
                           <div class="form-group">
                          <div class="col-xs-6">
                            <label for="gi">Graduate institution</label>
                              <input type="text" class="form-control" name="graduateInstitution"  value="<c:out value='${staff.graduateInstitution}' />" id="gi">
                          </div>
                      </div>
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="major">Major</label>
                              <input type="text" class="form-control" name="major"  value="<c:out value='${staff.major}' />" id="major">
                          </div>
                      </div>					  
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="gy">Graduate Year</label>
                              <input type="text" class="form-control" name="graduateYear"  value="<c:out value='${staff.graduateYear}' />" id="gy">
                          </div>
                      </div>
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="oe">Oversea education</label>
                              <input type="text" class="form-control" name="overseaEducation"  value="<c:out value='${staff.overseaEducation}' />" id="oe">
                          </div>
                      </div>
					<div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="ra">Certificate of degree</label>
                              <select class="form-control" name="degree" id="cod">
								<option value="0">University</option>
								<option value="1">College</option>
								<option value="2">TC</option>
								<option value="3">THPT</option>
							  </select>
                          </div>
                      </div>                                 
              			<div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button type="submit" class="btn btn-outline-success" onclick="validate()">Save</button>
                              	 <button class="btn btn-outline-danger" onclick="window.location.href='request.getContextPath()/ManageStaffServlet'">Cancel</button>
                            </div>
                      </div>              
                      	</form>
                      	 </div>
                      	  </div>
                      </div>     
                      <script>
	function validate()
	{
		swal({
  title: "Are you sure?",
  text: "",
  type: "info",
  showCancelButton: true,
  confirmButtonClass: "btn-success",
  confirmButtonText: "Yes",
  closeOnConfirm: false
},
function(){
  swal("Done!", "", "success");document.getElementById("updateprofile").submit();
	});}
	</script>
	
	 <jsp:include page = "admin_content_footer.jsp"></jsp:include>
</body>
</html>
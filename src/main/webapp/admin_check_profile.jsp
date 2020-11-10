<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sad.humanresourcemanagementsystem.service.StaffService" %>
<%@ page import="sad.humanresourcemanagementsystem.model.Staff" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>

<script>
    var element = document.getElementById("check");
  element.classList.add("activemenu");
    </script>
        <b>Staff was confirm</b><Br>
        <%
    StaffService service = null;
    try {
    	service = new StaffService();
    } catch(Exception e) {
    	e.printStackTrace();
    }     
    assert service != null;
   List<Staff> staffList1 = service.getStaffsByProfileStatus(2);
 
    if (staffList1 != null) {
        for (Staff staff : staffList1) {%>
        <table class="table table-bordered" id="myTable" style="width:50%;float:left">
            <thead>
                <tr class="ex">
                    <th>User name</th>
                    <th>Full name</th>
                    <th>Sex</th>
                    <th>Email</th>
					<th>Phone</th>
					<th>Confirm</th>
                </tr>
            </thead>
            <tbody>
            <tr>		
                                    <td style="text-align: center; color: green">
                                       <%=staff.getFullName()%> /> 
                                    </td>
                                     <td style="text-align: center; color: green">
                                       <c:out value="<%=staff.getSex()%>" />
                                    </td>
                                      <td style="text-align: center; color: green">
                                        <c:out value="<%=staff.getEmail()%>" />
                                    </td>
                                      <td style="text-align: center; color: green">
                                         <c:out value="<%=staff.getPhone()%>" />
                                    </td>
                                    </tr>
            </tbody>
        </table>
        <%
    }
} else {%>
No staff exists!
<%
    }
%>
        
		<div id="pageNavPosition" class="text-right" style="float:left;"></div>
		 <%
   List<Staff> staffList2 = service.getStaffsByProfileStatus(1);
 
    if (staffList2 != null) {
        for (Staff staff : staffList2) {%>
		<table class="table table-bordered" id="cflistuser" style="width:40%;float:right">
            <thead>
                <tr class="ex">
                    <th width="auto">User name</th>
                    <th width="auto">Full name</th>
                      <th width="auto">Sex</th>
                        <th width="auto">Email</th>
                          <th width="auto">Phone</th>
					<th>Address</th>
                    <th width="5px; !important">Check profile</th>
                </tr>
            </thead>
            <tbody>
             
                <tr>
	
                                    <td style="text-align: center; color: green">
                                        value="<%=staff.getFullName()%>"
                                    </td>
                                   <%
                                   if(staff.getSex() == 0) 
                                   %>
            						<td>Female</td>
                					 <%
                					 else {
                                   %> 
              						 <td>Male</td>
                    				 <%
                					 }
                                   %> 
                                     <td style="text-align: center; color: green">
                                        value="<%=staff.getEmail()%>" 
                                    </td>
                                      <td style="text-align: center; color: green">
                                        value="<%=staff.getPhone()%>
                                    </td>
                                      <td style="text-align: center; color: green">
                                       value="<%=staff.getAddress()%>
                                    </td>
                                    <td>
                                    <form method="POST">
                                    <input type="hidden" name="idstaff"  value="<%=staff.getId()%>"></input>
					<button type="submit" name="check" class="check" title="check" data-toggle="tooltip"><i class="fa fa-check-circle" aria-hidden="true"></i></button>
					</form></td>                              
                                    </tr>
                                                 
            </tbody>
        </table>
                        <%
    }
} else {%>
No staff exists!
<%
    }
%>
   
                
                
                
                <script type="text/javascript">
                    var pager = new Pager('myTable', 5);
                    pager.init();
                    pager.showPageNav('pager', 'pageNavPosition');
                    pager.showPage(1);
                </script>
                
		<div class="container bootstrap snippet">
    <div class="row" style="width:100%;float:left;display:none" id="profile">
  		<div class="col-sm-3"><!--left col-->    <p id="notifica"></p>       
      <div class="text-center">
	  <form class="form" method="post" id="updateprofile" enctype="multipart/form-data">
        <img src="resources/images/avatar_2x.png" id="img" class="avatar img-circle img-thumbnail" alt="avatar">
        </form>
      </div>
        </div><!--/col-3-->
    	<div class="col-sm-9">            
          <div class="tab-content">
            <div class="tab-pane active" id="home">
                <hr>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="first_name"><h4>Full name</h4></label>
                              <input type="text" class="form-control" name="fullname" id="fullname">
                          </div>
                      </div>
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email"><h4>Day of Birth</h4></label>
                              <input type="date" class="form-control" name="dob" id="dob">
                          </div>
                      </div>
                      <div class="form-group">                     
                          <div class="col-xs-6">
                            <label for="last_name" ><h4>Sex</h4></label>
                              <select id="sex" name="sex" class="form-control">
								<option value="0">Male</option>
								<option value="1">Female</option>
							  </select>
                          </div>
                      </div>
                      <div class="form-group">                       
                          <div class="col-xs-6">
                              <label for="text"><h4>Status Marriage</h4></label>
                              <select id="sm1" class="form-control" name="sm">
								<option value="0">Married</option>
								<option value="1">Not married</option>
							  </select>
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email"><h4>Email</h4></label>
                              <input type="email" class="form-control" name="email" id="email">
                          </div>
                      </div>
          
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label for="phone"><h4>Phone</h4></label>
                              <input type="phone" class="form-control" name="phone" id="phone">
                          </div>
                      </div>
                      
                      <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="address"><h4>Address</h4></label>
                              <input type="text" class="form-control" name="address" id="address">
                          </div>
                      </div>
					  <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="ra"><h4>Residential address</h4></label>
                              <input type="text" class="form-control" name="ra" id="ra">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="nc"><h4>Necessary contact</h4></label>
                              <input type="text" class="form-control" name="nc" id="nc" >
                          </div>
                      </div>
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="gi"><h4>Graduate institution</h4></label>
                              <input type="text" class="form-control" name="gi" id="gi">
                          </div>
                      </div>
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="major"><h4>Major</h4></label>
                              <input type="text" class="form-control" name="major" id="major">
                          </div>
                      </div>					  
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="gy"><h4>Graduate Year</h4></label>
                              <input type="text" class="form-control" name="gy" id="gy">
                          </div>
                      </div>
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="oe"><h4>Oversea education</h4></label>
                              <input type="text" class="form-control" name="oe" id="oe">
                          </div>
                      </div>
					<div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="ra"><h4>Certificate of degree</h4></label>
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
                              	<button class="btn btn-lg btn-success" onclick="confirm()"><i class="glyphicon glyphicon-ok-sign"></i> Confirm</button>
                            </div>
                      </div>
              <hr>
              	</form>
              
             </div><!--/tab-pane-->
          </div><!--/tab-content-->

        </div><!--/col-9-->
    </div><!--/row-->
	<script>
	function confirm(){
	document.getElementById("confirmform").submit();}
	</script>
	</div>

<jsp:include page = "admin_footer.jsp"></jsp:include>

</body>
</html>
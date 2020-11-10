<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Report type</title>
<jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>
<div class="container bootstrap snippet">
    <div class="row">
  		<div class="col-sm-3"><!--left col-->    <p id="notifica"></p>       
      <div class="text-center">
	  <form class="form" method="post" id="updateprofile" enctype="multipart/form-data">
        <img src="../../images/avatar_2x.png" id="img" class="avatar img-circle img-thumbnail" alt="avatar">
        <input type="file" name="avatar" id="avatar" accept=".jpg, .jpeg, .png" class="text-center center-block file-upload">
		<input type="hidden" name="currentavatar" id="currentavatar">
		</form>
      </div>
        </div><!--/col-3-->
    	<div class="col-sm-9">            
          <div class="tab-content">
            <div class="tab-pane active" id="home">
            <form>
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
                              <select class="form-control" name="sm" id="sm">
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
                          <div class="col-xs-12">
                             <label for="cmnd"><h4>CMND</h4></label>
                              <input type="phone" class="form-control" name="cmnd" id="cmnd">
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
              	</form>
                                    <div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button class="btn btn-lg btn-success" onclick="kiemtra()"><i class="glyphicon glyphicon-ok-sign"></i> Save</button>
                            </div>
                      </div>
              <hr>
              
             </div><!--/tab-pane-->
          </div><!--/tab-content-->

        </div><!--/col-9-->
    </div>
    </div>
    </body>
	<script>
	function kiemtra()
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
	</html>


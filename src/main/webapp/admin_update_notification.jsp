<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE NOTIFICATION</title>
<jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
                    <h4>Update Report</h4> 
                      <form action="UpdateNotificationServlet" method="post" id="updatenotification">
                        <input type="hidden" name="id" value="<c:out value='${notification.id}' />" />
                      <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Title</label>
                             <input type="text"  value="<c:out value='${notification.title}' />" class="form-control" name="title" id="title">
                          </div>
                      </div>	
                       <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="content">Content</label>
                              <textarea  class="form-control" name="content" id="content"><c:out value='${notification.content}' /></textarea>
                          </div>
                      </div>
                      <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Editor</label>
                              <input type="text" value="<c:out value='${notification.staffName}' />" class="form-control" name="staffName" id="staffName">
                          </div>
                      </div>		                    	                                                                                      
				<div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button type="submit" class="btn btn-outline-success" onclick="validate()">Save</button>
                              	 <button class="btn btn-danger" onclick="window.location.href='request.getContextPath()/ManageNotificationServlet'">Cancel</button>
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
  swal("Done!", "", "success");document.getElementById("updatenotification").submit();
	});}
	</script>
	<jsp:include page = "admin_content_footer.jsp"></jsp:include>
</body>
<jsp:include page = "admin_content_footer.jsp"></jsp:include>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE CONTRACT</title>
<jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="UpdateContractServlet" method="post" id="updateContract" enctype="multipart/form-data" >                   
                        <input type="hidden" name="id" value="<c:out value='${contracttype.id}' />" />
                    
                      <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Name</label>
                              <input type="text"  value="<c:out value='${contracttype.name}' />" class="form-control" name="name" id="name">
                          </div>
                      </div>
                      
                       <div class="form-group">
            <label for="message-text" class="col-form-label" >Select file</label>
            <input type="file" class="form-control" name="directory" accept=".doc, .docx">
          </div>			                                                                                      
				<div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button type="submit" class="btn btn-outline-success" onclick="validate()">Save</button>
                              	 <button class="btn btn-danger" onclick="window.location.href='/ManageReportTypeServlet'">Cancel</button>
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
 <jsp:include page = "admin_content_footer.jsp"></jsp:include>
</html>
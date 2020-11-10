<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Report</title>
<jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
         <c:if test="${type != null}">
            <form action="UpdateReportTypeServlet" method="post" id="updatereport">
                </c:if>
                    <caption>
                        <h2>
                            <c:if test="${report != null}">
                                Edit Report
                            </c:if>                       
                        </h2>
                    </caption>
                    <c:if test="${report != null}">
                        <input type="hidden" name="id" value="<c:out value='${report.id}' />" />
                    </c:if>
                      <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Title</label>
                              <input type="text"  value="<c:out value='${report.message}' />" class="form-control" name="message" id="message">
                          </div>
                      </div>	
                       <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Status</label>
                              <input type="text"  value="<c:out value='${report.status}' />" class="form-control" name="status" id="status">
                          </div>
                      </div>	                    	                                                                                      
				<div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button type="submit" class="btn btn-outline-success" onclick="validate()">Save</button>
                              	 <button class="btn btn-outline-danger" onclick="window.location.href='request.getContextPath()/ManageReportTypeServlet'">Cancel</button>
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
  swal("Done!", "", "success");document.getElementById("updatereport").submit();
	});}
	</script>
	<jsp:include page = "admin_content_footer.jsp"></jsp:include>
</body>
 <jsp:include page = "admin_content_footer.jsp"></jsp:include>
</html>
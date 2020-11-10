<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Report</title>
<jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>

<div class="well well-sm" style="border: 2px solid black; background: white;">
<div class="align-items-center justify-content-center">
        <div class="row">
           <div class="col-sm-12">
               <h4 style="text-align: center"><c:out value='${notification.title}' /></h4>
                <p>Posted by: <c:out value='${notification.staffName}' /></p>
               <p>Date Posted: <c:out value='${notification.date}' /></p>              
           </div>
        </div>       
        <div class="row">
            <div class="col-sm-12">                             
                    <span style="text-color:black"> 
                       <c:out value='${notification.content}' />
                    </span>                           
            </div>
        </div>    
        </div>
         <form method="post">   
		<c:if test="${notification.content != null}">                    					
					 <button type="button" style="float:left; margin-top:20px" data-toggle="collapse" data-target="#collapseExample2" aria-expanded="false" aria-controls="collapseExample1">UPDATE
					</button>
					 </c:if>
					  </form>
<div class="collapse" id="collapseExample2" style="margin-top:20px">
  <div class="card card-body">
    <label for="exampleFormControlTextarea1">Update Notification</label>
   <form action="UpdateNotificationServlet" method="post" id="updateprofile">                                                  
                        <input type="hidden" name="id" value="<c:out value='${notification.id}' />" />                   
                      <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Title</label>
                              <input type="text"  value="<c:out value='${notification.title}' />" class="form-control" name="title" id="message">
                          </div>
                      </div>	
                       <div class="form-group">                         
                          <div class="col-xs-6">
                             <div class="form-group shadow-textarea">
  <label for="exampleFormControlTextarea6">Content</label>
  <textarea class="form-control z-depth-1" name="content" id="exampleFormControlTextarea6" rows="10"><c:out value='${notification.content}' /></textarea>
</div>
                          </div>
                      </div>	                    	                                                                                      
				<div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button type="submit" class="btn btn-outline-success" onclick="validate()">Save</button>
                              	 <button class="btn btn-outline-danger" onclick="window.location.href='request.getContextPath()/ManageNotificationServlet'">Cancel</button>
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
</body>
</html>
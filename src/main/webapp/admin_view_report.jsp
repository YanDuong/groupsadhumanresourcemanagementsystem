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
               <h4 style="text-align: center"><c:out value='${report.title}' /></h4>
                <p>Posted by: <c:out value='${report.reporter}' /></p>
               <p>Date Posted: <c:out value='${report.date}' /></p>              
           </div>
        </div>       
        <div class="row">
            <div class="col-sm-12">                             
                    <span style="text-color:black"> 
                       <c:out value='${report.content}' />
                    </span>                           
            </div>
        </div>
        <p style="text-color:black"> Evaluation Message: <c:out value='${report.message}' /></p>    
               <p style="text-color:red"> Status: <c:out value='${report.status}' /></p>    
        </div>
         <form method="post">   
          <c:if test="${report.message == null}">                              					
					 <button type="button" style="float:left; margin-top:20px" data-toggle="collapse" data-target="#collapseExample1" aria-expanded="false" aria-controls="collapseExample1">EVALUATE
					</button>
					 </c:if>
		<c:if test="${report.message != null}">                    					
					 <button type="button" style="float:left; margin-top:20px" data-toggle="collapse" data-target="#collapseExample2" aria-expanded="false" aria-controls="collapseExample1">UPDATE
					</button>
					 </c:if>
					  </form>
		<div class="collapse" id="collapseExample1">
  <div class="card card-body">
    <label for="exampleFormControlTextarea1">Give Evaluation</label>
    <form action="AddReportEvaluationServlet" method="post">  
    
                        <input type="hidden" name="id" value="<c:out value='${report.id}' />" />              	
    <textarea name = "messageEvaluation" class="form-control" id="taEvaluation" rows="6"></textarea>
    	<button type="submit" style="float:right; margin-top:20px" class="btn btn-success" onclick="validate()">Save</button>
    	</form>
  </div>
</div>		
<div class="collapse" id="collapseExample2">
  <div class="card card-body">
    <label for="exampleFormControlTextarea1">Give Evaluation</label>
   <form action="UpdateReportServlet" method="post" id="updateprofile">                                                  
                        <input type="hidden" name="id" value="<c:out value='${report.id}' />" />                   
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
  swal("Done!", "", "success");document.getElementById("updateprofile").submit();
	});}
	</script>
</body>
</html>
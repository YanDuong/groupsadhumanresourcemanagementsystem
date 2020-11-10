<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<script>
$(function () {
	  $("#datepicker").datepicker({ 
	        autoclose: true, 
	        todayHighlight: true
	  }).datepicker('update', new Date());
	});
</script>		
		<div class = "table-title">
	<div class = "row">
	<div class = "col-sm-6">
	<h2>
	Manage <b>Contract</b>
	</h2>
	</div>
		 <div class="col-sm-6">
            <b>List Of Contract Type</b>           
            </div>  
 <c:if test="${mess != null}">
 <p style ="color:red"> <c:out value="${mess}" /></p>
 </c:if>  
  <c:if test="${message != null}">
 <p style ="color:red"> <c:out value="${message}" /></p>
 </c:if>        
</div>
		<table class="table table-bordered" id="myTable">
            <thead>
                <tr class="ex">
                    <th>Employee code</th>
                    <th>Full name</th>
                    <th>Contract Type</th>
                    <th>Start Day</th>
                    <th>End Day</th>
                    <th>Salary Per Hours</th>
                   <th>Base Salary</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
			<c:forEach var="ctInfo" items="${list}">
               <tr>
                  <td style="text-align: center">
                                        <c:out value="${ctInfo.employeeCode}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                        <c:out value="${ctInfo.fullName}" />
                                    </td>
                                     <td style="text-align: center; color: black">
                                        <c:out value="${ctInfo.ctName}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                    <fmt:formatDate value="${ctInfo.startDate}" pattern="dd-MMM-yyyy" />
                                    </td>                                                  
                                    <td style="text-align: center; color: black">
                                    <fmt:formatDate value="${ctInfo.endDate}" pattern="dd-MMM-yyyy" />
                                    </td>  
                                     <td style="text-align: center; color: black">
                                        <c:out value="${ctInfo.getHourSalary()}" />
                                    </td>       
                                    <td style="text-align: center; color: black">
                                        <c:out value="${ctInfo.baseSalary}" />
                                    </td>                                                                                                             
                    <td style = "white-space: nowrap; margin:auto;width:fit-content">
                     <c:if test="${ctInfo.fileLocation == null}">
                     <a href="UploadContractFileFormServlet?id=<c:out value='${ctInfo.id}' />" > <i class="fas fa-upload"></i></a>
                     </c:if>	
                     <c:if test="${ctInfo.fileLocation != null}">
                     <a href="DownloadContractFileServlet?id=<c:out value='${ctInfo.id}' />" > <i class="fas fa-download"></i></a>
                     </c:if>                   		                    		
                      <a href="RemoveContractServlet?id=<c:out value='${ctInfo.id}' />" onclick="return confirm('Are you sure you want to delete this item?');"> <i class="fas fa-trash"></i></a>				
                    </td>
                          </tr> 
                       </c:forEach>            
            </tbody>
        </table>   
        </div>  
       
    <div class="card">
    <div class="card-body">  
        <b>Add Contract</b> 
        <div class="card">
  <div class="card-body">
    <p class="card-text">
     <c:if test="${message != null}">
 		<p style ="color:green"> <c:out value="${message}" /></p>
 	 </c:if>
    </p>
  </div>
</div> 
 <div class="card">
  <div class="card-body">
    <p class="card-text">
     <c:if test="${error != null}">
 		<p style ="color:red"> <c:out value="${error}" /></p>
 	 </c:if>
    </p>
  </div>
</div> 
        <form action="AddContractServlet" method="POST" enctype="multipart/form-data">   
     <div class="form-group">                         
     <div class="col-xs-6">   
 		 <select name="staffName" class="form-control">
 		 <c:forEach var="staff" items="${staffs}">
  		<label>Select Staff</label>
  		  <c:if test="${!staff.fullName.isEmpty()}">
   			 <option selected> <c:out value="${staff.fullName}" /></option> 
      		</c:if>  
   		  </c:forEach>       
 		 </select> 
  <select name="cttName" class="form-control">
  		 <c:forEach var="contracttype" items="${contracttypeList}">
   				<label>Select Contract Type</label>
   		 <c:if test="${!contracttype.name.isEmpty()}">
   			 <option selected><c:out value="${contracttype.name}" /></option>
   		 </c:if>
  		 </c:forEach>
  </select>
  </div>
  </div>
    <div class="form-group">                         
     <div class="col-xs-6">   
  <label>OT Salary</label>
  <input type="text" name="hourSalary" placeholder="OT Salary" class="form-control"> 
  <label for="title">Base Salary</label>
  <input type="text" name="baseSalary" placeholder="Basic Salary" class="form-control">  
</div>
<div class="col-xs-6">   
   <div id="datepicker" class="input-group date" data-date-format="mm-dd-yyyy">
   <label>Start Date</label>
   					 <input class="form-control" type="text" placeholder = "Start Date" name = "startDate"/>
   				 <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				</div>
   <div id="datepicker" class="input-group date" data-date-format="mm-dd-yyyy">
  	 <label>End Date</label>
   				 <input class="form-control" type="text" placeholder = "End Date" name = "endDate"/>
   				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				</div>
 </div>
 </div>  
  <div class="form-group">
            <label for="message-text" class="col-form-label" >Select file</label>
            <input type="file" class="form-control" name="contractFile" accept=".doc, .docx">
          </div>   
  <div class="form-group">
                           <div class="col-xs-12">
 <button type="submit" name="setcontract" class="btn btn-primary mb-2">Add</button>
 </div>
 </div>
</form>
</div>
</div>


                 <jsp:include page = "admin_content_footer.jsp"></jsp:include>  
                </body>
                 <script type="text/javascript">
                    var pager = new Pager('myTable', 5);
                    pager.init();
                    pager.showPageNav('pager', 'pageNavPosition');
                    pager.showPage(1);
                </script>
<jsp:include page = "admin_footer.jsp"></jsp:include>

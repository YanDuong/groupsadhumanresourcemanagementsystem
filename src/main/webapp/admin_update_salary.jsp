<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update salary</title>
<jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
    <div class="card">
        <div class="card-body">
            <form action="UpdateEmployeeFeeServlet" method="post" id="updateEmployeeFee">                   
                        <input type="hidden" name="id" value="<c:out value='${employeeFee.id}' />" />                    
                      <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Employee Code</label>
                             <c:out value='${employeeFee.employeeCode}' />
                          </div>
                      </div>                      
                       <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Staff Name</label>
                             <c:out value='${employeeFee.staffName}' /> 
                          </div>
                      </div>                           
                       <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">KPI</label>
                              <input type="text"  value="<c:out value='${employeeFee.kpi}' />" class="form-control" name="kpi" id="name">
                          </div>
                      </div>  
                       <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Travel Fee</label>
                              <input type="text"  value="<c:out value='${employeeFee.travel}' />" class="form-control" name="travel" id="name">
                          </div>
                      </div>      
                       <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Equipment Fee</label>
                              <input type="text"  value="<c:out value='${employeeFee.equipment}' />" class="form-control" name="equipment" id="name">
                          </div>
                      </div>      
                       <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Reward</label>
                              <input type="text"  value="<c:out value='${employeeFee.bonus}' />" class="form-control" name="bonus" id="name">
                          </div>
                      </div>      
                       <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Inssurance Fee</label>
                              <input type="text"  value="<c:out value='${employeeFee.inssurance}' />" class="form-control" name="inssurance" id="name">
                          </div>
                      </div> 
                       <div class="form-group">                         
                          <div class="col-xs-6">                              
                                     <c:if test="${employeeFee.tax == 'no'}">                          
                                    <div class="form-check">
 									 <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..." name = "tax">
									</div>		
									</c:if>	
									<c:if test="${employeeFee.tax == 'yes'}">
									<div class="form-check">
      								<input class="form-check-input" type="checkbox" id="gridCheck" name = "tax">     					       
   									 </div>
									</c:if>			                                  
                          </div>
                      </div>      
                       <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Other</label>
                              <input type="text"  value="<c:out value='${employeeFee.other}' />" class="form-control" name="other" id="name">
                          </div>
                      </div>                                                                                              
				<div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button type="submit" class="btn btn-outline-success" onclick="validate()">Save</button>
                              	 <button class="btn btn-outline-danger" onclick="window.location.href='/ManageEmployeeFeeServlet'">Cancel</button>
                            </div>
                      </div>
                    	</form>	
                    	</div>	
                    	 </div>
                    
</body>
</html>
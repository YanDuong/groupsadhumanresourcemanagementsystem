<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Fee</title>
 <jsp:include page = "admin_resources.jsp"></jsp:include>
 <script>
   function setCookie(cname, cvalue, exdays) {
  var d = new Date();
  d.setTime(d.getTime() + (exdays*24*60*60*1000));
  var expires = "expires="+ d.toUTCString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
   var element = document.getElementById("grosssalary");
   element.classList.add("activemenu");
   </script>
   <style>
    table.table th:last-child{width:auto;}
    </style>

<style>
.btn-success:hover
{
    background-color:black;color:white;
}
 th, td{border:solid 2px black !important}

     .table>thead:first-child>tr:first-child>th
     {
        word-break:keep-all !important;height:70px;
     }
#myTable th
{
	vertical-align: middle;height:70px;
}
::-webkit-scrollbar{
  height:10px !important;
  background-color:#006bcf;
}
::-webkit-scrollbar-thumb {
  background: black !important; 
  border-radius: 0px !important;
}
#pageNavPosition{text-align:center}
td.fixedcolumn{height:70px;}
@media (min-width: 768px){
.col-sm-9 {
    width: 100%;
}}
		</style>
</head>
<body>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<div style="width:fit-content;margin:auto;height:50px">
  
</div>
<form class="form-inline" method="POST" action="ManageEmployeeFeeServlet">
 <label for="last_name" >Select month</label>
  <select id="month" name="month" class="form-control">
		<option value="01">January</option>
		<option value="02">February</option>
		<option value="03">March</option>
		<option value="04">April</option>
		<option value="05">May</option>
		<option value="06">June</option>
		<option value="07">July</option>
		<option value="08">August</option>
		<option value="09">Septemper</option>
		<option value="10">October</option>
		<option value="11">November</option>
		<option value="12">December</option>
  </select>  
  <button type="submit" class="btn btn-success">Get</button>
  </form>                              
        <div id="pageNavPosition" class="text-right" style="text-align:center;"></div><br/>
        <p style="text-align:center;font-size:25px;font-weight:600">GROSS SALARY OF STAFF</p>
        <div class="table-fixed-column-outter">
  <div class="table-fixed-column-inner">
        <table class="table table-bordered" style="width:100%;margin:auto">
            <thead>
                <tr class="ex">
                    <th style="background-color:white;color:black">Staff code</th>
                    <th style="left:0px;background-color:white;color:black">Staff Name</th>
                     <th style="background-color:white;color:green">Basic Salary (per day)</th>
                   <th style="background-color:white;color:green">OT Salary (per hour)</th>
                    <th style="background-color:white;color:green">KPI</th>
                    <th style="background-color:white;color:green">Travel</th>
                    <th style="background-color:white;color:green">Equipment</th>
                    <th style="background-color:white;color:green">Bounus</th>
                    <th style="background-color:white;color:red">Insurrance</th> 
                    <th style="background-color:white;color:red">Orther</th>
                    <th style="background-color:white;color:red">Tax</th>                 
                    <th style="background-color:white;color:black">Action</th>
                </tr>
            </thead>
            <tbody>   
               	<c:forEach var="employeeFee" items="${list}">
               <tr>
                  <td style="text-align: center">
                                        <c:out value="${employeeFee.employeeCode}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                       <c:out value="${employeeFee.staffName}" />
                                    </td>
                                     <td style="text-align: center; color: black">
                                         <c:out value="${employeeFee.basicSalary}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                      <c:out value="${employeeFee.hourSalary}" />
                                    </td>                                                  
                                 <td style="text-align: center; color: black">
                                      <c:out value="${employeeFee.kpi}" />
                                    </td>   
                                     <td style="text-align: center; color: black">
                                     <c:out value="${employeeFee.travel}" />
                                    </td>     
                                    <td style="text-align: center; color: black">
                                      <c:out value="${employeeFee.equipment}" />
                                    </td>     
                                      <td style="text-align: center; color: black">
                                      <c:out value="${employeeFee.bonus}" />
                                    </td>   
                                    <td style="text-align: center; color: black">
                                      <c:out value="${employeeFee.inssurance}" />
                                    </td>     
                                    <td style="text-align: center; color: black">
                                      <c:out value="${employeeFee.other}" />
                                    </td>   
                                     <td style="text-align: center; color: black">    
                                     <c:if test="${employeeFee.tax == 'no'}">                          
                                    <div class="form-check">
 									 <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="...">
									</div>		
									</c:if>	
									<c:if test="${employeeFee.tax == 'yes'}">
									<div class="form-check">
      								<input class="form-check-input" type="checkbox" id="gridCheck">     					       
   									 </div>
									</c:if>			
                                    </td>                                                                                                                                                                         
                    <td style = "white-space: nowrap; margin:auto;width:fit-content">                                   
                     <a href="UpdateEmployeeFeeServlet?id=<c:out value='${employeeFee.id}' />" > <i class="fas fa-pencil"></i></a>  
                      <a href="ViewEmployeeFeeServlet?id=<c:out value='${employeeFee.id}' />" > <i class="fas fa-eye"></i></a>                  		                    
                    </td>
                          </tr> 
                       </c:forEach>
            </tbody>
        </table>
                </div></div>
                </body>
        <script type="text/javascript">
                    var pager = new Pager('myTable', 5);
                    pager.init();
                    pager.showPageNav('pager', 'pageNavPosition');
                    pager.showPage(1);
                </script>
        <script>
        function sendmailsalary(data){
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.open("GET", "../sendmailsalary.jsp?data=" + data, true);
            xmlhttp.send();
            swal('Send success','','success');
        }
        </script>
<jsp:include page = "admin_footer.jsp"></jsp:include>
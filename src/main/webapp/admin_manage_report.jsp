<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page import="sad.humanresourcemanagementsystem.dao.ReportDAO" %>
<%@ page import="sad.humanresourcemanagementsystem.model.Report" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Report</title>
 <jsp:include page = "admin_resources.jsp"></jsp:include>
 <style>

<script src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>
<style>
.ck-editor__editable_inline {
    min-height: 300px;
}
</style>
</head>
<body>
<script>
    var element = document.getElementById("report");
  element.classList.add("activemenu");
    </script>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<div class = "column">
<div style="float:center;">
<b>List Of Reports</b>
        <table class="table table-bordered" id="ReportTable">     
            <thead>
                <tr class="ex">
                    <th style="width:50px">ID</th>
                    <th>Title</th>             
                    <th>Date</th>                                  
                    <th>Type</th>
                     <th>Reporter</th>
                     <th>Status</th>
					<th>Setting</th>
                </tr>
            </thead>
            <tbody>
              <c:forEach var="reportInfo" items="${reportInfoList}">
               <tr>
                  <td style="text-align: center">
                                        <c:out value="${reportInfo.reportId}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                        <c:out value="${reportInfo.reportTitle}" />
                                    </td>
                                                                                                
                                    <td style="text-align: center; color: red">
                                        <c:out value="${reportInfo.date}" />
                                    </td>
                                    <td style="text-align: center; color: red">
                                        <c:out value="${reportInfo.typeName}" />
                                    </td>
                                     <td style="text-align: center; color: green">
                                        <c:out value="${reportInfo.reporter}" />
                                    </td>      
                                     <td style="text-align: center; color: green">
                                        <c:out value="${reportInfo.status}" />
                                    </td>                                                                                                  
                    <td style="text-align: center; margin:auto;width:fit-content">
                    <form method="post">   
                     <a href="ViewReportServlet?id=<c:out value='${reportInfo.reportId}'/>"><i class="fa fa-eye"></i> &nbsp;&nbsp;</a>            					
					 <c:if test="${reportInfo.status == 1}">
					<button style="display:none" type="submit" name="cf" title="" data-toggle="tooltip" data-original-title="confirm"><i class="fa fa-check-circle" aria-hidden="true"></i>
					</button>
					 </c:if>
					  <c:if test="${reportInfo.status == 0}">
					<button type="submit" name="cf" title="" data-toggle="tooltip" data-original-title="confirm"><i class="fa fa-check-circle" aria-hidden="true"></i>
					</button>
					 </c:if>				  
					 <button type="submit" name="cf" title="" data-toggle="tooltip" data-original-title="confirm"><<i class="fa fa-file" aria-hidden="true"></i>
					</button>
					</form>
                    </td>
                          </tr>
                </c:forEach>			
            </tbody>
        </table>	
</div>

<div style="float:left;">
		<b>List Of Report Type</b>
		<table class="table table-bordered">
            <thead>
                <tr class="ex">	
                    <th>Name</th>
                   
					<th>Change</th>
                </tr>
            </thead>
            <tbody>
			 <c:forEach var="reportType" items="${reportTypeList}">
               <tr>
                                    <td style="text-align: center; color: black">
                                        <c:out value="${reportType.name}" />
                                    </td>                                                                                          
                    <td>
                        <a href="EditReportTypeFormServlet?id=<c:out value='${reportType.id}'/>"><i class="fas fa-pencil-alt"></i> &nbsp;&nbsp;</a>
                        <a href="RemoveReportTypeServlet?id=<c:out value='${reportType.id}' />" onclick="return confirm('Are you sure you want to delete this item?');"> <i class="fas fa-trash"></i></a>
                    </td>
                          </tr>
                </c:forEach>	
            </tbody>
        </table>       
		<b>Add Report Type</b>
		 <form class="form-inline" action="AddReportTypeServlet" method="post">
  <div class="form-group mx-sm-3 mb-2">
    <input type="text" class="form-control" name="reportTypeName" placeholder="Report type name">
  </div>
  <button type="submit" name="addrt" class="btn btn-primary mb-2">Add</button>
</form>
                <script type="text/javascript">
                    var pager1 = new Pager('ReportTable', 5);
                    pager1.init();
                    pager1.showPageNav('pager', 'pageNavPosition');
                    pager1.showPage(1);
                   
                </script>
                </div>
</div>
  <jsp:include page = "admin_content_footer.jsp"></jsp:include>
               </body>
              
<jsp:include page = "admin_footer.jsp"></jsp:include>

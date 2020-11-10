<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Contract Type</title>
 <jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<script>
    var element = document.getElementById("managecontract");
  element.classList.add("activemenu");
    </script>
<body>
 <c:if test="${message != null}">
 <p style ="color:red"> <c:out value="${message}" /></p>
 </c:if> 
<jsp:include page = "admin_content_header.jsp"></jsp:include>	
	<div class="row">
		<div class = "col-sm-6">
			<h2>List <b>Contract Type</b></h2>
		</div>
		
		<table class="table table-bordered">
            <thead>
                <tr class="ex">
                    <th>Name</th>
                    <th>File</th>
					<th>Change</th>
                </tr>
            </thead>
            <tbody>
			   <c:forEach var="cttype" items="${list}">
               <tr>
                  <td style="text-align: center">
                                        <c:out value="${cttype.name}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                        <c:out value="${cttype.fileName}" />
                                    </td>                                                              
                                           <td style = "white-space: nowrap; margin:auto;width:fit-content">
                     <a href="EditContractTypeFormServlet?id=<c:out value='${cttype.id}'/>"><i class="fas fa-pencil-alt" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="collapseExample"></i> &nbsp;&nbsp;</a>	
                     <a href="DownloadContractTypeServlet?id=<c:out value='${cttype.id}'/>"><i class="fas fa-download" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="collapseExample"></i> &nbsp;&nbsp;</a>	
                      <a href="RemoveContractTypeServlet?id=<c:out value='${cttype.id}' />" onclick="return confirm('Are you sure you want to delete this item?');"> <i class="fas fa-trash"></i></a>				
                    </td>
                          </tr> 
                       </c:forEach>            
            </tbody>
        </table>
        </div>
      
       
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Update Contract Type</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action = "UpdateContractTypeServlet">
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Name</label>
            <input type="text" value="<c:out value='${contracttype.name}' />" class="form-control" id="recipient-name" >
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label" >Select file</label>
            <input type="file" class="form-control" name="cttypeDirectory" accept=".doc, .docx">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Update</button>
      </div>
    </div>
  </div>
</div>
		<b>Add Contract Type</b>
		<form class="form-inline" method="POST" action = "AddContractTypeServlet" enctype="multipart/form-data">
  <div class="form-group mx-sm-3 mb-2">
    <input type="text" class="form-control" name="contractTypeName" placeholder="Contract type name">
    <input type="file" class="form-control" name="cttypeFile" value = "Select file" accept=".doc, .docx">
  </div>
  <button type="submit" name="addctt" class="btn btn-primary mb-2">Add</button>
</form>

  <jsp:include page = "admin_content_footer.jsp"></jsp:include>  
</body>
<jsp:include page = "admin_footer.jsp"></jsp:include>

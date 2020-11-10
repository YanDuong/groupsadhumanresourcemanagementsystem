<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPLOAD CONTRACT FILE</title>
<jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>
<jsp:include page = "staff_resources.jsp"></jsp:include>
<form class="md-form" action="UploadContractFileServlet" method="post" enctype="multipart/form-data" >
  <div class="file-field">
    <div class="btn btn-primary btn-sm float-center">
      <span>Choose files</span>
    <input type="hidden" name="id" value="<c:out value='${id}' />" />
    <input type="file" class="form-control" name="contractFile" value = "Select file" accept=".doc, .docx">
     <button type="submit" name="addctt" class="btn btn-primary mb-2">Add</button>
 </div>
    <div class="file-path-wrapper">
     
    </div>
  </div>
</form>

</body>
</html>
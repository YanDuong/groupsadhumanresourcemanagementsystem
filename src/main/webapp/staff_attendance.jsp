<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE CONTRACT</title>
<jsp:include page = "staff_resources.jsp"></jsp:include>
</head>
<body onload="time()" style="overflow-x:hidden">
<jsp:include page = "staff_header.jsp"></jsp:include>
<div class="card">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">
     <c:if test="${message != null}">
 		<p style ="color:green"> <c:out value="${message}" /></p>
 	 </c:if>
    </p>
  </div>
</div>
<div class="buttonHolder">
  <a href="StaffStartWorkingServlet" class="startButton">Start Working</a>
  <a href="StaffEndWorkingServlet" class="endButton">End Working</a>
</div>
</body>
</html>

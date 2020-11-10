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
<script>
    var element = document.getElementById("eac");
  element.classList.add("activemenu");
    </script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<div style="width:50%;float:left">
<canvas id="pie-chart" width="800" height="450"></canvas>
</div>
<div style="width:50%;float:right">
<canvas id="bar-chart-horizontal" width="800" height="450"></canvas>
</div>


<jsp:include page = "admin_footer.jsp"></jsp:include>
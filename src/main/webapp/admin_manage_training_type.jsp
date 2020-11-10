<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Traning Type</title>
 <jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<script>
    var element = document.getElementById("managetp");
  element.classList.add("activemenu");
    </script>
 
<div style="width:40%;margin:auto">
		<b>List Training Program</b>
		<table class="table table-bordered">
            <thead>
                <tr class="ex">
                    <th>Name</th>
                    <th>Time</th>
                    <th>Description</th>
					<th>Change</th>
                </tr>
            </thead>
            <tbody>
			
            </tbody>
        </table>
		<b>Modified Training Program</b>
		<form class="form-inline" method="POST">
  <div class="form-group" style="width:100%">
    <input style="width:49%" type="text" class="form-control" name="nametp" placeholder="Traning program name">
    <input style="width:49%" type="text" class="form-control" name="time" placeholder="How long (month)">
  </div>
  <textarea style="width:100%" class="form-control" name="des" placeholder="Description"></textarea>
  <button type="submit" name="addtp" class="btn btn-primary mb-2">Add</button>
</form>
</div>
 <jsp:include page = "admin_content_footer.jsp"></jsp:include>
</body>
</html>
<jsp:include page = "admin_footer.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>
<script>
    var element = document.getElementById("eac");
  element.classList.add("activemenu");
    </script>

<div style="width:40%;margin:auto">
<p style="text-align:center">Top 3 KPI</p>
<form method="post" style="width:fit-content;margin:auto">
    <input id="month1" name="date1" style="width:auto" type="month"><button name="setdate" class="btn btn-success">Check</button>
</form>
		<table class="table table-bordered" id="myTable">
            <thead>
                <tr class="ex">
                    <th>Full name</th>
                    <th>KPI</th>
                </tr>
            </thead>
            <tbody>
           
            </tbody>
        </table>
        <form method="post">
        
                <input type="hidden" name="ids" value="<?php echo $id; ?>">
                <input type="text" name="mes" value="<?php echo $text; ?>">
                <button id="add" type="submit" name="add" class="btn btn-success" value="<?php echo $text; ?>">Send message</button>
                <button id="update" type="submit" disabled name="edit" class="btn btn-primary">Update message</button>
        </form>
</div>

<jsp:include page = "admin_footer.jsp"></jsp:include>
</body>
</html>
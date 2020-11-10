<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title> Change Password</title>
<jsp:include page = "staff_resources.jsp"></jsp:include>
</head>
<body>
<jsp:include page = "staff_header.jsp"></jsp:include>
<form style="width:30%;margin:auto" method="post">
<div class="form-group">
    <label for="inputPassword6">Password</label>
    <input name="pw" type="password" id="inputPassword6" class="form-control mx-sm-3" aria-describedby="passwordHelpInline">
    <small id="passwordHelpInline" class="text-muted">
      Must be 6-10 characters long.
    </small>
  </div>
  <div class="form-group">
    <label for="inputPassword7">Re-Password</label>
    <input type="password" id="inputPasswor7" class="form-control mx-sm-3" aria-describedby="passwordHelpInline">
    <small id="passwordHelpInline" class="text-muted">
      Must be like password.
    </small>
  </div>
  <button type="submit" name="changepassword">Change password</button>
</form>
</body>
</html>
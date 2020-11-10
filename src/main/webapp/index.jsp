<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>LOGIN</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <link rel="stylesheet" href="resources/login.css">
</head>
<body>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <div class="fadeIn first">
    </div>
    <form action="LoginServlet" method = "post">
      <input type="text" id="username" class="fadeIn second" name="username" placeholder="Username">
      <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div>
<div class="card">
  <div class="card-body">
    <p class="card-text">
     <c:if test="${error != null}">
 		<p style ="color:red"> <c:out value="${error}" /></p>
 	 </c:if>
    </p>
  </div>
</div>
  </div>
</div>
</body>

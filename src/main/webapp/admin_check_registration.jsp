<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>

        <table class="table table-bordered" id="myTable" style="width:50%;float:left">
            <thead>
                <tr class="ex">
                    <th>Username</th>
                    <th>Register Day</th>
					<th>Email</th>
					<th>Activity</th>
                </tr>
            </thead>
            <tbody>
			
            </tbody>
        </table>
		<div id="pageNavPosition" class="text-right" style="float:left;"></div>
		<table class="table table-bordered" id="cflistuser" style="width:40%;float:right">
            <thead>
                <tr class="ex">
                    <th width="auto">User Name</th>
                    <th width="auto">Register Day</th>
					<th>Email</th>
                    <th width="5px; !important">Confirm</th>
                </tr>
            </thead>
            <tbody>
			
			
			
			

                
            </tbody>
        </table>
                
                <script type="text/javascript">
                    var pager = new Pager('myTable', 5);
                    pager.init();
                    pager.showPageNav('pager', 'pageNavPosition');
                    pager.showPage(1);
                </script>
<jsp:include page = "admin_footer.jsp"></jsp:include>
</body>
</html>
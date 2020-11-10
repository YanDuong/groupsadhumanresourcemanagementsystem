<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Report type</title>
<jsp:include page = "admin_resources.jsp"></jsp:include>
<style>
table.table th:last-child
{
    width:auto;
}
</style>
</head>
<body>
<jsp:include page = "staff_resources.jsp"></jsp:include>
<div style="width:80%;margin:auto">
		<table class="table table-bordered" id="myTable">
            <thead>
                <tr class="ex">
                    <th>ID Contract</th>
                    <th>Full name</th>
                    <th>Contract Type</th>
                    <th>Start Day</th>
                    <th>End Day</th>
                    <th>Over Time Salary (Per Hours)</th>
                    <th>Admin Sign</th>
                    <th>Staff Sign</th>
                    <th>View</th>
                </tr>
            </thead>
            <tbody>
			
            </tbody>
        </table>
</div>
        <script type="text/javascript">
                    var pager = new Pager('myTable', 5);
                    pager.init();
                    pager.showPageNav('pager', 'pageNavPosition');
                    pager.showPage(1);
                </script>
 
</body>

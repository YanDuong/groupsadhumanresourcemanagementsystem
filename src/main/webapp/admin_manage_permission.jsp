<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Permission</title>
 <jsp:include page = "admin_resources.jsp"></jsp:include>

</head>
<script>
    var element = document.getElementById("managestaff");
  element.classList.add("activemenu");
    </script>

<style>
table.table th:last-child{width:auto}
form input{width:auto;height:auto}
</style>
<div style="width:50%;float:left">
        <table class="table table-bordered" id="myTable">
            <thead>
                <tr class="ex">
                    <th>User</th>
                    <th>Name</th>
					<th>Is Admin</th>
					<th>Change</th>
                </tr>
            </thead>
            <tbody>
			
            </tbody>
        </table>
		</div>	
<div style="width:48%;float:right">
<form method="post">
	<select name="userstaff" id="userstaff" style="height:35px;border-radius:5px" onchange="this.form.submit()">
    <option selected>Select user</option>
   
    </select><br/>
	<label>Manage staff</label><input name="permision[]" style="margin:5px" type="checkbox" value="staff" id="staff"><br/>
	<label>Manage Attendance</label><input name="permision[]" style="margin:5px" type="checkbox" value="attendance" id="attendance"><br/>
	<label>Manage Department</label><input name="permision[]" style="margin:5px" type="checkbox" value="department" id="department"><br/>
	<label>Manage Permission</label><input name="permision[]" style="margin:5px" type="checkbox" value="permision" id="permision"><br/>
	<label>Manage Contract</label><input name="permision[]" style="margin:5px" type="checkbox" value="contract" id="contract"><br/>
	<label>Manage Contract type</label><input name="permision[]" style="margin:5px" type="checkbox" value="contractype" id="contractype"><br/>
	<label>Sign Contract</label><input name="permision[]" style="margin:5px" type="checkbox" value="signcontract" id="signcontract"><br/>
	<label>Check Registration</label><input name="permision[]" style="margin:5px" type="checkbox" value="checkregister" id="checkregister"><br/>
	<label>Check Profile</label><input name="permision[]" style="margin:5px" type="checkbox" value="checkprofile" id="checkprofile"><br/>
	<label>Manage training program</label><input name="permision[]" style="margin:5px" type="checkbox" value="tranningprogram" id="tranningprogram"><br/>
	<label>Manage training program type</label><input name="permision[]" style="margin:5px" type="checkbox" value="tranningprogramtype" id="tranningprogramtype"><br/>
	<label>Evaluate and Classify staff</label><input name="permision[]" style="margin:5px" type="checkbox" value="evaluate" id="evaluate"><br/>
	<label>List Statistics</label><input name="permision[]" style="margin:5px" type="checkbox" value="liststatic" id="liststatic"><br/>
	<label>Gross salary</label><input name="permision[]" style="margin:5px" type="checkbox" value="grossalary" id="grossalary"><br/>
	<label>Manage Report</label><input name="permision[]" style="margin:5px" type="checkbox" value="report" id="report"><br/>
	<label>Manage News</label><input name="permision[]" style="margin:5px" type="checkbox" value="news" id="news"><br/>
	<button id="update" type="submit"  name="update" class="btn btn-primary">Update</button>
</form>
</div>

<jsp:include page = "admin_footer.jsp"></jsp:include>
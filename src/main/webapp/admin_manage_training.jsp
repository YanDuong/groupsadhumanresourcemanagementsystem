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
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<script>
    var element = document.getElementById("managetp");
  element.classList.add("activemenu");
    </script>

<div style="width:59%;float:left">
        <table class="table table-bordered" id="myTable">
            <thead>
			<b>Staff in Training Program</b>
                <tr class="ex">
                    <th>Full name</th>
                    <th>Training program</th>
					<th>Start</th>
                    <th>End</th>
                    <th>Suport money</th>
                    <th>Description</th>
                    <th>Setting</th>
                </tr>
            </thead>
            <tbody>
			
            </tbody>
        </table>
		
		<div id="pageNavPosition" class="text-right" style="float:left;"></div></div>
<div style="width:40%;float:right">
		
        <b>Set Staff to training program</b>   
        <form class="form-inline" method="POST">
  <div class="form-group mx-sm-3 mb-2">
  <select name="userstaff" id="userstaff" style="height:35px;border-radius:5px">
    <option selected>Select user</option>
    
  </select>
  <select id="idtp" name="idtp" style="height:35px;border-radius:5px">
    <option selected>Select training program</option>
    
  </select>
  <br/><b style="width:100px">Start day</b><input type="date" class="form-control" id="starttp" name="starttp">
  <br/><b style="width:100px">End day</b><input type="date" class="form-control" id="endtp" name="endtp">
  <br/><b style="width:100px">Support Money</b><input type="text" class="form-control" id="spmoney" name="spmoney">
  <br/><b style="width:100px">Description</b><textarea type="text" class="form-control" id="des" name="des"></textarea>
  <input type="hidden" id="idstp" name="idstp" value="">
  <button type="submit" name="settp" id="settp" class="btn btn-primary mb-2">Add</button>
  <button disabled id="updatetp" type="submit" name="updatetp" class="btn btn-primary mb-2">Update</button>  </div>
</form></div>
                <script type="text/javascript">
                    var pager = new Pager('myTable', 5);
                    pager.init();
                    pager.showPageNav('pager', 'pageNavPosition');
                    pager.showPage(1);
                </script>
                 <jsp:include page = "admin_content_footer.jsp"></jsp:include>
</body>
<jsp:include page = "admin_footer.jsp"></jsp:include>
</html>
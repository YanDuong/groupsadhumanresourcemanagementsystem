<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
    var element = document.getElementById("managestaff");
  element.classList.add("activemenu");
    </script>

<div style="width:90%;margin:auto">
        <p class="timkiemnhanvien"><b>LOOK UP STAFF</b></p>
        <input type="text" id="myInput" onkeyup="myFunction()" placeholder=""
            data-toggle="tooltip" data-placement="bottom" title="">
        <i class="fa fa-search" aria-hidden="true"></i>
        <b>CONTROL:</b>
        <button onclick="xuatfile()" class="nv xuat" data-toggle="tooltip" data-placement="top" title="EXPORT FILE"><i
                class="fas fa-file-import"></i></button>
</div>
		<style>
		.table-fixed-column-outter {
  position: relative;
  margin: 2rem auto;
  max-width: 80%;
}
.table-fixed-column-inner {
  overflow-x: scroll;
  overflow-y: visible;
  margin-left: 300px;
}
.table.table-fixed-column {
  table-layout: fixed;
  width: 100%
}

.table td,
.table th {
  width: 100px;
}
.table .fixedcolumn{
  position: absolute;
  width: 100px;
}
#myTable th
{
	vertical-align: middle;height:70px;
}
::-webkit-scrollbar{
  height:10px !important;
  background-color:#006bcf;
}
::-webkit-scrollbar-thumb {
  background: black !important; 
  border-radius: 0px !important;
}
#pageNavPosition{text-align:center}
td.fixedcolumn{height:70px;}
@media (min-width: 768px){
.col-sm-9 {
    width: 100%;
}}
		</style>
		<div class="table-fixed-column-outter">
  <div class="table-fixed-column-inner">
        <table class="table table-bordered" id="myTable">
            <thead>
                <tr class="ex">
                    <th class="fixedcolumn" style="left:0"><p style="margin:10px 0">Staff Code</p></th>
                    <th class="fixedcolumn" style="left:100px"><p style="margin:10px 0">Full Name</p></th>
					<th class="fixedcolumn" style="left:200px"><p style="margin:10px 0">Department</p></th>
                    <th>Gender</th>                   
					<th style="width:200px">Email</th>
					<th>Phone</th>
					<th>Dob</th>
					<th>Address</th>
					<th>Status Marriage</th>
					<th>Necessary Contact</th>
					<th>Residetial Address</th>
					<th>Graduate Insutitution</th>
					<th>Major</th>
					<th>Degree</th>
					<th>Gratduate Year</th>
					<th>Oversea education</th>
					<th class="fixedcolumn" style="right:-110px"><p style="margin:10px 0">Setting</p></th>
                </tr>
            </thead>
            <tbody>
             
            </tbody>
        </table>
		</div></div>
                <div id="pageNavPosition" class="text-right"></div>
				<div style="margin:auto;width:80%">
		<form class="form" method="post" id="updateprofile">
		<input type="hidden" name="username" id="usernameedit">
    	<div class="col-sm-9">            
          <div class="tab-content">
            <div class="tab-pane active" id="home">
                <hr>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="first_name">Full name</label>
                              <input type="text" class="form-control" name="fullname" id="fullname">
                          </div>
                      </div>
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email">Day of Birth</label>
                              <input type="date" class="form-control" name="dob" id="dob">
                          </div>
                      </div>
                      <div class="form-group">                     
                          <div class="col-xs-6">
                            <label for="last_name" >Sex</label>
                              <select id="sex" name="sex" class="form-control">
								<option value="0">Male</option>
								<option value="1">Female</option>
							  </select>
                          </div>
                      </div>
                      <div class="form-group">                       
                          <div class="col-xs-6">
                              <label for="text">Status Marriage</label>
                              <select id="sm1" class="form-control" name="sm">
								<option value="0">Married</option>
								<option value="1">Not married</option>
							  </select>
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email">Email</label>
                              <input type="email" class="form-control" name="email" id="email">
                          </div>
                      </div>
          
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label for="phone">Phone</label>
                              <input type="phone" class="form-control" name="phone" id="phone">
                          </div>
                      </div>
                      
                      <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="address">Address</label>
                              <input type="text" class="form-control" name="address" id="address">
                          </div>
                      </div>
					  <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="ra">Residential address</label>
                              <input type="text" class="form-control" name="ra" id="ra">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="nc">Necessary contact</label>
                              <input type="text" class="form-control" name="nc" id="nc" >
                          </div>
                      </div>
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="gi">Graduate institution</label>
                              <input type="text" class="form-control" name="gi" id="gi">
                          </div>
                      </div>
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="major">Major</label>
                              <input type="text" class="form-control" name="major" id="major">
                          </div>
                      </div>					  
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="gy">Graduate Year</label>
                              <input type="text" class="form-control" name="gy" id="gy">
                          </div>
                      </div>
					  <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="oe">Oversea education</label>
                              <input type="text" class="form-control" name="oe" id="oe">
                          </div>
                      </div>
					<div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="ra">Certificate of degree</label>
                              <select class="form-control" name="degree" id="cod">
								<option value="0">University</option>
								<option value="1">College</option>
								<option value="2">TC</option>
								<option value="3">THPT</option>
							  </select>
                          </div>
                      </div>
                      </div>
                      </div>
                      </div>
              	</form>
				</div>
				<div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<a class="btn btn-lg btn-success" onclick="kiemtra()"><i class="glyphicon glyphicon-ok-sign"></i> Save</a>
                            </div>
                      </div>
                <script type="text/javascript">
                    var pager = new Pager('myTable', 5);
                    pager.init();
                    pager.showPageNav('pager', 'pageNavPosition');
                    pager.showPage(1);
                </script>
		<script>
			function xuatfile()
			{
				window.location.href = "../exportexcel.php";
			}
		</script>
		<script>
	function validate()
	{
		swal({
  title: "Are you sure?",
  text: "",
  type: "info",
  showCancelButton: true,
  confirmButtonClass: "btn-success",
  confirmButtonText: "Yes",
  closeOnConfirm: false
},
function(){
  swal("Done!", "", "success");document.getElementById("updateprofile").submit();
	});}
	</script>

<jsp:include page = "admin_footer.jsp"></jsp:include>
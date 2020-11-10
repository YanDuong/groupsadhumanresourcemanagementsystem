<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Fee Detail</title>
<jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<div class="view overlay">
 <div class="col-md-8">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="pull-right">
                    <div class="btn-group dropdown" uib-dropdown="dropdown">
                        <button class="btn btn-link dropdown-toggle" uib-dropdown-toggle="" aria-haspopup="true" aria-expanded="false"><em class="fa fa-ellipsis-v fa-lg text-muted"></em></button>
                        <ul class="dropdown-menu dropdown-menu-right animated fadeInLeft" role="menu">
                            <li><a href=""><span class="text-warning">Delete contact</span></a></li>
                        </ul>
                    </div>
                </div>
                <div class="h4 text-center">Detail Employee Fee</div>
                <div class="row pv-lg">
                    <div class="col-lg-2"></div>
                    <div class="col-lg-8">
                        <form class="form-horizontal ng-pristine ng-valid">
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="inputContact1">Employee Code</label>
                                <div class="badge badge-primary text-wrap" style="width: 6rem;">	
                                ${employeeFee.employeeCode}
     						 </div>      
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="inputContact2">Staff Name</label>
                                <div class="col-sm-10">
                                   <div class="badge badge-primary text-wrap" style="width: 6rem;">
       						 ${employeeFee.staffName}
      								</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="inputContact3">Working Days</label>
                                <div class="col-sm-10">
                                  <div class="badge badge-primary text-wrap" style="width: 6rem;">
       						 ${employeeFee.workingDays}
      								</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="inputContact4">OT Hours</label>
                                <div class="col-sm-10">
                                     <div class="badge badge-primary text-wrap" style="width: 6rem;">
       							 ${employeeFee.otHours}
      								</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="inputContact5">Real Salary</label>
                                <div class="col-sm-10">
                                     <div class="badge badge-primary text-wrap" style="width: 6rem;">
       						 ${employeeFee.basicSalary}
      								</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="inputContact6">KPI</label>
                                <div class="col-sm-10">
                                     <div class="badge badge-primary text-wrap" style="width: 6rem;">
       						 ${employeeFee.hourSalary}
      								</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="inputContact7">Travel Fee</label>
                                <div class="col-sm-10">
                                    <div class="badge badge-primary text-wrap" style="width: 6rem;">
       						 ${employeeFee.kpi}
      								</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="inputContact8">Equipment Fee</label>
                                <div class="col-sm-10">
                                     <div class="badge badge-primary text-wrap" style="width: 6rem;">
       						 ${employeeFee.travel}
      								</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <label class="col-sm-2 control-label" for="inputContact8"> Reward</label>
                                <div class="col-sm-10">
                                     <div class="badge badge-primary text-wrap" style="width: 6rem;">
       						 ${employeeFee.equipment}
      								</div>
                                </div>
                                </div>
                            </div>
                             <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <label class="col-sm-2 control-label" for="inputContact8"> Reward</label>
                                <div class="col-sm-10">
                                     <div class="badge badge-primary text-wrap" style="width: 6rem;">
       						 ${employeeFee.bonus}
      								</div>
                                </div>
                                </div>
                            </div>
                             <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <label class="col-sm-2 control-label" for="inputContact8"> Insurrance</label>
                                <div class="col-sm-10">
                                     <div class="badge badge-primary text-wrap" style="width: 6rem;">
       							 ${employeeFee.inssurance}
      								</div>
                                </div>
                                </div>
                            </div>
                             <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <label class="col-sm-2 control-label" for="inputContact8"> Other</label>
                                <div class="col-sm-10">
                                     <div class="badge badge-primary text-wrap" style="width: 6rem;">
       							 ${employeeFee.other}
      								</div>
                                </div>
                                </div>
                            </div>
                             <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <label class="col-sm-2 control-label" for="inputContact8"> Total</label>
                                <div class="col-sm-10">
                                     <div class="badge badge-primary text-wrap" style="width: 6rem;">
       							 ${employeeFee.totalFee}
      								</div>
                                </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                
                                    <button class="btn btn-outline-success" type="submit">Update</button>
                                     <button class="btn btn-outline-danger" onclick="window.location.href='request.getContextPath()/ManageEmployeeFeeServlet'">Cancel</button>
                                </div>
                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
</div>
</div>
</body>
</html>
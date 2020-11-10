<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VIEW NOTIFICATION</title>
<jsp:include page = "admin_resources.jsp"></jsp:include>
<script>
$(document).ready(function () {
	  $('#notificationTable').DataTable();
	  $('.dataTables_length').addClass('bs-select');
	});
$(document).ready(function () {
	  $('#notificationTable').DataTable({
	    "pagingType": "simple" // "simple" option for 'Previous' and 'Next' buttons only
	  });
	  $('.dataTables_length').addClass('bs-select');
	});
</script>
</head>
<body>
<jsp:include page = "staff_resources.jsp"></jsp:include>
<div class="row">
<div class="table-responsive col-md-6">
<h4>Notifications</h4>
        <table id="notificationTable" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">      
            <thead>
                <tr class="ex">
                    <th class="th-sm">ID</th>
                    <th class="th-sm">Title</th>                  
                    <th class="th-sm">Date</th>     
                    <th class="th-sm">Sender</th>                              
					<th class="th-sm">Setting</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="notification" items="${notifications}">
               <tr>
                  <td style="text-align: center">
                                        <c:out value="${notification.id}" />
                                    </td>
                                    <td style="text-align: center; color: black">
                                        <c:out value="${notification.title}" />
                                    </td>                                                         
                                    <td style="text-align: center; color: black">
                                    <fmt:formatDate value="${notification.date}" pattern="dd-MMM-yyyy hh:mm:ss:aa" />
                                    </td>  
                                    <td style="text-align: center; color: black">
                                        <c:out value="${notification.staffName}" />
                                    </td>                                                                                                                 
                    <td style = "white-space: nowrap; margin:auto;width:fit-content">                
 						<a href="StaffViewNotificationContentServlet?id=<c:out value='${notification.id}'/>"><i class="fa fa-eye" aria-hidden="true" role="button" aria-expanded="false" aria-controls="collapseExample"></i></a>
                    </td>
                          </tr> 
                       </c:forEach>                			
            </tbody>
        </table>
        
        
  </div>    	    
                 </div>      
</body>



<script>
        ClassicEditor
            .create( document.querySelector( '#editor' ),{
                ckfinder: {
                    uploadUrl: '../../vendor/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files&responseType=json'
                }
            } )
            .catch(error => {
                console.error( error );
            } );
    </script>
    <script type="text/javascript">
                    var pager = new Pager('NotificationTable', 5);
                    pager.init();
                    pager.showPageNav('pager', 'pageNavPosition');
                    pager.showPage(1);
                </script>
                <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
        </script>
                
<jsp:include page = "admin_footer.jsp"></jsp:include>
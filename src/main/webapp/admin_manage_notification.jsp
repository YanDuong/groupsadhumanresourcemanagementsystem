<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN</title>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="ADMIN PAGE SIDEBAR"> 
    <jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<script>
    var element = document.getElementById("news");
  element.classList.add("activemenu");
    </script>
<script src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>

<style>
.ck-editor__editable_inline {
    min-height: 300px;
}

</style>
<body>
<jsp:include page = "admin_content_header.jsp"></jsp:include>
<div class="row">
<div class="table-responsive col-md-6">
<h4>Notifications</h4>
        <table class="table table-bordered" id="NotificationTable">
       
            <thead>
                <tr class="ex">
                    <th>ID</th>
                    <th>Title</th>                  
                    <th>Date</th>                               
					<th>Setting</th>
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
                    <td style = "white-space: nowrap; margin:auto;width:fit-content">                
 <a href="ViewNotificationServlet?id=<c:out value='${notification.id}'/>"><i class="fa fa-eye" aria-hidden="true" role="button" aria-expanded="false" aria-controls="collapseExample"></i></a>
                     <a href="EditNotificationFormServlet?id=<c:out value='${notification.id}'/>"><i class="fas fa-pencil-alt" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="collapseExample"></i> &nbsp;&nbsp;</a>	
                      <a href="RemoveNotificationServlet?id=<c:out value='${notification.id}' />" onclick="return confirm('Are you sure you want to delete this item?');"> <i class="fas fa-trash"></i></a>				
                    </td>
                          </tr> 
                       </c:forEach>                			
            </tbody>
        </table>
        
        
  </div>  

 <div class="table-responsive col-md-6">
   <h4>Add New Notification</h4>
    <div class="card">
        <div class="card-body">  
            <form action="AddNotificationServlet" method="post" id="addprofile">                 
                      <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="title">Title</label>
                              <input type="text" class="form-control" name="title" id="title">
                          </div>
                      </div>	
                       <div>                         
                          <label for="Content">Content
                       <textarea name="content" rows = "5"></textarea>
                         </label>
                      </div>	
                      <div class="form-group">                         
                          <div class="col-xs-6">
                              <label for="first_name">Sender</label>
                              <input type="text" class="form-control" name="sender" id="sender">
                          </div>
                      </div>	                    	                                                                                      
				<div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button type="submit" class="btn btn-success" onclick="validate()">Save</button>
                              	 <button class="btn btn-danger" onclick="window.location.href='request.getContextPath()/ManageNotificationServlet'">Cancel</button>
                            </div>
                      </div>
                     <div class="container">
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
                    <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker1"/>
                    <div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
</div>
                    	</form>	
                    	</div>	
                  </div>
                  </div>  	    
                 </div>      
      <jsp:include page = "admin_content_footer.jsp"></jsp:include>  
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

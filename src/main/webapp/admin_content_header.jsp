<script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
<div class="wrapper" style="margin:5px">
        <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>ADMIN</h3>
                <strong>BS</strong>
            </div>
            <ul class="list-unstyled components">
                <li>
                    <a href="ManageStaffServlet" >
                        <i class="fas fa-staff"></i>
                       Staff
                    </a>                    
                </li>
                 <li>
                    <a href="ManageProfileServlet">
                        <i class="fas fa-user"></i>
                     Profile
                    </a>
                </li>
                <li>
                    <a href="ManageAttendanceServlet">
                        <i class="fa fa-clock-o"></i>
                      Attendance
                    </a>                          
                </li>
                <li class = "active">
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Manage Contract</a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                 <li>
                        <a href="ManageContractServlet">View Contract</a>
                    </li>
                    <li>
                        <a href="ManageContractTypeServlet">Manage Contract Type</a>
                    </li>               
                    <li>
                        <a href="ManageSignatureServlet">Signature</a>
                    </li>
                </ul>
                </li>
     
                <li>
                    <a href="ManageReportServlet">
                        <i class="fas fa-question"></i>
                       Report
                    </a>
                </li>
                <li>
                    <a href="">
                        <i class="fas fa-paper-plane"></i>
                      Training Program
                    </a>
                </li>
                 <li>
                    <a href="#">
                        <i class="fas fa-paper-plane"></i>
                      Permission
                    </a>
                </li>
                 <li>
                    <a href="#">
                        <i class="fas fa-paper-plane"></i>
                     Statistics
                    </a>
                </li>
                 <li>
                    <a href="ManageNotificationServlet">
                        <i class="fas fa-paper-plane"></i>
                     Notification
                    </a>
                </li>
                 <li>
                    <a href="ManageEmployeeFeeServlet">
                        <i class="fas fa-paper-plane"></i>
                     Manage Employee Fee
                    </a>
                </li>
            </ul>

        </nav>
<div id="content">
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">

                <button type="button" id="sidebarCollapse" class="btn btn-info">
                    <i class="fas fa-align-left"></i>
                    <span>Toggle Sidebar</span>
                </button>
            </div>
        </nav>
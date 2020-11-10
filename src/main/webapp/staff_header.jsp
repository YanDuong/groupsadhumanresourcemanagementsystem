<body onload="time()" style="overflow-x:hidden">
    <nav class="navbar navbar-light" style="background-color: #ddeeff;">
    <a href="" class="navbar-brand">STAFF</a>
    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav">
            <a href="#" class="nav-item nav-link active">Home</a>
            <a href="#" class="nav-item nav-link">Notification</a>
            <a href="#" class="nav-item nav-link">Profile</a>
        </div>
         <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Attendance</a>
                <div class="dropdown-menu">
                    <a href="StaffAttendanceServlet" class="dropdown-item">Check Attendance</a>
                  
                </div>
            </div>
        <form class="form-inline ml-auto">
            <input type="text" class="form-control mr-sm-2" placeholder="Search">
            <button type="submit" class="btn btn-outline-light">Search</button>
        </form>
         <div class="navbar-nav">
            <a href="StaffLoginServlet" class="nav-item nav-link">Login</a>
        </div>
         <div class="navbar-nav">
            <a href="StaffLogoutServlet" class="nav-item nav-link">Logout</a>
        </div>
    </div>
</nav>
        <div id="clock"></div>
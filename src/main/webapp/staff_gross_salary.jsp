
<script>
   function setCookie(cname, cvalue, exdays) {
  var d = new Date();
  d.setTime(d.getTime() + (exdays*24*60*60*1000));
  var expires = "expires="+ d.toUTCString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}</script>
<script>
    var element = document.getElementById("grosssalary");
  element.classList.add("activemenu");
    </script>
<div style="width:fit-content;margin:auto;height:50px">
    
</div>

<p style="text-align:center">Choose month:<?php echo $month.'/'.$year; ?></p>
<style>
    table.table th:last-child{width:auto;}
    </style>

<style>
.btn-success:hover
{
    background-color:black;color:white;
}
 th, td{border:solid 2px black !important}

     .table>thead:first-child>tr:first-child>th
     {
        word-break:keep-all !important;height:70px;
     }
     .activemenu{background-color:green !important;color:white !important}
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
        <table class="table table-bordered" id="myTable" style="width:77%;margin:auto">
            <thead>
                <tr class="ex">
                    <th style="background-color:white;color:black">Full name</th>
                    <th style="background-color:white;color:black">Basic Salary</th>
                    <th style="background-color:white;color:black">Overtime<br/>Salary<br/>(per Hour)</th>
                    <th style="background-color:white;color:green">KPI</th>
                    <th style="background-color:white;color:green">Travel<br/>(per Day)</th>
                    <th style="background-color:white;color:green">Equipment<br/>(per Day)</th>
                    <th style="background-color:white;color:green">Bounus</th>
                    <th style="background-color:white;color:green">Free Tax</th>
                    <th style="background-color:white;color:red">Insurrance</th>
                    <th style="background-color:white;color:red">Orther</th>
                    <th style="background-color:white;color:black">Save/Save ALL</th>                    
                </tr>
            </thead>
            <tbody>
			 
            </tbody>
        </table>
        <div id="pageNavPosition" class="text-right" style="text-align:center;"></div><br/>
        <p style="text-align:center;font-size:25px;font-weight:600">GROSS SALARY OF STAFF</p>
        <div class="table-fixed-column-outter">
  <div class="table-fixed-column-inner">
        <table class="table table-bordered" style="width:100%;margin:auto">
            <thead>
                <tr class="ex">
                    <th style="background-color:white;color:black">Staff code</th>
                    <th style="left:0px;background-color:white;color:black">Full name</th>
                    <th style="left:100px;background-color:white;color:black">Day Work</th>
                    <th style="left:200px;background-color:white;color:black">Real Day<br/>Work</th>
                    <th style="left:300px;background-color:white;color:black">Hours <br/> Work</th>
                    <th style="left:400px;background-color:white;color:black">Overtime<br/>Work</th>
                    <th style="background-color:white;color:green">Basic Salary</th>
                    <th style="background-color:white;color:green">Real Salary</th>
                    <th style="background-color:white;color:green">Overtime<br/>Salary</th>
                    <th style="background-color:white;color:green">KPI</th>
                    <th style="background-color:white;color:green">Travel</th>
                    <th style="background-color:white;color:green">Equipment</th>
                    <th style="background-color:white;color:green">Bounus</th>
                    <th style="background-color:white;color:red">Insurrance</th> 
                    <th style="background-color:white;color:red">Orther</th>
                    <th style="background-color:white;color:red">Tax</th>
                    <th style="right:-100px;width:70px;background-color:white;color:black">Total</th>
                    <th style="background-color:white;color:black">Send mail</th>
                </tr>
            </thead>
            <tbody>   
                
            </tbody>
        </table>
                </div></div>
        <script type="text/javascript">
                    var pager = new Pager('myTable', 5);
                    pager.init();
                    pager.showPageNav('pager', 'pageNavPosition');
                    pager.showPage(1);
                </script>
        <script>
        function sendmailsalary(data){
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.open("GET", "../sendmailsalary.php?data=" + data, true);
            xmlhttp.send();
            swal('Send success','','success');
        }
        </script>

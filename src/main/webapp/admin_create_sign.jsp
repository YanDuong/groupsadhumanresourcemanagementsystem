<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
    var element = document.getElementById("managecontract");
  element.classList.add("activemenu");
    </script>

    <script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
 
 $(document).ready(function () {
    /** Set Canvas Size **/
    var canvasWidth = 400;
    var canvasHeight = 100;

    /** IE SUPPORT **/
    var canvasDiv = document.getElementById('signaturePad');
    canvas = document.createElement('canvas');
    canvas.setAttribute('width', canvasWidth);
    canvas.setAttribute('height', canvasHeight);
    canvas.setAttribute('id', 'canvas');
    canvasDiv.appendChild(canvas);
    if (typeof G_vmlCanvasManager != 'undefined') {
        canvas = G_vmlCanvasManager.initElement(canvas);
    }
    context = canvas.getContext("2d");

    var clickX = new Array();
    var clickY = new Array();
    var clickDrag = new Array();
    var paint;

    /** Redraw the Canvas **/
    function redraw() {
        canvas.width = canvas.width; // Clears the canvas

        context.strokeStyle = "#000000";
        context.lineJoin = "miter";
        context.lineWidth = 2;

        for (var i = 0; i < clickX.length; i++) {
            context.beginPath();
            if (clickDrag[i] && i) {
                context.moveTo(clickX[i - 1], clickY[i - 1]);
            } else {
                context.moveTo(clickX[i] - 1, clickY[i]);
            }
            context.lineTo(clickX[i], clickY[i]);
            context.closePath();
            context.stroke();
        }
    }
    /** Save Canvas **/
    $("#saveSignature").click(function saveSig() {
        var sigData = canvas.toDataURL();
        $("#imgData").html('Thank you! Your signature was saved');
        //window.location.href = "?hinh=" + sigData;
        $("#image").val(sigData);
        $("#uploadImage").submit();
    });

    /** Clear Canvas **/
  $("#clearSignature").click(function clearSig() {
 
        clickX = new Array();
        clickY = new Array();
        clickDrag = new Array();
        canvas.width = canvas.width;
        canvas.height = canvas.height;
  });
    /**Draw when moving over Canvas **/
    $('#signaturePad').mousemove(function (e) {
        if (paint) {
            addClick(e.pageX - this.offsetLeft, e.pageY - this.offsetTop, true);
            redraw();
        }
    });

    /**Stop Drawing on Mouseup **/
    $('#signaturePad').mouseup(function (e) {
        paint = false;
    });

    /** Starting a Click **/
    function addClick(x, y, dragging) {
        clickX.push(x);
        clickY.push(y);
        clickDrag.push(dragging);
    }

    $('#signaturePad').mousedown(function (e) {
        var mouseX = e.pageX - this.offsetLeft;
        var mouseY = e.pageY - this.offsetTop;

        paint = true;
        addClick(e.pageX - this.offsetLeft, e.pageY - this.offsetTop);
        redraw();
    });

});
 </script>
   <div class="card">
        <div class="card-body">
      <form id="uploadImage" method="post" action="SaveSignatureImageServlet">
       <input type="hidden" id="id" value="<c:out value='${id}' />" name="id">  
       <input type="hidden" id="image" name="image">  
        <div class="form-group">                      
                          <div class="col-xs-6">
                              <label for="signer">Signer</label>
                              <input type="text" class="form-control" name="signer" id="signer">
                          </div>
                      </div>
    <p> Your Signature</p>
    <img width="435px" height="100px" src="">
        <fieldset style="width: 435px">
            <br/>
            <br/>
            <div id="signaturePad" style="border: 1px solid #00C; height: 100px; width: 400px;"></div>
            <br/>
            <button id="clearSignature" type="button">Clear Signature</button>&nbsp;
            <button id="saveSignature" type="button">Save Signature</button>
            <div id="imgData"></div>
            <div id="imgData"></div>
            <br/>
            <br/>
        </fieldset>
            </form>
   </div>
   </div>
<jsp:include page = "admin_footer.jsp"></jsp:include>
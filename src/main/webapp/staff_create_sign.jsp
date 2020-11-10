<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
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
    $("#saveSig").click(function saveSig() {
        var sigData = canvas.toDataURL("image/png");
        $("#imgData").html('Thank you! Your signature was saved');
        //window.location.href = "?hinh=" + sigData;
        $("#valuehinh").val(sigData);
        $("#uphinh").submit();
    });

    /** Clear Canvas **/
  $("#clearSig").click(function clearSig() {
 
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

</head>
<body>
<jsp:include page = "staff_resources.jsp"></jsp:include>
    <p> Your sign is</p>
    <img width="435px" height="100px" src="<?php echo $hinh; ?>">
        <fieldset style="width: 435px">
            <br/>
            <br/>
            <div id="signaturePad" style="border: 1px solid #00C; height: 100px; width: 400px;"></div>
            <br/>
            <button  id="clearSig" type="button">Clear Signature</button>&nbsp;
            <button id="saveSig" type="button">Save Signature</button>
            <div id="imgData"></div>
            <div id="imgData"></div>
            <br/>
            <br/>
        </fieldset>
    <form id="uphinh" method="post">
        <input type="hidden" id="valuehinh" name="hinh">
    </form>
    </body>
    </html>
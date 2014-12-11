<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.udcode.dao.*"%>
<%@ page language="java" import="com.udcode.entity.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>队伍创建</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">	
    <link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="../bootstrap/page_layout/field.css" rel="stylesheet">
    <style>
	 body {
      padding-bottom: 40px;
      color: #5a5a5a;
    }
    </style>
    <!-- js file  -->
    <script src="../bootstrap/js/jquery-1.11.1.min.js"></script>
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    <script src="../bootstrap/js/bootstrap-carousel.js"></script>
    
   <script>
      !function ($) {
        $(function(){
          // carousel demo
          $('#myCarousel').carousel()
        })
      }(window.jQuery);
      

	function loadPage() {
		$("#top_nav").load('topnav.html');
	}
	
	function submit() {
		
	}
</script>
  </head>
  <body onload="loadPage()">
    <div id="top_nav"></div>    
    <div id="team">
    	<form action="CreateTeam" method="post">
			<label>队名</label>
			<input type="string" name="name" />
			<br />
			<label>主场</label>
			<input type="select" name="filed" />
			<br />
			<input type="submit" />
		</form>
    </div>
  </body>
</html>

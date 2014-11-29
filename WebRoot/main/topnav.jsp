<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>topnav</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 <!-- Bootstrap -->
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">	
    
    <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <!-- js file  -->
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="../bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body>
   <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">我的足球梦</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li><a href="#">主页</a></li>
              <li><a href="teamrecord.jsp">球队战绩</a></li>
              <li><a href="#test">个人技术统计</a></li>
              <li><a href="field.jsp">场地</a></li>
          	  <li><a href="#expoler">探险新场地</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
  </body>
</html>

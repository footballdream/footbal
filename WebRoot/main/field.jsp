<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.udcode.dao.*"%>
<%@ page language="java" import="com.udcode.entity.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>场地</title>
    
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
</script>
  </head>
  
  <body onload="loadPage()">
    
    <div id="top_nav"></div>
    
     <%FieldDao dao = new FieldDao();
   		List<Field> fieldList = dao.getAllField();
   		TeamDao tDao = new TeamDao();
   		Team team = tDao.getTeam(1);
    %>

    
 
    <div id="myCarousel" class="carousel slide"> 
      <div class="carousel-inner">
     	<% int count = 0; 
    	for(Field f:fieldList){
    		boolean isHomeField = false;
    		if(team.getHomeField().getId()==f.getId()){
    			isHomeField = true;
    			System.out.println("=================");
    		}
    	
    		if(count==0){%>
        <div class="item active">
       	    <%}else{ %>
         <div class="item">
         	<%} %>
          <img src="../img/field/<%=f.getPicture() %>" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1><%=f.getName() %>
              <% if(isHomeField){%>(主场) <%} %>
              </h1>
              <p class="lead"><%=f.getDesc() %></p>
              <p class="lead">价格:<%=f.getPrice() %> 元/场</p>
              <a class="btn btn-large btn-primary" href="#" id ='full_time'>订全场</a>
               <% if(isHomeField){%> 
               	<a class="btn btn-large btn-primary" href="#" id ='full_time'>摆擂台</a> 
               <%} else{%>
               	<a class="btn btn-large btn-primary" href="#" id ='full_time'>挑战</a> 
               <%} %>
            </div>
          </div>
        </div>
  		
  		<% count++; } %>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div><!-- /.carousel -->
 
  </body>
</html>

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
</script>
  </head>
  <body onload="loadPage()">
    <div id="top_nav"></div>    
       <%TeamDao dao = new TeamDao();
         List<Team> team_list = dao.getAllTeam();
       %>
   
   <label><%=teamDao.getTeam(1).getName() %> </label>
   
   <div>
   		<table id='all_match'>
   			<tr>
   				<td>队名</td>
   				<td>主场</td>
   				<td>创建者</td>
   				<td>申请加入</td>
   			</tr>
   			<%	for(Team team:team_list){
   					
   			%>
   			<tr>
   				<td><%=team.getName() %></td>
   				<td><%=team.getHomeField().getName() %></td>
   				<td><%=team.getAccount().getName() %></td>
   				<input type="button" name="apply" value="申请加入">
   			</tr>
   			<% } %>
   		</table>
   </div>
  </body>
</html>

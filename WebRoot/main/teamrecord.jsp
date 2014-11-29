<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.udcode.dao.*"%>
<%@ page language="java" import="com.udcode.entity.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'team.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">	
	<script src="../bootstrap/js/bootstrap.min.js"></script>
 	<script src="../bootstrap/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		function loadPage() {
			$("#top_nav").load('topnav.html');
		}
	</script>
</head>
  
  <body  onload="loadPage()">
  
	<div id="top_nav"></div>
	<%
	TeamDao teamDao = new TeamDao();

   		List<Match> match_list = teamDao.getAllMatchByTeamId(1);
   		
   		
    %>
   
   <label><%=teamDao.getTeam(1).getName() %> </label>
   
   <div>
   		<table id='all_match'>
   			<tr>
   				<td>日期</td>
   				<td>主队</td>
   				<td>比分</td>
   				<td>客队</td>	
   			</tr>
   			<%	for(Match match:match_list){
   					System.out.println(match.getAwayScore());
   			%>
   			<tr>
   				<td><%=match.getDate() %></td>
   				<td><%=match.getHomeTeam().getName() %></td>
   				<td><%=match.getHomeScore() %> : <%=match.getAwayScore() %></td>
   				<td><%=match.getAwayTeam().getName() %></td>	
   			</tr>
   			<% } %>
   		</table>
   </div>
  </body>
</html>

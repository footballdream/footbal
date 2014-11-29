<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.udcode.dao.*"%>
<%@ page language="java" import="com.udcode.entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'match.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <%MatchDao dao = new MatchDao();
   		List<Match> match_list = dao.getMatch();
   		
   		TeamDao teamDao = new TeamDao();
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

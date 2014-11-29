<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>Config</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">	
	<script src="../bootstrap/js/bootstrap.min.js"></script>
 	<script src="../bootstrap/js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript">
	function loadPage() {
		$("#top_nav").load('topnav.html');
		/*$("#top_nav").load('topnav.html', function(response) {
			$("#top_nav").append(response);

		});*/
	}
</script>
	</head>

	<body onload="loadPage()">
		<div id="top_nav"></div>
		

		<div id="body_div" class="container">
			<form>
				<label>
					队名
				</label>

				<input type="text" name="fname" />
				<br>
			</form>
		</div>

	</body>
</html>

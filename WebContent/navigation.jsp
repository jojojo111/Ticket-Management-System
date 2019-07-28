<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			a{
				text-decoration: none;
				color: blue;
				text-align: center;
			}

			a:hover{
				color: blueviolet;
			}
		</style>
	</head>
	<body bgcolor="gainsboro">
			<a href="<%=path%>/FindAllUserServlet" target="right" ><h2>用户管理</h2></a>
			<a href="<%=path%>/QueryTrainServlet" target="right" ><h2>车次管理</h2></a>
			<a href="<%=path%>/QueryOrderServlet" target="right" ><h2>订单管理</h2></a>
			<a href="login.jsp" target="_top" ><h2>退出系统</h2></a>
	</body>
</html>

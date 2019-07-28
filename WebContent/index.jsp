<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>首页</title>
	</head>
	<frameset rows="25%,*" border="5">
		<frame src="logo.jsp" name="logo" noresize="noresize" />
		<frameset cols="15%,*" border="5">
			<frame src="<%=path%>/navigation.jsp" name="navigation" noresize="noresize" />
			<frame src="<%=path%>/FindAllUserServlet" name="right" noresize="noresize" />
		</frameset>
	</frameset>
</html>

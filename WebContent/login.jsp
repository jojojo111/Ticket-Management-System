<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录界面</title>
		<link rel="stylesheet" href="css/login_css.css" />
		<script type="text/javascript">
			function Isadmin_id()
			{
				var _admin_id = document.getElementById("admin_loginname").value;
				var p = /^\w{3,20}$/;
				if(!p.test(_admin_id))
				{
					window.alert("账户错误，请重新输入！");
					return false;
				}
				return true;
			}
			function Isadmin_loginpwd()
			{
				var _admin_loginpwd = document.getElementById("admin_loginpwd").value;
				var p = /^[0-9]{6}$/;
				if(!p.test(_admin_loginpwd))
				{
					window.alert("密码错误，请重新输入！");
					return false;
				}
				return true;
			}
			function IsLogin()
			{
				if(!(Isadmin_id() && Isadmin_loginpwd()))
				{
					return false;
				}
				return true;
			}
		</script>
	</head>
	<body bgcolor="gainsboro">
		<div id="one">
			<img src="img/logo.png" width="100%" align="center"/>
		</div>
		<div id="two">
			<h2>管理员账户登录</h2>
		<form action="<%=path%>/LoginServlet" method="get"
			onsubmit="return IsLogin();">
			账号：<input type="text" name="admin_loginname" id="admin_loginname"
				size="30" placeholder="请输入3~20位数字、字母或下划线" class="text-border" /><br />
			密码：<input type="password" name="admin_loginpwd" id="admin_loginpwd"
				size="30" maxlength="6" placeholder="请数入六位数字密码" class="text-border" /><br />
			<input type="submit" value="登录" class="text-border"
				style="width: 150px; height: 50;" />
		</form>
	</div>
	<div align="center" >
		<a href="our.jsp" style="text-decoration: none; color:blue;" >关于我们</a>
	</div>
	</body>
</html>

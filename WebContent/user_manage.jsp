<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户管理</title>
		<style type="text/css">
			a{
				text-decoration: none;
				color: #0000FF;
			}
		</style>
		
		<script type="text/javascript">
			function IsUser_cardnumber()
			{
				var _IDcard = document.getElementById("user_cardnumber").value;
				var p = /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
				if(!p.test(_IDcard))
				{
					window.alert("身份证输入不合法，请重新输入！");
					return false;
				}
				return true;
			}
			
			function IsResetPwd(user_id)
			{
				if(window.confirm("确定是否重置用户编号为:" + user_id +"的用户的密码吗?"))
				{
					window.location.href='<%=path%>/ResetPasswordServlet?user_id=' + user_id;
				}
			}
			
			function IsFreezeUser(user_id)
			{
				if(window.confirm("确定冻结用户编号为:" + user_id +"的用户的账户吗?")){
					window.location.href='<%=path%>/FreezeUserServlet?user_id=' + user_id;
				}
			}
			
			function IsUnfreezeUser(user_id)
			{
				if(window.confirm("确定解除冻结用户编号为:" + user_id +"的用户的账户吗?"))
				{
					window.location.href='<%=path%>/UnfreezeUserServlet?user_id=' + user_id;
				}
			}
		</script>
	</head>
	<body bgcolor="gainsboro">
		<div id="divone">
			<h1 align="center">用户管理</h1>
		</div>
		<div id="divtwo" align="right">
			<form action="<%=path%>/CriteriaQueryServlet" method="get" onsubmit="return IsUser_cardnumber();" style="padding: 20px 40px;">
				<input type="text" name="user_cardnumber" size="20" maxlength="18" placeholder="请输入身份证号" id="user_cardnumber" />
				<input type="submit" value="查询"/>
			</form>
		</div>
		<hr align="center" />
		<div id="divthree">
			<table border="2" cellspacing="" cellpadding="" align="center">
				<tr>
					<th>编号</th>
					<th>用户名</th>
					<th>登录密码</th>
					<th>姓名</th>
					<th>身份证号码</th>
					<th>电话号码</th>
					<th>性别</th>
					<th>出生年月</th>
					<th>操作</th>
				</tr>
				<c:choose>
				  	<c:when test="${empty users}">
				  		<tr align="center">
				  			<td colspan="9">查无数据!</td>
				  		</tr>
				  	</c:when>
				  	<c:otherwise>
				  		<c:forEach  items="${users}" var="v">
				  			<tr align="center">
							    <td>${v.user_id}</td>
							  	<td>${v.user_loginname}</td>
							  	<td>${v.user_loginpwd}</td>
							  	<td>${v.user_realname}</td>
							  	<td>${v.user_cardnumber}</td>
							  	<td>${v.user_telephone}</td>
							  	<td>${v.user_gender}</td>
							  	<td>${v.user_birthday }</td>
							  	<td align="left">
							  		<a href="javaScript:IsResetPwd(${v.user_id })" >
							  			<input type="button" value="重置密码" />
							  		</a>
							  		<c:choose>
							  			<c:when test="${v.remark1=='1' }">
							  				<a href="javaScript:IsUnfreezeUser(${v.user_id })">
							  					<input type="button" value="解除冻结" />
							  				</a>
							  			</c:when>
							  			<c:otherwise>
							  				<a href="javaScript:IsFreezeUser(${v.user_id })">
							  					&nbsp;&nbsp;&nbsp;<input type="button" value="冻结" />&nbsp;&nbsp;&nbsp;
							  				</a>
							  			</c:otherwise>
							  		</c:choose>
							  	</td>
						  	</tr>
				  		</c:forEach>
			  		</c:otherwise>
			  	</c:choose>
			  	<tr align="center">
			  	<td colspan="9">总页数：${totalPages }&nbsp;&nbsp;当前页：${currentpage }&nbsp;&nbsp;
					<c:choose>
						<c:when test="${empty user_cardnumber }">
							<a href="<%=path%>/FindAllUserServlet?setcurrentpage=1">首页</a>&nbsp;&nbsp;
							<a href="<%=path%>/FindAllUserServlet?setcurrentpage=${currentpage <=1? 1 :(currentpage-1)}">上一页</a>&nbsp;&nbsp;
							<a href="<%=path%>/FindAllUserServlet?setcurrentpage=${currentpage >=totalPages?totalPages:(currentpage+1)}">下一页</a>&nbsp;&nbsp;
							<a href="<%=path%>/FindAllUserServlet?setcurrentpage=${totalPages }">末页</a>
						</c:when>
						<c:otherwise>
							<a href="<%=path%>/CriteriaQueryServlet?setcurrentpage=1&user_cardnumber=${user_cardnumber}">首页</a>&nbsp;&nbsp;
							<a href="<%=path%>/CriteriaQueryServlet?setcurrentpage=${currentpage <=1? 1 :(currentpage-1)}&user_cardnumber=${user_cardnumber}">上一页</a>&nbsp;&nbsp;
							<a href="<%=path%>/CriteriaQueryServlet?setcurrentpage=${currentpage >=totalPages?totalPages:(currentpage+1)}&user_cardnumber=${user_cardnumber}">下一页</a>&nbsp;&nbsp;
							<a href="<%=path%>/CriteriaQueryServlet?setcurrentpage=${totalPages }&user_cardnumber=${user_cardnumber}">末页</a>&nbsp;&nbsp;
							<a href="<%=path%>/FindAllUserServlet?setcurrentpage=1" style="text-align: right;">返回</a>
						</c:otherwise>
					</c:choose>
			
		
			  		</td>
			  	</tr>
			</table>
		</div>
		
	</body>
</html>



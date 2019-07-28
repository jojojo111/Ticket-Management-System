<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    	String path =request.getContextPath();
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>订单统计</title>
		<script type="text/javascript">
			
			function validate_start_time() {
				var _ordertime = document.getElementById('order_strat').value;
				var pattern = /^$|^(((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29))$/;
				if (!pattern.test(_ordertime)) {
					window.alert('时间格式不正确！');
					return false;
				}
				return true;
			}
			
			function validate_end_time() {
				var _ordertime = document.getElementById('order_end').value;
				var pattern = /^$|^(((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29))$/;
				if (!pattern.test(_ordertime)) {
					window.alert('时间格式不正确！');
					return false;
				}
				return true;
			}
			
			function validate()
			{
				if(validate_start_time()&&validate_end_time())
				{
					return true;
				}
				return false;
			}
			
		</script>
	</head>
	<body bgcolor="gainsboro">
		<center>
			<p><h1>订单统计</h1></p>
			<br><br>
			<form action="<%=path%>/TotalOrderServlet" method="get" onsubmit="return validate();">
			<table  border="1" bordercolor="black">
				<tr>
					<td><font size="4" face="微软雅黑" style="font-weight: bolder;">开始时间:</font></td>
					<td><input placeholder="订单开始时间" id='order_strat' type="text" size="20" maxlength="20" name="order_strat" value="${ order_strat}"></td>
						<td rowspan="2"> 
						<input type="submit" value="提交">
					</td>
				</tr>
				<tr>
					<td><font size="4" face="微软雅黑" style="font-weight: bolder;">结束时间:</font></td>
					<td><input placeholder="订单结束时间" id='order_end' type="text" size="20" maxlength="20" name="order_end" value="${ order_end}"></td>
				</tr>
			</table>
			</form>
			<br>
			<hr align="center">
			<br>
			<div align="center">
			<table  border="1" bordercolor="black">
				<tr>
					<th><font size="4" face="微软雅黑" style="font-weight: bolder;">座位类型</font></th>
					<th><font size="4" face="微软雅黑" style="font-weight: bolder;">订单总金额(元)</font></th>
					<th><font size="4" face="微软雅黑" style="font-weight: bolder;">订单总数</font></th>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${empty data}">
							<tr>
								<td colspan="9">未统计到任何信息!</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${data}" var="v">
								<tr>
									<td>${v[0]}</td>
									<td>${v[1]}</td>
									<td>${v[2]}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
			</div>
			<br><br>
			<a href="<%=path%>/TotalOrderServlet"><button type="button">继续统计</button></a>
			<a href="<%=path%>/QueryOrderServlet?setcurrentpage=1"><button type="button">返回</button></a>
			<br><br>
		</center>
	</body>
</html>

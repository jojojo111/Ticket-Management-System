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
		<title>订单管理</title>
		<link rel="stylesheet" href="css/pagestyle.css" />
		<script type="text/javascript">
			function validate_ordernumber(){
				var _ordernumber = document.getElementById('ordernumber').value;
				var pattern = /^$|^([0-9]{15})$/;
				if(!pattern.test(_ordernumber))
				{
					window.alert('订单编号位数不正确！');
					return false;
				}
				return true;
			}
			function IsUser_cardnumber()
			{
				var _IDcard = document.getElementById('user_cardnumber').value;
				var p = /^$|^([1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx])$/;
				if(!p.test(_IDcard))
				{
					window.alert("身份证输入不合法，请重新输入！");
					return false;
				}
				return true;
			}

			function validate_ordertime(){
				var _ordertime = document.getElementById('ordertime').value;
				var pattern = /^$|^(((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29))$/;
				if(!pattern.test(_ordertime))
				{
					window.alert('时间格式不正确！');
					return false;
				}
				return true;
			}
			
			function validate()
			{
				if(validate_ordernumber()&&IsUser_cardnumber()&&validate_ordertime())
				{
					return true;
				}
				return false;
			}
		</script>
	</head>
	
	<body bgcolor="gainsboro" >
		<center>
			<h1>订单管理</h1>
			<form action="<%=path%>/QueryOrderServlet" method="get" onsubmit="return validate();">
			<table  border="1" bordercolor="black">
				<tr>
					<td><font size="4" face="微软雅黑" style="font-weight: bolder;">订单编号：</font></td>
					<td><input placeholder="按照订单编号查询" id='ordernumber' type="text" size="20" maxlength="20" name="order_number" value="${order_number}"></td>
					<td><font color="red" size="2" face="黑体">*长度为15位哦！</font></td>
					<td rowspan="3"><input type="submit" value = "查询" ></td>
				</tr>
				<tr>
					<td><font size="4" face="微软雅黑" style="font-weight: bolder;">用户身份证号：</font></td>
					<td><input placeholder="按照用户身份证号查询" id='user_cardnumber' type="text" size="20" maxlength="20" name="user_cardnumber" value="${user_cardnumber}"></td>
					<td><font color="red" size="2" face="黑体">*长度为18位哦！</font></td>
				</tr>
				<tr>
					<td><font size="4" face="微软雅黑" style="font-weight: bolder;">创建时间：</font></td>
					<td><input placeholder="按照创建时间查询"  id='ordertime' type="text" size="20" maxlength="20" name="order_creation_time" value="${order_creation_time}"></td>
					<td><font color="red" size="2" face="黑体">*时间格式为：xxxx(年)-xx(月)-xx(日)哦！</font></td>
				</tr>
			</table>
			</form>
			<br>
			<hr align="center">
			<br>
				<td><font size="3" face="微软雅黑" style="font-weight: bolder;">查询结果：共 </font></td>
				<td><font size="3" face="微软雅黑" style="font-weight: bolder;" color="blue"> ${result} </font></td>
				<td><font size="3" face="微软雅黑" style="font-weight: bolder;">条记录</font></td>
			<br><br>
	<table border="1">
	<tr>
	    <td>订单编号</td>
	  	<td>用户真实姓名</td>
	  	<td>用户身份证号</td>
	  	<td>用户车次信息</td>
	  	<td>订单创建时间</td>
	  	<td>订单价格</td>
	  	<td>订单支付类型</td>
	  	<td>用户联系方式</td> 	
	  	<td>用户座位类型</td>
  	</tr>
  	<c:choose>
  		<c:when test="${empty data}">
  			<tr>
  				<td colspan="9">未查询到任何信息!</td>
  			</tr>
  		</c:when>
  	<c:otherwise>
  		<c:forEach  items="${data}" var="v">
  			<tr>
		    	<td>${v[0]}</td>
		  		<td>${v[1]}</td>
		  		<td>${v[2]}</td>
		  		<td>${v[3]}</td>
		  		<td>${v[4]}</td>
		  		<td>${v[5]}</td>
		  		<td>${v[6]}</td>
		  		<td>${v[7]}</td>  
		  		<td>${v[8]}</td>
		 	</tr>
  		</c:forEach>
  	</c:otherwise>
  </c:choose>
  <tr>
				<td colspan="9">总页数:${totalpage}&nbsp;&nbsp; 当前页:${currentPage }&nbsp;&nbsp;
					<a 
					href="<%=path%>/QueryOrderServlet?setcurrentpage=1&order_number=${order_number}&user_cardnumber=${user_cardnumber}&order_creation_time=${order_creation_time}">首页</a>&nbsp;&nbsp;
					<a
					href="<%=path%>/QueryOrderServlet?setcurrentpage=${currentPage <=1? 1 :(currentPage-1)}&order_number=${order_number}&user_cardnumber=${user_cardnumber}&order_creation_time=${order_creation_time}">上一页</a>&nbsp;&nbsp;
					<a
					href="<%=path%>/QueryOrderServlet?setcurrentpage=${currentPage >=totalpage?totalpage:(currentPage+1)}&order_number=${order_number}&user_cardnumber=${user_cardnumber}&order_creation_time=${order_creation_time}">
						下一页 </a>&nbsp;&nbsp; <a
					href="<%=path%>/QueryOrderServlet?setcurrentpage=${totalpage }&order_number=${order_number}&user_cardnumber=${user_cardnumber}&order_creation_time=${order_creation_time}">末页
				</td>

			</tr>
</table><br><br>
	<a href="<%=path%>/QueryOrderServlet"><button type="button">继续查询</button></a>
	<a href="order_total.jsp"><button type="button">订单统计</button></a>
</center>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path =request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" href="css/pagestyle.css" />
		<meta charset="UTF-8">
		<title>checiguanli.html</title>
		<script type="text/javascript">	
			function validatefirstname() {
				var _train_start = document.getElementById('train_start').value;
				var pattern = /$|[\u4E00-\u9FA5\uF900-\uFA2D]/;
				if (!pattern.test(_train_start)) {
					window.alert('起始站名输入不合法');
					return false;
				}
				return true;
			}
			function validatelastname() {
				var _train_end = document.getElementById('train_end').value;
				var pattern = /$|[\u4E00-\u9FA5\uF900-\uFA2D]/;
				if (!pattern.test(_train_end)) {
					window.alert('目标站名输入不合法');
					return false;
				}
				return true;
			}
			function validatetime() {
				var _train_start_time = document.getElementById('train_start_time').value;
				var p = /$|^(?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]$/;
				if (!p.test(_train_start_time)) {
					window.alert('出发时间输入不合法');
					return false;
				}
				return true;
			}
			function validateuser() {
				if (validatefirstname() && validatelastname() && validatetime()) {
					//alert("查找成功");
					return true;
				}
				else
					return false;

			}
			function delectTrain(train_id){
				//console.log(uid);
				if(window.confirm("确定是否删除车次编号为:" + train_id +"的车次信息吗?")){
					window.location.href='<%=path%>/DelTrainServlet?train_id=' + train_id;
				}
				
			}
			function recoverTrain(train_id){
				if(window.confirm("确定是否恢复车次编号为:" + train_id +"的车次信息吗?")){
					window.location.href='<%=path%>/RecoverTrainServlet?train_id=' + train_id;
				}
				
			}
			function findTrainById(train_id)
			{
				window.location.href='<%=path%>/UpdateTrainInputServlet?train_id='+train_id;
			}
		</script>
	</head>
	<body bgcolor="gainsboro">
		<div>
		<center>
				<h1>车次管理</h1>
		</center>
		<center>
		<form action="<%=path%>/QueryTrainServlet" method="get"  onsubmit="return validateuser()">
			<tr>
				<td>车次号:</td>
				<td><input type="text" maxlength="20"  id="train_number"  name="train_number" value="${train_number }"/></td>
				<td>始发地:</td>
				<td><input type="text" maxlength="20" id="train_start"  name="train_start" value='${train_start }'/></td>
				<td>到达地:</td>
				<td><input type="text" maxlength="20" id="train_end" name="train_end" value='${train_end }'/></td>
				<td>出发时间:</td>
				<td><input type="datetime" maxlength="20" id="train_start_time" name="train_start_time" value='${train_start_time }'/></td>
				<td><a href="<%=path%>/QueryTrainServlet"><input type="submit" name="submit" value="查找" /></a></td>
				<td><a href="AddTrain.jsp"><button type="button">添加</button></a></td>
				<br/>
				<hr size="3"></hr>
			<hr >
			</tr>
		   </form>
		   <table border="1">
		   		<tr>
			   		<th>车次默认编号</th>
			   		<th>车次</th>
			   		<th>起始站</th>
			   		<th>目的站</th>
			   		<th>开始时间</th>
			   		<th>到站时间</th>
			   		<th>运行时间</th>
			   		<th>软卧数量</th>
			   		<th>硬卧数量</th>
			   		<th>硬座数量</th>
			   		<th>站票数量</th>
			   		<th>软卧票价</th>
			   		<th>硬卧票价</th>
			   		<th>硬座票价</th>
			   		<th>站票票价</th>
			   		<th>管理员编号</th>
			   		<th>操作</th>
		   		</tr>
		   		<c:choose>
  					<c:when test="${empty data}">
  						<tr>
  							<td colspan="17">查无数据!</td>
  						</tr>
  					</c:when>
  					<c:otherwise>
  						<c:forEach  items="${data}" var="v">
  							<tr>
							    <td>${v.train_id}</td>
							  	<td>${v.train_number}</td>
							  	<td>${v.train_start}</td>
							  	<td>${v.train_end}</td>
							  	<td>${v.train_start_time}</td>
							  	<td>${v.train_end_time}</td>
							  	<td>${v.train_runtime}</td>
							  	<td>${v.soft_berth_number }</td>
							  	<td>${v.hard_berth_number}</td>
							  	<td>${v.hard_seat_number}</td>
							  	<td>${v.stand_number}</td>
							  	<td>${v.soft_berth_price}</td>
							  	<td>${v.hard_berth_price}</td>
							  	<td>${v.hard_seat_price}</td>
							  	<td>${v.stand_price}</td>
							  	<td>${v.admin_id}</td>
							  	<td>
							  	<a href="javaScript:findTrainById(${v.train_id})"><input type="button" value="修改" /></a>
							  		<c:choose>
							  			<c:when test="${v.remark1=='1' }">
							  				<a href="javaScript:recoverTrain(${v.train_id })">
							  					<input type="button" value="恢复" />
							  				</a>
							  			</c:when>
							  			<c:otherwise>
							  				<a href="javaScript:delectTrain(${v.train_id })"><input type="button" value="删除" />
							  				</a>
							  			</c:otherwise>
							  		</c:choose>
							  	</td> 
		  					</tr>
  						</c:forEach>
  					</c:otherwise>
 			 	</c:choose>
 			 	  <tr align="center">
  			<td colspan="17">总页数:${totalpage }&nbsp;&nbsp;
  			当前页:${currentpage }&nbsp;&nbsp;
  			<a href="<%=path%>/QueryTrainServlet?setcurrentpage=1&train_number=${train_number}&train_start=${train_start}&train_end=${train_end}&train_start_time=${train_start_time}">首页</a>&nbsp;&nbsp;
  			 <a href="<%=path%>/QueryTrainServlet?setcurrentpage=${currentpage <=1? 1 :(currentpage-1)}&train_number=${train_number}&train_start=${train_start}&train_end=${train_end}&train_start_time=${train_start_time}">上一页</a>&nbsp;&nbsp;
  			<a href="<%=path%>/QueryTrainServlet?setcurrentpage=${currentpage >=totalpage?totalpage:(currentpage+1)}&train_number=${train_number}&train_start=${train_start}&train_end=${train_end}&train_start_time=${train_start_time}">  下一页  </a>&nbsp;&nbsp;
  			 <a href="<%=path%>/QueryTrainServlet?setcurrentpage=${totalpage }&train_number=${train_number}&train_start=${train_start}&train_end=${train_end}&train_start_time=${train_start_time}">末页</td>
  
  </tr>
		   </table></center>
	</div>
	</body>
</html>

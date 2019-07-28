<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%> 
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>12306</title>
	<!-- 引入外部css文件 -->
	<link rel="stylesheet" href="css/our.css" />
</head>
<body>
<!-- 顶部导航栏开始-->
	<div class="header">
		<div class="inner">
			<div class="logo"> 
				<a href="login.jsp" target="_top"><img src="img/logo.jpg" /></a>
			</div>
			<div class="nav"> 
				<ul>
					<li><a href="login.jsp" target="_top" ><h3>12306登录</h3></a></li>
				</ul>
			</div>
		</div>
	</div>
<!-- 顶部导航栏结束  -->

   <!-- banner 开始 -->
   <div class="banner">
   		<img src="img/banner.jpg" alt="" />
   </div>
   <!-- banner 结束 -->

   <!-- 项目介绍模块 start -->
   <div class="service">
   		<div class="service-hd">
   			<h3>项目介绍</h3>
   			<p>铁道部12306即中国铁路客户服务中心是铁路服务客户的重要窗口，
   				将集成全路客货运输信息，为社会和铁路客户提供客货运输业务和公共信息查询服务。
   				客户通过登录本网站，可以查询旅客列车时刻表、票价、列车正晚点、车票余票、
   				售票代售点、车次类型、车辆技术参数等。
   				铁路货运大客户可以通过本网站办理业务。
   			</p>
   		</div>
   </div>
<!-- 项目介绍模块 end -->
<!-- 功能实现模块开始 -->
   <div class="case">
	   	<div class="service-hd">
	   			<h3>功能实现</h3>
	   			<h6>用户管理</h6>
	   			<p>此模块可以通过输入用户的身份证号，获取用户的信息，进行查找，对用户进行管理，重置密码、冻结账户等。
	   			</p>
	   			<h6>车次管理</h6>
	   			<p>此模块主要实现了四个功能，通过输入车次的车次号、始发地、到达地、时间信息，
	   				进行查找车次信息。增加车次信息，删除车次信息，修改车次信息。
	   			</p>
	   			<h6>订单管理</h6>
	   			<p> 此模块是通过订单编号、创建时间，对订单信息进行查询以及统计。
	   			</p>
	   	</div>
   </div>
 <!-- 功能实现模块结束 -->
 <!-- 团队介绍开始 -->
   <div class="case">
	   	<div class="service-hd">
	   			<h3>团队介绍</h3>
	   			<p>
	   				我们的团队成员由西安财经大学计算机专业大三学生组成。组长：韩东，成员：王恒、郭鹏哲、董银磊、郗瑞。
	   				组长韩冬负责统筹管理、分工、整合任务。
	   				王恒、郗瑞主要负责用户管理模块功能实现，其中王恒具体实现查询、冻结账户、连接池等工作，郗瑞实现重置密码操作。
	   				郭鹏哲主要负责订单管理模块功能实现，具体实现按条件查询订单，订单统计操作。
	   				董银磊、郭鹏哲、郗瑞主要负责车次管理模块功能实现，其中董银磊具体实现增查操作，郭鹏哲实现修改车次信息操作，郗瑞实现删除操作。
	   				
	   			</p>
	   			<p>
	   				团队人数：5人
	   			</p>
	   			<p>
	   				团队理念：一个优秀的团队文化酿造出优秀的人。
	   			</p>
	   			<p>
	   				服务项目：12306铁道部火车票网上购票系统。
	   			</p>
	   			<div align="center">
	   				<img alt="" src="img/our.jpg" class="our" >
	   			</div>
	   	</div>
   </div>
 <!-- 团队介绍结束 -->
<!-- 页面底部开始 -->
<div class="footer">
	<div class="subnav">
	联系电话：13256784567<br />
	email：132567845677@163.com<br>
		<a href="login.jsp" target="_top">12306</a> |
		<a href="https://www.amap.com/">高德地图</a> 
	</div>
</div>
</body>
</html>
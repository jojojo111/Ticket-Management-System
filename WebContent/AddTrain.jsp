<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改车次信息</title>
<script type="text/javascript">
	function IsAddUser() {
		/*var _train_number = document.getElementById("train_number").value;
		var pattern1 = /^[a-zA-Z]{1,2}[0-9]{3}$/;
		if (!pattern1.test(_train_number)) {
			window.alert("车次号输入不合法");
			return false;
		}*/

		var _train_start = document.getElementById("train_start").value;
		var _train_end = document.getElementById("train_end").value;
		var pattern2 = /[\u4E00-\u9FA5\uF900-\uFA2D]/;
		if (!pattern2.test(_train_start) || !pattern2.test(_train_end)) {
			window.alert("站名输入不合法");
			return false;
		}

		var _train_start_time = document.getElementById("train_start_time").value;
		var _train_end_time = document.getElementById("train_end_time").value;
		var _train_runtime = document.getElementById("train_runtime").value;
		var pattern3 = /^(([0-1]?[0-9])|2[0-3]):([0-5][0-9])$/;
		if (!pattern3.test(_train_start_time)
				|| !pattern3.test(_train_end_time)
				|| !pattern3.test(_train_runtime)) {
			window.alert("时间输入不合法");
			return false;
		}

		var _soft_berth_number = document.getElementById("soft_berth_number").value;
		var _soft_berth_price = document.getElementById("soft_berth_price").value;
		var _hard_berth_number = document.getElementById("hard_berth_number").value;
		var _hard_berth_price = document.getElementById("hard_berth_price").value;
		var _hard_seat_number = document.getElementById("hard_seat_number").value;
		var _hard_seat_price = document.getElementById("hard_seat_price").value;
		var _stand_number = document.getElementById("stand_number").value;
		var _stand_price = document.getElementById("stand_price").value;

		var pattern4 = /^[0-9][0-9]{0,3}$/;
		if (!pattern4.test(_soft_berth_number)
				|| !pattern4.test(_hard_berth_number)
				|| !pattern4.test(_hard_seat_number)
				|| !pattern4.test(_stand_number)) {
			window.alert("座位数输入不合法");
			return false;
		}

		var p = /(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/;
		if (!p.test(_soft_berth_price) || !p.test(_hard_berth_price)
				|| !p.test(_hard_seat_price) || !p.test(_stand_price)) {
			window.alert("票价输入不合法");
			return false;
		}

		var _admin_id = document.getElementById("admin_id").value;
		var p = /^[1-9][0-9]?$/;
		if (!p.test(_admin_id)) {
			window.alert("管理员编号输入不合法");
			return false;
		}

		return true;
	}
</script>
</head>
<center>
<body bgcolor="gainsboro">
	<div>
		<h1>增加车次</h1>
		<form action="<%=path%>/AddTrainServlet" method="get" onsubmit="return IsAddUser()">
			<input type='hidden' name='train_id' value='${ obj.train_id }' >
			<table border="1"> 
				<tr>
					<td>车次号：</td>
					<td><input type="text" id="train_number" maxlength="20"
						name="train_number" value = "${ obj.train_number }"/></td>
				</tr>
				<tr>
					<td>始发站：</td>
					<td><input type="text" id="train_start" maxlength="20"
						name="train_start" value = "${ obj.train_start } " /></td>
				</tr>
				<tr>
					<td>到达站：</td>
					<td><input type="text" id="train_end" maxlength="20"
						name="train_end"  value = "${ obj.train_end }" /></td>
				</tr>
				<tr>
					<td>出发时间：</td>
					<td><input type="text" id="train_start_time" maxlength="20"
						name="train_start_time" value = "${obj.train_start_time }" /></td>
				</tr>
				<tr>
					<td>到达时间：</td>
					<td><input type="text" id="train_end_time" maxlength="20"
						name="train_end_time"  value = "${obj.train_end_time }" /></td>
				</tr>
				<tr>
					<td>运行时间：</td>
					<td><input type="text" id="train_runtime" maxlength="20"
						name="train_runtime" value = "${obj.train_runtime }"/></td>
				</tr>
				<tr>
					<td>软卧位：</td>
					<td>座位数： <input type="text" id="soft_berth_number"
						maxlength="20" name="soft_berth_number"  value = "${obj.soft_berth_number }"/> 票价： <input type="text"
						id="soft_berth_price" maxlength="20" name="soft_berth_price"  value = "${obj.soft_berth_price }"/></td>
				</tr>
				<tr>
					<td>硬卧位：</td>
					<td>座位数： <input type="text" id="hard_berth_number"
						maxlength="20" name="hard_berth_number"  value = "${obj.hard_berth_number }"/> 票价：<input type="text"
						id="hard_berth_price" maxlength="20" name="hard_berth_price" value = "${obj.hard_berth_price }"/></td>
				</tr>
				<tr>
					<td>硬座位：</td>
					<td>座位数：<input type="text" id="hard_seat_number"
						maxlength="20" name="hard_seat_number"  value = "${obj.hard_seat_number }"/> 票价：<input type="text"
						id="hard_seat_price" maxlength="20" name="hard_seat_price"  value = "${obj.hard_seat_price }"/></td>
				</tr>
				<tr>
					<td>站票位：</td>
					<td>站票数：<input type="text" id="stand_number" maxlength="20"
						name="stand_number"  value = "${obj.stand_number }"/> 票价：<input type="text" id="stand_price"
						maxlength="20" name="stand_price"  value = "${obj.stand_price }"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<input type="submit" name="submit" value="确定" />
							<a href="<%=path%>/QueryTrainServlet"><input type="button" name="submit" value="取消" /></a>
						</center>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</center>
</html>
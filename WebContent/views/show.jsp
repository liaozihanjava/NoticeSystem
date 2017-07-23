<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript" src="static/js/jquery-3.1.0.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<form id="updateForm" name="updateForm" action="/sss/user/update">
		<table>
			<tr>
				<td>用户编号</td>
				<td>${user1.empno}</td>
			</tr>
			<tr>
				<td>用户姓名</td>
				<td><input type="text" id="name" name="name"
					value="${user1.name}"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" id="phone" name="phone"
					value="${user1.phone}"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" id="email" name="email"
					value="${user1.email}"></td>
			</tr>
			<tr>
				<td>部门名称</td>
				<td>${dept1.dname}</td>
			</tr>
		</table>
		<input type="submit" value="修改">
	</form>
</body>
</html>
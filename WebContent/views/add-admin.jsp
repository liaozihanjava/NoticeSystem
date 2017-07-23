<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>员工添加</title>
<link rel="stylesheet" href="/sss/css/Normalize.css">
<!-- Bootstrap -->
<link href="/sss/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/sss/css/add-admin.css">
<link rel="stylesheet" href="/sss/css/navbar-theme.css">

</head>
<%-- <body>
	<a type="button" href="/sss/user/show.do?empno=${user1.empno}">个人信息</a>
	<a type="button" href="/sss/user/preshow.do?empno=${user1.empno}">修改个人信息</a>
	<a type="button" href="/sss/views/insert_notice.jsp">发布公告</a>
	<a type="button" href="/sss/notice/showonesnotice.do">历史操作</a>
	<a type="button"
		href="/sss/draft/showonesdraft.do?empno=${user1.empno}">查看草稿箱</a>
	<a type="button" href="/sss/user/logout.do">退出登录</a>
</body>
 --%>

<body>
	<c:if test="${user1.level==0 }">
	<nav class="navbar navbar-superadmin">
	</c:if>
<c:if test="${user1.level==1 }">
	<nav class="navbar navbar-inverse">
	</c:if>
<c:if test="${user1.level==2 }">
	<nav class="navbar navbar-admin">
	</c:if>
<c:if test="${user1.level==3 }">
	<nav class="navbar navbar-default">
	</c:if>
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/sss/page/jump">NMS公告管理系统</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="/sss/notice/showall.do">公告查看</a></li>
				<c:if test="${user1.level==1 }">
					<li><a href="/sss/notice/showun.do">公告审核</a></li>
				</c:if>
				<c:if test="${user1.level<3 }">
					<li><a
						href="/sss/user/finddeptusesr.do?deptno=${user1.deptno}">发布公告</a></li>
				</c:if>
				<c:if test="${user1.level==0 }">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">员工管理<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class="active"><a href="/sss/page/jumptoadminmanage">添加/删除员工</a></li>
							<li><a href="/sss/user/showAll.do">查看所有员工</a></li>
						</ul>
					</li>
				</c:if>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">个人中心<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a
							href="/sss/user/show.do?empno=${user1.empno}">个人资料</a></li>
						<c:if test="${user1.level<3 }">
							<li><a href="/sss/notice/showonesnotice.do">部门历史操作</a></li>
						</c:if>
						<c:if test="${user1.level<3 }">
							<li><a
								href="/sss/draft/showonesdraft.do?empno=${user1.empno}">草稿箱</a></li>
						</c:if>
						<li role="separator" class="divider"></li>
						<li><a href="/sss/user/logout.do">退出登录</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="notice-show">
		<div class="container">
			<div class="row">
				<div class="">
					<div class="container">
						<div class="panel panel-default">
							<div class="panel-heading">管理员操作</div>
							<div class="panel-body">
								<form class="form-horizontal">
									<div class="col-md-8 col-xs-6 col-sm-8">
										<div class="form-group">
											<label for="username" class="col-md-2 control-label">员工姓名</label>
											<div class="col-md-8">
												<input type="text" class="form-control" id="username"
													placeholder="请填写员工姓名" value="">

											</div>
										</div>
										<div class="form-group">
											<label for="phonenum" class="col-md-2 control-label">电话号码</label>
											<div class="col-md-8">
												<input type="number" class="form-control" id="phonenum"
													placeholder="请填写电话号码" maxlength="11">
											</div>
										</div>
										<div class="form-group">
											<label for="password" class="col-md-2 control-label">登录密码</label>
											<div class="col-md-8">
												<input type="password" class="form-control" id="password"
													placeholder="请填写登录密码">
											</div>
										</div>
										<div class="form-group">
											<label for="email" class="col-md-2 control-label">邮箱地址</label>
											<div class="col-md-8">
												<input type="email" class="form-control" id="email"
													placeholder="请填写邮箱地址" required="required">
											</div>
										</div>
										<div class="form-group">
											<label for="notice-title" class="col-md-2 control-label">所在部门</label>
											<div class="col-md-8">
												<select class="form-control" id="selectDepartment">
													<option value="" disabled="disabled" selected="selected"></option>
													<c:forEach items="${dept_list}" var="dept">
													<option value="${dept.deptno}">${dept.dname }</option>
													</c:forEach>
												</select>
											</div>


										</div>
										<div class="form-group">
											<label for="notice-title" class="col-md-2 control-label">员工级别</label>
											<div class="col-md-8">
												<select class="form-control" id="selectLevel">
													<option value="" disabled="disabled" selected="selected"></option>
													<option value="2">部门管理员</option>
													<option value="3">普通员工</option>

												</select>
											</div>

										</div>

									</div>

									<!--   <button type="" class="btn btn-success" id="deploy">发布公告</button>
            <button type="" class="btn btn-primary">保存草稿</button> -->
									<div class="">
										<div class="col-md-3 col-xs-6 col-sm-3 operate-area">
											<button type="" class="btn btn-success" id="add-emp">添加此员工</button>
											<button type="" class="btn btn-danger" id="delete-emp">删除此员工</button>
										</div>
									</div>
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/sss/js/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/sss/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		var personInfo = {};
		function collectInfo() {
			personInfo["name"] = $("#username").val();
			personInfo["phone"] = $("#phonenum").val();
			personInfo["email"] = $("#email").val();
			personInfo["deptno"] = $("#selectDepartment").val();
			personInfo["password"] = $("#password").val();
			personInfo["level"] = $("#selectLevel").val();
			for(var key in personInfo){ 
				if(!personInfo[key]){
					alert("信息不完整，请检查后重新提交！");
					return false; 
				}else{
					return true;
				}
				
			}
		}

		$("#add-emp").click(function(e) {
			e.preventDefault();
			if(!collectInfo()){
				return false;
			}
			console.log(personInfo);
			$.ajax({
				data : JSON.stringify(personInfo),
				url : '/sss/user/insert',
				contentType : 'application/json',
				method : 'post',
				success : function(data) {
					if (data == "1") {
						alert("用户名已存在！");
					} else if (data == "2") {
						alert("添加失败！");
					} else {
						alert("添加成功！");
						window.location.href = data;
						console.log(data);
					}
				},
				error : function(data) {
					// body...
				}
			})
		});

		$("#delete-emp").click(function(e) {
			e.preventDefault();
			console.log(personInfo);
			collectInfo();
			if(!personInfo["name"]){
				alert("员工姓名不能为空！");
				return false;
			}
			$.ajax({
				data : JSON.stringify(personInfo),
				url : '/sss/user/delete',
				contentType : 'application/json',
				method : 'post',
				success : function(data) {
					alert("删除成功！");
					window.location.href = data;
					console.log(data);
				},
				error : function() {
					// body...
				}
			})
		});
	</script>
	<%
		session.setAttribute("inserterrors", null);
		session.setAttribute("deleteerrors", null);
	%>
</body>
</html>
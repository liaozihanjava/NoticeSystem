<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>

<link rel="stylesheet" href="/sss/css/Normalize.css">
<!-- Bootstrap -->
<link href="/sss/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/sss/css/personal.css">
<!-- Bootstrap -->
<link rel="stylesheet" href="/sss/css/notice.css">
<link rel="stylesheet" href="/sss/css/personal.css">
<link rel="stylesheet" href="/sss/css/navbar-theme.css">
</head>
<%-- <body>
	<form id="updateForm" name="updateForm" action="/sss/user/update">
		<table>
			<tr>
				<td>用户编号</td>
				<td>${user1.empno}</td>
			</tr>
			<tr>
				<td>用户姓名</td>
				<td>
				${user1.name}</td>
			</tr>
			<tr>
				<td>电话</td>
				<td>${user1.phone}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					${user1.email}</td>
			</tr>
			<tr>
				<td>部门名称</td>
				<td>${dept1.dname}</td>
			</tr>
		</table>
	</form>
</body> --%>




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
				<li class="dropdown active"><a href="#" class="dropdown-toggle"
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
	<!-- /.container-fluid -->
	</nav>
	<div class="personal-content">
		<div class="container">
			<div class="personal-info col-md-6 col-md-offset-3">
				<table class="table table-hover">
					<tbody>
						<tr>
							<td>用户编号</td>
							<td>${user1.empno}</td>
						</tr>
						<tr>
							<td>用户姓名</td>
							<td>${user1.name}</td>
						</tr>
						<tr>
							<td>电话</td>
							<td>${user1.phone}</td>
						</tr>
						<tr>
							<td>Email</td>
							<td>${user1.email}</td>
						</tr>
						<tr>
							<td>部门名称</td>
							<td>${dept1.dname}</td>
						</tr>
					</tbody>
				</table>

				<div class="operate-area">
					<div class="">
						<a class="btn btn-success" href="#" role="button"
							data-toggle="modal" data-target="#exampleModal"
							data-whatever="@mdo">编辑个人信息</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">编辑个人信息</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="recipient-name" class="control-label">用户名：</label> <input
								type="text" class="form-control" id="recipient-name" value="" required="required">
						</div>
						<div class="form-group">
							<label for="phone-number" class="control-label">电话号码</label> <input
								class="form-control" id="phone-number" value="" required="required" maxlength="11">
						</div>
						<div class="form-group">
							<label for="email" class="control-label">邮箱</label> <input
								class="form-control" id="email" value="" required="required"  maxlength="30">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="saveinfo">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/sss/js/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/sss/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#saveinfo").click(function(e) {

			e.preventDefault();

			var personData = {};

			personData["name"] = $("#recipient-name").val();

			personData["phone"] = $("#phone-number").val();

			personData["email"] = $("#email").val();
			
			for(var key in personData){
				if(!personData[key]){
					alert("用户信息不完整，请重新输入！");
					return false;
				}
			}

			$.ajax({

				data : JSON.stringify(personData),

				url : '/sss/user/update.do',

				method : 'post',

				contentType : 'application/json',

				success : function(data) {

					alert("信息修改成功");
					window.location.href = data;

				},

				error : function(data) {

					// body...

				}

			});

		});
	</script>

</body>

</html>
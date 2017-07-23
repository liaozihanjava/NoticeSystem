<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>草稿列表</title>
<link rel="stylesheet" href="/sss/css/Normalize.css">
  <!-- Bootstrap -->
  <link href="/sss/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="/sss/css/notice.css">
  <link rel="stylesheet" href="/sss/css/navbar-theme.css">
  
</head>
<%-- <body>

	<table>
		<tr>
			<td>No</td>
			<td>公告内容</td>
			<td>操作</td>
			<td>操作</td>
			
		</tr>
		<c:forEach items="${draft_list}" var="draft">
		<tr>
		     <td>${draft.dno}
		     
		     </td>
		     
		     <td>${draft.content}</td>
		     <td><a href="/sss/draft/detail.do?dno=${draft.dno}">编辑</a></td>
		     <td><a href="/sss/draft/delete.do?dno=${draft.dno}">删除</td>
			<td>
		</tr>
		</c:forEach>
	</table>
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
				<li><a href="/sss/user/finddeptusesr.do?deptno=${user1.deptno}">发布公告</a></li>
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
          <div class="panel panel-default">
          <div class="panel-heading">草稿箱</div>
            <div class="bs-example" data-example-id="hoverable-table">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>No</th>
                  <th>草稿标题</th>
                  <th>编辑时间</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${draft_list}" var="draft" varStatus="status">
                <tr>
                  <th scope="row">${status.count}</th>
                  <td>${draft.title }</td>
                  <td>${draft.date}</td>
                  <td><a class="btn btn-success" href="/sss/draft/detail.do?dno=${draft.dno}" role="button">编辑</a></td>
                </tr>
                 </c:forEach>
              </tbody>
            </table>
          </div>
          </div>
          
        </div>
      </div>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="/sss/js/jquery.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="/sss/js/bootstrap.min.js"></script>
    </body>


</html>
<%@page import="com.nms.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告发布</title>
<link rel="stylesheet" href="/sss/css/Normalize.css">
<!-- Bootstrap -->
<link href="/sss/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/sss/css/notice-deploy.css">
<link rel="stylesheet" href="/sss/css/navbar-theme.css">

</head>
<%-- <body>
	<form id="insertNoticeForm" name="insertNoticeForm"
		action="/sss/notice/insert">
		<table>

			<tr>
				<td>公告内容</td>
				<td><input type="textarea" id="content" name="content"></td>
			</tr>
			<tr>
				<td>发布类型</td>
				<%
					User user = (User) request.getSession().getAttribute("user1");

					if (user.getLevel() == 0 || user.getLevel() == 1) {
				%>

				<td><select name="type" id="type">
						<option value="1">公司公文</option>
						<option value="2">部门公文</option>
						<option value="3">个人公文</option>
				</select></td>

				<%
					}
				%>
				<%
					if (user.getLevel() == 2) {
				%>

				<td><select name="type" id="type">
						<option value="2">部门公文</option>
						<option value="3">个人公文</option>
				</select></td>

				<%
					}
				%>
			</tr>
		</table>
		<input type="submit" value="发布">
	</form>
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
	<div class="input-detail">
		<div class="container">
			<form>
				<div class="form-group">
					<!-- <label for="notice-title">公告标题</label> -->
					<input type="text" class="form-control" id="notice-title"
						placeholder="请填写公告标题">
				</div>
				<div class="form-group">
					<!-- <label for="exampleInputPassword1">公告详情</label> -->
					<textarea rows="20" type="text" class="form-control"
						id="notice-detail" placeholder="请填写公告详情"></textarea>
				</div>
				<div class="form-group select-type">
					<label for="notice-title">请选择公告类型</label> 
					<select class="form-control" id="selectType">
						<option value="0" disabled="disabled" selected=""></option>
						<c:if test="${user1.level!=1 }">
						<option  value="3">个人公告</option>
						</c:if>
						<c:if test="${user1.level==1 }">
						<option  value="1">公司公告</option>
						</c:if>
						<c:if test="${user1.level!=1 }">
						<option  value="2">部门公告</option>
						</c:if>
					</select> <span class="display-selected-user label label-warning"></span>
				</div>

				<button type="" class="btn btn-success" id="deploy">发布公告</button>
				<button type="" class="btn btn-primary" id="savedraft">保存草稿</button>
			</form>
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
					<h4 class="modal-title" id="exampleModalLabel">请选择待接收用户</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="notice-title">请选择用户:</label> <select
								class="form-control" id="selectUser"> 
							
								<option value="" disabled="disabled" selected=""></option>
								<c:forEach items="${user_list}" var="user">
								<option value="${user.empno }">${user.name }</option>
								</c:forEach>
								
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<span class="display-selected-user label label-success"></span>
					<button type="button" class="btn btn-default" data-dismiss="modal">确认</button>
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
    var receiver = 0;
    $(document).on("change","#selectType",function (argument) {
      $(".display-selected-user").text("");
      if($(this).val() == 3){
        $("#exampleModal").modal();
      }
    });
    $(document).on("change","#selectUser",function (argument) {
      $(".display-selected-user").text("您选择了"+$(this).find("option:selected").text());
      receiver = $("#selectUser").val();
      $("#selectUser").val("");
    });
    function send(){
      var noticeData = {};
      if($("#notice-title").val() == ""){
    	  alert("标题不能为空！");
    	  $("#notice-title").focus();
    	  return false;
      }
      else if(!($("#selectType").val())){
    	  alert("请选择公告发布对象！");
    	  return false;
      }
      else{
    	  noticeData["title"] = $("#notice-title").val();
      }
      noticeData["content"] = $("#notice-detail").val();
      noticeData["empno"] = receiver + "";
      noticeData["type"] = $("#selectType").val();
      var ND = JSON.stringify(noticeData);
      console.log(noticeData);
      console.log(ND);
      $.ajax({
         data: ND,
         url:'/sss/notice/insert.do',
         method:'post',
         contentType:'application/json',
         success:function (data) {
        	 receiver = "0";
        	 alert("公告以发出，待审核！");
        	 window.location.href =  data;
         },
      	error:function (data) {}
       });   
     
  }
    function savedraft(){
        var draft = {};
        if($("#notice-title").val() == ""){
      	  alert("标题不能为空！");
      	  $("#notice-title").focus();
      	  return false;
        }
        else{
        	draft["title"] = $("#notice-title").val();
        }
        /* draft["title"] = $("#notice-title").val(); */
        draft["content"] = $("#notice-detail").val();
        $.ajax({
           data: JSON.stringify(draft),
           url:'/sss/draft/add.do',
           method:'post',
           contentType:'application/json',
           success:function (data) {
          	 alert("草稿保存成功");
          	 window.location.href =  data;
           },
        	error:function (data) {}
         });   
       
    }
    $("#deploy").click(function(e){
      e.preventDefault();
      // console.log( $("#notice-title").value());
     
      send();
    });
    $("#savedraft").click(function(e){
        e.preventDefault();
       
        savedraft();
      });

  </script>
</body>



</html>
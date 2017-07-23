<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NMS登陆</title>
<link rel="stylesheet" href="/sss/css/Normalize.css">
<!-- Bootstrap -->
<link href="/sss/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/sss/css/login.css">
</head>
<!-- <body>
	<form action="/sss/user/login" method="post" id="loginform">
		<input type="text" id="name" name="name" /> <br>
		<input type="password" id="password" name="password" /> <br>
			<input type="submit" value="提交" id="login" />
	</form>
</body> -->
<body>
	<div class="main-content">
		<div class="content">
			<div class="container">
				<div class="sysname">
					<h1>NMS</h1>
					<h3>公文管理系统</h3>
				</div>
				<div class="login-area">
					<div class="container">
						<div class="col-md-6 col-md-offset-3">
							<div class="form-card">
								<form>
									<div class="form-group">
										<label for="username">username</label> <input type="text"
											class="form-control" id="name" name="name"
											placeholder="请输入用户名">
									</div>
									<div class="form-group">
										<label for="password">password</label> <input type="password"
											class="form-control" id="password" name="password"
											placeholder="请输入密码">
									</div>
									<button type="" class="btn btn-default" id="login">登录NMS</button>
								</form>
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

      $("#login").click(function (e) {

        e.preventDefault();

        var logindata = {};

        logindata["name"] = $("#name").val();
		logindata["password"] = $("#password").val();
        console.log(JSON.stringify(logindata));

        $.ajax({

          data:JSON.stringify(logindata),

          url:'/sss/user/login.do',

          contentType:'application/json',

          method:'post',

          success:function (data) {
			if(data == "1"){
				alert("用户名不存在！");
			}
			else if(data == "2"){
				alert("密码错误！");
			}
			else if(data == "3"){
				alert("您已经在线了 请注销当前账户！");
			}
			else{
				alert("登陆成功!");
	          	window.location.href= data;
			}
          },

          error:function (data) {

            alert("网络错误"+ data);

          }

        })

      });

        

      </script>
</body>
</html>
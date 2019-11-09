<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>用户注册</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/animate.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/theme.css">

<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container">
		<div class="login-box">
			<div class="title">
				<h3>
					<i class="fa fa-pencil-square-o"></i> 用户注册
				</h3>
			</div>
			<div class="box">
				<form action="${pageContext.request.contextPath }/register.do"
					method="post" onsubmit="return check();">
					<div class="control">
						<div class="label">姓名</div>
						<input type="text" class="form-control" name="aName" id="aName" />
					</div>
					<div class="control">
						<div class="label">密码</div>
						<input type="password" class="form-control" name="aPwd" id="aPwd" />
					</div>
					<div class="control">
						<div class="label">再次输入密码</div>
						<input type="password" class="form-control" name="reaPwd"
							id="reaPwd" />
					</div>
					<div class="control">
						<div class="label">邮箱</div>
						<input type="text" class="form-control" name="aEmail" id="aEmail" />
					</div>
					<div class="control">
						<div class="label">状态</div>
						<br> <select name="state" id="state"
							style="width: 350px; height: 50px">
							<option selected="selected" value="1" style="color: #000;">管理员</option>
							<option value="0" style="color: #000;">普通用户</option>
						</select>
					</div>
					<div class="login-button">
						<input type="submit" class="btn btn-orange" value="注册">
					</div>
				</form>
			</div>
			<div class="info-box">
				<span class="text-left"><a href="login.jsp">已有账号直接登录!</a></span>
				<div class="clear-both"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function check() {
			var password = document.getElementById("aPwd").value;
			var repsword = document.getElementById("reaPwd").value;
			if (password === '') {
				alert('密码不能为空');
				return false;
			}
			if (password != repsword) {
				alert("两次密码不同，请重新输入");
				return false;
			}
		}
	</script>
</body>

</html>

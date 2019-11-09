<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<head>
<title>Flat Admin - Bootstrap Themes</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="" />
<meta name="author" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900'
	rel='stylesheet' type='text/css' />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/animate.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-select.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/awesome-bootstrap-checkbox.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/theme.css" />

<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>

<body class="flat-blue sidebar-collapse">
	<div class="sidebar">
		<div class="menu-control toggle-sidebar">
			<a class="navbar-brand" href="#"> <i class="fa fa-bar-chart"></i>
				菜单栏
			</a> <i class="fa fa-bars navicon"></i>
		</div>
		<ul class="menu">
			<li class="submenu"><a
				href="${pageContext.request.contextPath }/selectCookBook.do">
					<div>
						<i class="menu-icon fa fa-th-large"></i> <span class="menu-title">文章查看审核</span>
					</div>
			</a></li>
			<li class="submenu"><a
				href="${pageContext.request.contextPath }/selectAuthor.do">
					<div>
						<i class="menu-icon fa fa-desktop"></i> <span class="menu-title">用户信息查看</span>
					</div>
			</a></li>
			<li class="submenu"><a
				href="${pageContext.request.contextPath }/selpictureall.do">
					<div>
						<i class="menu-icon fa fa-table"></i> <span class="menu-title">查看菜谱信息</span>
					</div>
			</a></li>
			<li class="submenu"><a href="form.jsp" class="active">
					<div>
						<i class="menu-icon fa fa-file-text-o"></i> <span
							class="menu-title">更新菜谱信息</span>
					</div>
			</a></li>
		</ul>
	</div>
	<div class="content-container wrap">
		<nav class="navbar navbar-default">
		<div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"><i class="fa fa-bar-chart"></i>
						菜单栏</a>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="fa fa fa-comments"></i> 0</a>
						<ul class="dropdown-menu">
							<li class="dropdown-title-bar">待审核 ( 0 )</li>
							<li class="message">No new notification</li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">个人信息
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu user-info">
							<li class="dropdown-title-bar"><img src="img/profile.jpg"
								class="profile-img" /></li>
							<li>
								<div class="navbar-login">
									<h4 class="user-name">${author.aPetName }<c:if
											test="${author.aPetName ==null}">${author.aName }</c:if>
									</h4>
									<p>${author.aEmail }</p>
									<div class="btn-group margin-bottom-2x" role="group">
										<button type="button" class="btn btn-default" id="Profile">
											<i class="fa fa-user"></i> 个人信息
										</button>
										<button type="button" class="btn btn-default" id="Logout">
											<i class="fa fa-sign-out"></i> 退出登录
										</button>
									</div>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<span class="page-title red"><h3>更新菜谱信息</h3></span>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="content-block">
						<form class="form-vertical" enctype="multipart/form-data"
							action="${pageContext.request.contextPath }/addPicture.do" method="post">
							<div class="block-title">添加信息</div>

							<div class="block-content">
								<div class="form-group">
									<label for="exampleInputEmail1">菜名</label> <input type="text"
										class="form-control" name="pDish" id="pDish" />
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">食材</label>
									<textarea class="form-control" rows="3" name="pCaption"
										id="pCaption"></textarea>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">菜系</label> <select id="pType"
										class="form-control" name="pType">
										<option>鲁菜</option>
										<option>川菜</option>
										<option>粤菜</option>
										<option>苏菜</option>
										<option>闽菜</option>
										<option>浙菜</option>
										<option>徽菜</option>
										<option>湘菜</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputFile">菜品图片</label> <input type="file"
										id="pimg" name="pimg" />
									<p class="help-block">选择本地图片.</p>
								</div>
								<div class="block-footer">
									<div class="form-group">
										<input type="submit" class="btn btn-primary" value="添加" />

									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>

</html>


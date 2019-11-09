<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
<title>后台管理</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="Free Flat Admin Bootstrap Themes" />
<meta name="author" content="Charuwit Nodthaisong" />
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
<link rel="stylesheet" type="text/css" href="css/select2.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/theme.css" />

<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/Chart.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/index.js"></script>
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
				href="${pageContext.request.contextPath }/selectCookBook.do"
				class="active">
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
			<li class="submenu"><a href="form.jsp">
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
							<li class="dropdown-title-bar"><img src="${author.aHead }"
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
										<button type="button" class="btn btn-default" id="Logout"
											onclick="logout();">
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
					<span class="page-title red"><h2>
							博客查看审核
							</h3></span>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="content-block">
						<div class="block-title">审核状态</div>
						<div class="block-content">
							<table id="example" class="table table-striped" cellspacing="0"
								width="100%">
								<thead>
									<tr>
										<th>标题</th>
										<th>文章</th>
										<th>发表时间</th>
										<th>作者编号</th>
										<th>审核状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${ckList }" var="ckli">
										<tr>
											<td>${ckli.ckTitle}</td>
											<td>${ckli.ckContent}</td>
											<td>${ckli.ckTime}</td>
											<td>${ckli.aId}</td>
											<td><c:if test="${ckli.ckState==0}">
													<span style="color: red">待审核</span>
												</c:if> <c:if test="${ckli.ckState==1}">审核成功</c:if></td>
											<td><a href="" onclick="state('${ckli.ckId}');">审核状态</a></td>
										</tr>

									</c:forEach>

								</tbody>
							</table>
							<%-- <nav class="table-pagination">
							<ul class="pagination">
								<li class="disabled"><a href="#" aria-label="Previous"><span
										aria-hidden="true">芦</span></a></li>
								<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a>
								</li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#" aria-label="Next"><span
										aria-hidden="true">禄</span></a></li>
							</ul>
							</nav>--%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${ok==0 }">
		<script type="text/javascript">
			alret("修改失败");
		</script>
	</c:if>
	<c:if test="${ok==1 }">
		<script type="text/javascript">
			alret("修改成功");
		</script>
	</c:if>

	<script type="text/javascript">
		function logout() {
			var flag = confirm("确认退出?");
			if (flag == true) {
				window.location.href = "login.jsp";
			}

		}
		function state(ckid) {
			var flag = confirm("确认通过审核吗?");
			if (flag == true) {
				window.location.href = "${pageContext.request.contextPath }/update.do?ckid="
						+ ckid;
			}

		}
	</script>
	<%-- <div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="banner-block white">
					<div class="block-content">
						<div class="block-title">Orders</div>
						<canvas id="dashboard-order-chart"
							style="padding:10px 30px 10px 10px;"></canvas>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="banner-block white">
					<div class="block-content">
						<div class="block-title">Stats</div>
						<div class="row">
							<div class="col-md-9">
								<canvas id="dashboard-stat-chart"
									style="padding:10px 30px 10px 10px;"></canvas>
							</div>

							<div class="col-md-3">
								<div id="dashboard-stat-chart-legend" class="pie-legend"></div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="fa fa-comments-o"></i> Last Message
						</h3>
					</div>
					<div class="panel-body no-padding">
						<ul class="message-list">
							<a href="#">
								<li><img src="images/profile.jpg"
									class="profile-img pull-left">
										<div class="message-block">
											<div>
												<span class="username">Tui2Tone</span> <span
													class="message-datetime">12 min ago</span>
											</div>
											<div class="message">Lorem ipsum dolor sit amet,
												consectetur adipiscing elit. Curabitur bibendum ornare
												dolor, quis ullamcorper ligula sodales.</div>
										</div></li>
							</a>
							<a href="#">
								<li><img src="images/profile.jpg"
									class="profile-img pull-left">
										<div class="message-block">
											<div>
												<span class="username">Tui2Tone</span> <span
													class="message-datetime">15 min ago</span>
											</div>
											<div class="message">Lorem ipsum dolor sit amet,
												consectetur adipiscing elit. Curabitur bibendum ornare
												dolor, quis ullamcorper ligula sodales.</div>
										</div></li>
							</a>
							<a href="#">
								<li><img src="images/profile.jpg"
									class="profile-img pull-left">
										<div class="message-block">
											<div>
												<span class="username">Tui2Tone</span> <span
													class="message-datetime">2 hour ago</span>
											</div>
											<div class="message">Lorem ipsum dolor sit amet,
												consectetur adipiscing elit. Curabitur bibendum ornare
												dolor, quis ullamcorper ligula sodales.</div>
										</div></li>
							</a>
							<a href="#">
								<li><img src="images/profile.jpg"
									class="profile-img pull-left">
										<div class="message-block">
											<div>
												<span class="username">Tui2Tone</span> <span
													class="message-datetime">1 day ago</span>
											</div>
											<div class="message">Lorem ipsum dolor sit amet,
												consectetur adipiscing elit. Curabitur bibendum ornare
												dolor, quis ullamcorper ligula sodales.</div>
										</div></li>
							</a>
							<a href="#" id="message-load-more">
								<li class="text-center load-more"><i class="fa fa-refresh"></i>
									load more..</li>
							</a>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="fa fa-users"></i> New Users
						</h3>
					</div>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Username</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
							</tr>
							<tr>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
							<tr>
								<td>Larry</td>
								<td>the Bird</td>
								<td>@twitter</td>
							</tr>
							<tr>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
							</tr>
							<tr>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
							<tr>
								<td>Larry</td>
								<td>the Bird</td>
								<td>@twitter</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>--%>


</body>

</html>

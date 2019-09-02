<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>爱家-个人信息</title>
<link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="css/reset.css" rel="stylesheet">
<link
	href="plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css"
	rel="stylesheet">
<link href="css/ihome/main.css" rel="stylesheet">
<link href="css/ihome/profile.css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/setUsername.js"></script>
</head>
<body>
	<div class="container">
		<div class="top-bar">
			<div class="nav-bar">
				<h3 class="page-title">个人信息</h3>
				<a class="nav-btn fl" href="my.jsp"><span><i
						class="fa fa-angle-left fa-2x"></i></span></a>
			</div>
		</div>
		<div class="menus-con">
			<ul class="menus-list">
				<li>
					<div class="menu-title">
						<h3>头像</h3>
					</div>
					<div class="menu-content">
						<img id="user-avatar" src="">
						<div class="menu-text">
							<form action="UploadUserImgServlet" id="form-avatar"
								method="post" enctype="multipart/form-data">
								<label for="exampleInputFile">选择头像：</label> <br /><br /><input
									type="file" name="files"><br />
								<div>
									<input type="submit" class="btn btn-info" value="确认修改" />
								</div>
							</form>

						</div>
					</div>
				</li>
				<li>
					<div class="menu-title">
						<h3>用户名</h3>
						<font id="usernameif"></font>
					</div>
					<div class="menu-content">
						<!--   <form action="SetUserFileServlet"  id="form-name" method="post"> -->
						<input type="text" name="name" id="user-name">
						<button type="button" onclick="updateUserButton()"
							class="btn btn-success">保存</button>
						<!--  </form> -->
					</div>
				</li>
			</ul>
		</div>
		<div class="footer">
			<p>
				<span><i class="fa fa-copyright"></i></span>爱家租房&nbsp;&nbsp;享受家的温馨
			</p>
		</div>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>爱家-实名认证</title>
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
	src="${pageContext.request.contextPath}/js/auth.js"></script>


</head>
<body>
	<div class="container">
		<div class="top-bar">
			<div class="nav-bar">
				<h3 class="page-title">实名认证</h3>
				<a class="nav-btn fl" href="my.jsp"><span><i
						class="fa fa-angle-left fa-2x"></i></span></a>
			</div>
		</div>
		<div class="menus-con">
			<ul class="menus-list">
				<li>
					<div class="menu-title">
						<h3>认证信息</h3>&nbsp;&nbsp;&nbsp;<font id="authif">(已认证!)</font>
					</div>
					<div class="menu-content">
						<form action="UserAuthServlet" method="post">
							<div class="form-group">
								<label for="realName">真实姓名</label>
								<div id="namexiaoshi">
									<input type="text" class="form-control" name="realName"
										id="realName">
								</div>
							</div>
							<div class="form-group">
								<label for="idCard">身份证号码</label>
								<div id="idxiaoshi">
									<input type="text" class="form-control" name="idCard"
										id="idCard">
								</div>
							</div>
							<div id="xiaoshi">
								<input type="submit" class="btn btn-success" value="保存">
							</div>
							
						</form>
					</div>
				</li>
			</ul>
		</div>
		<div class="popup_con">
			<div class="popup">
				<p>保存成功！</p>
			</div>

			<div class="mask"></div>
		</div>
		<div class="footer">
			<p>
				<span><i class="fa fa-copyright"></i></span>爱家租房&nbsp;&nbsp;享受家的温馨
			</p>
		</div>
	</div>

</body>
</html>
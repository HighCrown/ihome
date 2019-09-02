<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>爱家-房源</title>
<link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="css/reset.css" rel="stylesheet">
<link
	href="plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css"
	rel="stylesheet">
<link href="css/ihome/main.css" rel="stylesheet">
<link href="css/ihome/search.css" rel="stylesheet">
</head>
<body>
	<div>
		<div class="top-bar">
			<div class="nav-bar">
				<h3 class="page-title">房 源</h3>


				<a class="nav-btn fl" href="index.html"><span><i
						class="fa fa-angle-left fa-2x"></i></span></a>

			</div>
			<div class="nav-bar" style="text-align: right;">
			<% Object user = session.getAttribute("existUser"); 
				if(user == null){
			%>
				<a style="text-align: right;" class="btn top-btn btn-sm btn-theme"
					href="regist.html">注册</a> <a class="btn top-btn btn-theme btn-sm"
					href="login.jsp">登录</a>
			<% }else{ %>
			     <div class="user-info fr"><span><i class="fa fa-user fa-lg"></i></span> <a class="user-name" href="my.jsp">${existUser.name}</a></div>
			<% }%>
			</div>
			<ul class="filter-title-bar">
				<li class="filter-title"><span id="dateTitle">入住日期</span> <span><i
						class="fa fa-angle-down"></i></span> <span class="split-line fr">|</span>
				</li>
				<li class="filter-title"><span id="areaTitle">位置区域</span> <span><i
						class="fa fa-angle-down"></i></span> <span class="split-line fr">|</span>
				</li>
				<li class="filter-title"><span id="conditionThree">最新上线</span>
					<span><i class="fa fa-angle-down"></i></span></li>
			</ul>
			<div class="filter-item-bar">
				<div class="filter-item filter-date">
					<div class="input-daterange input-group">
						<input type="text" class="input-sm form-control" id="start-date" />
						<span class="input-group-addon">至</span> <input type="text"
							class="input-sm form-control" id="end-date" />
					</div>
				</div>
				<ul class="filter-item filter-area">
				</ul>
				<ul class="filter-item filter-sort" id="switch1">
					<li id="new" class="active" sort-key="new">最新上线</li>
					<li id="booking" sort-key="booking">入住最多</li>
					<li id="price-inc" sort-key="price-inc">价格 低-高</li>
					<li id="price-des" sort-key="price-des">价格 高-低</li>
				</ul>
			</div>
		</div>
		<div class="display-mask"></div>
		<ul class="house-list">
		</ul>

		<br> <br> <br>
		<div class="container">
			<div class="row"></div>
		</div>

		<nav id="pageColumn" aria-label="Page navigation"
			style="text-align: center">
			<ul id="page" class="pagination">
				<!--  
		    <li>
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li><a href="#">1</a></li>
		    
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		    -->
			</ul>
		</nav>



		<div class="footer">
			<p>
				<span><i class="fa fa-copyright"></i></span>爱家租房&nbsp;&nbsp;享受家的温馨
			</p>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
	<script
		src="plugins/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
	<script src="js/template.js"></script>
	<script src="js/ihome/search.js"></script>
</body>
</html>
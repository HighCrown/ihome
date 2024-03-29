<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>爱家-我的爱家</title>
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/reset.css" rel="stylesheet">
    <link href="plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <link href="css/ihome/main.css" rel="stylesheet">
    <link href="css/ihome/my.css" rel="stylesheet">
</head>
<body onload="opener.location.reload()">
    <div class="container">
        <div class="top-bar">
            <div class="nav-bar">
                <h3 class="page-title">我的爱家</h3>
                <a class="nav-btn fl" href="index.html"><span><i class="fa fa-angle-left fa-2x"></i></span></a>
            </div>
        </div>
        <div class="menus-con">
            <ul class="menus-list">
                <li>
                    <div class="menu-title">
                        <h3>个人信息</h3>
                        <a class="fr" href="profile.jsp">修改</a>
                    </div>
                    <div class="menu-content">
                    
                        <img id="user-avatar" src="${existUser.avatarUrl }">
                        <div class="menu-text">
                            <h3>用户名：<span id="user-name">${existUser.name}</span></h3>
                            <h5>手机号：<span id="user-mobile">${existUser.mobile}</span></h5>
                        </div> 
                    </div>
                </li>
                
                <li>
                    <div class="menu-title menu-radius">
                        <a href="order.jsp"><h3>我的订单</h3></a>
                    </div>
                </li>
                <li>
                    <div class="menu-title menu-radius">
                        <a href="auth.jsp"><h3>实名认证</h3></a>
                    </div>
                </li>
                <li>
                    <div class="menu-title menu-radius">
                        <a href="myhouse.html"><h3>我的房源</h3></a>
                    </div>
                </li>
                <li>
                    <div class="menu-title menu-radius">
                        <a href="lorders.html"><h3>客户订单</h3></a>
                    </div>
                </li>
                <li>
                    <div class="menu-title menu-radius">
                        <a href="index.html" onclick="logout();" >退出</a>
                    </div>
                </li>
            </ul>
        </div>
        <div class="footer">
            <p><span><i class="fa fa-copyright"></i></span>爱家租房&nbsp;&nbsp;享受家的温馨</p>
        </div> 
    </div>
    
   <!--  <script src="js/jquery.min.js"></script>
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
    <script src="plugins/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
    <script src="js/ihome/my.js"></script> -->
    <script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ihome/my.js"></script>
</body>
</html>
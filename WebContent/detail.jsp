<%@page import="com.ihome.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>爱家-房间信息</title>
<link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="css/reset.css" rel="stylesheet">
<link href="plugins/swiper/css/swiper.min.css" rel="stylesheet">
<link
	href="plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css"
	rel="stylesheet">
<link href="css/ihome/main.css" rel="stylesheet">
<link href="css/ihome/detail.css" rel="stylesheet">
</head>

<body>

	<div class="top-bar">
		<div class="nav-bar">
			<h3 class="page-title">房间信息</h3>
			<a class="nav-btn fl" href="search.jsp" ><span><i
					class="fa fa-angle-left fa-2x"></i></span></a>
		</div>
	</div><br><br><br>
	<div class="container">
		<div class="swiper-container swiper-container-horizontal">
			<div class="swiper-slide">
				<img id="house-image" src="">
			</div>
			<div class="house-price">
				￥<span id="house-price"></span>/晚
			</div>
		</div>
		<div class="detail-con">
			<div class="detail-header layout-style">

				<!-- 房间标题 -->
				<h2 class="house-title"></h2>
				<div class="landlord-pic">
					<img id="user-avatar" src="">
				</div>
				<h2 class="landlord-name">
					房东： <span id="user-name"></span>
				</h2>
			</div>
			<div class="house-info layout-style">
				<h3>房屋地址</h3>
				<ul class="house-info-list text-center">

					<!-- 房间地址 -->
					<li id="house-address"></li>
				</ul>
			</div>
			<ul class="house-type layout-style">
				<li><span class="icon-house"></span>
					<div class="icon-text">

						<h3>
							出租<font id="house-count"></font>间
						</h3>
						<p>
							房屋面积:<font id="house-acreage"></font>平米
						</p>
						<p>
							房屋户型:<font id="house-unit"></font>
						</p>
					</div></li>
				<li><span class="icon-user"></span>
					<div class="icon-text">

						<h3>
							宜住<font id="house-capacity"></font>人
						</h3>
					</div></li>
				<li><span class="icon-bed"></span>
					<div class="icon-text">

						<h3>卧床配置</h3>
						<p id="house-beds"></p>
					</div></li>
			</ul>
			<div class="house-info layout-style">
				<h3>房间详情</h3>
				<ul class="house-info-list">

					<li>收取押金<span id="house-deposit"></span></li>
					<li>最少入住天数<span id="house-minDays"></span></li>
					<li>最多入住天数<span id="house-maxDays"></span></li>
				</ul>
			</div>
			<div class="house-facility layout-style">
				<h3>配套设施</h3>
				<ul class="house-facility-list clearfix">
					<li><font id="1" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						无线网络</li>
					<li><font id="2" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						热水淋浴</li>
					<li><font id="3" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						空调</li>
					<li><font id="4" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						暖气</li>
					<li><font id="5" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						允许吸烟</li>
					<li><font id="6" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						饮水设备</li>
					<li><font id="7" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						牙具</li>
					<li><font id="8" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						香皂</li>
					<li><font id="9" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						拖鞋</li>
					<li><font id="10" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						手纸</li>
					<li><font id="11" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						毛巾</li>
					<li><font id="12" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						沐浴露、洗发露</li>
					<li><font id="13" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						冰箱</li>
					<li><font id="14" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						洗衣机</li>
					<li><font id="15" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						电梯</li>
					<li><font id="16" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						允许做饭</li>
					<li><font id="17" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						允许带宠物</li>
					<li><font id="18" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						允许聚会</li>
					<li><font id="19" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						门禁系统</li>
					<li><font id="20" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						停车位</li>
					<li><font id="21" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						有线网络</li>
					<li><font id="22" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						电视</li>
					<li><font id="23" color=""><span
							class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						浴缸</li>
				</ul>
			</div>
		</div>
		<!--预定-->
		<div>
			<div id="abc" class="btn search-btn btn-theme" onclick="goToOrder(this);" seller-id="" house-id="" house-name="" house-image="" house-price="" house-deposit=""  minDays="" maxDays=""    
			>即刻预定</div>
			<div id="def" class="btn search-btn btn-theme" onclick="goToLogin();">即刻预定</div>
		</div>
		<div class="footer">
			<p>
				<span><i class="fa fa-copyright"></i></span>爱家租房&nbsp;&nbsp;享受家的温馨
			</p>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script type="text/javascript">
		/* 鼠标点击特效 */
		var a_idx = 0;
		jQuery(document).ready(
				function($) {
					$("body").click(
							function(e) {
								var a = new Array("富强", "民主", "文明", "和谐", "自由",
										"平等", "公正", "法治", "爱国", "敬业", "诚信",
										"友善");
								var $i = $("<span/>").text(a[a_idx]);
								a_idx = (a_idx + 1) % a.length;
								var x = e.pageX, y = e.pageY;
								$i.css({
									"z-index" : 100000000,
									"top" : y - 20,
									"left" : x,
									"position" : "absolute",
									"font-weight" : "bold",
									"color" : "#ff6651"
								});
								$("body").append($i);
								$i.animate({
									"top" : y - 180,
									"opacity" : 0
								}, 1500, function() {
									$i.remove();
								});
							});
				});
	</script>
	<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="plugins/swiper/js/swiper.jquery.min.js"></script>
	<script
		src="plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
	<script
		src="plugins/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
	<script src="js/template.js"></script>
	<script src="js/ihome/detail.js"></script>
	<script type="text/javascript"
		src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>

</body>
</html>
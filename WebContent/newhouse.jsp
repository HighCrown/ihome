<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>爱家-发布新房源</title>
<link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="css/reset.css" rel="stylesheet">
<link
	href="plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css"
	rel="stylesheet">
<link href="css/ihome/main.css" rel="stylesheet">
<link href="css/ihome/newhouse.css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/json.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/newHouse.js"></script>
</head>
<body>
	<div class="container">
		<div class="top-bar">
			<div class="nav-bar">
				<h3 class="page-title">发布新房源</h3>
				<a class="nav-btn fl" href="my.jsp"><span><i
						class="fa fa-angle-left fa-2x"></i></span></a>
			</div>
		</div>
		<div class="houses-con">
			<ul class="houses-list">

				<form id="addHouseForm"  method="post">
					<li>
						<div class="house-title">
							<h3>基本信息</h3>
						</div>
						<div class="house-content">
							<div class="form-group">
								<label for="house-title">房屋标题</label> <input type="text"
									class="form-control" name="title" id="house-title" required>
							</div>
							<div class="form-group">
								<label for="house-price">每晚价格</label> <input type="number"
									class="form-control" name="price" id="house-price" required>
							</div>
							<div class="form-group">
								<label for="area-id">所在城区</label> <select class="form-control"
									id="area-id" name="areaName">
								</select>
							</div>
							<div class="form-group">
								<label for="house-address">详细地址</label>
								<textarea class="form-control" name="address" id="house-address"
									required></textarea>
							</div>
						</div>
					</li>
					<li>
						<div class="house-title">
							<h3>详细信息</h3>
						</div>
						<div class="house-content">
							<div class="form-group">
								<label for="house-room-count">出租房间数目</label> <input
									type="number" class="form-control" name="roomCount"
									id="house-room-count" required>
							</div>
							<div class="form-group">
								<label for="house-acreage">房屋面积</label> <input type="number"
									class="form-control" name="acreage" id="house-acreage" required>
							</div>
							<div class="form-group">
								<label for="house-unit">户型描述</label> <input type="text"
									class="form-control" name="unit" id="house-unit"
									placeholder="如：三室两厅两卫" required>
							</div>
							<div class="form-group">
								<label for="house-capacity">宜住人数</label> <input type="number"
									class="form-control" name="capacity" id="house-capacity"
									required>
							</div>
							<div class="form-group">
								<label for="house-beds">卧床配置</label> <input type="text"
									class="form-control" name="beds" id="house-beds"
									placeholder="如：双人床:2x1.8x1张 1.5x2x2张" required>
							</div>
							<div class="form-group">
								<label for="house-deposit">押金数额</label> <input type="number"
									class="form-control" name="deposit" id="house-deposit" required>
							</div>
							<div class="form-group">
								<label for="house-min-days">最少入住天数</label> <input type="number"
									class="form-control" name="minDays" id="house-min-days"
									required>
							</div>
							<div class="form-group">
								<label for="house-max-days">最多入住天数</label> <input type="number"
									class="form-control" name="maxDays" id="house-max-days"
									placeholder="" required>
							</div>
						</div>
					</li>
					<li>
						<div class="house-title">
							<h3>配套设施</h3>
						</div>
						<div class="house-content">
							<ul class="house-facility-list clearfix">
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="1">无线网络
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="2">热水淋浴
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="3">空调
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="4">暖气
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="5">允许吸烟
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="6">饮水设备
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="7">牙具
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="8">香皂
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="9">拖鞋
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="10">手纸
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="11">毛巾
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="12">沐浴露、洗发露
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="13">冰箱
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="14">洗衣机
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="15">电梯
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="16">允许做饭
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="17">允许带宠物
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="18">允许聚会
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="19">门禁系统
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="20">停车位
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="21">有线网络
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="22">电视
										</label>
									</div>
								</li>
								<li>
									<div class="checkbox">
										<label> <input type="checkbox" name="facility"
											value="23">浴缸
										</label>
									</div>
								</li>
							</ul>
						</div>
					</li> <input id="addHouseBtn" type="button" class="btn btn-success btn-commit"
						value="发布房源信息">
					<div class="error-msg text-center">
						<i class="fa fa-exclamation-circle"></i>请将全部信息填写完整后再提交
					</div>
				</form>
				<div id="houseImg"></div>
			</ul>
		</div>
		<div class="popup_con">
			<div class="popup">
				<p>
					<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
				</p>
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
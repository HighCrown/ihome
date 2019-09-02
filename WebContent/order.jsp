<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>爱家-我的订单</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/order.css" />
<script type="text/javascript" src="js/ihome/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/ihome/bootstrap.min.js"></script>
<script type="text/javascript" src="js/ihome/order.js	"></script>
<script type="text/javascript" src="js/json.js	"></script>

</head>

<body style="background: #EEEEEE;">

	<nav class="navbar navbar-default navbar-fixed-top"
		style="background: #FFFFFF; padding-top: 10px;">
		<div class="container">
			<div class="row">
				<!--上一步-->
				<div class="col-xs-5">
					<a href="my.jsp"><span
						style="font-size: 25px; color: #000000;"
						class="glyphicon glyphicon-chevron-left"></span></a>
				</div>
				<!--导航标题-->
				<font style="text-align: center;" size="5">我的订单</font>

			</div>
		</div>
	</nav>
	
	<!--每条数据-->
	<!-- 隐藏域，获取用户ID -->
	<input id="findUserId" type="hidden" value="${existUser.id}"/>

	<div class="container" style="padding: 10px;" id="order">
		
	</div>
	<!-- 评论 -->
	<div class="modal fade" id="commentModal" tabindex="-1" role="dialog" aria-labelledby="comment-label">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">发表评价</h4>
                        </div>
                        <div class="modal-body">
                            <textarea class="form-control" rows="3" id="comment" placeholder="请在此处填写评价"></textarea>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary modal-comment">确定</button>
                        </div>
                    </div>
                </div>
            </div>
	<!--分页-->
	<div>
		<nav style="text-align: center;">
			<ul class="pagination pagination-lg" id="pageIndex">
				
			</ul>
		</nav>
	</div>
	<!--底层信息-->
	<div id="feet">
		<font><span class="glyphicon glyphicon-copyright-mark"></span>爱家租房&nbsp;享受家的温馨</font>
	</div>

</body>

</html>
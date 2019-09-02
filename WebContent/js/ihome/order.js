
var currPage=1;
var pageSize=5;
var totalPages=0;
var ok="";		//获取userID的中间量
var userId="";	//获取用户ID
//合计金额
var amount = "";
//订单ID
var id = "";


$(function(){
	ok = $("#findUserId").val();	//获取userID的中间量
	userId=ok;
	find();
});

function find(){

	$.post("findAll",{"userId":userId,"currPage":currPage,"pageSize":pageSize},function(data){
		var count=data.count;
		if(count%pageSize==0){
			totalPages=count/pageSize;
		}else{
			totalPages=(count-(count%pageSize))/pageSize+1;
		} 
		
		//清除每次不需要的数据 
		$("#order").html("");
		$("#pageIndex").html("");
		 
		if(totalPages==0){
			return;
		}
	
		
		for(var i=0;i<data.list.length;i++){
			//订单状态
			status = data.list[i].status;
			//待接单
			if(status=="WAIT_ACCEPT"){
				var order='<div class="container" style="padding: 10px;" id="order">'+
				'<div id="radius" class="row"><div class="col-xs-11"><h5>订单编号：'+data.list[i].id+'</h5>'+
					'</div>'+
					'<div class="col-xs-1">'+
						'<a id="a" href="#"><button id="btn" value="1"  style="float: right;" type="button"'+
								'class="btn btn-success hidden"></button></a>'+
					'</div>'+
					'<hr />'+
					'<div class="row">'+
						'<div class="col-xs-3">'+
							'<img id="img" src="'+data.list[i].indexImageUrl+'" />'+
						'</div>'+
						'<div class="col-xs-6 col-xs-offset-1" id="selectOrder">'+
							'<ul>'+
								'<li>'+
									'<h4>'+data.list[i].title+'</h4>'+
								'</li>'+
								'<li>'+
									'<font size="2">创建时间：'+getLocalTime(data.list[i].createTime)+' <font>'+
								'</li>'+
								'<li>入住日期：'+getLocalTime(data.list[i].beginDate)+'</li>'+
								'<li>离开日期：'+getLocalTime(data.list[i].endDate)+'</li>'+
								'<li>合计金额：￥'+(data.list[i].days*data.list[i].housePrice)+'(共'+data.list[i].days+'晚)</li>'+
								'<li>订单状态：待接单</li>'+
							'</ul>'+
						'</div>'+
					'</div>'+
				'</div>'+
			'</div>';
				$("#order").append(order);
			}
			//待支付
			if(status=="WAIT_PAYMENT"){
				var order='<div class="container" style="padding: 10px;" id="order">'+
				'<div id="radius" class="row"><div class="col-xs-11"><h5>订单编号：'+data.list[i].id+'</h5>'+
					'</div>'+
					'<div class="col-xs-1">'+
						'<a id="a" href="#"><button id="btn" value="1" onclick="paid('+data.list[i].amount+','+data.list[i].id+')" style="float: right;" type="button"'+
								'class="btn btn-success">支付</button></a>'+
					'</div>'+
					'<hr />'+
					'<div class="row">'+
						'<div class="col-xs-3">'+
							'<img id="img" src="'+data.list[i].indexImageUrl+'" />'+
						'</div>'+
						'<div class="col-xs-6 col-xs-offset-1" id="selectOrder">'+
							'<ul>'+
								'<li>'+
									'<h4>'+data.list[i].title+'</h4>'+
								'</li>'+
								'<li>'+
									'<font size="2">创建时间：'+getLocalTime(data.list[i].createTime)+' <font>'+
								'</li>'+
								'<li>入住日期：'+getLocalTime(data.list[i].beginDate)+'</li>'+
								'<li>离开日期：'+getLocalTime(data.list[i].endDate)+'</li>'+
								'<li>合计金额：￥'+(data.list[i].days*data.list[i].housePrice)+'(共'+data.list[i].days+'晚)</li>'+
								'<li>订单状态：待支付</li>'+
							'</ul>'+
						'</div>'+
					'</div>'+
				'</div>'+
			'</div>';
				$("#order").append(order);
			}
			
			//已付款
			if(status=="COMPLETE"){
				var order='<div class="container" style="padding: 10px;" id="order">'+
				'<div id="radius" class="row"><div class="col-xs-11"><h5>订单编号：'+data.list[i].id+'</h5>'+
					'</div>'+
					'<div class="col-xs-1">'+
						'<a id="a" href="#"><button id="btn" value="1"  style="float: right;" type="button"'+
								'class="btn btn-success hidden">评价</button></a>'+
					'</div>'+
					'<hr />'+
					'<div class="row">'+
						'<div class="col-xs-3">'+
							'<img id="img" src="'+data.list[i].indexImageUrl+'" />'+
						'</div>'+
						'<div class="col-xs-6 col-xs-offset-1" id="selectOrder">'+
							'<ul>'+
								'<li>'+
									'<h4>'+data.list[i].title+'</h4>'+
								'</li>'+
								'<li>'+
									'<font size="2">创建时间：'+getLocalTime(data.list[i].createTime)+' <font>'+
								'</li>'+
								'<li>入住日期：'+getLocalTime(data.list[i].beginDate)+'</li>'+
								'<li>离开日期：'+getLocalTime(data.list[i].endDate)+'</li>'+
								'<li>合计金额：￥'+(data.list[i].days*data.list[i].housePrice)+'(共'+data.list[i].days+'晚)</li>'+
								'<li>订单状态：已付款</li>'+
							'</ul>'+
						'</div>'+
					'</div>'+
				'</div>'+
			'</div>';
				$("#order").append(order);
			}

			
			//已拒单
			if(status=="REJECTED"){
				var order='<div class="container" style="padding: 10px;" id="order">'+
				'<div id="radius" class="row"><div class="col-xs-11"><h5>订单编号：'+data.list[i].id+'</h5>'+
					'</div>'+
					'<div class="col-xs-1">'+
						'<a id="a" href="#"><button id="btn" value="1"  style="float: right;" type="button"'+
								'class="btn btn-success hidden">拒单原因</button></a>'+
					'</div>'+
					'<hr />'+
					'<div class="row">'+
						'<div class="col-xs-3">'+
							'<img id="img" src="'+data.list[i].indexImageUrl+'" />'+
						'</div>'+
						'<div class="col-xs-6 col-xs-offset-1" id="selectOrder">'+
							'<ul>'+
								'<li>'+
									'<h4>'+data.list[i].title+'</h4>'+
								'</li>'+
								'<li>'+
									'<font size="2">创建时间：'+getLocalTime(data.list[i].createTime)+' <font>'+
								'</li>'+
								'<li>入住日期：'+getLocalTime(data.list[i].beginDate)+'</li>'+
								'<li>离开日期：'+getLocalTime(data.list[i].endDate)+'</li>'+
								'<li>合计金额：￥'+(data.list[i].days*data.list[i].housePrice)+'(共'+data.list[i].days+'晚)</li>'+
								'<li>订单状态：已拒单</li>'+
								'<li>拒单理由：'+data.list[i].comment+'</li>'
							'</ul>'+
						'</div>'+
					'</div>'+
				'</div>'+
			'</div>';
				$("#order").append(order);
			}
			
		}
		
		
		
		var left="";
		if(currPage==1){
			left='<li class="disabled" id="left"><a  aria-label="Previous"> <span aria-hilien="true">&laquo;</span></a></li>';
		}else{
			left='<li onclick="left()"><a  aria-label="Previous"> <span aria-hilien="true">&laquo;</span></a></li>';
		}	
		$("#pageIndex").append(left);
		for(var i=1;i<=totalPages;i++){
			var index='<li><a onclick="change('+i+')">'+i+'</a></li>';
			$("#pageIndex").append(index);
		}
		var right="";
		if(currPage==totalPages){
			right='<li class="disabled" id="right"><a aria-label="Next"> <span aria-hilien="true">&raquo;</span></a></li>';
		}else{
			right='<li onclick="right()"><a aria-label="Next"> <span aria-hilien="true">&raquo;</span></a></li>';
		}
			$("#pageIndex").append(right);
	},"json");
};

//中间的页码
function change(i){
	currPage=i;
	find();
}

//左右两边的图标
function left(){
	currPage--;
	find();
}
function right(){
	currPage++;
	find();
}


//支付
function paid(orderMoney,orderId){
	if(confirm("确认支付？")){
//        location.href="Edit_OrderServlet?method=delete&id="+id+"&in="+name;
		$.post("updateStatus",{"orderId":orderId},function(data){
			
		},"json");
		location.href="buy?amount="+orderMoney+"&id="+orderId+"";
    }else {
//        alert("支付失败");
    }
}


//时间戳转换成时间
function getLocalTime(nS) {  
	 return new Date(parseInt(nS)).toLocaleString().replace(/:\d{1,2}$/,' ');  
	}
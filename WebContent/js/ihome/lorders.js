$(function() {
	$.post("findAllOrder", function(data) {
		if(data.length == 0){
			$("#orderList").html("<font size ='4' color='blue' >对不起,还没有客户添加订单</font>")
			return;
		}
		for (var i = 0; i < data.length; i++) {
			var status = data[i].status;
			var days = (data[i].endDate-data[i].beginDate)/1000/24/60/60;
			switch (status) {
			case "WAIT_ACCEPT":
				var waitAccept = '<br/><div  class="order-title"><h3>订单编号：'+data[i].id+'</h3><div class="fr order-operate">'+
                   ' <button type="button" class="btn btn-success order-accept" data-toggle="modal" onclick=confirmOrder('+data[i].id+')>接单</button>'+
                  '  <button type="button" class="btn btn-danger order-reject" data-toggle="modal" onclick=rejectedOrder('+data[i].id+')>拒单</button>'+
                '</div></div><div class="order-content">'+
                '<img src="'+data[i].indexImageUrl+'"><div class="order-text"><h3>'+data[i].title+'</h3><ul>'+
                        '<li>创建时间：'+getLocalTime(data[i].createTime)+'</li><li>入住日期：'+getLocalTime(data[i].beginDate)+'</li><li>离开日期：'+getLocalTime(data[i].endDate)+'</li>'+
                       ' <li>合计金额：￥'+data[i].amount+'(共'+days+'晚)</li> <li>订单状态：请选择接单或者拒单</li>'
                        $("#orderList").append(waitAccept);   
				break;
			case "WAIT_PAYMENT":
				var waitPayent = '<br/><div  class="order-title"><h3>订单编号：'+data[i].id+'</h3><div class="fr order-operate">'+
               '</div></div><div class="order-content">'+
             '<img src="'+data[i].indexImageUrl+'"><div class="order-text"><h3>'+data[i].title+'</h3><ul>'+
                     '<li>创建时间：'+getLocalTime(data[i].createTime)+'</li><li>入住日期：'+getLocalTime(data[i].beginDate)+'</li><li>离开日期：'+getLocalTime(data[i].endDate)+'</li>'+
                    ' <li>合计金额：￥'+data[i].amount+'(共'+days+'晚)</li> <li>订单状态：等待支付</li>'
                     $("#orderList").append(waitPayent);
				break;
			case "REJECTED":
				var rejected = '<br/><div  class="order-title"><h3>订单编号：'+data[i].id+'</h3><div class="fr order-operate">'+
                '</div></div><div class="order-content">'+
              '<img src="'+data[i].indexImageUrl+'"><div class="order-text"><h3>'+data[i].title+'</h3><ul>'+
              '<li>创建时间：'+getLocalTime(data[i].createTime)+'</li><li>入住日期：'+getLocalTime(data[i].beginDate)+'</li><li>离开日期：'+getLocalTime(data[i].endDate)+'</li>'+
              ' <li>合计金额：￥'+data[i].amount+'(共'+days+'晚)</li> <li>订单状态：拒单</li>'+
                      '<li>拒单理由：'+data[i].comment +'</li>'
	                       $("#orderList").append(rejected);
				break;
			case "PAID":
				var paid = '<br/><div  class="order-title"><h3>订单编号：'+data[i].id+'</h3><div class="fr order-operate">'+
                '</div></div><div class="order-content">'+
                '<img src="'+data[i].indexImageUrl+'"><div class="order-text"><h3>'+data[i].title+'</h3><ul>'+
                '<li>创建时间：'+getLocalTime(data[i].createTime)+'</li><li>入住日期：'+getLocalTime(data[i].beginDate)+'</li><li>离开日期：'+getLocalTime(data[i].endDate)+'</li>'+
                 ' <li>合计金额：￥'+data[i].amount+'(共'+days+'晚)</li> <li>订单状态：已支付</li>'
  	                       $("#orderList").append(paid);
				break;
			default:
				break;
			}
		}
	}, "json")
})

function confirmOrder(id){
	$("#idConfirm").val(id)
	$("#accept-modal").modal('show');
}
function rejectedOrder(id){
	$("#idRejected").val(id)
	$("#reject-modal").modal('show');
}
 function getLocalTime(nS) { 
       return new Date(parseInt(nS)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " "); 
    } 

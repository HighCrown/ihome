$(function() {
	// 日期选择
	$(".input-daterange").datepicker({
		format : "yyyy-mm-dd",
		startDate : "today",
		language : "zh-CN",
		autoclose : true
	});
	$(".input-daterange").on("changeDate", function() {
		var startDate = $("#start-date").val();
		var endDate = $("#end-date").val();
		if (startDate && endDate && startDate > endDate) {
			showErrorMsg("日期有误，请重新选择!");
		} else {
			var sd = new Date(startDate);
			var ed = new Date(endDate);
			days = (ed - sd) / (1000 * 3600 * 24) + 1;
			var price = $("#housePrice").html();
			var deposit = $("#deposit").html();
			var add = "(共<font id='days'>" + days + "</font>天)"
			var amount = Number(days * price) + Number(deposit);
			$("#amount").html(amount);
			$("#night").html(add);
		}
	});

	var data = decodeQuery();
	housePrice = (data[3].split("="))[1]
	houseName = (data[4].split("="))[1]
	houseImage = (data[5].split("="))[1]
	deposit = (data[6].split("="))[1]
	minDays = (data[7].split("="))[1]
	maxDays = (data[8].split("="))[1]
	$("#houseImg").attr("src", houseImage);
	$("#houseTitle").html(houseName);
	$("#housePrice").html(housePrice)
	$("#deposit").html(deposit)
	$("#minDays").html(minDays)
	$("#maxDays").html(maxDays)
})

function hrefBack() {
	history.go(-1);
}

function showErrorMsg() {
	$('.popup_con').fadeIn('fast', function() {
		setTimeout(function() {
			$('.popup_con').fadeOut('fast', function() {
			});
		}, 1000)
	});
}

// 解析url中的查询字符串
function decodeQuery() {
	var search = decodeURI(document.location.search);
	var arr = search.replace('?', '').split('&')
	return arr;
}

//提交订单
function submitOrder() {
	var date = $("#start-date").val();
	var days=$("#days").html()
	var maxdays=$("#maxDays").html()
	if (date == "" || date == null || date == undefined) {
		alert("请选择日期");
	} else {
		if (Number(days)>Number(maxdays)) {
			alert("已超过最大入住天数，请重新选择")
		}else {
			var data = decodeQuery()
			var deposit = (data[6].split("="))[1]
			var userId = (data[0].split("="))[1]
			var sellerId = (data[1].split("="))[1]
			var houseId = (data[2].split("="))[1]
			var beginDate = $("#start-date").val()
			var endDate = $("#end-date").val()
			var days = $("#days").html()
			var housePrice = $("#housePrice").html()
			var amount = $("#amount").html()
			var status = "WAIT_ACCEPT"
			$.post("submitOrder", {
				"userId" : userId,
				"sellerId" : sellerId,
				"houseId" : houseId,
				"beginDate" : beginDate,
				"endDate" : endDate,
				"days" : days,
				"housePrice" : housePrice,
				"amount" : amount,
				"status" : status
			}, function(data) {
				location.href="order.jsp"
					alert("订单提交成功，请等待房主接单")
			})
		}
		}
}


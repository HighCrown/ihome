$(function() {
	// 获取房间ID
	var id = window.location.search.substr(1).split("=")[1];
	$(".search-btn").attr("house-id", id);
	// 获取该房屋详细信息
	$.post("gethousemsg", {
		"id" : id
	}, function(data) {

		$("#house-image").attr("src", data.indexImageUrl);
		$("#house-price").html(data.price);
		$(".house-title").html(data.title);
		$("#house-address").html(data.address);
		$("#house-count").html(data.roomCount);
		$("#house-acreage").html(data.acreage);
		$("#house-unit").html(data.unit);
		$("#house-capacity").html(data.capacity);
		$("#house-beds").html(data.beds);
		$("#house-deposit").html(data.deposit);
		$("#house-minDays").html(data.minDays);

		$(".search-btn").attr("house-name", data.title);
		$(".search-btn").attr("house-image", data.indexImageUrl);
		$(".search-btn").attr("house-price", data.price);
		$(".search-btn").attr("house-deposit", data.deposit);
		$(".search-btn").attr("minDays", data.minDays);
		$(".search-btn").attr("maxDays", data.maxDays);

		$.post("getuser", function(data1) {
			if (data1 == null) {
				$("#def").show();
				$("#abc").hide();
			} else {
				if (data1.id != data.userId) {
					$("#abc").show();
					$("#def").hide();
				} else {
					$("#abc").hide();
					$("#def").hide();
				}
			}
		}, "json")

		if (data.maxDays == 0) {
			$("#house-maxDays").html("无限制");
		} else {
			$("#house-maxDays").html(data.maxDays);
		}
		var uid = data.userId;

		$(".search-btn").attr("seller-id", uid);
		// 获取房主信息
		$.post("getusermsg", {
			"uid" : uid
		}, function(data) {
			$("#user-avatar").attr("src", data.avatarUrl);
			$("#user-name").html(data.name);
		}, "json")
	}, "json")
	// 获取设施信息
	$.post("getfacilitymsg", {
		"id" : id
	}, function(data) {
		for (var i = 0; i < data.length; i++) {
			$("#" + data[i].id).attr("color", "limegreen");
			$("#" + data[i].id + " span").attr("class",
					"glyphicon glyphicon-ok");
		}
	}, "json")
	// 设置日期框图
	$("#start-date").datepicker({
		language : "zh-CN",// 显示语言
		startDate : "today",// 开始日期
		format : "yyyy-mm-dd"// 日期格式
	});
	$("#start-date").on("changeDate", function() {
		var date = $(this).datepicker("getFormattedDate");
		$("#start-date-input").val(date);
	});

})

// 设置入住日期
function setStartDate() {
	var startDate = $("#start-date-input").val();
	if (startDate) {
		$(".search-btn").attr("start-date", startDate);
		$("#start-date-btn").html(startDate);
		$("#end-date").datepicker("destroy");
		$("#end-date-btn").html("离开日期");
		$("#end-date-input").val("");
		$(".search-btn").attr("end-date", "");
		$("#end-date").datepicker({
			language : "zh-CN",
			startDate : startDate,
			format : "yyyy-mm-dd"
		});
		$("#end-date").on("changeDate", function() {
			$("#end-date-input").val($(this).datepicker("getFormattedDate"));
		});
		$(".end-date").show();
	}
	$("#start-date-modal").modal("hide");
}

// 设置离开日期
function setEndDate() {
	var endDate = $("#end-date-input").val();
	if (endDate) {
		$(".search-btn").attr("end-date", endDate);
		$("#end-date-btn").html(endDate);
	}
	$("#end-date-modal").modal("hide");
}

// 去登陆
function goToLogin() {
	location.href = "login.jsp";
}
// 预定
function goToOrder(btn) {
	$.post("getuser", function(data) {
		location.href = "booking.html?" + "userId=" + data.id + "&"
				+ "sellerId=" + $(btn).attr("seller-id") + "&" + "houseId="
				+ $(btn).attr("house-id") + "&" + "housePrice="
				+ $(btn).attr("house-price") + "&" + "houseName="
				+ $(btn).attr("house-name") + "&" + "houseImage="
				+ $(btn).attr("house-image") + "&" + "deposit="
				+ $(btn).attr("house-deposit") + "&" + "minDays="
				+ $(btn).attr("minDays") + "&" + "maxDays="
				+ $(btn).attr("maxDays");
	}, "json")
}

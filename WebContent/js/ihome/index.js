$(function() {
	// 得到城区数据
	$.post("areasList", function(data) {
		for (var i = 0; i < data.length; i++) {
			var area = "<a href='#' area-id=" + data[i].id
					+ " onclick=confirmArea('" + data[i].id + "-"
					+ data[i].name + "')>" + data[i].name + "</a>";
			$("#areaModal").append(area);
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
	// 检查用户的登录状态
	$.post("getuser",function(data){
		if (data!=null) {
            $(".top-bar>.user-info").show();
            $(".top-bar>.register-login").hide();
            $("#user-name").html(data.name);
		}else {
			$(".top-bar>.register-login").show();
		}
	},"json")

})

// 选择城区
function confirmArea(name) {
	$("#area-modal").modal("hide");
	var arr = name.split("-");
	$("#area-btn").html(arr[1]);
	$(".search-btn").attr("area-id", arr[0]);
	$(".search-btn").attr("area-name", arr[1]);
}

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

// 传递数据
function goToSearchPage(btn) {
	var end = $("#end-date-btn").html();
	if (end === "离开日期") {
		alert("请选择离开日期");
	} else {
		location.href = "search.jsp?" + "aid=" + $(btn).attr("area-id") + "&"
				+ "aname=" + $(btn).attr("area-name") + "&" + "sd="
				+ $(btn).attr("start-date") + "&" + "ed="
				+ $(btn).attr("end-date");
	}
}
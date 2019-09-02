var currPage=1;
var pageTotal=0;
var pageSize=6;
var findFlag=1;
var aid="";
var temp="";
var aname="";
var sd="";
var ed="";

// 解析url中的查询字符串
function decodeQuery() {
	var search = decodeURI(document.location.search);
	if (search=="") {
		return;
	}
	var arr=search.replace('?', '').split('&')
	
	aid=(arr[0].split("="))[1]
	aname=(arr[1].split("="))[1]
    sd=(arr[2].split("="))[1]	
    ed=(arr[3].split("="))[1]
	
}
$(function() {
	 decodeQuery();
	
	 $("#start-date").val(sd);
     $("#end-date").val(ed);
    if (sd!="") {
        var text = sd.substr(5) + "/" + ed.substr(5);
        $("#dateTitle").html(text);
    } else {
    	$("#dateTitle").html("入住日期");
    }
    
    if (!aname) aname = "位置区域";
    $("#areaTitle").html(aname);

	findAreas();
	findHouseMsg();
	$(".input-daterange").datepicker({
        format: "yyyy-mm-dd",
        startDate: "today",
        language: "zh-CN",
        autoclose: true
    });
    var $filterItem = $(".filter-item-bar>.filter-item");
    $(".filter-title-bar").on("click", ".filter-title", function(e){
        var index = $(this).index();
        if (!$filterItem.eq(index).hasClass("active")) {
            $(this).children("span").children("i").removeClass("fa-angle-down").addClass("fa-angle-up");
            $(this).siblings(".filter-title").children("span").children("i").removeClass("fa-angle-up").addClass("fa-angle-down");
            $filterItem.eq(index).addClass("active").siblings(".filter-item").removeClass("active");
            $(".display-mask").show();
        } else {
            $(this).children("span").children("i").removeClass("fa-angle-up").addClass("fa-angle-down");
            $filterItem.eq(index).removeClass('active');
            $(".display-mask").hide();
            updateDateDisplay();
        }
    });
    $(".display-mask").click(function() {
        $(this).hide();
        $filterItem.removeClass('active');
        updateDateDisplay();
        findHouseMsg();

    });
    $(".filter-item-bar>.filter-area").on("click", "li", function(e) {
        if (!$(this).hasClass("active")) {
            $(this).addClass("active");
            $(this).siblings("li").removeClass("active");
            $("#areaTitle").html($(this).html());
        } else {
            $(this).removeClass("active");
            $("#areaTitle").html("位置区域");
        }
    });

    $("#new").click(function() {
    	$("#switch1 li").removeClass("active");
		$(this).addClass("active");
		$("#conditionThree").html($(this).html());
		findFlag=1;
		findHouseMsg();
	});
    $("#booking").click(function() {
    	$("#switch1 li").removeClass("active");
    	$(this).addClass("active");
    	$("#conditionThree").html($(this).html());
    	findFlag=2;
    	findHouseMsg();
    });
    $("#price-inc").click(function() {
    	$("#switch1 li").removeClass("active");
    	$(this).addClass("active");
    	$("#conditionThree").html($(this).html());
    	findFlag=3;
    	findHouseMsg();
    });
    $("#price-des").click(function() {
    	$("#switch1 li").removeClass("active");
    	$(this).addClass("active");
    	$("#conditionThree").html($(this).html());
    	findFlag=4;
    	findHouseMsg();
    });
    
	
})
function updateDateDisplay() {
    sd = $("#start-date").val();
    ed = $("#end-date").val();
    if (sd!="") {
        var text = sd.substr(5) + "/" + ed.substr(5);
        $("#dateTitle").html(text);
    } else {
    	$("#dateTitle").html("入住日期");
    }
}
// 查询城市区域信息
function findAreas() {
	$.post("/ihome/findAreas",function(data){
		if(aid==""){
		for (var i = 0; i < data.length; i++) {
			$(".filter-area").append('<li onclick="changeArea('+ data[i].id+')">'+ data[i].name+'</li>');
		}
	  }else {
		for (var i = 0; i < data.length; i++) {
			
			if (data[i].id==parseInt(aid)) {
				 $(".filter-area").append('<li onclick="changeArea('+ data[i].id+')" class="active">'+ data[i].name+'</li>');
			}else {
                $(".filter-area").append('<li onclick="changeArea('+ data[i].id+')">'+ data[i].name+'</li>');
            }
		}
	}
	},"json")
	
	
}

function findHouseMsg() {
	sd = $("#start-date").val();
    ed = $("#end-date").val();
//	var sdDate=new Date(sd);
//	var edDate=new Date(ed);
//    var last=(edDate.getTime()-sdDate.getTime())/1000/60/60/24;
	$.post("/ihome/findHouseMsg",{"currPage":currPage,"pageSize":pageSize,"aid":aid,"sd":sd,"ed":ed,"findFlag":findFlag},function(data){
		$(".row").html("");
		$("#page").html("")
		var count=data.count;
		if (count==0) {
			$(".row").append('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red" size="3px">抱歉，没有您想要的房源信息</font>');
			
			return;
		}
		if (count%pageSize==0) {
			pageTotal=count/pageSize;
		}else {
			pageTotal=(count-count%pageSize)/pageSize+1;
		}
		
	        for (var i = 0; i < data.list.length; i++) {
	        var div=	'<div class="col-sm-6 col-md-4">'+
				'<div class="thumbnail">'+
					'<a href="detail.jsp?id='+data.list[i].id+'">'+
					'<img src="/ihome/'+data.list[i].indexImageUrl+'"></a>'+
					'<div class="house-desc">'+
						'<div class="landlord-pic">'+
							'<img width="55px" height="55px" src="/ihome/'+data.list[i].avatarUrl+'">'+
						'</div>'+
						'<div class="house-price">￥<span>'+data.list[i].price+'</span>/晚</div>'+
						'<font size="3px">'+data.list[i].title+'</font> <em>出租'+data.list[i].roomCount+'间 - '+data.list[i].orderCount+'次入住 - '+data.list[i].address+'</em>'+
					'</div></div></div>'
			$(".row").append(div);
	        }
	        if (currPage==1) {
				
	        	var left= '<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>';
			}else {
				var left= '<li><a href="#" aria-label="Previous" onclick="pageSwitch(-1)"><span aria-hidden="true">&laquo;</span></a></li>';
				
			}
	       $("#page").append(left);
	       
	    for (var i = 1; i <=pageTotal; i++) {
	    	if (currPage==i) {
	    		var pageIndex='<li class="active"><a href="#" onclick="pageChange('+i+')">'+i+'</a></li>';	
			}else {
				var pageIndex='<li><a href="#" onclick="pageChange('+i+')">'+i+'</a></li>';	
				
			}
	    	$("#page").append(pageIndex);
		}
	    if (currPage==pageTotal) {
	    	var right='<li class="disabled"><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
			
		}else {
			var right='<li><a href="#" aria-label="Next" onclick="pageSwitch(1)"><span aria-hidden="true">&raquo;</span></a></li>';
			
		}
	    $("#page").append(right);
	},"json")
	
}
function pageChange(i){
	currPage=i;
	findHouseMsg();
}
function pageSwitch(a) {
	currPage+=a;
	findHouseMsg();
	
}
function changeArea(id) {
		aid=id; 
		if(aid === temp){
			aid="";
			temp="";
		}else{
			temp=id;
		}
		findHouseMsg();
}
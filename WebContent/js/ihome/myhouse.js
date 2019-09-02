$(function(){
	findAllMyHouse();
});
//当前页面
var currPage = 1;
//一页个数
var pageSize = 3;
//最大页数
var totalPages = 0;
function findAllMyHouse(){
	$.post("findAllMyHouse",{"currPage":currPage,"pageSize":pageSize},function(data){
		var count = data.count;
		if(count%pageSize == 0){
			totalPages=count/pageSize;
		}else{
			totalPages=(count - count%pageSize)/pageSize + 1;
		}
		
		//清空
		$("#paging").html("");
		$("#houseList").html("");
		if(totalPages == 0){
			return;
		}
		
		//添加页面信息
		var house ="";
		for(var i = 0;i < data.list.length;i++){
			var item = JSON.stringify(data.list[i]);
			var temp = encodeURI(item);
			house = '<br/> '+
            '<a href="detail.jsp?id='+data.list[i].id+'">'+
            '<div class="house-title">'+
               ' <h3>房屋ID:'+data.list[i].id+'</h3>'+
            '</div>'+
            '<div class="house-content">'+
                '<img src="'+data.list[i].indexImageUrl+'">'+
               ' <div class="house-text"><ul>'+
                       ' <li>位于：'+data.list[i].areaName+'</li>'+
                        '<li>价格：￥'+data.list[i].price+'/晚</li>'+
                        '<li>发布时间：'+data.list[i].time+'</li>'+
                        '<li></li><li></li>'+
                        '<li style="float: right;"><button class="btn btn-success" onclick="updateModal('+'\''+temp+'\')" >修改</button>&nbsp;&nbsp;<button class="btn btn-danger" onclick="delHouse('+data.list[i].id+')">删除</button></li>'+
                    '</ul></div></div></a>'
              $("#houseList").append(house);
		}
		
		//添加分页码
		var letf = "";
		if(currPage == 1){
			left = "<li class='disabled'><a aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>"
		}else{
			left = "<li><a onclick='switchPage(-1)' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>"
		}
		$("#paging").append(left);
		
		var center="";
		for(var i = 1;i <= totalPages ;i++){
			if(currPage == i){
				center = '<li class="active"><a class="item" onclick="change('+i+')">'+i+'</a></li>'
			}else{
				center = '<li ><a class="item" onclick="change('+i+')">'+i+'</a></li>'
			}
			$("#paging").append(center);
		}
		
		var right="";
		if(currPage == totalPages){
			right = '<li class="disabled"><a   aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>'
		}else{
			right = '<li><a  onclick="switchPage(1)" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>'
		}
		$("#paging").append(right);
	},"json")
}

function change(i){
	currPage = i;
	findAllMyHouse();
}


function switchPage(val){
	if(currPage+val == 0 || currPage + val > totalPages){
		return;
	}
	currPage +=val;
	findAllMyHouse();
	
}

function updateModal(temp){
	event.preventDefault();
	var obj = JSON.parse(decodeURI(temp));
	$("#updateModal").modal('show');
	$("#UpdateForm").populateForm(obj);
	$.post("findAreaByHouseId",function(data){
		for(var i=0;i<data.length;i++){
			if(obj.areaId == data[i].id){
				$("#areaId").append("<option value="+data[i].id+">"+data[i].name+"</option>")
			}
		}
		for(var i=0;i<data.length;i++){
			if(obj.areaId != data[i].id){
				$("#areaId").append("<option value="+data[i].id+">"+data[i].name+"</option>")
			}
		}
	},"json")
	var id = obj.id;
	$.post("findFacilityByHouseId",{"id":id},function(data){
		for(var i = 0;i<data.length;i++){
			$("#"+data[i].facilityId).attr("checked","true");
		}
	},"json")
}

function delHouse(i){
	 event.preventDefault();
	 $.post("deleteMyHouse",{"id":i},function(data){
	 })
	 window.location.href = "myhouse.html"
}

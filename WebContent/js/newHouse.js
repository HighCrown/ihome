//页面加载完毕把所有的地区显示

$(function() {
	$.post("FindAllAreaServlet", function(data) {
		for (var i = 0; i < data.length; i++) {
			var a = "<option>" + data[i].name + "</option>"
			$("#area-id").append(a);
		}
	}, "json")

	// 点击发布新房源之后把表单提交给servlet
	$("#addHouseBtn")
			.click(
					function() {
						var json = $("#addHouseForm").serializeJson();

						$.post("AddNewHouseServlet", json, function(data) {

						}, "json")

						alert("发布成功，请上传房间图片！")
						// 显示上传房间图片
						var img = "<form id='form-avatar' action='UploadHouseImgServlet' method='post' enctype='multipart/form-data'>"
								+ "<input type='hidden' name='house_id' id='house-id' value=''>"
								+ "<div class='house-title'>"
								+ "<h3>添加图片</h3>"
								+ "</div>"
								+ "<div class='house-content'>"
								+ "<div class='house-image-cons'></div>"
								+ "<div class='form-group'>"
								+ "<label for='house-image'>选择图片</label> <input type='file' accept='image/*' name='house_image' id='house-image'>"
								+ "</div>"
								+ "<input type='submit' class='btn btn-success' value='上传'>"
								+ "</div>" + "</form>";
						$("#houseImg").html(img);
					})
})

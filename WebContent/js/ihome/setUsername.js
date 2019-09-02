function updateUserButton() {
	var username = $("#user-name").val();
	$.post("setUser", {
		"user-name" : username
	}, function(data) {
		if (data == username) {
			alert("用户名已存在，请重新设置！")
		} else {
			alert("用户名修改成功！")
		}
	}, "json")
	
}
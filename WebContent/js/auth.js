$(function() {
	$
			.post(
					"UserSwitchAuthServlet",
					function(data) {
						if ((data.realName == null || data.realName == "")  && (data.idCard == null || data.idCard == "")) {
							$("#authif").html("(请完成认证!)");
						}else{
							alert("认证成功")
							$("#xiaoshi").html("");
							$("#namexiaoshi")
									.html(
											"<input type='text' value = '"+data.realName+"' disabled='true' class='form-control' name='realName' id='realName' >");
							$("#idxiaoshi")
									.html(
											" <input type='text' value = '"+data.idCard+"' disabled='true' class='form-control' name='idCard' id='idCard'>");
						}
							
					}, "json")
})

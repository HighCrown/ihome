
var flag = false;
$(function(){
	$("#sendMsg").click(function(){
		var msg = $("#mobile").val()
		if(flag = true){
			$.post("/ihome/CodeServlet2",{"code":msg},function(data){
			})
		}
	})


	$("#mobile").blur(function(){
		var phone = $(this).val();
	    if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))){ 
	       $("#fontMobile").html("手机号码有误，请重填")
	    	   flag=false;
	    }else{
	    	$("#fontMobile").html("")
	    	flag = true;
	    }
	})	
})
	
function submitTest(){
		  if ($("#username").val()==""){
			   alert("请填写用户名！");
			   addForm.username.focus();
			   return false;
			           }
			  if ($("#password").val()==""){
			                alert("请填写密码！");
			                addForm.title.focus();
			                return false;
			            }
			           return true;
}
	

	























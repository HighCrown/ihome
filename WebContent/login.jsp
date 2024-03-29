<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>爱家-登陆</title>
    <link href="/ihome/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/ihome/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/ihome/css/reset.css" rel="stylesheet">
    <link href="/ihome/css/main.css" rel="stylesheet">
    <link href="/ihome/css/login.css" rel="stylesheet">
<script type="text/javascript">
        /*7Core-CN - 网页鼠标点击特效（爱心）*/
        !function (e, t, a) {function r() {for (var e = 0; e < s.length; e++) s[e].alpha <= 0 ? (t.body.removeChild(s[e].el), s.splice(e, 1)) : (s[e].y--, s[e].scale += .004, s[e].alpha -= .013, s[e].el.style.cssText = "left:" + s[e].x + "px;top:" + s[e].y + "px;opacity:" + s[e].alpha + ";transform:scale(" + s[e].scale + "," + s[e].scale + ") rotate(45deg);background:" + s[e].color + ";z-index:99999");requestAnimationFrame(r)}function n() {var t = "function" == typeof e.onclick && e.onclick;e.onclick = function (e) {t && t(), o(e)}}function o(e) {var a = t.createElement("div");a.className = "heart", s.push({el: a,x: e.clientX - 5,y: e.clientY - 5,scale: 1,alpha: 1,color: c()}), t.body.appendChild(a)}function i(e) {var a = t.createElement("style");a.type = "text/css";try {a.appendChild(t.createTextNode(e))} catch (t) {a.styleSheet.cssText = e}t.getElementsByTagName("head")[0].appendChild(a)}function c() {return "rgb(" + ~~(255 * Math.random()) + "," + ~~(255 * Math.random()) + "," + ~~(255 * Math.random()) + ")"}var s = [];e.requestAnimationFrame = e.requestAnimationFrame || e.webkitRequestAnimationFrame || e.mozRequestAnimationFrame || e.oRequestAnimationFrame || e.msRequestAnimationFrame || function (e) {setTimeout(e, 1e3 / 60)}, i(".heart{width: 10px;height: 10px;position: fixed;background: #f00;transform: rotate(45deg);-webkit-transform: rotate(45deg);-moz-transform: rotate(45deg);}.heart:after,.heart:before{content: '';width: inherit;height: inherit;background: inherit;border-radius: 50%;-webkit-border-radius: 50%;-moz-border-radius: 50%;position: fixed;}.heart:after{top: -5px;}.heart:before{left: -5px;}"), n(), r()}(window, document);
</script>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
        /* 鼠标点击特效 - 7Core.CN */
        var a_idx = 0;jQuery(document).ready(function($) {$("body").click(function(e) {var a = new Array("富强", "民主", "文明", "和谐", "自由", "平等", "公正" ,"法治", "爱国", "敬业", "诚信", "友善");var $i = $("<span/>").text(a[a_idx]);
        a_idx = (a_idx + 1) % a.length;var x = e.pageX,y = e.pageY;$i.css({"z-index": 100000000,"top": y - 20,"left": x,"position": "absolute","font-weight": "bold","color": "#ff6651"});$("body").append($i);$i.animate({"top": y - 180,"opacity": 0},1500,function() {$i.remove();});});});
</script>
<script src="//cdn.bootcss.com/canvas-nest.js/1.0.0/canvas-nest.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="logo-bar"><a href="index.html"><img src="/ihome/img/logo@128x59.png"></a></div>
        <form class="form-login" action="check">
            <div class="form-group form-group-lg">
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-user fa-lg fa-fw"></i></div>
                    <input type="number" class="form-control" name="mobile" id="mobile" placeholder="手机号" value="18627143333" required>
                </div>
            </div>
            <div class="error-msg" id="mobile-err"><i class="fa fa-exclamation-circle"></i><span></span></div>
            <div class="form-group form-group-lg">
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-lock fa-lg fa-fw"></i></div>
                    <!--  密码输入框 -->
                    <input type="password" class="form-control" name="passwordHash" id="password" placeholder="密码" required>
                </div>
                <br>
                <div>
                <!-- 图片验证码输入框 -->
                <input type="text" name="checkcode" class="form-control" placeholder="图片验证码">
                </div>
                <br>
                <!-- 图片验证码以及报错框 -->
                <a class="btn btn-default" href="#" role="button"><img  src="/ihome/Imag" onclick="changecode(this)"/></a>
                <font color="red">${msg}</font> 
            </div>
            <div class="error-msg" id="password-err"><i class="fa fa-exclamation-circle"></i><span></span></div>
            <button type="submit" class="btn btn-lg btn-theme btn-block">登录</button>
            <p class="register-a">没有账号，<a href="regist.html">立即注册</a></p>
        </form>
   </div>
    <script src="/ihome/js/jquery.1.9.min.js"></script>
    <script src="/ihome/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="/ihome/js/login.js"></script>
</body>
</html>
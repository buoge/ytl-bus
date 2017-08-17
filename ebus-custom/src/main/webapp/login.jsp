<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>蓝泰源App管理系统</title>
 <link rel="stylesheet" type="text/css" href="${appName}/commons/lib/easyui/themes/default/easyui.css">  
<link rel="stylesheet" href="${appName}/commons/css/login.css">
<script type="text/javascript">

</script>
</head>
<body onkeydown="on_return();">
	<div class="head">
		<p></p>
	</div>
	<div class="content">
		<div class="login">
			<p>用户登录</p>
			<div class="message">
				<div class="user">
					<div class="first">
						<label for=""></label><input type="text">
					</div>
					<span class="userName">用户名不能为空</span>
					<div class="firsts">
						<label for=""></label><input type="password">
					</div>
					<span class="pwdName">密码不能为空</span>
				</div>
			</div>
			<button onclick="loginTo();" id="login">登录</button>
		</div>
	</div>
	<input type='hidden'   id='appName'  value="${appName}"/>
</body>
<script type="text/javascript" src="${appName}/commons/lib/jquery.js"></script>
<script type="text/javascript" src="${appName}/commons/lib/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${appName}/commons/js/system/login.js"></script>
<script type="text/javascript" src="${appName}/commons/js/publicCommon/publicCommon.js"></script>
</html>
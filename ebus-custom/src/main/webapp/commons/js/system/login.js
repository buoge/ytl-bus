$(function() {
	var $input = $(".user div input")
	$input.focus(function() {
		$(this).parent().addClass("colorChange").siblings()
		.removeClass("colorChange");
	})
});
//登陆方法
function loginTo(){
	var $uesr = $(".user .first input").val();
	var $pwd = $(".user .firsts input").val();
	if (!$uesr) {
		$(".user .userName").show();
		return false;
	}
	if (!$pwd) {
		$(".user .pwdName").show();
		return false;
	}
	if ($uesr) {
		$(".user .userName").hide();
	}
	if ($pwd) {
		$(".user .pwdName").hide();
	}
	ajaxValide($uesr, $pwd);
}

//回车时，默认是登陆
function on_return(){
 if(window.event.keyCode == 13){
  if (document.all('login')!=null){
     document.all('login').click();
     }
 }
}
var appName=$('#appName').val();
//登陆验证
function ajaxValide(user, pwd) {
	var params = {
			userName : user,
			passWord : pwd
	};
	localStorageUtil.setLocalStorageItem("userNas",user);
	$.ajax({
		type : "POST",
		url : appName+"/webapp/login",
		data : params,
		dataType : "json",
		success : function(data) {
			if (data.success) {
				window.location.href = appName+'/webviews/main.jsp';
				
				
			} else {
				$.messager.alert('系统提示', data.msg, 'info');
			}
		},
		error : function() {
			$.messager.alert('系统提示', '抱歉，出错了。', 'info');
		}
	});
}
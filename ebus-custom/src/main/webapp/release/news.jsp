<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" /> 
<title>列表</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
<div class="page">
    <div class="page-header"></div>
    <div class="page-info"> <span class="page-total fr"></span><span class="page-time fr"></span></div>
    <div class="page-content">

    </div><!--end content -->
</div><!--end page -->

<script src="js/zepto.js"></script>
<script type="text/javascript">
$(function(){
	dataInfo();
})

Date.prototype.Format = function (fmt) { 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
//获取参数id func
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    console.log(window.location.search);
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
function dataInfo(){
	var urlId=getUrlParam("id");
	$.ajax({
		url : '${appName}/busnews/newsDetail',
		data: {id:urlId},
		cache : false,
		type:'post',
		dataType : 'JSON',
		success : function(data) {
			var result = $.parseJSON(data);
			if (result&&result.success) {
				listView(result);
			}
		}
	});
}
function listView(news){
	var content=news.obj;
	$('.page-header').html(content.title);
	$('.page-content').html(content.content);
	var date=parseInt(content.createtime);
	var time=new Date(date).Format("yyyy-MM-dd hh:mm:ss");
	$('.page-time').text(time);
	$('.page-total').text(content.peopleViews);
}

</script>
</body>
</html>

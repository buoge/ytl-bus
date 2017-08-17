/*  wxl   2016 12/26 
 * newsManageDetial
 */
$(function(){
	//实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    //var ue = UE.getEditor('editor');
	$('#acityChoose').combobox({
		url:appName+'/webapp/cities',
		valueField:'citycode',
		textField:'cityname',
		loadFilter:function(data){
			if(data.success) {
				data.obj[0].selected = true;
				return data.obj;
			}else{
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
		}
	});
	$('#dcityChoose').combobox({
		url:appName+'/webapp/cities',
		valueField:'citycode',
		textField:'cityname',
		loadFilter:function(data){
			if(data.success) {
				var rows = $('#girdNewsManage').datagrid('getSelected');
				for(var i = 0; i < data.obj.length; i++) {
					if(data.obj[i].citycode == rows.cityCode) {
						data.obj[i].selected = true;
						break;
					}
				}
				return data.obj;
			}else{
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
		},
	});
	
	$('#ecityChoose').combobox({
		url:appName+'/webapp/cities',
		valueField:'citycode',
		textField:'cityname',
		loadFilter:function(data){
			if(data.success) {
				var rows = $('#girdNewsManage').datagrid('getSelected');
				for(var i = 0; i < data.obj.length; i++) {
					if(data.obj[i].citycode == rows.cityCode) {
						data.obj[i].selected = true;
						break;
					}
				}
				return data.obj;
			}else{
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
		},
	});
	
	$('#eocityChoose').combobox({
		url:appName+'/webapp/cities',
		valueField:'citycode',
		textField:'cityname',
		loadFilter:function(data){
			if(data.success) {
				var rows = $('#girdNewsManage').datagrid('getSelected');
				for(var i = 0; i < data.obj.length; i++) {
					if(data.obj[i].citycode == rows.cityCode) {
						data.obj[i].selected = true;
						break;
					}
				}
				return data.obj;
			}else{
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
		},
	});
	
	$('#docityChoose').combobox({
		url:appName+'/webapp/cities',
		valueField:'citycode',
		textField:'cityname',
		loadFilter:function(data){
			if(data.success) {
				var rows = $('#girdNewsManage').datagrid('getSelected');
				for(var i = 0; i < data.obj.length; i++) {
					if(data.obj[i].citycode == rows.cityCode) {
						data.obj[i].selected = true;
						break;
					}
				}
				return data.obj;
			}else{
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
		},
	});
	
});

function addNews() {
	$("#dialogForm").form('submit',{
		url:appName+'/webapp/insertNews',
		onSubmit:function(param){
			if(!$("#dialogForm").form("validate")){
				return false;
			}
			if($('#atitle').val() == undefined || $('#atitle').val().trim() == '') {
				$.messager.alert('系统提示','<div class="item-errortip">标题不能为空','info'); 
				return false;
			}
			if($('#aicon_url').val() == undefined || $('#aicon_url').val() == '') {
				$.messager.alert('系统提示','<div class="item-errortip">请选择图标，并上传图片','info'); 
				return false;
			}
			if($('#anewsCategory').combobox('getValue') == 1 && $('#atype').combobox('getValue') == -2) {
				$.messager.alert('系统提示','<div class="item-errortip">公交动态需要区分排版类型，请选择','info'); 
				return false;
			}
			
			if($('#anewsCategory').combobox('getValue') == 2 && $('#atype').combobox('getValue') != -2) {
				$.messager.alert('系统提示','<div class="item-errortip">失物招领不区分排版类型，请选择无','info'); 
				return false;
			}
			param.content =$('#addContent').val();
			if(param.content == undefined || param.content == '') {
				$.messager.alert('系统提示','<div class="item-errortip">内容不能为空','info'); 
				return false;
			}
			
		},
		success:function(msg){
			var result = $.parseJSON(msg);
			if(result.success){
				$.messager.alert('系统提示','添加成功','info',function(){
					$("#dialogForm")[0].reset();
					$('#girdNewsManage').datagrid("reload");
					publicClose();
				});
			}else{
				$.messager.alert('系统提示',result.msg,'info'); 
			}
		},
		error:function(){
			$.messager.alert('系统提示','抱歉，出错了。','info'); 
		}
	});
}

function updateNews(formId) {
	$("#"+formId).form('submit',{
		url:appName+'/webapp/updateNews',
		onSubmit:function(param){
			if(!$("#"+formId).form("validate")){
				return false;
			}
			var icon_url, title;
			if(formId == "newsManageEditForm") {
				icon_url = $('#eicon_url').val();
				title = $('#etitle').val();
			}else {
				icon_url = $('#eoicon_url').val();
				title = $('#eotitle').val();
			}
			if(title == undefined || title.trim() == '') {
				$.messager.alert('系统提示','<div class="item-errortip">标题不能为空</div>','info'); 
				return false;
			}
			if(icon_url == undefined || icon_url == '') {
				$.messager.alert('系统提示','<div class="item-errortip">请选择图标，并上传图片</div>','info'); 
				return false;
			}
			if($('#enewsCategory').combobox('getValue') == 1 && $('#etype').combobox('getValue') == -2) {
				$.messager.alert('系统提示','<div class="item-errortip">公交动态需要区分排版类型，请选择','info'); 
				return false;
			}
			
			if($('#enewsCategory').combobox('getValue') == 2 && $('#etype').combobox('getValue') != -2) {
				$.messager.alert('系统提示','<div class="item-errortip">失物招领不区分排版类型，请选择无','info'); 
				return false;
			}
			param.content = $('#editContent').val();
			
			if(formId == "newsManageEditForm" && (param.content == undefined || param.content == '')) {
				$.messager.alert('系统提示','<div class="item-errortip">内容不能为空</div>','info'); 
				return false;
			}
		},
		success:function(msg){
			var result = $.parseJSON(msg);
			if(result.success){
				$.messager.alert('系统提示','修改成功','info',function(){
					$("#"+formId)[0].reset();
					$('#girdNewsManage').datagrid("reload");
					publicClose();
				});
			}else{
				$.messager.alert('系统提示',result.msg,'info'); 
			}
		},
		error:function(){
			$.messager.alert('系统提示','抱歉，出错了。','info'); 
		}
	});
}

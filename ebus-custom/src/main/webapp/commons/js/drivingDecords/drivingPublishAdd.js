//状态赋值
	var valStatus="";
	$('.item-check ').on('click',function(){
		  valStatus+= $(this).val()+',';
         $('#acceptLicenses').val(valStatus.substring(0,valStatus.length-1));
	});
//获取所有城市
$('#publishChoose').combobox({
	url : appName + '/webapp/cities',
	valueField : 'citycode',
	textField : 'cityname',
	loadFilter : function(data) {
		if (data.success) {
			data.obj[0].selected = true;
			return data.obj;
		} else {
			$.messager.alert('系统提示', '抱歉，出错了。', 'info');
		}
	}
});
//新增保存按钮
function addPublish() {
	$("#addPublishForm").form('submit',{
		 url:appName+'/driver/school/insert',    
		 onSubmit:function(param){
			 if(!$("#addPublishForm").form("validate")){
					return false;
				}
	      },
		success:function(msg){
			var result = $.parseJSON(msg);
			console.log(result);
			if(result.success){
				$.messager.alert('系统提示','添加成功','info',function(){
					$("#addPublishForm")[0].reset();
					$('#girdDrivingPublish').datagrid("reload");
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
//编辑提交
function pubishEdit(formId) {
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
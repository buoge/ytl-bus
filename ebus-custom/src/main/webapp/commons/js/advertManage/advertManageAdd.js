/*  wxl   2016 12/26 
 * newsManageDetial
 */
$(function(){
	$('#addAcityChoose').combobox({
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
	$('#acityChoose').combobox({
		url:appName+'/webapp/cities',
		valueField:'citycode',
		textField:'cityname',
		loadFilter:function(data){
			if(data.success) {
				var rows = $('#girdAdvertManage').datagrid('getSelected');
				for(var i = 0; i < data.obj.length; i++) {
					if(data.obj[i].citycode == rows.citycode) {
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
})
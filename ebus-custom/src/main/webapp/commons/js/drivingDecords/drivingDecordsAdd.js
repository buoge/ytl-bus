//新增保存按钮
function addDriving() {
	$("#addDrivingForm").form('submit',{
		 url:appName+'/driver/school/signUp/contact/get',    
		 onSubmit:function(param){
			 if(!$("#addDrivingForm").form("validate")){
					return false;
				}
	      },
		success:function(msg){
			var result = $.parseJSON(msg);
			if(result.success){
				$.messager.alert('系统提示','添加成功','info',function(){
					$("#addDrivingForm")[0].reset();
					$('#girdDrivingDecords').datagrid("reload");
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
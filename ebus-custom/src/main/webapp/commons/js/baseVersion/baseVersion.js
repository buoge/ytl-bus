/*  wxl   2016 12/29 
 * girdBaseVersion
 */
$(function(){
	//初始化initDatagridBaseVersion表格
	initDatagridBaseVersion();
});
var appName=$('#appName').val();
//初始化initDatagridBaseVersion funtion
function initDatagridBaseVersion(){
	$('#girdBaseVersion').datagrid({
      method:'post',
	  url:appName+'/version/getServiceIpByPage',
	  toolbar: '#tb',
      align:'center',
      singleSelect:true,  //单选  false多选
      rownumbers:true,    //序号
      pagination:true,    //分页
      fitColumns:true,    //占满
      showFooter:true,
      pageNumber:1,
      pageSize:20,
      height:'auto',
      width:'100%',
      columns:[[
          {field: "id",title: "id",align: 'center',hidden:true,width: 80},
          {field: "serviceip",title: "城市上传ip",align: 'center', width: 100 },
          {field: "times",title: "每日最大上传次数",align: 'center',width: 150 }, 
          {field: "cityname",title: "城市名称",align: 'center',width: 180},
          {field: "citycode",title: "城市代码",align: 'center',width:80},
          {field: "authority",title: "权限",align: 'center',width: 400},
          {field:'quotedtime',title:'操作',width:130,align:'center',
        	  formatter: function(value ,row,index){
        		  var str="<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"+index+"' onclick='baseVersionEdit(event);'>编辑</a>"+
        			           "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"+index+"' onclick='baseVersionDelete(event);'>删除</a>"
              	  return  str; 
			  }
          },
      ]],
      loadFilter: function(data){
    	  console.log(data);
    	  if (data.success){
				return data.obj;
			} else {
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
     	}
	});
}
//查询事件
$(document).on('click','#query',function(){
		$('#girdBaseVersion').datagrid("load",{
			cityname:$("#cityname").val(),
			citycode:$("#citycode").val()
		});
});

//新增信息动态创建dialog
function baseVersionAdd() {
		var dialog=	$('<div/>').dialog({
			href : appName+'/webviews/baseVersion/baseVersionAdd.jsp',
			width : 270,
			height :420,
			modal : true,
			title : '新增信息',
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				//传对应dialog对象和按钮id
				 dialogCallback($(this));
			}
		});
}

//编辑信息动态创建dialog
function baseVersionEdit(event) {
	var index = $(event.target).attr('data-index');
	$("#girdBaseVersion").datagrid('selectRow',index);
	var rows = $('#girdBaseVersion').datagrid('getSelected');
	var dialog=	$('<div/>').dialog({
		href : appName+'/webviews/baseVersion/baseVersionEdit.jsp',
		width : 270,
		height :420,
		modal : true,
		title : '详细信息',
		onClose : function() {
			$(this).dialog('destroy');
			
		},
		onLoad : function() {
			var me = this;
			$("#baseVersionEditForm").form("load",rows);//填充数据
			//传对应dialog对象和按钮id
			 dialogCallback($(this));
		}
	});
}

//删除信息动态confirm一行
function baseVersionDelete(event) {
	var index = $(event.target).attr('data-index');
	$("#girdBaseVersion").datagrid('selectRow',index);
	var delrows = $('#girdBaseVersion').datagrid('getSelected');
	console.log(delrows)
	if (delrows) {
		$.messager.confirm('询问', '<div class="messager-tip">您确定要删除【' + delrows.id + '】？</div>', function(data) {
			if (data) {
				$.ajax({
					url : appName+'/serviceIp/deleteServiceIp/'+delrows.id,
					cache : false,
					type : 'delete',
					dataType : 'JSON',
					success : function(r) {
						if (r.success) {
							$.messager.alert('系统提示',r.msg,'info');
							$('#girdBaseVersion').datagrid('reload');
						}
						$.messager.show({
							msg : r.msg,
							title : '提示'
						});
					}
				});
			}
		});
	}
}

//城市ip配置新增页面表单提交
function commitBaseVersionAdd(){
	$("#baseVersionAddForm").form('submit',{
		url:appName+'/serviceIp/addServiceIp',
		onSubmit:function(param){
			$("#baseVersionAddForm").form("enableValidation");
			if(!$("#baseVersionAddForm").form("validate")){
				return false;
			}
			//param = $("#baseVersionAddForm").serializeArray();
		},
		success:function(msg){
			var result = $.parseJSON(msg);
			if(result.success){
				$.messager.alert('系统提示','操作成功','info',function(){
					$("#baseVersionAddForm").window("close");
				});
				$('#girdBaseVersion').datagrid('reload');
				  publicClose();
			}else{
				$.messager.alert('系统提示',result.msg,'info'); 
			}
		},
		error:function(){
			$.messager.alert('系统提示','抱歉，出错了。','info'); 
		}
	});
}

//城市ip配置编辑页面表单提交
function commitBaseVersionEdit(){
	$("#baseVersionEditForm").form('submit',{
		url:appName+'/serviceIp/updateServiceIp',
		onSubmit:function(param){
			$("#baseVersionEditForm").form("enableValidation");
			if(!$("#baseVersionEditForm").form("validate")){
				return false;
			}
		},
		success:function(msg){
			var result = $.parseJSON(msg);
			if(result&&result.success){
				$.messager.alert('系统提示',result.msg,'info',function(){
					  publicClose();
				});
				$('#girdBaseVersion').datagrid('reload');
				
			}else{
				$.messager.alert('系统提示',result.msg,'info'); 
			}
		},
		error:function(){
			$.messager.alert('系统提示','抱歉，出错了。','info'); 
		}
	});
}

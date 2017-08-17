/*  wxl   2016 12/26 
 * initDatagridAdvertManage
 */
$(function(){
	//初始化initDatagridAdvertManage表格
	initDatagridAdvertManage();
});
var appName=$('#appName').val();
//初始化initDatagridAdvertManage funtion
function initDatagridAdvertManage(){
	  var height=setDatagirdTable();
	$('#girdAdvertManage').datagrid({
	    //title:'普通表单-用键盘操作',
        method:'post',
	  url:appName+'/webapp/queryImageList',
	  toolbar: '#tb',
      align:'center',
      //toolbar: '#tb',     //工具栏 id为tb
      singleSelect:true,  //单选  false多选
      rownumbers:true,    //序号
      pagination:true,    //分页
      fitColumns:true,    //占满
      showFooter:true,
      pageNumber:1,
      pageSize:20,
      height:height,
      width:'100%',
      columns:[[
           {field : 'ck',checkbox : true},
          {field:'avdImage',title:'图片url',width:240,align:'center',hidden:true,},
          {field:'htmlUrl',title:'图片跳转url',width:240,align:'center',hidden:true,},
          {field:'type',title:'图片类型',width:80,align:'center',
        	  formatter:function(value) {
        			if(value) {
        				if(value==1){
        					value="闪屏"
        				}
        				else if(value==2){
        					value="广告"
        				}
        				else if(value==3){
        					value="新特性 "
        				}
        				return value;
        			}
          	  }
          },
          {field:'citycode',title:'所属城市',width:80,align:'center',editor:'textbox'},
          {field:'startdate',title:'生效时间',width:120,align:'center',
        	  formatter:function(value) {
      			if(value != undefined&&value!=null&&value != '') {
      				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
      			}
        	  }
          },
          {field:'enddate',title:'失效时间',width:120,align:'center',
        	  formatter:function(value) {
      			if(value != undefined&&value!=null&&value != '') {
      				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
      			}
        	  }
          },
          {field:'isvalid',title:'是否有效',width:80,align:'center',
        	  formatter: function(value){
					if(value==0) {
						return '否';
					}else if(value ==1) {
						return '是';
					}
				}
          },
          {field:'orderno',title:'排序',width:40,align:'center'},
          {field:'operate',title:'操作',width:100,align:'center',
        	  formatter: function(value ,row,index){
        		 
        	      if(row.isvalid==0){
		                 var   isvalid="<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"+index+"' data-id='"+row.id+"'  onclick='advertManageInvalid(event);'>生效</a>"
		                }
		                else{
		                 var   isvalid="<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"+index+"' data-id='"+row.id+"'   onclick='advertManageToInvalid(event);'>失效</a>"
                      }
        		  var str="<a class='item-span  f-blue fl'  href='javascript:void(0);'  data-index='"+index+"' onclick='advertManageDetial(event)'>详细</a>" +
        		                "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"+index+"' onclick='advertManageEdit(event)'>编辑</a> "+isvalid
        		               
        		        return  str; 
				}
          },
      ]],
      loadFilter: function(data){
    	  console.log(data)
    	  if (data.success){
				return data.obj;
			} else {
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
     	}
	});
}
$('#LinesChoose').combobox({
	url:appName+'/baseRoute/routes/'+$("#line"),
	valueField:'routeId',
	textField:'routeName',
	loadFilter:function(data){
		if(data.success) {
			data.obj[0].selected = true;
			return data.obj;
			console.log(data.obj)
		}else{
			$.messager.alert('系统提示','抱歉，出错了。','info');
		}
	}
});
//查询事件
$(document).on('click','#query',function(){
		$('#girdAdvertManage').datagrid("load",{
			isValid:$("#isvalid").combobox('getValue'),
			type:$("#type").combobox('getValue'),
			citycode:$("#cityChoose").combobox('getValue'),
		});
});

//新增信息动态创建dialog
function advertManageAdd() {
var dialog=	$('<div/>').dialog({
		href : appName+'/webviews/advertManage/advertManageAdd.jsp',
		width :640,
		height :440,
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

//详细信息动态创建dialog
function advertManageDetial(event) {
	var index = $(event.target).attr('data-index');
	$("#girdAdvertManage").datagrid('selectRow',index);
	var rows = $('#girdAdvertManage').datagrid('getSelected');
	//日期格式化
	rows.startdate= formatDate(rows.startdate,'yyyy-MM-dd');
	rows.enddate= formatDate(rows.enddate,'yyyy-MM-dd')
	var dialog=	$('<div/>').dialog({
			href : appName+'/webviews/advertManage/advertManageDetial.jsp',
			width :640,
			height :600,
			modal : true,
			title : '详细信息',
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				$("#detialAdvertFrom").form("load",rows);//填充数据
				$('.fileimg').attr('src',rows.avdImage)
				//传对应dialog对象和按钮id
				 dialogCallback($(this));
				//禁止所有input  时间文本框编辑
				 publicDisabled('detialAdvertFrom');
			}
		});
}

//详细信息动态创建dialog
function advertManageEdit(event) {
	var index = $(event.target).attr('data-index');
	$("#girdAdvertManage").datagrid('selectRow',index);
	var rows = $('#girdAdvertManage').datagrid('getSelected');
	//日期格式化
	rows.startdate= formatDate(rows.startdate,'yyyy-MM-dd');
	rows.enddate= formatDate(rows.enddate,'yyyy-MM-dd')
	var dialog=	$('<div/>').dialog({
			href : appName+'/webviews/advertManage/advertManageEdit.jsp',
			width :640,
			height :600,
			modal : true,
			title : '详细信息',
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				$("#editAdvertFrom").form("load",rows);//填充数据
				$('.fileimg').attr('src',rows.avdImage);
				//传对应dialog对象和按钮id
				 dialogCallback($(this));
			}
		});
}

//生效信息动态confirm一行
function advertManageInvalid(index) {
	var index = $(event.target).attr('data-index');
	var rowid = $(event.target).attr('data-id');
	console.log(rowid);
	$("#girdAdvertManage").datagrid('selectRow',index);
	var delrows = $('#girdAdvertManage').datagrid('getSelected');
	if (delrows) {
		$.messager.confirm('询问', '<div class="messager-tip">您确定让该屏闪图生效？</div>', function(data) {
			if (data) {
				$.ajax({
					url : appName+'/webapp/modifyImageToValid',
					data : {id : rowid},
					cache : false,
					//dataType : 'JSON',
					type:'POST',
					success : function(result) {
						var result = $.parseJSON(result);
						if (result&&result.success) {
							$('#girdAdvertManage').datagrid('reload');
						}
						$.messager.alert('系统提示',result.msg,'info'); 
					}
				});
			}
		});
	}
}
//失效信息动态confirm一行
function advertManageToInvalid(index) {
	var index = $(event.target).attr('data-index');
	var rowid = $(event.target).attr('data-id');
	$("#girdAdvertManage").datagrid('selectRow',index);
	var delrows = $('#girdAdvertManage').datagrid('getSelected');
	if (delrows) {
		$.messager.confirm('询问', '<div class="messager-tip">您确定让该屏闪图失效？</div>', function(data) {
			if (data) {
				$.ajax({
					url : appName+'/webapp/modifyImageToUnValid',
					data : {id : rowid},
					cache : false,
					type:'post',
					//dataType : 'JSON',
					success : function(result) {
						var result = $.parseJSON(result);
						if (result&&result.success) {
							$('#girdAdvertManage').datagrid('reload');
						}
						$.messager.alert('系统提示',result.msg,'info'); 
					}
				});
			}
		});
	}
}
//新增保存按钮
function submitFrom() {
	$("#addAdvertFrom").form('submit',{
		 url:appName+'/webapp/saveImage',    
		 onSubmit:function(param){
			 if(!$("#addAdvertFrom").form("validate")){
					return false;
				}
			 if($('#startdate').val() == undefined || $('#startdate').val().trim() == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请输入生效时间</div>','info'); 
					return false;
				}
				if($('#enddate').val() == undefined || $('#enddate').val().trim() == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请输入失效时间</div>','info'); 
					return false;
				}
				if($('#aicon_url').val() == undefined || $('#aicon_url').val() == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请选择图标，并上传图片</div>','info'); 
					return false;
				}
				//图片宽高
				var height=$('.fileimg').height();
				var width=$('.fileimg').width();
				param.width=width;
				param.height=height;
	      },
		success:function(msg){
			var result = $.parseJSON(msg);
			if(result.success){
				$.messager.alert('系统提示','添加成功','info',function(){
					$("#addAdvertFrom")[0].reset();
					$('#girdAdvertManage').datagrid("reload");
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
//广告编辑提交
function submitEditFrom() {
	$("#editAdvertFrom").form('submit',{
		 onSubmit:function(param){
				if(!$('#editAdvertFrom').form("validate")){
					return false;
				}
				if($('#startdate').val() == undefined || $('#startdate').val().trim() == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请输入生效时间</div>','info'); 
					return false;
				}
				if($('#enddate').val() == undefined || $('#enddate').val().trim() == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请输入失效时间</div>','info'); 
					return false;
				}
				if($('#aicon_url').val() == undefined || $('#aicon_url').val() == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请选择图标，并上传图片</div>','info'); 
					return false;
				}
				//图片宽高
				var height=$('.fileimg').height();
				var width=$('.fileimg').width();
				param.width=width;
				param.height=height;
	    	  },
		 url:appName+'/webapp/updateImage',    
		 success:function(msg){
			var result = $.parseJSON(msg);
			if(result.success){
				
				$.messager.alert('系统提示','编辑成功','info',function(){
					$("#editAdvertFrom")[0].reset();
					$('#girdAdvertManage').datagrid("reload");
					
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


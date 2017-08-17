var appName = $('#appName').val();
	// 插件的定义
	$.fn.suggestion = function(options) {

	}

	$.fn.suggestion.defaults = {    
			_add: true,
			_mod: true,
			_detail: true,
			_reply: true,
			_appPath:""
	};
	//页面初始化
	$.fn.suggestion.init = function() {
		$.fn.suggestion.initGridData();//表格数据初始化
		$.fn.suggestion.clickQueryButton();//初始化查询按钮
		$.fn.suggestion.initDetailDialog();//初始化建议反馈详情弹出框
		$.fn.suggestion.initReplyDialog();//初始化建议反馈回复弹出框
	};
	//将表单数据转为json
	$.fn.suggestion.form2Json = function(id) {
		var arr = $("#" + id).serializeArray()
		var jsonStr = "";
		jsonStr += '{';
		for (var i = 0; i < arr.length; i++) {
			jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
		}
		jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
		jsonStr += '}'
			var json = JSON.parse(jsonStr)
			return json
	};

	//初始化表格数据
	$.fn.suggestion.initGridData = function() {
		  var height=setDatagirdTable();
		$("#dg").datagrid({
			 method:'post',
			url: appName+'/suggestion/getSuggestionPagging',
			align:'center',
			toolbar: '#tb',     //工具栏 id为tb
			singleSelect:true,  //单选  false多选
			rownumbers:true,    //序号
			pagination:true,    //分页
//			fitColumns:true,    //占满
			showFooter:true,
			pageNumber:1,
			pageSize:20,
			height:height,
			width:'100%',
			pageList: [5, 10, 15, 20, 25, 30, 50, 80, 200],
			queryParams: $().suggestion.form2Json("searchform"),//关键之处
			columns: [[
						          { field: "id",title: "id", width: 200, hidden: true },
						          {field: "username",title: "客服用户",align: 'center',width: 260 }, 
						          {field: "contactinfo",title: "联系方式",align: 'center',width: 250 }, 
						          { field: "createtime",title: "客服时间",align: 'center',width: 250,
						        	   formatter: function(value){
						        		   if(value!=undefined&&value!=''){
						        			   return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
						        		   }
						        		   return value;
						        	   }
						           }, 
						           {field: "content",title: "客服问题",align: 'center',width: 400 },
						        {field: "sysLastReply",title: "操作", align: 'center',width: 200,
				                formatter: function(value ,row,index){
				                	var str="<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"+index+"' onclick='$.fn.suggestion.viewDetail(event)'>回复</a>" 
				                			/*    + "<a class='item-span  f-blue fl' data-index='"+index+"'  href='javascript:void(0);' onclick='$.fn.suggestion.reply(event);'>回复</a>"*/
				                	return  str; 
								}
			           	 	}
			           ]],
			           loadFilter: function(data){
			        	   if (data.success){
			        		   return data.obj;
			        	   } else {
			        		   $.messager.alert('系统提示','抱歉，出错了。','info');
			        	   }
			           }
			           //toolbar: $().suggestion.getToolBar()
		});
	};
	//直接在详情表单中提交回复
	$.fn.suggestion.submitReplyInDetailForm = function() {
		$("#detail_sta_form").form('submit',{
			url:$(this).suggestion.defaults._appPath+'/suggestion/sysReply',
			onSubmit:function(param){
				$("#detail_sta_form").form("enableValidation");
				if(!$("#detail_sta_form").form("validate")){
					return false;
				}
				param.topicid=$("#id").val();
				param.content=$("#replyInDetailContent").val();
				param.userid=0;
				param.username="系统管理员";
			},
			success:function(msg){
				var result = $.parseJSON(msg);
				if(result.success){
					$.messager.alert('系统提示','操作成功','info',function(){
						$("#detailsta_dialog").window("close");
						$("#detail_sta_form")[0].reset();
						$('#table').datagrid("reload");
					});
				}else{
					$.messager.alert('系统提示',result.msg,'info'); 
				}
			},
			error:function(){
				$.messager.alert('系统提示','抱歉，出错了。','info'); 
			}
		});
	};
	//回复表单提交
	$.fn.suggestion.submitReplyForm = function() {
		$("#detail_win_reply_form").form('submit',{
			url:$(this).suggestion.defaults._appPath+'/suggestion/sysReply',
			onSubmit:function(param){
				$("#detail_win_reply_form").form("enableValidation");
				if(!$("#detail_win_reply_form").form("validate")){
					return false;
				}
				param.topicid=$("#replyEntityId").val();
				//param.content=$("#systemContent").val();
				param.userid=0;
				param.username="系统管理员";
			},
			success:function(msg){
				var result = $.parseJSON(msg);
				if(result.success){
					$.messager.alert('系统提示','操作成功','info',function(){
						$("#win_reply_dialog").window("close");
						$("#detail_win_reply_form")[0].reset();
						$('#table').datagrid("reload");
					});
				}else{
					$.messager.alert('系统提示',result.msg,'info'); 
				}
			},
			error:function(){
				$.messager.alert('系统提示','抱歉，出错了。','info'); 
			}
		});
	};

	/**
	 * 初始化回复窗口
	 */
	$.fn.suggestion.initReplyDialog = function(){

		$("#win_reply_dialog").dialog({
			title:"建议反馈回复",
			modal:true,
			closed:true,
			/*buttons:[{
				id:"win_reply_dialog_save",
				text:"确定",
				handler:function(){
					$().suggestion.submitReplyForm();
				}
			},{ 
				id:"win_reply_dialog_cancel",
				text:"取消",
				handler:function(){
					$("#win_reply_dialog").window('close');
				}
			}]*/
		});
		//初始化完成，关闭窗口
		$("#win_reply_dialog").dialog("close");
	};
//回复btn	
	function suggestReplay(){
		$().suggestion.submitReplyForm();
	}
	/**
	 * 初始化详情窗口
	 */
	$.fn.suggestion.initDetailDialog = function(){
		$("#detailsta_dialog").dialog({
			title:"建议反馈",
			modal:true,
			closed:true,
			onOpen:function(){//打开窗口时，保存与取消按钮设置可用
			},
			onBeforeClose:function(){//窗口关闭事件
				$("#detail_sta_form")[0].reset();
			},
			onClose:function(){
				//$("#detailInfo").html("");
				$("#detail_sta_form")[0].reset();
			},
			onDestroy:function(){
				//$("#detailInfo").html("");
				$("#detail_sta_form").panel().destroy();
			},
			/*buttons:[{
				id:"suggestion_dialog_save",
				text:"回复",
				handler:function(){
					$().suggestion.submitReplyInDetailForm();
				}
			},{ 
				id:"suggestion_dialog_cancel",
				text:"取消",
				handler:function(){
					$("#detailsta_dialog").window('close');
				}
			}]*/
		});
		//初始化完成，关闭窗口
		$("#detailsta_dialog").dialog("close");
	};
//详情回复
function suggestDetial(){
	$().suggestion.submitReplyInDetailForm();
}

	//为查询按钮添加事件
	$.fn.suggestion.clickQueryButton = function() {
		$("#submit_search").click(function () {
			$('#dg').datagrid('load', {    
				username:$("#contactinfo").val(),    
				contactinfo: $("#content").val(), 
				starttime: $("#starttime").val(), 
				endtime: $("#endtime").val(),
				citycode:$("#qcityChoose").combobox("getValue"),
				
			});   //点击搜索
		});
	};
	//建议反馈回复
	$.fn.suggestion.reply = function() {
		   event.stopPropagation();
		   //获取当前行号
	       var index = $(event.target).attr('data-index');
	     	$("#dg").datagrid('selectRow',index);
	  	    //获取当前行数据
			 var rows = $("#dg").datagrid("getSelected");
			 //时间转化
			   rows.createtime=new Date( rows.createtime).Format("yyyy-MM-dd hh:mm:ss"); 
			$("#detail_win_reply_form").form('clear');
			$("#detail_win_reply_form").form("load",rows);//填充数据
			$("#systemContent").val("");
			$("#win_reply_dialog").removeClass("hide");
			$("#win_reply_dialog").window("open");
	};

	//建议反馈详细信息
	$.fn.suggestion.viewDetail = function(event) {
		
		event.stopPropagation();
		//获取当前行号
	    var index = $(event.target).attr('data-index');
		$("#dg").datagrid('selectRow',index);
		  //获取当前行数据
		   var rows = $("#dg").datagrid("getSelected");
		   //时间转化
		   rows.createtime=new Date( rows.createtime).Format("yyyy-MM-dd hh:mm:ss"); 
		   var form = $("#detail_sta_form")[0];
			$("#detail_sta_form").form('clear');
			$("#detailsta_dialog").form("load",rows);//填充数据
			$().suggestion.appendDetailInfo(rows.id);
			$("#detailInfo").html("");
			$("#detailsta_dialog").removeClass("hide");
			$("#detailsta_dialog").window("open");
	};

	//日期格式化，将毫秒格式的日期转化为yyyy-MM-dd hh:mm:ss
	$.fn.suggestion.dataFormat = function(createtime) {
		var formatTime = "";
		if(createtime!=undefined&&createtime!=''){
			formatTime = new Date(createtime).Format('yyyy-MM-dd hh:mm:ss');
		}
		return formatTime;
	};
	//添加图片展示
	$.fn.suggestion.appendDetailInfo = function(entityid){

		var url = $(this).suggestion.defaults._appPath+'/suggestion/getSuggestDetailById?entityid='+entityid;
		$.get(url,function(result) {
			var dataArr = result.obj;
			console.log(dataArr)
			dataArr.forEach(function(entity){  
				var username = entity.username;
				var createtime = $.fn.suggestion.dataFormat(entity.createtime);
				var content = entity.content;
				if(entity.userid == 0){
					username = "<span class='item-span'>"+username+"</span>";
					createtime = "<span class='item-span'>"+createtime+"</span>";
					content = "<span class='item-span'>"+content+"</span>";
				}
				var attachpaths = entity.attachpaths;

				var dataStr = 
					"<div class='item-row'>" +
					username+": "+createtime +
					"</div>" +
					"<div class='item-row'>"  +
					content +
					"</div>";

				var pictureStr = "";
				attachpaths.forEach(function(picturePath){
					pictureStr += '<img alt="图片测试" width="300px" height="180px"  src="'+picturePath+'">';
				})

				$("#detailInfo").append(dataStr+pictureStr);

			}) 
		}, "json");
	};
	//获取城市列表
	$('#qcityChoose').combobox({
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

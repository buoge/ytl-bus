/*  wxl   2016 12/26 
 * girdNoticeRecord
 */
$(function() {
	// 初始化initDatagridCustom表格
	initDatagridNoticeRecord();
	
});
var appName = $('#appName').val();
var rowpoints;
// 初始化initDatagridNewsManage funtion
function initDatagridNoticeRecord() {
	var height = setDatagirdTables();
	$('#girdNoticeRecord').datagrid({
		// title:'普通表单-用键盘操作',
		method : 'get',
        url : appName +'/notice/listByPage',
		toolbar : '#tb',
		align : 'center',
		singleSelect : true, // 单选 false多选
		rownumbers : true, // 序号
		pagination : true, // 分页
		fitColumns : true, // 占满
		showFooter : true,
		pageNumber : 1,
		pageSize : 20,
		height : height,
		width : '100%',
		columns : [ [
				{
					field : 'ck',
					checkbox : true
				},
				
				{
					field : "content",
					title : "内容",
					align : 'center',
					width : 150
				},
				{
					field : "importantGrade",
					title : "重要性",
					align : 'center',
					width : 80,
					formatter : function(value) {
						if (value == 1) {
							return '一般';
						} else if (value == 2) {
							return '较重要';
						} 
						else if (value == 3){
							return '非常重要 ';
						}
						else {
							return '空 ';
						}
					}
				},
				{
				field : "noticeRange",
				title : "通知范围",
				align : 'center',
				width : 80,
				formatter : function(value) {
					if (value == 1) {
						return '所有城市';
					} else if (value == 2) {
						return '全城';
					} else if(value == 3) {
						return '指定地点范围';
					}
					else if(value == 4){
						return '指定线路范围';
					}
					else {
						return ' 空';
					}
				}
			},
				{
					field : "publishTime",
					title : "发布时间",
					align : 'center',
					width : 80,
					formatter : function(value) {
						if (value != undefined && value != null
								&& value != '') {
							return new Date(value)
									.Format("yyyy-MM-dd hh:mm:ss");
						}
					}
				},
				{
					field : "process",
					title : "操作",
					width :30,
					align : 'center',
					formatter : function(value, row, index) {
						var str = "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
								+ index
								+ "' onclick='noticeRecordDeital(event);'>详情</a>"
								/*+ "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
								+ index
								+ "' onclick='noticeRecordEdit(event);'>编辑</a>"
								+ "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
								+ index
								+ "' onclick='noticeRecordDelete(event);'>删除</a>"*/
						return str;
					}
				} ] ],
		loadFilter : function(data) {
			if (data.success) {
				return data.obj;
			} else {
				$.messager.alert('系统提示', '抱歉，出错了。', 'info');
			}
		}
	});
}
// 查询事件
$(document).on('click', '#query', function() {
	$('#girdNoticeRecord').datagrid("load", {
		publishTimeStart : $("#qstartTime").val(),
		publishTimeEnd : $("#qendTime").val(),
		cityCode : $("#qcityChoose").combobox("getValue")
	});
});
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
// 新增信息动态创建dialog
function noticeRecordAdd() {
	var dialog = $('<div/>').dialog({
		href : appName + '/webviews/newsManage/noticeRecordAdd.jsp',
		width :590,
		height :610,
		modal : true,
		title : '新增信息',
		onClose : function() {
			$(this).dialog('destroy');
		},
		onLoad : function() {
			// 传对应dialog对象和按钮id
			dialogCallback($(this));
			
		}
	});
}
// 详细信息动态创建dialog
function noticeRecordDeital(event) {
	var index = $(event.target).attr('data-index');
	$("#girdNoticeRecord").datagrid('selectRow', index);
	var rows = $('#girdNoticeRecord').datagrid('getSelected');
	var height=setNotcieHeight();
	// 让城市下拉框能选中城市
	var dialog = $('<div/>').dialog({
		href : appName + '/webviews/newsManage/noticeRecordDetail.jsp',
		width : 590,
		height :height,
		modal : true,
		title : '详细信息',
		onClose : function() {
			$(this).dialog('destroy');
		},
		onLoad:function() {
			// 传对应dialog对象和按钮id
			$("#noticeRecordDetailForm").form("load", rows);// 填充数据
			publicDisabled('noticeRecordDetailForm');
			//publicDisabledunBox('noticeRecordDetailForm','anoticeRange');
			rowpoints=rows.noticePoints;
			dialogCallback($(this));
		}
	});

}
//动态设置 noticeRecordDeital 的高度
function setNotcieHeight(){
	var setHeight;
	var index = $(event.target).attr('data-index');
	$("#girdNoticeRecord").datagrid('selectRow', index);
	var rows = $('#girdNoticeRecord').datagrid('getSelected');
	var noticeRange=rows.noticeRange;
	if(noticeRange==3){
		setHeight=580;
	  }
	else if(noticeRange==1||noticeRange==2){
		setHeight=240;
	 }
	else if(noticeRange==4){
		setHeight=280;
	}
	return setHeight;
}
//// 编辑信息动态创建dialog
function noticeRecordEdit(event) {
	var index = $(event.target).attr('data-index');
	$("#girdNoticeRecord").datagrid('selectRow', index);
	var rows = $('#girdNoticeRecord').datagrid('getSelected');
	var height=setNotcieHeight();
	// 让城市下拉框能选中城市
	var dialog = $('<div/>').dialog({
		href : appName + '/webviews/newsManage/noticeRecordEdit.jsp',
		width : 590,
		height :height,
		modal : true,
		title : '详细信息',
		onClose : function() {
			$(this).dialog('destroy');
		},
		onLoad : function() {
			
			// 传对应dialog对象和按钮id
			$("#noticeRecordEditForm").form("load", rows);// 填充数据
			
			dialogCallback($(this));
			
		}
	});

}
//// 删除信息动态confirm一行
function noticeRecordDelete(event) {
	var index = $(event.target).attr('data-index');
	$("#girdNoticeRecord").datagrid('selectRow', index);
	var delrows = $('#girdNoticeRecord').datagrid('getSelected');
	if (delrows) {
		$.messager.confirm('询问', '<div class="messager-tip">您确定要删除【'
				+ delrows.content + '】？</div>', function(data) {
			if (data) {
				$.ajax({
					url : appName + '/notice/delete/' + delrows.id,
					cache : false,
					type : 'delete',
					dataType : 'JSON',
					success : function(r) {
						if (r.success) {
							$.messager.alert('系统提示', r.msg, 'info');
							$('#girdNoticeRecord').datagrid('reload');
						}
					}
				});
			}
		});
	}
}
//通知记录配置编辑页面表单提交
function commitNoticeRecordEdit(event){
	var eid_val=$("#eid").val();
	var acontent_val=$("#acontent").val();
	var anoticeRange_val=$('#anoticeRange').combobox('getValue');
	var aimportantGrade_val=$('#aimportantGrade').combobox('getValue');
	var arange_val=$('#arange').combobox('getValue');
	var LinesName_val=$('#LinesName').val();
	
	var params={
		id:eid_val,
		content:acontent_val,
		noticeRange:anoticeRange_val,
		importantGrade:aimportantGrade_val,
		distanceRange:arange_val,
		routeStr:LinesName_val,
	    noticePoints:noticePointsArr,
	}
	$.ajax({
		url : appName+'/notice/update',
		cache : false,
		type : 'post',
		data:JSON.stringify(params),
		contentType: "application/json; charset=utf-8",
		dataType : 'json',
		success : function(result) {
			if (result.success) {
				$.messager.alert('系统提示',result.msg,'info',function(){
					  publicClose();
				});
				$('#girdNoticeRecord').datagrid('reload');
			}else{
				$.messager.alert('系统提示',result.msg,'info'); 
			}
		}
	})
	
	
}

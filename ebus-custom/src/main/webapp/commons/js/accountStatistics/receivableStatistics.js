/*  wxl   2017 4/27
 * girdReceivableStatistics
 */
$(function() {
	// 初始化initDatagridCustom表格
	initDatagridReceivableStatistics();
	//自定义时间
	$('#chooseDate').combobox({
		 onSelect: function(){ 
			  var val=$('#chooseDate').combobox('getValue');
			  console.log(val);
			  if(val==5){
				  $(".setDate").show();
			  }
			  else{
				  $(".setDate").hide();
			  }
		 }	
	})
});
var appName = $('#appName').val();
// 初始化initDatagridReceivableStatistics funtion
function initDatagridReceivableStatistics() {
	  var height=setDatagirdTable();
	$('#girdReceivableStatistics')
			.datagrid(
					{
						// title:'普通表单-用键盘操作',
						method : 'post',
						url : appName + '/webapp/busNewsByPage',
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
									field : "title",
									title : "标题",
									align : 'center',
									width : 150
								},
								{
									field : "newsCategory",
									title : "类型",
									align : 'center',
									width : 80,
									formatter : function(value) {
										if (value == 1) {
											return '公交动态';
										} else {
											return '';
										}
									}
								},
								{
									field : "createtime",
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
									field : "type",
									title : "排版类型",
									align : 'center',
									width : 80,
									formatter : function(value) {
										if (value == 1) {
											return '大标题';
										} else if (value == 2) {
											return '小标题';
										} else {
											return '';
										}
									}
								},
								{
									field : "peopleViews",
									title : "阅读情况",
									align : 'center',
									width : 80
								},
								{
									field : "cityName",
									title : "所属城市",
									align : 'center',
									width : 80,
									formatter : function(value, row) {
										if (row.cityCode == -1) {
											return '所有城市';
										}
										return value + "(" + row.cityCode + ")";
									}
								},
								{
									field : "process",
									title : "操作",
									width : 100,
									align : 'center',
									formatter : function(value, row, index) {
										var str = "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
												+ index
												+ "' onclick='drivingDecordsDeital(event);'>详情</a>"
												+ "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
												+ index
												+ "' onclick='drivingDecordsLink(event);'>联系</a>"
												+ "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
												+ index
												+ "' onclick='newsManageDelete(event);'>删除</a>"
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
	$('#girdReceivableStatistics').datagrid("load", {
		type : $("#qtype").combobox("getValue"),
		title : $("#qtitle").val(),
		newsCategory : $("#qnewsCategory").combobox("getValue"),
		startTime : $("#qstartTime").val(),
		endTime : $("#qendTime").val(),
		cityCode : $("#qcityChoose").combobox("getValue")
	});
});

// 新增信息动态创建dialog
/*
 * @param type资源类型0 代表内部 1代表外部
 * 
 */
function drivingDecordsAdd() {
	var dialog = $('<div/>').dialog({
		href : appName + '/webviews/drivingDecords/drivingDecordsAdd.jsp',
		width : 580,
		height :570,
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

// 编辑信息动态创建dialog
function drivingDecordsDeital(event) {
	var index = $(event.target).attr('data-index');
	$("#girdReceivableStatistics").datagrid('selectRow', index);
	var rows = $('#girdReceivableStatistics').datagrid('getSelected');
	// 让城市下拉框能选中城市
		var dialog = $('<div/>').dialog({
			href : appName + '/webviews/drivingDecords/drivingDecordsDetial.jsp',
			width : 580,
			height : 570,
			modal : true,
			title : '详细信息',
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				// 传对应dialog对象和按钮id
				$("#newsManageDetailForm").form("load", rows);// 填充数据
				publicDisabled('newsManageDetailForm');
				dialogCallback($(this));
			}
		});
	
}

// 编辑信息动态创建dialog
function drivingDecordsLink(event) {
	var index = $(event.target).attr('data-index');
	$("#girdReceivableStatistics").datagrid('selectRow', index);
	var rows = $('#girdReceivableStatistics').datagrid('getSelected');
		var dialog = $('<div/>').dialog({
			href : appName + '/webviews/drivingDecords/drivingDecordsLink.jsp',
			width : 580,
			height :570,
			modal : true,
			title : '编辑信息',
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				// 传对应dialog对象和按钮id
				$("#newsManageEditForm").form("load", rows);// 填充数据
				dialogCallback($(this));
			}
		});
}

// 删除信息动态confirm一行
function newsManageDelete(event) {
	var index = $(event.target).attr('data-index');
	$("#girdReceivableStatistics").datagrid('selectRow', index);
	var delrows = $('#girdReceivableStatistics').datagrid('getSelected');
	if (delrows) {
		$.messager.confirm('询问', '<div class="messager-tip">您确定要删除【'
				+ delrows.title + '】？</div>', function(data) {
			if (data) {
				$.ajax({
					url : appName + '/webapp/deleteNews/' + delrows.id,
					cache : false,
					type : 'delete',
					dataType : 'JSON',
					success : function(r) {
						if (r.success) {
							$.messager.alert('系统提示', r.msg, 'info');
							$('#girdReceivableStatistics').datagrid('reload');
						}
					}
				});
			}
		});
	}
}

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

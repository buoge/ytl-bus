/*  wxl   2017 4/27
 * girdDrivingPublish
 */
$(function() {
	// 初始化initDatagridCustom表格
	initDatagridDrivingPublish();

});
var appName = $('#appName').val();
// 初始化initDatagridDrivingPublish funtion
function initDatagridDrivingPublish() {
	  var height=setDatagirdTable();
	$('#girdDrivingPublish').datagrid({
						method : 'get',
						url : appName +'/driver/school/list',
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
								{ field: "ck",title: "当前", width: 50,checkbox : true, },
								{ field: "citycode",title: "城市",align: 'center',width: 50},
								{field: "acceptLicenseTypeDesc", title: "驾照类型",align: 'left',width: 50},
								{field: "acceptLicense", title: "驾照类型值",align: 'left',width: 50,hidden:true},
								{ field: "location",title: "地址",align: 'center',width: 50},
								{ field: "name",title: "驾校名称",align: 'center', width: 50 }, 
								{field: "tel",title: "手机号码",align: 'center',width: 50 }, 
								{field : "process",title : "操作",width :40,align : 'center',
									formatter : function(value, row, index) {
										var str = "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
												+ index
												+ "' onclick='drivingPublishDeital(event);'>详情</a>"
												+ "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
												+ index
												+ "' onclick='drivingPublishEdit(event);'>编辑</a>"		
										return str;
									}
								} ] ],
						loadFilter : function(data) {
							if (data.success) {
								console.log(data)
								return data.obj;
							} else {
								$.messager.alert('系统提示', '抱歉，出错了。', 'info');
							}
						}
	});
}

// 查询事件
$(document).on('click', '#query', function() {
	$('#girdDrivingPublish').datagrid("load", {
		cityCode : $("#qcityChoose").combobox("getValue"),
		licenseType : $("#drivingType").combobox("getValue"),
		name : $("#drivingName").val(),
		status :   $('#drivingStatus').val(),
	 	tel : $("#drivingTelephone").val(),
	});
});

// 新增信息动态创建dialog
/*
 * @param type资源类型0 代表内部 1代表外部
 * 
 */
function drivingPublishAdd() {
	var dialog = $('<div/>').dialog({
		href : appName + '/webviews/drivingDecords/drivingPublishAdd.jsp',
		width : 840,
		height :690,
		modal : true,
		title : '新增信息',
		onClose : function() {
			$(this).dialog('destroy');
			deleteEditor();
		},
		onLoad : function() {
			// 传对应dialog对象和按钮id
			dialogCallback($(this));
			createEditor(1);
		}
	});
}

// 编辑信息动态创建dialog
function drivingPublishDeital(event) {
	var index = $(event.target).attr('data-index');
	$("#girdDrivingPublish").datagrid('selectRow', index);
	var rows = $('#girdDrivingPublish').datagrid('getSelected');
	// 让城市下拉框能选中城市
		var dialog = $('<div/>').dialog({
			href : appName + '/webviews/drivingDecords/drivingPublishDetial.jsp',
			width : 805,
			height :690,
			modal : true,
			title : '详细信息',
			onClose : function() {
				$(this).dialog('destroy');
				deleteEditor();
			},
			onLoad : function() {
				// 传对应dialog对象和按钮id
				$("#detialPublishForm").form("load", rows);// 填充数据
				publicDisabled('detialPublishForm');
				dialogCallback($(this));
				createEditor(2);
			}
		});
	
}

// 编辑信息动态创建dialog
function drivingPublishEdit(event) {
	var index = $(event.target).attr('data-index');
	$("#girdDrivingPublish").datagrid('selectRow', index);
	var rows = $('#girdDrivingPublish').datagrid('getSelected');
		var dialog = $('<div/>').dialog({
			href : appName + '/webviews/drivingDecords/drivingPublishEdit.jsp',
			width : 805,
			height :690,
			modal : true,
			title : '编辑信息',
			onClose : function() {
				$(this).dialog('destroy');
				deleteEditor();
			},
			onLoad : function() {
				// 传对应dialog对象和按钮id
				$("#editPublishForm").form("load", rows);// 填充数据
				dialogCallback($(this));
				createEditor(3);
			}
		});
}


//获取所有城市
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

//获取驾照类型
$('#drivingType').combobox({
	url : appName + '/driver/school/licenseTypes',
	method:'get',
	valueField : 'value',
	textField : 'desc',
	loadFilter : function(data) {
		if (data.success) {
			data.obj[0].selected = true;
			return data.obj;
		} else {
			$.messager.alert('系统提示', '抱歉，出错了。', 'info');
		}
	}
});


//编辑器的创建方法
function createEditor(type) {
	// 编辑器初始化
	var editor = new wangEditor('editor-trigger');
	// 上传图片
	editor.config.uploadImgUrl = appName + '/busnews/editorImage';
	// 将上传的图片的名字改成fileName
	editor.config.uploadImgFileName = 'fileName';
	// 普通的自定义菜单
	editor.config.menus = $.map(wangEditor.config.menus, function(item, key) {
		if (item === 'location') {
			return null;
		}
		return item;
	});
	editor.create();
	// 获取编辑区域的html
	if (type == 1) {// add 
		editor.$txt.html("");
		// 配置 onchange 事件
		editor.onchange = function() {
			var html = this.$txt.html();
			$('#introduction').val(html);
		}
	} else if (type == 2) {// detail
		var rows = $('#girdDrivingPublish').datagrid('getSelected');
		$.ajax({
			url : appName + '/driver/school/get/{id}',
			cache : false,
			data : 'id=' + rows.id,
			type : 'post',
			dataType : 'JSON',
			success : function(r) {
				if (r.success) {
					editor.$txt.html(r.obj);
					// 禁用
					editor.disable();
				} else {
					$.messager.alert('系统提示', '抱歉，出错了。', 'info');
				}
			}
		});

	} else if (type == 3) {// edit
		var rows = $('#girdDrivingPublish').datagrid('getSelected');
		$.ajax({
			url : appName + '/webapp/newsContent/',
			cache : false,
			data : 'id=' + rows.id,
			type : 'post',
			dataType : 'JSON',
			success : function(r) {
				if (r.success) {
					editor.$txt.html(r.obj);
					$('#editContent').val(r.obj);
					editor.onchange = function() {
						var htmltext = this.$txt.html();
						$('#editContent').val(htmltext);
					}
				} else {
					$.messager.alert('系统提示', '抱歉，出错了。', 'info');
				}
			}
		});
	}

}
//编辑器的销毁方法
function deleteEditor() {
	var editor = new wangEditor('editor-trigger');
	editor.undestroy();
}
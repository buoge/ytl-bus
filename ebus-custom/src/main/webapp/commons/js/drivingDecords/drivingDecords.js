/*  wxl   2017 4/27
 * girdDrivingDecords
 */
$(function() {
	// 初始化initDatagridCustom表格
	initDatagridDrivingDecords();
   //单选
	 //状态赋值
	var valStatus="";
	$('.item-check ').on('click',function(){

		  valStatus+= $(this).val()+',';
		console.log(valStatus);
         $('#drivingStatus').val(valStatus.substring(0,valStatus.length-1));
	});
});
var appName = $('#appName').val();
// 初始化initDatagridDrivingDecords funtion
function initDatagridDrivingDecords() {
	  var height=setDatagirdTables();
	$('#girdDrivingDecords').datagrid({
						method : 'get',
						url : appName +'/driver/school/signUp/list',
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
								{field: "licenseType", title: "驾照类型",align: 'left',width: 50,
									 formatter:function(value) {
						        			if(value) {
						        				if(value==1){
						        					value="A1"
						        				}
						        				else if(value==2){
						        					value="A2"
						        				}
						        				else if(value==3){
						        					value="A3 "
						        				}
						        				else if(value==4){
						        					value="B1 "
						        				}
						        				else if(value==5){
						        					value="B2 "
						        				}
						        				else if(value==6){
						        					value="C1 "
						        				}
						        				else if(value==7){
						        					value="C2 "
						        				}
						        				return value;
						        			}
						          	  }
								},
								{ field: "name",title: "姓名",align: 'center',width: 50},
								{ field: "sex",title: "性别",align: 'center', width: 50 }, 
								{ field: "age",title: "年龄",align: 'center',width:50},
								{field: "tel",title: "手机号码",align: 'center',width: 50 }, 
								{field: "signupTime",title: "报名时间",align: 'center',width: 80,
									formatter:function(value) {
						      			if(value != undefined&&value!=null&&value != '') {
						      				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
						      			}
						         }
								},
								{ field: "lastContactTime",title: "最后一次联系时间",align: 'center',width: 80,
									formatter:function(value) {
							      			if(value != undefined&&value!=null&&value != '') {
							      				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
							      			}
							         }
								},
								{ field: "status",title: "状态",align: 'center',width: 50,
									 formatter:function(value) {
						        			if(value) {
						        				if(value==1){
						        					value="待联系"
						        				}
						        				else if(value==2){
						        					value="下次联系"
						        				}
						        				else if(value==3){
						        					value="已报名 "
						        				}
						        				return value;
						        			}
						          	  }
								},
								{field : "process",title : "操作",width : 50,align : 'center',
									formatter : function(value, row, index) {
										var str = "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
												+ index
												+ "' onclick='drivingDecordsDeital(event);'>详情</a>"
												+ "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
												+ index
												+ "' onclick='drivingDecordsLink(event);'>联系</a>"
										
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
	$('#girdDrivingDecords').datagrid("load", {
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
function drivingDecordsAdd() {
	var dialog = $('<div/>').dialog({
		href : appName + '/webviews/drivingDecords/drivingDecordsAdd.jsp',
		width : 570,
		height :540,
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
	$("#girdDrivingDecords").datagrid('selectRow', index);
	var rows = $('#girdDrivingDecords').datagrid('getSelected');
	console.log(rows);
	// 让城市下拉框能选中城市
		var dialog = $('<div/>').dialog({
			href : appName + '/webviews/drivingDecords/drivingDecordsDetial.jsp',
			width : 570,
			height : 540,
			modal : true,
			title : '详细信息',
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				// 传对应dialog对象和按钮id
				$("#detialDrivingForm").form("load", rows);// 填充数据
				publicDisabled('detialDrivingForm');
				dialogCallback($(this));
			}
		});
	
}

// 编辑信息动态创建dialog
function drivingDecordsLink(event) {
	var index = $(event.target).attr('data-index');
	$("#girdDrivingDecords").datagrid('selectRow', index);
	var rows = $('#girdDrivingDecords').datagrid('getSelected');
	console.log(rows);
		var dialog = $('<div/>').dialog({
			href : appName + '/webviews/drivingDecords/drivingDecordsLink.jsp',
			width : 570,
			height :540,
			modal : true,
			title : '联系信息',
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				// 传对应dialog对象和按钮id
				$("#linkDrivingForm").form("load", rows);// 填充数据
				var bmTime=new Date(rows.signupTime).Format("yyyy-MM-dd hh:mm:ss")
				$('#bmTime').val(bmTime)
				//获取联系记录
				getContactRecord(rows.id);
				$('#signupId').val(rows.id);
				dialogCallback($(this));
			}
		});
}


function getContactRecord(signupId){
		$.ajax({
			url : appName+'/driver/school/signUp/contact/get/'+signupId,
			cache : false,
			//dataType : 'JSON',
			type:'get',
			success : function(result) {
				console.log(result);
				var result = $.parseJSON(result);
				if (result&&result.success) {
					result.obj
				}
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


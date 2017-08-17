/*  wxl   2016 12/20 
 * bookbus
 */
$(function(){
	//初始化initDatagridCustom表格
	initDatagridBusBook();
});
var appName=$('#appName').val();
//初始化initDatagridBusBook funtion
function initDatagridBusBook(){
	  var height=setDatagirdTable();
	$('#girdBusBook').datagrid({
	    //title:'普通表单-用键盘操作',
        method:'post',
	  url:appName+'/webapp/bookbuslist',
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
          {field:'ck',checkbox:true},
          {field:'orderNo',title:'订单号',width:240,align:'center'},
          {field:'contactphone',title:'联系电话',width:150,align:'center',editor:'textbox'},
          {field:'sourcelocation',title:'出发地',width:180,align:'center'},
          {field:'targetlocation',title:'目的地',width:180,align:'center'},
          {field:'bookbustype',title:'包车类型',width:100,align:'center',
        	  formatter: function(value){
					if(value==1) {
						return '单程包车';
					}else if(value == 2) {
						return '往返包车';
					}else if(value == 3) {
						return '包天包车';
					}
				}
          },
          {field:'starttime',title:'出发时间',width:180,align:'center',
        	  formatter:function(value) {
      			if(value != undefined&&value!=null&&value != '') {
      				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
      			}
        	  }
          },
          {field:'backtime',title:'结束时间',width:180,align:'center',
        	  formatter:function(value) {
      			if(value != undefined&&value!=null&&value != '') {
      				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
      			}
        	  }
          },
          {field:'passengernum',title:'乘车人数',width:80,align:'center'},
          {field:'quotedprice',title:'金额（元）',width:80,align:'center'},
          {field:'status',title:'状态',width:80,align:'center',
        	  formatter: function(value){
					if(value==0) {
						return '待报价';
					}else if(value == 1) {
						return '待付款';
					}else if(value == 2) {
						return '待派车';
					}else if(value == 3) {
						return '已取消';
					}else if(value == 4) {
						return '已完成';
					}else if(value == 5) {
						return '退款申请中';
					}else if(value == 6) {
						return '已退款';
					}
				}
          },
          {field:'quotedtime',title:'报价时间',width:180,align:'center',
        	  formatter:function(value) {
        			if(value != undefined&&value!=null&&value != '') {
        				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
        			}
          	  }
          },
          {field:'orderTime',title:'申请时间',width:180,align:'center',
        	  formatter:function(value) {
        			if(value != undefined&&value!=null&&value != '') {
        				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
        			}
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
	});
}
//查询事件
$(document).on('click','#query',function(){
		$('#girdBusBook').datagrid("load",{
			orderNo:$("#orderNo").val(),
			contactPhone:$("#contactPhone").val(),
			bookBusType:$("#bookBusType").combobox('getValue'),
			status:$("#status").combobox('getValue')
		});
});
//
$(document).on('click','#ubtn',function(){
		$("#updateForm").form('submit',{
				url:appName+'/webapp/quote',
				onSubmit:function(param){
					$("#updateForm").form("enableValidation");
					if(!$("#updateForm").form("validate")){
						return false;
					}
					var quotedPrice = $("#quotedPrice").val();
					if(quotedPrice <= 0) {
						$.messager.alert('系统提示','报价必须大于0','info'); 
						return false;
					}
					if(quotedPrice.indexOf('.')>0 && quotedPrice.split('.')[1].length > 2) {
						$.messager.alert('系统提示','报价金额最多只能保留两位小数','info'); 
						return false;
					}
					
			},
			success:function(msg){
				var result = $.parseJSON(msg);
				if(result.success){
					$.messager.alert('系统提示','报价成功','info',function(){
						$("#updateWin").window("close");
						$("#updateForm")[0].reset();
						$('#girdBusBook').datagrid("reload");
					});
				}else{
					$.messager.alert('系统提示',result.msg,'info'); 
				}
			},
			error:function(){
				$.messager.alert('系统提示','抱歉，出错了。','info'); 
			}
	});
});
//详情window
function detailInfo(){
	var array = $("#girdBusBook").datagrid("getChecked");
	if(array.length<=0){
		$.messager.alert('系统提示','请选择要查看的记录！','info');
	}else if(array.length>=2){
		$.messager.alert('系统提示','只能选择一个记录！','info');
	}else{
		$('#dcontact').val(array[0].contactname);
			$('#dcontactphone').val(array[0].contactphone);
			$('#dcount').val(array[0].passengernum);
			$('#dmoney').val(array[0].quotedprice);
			$('#dstart').val(array[0].sourcelocation);
			$('#dend').val(array[0].targetlocation);
			$('#dstarttime').val(array[0].starttime);
			$('#dendtime').val(array[0].backtime);
			$('#dremark').val(array[0].remark);
			$('#dapply').val(array[0].userName);
			$('#dapplytime').val((array[0].createtime == undefined ||array[0].createtime == '')?
					array[0].createtime:new Date(array[0].createtime).Format("yyyy-MM-dd hh:mm:ss"));
			$('#dquoter').val(array[0].quotedname);
			$('#dquotetime').val(
				(array[0].quotedtime == undefined ||array[0].quotedtime == '')?
						array[0].quotedtime:
							new Date(array[0].quotedtime).Format("yyyy-MM-dd hh:mm:ss"));
			$('#dpay').val(array[0].payPerson);
			$('#dpaytime').val(array[0].payTime);		
			$("#detailWin").removeClass("hide");
		    $("#detailWin").window("open");
	}
}	
//报价window

function updateInfo(){
	var array = $("#girdBusBook").datagrid("getChecked");
	if(array.length<=0){
		$.messager.alert('系统提示','请选择要修改的记录！','info');
	}else if(array.length>=2){
		$.messager.alert('系统提示','只能选择一个记录！','info');
	}else if(array[0].status != 0){
		$.messager.alert('系统提示','只有待报价的订单才能被报价！','info');
	}else{
		$('#goodsId').val(array[0].goodsid);
		$('#uorderNo').val(array[0].orderNo);
		$("#updateWin").removeClass("hide");
		$("#updateWin").window("open");
	}
}
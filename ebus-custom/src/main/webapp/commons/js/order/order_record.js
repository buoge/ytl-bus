/*  wxl   2016 12/20 
 * OrderRecord
 */
$(function(){
	//初始化initDatagridOrderRecord表格
	initDatagridOrderRecord();
});
var appName=$('#appName').val();
//初始化initDatagridOrderRecord funtion
function initDatagridOrderRecord(){
	  var height=setDatagirdTable();
	$('#girdOrderRecord').datagrid({
	    //title:'普通表单-用键盘操作',
        method:'post',
	  url:appName+'/webapp/orderlist',
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
	        	{field:'sourcelocation',title:'上车站',width:180,align:'center'},    
	        	{field:'targetlocation',title:'下车站',width:180,align:'center'},
	        	{field:'contactphone',title:'联系方式',width:150,align:'center'},    
	        	{field:'userName',title:'购票人',width:80,align:'center'},    
		        {field:'orderTime',title:'下单时间',width:180,align:'center',
	        		formatter:function(value) {
	        			if(value != undefined&&value!=null&&value != '') {
	        				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
	        			}
	        		
	        		}},    
		        {field:'starttime',title:'乘车时间',width:180,align:'center',
	        			  formatter:function(value) {
	              			if(value != undefined&&value!=null&&value != '') {
	              				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
	              			}
	                	  }
		        },    
		        {field:'quotedprice',title:'金额（元）',width:80,align:'center'},
		        {field:'payType',title:'支付方式',width:80,align:'center',
		        	formatter: function(value){
		        		if(value == 1) {
		        			return '支付宝';
		        		}else if(value == 2) {
		        			return '微信';
		        		}else if(value == 4) {
		        			return '钱包';
		        		}else {
		        			return '';
		        		}
					}
		        }, 
		        {field:'orderStatus',title:'状态',width:100,align:'center',
					formatter: function(value){
		        		if(value == 0) {
		        			return '未支付';
		        		}else if(value == 1) {
		        			return '已支付';
		        		}else if(value == 2) {
		        			return '已取消';
		        		}else if(value == 3) {
		        			return '订单失效';
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
//查询window
$(document).on('click','#query',function(){
		$('#girdOrderRecord').datagrid("load",{
			orderNo:$("#orderNo").val(),
			contactPhone:$("#contactPhone").val(),
			orderStatus:$("#orderStatus").combobox('getValue'),
			type:$("#orderType").combobox('getValue')
		});
	});

$(document).on('click','#ubtn',function(){
		$("#updateForm").form('submit',{
				url:appName+'/webapp/apply_refund',
			onSubmit:function(param){
				$("#updateForm").form("enableValidation");
				if(!$("#updateForm").form("validate")){
					return false;
				}
				param.type = $("#orderType").combobox('getValue');
			},
			success:function(msg){
				var result = $.parseJSON(msg);
				if(result.success){
					$.messager.alert('系统提示','退款申请成功','info',function(){
						$("#refundWin").window("close");
						$("#updateForm")[0].reset();
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
});
//详情window
function detailInfo(){
	var array = $("#girdOrderRecord").datagrid("getChecked");
	if(array.length<=0){
		$.messager.alert('系统提示','请选择要查看的订单！','info');
	}else if(array.length>=2){
		$.messager.alert('系统提示','只能选择一个记录！','info');
	}else{
		$('#dorderno').val(array[0].orderNo);
			$('#dinstation').val(array[0].sourcelocation);
			$('#doffstation').val(array[0].targetlocation);
			var value = array[0].orderTime;
			if(value != undefined&&value!=null&&value != '') {
			value = new Date(value).Format("yyyy-MM-dd hh:mm:ss");
		}
			$('#dordertime').val(value);

			$('#dridetime').val(array[0].starttime);
			$('#dmoney').val(array[0].quotedprice);
			if(array[0].payType == 1) {
				$('#dpaytype').val("支付宝");
			}else if(array[0].payType == 2) {
				$('#dpaytype').val("微信");
			}else if(array[0].payType == 4) {
				$('#dpaytype').val("钱包");
			}else {
				$('#dpaytype').val("");
			}
			if(array[0].orderStatus==0){
				$('#dstatus').val('未支付');
			}else if(array[0].orderStatus==1) {
				$('#dstatus').val('已支付');
			}else if(array[0].orderStatus==2) {
				$('#dstatus').val('已取消');
			}else if(array[0].orderStatus==3) {
				$('#dstatus').val('订单失效');
			}else {
				$('#dstatus').val('');
			}
			$('#dpaymoney').val(array[0].orderPrice);
			$('#dbuyperson').val(array[0].userName);
			$('#dcontactphone').val(array[0].contactphone);
			$("#detailWin").removeClass("hide");
		    $("#detailWin").window("open");
	}
}	
//退款详情window
function updateInfo(){
	var array = $("#girdOrderRecord").datagrid("getChecked");
	if(array.length<=0){
		$.messager.alert('系统提示','请选择要退款的订单！','info');
	}else if(array.length>=2){
		$.messager.alert('系统提示','只能选择一个记录！','info');
	}else if(array[0].orderStatus != 1){
		$.messager.alert('系统提示','只有已支付的订单才能被退款！','info');
	}else{
		$('#rgoodsId').val(array[0].goodsid);
		$('#rorderNo').val(array[0].orderNo);
		$('#rorderDetailId').val(array[0].orderDetailId);
		$('#rorderno2').val(array[0].orderNo);
			$('#rinstation').val(array[0].sourcelocation);
			$('#roffstation').val(array[0].targetlocation);
			var value = array[0].orderTime;
			if(value != undefined&&value!=null&&value != '') {
			value = new Date(value).Format("yyyy-MM-dd hh:mm:ss");
		}
			$('#rordertime').val(value);
			$('#rridetime').val(array[0].starttime);
			$('#rmoney').val(array[0].quotedprice);
			if(array[0].payType == 1) {
				$('#rpaytype').val("支付宝");
			}else if(array[0].payType == 2) {
				$('#rpaytype').val("微信");
			}else if(array[0].payType == 4) {
				$('#rpaytype').val("钱包");
			}else {
				$('#rpaytype').val("");
			}
			if(array[0].orderStatus==0){
				$('#rstatus').val('未支付');
			}else if(array[0].orderStatus==1) {
				$('#rstatus').val('已支付');
			}else if(array[0].orderStatus==2) {
				$('#rstatus').val('已取消');
			}else if(array[0].orderStatus==3) {
				$('#rstatus').val('订单失效');
			}else {
				$('#rstatus').val('');
			}
			$('#rpaymoney').val(array[0].orderPrice);
			$('#rbuyperson').val(array[0].userName);
			$('#rcontactphone').val(array[0].contactphone);
			$("#refundWin").removeClass("hide");
		    $("#refundWin").window("open");
	}
}
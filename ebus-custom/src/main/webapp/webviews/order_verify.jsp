<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		 <!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
		<title>订单审核</title>
	</head>
	<body>
	 <!-- item-header -->
	   	<div id="tb" class="item-header">
			<a href="javascript:void(0);"  class="item-span  f-blue fl"   onclick="javascript:detailInfo();">详情</a>
			<a href="javascript:void(0);"  class="item-span  f-blue fl"  onclick="javascript:updateInfo();">退款申请审核</a>
			<span class="item-span  fl">订单类型：</span>
			<span class="item-select fl">
				<select id="orderType" class="easyui-combobox" name="orderType" style="width:100px;">  
					<option value="1">专车</option>   
					<option value="2">定制公交</option>   
				</select> 
			 </span>
			<span class="item-span  fl">订单号：</span>
			<input type="text"  class="item-input  fl"  id='orderNo' size="15"/>
			<span class="item-span  fl">联系方式：</span>
			<input type="text"  class="item-input  fl"  id='contactPhone' size="15"/>
			<span class="item-span  fl">订单状态：</span>
			<span class="item-select fl">
			<select id="orderStatus" class="easyui-combobox" name="orderStatus" style="width:100px;">  
					    <option value="-1">--请选择--</option>   
					    <option value="4">退款申请中</option>   
					    <option value="5">已退款</option>   
					 </select>
			</span>
			<a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
		</div>
		<!-- girdOrderVerify -->
		<div class="item-content" >
		   <table id ="girdOrderVerify"></table>
		</div>
		<div id="detailWin" class="easyui-window" align="center" title="查看详情" style="width:850px;height:380px" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:true">
			<br>
			<table class="item-table">
				<tr>
					<td><span class="item-span">订单号：</span></td>
					<td><input type='text'  class="item-input fl"  id='dorderno' disabled='disabled'/></td>
					<td><span class="item-span">上车站：</span></td>
					<td><input type='text'  class="item-input fl" id='dinstation' disabled='disabled'/></td>
					<td><span class="item-span">下车站：</span></td>
					<td><input type='text'  class="item-input fl"  id='doffstation' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">下单时间：</span></td>
					<td><input type='text'  class="item-input fl" id='dordertime' disabled='disabled'/></td>
					<td><span class="item-span">乘车时间：</span></td>
					<td><input type='text' class="item-input fl"  id='dridetime' disabled='disabled'/></td>
					<td colspan='2'> </td>
				</tr> 
				<tr>
					<td><span class="item-span">金额：</span></td>
					<td><input type='text'  class="item-input fl"  id='dmoney' disabled='disabled'/></td>
					<td ><span class="item-span">支付方式：</span></td>
					<td><input type='text'  class="item-input fl"  id='dpaytype' disabled='disabled'/></td>
					<td><span class="item-span">状态：</span></td>
					<td><input type='text'  class="item-input fl"  id='dstatus' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">实付金额：</span></td>
					<td><input type='text'  class="item-input fl"  id='dpaymoney' disabled='disabled'/></td>
					<td><span class="item-span">购票人：</span></td>
					<td><input type='text'  class="item-input fl" id='dbuyperson' disabled='disabled'/></td>
					<td><span class="item-span">联系方式：</span></td>
					<td><input type='text'  class="item-input fl"  id='dcontactphone' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">退款备注：</span></td>
					<td colspan='5'>
						<div class="item-inputmark" ><textarea type='text'  id='dremark' name="remark" disabled='disabled'/></textarea></div>
					</td>
				</tr>
			</table> 
			<br>
		</div>
		
		<div id="refundWin" align="center" class="easyui-window" title="退款申请审核" style="width:850px;height:420px" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:true">
			<br>
			<form id="updateForm" method="post">
			<input type="hidden" name="goodsId" id="rgoodsId"/>
			<input type="hidden" name="orderNo" id="rorderNo"/>
			<input type="hidden" name="orderDetailId" id="rorderDetailId"/>
			<table class="item-table">
				<tr>
					<td><span class="item-span">订单号：</span></td>
					<td><input type='text'  class="item-input fl"  id='rorderno2' disabled='disabled'/></td>
					<td><span class="item-span">上车站：</span></td>
					<td><input type='text'  class="item-input fl"  id='rinstation' disabled='disabled'/></td>
					<td><span class="item-span">下车站：</span></td>
					<td><input type='text'  class="item-input fl"  id='roffstation' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">下单时间：</span></td>
					<td><input type='text'  class="item-input fl"  id='rordertime' disabled='disabled'/></td>
					<td><span class="item-span">乘车时间：</span></td>
					<td><input type='text'  class="item-input fl"  id='rridetime' disabled='disabled'/></td>
					<td colspan='2'> </td>
				</tr> 
				<tr>
					<td><span class="item-span">金额：</span></td>
					<td><input type='text'  class="item-input fl"  id='rmoney' disabled='disabled'/></td>
					<td><span class="item-span">支付方式：</span></td>
					<td><input type='text'  class="item-input fl"  id='rpaytype' disabled='disabled'/></td>
					<td><span class="item-span">状态：</span></td>
					<td><input type='text'  class="item-input fl"  id='rstatus' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">实付金额：</span></td>
					<td><input type='text'  class="item-input fl"  id='rpaymoney' disabled='disabled'/></td>
					<td><span class="item-span">购票人：</span></td>
					<td><input type='text'  class="item-input fl"  id='rbuyperson' disabled='disabled'/></td>
					<td><span class="item-span">联系方式：</span></td>
					<td ><input type='text'  class="item-input fl"  id='rcontactphone' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">退款备注：</span></td>
					<td colspan='5'>
						<div class="item-inputmark" ><textarea type='text'   id='rremark' name="remark" disabled='disabled' /></textarea></div>
					</td>
					
				</tr>
			</table> 
			</form>
		    <br>
		     <a id="ubtn" href="javascript:void(0);" class="item-btn fl" >同意退款申请</a>
		     <a id="vbtn" href="javascript:void(0);" class="item-btn fl gray-bg f-white"  >拒绝退款申请</a>
			<br>
		</div>
	  </body>
	 <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
       <script type="text/javascript" src="${appName}/commons/js/order/order_verify.js"></script> 
</html>

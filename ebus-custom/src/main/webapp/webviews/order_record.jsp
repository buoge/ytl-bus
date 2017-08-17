<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		 <!-- common header -->
         <%@ include file="/webviews/common/header.jsp"%>
		<title>订单记录</title>
	</head>
	<body>
	 <!-- item-header -->
	   	<div id="tb" class="item-header">
			<a href="javascript:void(0);"  class="item-span  f-blue fl"   onclick="javascript:detailInfo();">详情</a>
			<a href="javascript:void(0);"  class="item-span  f-blue fl"  onclick="javascript:updateInfo();">退款申请</a>
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
			<input type="text"  class="item-input  fl" id='contactPhone' size="15"/>
			<span class="item-span  fl">订单状态：</span>
			<span class="item-select fl">
			<select id="orderStatus" class="easyui-combobox" name="orderStatus" style="width:100px;">  
					    <option value="-1">--请选择--</option>   
					    <option value="0">未支付</option>   
					    <option value="1">已支付</option>   
					    <option value="2">已取消</option>
					    <option value="3">订单失效</option>
					</select>
			</span>
			<a id="query" href="javascript:void(0);" class="item-btn" >查询</a>
		</div>
		<!-- girdOrderRecord  -->
		<div class="item-content" >
		   <table id ="girdOrderRecord"></table>
		</div>
		
		<div id="detailWin" class="easyui-window hide" align="center" title="查看详情" style="width:850px;height:300px" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:true">
			<br>
			<table class="item-table">
				<tr>
					<td><span class="item-span">订单号：</span></td>
					<td ><input type='text'  class="item-input fl" id='dorderno' disabled='disabled'/></td>
					<td ><span class="item-span">上车站：</span></td>
					<td><input type='text'  class="item-input fl"  id='dinstation' disabled='disabled'/></td>
					<td ><span class="item-span">下车站：</span></td>
					<td ><input type='text'  class="item-input fl"   id='doffstation' disabled='disabled'/></td>
				</tr> 
				<tr>
				</tr>
				<tr>
					<td ><span class="item-span">下单时间：</span></td>
					<td ><input type='text'  class="item-input fl"  id='dordertime' disabled='disabled'/></td>
					<td ><span class="item-span">乘车时间：</span></td>
					<td><input type='text'  class="item-input fl" id='dridetime' disabled='disabled'/></td>
					<td colspan='2'> </td>
				</tr> 
				<tr>
					<td ><span class="item-span">金额：</span></td>
					<td ><input type='text'  class="item-input fl" id='dmoney' disabled='disabled'/></td>
					<td ><span class="item-span">支付方式：</span></td>
					<td><input type='text'  class="item-input fl" id='dpaytype' disabled='disabled'/></td>
					<td ><span class="item-span">状态：</span></td>
					<td ><input type='text'  class="item-input fl"  id='dstatus' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td ><span class="item-span">实付金额：</span></td>
					<td ><input type='text'  class="item-input fl" id='dpaymoney' disabled='disabled'/></td>
					<td ><span class="item-span">购票人：</span></td>
					<td><input type='text'  class="item-input fl" id='dbuyperson' disabled='disabled'/></td>
					<td ><span class="item-span">联系方式：</span></td>
					<td ><input type='text'  class="item-input fl"  id='dcontactphone' disabled='disabled'/></td>
				</tr> 
			</table> 
			<br>
		</div>
		
		<div id="refundWin" align="center" class="easyui-window hide" title="订单退款申请" style="width:850px;height:420px" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:true">
			<br>
			<form id="updateForm" method="post">
			<input type="hidden" name="goodsId" id="rgoodsId"/>
			<input type="hidden" name="orderNo" id="rorderNo"/>
			<input type="hidden" name="orderDetailId" id="rorderDetailId"/>
			<table class="item-table">
				<tr>
					<td><span class="item-span">订单号：</span></td>
					<td><input type='text'  class="item-input fl" id='rorderno2' disabled='disabled'/></td>
					<td><span class="item-span">上车站：</span></td>
					<td><input type='text'  class="item-input fl" id='rinstation' disabled='disabled'/></td>
					<td><span class="item-span">下车站：</span></td>
					<td><input type='text'   class="item-input fl" id='roffstation' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">下单时间：</span></td>
					<td><input type='text'  class="item-input fl" id='rordertime' disabled='disabled'/></td>
					<td><span class="item-span">乘车时间：</span></td>
					<td><input type='text'  class="item-input fl" id='rridetime' disabled='disabled'/></td>
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
					<td><input type='text'  class="item-input fl"   id='rcontactphone' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">退款备注：</span></td>
						<td colspan='5'>
						<div class="item-inputmark white-bg" ><textarea type='text'   id='rremark' name="remark" /></textarea></div>
					</td>
				</tr>
			</table> 
			</form>
		    <br>
		    <a id="ubtn" href="javascript:void(0);" class="item-btn gray-bg f-white"  >退款申请</a>
			<br>
		</div>
	</body>
	 <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
      <script type="text/javascript" src="${appName}/commons/js/order/order_record.js"></script> 
</html>

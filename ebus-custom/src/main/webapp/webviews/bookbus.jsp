<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
		<title>专车管理</title>
	</head>
	<body>
	  <!-- item-header -->
	   	<div id="tb"  class="item-header">
			<a href="javascript:void(0);"  class="item-span  f-blue fl"   onclick="javascript:detailInfo();">详情</a>
			<a href="javascript:void(0);"  class="item-span  f-blue fl"  onclick="javascript:updateInfo();">报价</a>
			<span class="item-span  fl">订单号：</span>
			<input type="text"  class="item-input fl"   id='orderNo'  size="15"/>
			<span class="item-span  fl">联系电话：</span>
			<input type="text"  class="item-input fl"  id='contactPhone'  size="15"/>
			<span class="item-span  fl">包车类型：</span>
		    <span class="item-select fl">
			   <select id="bookBusType"  class="easyui-combobox"  name="status" >  
					    <option value="-1">--请选择--</option>   
					    <option value="1">单程</option>   
					    <option value="2">往返</option>   
					    <option value="3">包天</option>   
					 </select>  
		    </span>
			<span class="item-span  fl">订单状态：</span>
			 <span class="item-select fl">
			<select id="status" class="easyui-combobox" name="status">  
					    <option value="-1">--请选择--</option>   
					    <option value="0">待报价</option>   
					    <option value="1">待付款</option>   
					    <option value="2">待派车</option>
					    <option value="3">已取消</option>  
					    <option value="4">已完成</option>
					    <option value="5">退款申请中</option>  
					    <option value="6">已退款</option>
					 </select>
			</span>
		  <a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
		</div>
		
		<div class="item-content" >
		  <table id ="girdBusBook" >   </table>
	    </div>
	    
		<div id="detailWin" class="easyui-window  hide" align="center" title="查看详情" style="width:760px;height:540px" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:true">
			<br>
			<table  class="item-table">
				<tr>
					<td><span class="item-span">用车联系人：</span></td>
					<td><input type='text'  class="item-input"   id='dcontact' disabled='disabled'/></td>
					<td><span class="item-span">联系电话：</span></td>
					<td><input type='text'  class="item-input"   id='dcontactphone' disabled='disabled'/></td>
				
				</tr> 
				<tr>
					<td><span class="item-span">乘车人数：</span></td>
					<td><input type='text'  class="item-input"   id='dcount' disabled='disabled'/></td>
					<td><span class="item-span">包车费用（元）：</span></td>
					<td><input type='text'  class="item-input"   id='dmoney' disabled='disabled'/></td>
				</tr>
				<tr>
					<td><span class="item-span">出发地：</span></td>
					<td><input type='text'  class="item-input"   id='dstart' disabled='disabled'/></td>
					<td><span class="item-span">目的地：</span></td>
					<td><input type='text'  class="item-input"  id='dend' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">出发时间：</span></td>
					<td><input type='text'  class="item-input"  id='dstarttime' disabled='disabled'/></td>
					<td><span class="item-span">结束时间：</span></td>
					<td><input type='text' class="item-input"   id='dendtime' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">申请人：</span></td>
					<td><input type='text'  class="item-input"   id='dapply' disabled='disabled'/></td>
					<td><span class="item-span">申请时间：</span></td>
					<td><input type='text'  class="item-input"   id='dapplytime' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">报价员：</span></td>
					<td ><input type='text'  class="item-input"   id='dquoter' disabled='disabled'/></td>
					<td><span class="item-span">报价时间：</span></td>
					<td><input type='text'  class="item-input"  id='dquotetime' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">付款人：</span></td>
					<td><input type='text'  class="item-input"  id='dpay' disabled='disabled'/></td>
					<td><span class="item-span">付款时间：</span></td>
					<td><input type='text'  class="item-input"  id='dpaytime' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">备注：</span></td>
					<td colspan='3'><div class="item-inputmark" ><textarea type='text'   id='dremark'  disabled='disabled'/></textarea></div></td>
				</tr> 
			</table> 
			<br>
		</div>
		
		<div id="updateWin" align="center" class="easyui-window  hide"   title="报价" style="width:400px;height:auto" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:true">
			<form id="updateForm" method="post">
			<input type="hidden" name="goodsId" id="goodsId"/>
			<input type="hidden" name="orderNo" id="uorderNo"/>
				<div class="pad30  crbox ">
				    <span class="item-span fl">金额(元):</span><span class="item-span f-red fl">*</span>
				    <input type="text" name="quotedPrice" class=" easyui-validatebox item-input fl"   id="quotedPrice"  data-options="required:true,validType:'intOrFloat'"/>
			         <a id="ubtn" href="javascript:void(0);" class="item-btn fl" >报价</a>
			    </div>
		    </form>
		</div>
	</body>
	  <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
      <script type="text/javascript" src="${appName}/commons/js/bookbus/bookbus.js"></script> 
</html>

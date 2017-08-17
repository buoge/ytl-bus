<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		 <!-- common header -->
         <%@ include file="/webviews/common/header.jsp"%>
		<title>车辆评价记录</title>
	</head>
	<body>
	 <!-- item-header -->
	   	<div id="tb" class="item-header">
			<a href="javascript:void(0);"  class="item-span  f-blue fl"  onclick="detailInfo();">详情</a>
			<span class="item-span  fl">线路：</span>
			<input type="text" class="item-input  fl"  id='routeName' size="15"/>
			<span class="item-span  fl">车牌号：</span>
			<input type="text" class="item-input  fl"  id='evaluatObjName' size="15"/>
			<span class="item-span  fl">评价人：</span>
			<input type="text" class="item-input  fl"  id='userName' size="15"/>
			   <span class="item-span  fl">时间范围： </span>
				<span class="item-select item-time fl">
				<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'endDate\')}'})" id='startDate'  name="startDate" size="15"/>
				 <i class="Wdateico" ></i>
				</span>
				<span class="item-span  fl">至： </span>
				<span class="item-select item-time fl">
				<input class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'startDate\')}',startDate:'#F{$dp.$D(\'startDate\',{d:+1})}'})" id='endDate'  name="endDate" size="15"/>
				 <i class="Wdateico" ></i>
				</span>
			<a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
		</div>
		<div class="item-content" >
		<table id="gridBusEvaluate" > </table>
	</div>
		<div id="detailWin" class="easyui-window hide" align="center" title="查看详情" style="width:800px;height:290px" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:true">
			<br>
			<table class="item-table">
				<tr>
					<td><span class="item-span">线路：</span></td>
					<td><input type='text'  class="item-input"  id='droutename'  disabled='disabled'/></td>
					<td><span class="item-span">车牌号：</span></td>
					<td><input type='text'  class="item-input"  id='dbusnumber' disabled='disabled'/></td>
				</tr> 
				<tr>
			       	<td><span class="item-span">评价人：</span></td>
					<td><input type='text'  class="item-input"   id='dusername' disabled='disabled'/></td>
					<td><span class="item-span">评价时间：</span></td>
					<td><input type='text'  class="item-input"  id='devalutime' disabled='disabled'/></td>
					</tr>
				<tr>
					<td><span class="item-span">类型：</span></td>
					<td><input type='text'  class="item-input"   id='dtype' disabled='disabled'/></td>
					<td><span class="item-span">评价得分：</span></td>
					<td><input type='text'  class="item-input"  id='dscore' disabled='disabled'/><input type='text'  class="item-input item-w60 t-c item-marl15"    id='dtypetail' disabled='disabled'/></td>
				</tr> 
				<tr>
					<td ><span class="item-span">更多细节</span></td>
					<td colspan='3'><input type='text'   class="item-input item-60"  id='dcomment' disabled='disabled'/></td>
				</tr> 
			</table> 
			<br>
		</div>
	</body>
	 <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
       <script type="text/javascript" src="${appName}/commons/js/evaluate/bus_evaluate.js"></script> 
</html>

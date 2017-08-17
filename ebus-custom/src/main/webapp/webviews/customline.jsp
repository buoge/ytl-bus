<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	  <!-- common header -->
      <%@ include file="/webviews/common/header.jsp"%>
	 <title>定制公交</title>	
	</head>
	<body>
	
	  <!-- item-header -->
	   	<div id="tb" class="item-header">
			 <a href="javascript:void(0);" class="item-span  f-blue fl"  onclick="detailInfo();">详情</a>
			 <a href="javascript:void(0);" class="item-span  f-blue fl"  onclick="openCustomLine();">开通</a>
			 <span class="item-span  fl">起始站台：</span><input class="item-input fl"  type="text"  id='startStation' size="15"/>
			 <span class="item-span fl">终止站台：</span><input class="item-input fl"  type="text"  id='endStation' size="15"/>
			 <span class="item-span fl">状态：</span>
			 <span class="item-select fl">
				 <select id="status" class="easyui-combobox  name="status“>  
					    <option value="-1">--请选择--</option>   
					    <option value="1">众筹中</option>   
					    <option value="2">待处理</option>   
					    <option value="3">不开通</option>   
					    <option value="4">已开通</option>
					    <option value="5">未开通</option>   
					</select>  
				</span>
			<a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
			<a id="map" href="javascript:void(0);" class="item-btn fl">地图</a>
		</div>
		
		<div class="item-content" >
		  <!-- gridCustomLine   datagrid -->
		   <div class="item-boxset">
			<table id ="gridCustomLine" > </table>
			</div>
		 </div>
	  
	  <!-- 详情 start  -->
		<div id="detailWin" class="easyui-window hide" align="center" title="查看详情"  style="width:800px;height:500px" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:true">
			<input type="hidden" id="singleLineId"/>
			<table  class="item-table">
				<tr>
					<td ><span class="item-span">发起人：</span></td>
					<td><input type='text'  id='promoter'  class="item-input" disabled='disabled'/></td>
					<td ><span class="item-span">发起时间：</span></td>
					<td ><input type='text'  id='promoteTime'  class="item-input" disabled='disabled'/></td>
					
				</tr> 
				<tr>
				    <td ><span class="item-span">起点：</span></td>
					<td><input type='text'  id='subStartStation'  class="item-input" disabled='disabled'/></td>
					<td><span class="item-span">终点：</span></td>
					<td><input type='text'  id='subEndStation'  class="item-input"  disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">上班时间：</span></td>
					<td><input type='text'  id='onWorkTime'  class="item-input"  disabled='disabled'/></td>
					<td><span class="item-span">下班时间：</span></td>
					<td><input type='text'  id='offWorkTime' class="item-input"  disabled='disabled'/></td>
				</tr> 
			</table> 
			
			<table class="item-table">
				<tr>
					<td><span class="item-span">已报名人数：</span></td>
					<td colspan='2'>
					    <input type='text'  class="item-input fl"    id='regPersons' disabled='disabled'/>
						<a id="map2" href="javascript:void(0);" class="item-btn fl" >地图</a>
					</td>
				</tr> 
				<tr>
					<td><span class="item-span">起点：</span></td>
					<td colspan='2'>
						<input type='text'  id='start0'  class="item-input "  disabled='disabled'/>
						<input type='text'  id='start1'  class="item-input item-marl"  disabled='disabled'/>
						<input type='text'  id='start2' class="item-input item-marl"  disabled='disabled'/>
					</td>
				</tr>
				<tr>
					<td><span class="item-span">终点：</span></td>
					<td>
						<input type='text'  id='end0' class="item-input"  disabled='disabled'/>
						<input type='text'‘  id='end1' class="item-input item-marl"    disabled='disabled'/>
						<input type='text'  id='end2' class="item-input item-marl"  disabled='disabled'/>
					</td>
				</tr>
				<tr>
					<td ><span class="item-span">过滤数目：</span></td>
					<td colspan='2'>
						<input type='text' class="item-input"  id='filteredResult' disabled='disabled'/>
					</td>
				</tr>
			</table>
			<table id="gridCustomdg"></table> 
		</div>
		
		  <!-- map start -->
		<div id="mapWin" align="center" class="easyui-window" title="地图" style="width:800px;height:600px"  data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:true"></div>
	  </body>
	   <!-- common footer -->
       <%@ include file="/webviews/common/footer.jsp"%>
       <script src="http://webapi.amap.com/maps?v=1.3&key=6008d49517cbff8cdf61c00e7e9ef338"></script>
       <script src="http://webapi.amap.com/js/marker.js"></script>
	   <script type="text/javascript" src="${appName}/commons/js/customline/customline.js"></script> 
	   
</html>
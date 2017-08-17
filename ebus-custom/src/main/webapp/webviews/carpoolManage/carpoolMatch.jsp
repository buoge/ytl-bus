<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	  <!-- common header -->
      <%@ include file="/webviews/common/header.jsp"%>
	 <title>拼车管理-撮合设置</title>	
	</head>
	<body>
	
	  <!-- item-header -->
	   	 <div id="tb" class="item-header">
	   	    
			<span class="item-spans fl">城市： </span>
				<span class="item-select fl">
					<select id="qcityChoose" name="cityCode">  
				    </select>
				</span>	
				<a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
				
			</div>	
		</div> 
		
		
		<div class="item-content" >
		  <!-- gridCustomLine   datagrid -->
		   <div class="item-boxset">
			<table id ="gridCarpoolRecord" > </table>
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
	   <script type="text/javascript" src="${appName}/commons/js/carpoolManage/carpoolMatch.js"></script> 
	   
</html>
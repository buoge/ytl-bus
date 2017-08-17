<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	  <!-- common header -->
      <%@ include file="/webviews/common/header.jsp"%>
	 <title>拼车管理-拼车记录</title>	
	</head>
	<body>
	  <!-- item-header -->
	  <div id="tb" class="item-header">
			 <span class="item-span  fl">起点：</span><input class="item-input fl"  type="text"  id='qstartPlace' size="15"/>
			 <span class="item-span fl">终点站台：</span><input class="item-input fl"  type="text"  id='qendPlace' size="15"/>
			 <span class="item-spans fl">日期： </span>
				<span class="item-select item-time fl">
				<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,})" id='qstartTime'  name='qstartTime'  size="15"/>
				 <i class="Wdateico" ></i>
				</span>
				<!-- <span class="item-spans fl">至： </span>
				<span class="item-select item-time fl">
				<input class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'qstartTime\')}',startDate:'#F{$dp.$D(\'qstartTime\',{d:+1})}'})" id='qendTime'  name="qendTime" size="15"/>
				 <i class="Wdateico" ></i>
				</span> -->
			 <div class="crbox">
				<span class="item-spans fl">城市： </span>
				<span class="item-select fl">
					<select id="qcityChoose" name="cityCode">  
				    </select>
				</span>	
				<a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
			 </div>	
		</div>
		</div>
		<div class="item-content" >
		  <!-- gridCustomLine   datagrid -->
		   <div class="item-boxset">
			<table id ="gridCarpoolRecord" > </table>
			</div>
		 </div>
	    
	  <!-- 详情 start  -->
		<div id="detailWin" class="easyui-window hide" align="center" title="拼车详情"  style="width:1165px;height:580px" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:true">
			<input type="hidden" id="singleLineId"/>
			<input type="hidden" id="cityCode"/>
			<table  class="item-table">
				<tr>
				    <td ><span class="item-span">起点：</span></td>
					<td><input type='text'  id='startStation'  class="item-input" disabled='disabled'/></td>
					<td><span class="item-span">撮合开始：</span></td>
					<td><input type='text'  id='gmtCreate'  class="item-input"  disabled='disabled'/></td>
					<td><span class="item-span">撮合次数：</span></td>
					<td><input type='text'  id='matchTimes'  class="item-input"  disabled='disabled'/></td>
					<td><span class="item-span">撮合人数：</span></td>
					<td><input type='text'  id='matchPersons'  class="item-input"  disabled='disabled'/></td>
				</tr> 
				<tr>
					<td><span class="item-span">终点：</span></td>
					<td><input type='text'  id='endPlace'  class="item-input"  disabled='disabled'/></td>
					<td><span class="item-span">撮合时长：</span></td>
					<td><input type='text'  id='gmtModified' class="item-input"  disabled='disabled'/></td>
					<td><span class="item-span">剩余时长：</span></td>
					<td><input type='text'  id='matchExpectTime' class="item-input"  disabled='disabled'/></td>
					
				</tr> 
				<tr>
					<td ><span class="item-span">发车时间：</span></td>
					<td colspan='1'><input type='text'   class="item-input item-60"  id='departTime' disabled='disabled'/></td>
					<td ><span class="item-span">票价：</span></td>
					<td colspan='1'><input type='text'   class="item-input item-60"  id='price' disabled='disabled'/></td>
					<td ><span class="item-span">资源匹配：</span></td>
					<td colspan='1'><input type='text'   class="item-input item-60"  id='busType' style="font-size:12px" disabled='disabled'/></td>
					<td><button id="map"  class="item-btn fl">总览</button></td>
					<td><button id="carpoolDetail"  class="item-btn fl">拼车人员详情</button></td>
				</tr> 
			</table> 
		    <!-- map start -->
		   
		   <!--  <div id="mapWin" class="easyui-window mapContent" style="width:100% height:1020px" >
		    
		    </div>  -->
	    <div id="mapWin" align="center" class="easyui-window mapContent" title="地图" style="width:800px;height:600px"  data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:true"></div> 
		    <div class="item-content" id="carpoolPeople"  >
		        <table id="gridCustomdg"></table>
	       </div>
		</div>
		
		
	  </body>
	   <!-- common footer -->
       <%@ include file="/webviews/common/footer.jsp"%>
       <script src="http://webapi.amap.com/maps?v=1.3&key=6008d49517cbff8cdf61c00e7e9ef338&plugin=AMap.Driving"></script>
       <script src="http://webapi.amap.com/js/marker.js"></script>
 <!--       <script type="text/javascript" src="http://cache.amap.com/lbs/static/TransferRender1230.js"></script> -->
       <script type="text/javascript" src="${appName}/commons/js/carpoolManage/carpoolRecord.js"></script> 
	   
</html>
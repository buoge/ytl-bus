<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	  <!-- common header -->
      <%@ include file="/webviews/common/header.jsp"%>
	 <title>城市od导向图</title>	
	</head>
	<body>
	  <!-- item-header -->
	   	<div id="tb" class="item-header">
		 <span class="item-span    fl">选择城市：</span>
			 <span class="item-select fl">
				<select id="cityChoose" name="citycode">  
				</select>
			</span>
			 <span class="item-span    fl">收集乘客人数：<i id="totleNum">0</i></span>
			<!--  <span class="item-spans fl">发布时间： </span>
				<span class="item-select item-time fl">
				<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'qendTime\')}'})" id='qstartTime'  name='qstartTime'  size="15"/>
				 <i class="Wdateico" ></i>
				</span>
				<span class="item-spans fl">至： </span>
				<span class="item-select item-time fl">
				<input class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'qstartTime\')}',startDate:'#F{$dp.$D(\'qstartTime\',{d:+1})}'})" id='qendTime'  name="qendTime" size="15"/>
				 <i class="Wdateico" ></i>
				</span> -->
			<a  href="javascript:void(0);" class="item-btn fl"  onclick="searchMap();">查询</a>
		</div>
		
		<div class="item-content" >
		  <!-- map start -->
		    <div id="initMapData"  class="item-map"></div>
		 </div>
	  </body>
	   <!-- common footer -->
       <%@ include file="/webviews/common/footer.jsp"%>
       <script src="http://webapi.amap.com/maps?v=1.3&key=6008d49517cbff8cdf61c00e7e9ef338"></script>
       <script src="http://webapi.amap.com/js/marker.js"></script>
	   <script type="text/javascript" src="${appName}/commons/js/cityGuideMap/cityGuideMap.js"></script> 
</html>
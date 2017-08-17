<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
		<title>趋势分析</title>
	</head>
	<body>
	  <!-- item-header -->
	   	<div id="tb"  class="item-header">
			  <span class="item-span    fl">选择城市：</span>
			 <span class="item-select fl">
				<select id="cityChoose" name="citycode">  
				</select>
			</span>
			 <span class="item-spans fl">发布时间： </span>
				<span class="item-select item-time fl">
				<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'endDate\')}'})" id='startDate'  name='startDate'  size="15"/>
				 <i class="Wdateico" ></i>
				</span>
				<span class="item-spans fl">至： </span>
				<span class="item-select item-time fl">
				<input class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'startDate\')}',startDate:'#F{$dp.$D(\'startDate\',{d:+1})}'})" id='endDate'  name="endDate" size="15"/>
				 <i class="Wdateico" ></i>
				</span>
		  <a id="query" href="javascript:void(0);" onclick="initDataEchartQuery()" class="item-btn fl" >查询</a>
		</div>
		
		<div class="item-content" >
		     <!-- echart js start -->
		     <div class="item-line echart-header  crbox">
			     <span class="fl">趋势分析</span>
			      <span class="datestatus fr"  dataNum="30"  >月</span>
			     <span class="datestatus fr"  dataNum="7" >周</span>
			     <span class="datestatus item-active fr" dataNum="1"  >日</span>
		     </div>
		     <div id="gridEchartTrend"  style="height:400px;width:100%;">
		     </div>
		     <!-- echart js end -->
	       <div class="item-line" >  
              <table class="item-tables"> 
	            <thead><th>新增用户</th><th>活跃用户</th><th>启动次数</th><th>累计用户</th></thead>
	            <tbody id ="girdTrendAnalysis" ></tbody>
	          </table  >
	    </div>
	    </div>
	</body>
	  <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
      <script type="text/javascript" src="${appName}/commons/js/trendAnalysis/trendAnalysis.js"></script> 
      <script type="text/javascript" src="${appName}/commons/lib/echart/echarts.js"></script> 
</html>

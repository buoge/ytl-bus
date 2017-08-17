<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
		<title>应收应付统计</title>
	</head>
	<body>
	  <!-- item-header -->
	   	<div id="tb"  class="item-header">
			<div class="item-col crbox">
			<span class="item-span fl">城市： </span>
			<span class="item-select fl">
				<select id="qcityChoose" name="cityCode">  
			    </select>
			</span>
			<span class="item-span fl">周期： </span>
			<span class="item-select fl">
				<select  class="easyui-combobox"    id="chooseDate" >
				   <option value="1">所有</option>  
				   <option value="2">今日</option>
				   <option value="3">本周</option>
				   <option value="4">本月</option>
				   <option value="5">自定义</option>
			    </select>
			</span>
			<div class="setDate" style="display:none"> 
			    <span class="item-span  fl">生效时间： </span>
				<span class="item-select item-time fl">
				<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'enddate\')}'})" id='startdate'  name="startdate" size="15"/>
				 <i class="Wdateico" ></i>
				</span>
				<span class="item-span  fl">失效时间： </span>
				<span class="item-select item-time fl">
				<input class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'startdate\')}',startDate:'#F{$dp.$D(\'startdate\',{d:+1})}'})" id='enddate'  name="enddate" size="15"/>
				 <i class="Wdateico" ></i>
				</span>
			</div>
			   <a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
			  </div>
	
		</div>
		
		<div class="item-content"  >
		   <table id ="girdReceivableStatistics" ></table>
	    </div>
	</body>
	  <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
      <script type="text/javascript" src="${appName}/commons/js/accountStatistics/receivableStatistics.js"></script>
</html>

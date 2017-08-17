<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
     <!-- common header -->
      <%@ include file="/webviews/common/header.jsp"%>
      <title>反馈建议</title>
</head>
<body>
	<form name="searchform" method="post" action="${appName}/evaluationGeneral/list" id="searchform">
		<div id="tb"  class="item-header">
		  <div class="item-col crbox">
		    <span class="item-span  fl">&nbsp;&nbsp;&nbsp;线路:</span>
			<input type="text" class="item-input  fl"  name="routeName" id="drouteName" size=20> 
			<span class="item-span  fl">&nbsp;车牌号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" class="item-input  fl"  name="busPlateNumber" id="dbusPlateNumber" size=20> 
			<span class="item-span  fl">司机:</span>
			<input type="text" class="item-input  fl"  name="driver" id="ddriver" size=20> 
			<span class="item-span  fl">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;站台:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" class="item-input  fl"  name="position" id="dposition" size=20></div> 
			<div class="item-col crbox">
			    <span class="item-span  fl">评价人:</span> 
			    <input type="text" class="item-input fl"  name="userName" id="duserName" size=20> 
		        <span class="item-span  fl">时间范围: 从</span>
				<span class="item-select item-time fl">
				<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'endtime\')}'})" id='starttime'  name="starttime" size="15"/>
				 <i class="Wdateico" ></i>
				</span>
				<span class="item-span  fl">至： </span>
				<span class="item-select item-time fl">
				<input class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'starttime\')}',startDate:'#F{$dp.$D(\'starttime\',{d:+1})}'})" id='endtime'  name="endtime" size="15"/>
				 <i class="Wdateico" ></i>
				</span>
		        <span class="item-spans fl">城市： </span>
			    <span class="item-select fl">
				<select id="qcityChoose" name="cityCode">  
			    </select>
			    </span>
		    <span id="submit_search" class="item-btn">查询</span>
		  </div>
	  </div>
	  	
	</form>
	<div class="item-content" >
	    <table id="dg" ></table>
	</div>
</body>
 <!-- common footer -->
  <%@ include file="/webviews/common/footer.jsp"%>
<!-- 这里是编辑窗口-->
<%@include file="/webviews/suggestionEdit.jsp"%>
<script type="text/javascript"  src="${appName}/commons/js/suggestion/suggest.js"></script>
<script type="text/javascript">
        $(function () {
        	$(this).suggestion.defaults._appPath = "${appName}";
        	$(this).suggestion.init();
        });
    </script> 
</html>
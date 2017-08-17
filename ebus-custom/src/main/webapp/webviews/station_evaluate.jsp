<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
     <!-- common header -->
      <%@ include file="/webviews/common/header.jsp"%>
      <title>反馈建议</title>
</head>
<body>
	<form name="searchform" method="post" action="${appName}/suggestion/getSuggestionPagging" id="searchform">
		<div id="tb"  class="item-header">
			<span class="item-span  fl">客服用户:</span>
			<input type="text" class="item-input  fl"  name="contactinfo" id="contactinfo" size=20> 
			<span class="item-span  fl">联系方式:</span> 
			<input type="text" class="item-input fl"  name="content" id="content" size=20>
	
		    <span class="item-span  fl">客服时间: 从</span>
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
			    <!-- <span class="item-select fl">
				<select id="qcityChoose" name="cityCode">  
			    </select>
			    </span> -->
			    <span class="item-select fl">
				<select id="qcityChoose" name="cityCode">  
			    </select>
			</span>
		    <span id="submit_search" class="item-btn">搜索</span>
		</div>
	</form>
	<div class="item-content" >
	    <table id="dg" ></table>
	</div>
</body>
 <!-- common footer -->
  <%@ include file="/webviews/common/footer.jsp"%>
<!-- 这里是编辑窗口-->
<%@include file="/webviews/stationevaluateEdit.jsp"%>
<script type="text/javascript"  src="${appName}/commons/js/evaluate/station_evaluate.js"></script>
<script type="text/javascript">
        $(function () {
        	$(this).suggestion.defaults._appPath = "${appName}";
        	$(this).suggestion.init();
        });
    </script> 
</html>

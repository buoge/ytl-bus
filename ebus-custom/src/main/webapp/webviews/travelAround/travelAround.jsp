<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
		<title>广告屏闪管理</title>
	</head>
	<body>
	  <!-- item-header -->
	    <div id="tb"  class="item-header">
	   	    <span class="item-span    fl">所属城市：</span>
			<span class="item-select fl">
				<select id="cityChoose" name="citycode"></select>  
			</span>
			<span class="item-span  fl">标题 :</span>
			<input type="text" class="item-input  fl"  name="title" id="title" size=20> 
		    <a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
		    <span class="item-alink  f-blue fl"  onclick="advertManageAdd();">新增</span>
		</div>
		<div class="item-content" >
	       <!--  <table id ="girdAdvertManage" ></table> -->
	         <table id ="girdTravelAround" ></table>
	    </div>
	</body>
	  <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
      <script type="text/javascript" src="${appName}/commons/js/travelAround/travelAround.js"></script> 
</html>

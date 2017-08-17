<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
        <!-- 富文本编辑器 -->
        <link rel="stylesheet" type="text/css" href="${appName}/commons/lib/wangEditor/dist/css/wangEditor.min.css">  
		<title>驾校报名</title>
	</head>
	<body>
	  <!-- item-header -->
	   	<div id="tb"  class="item-header">
			<div class="item-col crbox">
			<span class="item-alink  f-blue fl"  onclick="drivingPublishAdd();">新增</span>
			<span class="item-span fl">城市： </span>
			<span class="item-select fl">
				<select id="qcityChoose" name="cityCode">  
			    </select>
			</span>
			   <span class="item-span fl">驾照类型： </span>
			   <span class="item-select fl">
				<select id="drivingType" name="desc">  
			    </select>
			</span>
			   <a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
			  </div>			
		</div>
		
		<div class="item-content"  >
		   <table id ="girdDrivingPublish" ></table>
	    </div>
	</body>
	  <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
           <!-- ueditor footer -->
      <%@ include file="/webviews/common/ueditor.jsp"%>
      <script type="text/javascript" src="${appName}/commons/js/drivingDecords/drivingPublish.js"></script>
</html>

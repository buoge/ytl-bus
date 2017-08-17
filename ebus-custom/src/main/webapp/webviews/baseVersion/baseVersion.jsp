<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
		<title>城市ip配置</title>
	</head>
	<body>
	  <!-- item-header -->
	   	<div id="tb"  class="item-header">
	   		<span class="item-alink  f-blue fl"  onclick="cityIpConfigAdd();">新增</span>
			<span class="item-span  fl">版本号：</span>
		    <input type="text"  class="item-input fl"   id='versionId'  size="15"/>
			<span class="item-span  fl">城市编码：</span>
			<input type="text"  class="item-input fl"   id='citycode'  size="15"/>
			
		  <a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
		</div>
		<div class="item-content" >
	        <table id ="girdBaseVersion" >  </table>
	    </div>
	</body>
	  <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
      <script type="text/javascript" src="${appName}/commons/js/baseVersion/baseVersion.js"></script> 
</html>

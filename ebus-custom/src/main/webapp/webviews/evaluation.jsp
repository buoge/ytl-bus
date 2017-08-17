<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
      <!-- common header -->
      <%@ include file="/webviews/common/header.jsp"%>
<title>评价管理</title>
</head>
</head>
<body>
	<div class="item-content">
    <div id="echartPie"  class="echartPie" ></div>
    </div>
  </body>
 <!-- common footer -->
 <%@ include file="/webviews/common/footer.jsp"%>
  <script type="text/javascript" src="${appName}/commons/lib/dist/echarts.js"></script>
 <script type="text/javascript" src="${appName}/commons/js/evaluate/evaluate.js"></script>
</html>

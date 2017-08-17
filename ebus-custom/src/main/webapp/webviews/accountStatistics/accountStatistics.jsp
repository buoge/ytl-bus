<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
		<title>账目统计</title>
	</head>
	<body>
	  <!-- item-header -->
	   	<div id="tb"  class="item-header">
			<div class="item-col crbox">
					<span class="item-span " >城市数 ： 13 个</span>
					<span class="item-span ">用户钱包总余额 ： 2548542.68 元 </span>
			        <span class="item-span ">今日消费总额： 2548542.68 元</span>
			  </div>
		</div>
		<div class="item-content"  >
		   <table id ="girdDrivingDecords" ></table>
	    </div>
	    
	</body>
	  <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
      <script type="text/javascript" src="${appName}/commons/js/accountStatistics/accountStatistics.js"></script>
</html>

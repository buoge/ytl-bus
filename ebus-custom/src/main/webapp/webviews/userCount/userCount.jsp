<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
		<title>用户统计</title>
	</head>
	<body>
	  <!-- item-header -->
	   	<div  class="item-conner crbox">
	          <ul class="crbox">
		           <li class="item-w12 item-blues"><div><p class="item-ptxt item-blues" ></p><p class="item-txts">今日</p><p class="item-txts">昨日</p></div></li>
		          <li class="item-w22"><div><p class="item-ptxt">新增用户</p><p class="item-ptxts item-green nowNewusers"  >0</p><p class="item-ptxts todayNewusers" >0</p></div></li>
		          <li class="item-w22"><div class="item-borleft"><p class="item-ptxt">活跃用户</p><p class="item-ptxts item-green nowActiveusers">0</p><p class="item-ptxts todayActiveusers" >0</p></div></li>
		          <li class="item-w22 "><div class="item-borleft"><p class="item-ptxt">启动次数</p><p class="item-ptxts item-green nowStarttimes" >0</p><p  class="item-ptxts todayStarttimes" >0</p></div></li>
		          <li class="item-w22 " ><div class="item-borleft"><p class="item-ptxt">累计用户</p><p class="item-ptxts item-green nowTotalusers" >0</p><p  class="item-ptxts todayTotalusers" >0</p></div></li>
	          </ul>
		</div>
		
		<div class="item-wapper" >  
		   <div class="item-line crbox"><span   class=" item-untabs fl ">各个城市</span><span class="item-tabs  fl item-radtl  item-click"  dataDate="1">今天</span><span  class="item-tabs  fl  item-radbr " dataDate="2">昨天</span></div>
	        <table class="item-tables"> 
	            <thead><th>排名</th><th>升降</th><th>城市编码</th><th>城市</th><th>新增用户</th><th>活跃用户</th><th>启动次数</th><th>累计用户</th></thead>
	            <tbody id ="girdUserCount" ></tbody>
	          </table  >
	    </div>
	</body>
	  <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
      <script type="text/javascript" src="${appName}/commons/js/userCount/userCount.js"></script> 
</html>
	            
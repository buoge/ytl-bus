<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
		<title>充值记录</title>
	</head>
	<body>
	  <!-- item-header -->
	   	<div id="tb"  class="item-header">
			<div class="item-col crbox">
			<span class="item-span fl">城市：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
			<span class="item-select fl">
				<select id="qcityChoose" name="cityCode">  
			    </select>
			</span>
			<span class="item-span fl">支付状态： </span>
			<span class="item-select fl">
				<select  class="easyui-combobox"    >
				   <option value="1">全部</option>  
				   <option value="2">已支付</option>
				   <option value="3">未支付</option>
			    </select>
			</span>
			<span class="item-span fl">支付方式： </span>
			<span class="item-select fl">
				<select  class="easyui-combobox"    >
				   <option value="1">全部</option>  
				   <option value="2">微信</option>
				   <option value="3">支付宝</option>
			    </select>
			</span>
			<br/><br/><br/>
			<span class="item-span  fl">充值金额： </span>
			<input type="text"  class="item-input  item-w60s fl"     />
			<span class="item-span  fl">时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
			<span class="item-select item-time fl">
			<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'enddate\')}'})" id='startdate'  name="startdate" size="15"/>
			<i class="Wdateico" ></i>
			</span>
			<span class="item-span  fl">&nbsp;&nbsp;至：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </span>
			<span class="item-select item-time fl">
			<input class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'startdate\')}',startDate:'#F{$dp.$D(\'startdate\',{d:+1})}'})" id='enddate'  name="enddate" size="15"/>
			<i class="Wdateico" ></i>
			</span>
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

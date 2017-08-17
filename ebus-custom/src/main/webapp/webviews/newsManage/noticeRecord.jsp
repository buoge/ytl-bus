<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
        <title>通知记录</title>
	</head>
	<body>
	  <!-- item-header -->
	   	<div id="tb"  class="item-header">
	   
			<span class="item-alink  f-blue fl"  onclick="noticeRecordAdd();">新增</span>
	        <a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
			
			<div class="item-col crbox">
			<span class="item-alink  f-blue fl"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<!-- <span class="item-spans fl">城市： </span>
			<span class="item-select fl">
				<select id="qcityChoose" name="cityCode">  
			    </select> -->
			<span class="item-spans fl">城市： </span>
			<span class="item-select fl">
				<select id="qcityChoose" name="cityCode">  
			    </select>
			</span>
			   <span class="item-spans fl">发布时间： </span>
				<span class="item-select item-time fl">
				<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'qendTime\')}'})" id='qstartTime'  name='qstartTime'  size="15"/>
				 <i class="Wdateico" ></i>
				</span>
				<span class="item-spans fl">至： </span>
				<span class="item-select item-time fl">
				<input class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'qstartTime\')}',startDate:'#F{$dp.$D(\'qstartTime\',{d:+1})}'})" id='qendTime'  name="qendTime" size="15"/>
				 <i class="Wdateico" ></i>
				</span>
				</div>
		
		</div>
		
		<div class="item-content"  >
		   <table id ="girdNoticeRecord" ></table>
	    </div>
	</body>
	  <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>

      <script type="text/javascript" src="${appName}/commons/js/newsManage/noticeRecord.js"></script>
</html>

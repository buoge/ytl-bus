<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
		<title>驾校报名</title>
	</head>
	<body>
	  <!-- item-header -->
	   	<div id="tb"  class="item-header">
			<div class="item-col crbox">
			<span class="item-alink  f-blue fl"  onclick="drivingDecordsAdd();">新增</span>
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
			    <span class="item-span fl">姓名： </span>
			   <input type="text"  class="item-input fl"   id='drivingName'  size="15"/>
			    <span class="item-span fl">手机号码： </span>
			   <input type="text"  class="item-input fl"   id='drivingTelephone'  size="15"/>
			   <a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
			  </div>
			  <div class="item-col crbox">
			 <span class="item-span fl">状态：</span>
			  <label class="item-label fl crbox"><input  type="checkbox"   name="checkStatus"   value="1" class="item-check fl"><span class="item-em fl"  >待联系</span></label>
			   <label class="item-label fl crbox"><input  type="checkbox"   name="checkStatus"  value="2"  class="item-check fl"><span class="item-em fl"  >下次联系</span></label>
			   <label class="item-label fl crbox"><input  type="checkbox"   name="checkStatus"  value="3" class="item-check fl"><span class="item-em fl"  >已报名</span></label>
			  <input type="hidden"  class="item-input fl"   id='drivingStatus'  size="15"/>
			</div>
			
		</div>
		
		<div class="item-content"  >
		   <table id ="girdDrivingDecords" ></table>
	    </div>
	</body>
	  <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
      <script type="text/javascript" src="${appName}/commons/js/drivingDecords/drivingDecords.js"></script>
</html>

<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- common header -->
        <%@ include file="/webviews/common/header.jsp"%>
        <!-- 富文本编辑器 -->
        <link rel="stylesheet" type="text/css" href="${appName}/commons/lib/wangEditor/dist/css/wangEditor.min.css">  
		<title>信息发布管理</title>
	</head>
	<body>
	  <!-- item-header -->
	   	<div id="tb"  class="item-header">
	   	<div class="item-col crbox">
			<span class="item-alink  f-blue fl"  onclick="newsManageAdd();">新增</span>
			<span class="item-spans fl">标题：</span>
			<input type="text"  class="item-input fl"   id='qtitle'  size="15"/>
			<span class="item-spans fl">类型：</span>
		    <span class="item-select fl">
			   <select id="qnewsCategory"  class="easyui-combobox"  name="newsCategory" >  
					    <option value="-1">--请选择类型--</option>   
					    <option value="1">公交动态</option>   
					    <option value="2">失物招领</option>
					 </select>  
		    </span>
			<span class="item-spans fl">排版类型：</span>
			 <span class="item-select fl">
			<select id="qtype" class="easyui-combobox" name="type">  
			    <option value="-1">--请选择排版类型--</option>   
			    <option value="1">大标题</option>   
			    <option value="2">小标题</option>   
			</select>
			</span>
				  <a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
			</div>
			<div class="item-col crbox">
			<span class="item-alink  f-blue fl"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
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
		   <table id ="girdNewsManage" ></table>
	    </div>
	</body>
	  <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
            <!-- ueditor footer -->
      <%@ include file="/webviews/common/ueditor.jsp"%>
      <script type="text/javascript" src="${appName}/commons/js/newsManage/newsManage.js"></script> 
</html>

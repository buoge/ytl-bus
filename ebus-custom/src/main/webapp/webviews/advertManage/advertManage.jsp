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
	   		<span class="item-alink  f-blue fl"  onclick="advertManageAdd();">新增</span>
			<span class="item-span  fl">图片类型：</span>
		    <span class="item-select fl">
			   <select id="type"  class="easyui-combobox"  name="type" >  
					    <option value="">--请选择图片类型--</option>   
					    <option value="1">屏闪</option>   
					     <option value="2">广告</option>  
					     <option value="3">新特性</option>  
					 </select>  
		    </span>
			<span class="item-span  fl">是否生效：</span>
			 <span class="item-select fl">
			<select id="isvalid" class="easyui-combobox" name="isvalid">  
					    <option value="">--请选择--</option>   
					    <option value="0">否</option>   
					    <option value="1">是</option>   
					 </select>
			</span>
			  <span class="item-span    fl">所属城市：</span>
			 <span class="item-select fl">
				<select id="cityChoose" name="citycode">  
				</select>
			</span>
			
		  <a id="query" href="javascript:void(0);" class="item-btn fl" >查询</a>
		</div>
		
		<div class="item-content" >
	        <table id ="girdAdvertManage" >   </table>
	    </div>
	</body>
	  <!-- common footer -->
      <%@ include file="/webviews/common/footer.jsp"%>
      <script type="text/javascript" src="${appName}/commons/js/advertManage/advertManage.js"></script> 
</html>

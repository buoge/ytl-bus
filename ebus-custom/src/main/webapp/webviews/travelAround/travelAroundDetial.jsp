
<%@ page language="java" pageEncoding="utf-8"%>
<link rel="stylesheet" href="${appName}/commons/lib/wangEditor/dist/css/wangEditor.css">
<link rel="stylesheet" href="travelimage.css">
      <div class="wrapper">
       <form id="editAdvertFrom"  enctype="multipart/form-data"   method="post" >
        <div class="item-line item-pad crbox"> 
        <span class="item-btn  fl"  onclick="closeActiveDetail()" id="closeActive">编辑基本信息</span> 
        <span class="item-btn  fl" onclick="closeBasicMessage()" id="closeBasic">编辑活动详情</span></div> 
           <div id="basicMessage">
           
             <div class="item-line item-pad crbox"> 
             <span class="item-span item-marl   fl">所属城市<strong class="f-red">*</strong>：</span>
			   <!--  <select id="dtcityChoose" name="cityCode"></select> -->
			  <input  type="text" class="item-input fl"  name="cityCode"  id="dtcityChoose" size=20  >
			  
			  </div>
		    <div class="item-line item-pad crbox">  
		    <span class="item-span  fl mr-44">标题<strong class="f-red">*</strong>:</span> 
		    <input type="text" class="item-input fl"  name="title" id="title" size=20>
		    </div>
		    <div class="item-line item-pad crbox"> 
		    <span class="item-span  fl mr-49">地点:</span> 
		    <input type="text" class="item-input fl"  name="location" id="location" size=20></div>
		    <div class="item-line item-pad crbox"> 
		     <span class="item-span  fl mr-49">简介:</span> 
		    <input type="text" class="item-input fl"  name="briefIntroduction" id="briefIntroduction" size=20></div>
		    <span class="item-span item-w60 fl">有效期：</span>
		    <label><input name="isPermanentValid" type="radio" value="0"  style="margin-left: 18px;"/>永久有效 </label> <br/><br/>
			 <label><input name="isPermanentValid" type="radio" value="1"  style=" margin-left: 103px;"/>自定义有效期 </label><br/>
			<div class="item-line item-pad crbox" style="margin-top: -42px;margin-left: 190px;">
			<span class="item-select item-time fl">
<!-- 			<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'endValidPeriod\')}'})" id='startValidPeriod'  name="startValidPeriod" size="15"/> -->
            <input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'endValidPeriod\')}'})" id='startValidPeriod'  name="startValidPeriod" size="15"/>
			<i class="Wdateico" ></i>
			</span>
			<span class="item-span  fl">至： </span>
			<span class="item-select item-time fl">
			<input class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'startValidPeriod\')}',startValidPeriod:'#F{$dp.$D(\'startValidPeriod\',{d:+1})}'})" id='endValidPeriod'  name="endValidPeriod" size="15"/>
			<i class="Wdateico" ></i>
			</div> 
			</span> 
			<div class="item-line item-pad crbox"> 
			<span class="item-span fl">出行日期<strong class="f-red">*</strong>： </span>
				<span class="item-select item-time fl">
				<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,})" id='tripDate'  name='tripDate'  size="15"/>
				 <i class="Wdateico" ></i>
			</span></div>
			<div class="item-line item-pad crbox"> 
		   <span class="item-span  fl mr-44">现价<strong class="f-red">*</strong>:</span> 
		   <input type="text" class="item-input fl"  name="currentPrice" id=" currentPrice" size=20>&nbsp;&nbsp;
		   <span class="item-span  fl mr-44">原价<strong class="f-red">*</strong>:</span>
		   <input type="text" class="item-input fl item-marl"  name="originalPrice" id="originalPrice" size=20></input><br/></div>
		   <div class="item-line item-pad crbox"> 	
		   <span class="item-span  fl mr-44">票数<strong class="f-red">*</strong>:</span> 
		   <input type="text" class="item-input fl"  name="ticketNum" id="ticketNum" size=20></div>
		   <div class="img-box full">
			<section class=" img-section">
				<span class="up-p item-marl">图片<strong class="f-red">*</strong>：</span>
				<div class="z_photo upimg-div clear" >
		                <section class="z_file fl">
		                    <img src="${appName}/commons/images/a11.png" tppabs="http://www.jq22.com/demo/imgUp201703281022/img/a11.png" class="add-img1" height="100" width="100">
		               	 	<input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple />
		               	 	<input type="hidden"  class="item-input  fl"  id='aicon_url' name='icon_url'/>
		               	 </section>
		                 <section class="z_file fl">
		                    <img src="${appName}/commons/images/a11.png" tppabs="http://www.jq22.com/demo/imgUp201703281022/img/a11.png" class="add-img2" height="100" width="100">
		               	 	<input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple />
		               	 	<input type="hidden"  class="item-input  fl"  id='aicon_url' name='icon_url'/>
		               	 </section>
		               	 <section class="z_file fl">
		                    <img src="${appName}/commons/images/a11.png" tppabs="http://www.jq22.com/demo/imgUp201703281022/img/a11.png" class="add-img3" height="100" width="100">
		               	 	<input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple />
		               	 	<input type="hidden"  class="item-input  fl"  id='aicon_url' name='icon_url'/>
		               	 </section>
		               	 <section class="z_file fl">
		                    <img src="${appName}/commons/images/a11.png" tppabs="http://www.jq22.com/demo/imgUp201703281022/img/a11.png" class="add-img4" height="100" width="100">
		               	 	<input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple />
		               	 	<input type="hidden"  class="item-input  fl"  id='aicon_url' name='icon_url'/>
		               	 </section>
		               	 <section class="z_file fl">
		                    <img src="${appName}/commons/images/a11.png" tppabs="http://www.jq22.com/demo/imgUp201703281022/img/a11.png" class="add-img5" height="100" width="100">
		               	 	<input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple />
		               	 	<input type="hidden"  class="item-input  fl"  id='aicon_url' name='icon_url'/>
		               	 </section>
		               	 </section>  	 	 
		         </div>
			 </section>
			 <div class="item-inblock">
             <span  onclick="closeBasicMessage();"  class="item-btn">下一步</span></div>
		 </div>
         <aside class="mask works-mask">
			<div class="mask-content">
				<p class="del-p">您确定要删除作品图片吗？</p>
				<p class="check-p"><span class="del-com wsdel-ok">确定</span><span class="wsdel-no">取消</span></p>
			</div>
		  </aside>
		  
		</div></div></div>	
	 </div>	
	 
	 <div id="activeDetail" style=" display:none">
	       <span class="item-select fl" data-options="multiple:true">关联专线：
				<select id="routeid" class="easyui-combobox" name="routename"></select>
			</span>
			 <!-- editor 富文本编辑器 -->
	            <div id="editor-container">
	                <br/><br/><span>活动详情<strong class="f-red">*</strong>：</span>
				    <div id="editor-trigger" class="editor" >
			        <p id="actinfomation">请输入内容</p>
				    </div>
			    </div>
			    <div >
                     <span>购票需知<strong class="f-red">*</strong>：</span>
                     <div id="editor-trigger2" class="editor" ><p id="ticketinfomation">请输入内容</p></div>
                     
                </div>
                <input type="hidden"  id='editContent' />
                <div class="item-pad  t-c crbox item-nomar" >
                  <div class="ite              m-inblock">
                  <span  onclick="publicClose();"   class="item-btn  gray-bg" >取消</span>
               </div>
              
	       </div>
	      
            </div>  
		</div>
	 	<div id="previewDialog" style="display:none ">
		  <!--  <div id="top" style="height:33%;background-color:#D29779"></div> -->
		
        </form>
      </div>
     <!-- shadow html -->
	<div class="shadow "> </div>
	<div class="preview ">
	     <div class="previewclose"><span class="previepic"  onclick="closeview();"></span></div>
	     <div class="previewconner"></div>
	</div>
 <script type="text/javascript" charset="utf-8" src="${appName}/commons/lib/wangEditor/dist/js/wangEditor.js"></script>
 <script type="text/javascript" src="${appName}/commons/js/travelAround/travelAroundEdit.js"></script>


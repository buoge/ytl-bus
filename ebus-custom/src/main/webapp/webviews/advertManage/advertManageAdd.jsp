<%@ page language="java" pageEncoding="utf-8"%>
      <div class="wrapper">
      <form id="addAdvertFrom"  enctype="multipart/form-data"   method="post" >
        <div class="item-line item-pad crbox">
          <span class="item-span item-marl  fl">图片类型：</span>
		    <span class="item-select fl">
			   <select id="type"  class="easyui-combobox"   name="type"  >  
					    <option value="0">--请选择图片类型--</option>   
					     <option value="1">屏闪图</option>
					    <option value="2">广告图</option>  
					     <option value="3">新特性</option>     
					 </select>  
		    </span>
		     <span class="item-span  fl">图片排序：</span>
			    <input type="text"  class="item-input  easyui-validatebox fl "   id='orderno'  name="orderno"  data-options="required:true,validType:['intlength','length[0,5]']" />
        </div>
        
        <div class="item-line item-pad crbox"> 
            <span class="item-span item-marl   fl">所属城市：</span>
			<span class="item-select fl">
			<select id="addAcityChoose" name=citycode>  
			</select>
			</span>
		</div>
		
        <div class="item-line item-pad crbox">
	            <span class="item-span  fl">生效时间： </span>
				<span class="item-select item-time fl">
				<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'enddate\')}'})" id='startdate'  name="startdate" size="15"/>
				 <i class="Wdateico" ></i>
				</span>
				<span class="item-span  fl">失效时间： </span>
				<span class="item-select item-time fl">
				<input class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'startdate\')}',startDate:'#F{$dp.$D(\'startdate\',{d:+1})}'})" id='enddate'  name="enddate" size="15"/>
				 <i class="Wdateico" ></i>
				</span>
			</div>
           <div class="item-line item-pad crbox">
	            <span class="item-span  fl">上传图片： </span>
	               <input type="text"  class="item-input  fileurl  fl"  />
	             
	              <div class="item-inputfile fl item-marl">
			         <input type="file"  id="imageName" onchange="choosefile(this)"  name="imageName"  accept="image/jpg,image/jpeg,image/png"  multiple/>
			          选择文件
			       </div>
			      <span class="item-btn " onclick="uploadfile('imageName','addAdvertFrom','aicon_url')">上传图片</span>
			     <span class="item-minbtn  red-bg item-marl" onclick="viewScan(this,'aicon_url')">预览</span>
			    <input type="hidden"  class="item-input  fl"  id='aicon_url' name='icon_url'/>
			    <input type="hidden" id="avdImage"  class="item-input  "  name="avdImage"  />
			</div>
			 <div class="item-line item-pad crbox">
	               <div class="fileview">
			          <img class="fileimg" src="">
			       </div>
			</div>		   
           <div class="item-pad  t-c crbox item-nomar" >
               <div class="item-inblock">
               <span  onclick="submitFrom();"  class="item-btn" >保存</span>
               <span  onclick="publicClose();"  class="item-btn  gray-bg" >取消</span>
               </div>
            </div>
            </form>
      </div>
     <!-- shadow html -->
	<div class="shadow "> </div>
	<div class="preview ">
	     <div class="previewclose"><span class="previepic"  onclick="closeview();"></span></div>
	     <div class="previewconner"></div>
	</div>
 



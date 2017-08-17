<%@ page language="java" pageEncoding="utf-8"%>
      <div class="wrapper">
       <form id="editAdvertFrom"  enctype="multipart/form-data"   method="post" >
         	<input type="text" id='id' name='id' hidden=true/>
        <div class="item-line item-pad crbox">
          <span class="item-span item-marl  fl">图片类型：</span>
		    <span class="item-select fl">
			   <select id="type"  class="easyui-combobox"  name="type" >  
					    <option value="0">--请选择图片类型--</option>   
					     <option value="1">屏闪图</option>
					    <option value="2">广告图</option>  
					     <option value="3">新特性</option>    
					 </select>  
		    </span>
		     <span class="item-span  fl">图片排序：</span>
		     <input type="text"  class="item-input  easyui-validatebox"   id='orderno'  name="orderno"  data-options="required:true,validType:['intlength','length[0,5]']" />
		</div>
        
        <div class="item-line item-pad crbox"> 
            <span class="item-span item-marl   fl">所属城市：</span>
			 <span class="item-select fl">
				<select id="acityChoose" name="citycode">  
				</select>
			</span>
		</div>
		
        <div class="item-line item-pad crbox">
	             <span class="item-span  fl">生效时间： </span>
				<span class="item-select item-time fl">
				<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'enddate\')}'})" id='startdate'  name="startdate" />
				 <i class="Wdateico" ></i>
				</span>
				<span class="item-span  fl">失效时间： </span>
				<span class="item-select item-time fl">
				<input class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'startdate\')}',startDate:'#F{$dp.$D(\'startdate\',{d:+1})}'})" id='enddate'  name="enddate" />
				 <i class="Wdateico" ></i>
				</span>
			</div>
           <div class="item-line item-pad crbox">
	            <span class="item-span  fl">上传图片： </span>
	              <input type="text" id="avdImage" name="icon_url" class="item-input  fileurl  fl"   />
	              <div class="item-inputfile fl item-marl">
			         <input type="file"  onchange="choosefile(this)"  name="imageName"  accept="image/jpg,image/jpeg,image/png"/>
			          选择文件
			       </div>
			       <span class="item-btn  item-disabled" onclick="uploadfile('avdImage','editAdvertFrom','aicon_url')">上传图片</span>
				  <span class="item-minbtn  red-bg item-marl" onclick="viewScan(this,'aicon_url')">预览</span>
			       <input type="hidden"  class="item-input  fl"  id='aicon_url'  name="avdImage" />
			</div>
			 <div class="item-line item-pad crbox">
	               <div class="fileview">
			              <img class="fileimg" src="">
			            </div>
					   
					</div>
           <div class="item-pad  t-c crbox item-nomar" >
                  <div class="item-inblock">
                  <span  onclick="submitEditFrom();"  class="item-btn" >编辑</span>
                  <span  onclick="publicClose();"   class="item-btn  gray-bg" >取消</span>
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
 <script type="text/javascript" src="${appName}/commons/js/advertManage/advertManageAdd.js"></script>


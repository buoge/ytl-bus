<%@ page language="java" pageEncoding="utf-8"%>
      <div class="wrapper">
      <form id="newsManageEditForm" method="post" enctype="multipart/form-data">
      <input type='hidden' id="eid" name='id'/>
        <div class="item-line crbox">
             <span class="item-span  fl">标题：</span>
			 <input type="text"  class="item-input  item-w250 fl easyui-validatebox" id='etitle' size="15" name="title" data-options="required:true"/>
	    </div>
	     <div class="item-line crbox">
             <span class="item-span  fl">图标：</span>
			 <input type="text"  class="item-input fileurl fl"   id='eavdImage'/>
			 <div class="item-inputfile fl item-marl">
			   <input type="file"  onchange="choosefile(this)"  name="imageName"  accept="image/jpg,image/jpeg,image/png"/>
			         选择图片
			 </div>
			<span class="item-btn " onclick="uploadfile('eavdImage','newsManageEditForm','eicon_url')">重新上传</span>
			<span class="item-btn  red-bg item-marl" onclick="viewScan(this,'eicon_url')">查看图片</span>
			<input type="hidden"  class="item-input  fl"  id='eicon_url' name='icon_url'/>
	    </div>
		<div class="item-line crbox">
          	 <span class="item-span item-marl  fl">类型：</span>
		    <span class="item-select fl">
			   <select id="enewsCategory"  class="easyui-combobox"  name="newsCategory" >  
					    <option value="1">公交动态</option> 
					    <option value="2">失物招领</option>   
					 </select>  
		    </span>
		     <span class="item-span item-marl   fl">排版类型：</span>
			 <span class="item-select fl">
				<select id="etype" class="easyui-combobox" name="type">  
					<option value="-2">无</option>
				    <option value="1">大标题</option>   
				    <option value="2">小标题</option>   
				 </select>
			</span>
			<span class="item-span  fl">城市： </span>
			<span class="item-select fl">
			<select id="ecityChoose" name="cityCode">  
			</select>
			</span>
        </div>
          <div class="item-pad crbox">
            <!-- editor 富文本编辑器 -->
              <div id="editor-container" >
			    <div id="editor-trigger" class="editor"><p>请输入内容</p></div>
			  </div>
          </div>
          <div class="item-pad  t-c crbox " >
               <div class="item-inblock">
	               <span class="item-btn" onclick="updateNews('newsManageEditForm');">保存</span>
	               <span onclick="publicClose();"  class="item-btn  gray-bg" >取消</span>
               </div>
            </div>
          <input type="hidden"  id='editContent' />
          </form>
      </div>
        <!-- shadow html -->
		<div class="shadow "> </div>
		<div class="preview ">
		     <div class="previewclose"><span class="previepic"  onclick="closeview();"></span></div>
		     <div class="previewconner"></div>
		</div>
<script type="text/javascript" src="${appName}/commons/js/newsManage/newsManageDetial.js"></script> 


<%@ page language="java" pageEncoding="utf-8"%>
      <div class="wrapper">
      <form id="newsManageDetailForm">
        <div class="item-line crbox">
            <span class="item-span  fl">标题：</span>
			<input type="text"  class="item-input  item-w250 fl"   id='dtitle' name='title'/>
	    </div>
	     <div class="item-line crbox">
             <span class="item-span  fl">图标：</span>
             <span class="item-btn  red-bg item-marl" onclick="viewScan(this,'dicon_url')">查看图片</span>
			  <input type="text"  class="item-input  item-w150 fl"  id='dicon_url' name='icon_url'/>
	    </div>
		<div class="item-line crbox">
          	<span class="item-span item-marl  fl">类型：</span>
		    <span class="item-select fl">
			    <select id="dnewsCategory"  class="easyui-combobox"  name="newsCategory" >  
			 	    <option value="-1">--请选择类型--</option>  
			 	    <option value="-2">无</option> 
				    <option value="1">公交动态</option> 
				    <option value="2">失物招领</option>   
			    </select>  
		    </span>
		    <span class="item-span item-marl   fl">排版类型：</span>
			<span class="item-select fl">
				<select id="dtype" class="easyui-combobox" name="type">  
				    <option value="-1">--请选择排版类型--</option>   
				    <option value="-2">无</option>
				    <option value="1">大标题</option>   
				    <option value="2">小标题</option>   
				</select>
			</span>
			<span class="item-span  fl">城市： </span>
			<span class="item-select fl">
				<!-- <select id="dcityChoose" name="cityCode">  	     
				</select> -->
				<input id="dcityChoose"  name="cityCode" >  
			</span>
        </div>
          <div class="item-pad crbox">
            <!-- editor 富文本编辑器 -->
            <div id="editor-container" >
			    <div id="editor-trigger" class="editor"></div>
			  </div>
          </div>
           <div class="item-pad  t-c crbox " >
               <div class="item-inblock">
               <span onclick="publicClose();"  class="item-btn  gray-bg" >取消</span>
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
<script type="text/javascript" src="${appName}/commons/js/newsManage/newsManageDetial.js"></script> 


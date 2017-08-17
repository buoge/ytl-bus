<%@ page language="java" pageEncoding="utf-8"%>
      <div class="wrapper">
      <form id="detialPublishForm" method="post" enctype="multipart/form-data">
	            <div class="item-line  crbox">
		              <span class="item-span item-w60   fl">驾校名称： </span>
					 <input type="text"  name="name"  class="item-input fl"  />
				       <span class="item-span   fl">城市： </span>
							<span class="item-select fl">
								<select id="publishChoose" name="cityCode">  
							    </select>
					</span>
	                   <span class="item-span   fl">联系电话：</span>
					   <input type="text" name="tel"  class="item-input fl"  />
				  </div>
	           <div class="item-line  crbox">
		              <span class="item-span item-w60  fl">驾校地址：</span>
					 <input type="text" name="location"  class="item-input item-w250 fl"  />
	           	</div>
               <div class="item-line  crbox">
                       <span class="item-span item-w60  fl">可学驾照：</span>
		               <label class="item-label fl crbox"><input  type="checkbox"   name="checkStatus"   value="1" class="item-check fl"><span class="item-em fl"  >A1</span></label>
			           <label class="item-label fl crbox"><input  type="checkbox"   name="checkStatus"  value="2"  class="item-check fl"><span class="item-em fl"  >A2</span></label>
			          <label class="item-label fl crbox"><input  type="checkbox"   name="checkStatus"  value="3" class="item-check fl"><span class="item-em fl"  >A3</span></label>
			          <label class="item-label fl crbox"><input  type="checkbox"   name="checkStatus"  value="4"  class="item-check fl"><span class="item-em fl"  >B1</span></label>
			          <label class="item-label fl crbox"><input  type="checkbox"   name="checkStatus"  value="5" class="item-check fl"><span class="item-em fl"  >B2</span></label>
			         <label class="item-label fl crbox"><input  type="checkbox"   name="checkStatus"  value="6"  class="item-check fl"><span class="item-em fl"  >C1</span></label>
			         <label class="item-label fl crbox"><input  type="checkbox"   name="checkStatus"  value="7" class="item-check fl"><span class="item-em fl"  >C2</span></label>
           	      <input type="hidden" id="acceptLicenses" class="item-input  " name="acceptLicenses">
           	    </div>
			      <div class="item-line  crbox">
			             <span class="item-span  fl">驾校照片：</span>
			             <span class="item-btn  red-bg item-marl" onclick="viewScan(this,'dicon_url')">查看图片</span>
						  <input type="text"  class="item-input  item-w150 fl"  id='dicon_url' name='image'/>
				    </div>
		       <div class="item-pad crbox">
	            <!-- editor 富文本编辑器 -->
	            <div id="editor-container" >
				    <div id="editor-trigger" class="editor"><p>请输入内容</p></div>
			    </div>
	          </div>
           <div class="item-pad  t-c crbox " >
                <div class="item-inblock">
               <span  onclick="publicClose();" class="item-btn  gray-bg" >取消</span>
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
<script type="text/javascript" src="${appName}/commons/js/drivingDecords/drivingPublishAdd.js"></script> 


<%@ page language="java" pageEncoding="utf-8"%>
<form id="cityIpAddForm" method="post" enctype="multipart/form-data">   
     <div class="wrapper">
        <div class="item-line crbox">
             <span class="item-span  fl">可上传ip：</span>
			 <input type="text"  class="item-input   fl easyui-validatebox"   id='serviceip' name='serviceip'  data-options="required:true,validType:['ip']" />
	    </div>
		<div class="item-line crbox">
          	 <span class="item-span item-marl  fl">上传次数：</span>
		     <input type="text"  class="item-input  fl  easyui-validatebox"   id='times' name='times'  data-options="required:true,validType:['intlength','length[0,6]']"  />
		</div>
		<div class="item-line crbox">
		     <span class="item-span item-marl  fl">城市名称：</span>
		     <input type="text"  class="item-input   fl easyui-validatebox"   id='cityname' name='cityname'  data-options="required:true,validType:['chinese']" />
		</div>
		<div class="item-line crbox">
		     <span class="item-span item-marl  fl ">城市代码：</span>
		     <input type="text"  class="item-input   fl easyui-validatebox"   id='citycode' name='citycode'  data-options="required:true,validType:['intlength']" />
        </div>
        <div class="item-line crbox">
		     <span class="item-span item-marl  fl ">权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限：</span>
		     <span class="item-select fl">
				 <select id="authority" class="easyui-combobox  name="authority“>      
					    <option value="0">资讯</option>   
					    <option value="1">资讯、专车、专线</option>   
				 </select>  
			 </span>
        </div>
         <div class="item-line crbox">
		     <span class="item-span  fl">城市图片：</span>
			 <input type="text"  class="item-input fileurl fl"   id='avdImage'/>
			 <div class="item-inputfile fl item-marl">
			   <input type="file"  onchange="choosefile(this)"  name="imageName"  accept="image/jpg,image/jpeg,image/png"/>
			         选择图片
			 </div>
			<span class="item-btn" onclick="uploadfile('avdImage','cityIpAddForm','aicon_url')">上传图片</span>
			<span class="item-minbtn  red-bg item-marl" onclick="viewScan(this,'aicon_url')">预览</span>
			 <input type="hidden"  class="item-input  fl"  id='aicon_url' name='imgurl'/>
	    </div>
	     <!-- shadow html -->
	<div class="shadow "> </div>
	<div class="preview ">
	     <div class="previewclose"><span class="previepic"  onclick="closeview();"></span></div>
	     <div class="previewconner"></div>
	</div>
        <div class="item-pad  t-c crbox " >
             <div class="item-inblock">
             <span  class="item-btn" onclick="commitCityIpConfigAdd();">保存</span>
             <span onclick="publicClose();"  class="item-btn  gray-bg" >取消</span>
             </div>
         </div>
     </div>
</form>   

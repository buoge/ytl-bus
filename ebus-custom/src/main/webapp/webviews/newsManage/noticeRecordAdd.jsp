<%@ page language="java" pageEncoding="utf-8"%>

 <form id="noticeRecordAddForm" method="post" enctype="multipart/form-data">

    <div class="wrapper">
        <div class="item-line crbox">
            <span class="item-spans item-w70  fl">内容：</span>
            <input type="text"  class="item-input item-w400  fl easyui-validatebox" id='acontent' name="content" data-options="required:true,validType:'length[1,60]'"  maxLength=60/>
        </div>
        <div class="item-line crbox">
            <span class="item-spans item-w70 item-marl  fl ">通知范围：</span>
		     <span class="item-select fl">
				 <select id="anoticeRange" class="easyui-combobox"  name="noticeRange">
					   <!--  <option value="1" >所有城市</option>
					    <option value="2" >全城</option>
					    <option value="3" >指定地点范围</option>
					    <option value="4">指定线路范围</option> -->
				 </select>
				  <input type="hidden" id="anoticeRangeVal" value=""/>
			 </span>
			 <input type="hidden" id="current" class="item-input" value=""/>
            <span class="item-spans item-w70 item-marl  fl ">紧急程度：</span>
		    <span class="item-select fl">
			 <select id="aimportantGrade" class="easyui-combobox"  name="importantGrade" >
				    <option value="1">一般</option>
				    <option value="2">较重要</option>
				    <option value="3">非常重要</option>
			 </select>
		   </span>
        </div>
       <div id="specifyScope" class="item-relative item-line" style="display:none" >
          <span class="item-spans item-w70 item-marl  fl ">选取范围;</span>
           <span class="item-select fl" >
			 <select id="arange" class="easyui-combobox"  name="range"  >
                    <option value="">请选取范围</option>
				    <option value="300">周围300米</option>
				    <option value="500">周围500米</option>
				    <option value="800">周围800米</option>
			 </select>
			 <br/><br/>
            </span>
            
            <div class="searchGeo" >
                <input type="text" id="address" class="item-input" autocomplete="off"  value=""/>
                
                <span class="item-minbtn" onclick="javascript:placeSearch()">定位</span>
                <span class="item-minbtn red-bg" id="tipsMarker" onclick="javascript:markMap()">标记</span>
                <span class="item-minbtn red-bg" id="deleteMarker" >删除标记</span>
                 
                <div class="item-row item-relative crbox">
                    <div id="result"  name="result" class="searchList" style="display:none;"></div>
                </div>
            </div>
         
                <div id="iCenter" class="mapContent" ></div>
      
           
       </div>
          <div id="chooseRouter" style="display:none;">
            <div class="item-line  crbox">
                <span class="item-spans item-w70 fl">选择线路:</span>
                <span class="item-select routerText fl">
		        <select id="routeStr"  name="routeStr" ></select>
		        <input type="hidden" id="noticePoints" name="noticePoints"/>
                </span>
            </div>
            <div class="item-line  crbox">
                <span class="item-spans item-w70 fl">已选择线路：</span>
                <input type="text"  id="LinesName"  class="item-input item-w400"/>
                <input type="hidden" id="LinesId"  class="item-input"/>
            </div>
          </div>
       <div class="item-pad  t-c crbox " >
            <div class="item-inblock">
                <span  class="item-btn" onclick="commitNoticeRecordAdd();">保存</span>
                <span onclick="publicClose();"  class="item-btn  gray-bg" >取消</span>
            </div>
       </div>
    </div>
</form>
<script src="http://webapi.amap.com/maps?v=1.3&key=6008d49517cbff8cdf61c00e7e9ef338"></script>
<script src="http://webapi.amap.com/js/marker.js"></script>
<script type="text/javascript" src="${appName}/commons/js/newsManage/noticeRecordAdd.js"></script> 


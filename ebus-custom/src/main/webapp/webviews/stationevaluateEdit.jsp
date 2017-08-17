<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <link rel="stylesheet" type="text/css" href="${appName}/commons/css/global.css">
<div id="detailsta_dialog" class="easyui-window hide" align="center" title="建议反馈回复" style="width:1120px;height:500px">
	<form id="detail_sta_form" class="item-from"   method="post"> 
		<input type="hidden" id="id" name="id"/>
		<div class="item-main item-marb60">
			<div class="item-line">   
		        <!-- <span class="item-span">线路:</span>   
		        <input class="easyui-validatebox item-input" type="text" name="routeName" disabled='disabled'/>  
		        <span class="item-span">车牌号:</span>     
		        <input class="easyui-validatebox item-input" type="text"  name="busPlateNumber" disabled='disabled'/> -->
		        <span class="item-span">评价人:</span>     
		        <input class="easyui-validatebox item-input" type="text"  name="username" disabled='disabled'/>
		        <span class="item-span">联系方式:</span>     
		        <input class="easyui-validatebox item-input" type="text"  name="contactinfo" disabled='disabled'/>
		        <span class="item-span">评价时间:</span>     
		        <input class="easyui-validatebox item-input" type="text"  name="createtime" disabled='disabled'/>
		      </div>
		    </div>   
			<div id="detailInfo"  class="item-line crbox" >
			</div>
			<div class="item-line " >   
	        	<span class="item-span">回复内容:</span> 
	            <textarea colspan='5'   class="item-textarea"  id="replyInDetailContent" name="replyInDetailContent" /></textarea>
	        </div>  
	        <div class=" t-c crbox item-postation   item-martb">
                <div class="item-inblock">
                 	<span  onclick="suggestDetial();" class="item-btn ">回复</span>
		           <span  onclick="closeDialog('detailsta_dialog')" class="item-btn gray-bg">取消</span>
               </div> 
            </div>  
		   </div> 
		   
	</form>
</div>
<!-- <div id="win_reply_dialog" class="easyui-window hide" align="center" title="快速回复" style="width:850px;height:470px">
	<form id="detail_win_reply_form" class="item-from" method="post"> 
		<input type="hidden" id="replyEntityId" name="id"/>  
	  <div class="item-main item-marb60">
			<div class="item-line">   
	        <span class="item-span">投诉人:</span>
	        <input class="easyui-validatebox item-input" type="text" name="username" disabled='disabled'/>  
	        
	       <span class="item-span">联系方式:</span>
	        <input class="easyui-validatebox item-input"  type="text" name="contactinfo" disabled='disabled'/> 
	        
	        <span class="item-span">投诉时间:</span>
	        <input class="easyui-validatebox item-input" type="text" name="createtime" disabled='disabled'/>
	    </div>   
		    <div class="item-line">  
		      <span class="item-span">回复内容:</span>   
		        <textarea colspan='5'   class="item-textarea"  id="systemContent" name="content"/></textarea>
		    </div>   
            </div>
            <div class="t-c crbox item-postation item-martb">
                <div class="item-inblock">
                 	<span  onclick="suggestReplay();" class="item-btn ">回复</span>
		           <span  onclick="closeDialog('win_reply_dialog')" class="item-btn gray-bg">取消</span>
               </div>
	    </div>
	</form>  
</div> -->
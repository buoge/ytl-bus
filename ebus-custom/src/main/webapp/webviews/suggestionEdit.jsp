<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <link rel="stylesheet" type="text/css" href="${appName}/commons/css/global.css">
<div id="detailWin_dialog" class="easyui-window hide" align="center" title="建议反馈回复" style="width:1120px;height:500px">
	<form id="detail_win_form" class="item-from"   method="post"> 
		<input type="hidden" id="id" name="id"/>
		<div class="item-main item-marb60">
			<div class="item-line">   
		        <span class="item-span">线路:</span>   
		        <input class="easyui-validatebox item-input" type="text" name="routeName" disabled='disabled'/>  
		        <span class="item-span">方向:&nbsp;&nbsp;&nbsp;</span>   
		        <input class="easyui-validatebox item-input" type="text" name="direction" disabled='disabled'/> 
		         <span class="item-span">位置:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>     
		        <input class="easyui-validatebox item-input" type="text"  name="position" disabled='disabled'/>
		        <span class="item-span">车牌号:</span>     
		        <input class="easyui-validatebox item-input" type="text"  name="busPlateNumber" disabled='disabled'/>
		        <span class="item-span">司机:</span>     
		        <input class="easyui-validatebox item-input" type="text"  name="driver" disabled='disabled'/>
		        <span class="item-span">评价人:</span>     
		        <input class="easyui-validatebox item-input" type="text"  name="comment" disabled='disabled'/>
		        <span class="item-span">评价时间:</span>     
		        <input class="easyui-validatebox item-input" type="text"  name="gmtCreate" disabled='disabled'/>
		        <span class="item-select ">评价维度：
		        <select id="akind" class="easyui-combobox"  name="kind" >
			        <option value="1" selected = true  >综合评价</option>
				    <!-- <option value="2">司机评价</option>
				    <option value="3">车辆评价</option>
				    <option value="4">站台评价</option> --> -->
			   </select> 
		       </span>
		       <div id="stars">
		      <span class="item-select fl area">车辆到站快： </span>
		      <ul class="star busArriveSpeedStar">
					    <li class="light"><a href="javascript:;">1</a></li>
					    <li><a href="javascript:;">2</a></li>
					    <li><a href="javascript:;">3</a></li>
					    <li><a href="javascript:;">4</a></li>
					    <li><a href="javascript:;">5</a></li>
				</ul> 
		       <span class="item-select fl area ">车内舒适度：</span>
			       <ul class="star comfortInBusStar">
					    <li class="light"><a href="javascript:;">1</a></li>
					    <li><a href="javascript:;">2</a></li>
					    <li><a href="javascript:;">3</a></li>
					    <li><a href="javascript:;">4</a></li>
					    <li><a href="javascript:;">5</a></li>
					</ul>
		        <span class="item-select fl area">司机服务好：</span>
			       <ul class="star  serviceForDriverStar">
					    <li class="light"><a href="javascript:;">1</a></li>
					    <li><a href="javascript:;">2</a></li>
					    <li><a href="javascript:;">3</a></li>
					    <li><a href="javascript:;">4</a></li>
					    <li><a href="javascript:;">5</a></li>
					</ul>
		       
		       <span class="item-select fl area">站台设施全：</span>
			       <ul class="star stationFacilitiesStar">
					    <li class="light"><a href="javascript:;">1</a></li>
					    <li><a href="javascript:;">2</a></li>
					    <li><a href="javascript:;">3</a></li>
					    <li><a href="javascript:;">4</a></li>
					    <li><a href="javascript:;">5</a></li>
					</ul>
		       <span class="item-select fl area">乘车点合理： </span>
			       <ul class="star  ridingPlaceReasonableStar">
					    <li class="light"><a href="javascript:;">1</a></li>
					    <li><a href="javascript:;">2</a></li>
					    <li><a href="javascript:;">3</a></li>
					    <li><a href="javascript:;">4</a></li>
					    <li><a href="javascript:;">5</a></li>
					</ul>
			</div>
		    </div>   
			<div id="detailInfo"  class="item-line crbox" >
			</div>
			<div class="item-line " >   
	        	<span class="item-span">回复内容:</span> 
	            <textarea colspan='5'   class="item-textarea"  id="replyInDetailContent" name="replyInDetailContent" /></textarea>
	        </div>  
	      
		   </div> 
		   <div class=" t-c crbox item-postation   item-martb">
                <div class="item-inblock">
                 	<span  onclick="suggestDetial();" class="item-btn ">回复</span>
		           <span  onclick="closeDialog('detailWin_dialog')" class="item-btn gray-bg">取消</span>
               </div>
            </div>
	</form>
</div>
<div id="win_reply_dialog" class="easyui-window hide" align="center" title="快速回复" style="width:850px;height:470px">
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
</div>
<script type="text/javascript">
        var num=finalnum = tempnum= 0;
		var lis = document.getElementsByTagName(".comfortInBusStar li");
		//num:传入点亮星星的个数
		//finalnum:最终点亮星星的个数
		//tempnum:一个中间值
		function fnShow(num) {
		    finalnum= num || tempnum;//如果传入的num为0，则finalnum取tempnum的值
		    for (var i = 0; i < lis.length; i++) {
		        lis[i].className = i < finalnum? "light" : "";//点亮星星就是加class为light的样式
		    }
		} 
</script> 	
 
<%@ page language="java" pageEncoding="utf-8"%>
      <div class="wrapper">
      <form id="linkDrivingForm" method="post" enctype="multipart/form-data">
          <div class="item-line crbox">
           <ul class="item-ul crbox">
              <li>
	              <span class="item-span item-w60  fl">报名人：</span>
				 <input type="text"  name="name"  class="item-input fl"  />
				 <input type="hidden" id="signupId"  name="signupId"  class="item-input fl"  />
		    </li>
              <li>
                   <span class="item-span item-w60 fl">性别：</span>
	                 <span class="item-select fl">
						 <select class="easyui-combobox"    name="sex" >  
						    <option value="0">男</option>   
						    <option value="1">女</option>   
						 </select>
				    </span>
              </li>
           </ul>
           <ul class="item-ul crbox">
              <li>
	              <span class="item-span item-w60  fl">年龄：</span>
				 <input type="text"  name="age"  class="item-input fl"  />
		    </li>
              <li>
                   <span class="item-span  item-w60 fl">手机号码：</span>
				   <input type="text"  name="tel"  class="item-input fl"  />
              </li>
           </ul>
              <ul class="item-ul crbox">
	              <li>
		              <span class="item-span item-w60 fl">报名时间：</span>
					 <input type="text" name="bmTime"  class="item-input fl"  disabled/>
			    </li>
	              <li>
	                   <span class="item-span item-w60  fl">联系人：</span>
					    <input type="text" name="contactPerson"  class="item-input fl"  />
	              </li>
           </ul>
           <ul class="item-ul crbox">
	              <li>
		              <span class="item-span  item-w60 fl">状态：</span>
					  <span class="item-select fl">
						 <select class="easyui-combobox"   name="status" >  
						    <option value="1">待联系</option>   
						    <option value="2">下次联系</option> 
						    <option value="3">已报名</option>  
						 </select>
				    </span>
			    </li>
	              
           </ul>
              <div class="item-ul  item-marb  crbox">
	            <span class="item-span  fl">联系时间： </span>
				<span class="item-select item-time fl">
				<input class="Wdate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" id='contactTime'  name="contactTimeStr" size="15"/>
				 <i class="Wdateico" ></i>
				</span>
			</div>
                 <div class="item-ul  item-marb crbox">
		              <span class="item-span  item-w60 fl">联系记录：</span>
					   	<span class=" item-editor fl">
						<textarea  class="item-textarea" name="contactRecord"></textarea>
						</span>
              </div>
	    </div>
	          
           <div class="item-pad  t-c crbox " >
                <div class="item-inblock">
               <span  onclick="linkDriving();"  class="item-btn">保存</span>
               <span  onclick="publicClose();" class="item-btn  gray-bg" >取消</span>
               </div>
            </div>

         </form>
      </div>
<script type="text/javascript" src="${appName}/commons/js/drivingDecords/drivingDecordsAdd.js"></script> 


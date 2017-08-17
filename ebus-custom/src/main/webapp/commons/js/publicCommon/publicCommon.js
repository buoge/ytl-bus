/*
 * creat by   wxl    2016/12/21
 * 
 * 常用的方法
 */

 /* 
  * 格式化日期的公用方法
 * 对Date的扩展，将 Date 转化为指定格式的String
* 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
* 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 

 调用：
 var time1 = new Date().format("yyyy-MM-dd");
 var time2 = new Date().format("yyyy-MM-dd hh:mm:ss");
 */
Date.prototype.Format = function (fmt) { 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

/**
 * 格式化日期，返回格式化后的字符串
 * @param dateValue Date值
 * @param pattern 格式，默认为 yyyy-MM-dd hh:mm:ss
 * @returns
 */
function formatDate(dateValue, pattern){
	if(!pattern){
		pattern = 'yyyy-MM-dd hh:mm:ss';
	}
	if(dateValue){
		return new Date(dateValue).Format(pattern);
	}
	return dateValue;
}

//公用的禁止方法
function publicDisabled(id){
	$('#'+id).find('input').attr("disabled","disabled");
	$('#'+id).find('select').attr("disabled","disabled");
	$('#'+id).find('.combobox-f').combobox('disable');
	$('#'+id).find('.Wdate').removeAttr("focus");
	$('#'+id).find('.item-disabled').removeAttr("click");
}
//公用的禁止方法除去combobox的
	function publicDisabledunBox(id,combox){
		$('#'+id).find('#'+combox).combobox('enable');
	}
//返回
function toBack(){
	history.go(-1);
}
//刷新当前页面
function gFunRefresh() {
    window.location.reload();
}
/**
 * 获取form表单input combox的值
 * @param  表单id   
 * @param  name值
 * @returns serializeObj对象
 */
$.fn.serializeObject=function(){  
	  var serializeObj={};  
	  var array=this.serializeArray();  
	  var str=this.serialize();  
	  $(array).each(function(){  
	      if(serializeObj[this.name]){  
	          if($.isArray(serializeObj[this.name])){  
	              serializeObj[this.name].push(this.value);  
	          }else{  
	              serializeObj[this.name]=[serializeObj[this.name],this.value];  
	          }  
	      }else{  
	          serializeObj[this.name]=this.value;   
	      }  
	  });  
	  return serializeObj;  
};
/**
 * 关闭dialog common
 * @param obj  dialog对象
 */
function closeDialog(obj){
	$("#"+obj).window('close');
}

/**
 * 添加一行
 * @param index  当前行号
 * @param defaultVal  默认值
 */
this.addRow = function(index,defaultVal){
    $("#"+gridName).datagrid("endEdit", rowIndex);
    $("#"+gridName).datagrid("insertRow",{
        index:parseInt(index)+1,
        row:$.extend({},defaultVal)
    });
    setTimeout(function(){
        $("#"+gridName).datagrid("loadData",$("#"+gridName).datagrid("getRows"));
    },10);
}
/**
 * 删除当前行
 * @param index     当前行号
 */
this.delRow = function(index){
    if( $("#"+gridName).datagrid("getRows").length==1){
        return;
    }
    $("#"+gridName).datagrid("endEdit", rowIndex);
    $("#"+gridName).datagrid("deleteRow",index);
    setTimeout(function(){
        $("#"+gridName).datagrid("loadData",$("#"+gridName).datagrid("getRows"));
    },10)
}
var diaTamp;
//dialog返回对象和id
function dialogCallback(obj){
	diaTamp=obj
}
/**
 * publicClose destroy的动态创建的dialog
 * @param datmp   dialog 对象
 */
function  publicClose(){
	diaTamp.dialog('destroy');
}

//表单验证
$.extend($.fn.validatebox.defaults.rules, {
    idcard: {// 验证身份证
        validator: function (value) {
            return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
        },
        message: '身份证号码格式不正确'
    },
    minLength: {
        validator: function (value, param) {
            return value.length >= param[0];
        },
        message: '请输入至少（2）个字符.'
    },
    leng: {
        validator: function (value, param) {
            return value.length == param[0];
        },
        message: '请输入{0}个字符.'
    },
    length: { validator: function (value, param) {
        var len = $.trim(value).length;
        return len >= param[0] && len <= param[1];
    },
        message: "输入内容长度必须介于{0}和{1}之间."
    },
    phone: {// 验证电话号码
        validator: function (value) {
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message: '格式不正确,请使用下面格式:020-88888888'
    },
    mobile: {// 验证手机号码
        validator: function (value) {
            return /^(13|15|18)\d{9}$/i.test(value);
        },
        message: '手机号码格式不正确'
    },
    intOrFloat: {// 验证整数或小数
        validator: function (value) {
            return /^\d+(\.\d+)?$/i.test(value);
        },
        message: '请输入数字，并确保格式正确'
    },
    int: {// 验证整数
        validator: function (value) {
            return /^\d+(\d+)?$/i.test(value);
        },
        message: '请输入数字，并确保格式正确'
    },
    intlength: {// 验证正整数
        validator: function (value) {
        	console.log(value);
            return /^[1-9]\d*$/i.test(value);
        },
        message: '请输入正整数'
    },
    currency: {// 验证货币
        validator: function (value) {
            return /^\d+(\.\d+)?$/i.test(value);
        },
        message: '货币格式不正确'
    },
    qq: {// 验证QQ,从10000开始
        validator: function (value) {
            return /^[1-9]\d{4,9}$/i.test(value);
        },
        message: 'QQ号码格式不正确'
    },
    integer0: {// 验证整数 可正负数
        validator: function (value) {
            //return /^[+]?[1-9]+\d*$/i.test(value);
            return /^[0|1]*$/i.test(value);
        },
        message: '请输入非负整数'
    },
    integer: {// 验证整数 可正负数
        validator: function (value) {
            //return /^[+]?[1-9]+\d*$/i.test(value);
            return /^([+]?[0-9])|([-]?[0-9])+\d*$/i.test(value);
        },
        message: '请输入整数'
    },
    url: {// 验证输入地址
        validator: function (value) {
        	var strRegex ='(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]';  
        	var reg=new RegExp(strRegex);   
            return reg.test(value);
        },
        message: '请输入正确的URL地址'
    },
    age: {// 验证年龄
        validator: function (value) {
            return /^(?:[1-9][0-9]?|1[01][0-9]|120)$/i.test(value);
        },
        message: '年龄必须是0到120之间的整数'
    },

    chinese: {// 验证中文
        validator: function (value) {
            return /^[\Α-\￥]+$/i.test(value);
        },
        message: '请输入中文'
    },
    english: {// 验证英语
        validator: function (value) {
            return /^[A-Za-z]+$/i.test(value);
        },
        message: '请输入英文'
    },
    
    unnormal: {// 验证是否包含空格和非法字符
        validator: function (value) {
            return /.+/i.test(value);
        },
        message: '输入值不能为空和包含其他非法字符'
    },
    title: {// 标题
        validator: function (value) {
            return /[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/i.test(value);
        },
        message: '只能输入中文、英文、数字'
    },
    username: {// 验证用户名
        validator: function (value) {
            return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
        },
        message: '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）'
    },
    faxno: {// 验证传真
        validator: function (value) {
            //            return /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/i.test(value);
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message: '传真号码不正确'
    },
    zip: {// 验证邮政编码
        validator: function (value) {
            return /^[1-9]\d{5}$/i.test(value);
        },
        message: '邮政编码格式不正确'
    },
    ip: {// 验证IP地址
        validator: function (value) {
            return /((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)/i.test(value);
        },
        message: 'IP地址格式不正确'
    },
    name: {// 验证姓名，可以是中文或英文
        validator: function (value) {
            return /^[\Α-\￥]+$/i.test(value) | /^\w+[\w\s]+\w+$/i.test(value);
        },
        message: '请输入姓名'
    },
    date: {// 验证姓名，可以是中文或英文
        validator: function (value) {
            //格式yyyy-MM-dd或yyyy-M-d
            return /^(?:(?!0000)[0-9]{4}([-]?)(?:(?:0?[1-9]|1[0-2])\1(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])\1(?:29|30)|(?:0?[13578]|1[02])\1(?:31))|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)([-]?)0?2\2(?:29))$/i.test(value);
        },
        message: '清输入合适的日期格式'
    },
    msn: {
        validator: function (value) {
            return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value);
        },
        message: '请输入有效的msn账号(例：abc@hotnail(msn/live).com)'
    },
    same: {
        validator: function (value, param) {
            if ($("#" + param[0]).val() != "" && value != "") {
                return $("#" + param[0]).val() == value;
            } else {
                return true;
            }
        },
        message: '两次输入的密码不一致！'
    }
});


//input路径input赋值
function choosefile(obj){
	
	var imgPath=$(obj).val();
	var $adImage =  $(obj).parents('.img-box').find('.fileurl');
	if($adImage.val() !=" "){
		$adImage.val($adImage.val() + "," + imgPath);
	}
	console.log($("#adImage").val());
	
}
/**
 * 图片上传 uploadfile
 * @param  id 文件选择inputval 值
 * @param  formId  表单id
 *  @param iconUrlId  图片上传后返回的路径存取的input id
 */
function uploadfile(id,formId,iconUrlId){
	console.log("id"+id);
	var imgPath=$('#'+id).val();
	//判断是否有选择上传文件
	  if (imgPath == "") {
		  $.messager.alert('系统提示','请选择要上传的图片！','info'); 
          return;
      }
	  var strExtension = imgPath.substr(imgPath.lastIndexOf('.') + 1).toLowerCase();
	   //判断上传文件的后缀名
     if (strExtension != 'jpg' && strExtension != 'gif' && strExtension != 'png' && strExtension != 'bmp') {
   	     $.messager.alert('系统提示','请选择图片文件','info'); 
         return;
     }
	$("#"+formId).form('submit',{
		url:appName+'/busnews/upload',
		onSubmit:function(param){
			$("#"+formId).form("enableValidation");
			if(!$("#"+formId).form("validate")){
				return false;
			}
		},
		success:function(msg){
			var result = $.parseJSON(msg);
			if(result.success){
				$.messager.alert('系统提示','成功','info');
				$("#"+iconUrlId).val(result.obj);
				var showUrl=$("#"+iconUrlId).val();
				 $('.fileimg').attr('src',showUrl);
				$("#avdImage").val(showUrl);
				$("#adImage").val(showUrl);
				
			}else{
				$.messager.alert('系统提示','info'); 
			}
		},
		error:function(){
			$.messager.alert('系统提示','抱歉，出错了。','info'); 
		}
	});
}
//图片预览
function viewScan(obj,iconId){
	var imgUrl=$(obj).next('#'+iconId).val();
	if(imgUrl == undefined || imgUrl == null || imgUrl == "") {
		$.messager.alert('系统提示','请先上传图片。','info'); 
		return false;
	}
	$('.preview').show();
	$('.shadow').show();
	$('.previewconner').css('background-image','url('+imgUrl+')');
}
//关闭预览
function closeview(){
	$('.preview').hide();
	$('.shadow').hide();
	$('.preview img').attr('src',' ');
}
/**
 * Created by zhanghuan on 2016/08/10.
 * 日期范围工具类
 */
var dateUtil = {
    /**
     * 添加开始时间
     */
    addStartTime:function(date){
        var result = new Date(date);
        var newResult = result.getFullYear() + "-" + this.parseDate(result.getMonth() + 1) + "-" + this.parseDate(result.getDate())+" 00:00";
        return new Date(newResult);
    },
    /**
     * 添加开始时间
     */
    addEndTime:function(date){
        var result = new Date(date);
        var newResult = result.getFullYear() + "-" + this.parseDate(result.getMonth() + 1) + "-" + this.parseDate(result.getDate())+" 23:59";
        return new Date(newResult);
    },
    /**
     * 获取系统当前时间
     * @returns {Date}
     */
    getCurrentDate:function () {
        return new Date();
    },
    getCurrentDateTime:function () {
    	 var result = new Date();
         var newResult = result.getFullYear() + "-" + this.parseDate(result.getMonth() + 1) + "-" + this.parseDate(result.getDate())+" 16:00";
         return new Date(newResult);
    },
    /**
     * 获取系统当前时间显示值，默认格式yyyy-MM-dd
     * @returns {string}
     */
    getCurrentDateStr:function (fmt) {
    	
    	//默认时间格式化
    	if(!fmt){
    		fmt = "yyyy-MM-dd hh:mm";
    	}
    	var d = this.getCurrentDate();
    	return dateUtil.addEndTime(d).format(fmt);
    },
    
    /**
     * 获取系统当前时间显示值，默认格式yyyy-MM-dd
     * @returns {string}
     */
    getCurrentDateDay:function (fmt) {
    	
    	//默认时间格式化
    	if(!fmt){
    		fmt = "yyyy-MM-dd";
    	}
    	var d = this.getCurrentDate();
    	return dateUtil.addEndTime(d).format(fmt);
    },
    
    /**
     * 获取当前日期前面几天或者后面几天
     * @returns {string}
     */
    getCurrDayPreOrNextDay:function(flag,dayParamater){
        var d = this.getCurrentDate();
        if(flag == "prev"){  //前面几天
            //当前日期的毫秒数 - 天数 * 一天的毫秒数
            var n = d.getTime() - dayParamater * 24 * 60 * 60 * 1000;
        }else if(flag == "next"){  //后面几天
            //当前日期的毫秒数 + 天数 * 一天的毫秒数
            var n = d.getTime() + dayParamater * 24 * 60 * 60 * 1000;
        }
        var result = new Date(n);
        return result.getFullYear() + "-" + this.parseDate(result.getMonth() + 1) + "-" + this.parseDate(result.getDate());
    },
    
    /**
     * 获取当前日期前面几天或者后面几天
     * @returns {Date}
     */
    getPreMonthDate:function(){
    	var d = this.getCurrentDate();
    	d.setMonth(d.getMonth()-1);
    	d.setDate(d.getDate()+1);
    	return d;
    },
    
    /**
     * 获取当前日期前面几天或者后面几天，默认格式yyyy-MM-dd
     * @returns {String}
     */
    getPreMonthDateStr:function(fmt){
    	//默认时间格式化
    	if(!fmt){
    		fmt = "yyyy-MM-dd hh:mm";
    	}
    	var d = this.getPreMonthDate();
    	return dateUtil.addStartTime(d).format(fmt);
    },
    
    /***
     * 获得本周起止时间
     */
    getCurrentWeek:function () {
        //起止日期数组
        var startStop = new Array();
        //获取当前时间
        var currentDate = this.getCurrentDate();
        //返回date是一周中的某一天
        var week = currentDate.getDay();
        //返回date是一个月中的某一天
        var month = currentDate.getDate();

        //一天的毫秒数
        var millisecond = 1000 * 60 * 60 * 24;
        //减去的天数
        var minusDay = week != 0 ? week - 1 : 6;
        //alert(minusDay);
        //本周 周一
        var monday = new Date(currentDate.getTime() - (minusDay * millisecond));
        //本周 周日
        var sunday = new Date(monday.getTime() + (6 * millisecond));
        //添加本周时间
        startStop.push(monday); //本周起始时间
        //添加本周最后一天时间
        startStop.push(sunday); //本周终止时间
        //返回
        return startStop;
    },
    /**
     * 获得上一周的起止日期
     * **/
    getPreviousWeek:function () {
        //起止日期数组
        var startStop = new Array();
        //获取当前时间
        var currentDate = this.getCurrentDate();
        //返回date是一周中的某一天
        var week = currentDate.getDay();
        //返回date是一个月中的某一天
        var month = currentDate.getDate();
        //一天的毫秒数
        var millisecond = 1000 * 60 * 60 * 24;
        //减去的天数
        var minusDay = week != 0 ? week - 1 : 6;
        //获得当前周的第一天
        var currentWeekDayOne = new Date(currentDate.getTime() - (millisecond * minusDay));
        //上周最后一天即本周开始的前一天
        var priorWeekLastDay = new Date(currentWeekDayOne.getTime() - millisecond);
        //上周的第一天
        var priorWeekFirstDay = new Date(priorWeekLastDay.getTime() - (millisecond * 6));

        //添加至数组
        startStop.push(priorWeekFirstDay);
        startStop.push(priorWeekLastDay);

        return startStop;
    },
    /***
     * 获得本月的起止时间
     */
    getCurrentMonth:function () {
        //起止日期数组
        var startStop = new Array();
        //获取当前时间
        var currentDate = this.getCurrentDate();
        //获得当前月份0-11
        var currentMonth = currentDate.getMonth();
        //获得当前年份4位年
        var currentYear = currentDate.getFullYear();
        //求出本月第一天
        var firstDay = new Date(currentYear, currentMonth, 1);


        //当为12月的时候年份需要加1
        //月份需要更新为0 也就是下一年的第一个月
        if (currentMonth == 11) {
            currentYear++;
            currentMonth = 0; //就为
        } else {
            //否则只是月份增加,以便求的下一月的第一天
            currentMonth++;
        }

        //一天的毫秒数
        var millisecond = 1000 * 60 * 60 * 24;
        //下月的第一天
        var nextMonthDayOne = new Date(currentYear, currentMonth, 1);
        //求出上月的最后一天
        var lastDay = new Date(nextMonthDayOne.getTime() - millisecond);

        //添加至数组中返回
        startStop.push(firstDay);
        startStop.push(lastDay);
        //返回
        return startStop;
    },
    /**
     * 返回上一个月的第一天Date类型
     * @param year 年
     * @param month 月
     **/
    getPriorMonthFirstDay:function (year, month) {
        //年份为0代表,是本年的第一月,所以不能减
        if (month == 0) {
            month = 11; //月份为上年的最后月份
            year--; //年份减1
            return new Date(year, month, 1);
        }
        //否则,只减去月份
        month--;
        return new Date(year, month, 1); ;
    },
    /**
     * 获得上一月的起止日期
     * ***/
    getPreviousMonth:function () {
        //起止日期数组
        var startStop = new Array();
        //获取当前时间
        var currentDate = this.getCurrentDate();
        //获得当前月份0-11
        var currentMonth = currentDate.getMonth();
        //获得当前年份4位年
        var currentYear = currentDate.getFullYear();
        //获得上一个月的第一天
        var priorMonthFirstDay = this.getPriorMonthFirstDay(currentYear, currentMonth);
        //获得上一月的最后一天
        var priorMonthLastDay = new Date(priorMonthFirstDay.getFullYear(), priorMonthFirstDay.getMonth(), this.getMonthDays(priorMonthFirstDay.getFullYear(), priorMonthFirstDay.getMonth()));
        //添加至数组
        startStop.push(priorMonthFirstDay);
        startStop.push(priorMonthLastDay);
        //返回
        return startStop;
    },
    /**
     * 获得该月的天数
     * @param year年份
     * @param month月份
     * */
    getMonthDays:function (year, month) {
        //本月第一天 1-31
        var relativeDate = new Date(year, month, 1);
        //获得当前月份0-11
        var relativeMonth = relativeDate.getMonth();
        //获得当前年份4位年
        var relativeYear = relativeDate.getFullYear();

        //当为12月的时候年份需要加1
        //月份需要更新为0 也就是下一年的第一个月
        if (relativeMonth == 11) {
            relativeYear++;
            relativeMonth = 0;
        } else {
            //否则只是月份增加,以便求的下一月的第一天
            relativeMonth++;
        }
        //一天的毫秒数
        var millisecond = 1000 * 60 * 60 * 24;
        //下月的第一天
        var nextMonthDayOne = new Date(relativeYear, relativeMonth, 1);
        //返回得到上月的最后一天,也就是本月总天数
        return new Date(nextMonthDayOne.getTime() - millisecond).getDate();
    },
    /**
     * 得到本季度开始的月份
     * @param month 需要计算的月份
     ***/
    getQuarterSeasonStartMonth:function (month) {
        var quarterMonthStart = 0;
        var spring = 0; //春
        var summer = 3; //夏
        var fall = 6;   //秋
        var winter = 9; //冬
        //月份从0-11
        if (month < 3) {
            return spring;
        }

        if (month < 6) {
            return summer;
        }

        if (month < 9) {
            return fall;
        }

        return winter;
    },
    /**
     * 获得本季度的起止日期
     */
    getCurrentSeason:function () {
        //起止日期数组
        var startStop = new Array();
        //获取当前时间
        var currentDate = this.getCurrentDate();
        //获得当前月份0-11
        var currentMonth = currentDate.getMonth();
        //获得当前年份4位年
        var currentYear = currentDate.getFullYear();
        //获得本季度开始月份
        var quarterSeasonStartMonth = this.getQuarterSeasonStartMonth(currentMonth);
        //获得本季度结束月份
        var quarterSeasonEndMonth = quarterSeasonStartMonth + 2;

        //获得本季度开始的日期
        var quarterSeasonStartDate = new Date(currentYear, quarterSeasonStartMonth, 1);
        //获得本季度结束的日期
        var quarterSeasonEndDate = new Date(currentYear, quarterSeasonEndMonth, this.getMonthDays(currentYear, quarterSeasonEndMonth));
        //加入数组返回
        startStop.push(quarterSeasonStartDate);
        startStop.push(quarterSeasonEndDate);
        //返回
        return startStop;
    },
    /**
     * 得到上季度的起始日期
     * year 这个年应该是运算后得到的当前本季度的年份
     * month 这个应该是运算后得到的当前季度的开始月份
     * */
    getPriorSeasonFirstDay:function (year, month) {
        var quarterMonthStart = 0;
        var spring = 0; //春 0,1,2
        var summer = 3; //夏 3,4,5
        var fall = 6;   //秋 6,7,8
        var winter = 9; //冬 9,10,11
        //月份从0-11
        switch (month) {//季度的其实月份
            case 0:
            case 1:
            case 2:
                //如果是第一季度则应该到去年的冬季
                year--;
                month = winter;
                break;
            case 3:
            case 4:
            case 5:
                month = spring;
                break;
            case 6:
            case 7:
            case 8:
                month = summer;
                break;
            case 9:
            case 10:
            case 11:
                month = fall;
                break;

        };

        return new Date(year, month, 1);
    },
    /**
     * 得到上季度的起止日期
     * **/
    getPreviousSeason:function(){
        //起止日期数组
        var startStop = new Array();
        //获取当前时间
        var currentDate = this.getCurrentDate();
        //获得当前月份0-11
        var currentMonth = currentDate.getMonth();
        //获得当前年份4位年
        var currentYear = currentDate.getFullYear();
        //上季度的第一天
        var priorSeasonFirstDay = this.getPriorSeasonFirstDay(currentYear, currentMonth);
        //上季度的最后一天
        var priorSeasonLastDay = new Date(priorSeasonFirstDay.getFullYear(), priorSeasonFirstDay.getMonth() +2, this.getMonthDays(priorSeasonFirstDay.getFullYear(), priorSeasonFirstDay.getMonth() +2));
        //添加至数组
        startStop.push(priorSeasonFirstDay);
        startStop.push(priorSeasonLastDay);
        return startStop;
    },
    /***
     * 得到本年的起止日期
     *
     */
    getCurrentYear:function () {
        //起止日期数组
        var startStop = new Array();
        //获取当前时间
        var currentDate = this.getCurrentDate();
        //获得当前年份4位年
        var currentYear = currentDate.getFullYear();

        //本年第一天
        var currentYearFirstDate = new Date(currentYear, 0, 1);
        //本年最后一天
        var currentYearLastDate = new Date(currentYear, 11, 31);
        //添加至数组
        startStop.push(currentYearFirstDate);
        startStop.push(currentYearLastDate);
        //返回
        return startStop;
    },
    /**
     * //如果数据小于10.加一个0
     * @param date
     * @returns {*}
     */
    parseDate:function(date) {
        if (date < 10) {
            date = '0' + date;
        }
        return date;
    }
}
//计算datagrid table的高度
function setDatagirdTable(){
	var win=$(window).height();
	var  item=$('.item-header').height();
	var table=win-62-item+75;
	return table;
}
//计算datagrid table的高度
function setDatagirdTables(){
	var win=$(window).height();
	var  item=$('.item-header').height();
	var table=win-62-item+125;
	return table;
}
// localStorage 存值永久有效
window.localStorageUtil = {
	setLocalStorageItem:function(localName,localObj){ //设置存储数据，传入key和value；key是任意的字符串，value是一个object
		localStorage.setItem(localName,JSON.stringify(localObj));
	},
	getLocalStorageItem:function(localName){ //获取存储数据，传入之前设置的key
		var data = JSON.parse(localStorage.getItem(localName));
  		return data;
	},
	delLocalStorageItem:function(localName){ //删除存储数据，传入之前设置的key
		localStorage.removeItem(localName);
	},
	clearStorageItem:function(){ //清空所有存储数据
		localStorage.clear()
	}
}

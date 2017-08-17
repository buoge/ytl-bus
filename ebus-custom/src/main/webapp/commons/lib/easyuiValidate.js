$.extend($.fn.validatebox.defaults.rules,{    
    equals: {    
        validator: function(value,param){    
            return value == $(param[0]).val();    
        },    
        message: '两次输入的密码必须一致。'   
    },
    phone: {
    	validator: function(value){
    		var phoneRegWithArea = /^[0][1-9]{2,3}-[0-9]{5,10}$/; 
    		var phoneRegWithArea2 = /^[0][1-9]{2,3}[0-9]{5,10}$/; 
			var phoneRegNoArea = /^[1-9]{1}[0-9]{5,8}$/;   
			var mobileReg=/^1[3-8]+\d{9}$/;  
            return phoneRegWithArea.test(value)||phoneRegWithArea2.test(value)||phoneRegNoArea.test(value)||mobileReg.test(value);
        },    
        message: '请输入正确的联系方式。' 
    },
    number: {
    	validator: function(value){
            return !isNaN(value);
        },    
        message: '请输入数值。' 
    },
    img: {
    	validator: function(value){
    		var index = value.indexOf(".");
    		var ext = value.substring(index+1);
            return ext=="jpg"||ext=="jpeg"||ext=="png"||ext=="bmp"||ext=="JPG"||ext=="JPEG"||ext=="PNG"||ext=="BMP";
        },    
        message: '只能上传jpg,jpeg,png,bmp格式的图片。'
    },
     maxLength: {    
        validator: function(value, param){    
            return value.length <= param[0];    
        },    
        message: '最多输入{0}个字，已超出上限。'   
    },
    area: {    
        validator: function(value,param){ 
            return value != '--请选择--';    
        },    
        message: '请选择地区。'   
    },
    IdNum: {
    	validator: function(value){
    		var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
    		return reg.test(value);
    	},
    	message: '请输入正确格式的身份证号码。'
    }
});
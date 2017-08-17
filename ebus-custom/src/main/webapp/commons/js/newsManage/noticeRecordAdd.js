var appName=$('#appName').val();
//定义全局变量初始值


var routerStrName="";
var routerStrId="";
var noticePointsArr=[];


//通知范围 combobox
$('#anoticeRange').combobox({
	 onSelect: function(){ 
		  var val=$('#anoticeRange').combobox('getValue');
		  if(val==3){
			  $("#specifyScope").show();
			  $("#chooseRouter").hide();
			  //根据地址地图初始化
			  getCity();
		  }
		  else if(val==4){
			  $("#chooseRouter").show();
			  $("#specifyScope").hide();
			  routerList();
		  }
		  else if(val==2){
			  $("#chooseRouter").hide();
			  $("#specifyScope").hide();
			  $('#arange').combobox('setValue',null);
			 $('#LinesName').val("")
			  
		  }
		  
	 }	
})

var userName = localStorageUtil.getLocalStorageItem("userNas");
if(userName=="admin"){
	$('#anoticeRange').combobox('setValue','1');
	$('#anoticeRange').combobox('setText','所有城市');	
}else{
     var areaData, json;
	 json = '[{"id":"全城","text":"全城","value":"2","selected":true},{"id":"指定地点范围","text":"指定地点范围","value":"3"},{"id":"指定线路范围","text":"指定线路范围","value":"4"}]';
	 areaData = $.parseJSON(json);
	 $("#anoticeRange").combobox("loadData", areaData);
	 $('#anoticeRangeVal').val($('#anoticeRange').combobox('getValue'));
}

//线路下拉列表combobox
function routerList(){
	$('#routeStr').combobox({
		method:'get',
		url:appName+'/baseRoute/routes',
   	    valueField:'routeid',
		textField:'routename',
		mode:'remote',
		loadFilter:function(data){
			if(data.success) {
				data.obj[0].selected = true;
				 $('#LinesName').val();
				 $('#LinesId').val();
				return data.obj;
			}else{
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
		}
	 });
}
//线路选择赋值
$('#routeStr').combobox({
	    onHidePanel:function(){  
			var _options = $(this).combobox('options');  
			var _data = $(this).combobox('getData');/* 下拉框所有选项 */
			console.log(_data);
			var _value = $(this).combobox('getValue');/* 用户输入的值 */
			console.log(_value); 
			var _b = false;/* 标识是否在下拉列表中找到了用户输入的字符 */  
			for (var i = 0; i < _data.length; i++) {  
			    if (_data[i][_options.valueField] == _value) {  
			        _b=true;  
			        break;  
			    }  
			}  
			if(!_b){  
			    $(this).combobox('setValue', '');  
		  }  
		},  
	    onSelect:function(){ 
		 var text=$('#routeStr').combobox('getText');
		 var val=$('#routeStr').combobox('getValue');
		 routerStrName+=text+',';
		 routerStrId+=val+',';
		 $('#LinesName').val(routerStrName.substring(0,routerStrName.length-1));
		 $('#LinesId').val(routerStrId.substring(0,routerStrName.length-1));
	 }
})

//map  
var mapObj;
var marker = new Array();  
var windowsArr = new Array();
var cloudDataLayer;
var MSearch;  
var keyword;
var geocoder;
var openOrlock = false;
var markerArea=[];
var markerAreaBj=[];
var markerBj=[];

//初始化地图
function mapInit(cityNames){
	if(!cityNames){	
		return
	}
	mapObj = new AMap.Map('iCenter', {
         level: 11,//地图显示的比例尺级别
         resizeEnable: true
     });
	 mapObj.setCity(cityNames);
     AMap.event.addListener(mapObj, 'click', getLnglat); //点击事件	
     AMap.event.addDomListener(marker, 'click', function() {
    	 marker.getMap();
     }, false);
     //加载输入提示插件  
     mapObj.plugin(["AMap.Autocomplete"], function() {
         //判断是否IE浏览器  
         if (navigator.userAgent.indexOf("MSIE") > 0) {
             document.getElementById("address").onpropertychange = autoSearch;
         } else {
             document.getElementById("address").oninput = autoSearch;
         }
     });

}
function getCity(){
	$.ajax({
		url:appName+'/notice/getCityName',
		cache : false,
		type :'get',
		success : function(data) {
			var result = $.parseJSON(data);
			if (result.success) {
			   mapInit(result.obj);
			}
		}
	});
}
//是否可以标记
function markMap(){
   if (openOrlock ) {
       openOrlock = false;
       $('#tipsMarker').addClass('red-bg');
      
   }else {
	   $('#tipsMarker').removeClass('red-bg');
       openOrlock = true;
   }

}   
//鼠标点击，获取经纬度坐标  
function getLnglat(e) {
   var x = e.lnglat.getLng();
   var y = e.lnglat.getLat();
  if (openOrlock) {
       addMarkerforMap(x,y);
       getPotion(x,y);
  }
   var NoticePoint = new Object();
	NoticePoint.latitude=x;
	NoticePoint.longitude=y;
	noticePointsArr.push(NoticePoint)
}
//标记marker  
function addMarkerforMap(x,y){  
  // mapObj.clearMap();
 var markerClick=new AMap.Marker({
   map:mapObj,  
   icon:appName+'/commons/images/marker.png',
   position:new AMap.LngLat(x,y)  
   });  
   markerClick.setMap(mapObj);  //在地图上添加点  
	 
   //小于30个点往marker 数组添加marker
   if(marker.length<=30){  
	   markerBj.push(markerClick);  
   }
 //存储点击marker的坐标值  
   AMap.event.addListener(markerClick, "click", function(){
	   markerClick.setIcon(appName+'/commons/images/markers.png');
	   markerAreaBj.push(markerClick.getPosition()); 
   });  
   //删除指定标记Marker
   AMap.event.addDomListener(document.getElementById('deleteMarker'), 'click', function() {
 	for(var i=0;i<markerBj.length;i++){
 		var markerData=markerBj[i].getPosition();
 		for(var j=0;j<markerAreaBj.length;j++){
 			if(markerData.I==markerAreaBj[j].I&&markerData.M==markerAreaBj[j].M&&markerData.lng==markerAreaBj[j].lng&&markerData.lat==markerAreaBj[j].lat){
 				markerBj[i].setMap(null);
 			}
 		}
 	   
 	}
   }, false);
}  
//清空地图上所有覆盖物
function clearMap(){	
	mapObj.clearMap();	
}

//反馈地理位置
function getPotion(x,y) {
         var lnglatXY=new AMap.LngLat(x,y);
       //加载地理编码插件 
 mapObj.plugin(["AMap.Geocoder"],function(){  
   geocoder=new AMap.Geocoder({ 
   radius:1000, //以已知坐标为中心点，radius为半径，返回范围内兴趣点和道路信息 
   extensions: "all"//返回地址描述以及附近兴趣点和道路信息，默认"base" 
});       
 //逆地理编码 
   geocoder.getAddress(lnglatXY,function(status,result){
   if (status === 'complete' && result.info === 'OK') {
            document.getElementById("address").value = result.regeocode.formattedAddress;
         }
   }); 
 }); 
}
function clearCloud(){
	cloudDataLayer.setMap(null);
	mapObj.clearMap();	
}
//添加marker&infowindow      
function addmarker(i, d) {  
	var lngX; 
	var latY;
	var iName;
	var iAddress;
	if(d.location){
		lngX = d.location.getLng();  
		latY = d.location.getLat();  
	}else{
		lngX = d._location.getLng();  
		latY = d._location.getLat(); 
	}
	if(d.name){
		iName = d.name;
	}else{
		iName = d._name;
	}
	if(d.name){
		iAddress = d.address;
	}else{
		iAddress = d._address;
	}
  var markerOption = {  
      map:mapObj,  
      icon:appName+'/commons/images/marker.png',  
      position:new AMap.LngLat(lngX, latY)  
  };  
  var mar= new AMap.Marker(markerOption); 
  //小于30个点往marker 数组添加marker
  if(marker.length<=30){  
	  marker.push(mar);  
  }
  var infoWindow = new AMap.InfoWindow({  
      content:"<h3><font color=\"#00a6ac\">" + (i + 1) + ". " + iName + "</font></h3>" + TipContents(d.type, iAddress, d.tel),  
      size:new AMap.Size(300, 0),   
      autoMove:true,    
      offset:new AMap.Pixel(0,-30)  
  });  
  windowsArr.push(infoWindow);   
  var aa = function (e) {infoWindow.open(mapObj, mar.getPosition());};  
//存储点击marker的坐标值  
  AMap.event.addListener(mar, "click", function(){
	   mar.setIcon(appName+'/commons/images/markers.png');
	   markerArea.push(mar.getPosition());
  });  
  //删除指定标记Marker
  AMap.event.addDomListener(document.getElementById('deleteMarker'), 'click', function() {
	for(var i=0;i<marker.length;i++){
		var markerData=marker[i].getPosition();
		for(var j=0;j<markerArea.length;j++){
			if(markerData.I==markerArea[j].I&&markerData.M==markerArea[j].M&&markerData.lng==markerArea[j].lng&&markerData.lat==markerArea[j].lat){
				  marker[i].setMap(null);
			}
		}
	   
	}
  }, false);
}  

//输入提示  
function autoSearch() {
  var keywords = document.getElementById("address").value;
  if (keywords == "") {
      document.getElementById("result").innerHTML = "";
      return;
  }
  var auto;
  var autoOptions = {
      pageIndex: 1,
      pageSize: 10,
      city: "" //城市，默认全国  
  };
  auto = new AMap.Autocomplete(autoOptions);
  //查询成功时返回查询结果  
  AMap.event.addListener(auto, "complete", autocomplete_CallBack);
  auto.search(keywords);
}
//输出输入提示结果的回调函数  
function autocomplete_CallBack(data) {
//显示查询结果
 $("#result").show();
  var resultStr = "";
  var tipArr = [];
  if(data.info="ok"){
	  tipArr = data.tips;
	  if (tipArr.length>=0) {
	      for (var i = 0; i < tipArr.length; i++) {
	     	 resultStr += "<ul><li onclick='selectResult(" + i + ")'><span class='item-em'>"+tipArr[i].name+"</span><span  class='item-em'>" + tipArr[i].district+"</span></li></ul>";  
	       }
	     } 
  }
  else{
	  resultStr = " π__π 亲,人家找不到结果!<br />要不试试：<br />1.请确保所有字词拼写正确<br />2.尝试不同的关键字<br />3.尝试更宽泛的关键字";
  }
  document.getElementById("result").innerHTML = resultStr;
}
//关键词查询
function placeSearch() {  
	clearMap();
	 keyword = document.getElementById("address").value;
	   mapObj.plugin(["AMap.PlaceSearch"], function() {
         MSearch = new AMap.PlaceSearch({ //构造地点查询类  
             pageSize: 10,
             pageIndex: 1,
             city: "021" //城市  
         });
         AMap.event.addListener(MSearch, "complete", Search_CallBack); //返回地点查询结果  
         MSearch.search(keyword); //关键字查询  
  });  
}       
//回调函数  
function Search_CallBack(data) {  
  var resultStr = "";  
  var poiArr = data.poiList.pois;  
  var resultCount = poiArr.length;  
  for (var i = 0; i < resultCount; i++) {  
      resultStr += "<ul><li onclick='selectResult(" + i + ")'>" + poiArr[i].name+"</li></ul>";  
     // resultStr += TipContents(poiArr[i].type, poiArr[i].address, poiArr[i].tel) + "</li></ul></div>";  
      addmarker(i, poiArr[i]);  
  }  
  document.getElementById("result").innerHTML = resultStr;  
  mapObj.setFitView();  
}  
//从输入提示框中选择关键字并查询  
function selectResult(index) {
  if (navigator.userAgent.indexOf("MSIE") > 0) {
      document.getElementById("address").onpropertychange = null;
      document.getElementById("address").onfocus = focus_callback;
  }
  //截取输入提示的关键字部分  
  var text = $('.searchList ul li').eq(index).text();
  $("#address").val(text);
  $("#result").hide();
  //根据选择的输入提示关键字查询  
  mapObj.plugin(["AMap.PlaceSearch"], function() {
      var msearch = new AMap.PlaceSearch(); //构造地点查询类  
      AMap.event.addListener(msearch, "complete", Search_CallBack); //查询成功时的回调函数  
      msearch.search(text); //关键字查询查询  
  });
}

//定位选择输入提示关键字  
function focus_callback() {
  if (navigator.userAgent.indexOf("MSIE") > 0) {
      document.getElementById("address").onpropertychange = autoSearch;
  }
}


function TipContents(type, address, tel) {  //窗体内容  
  if (type == "" || type == "undefined" || type == null || type == " undefined" || typeof type == "undefined") {  
      type = "暂无";  
  }  
  if (address == "" || address == "undefined" || address == null || address == " undefined" || typeof address == "undefined") {  
      address = "暂无";  
  }  
  if (tel == "" || tel == "undefined" || tel == null || tel == " undefined" || typeof address == "tel") {  
      tel = "暂无";  
  }  
  var str = "&nbsp;&nbsp;地址：" + address + "<br />&nbsp;&nbsp;电话：" + tel + " <br />&nbsp;&nbsp;类型：" + type;  
  return str;  
}  
function openMarkerTipById1(pointid, thiss) {  //根据id 打开搜索结果点tip  
  thiss.style.background = '#CAE1FF';  
  windowsArr[pointid].open(mapObj, marker[pointid]);  
}  
function onmouseout_MarkerStyle(pointid, thiss) { //鼠标移开后点样式恢复  
  thiss.style.background = "";  
} 
//输入提示框鼠标滑过时的样式  
function openMarkerTipById(pointid, thiss) {  //根据id打开搜索结果点tip    
  thiss.style.background = '#CAE1FF';  
}  

//输入提示框鼠标移出时的样式  
function onmouseout_MarkerStyle(pointid, thiss) {  //鼠标移开后点样式恢复    
  thiss.style.background = "";  
}  
//通知记录新增页面表单提交
function commitNoticeRecordAdd(){
    var acontent_val=$("#acontent").val();
	var anoticeRange_val=$('#anoticeRangeVal').val();
	console.log(anoticeRange_val);
	var aimportantGrade_val=$('#aimportantGrade').combobox('getValue');
	var arange_val=$('#arange').combobox('getValue');
	var LinesName_val=$('#LinesName').val();
	var LinesId_val=$('#LinesId').val();
	if(acontent_val== undefined ||acontent_val.trim() == '') {
		$.messager.alert('系统提示','<div class="item-errortip">内容不能为空','info'); 
		return false;
	};
	if(userName=="admin"){
		anoticeRange_val=1;
	}
	if(anoticeRange_val== undefined || anoticeRange_val=="" ) {
			$.messager.alert('系统提示','<div class="item-errortip">选择范围不能为空','info'); 
			return false;
	};
	

	var params={
		content:acontent_val,
		noticeRange:anoticeRange_val,
		importantGrade:aimportantGrade_val,
		distanceRange:arange_val,
		routeStr:LinesId_val,
		routeStrName:LinesName_val,
		noticePoints:noticePointsArr,
	}

	$.ajax({
		url : appName+'/notice/add',
		cache : false,
		type : 'post',
		data:JSON.stringify(params),
		contentType: "application/json; charset=utf-8",
		dataType : 'json',
		success : function(r) {
			if (r.success) {
				$.messager.alert('系统提示','添加成功','info',function(){
					$("#noticeRecordAddForm")[0].reset();
					$('#girdNoticeRecord').datagrid("reload");
					publicClose();
				});
			} else {
				
				$.messager.alert('系统提示',r.msg,'info');
			}
 		}
	})
	
};
/*  wxl   2016 2/27 
 * initCityGuideMap
 */
$(function(){
	// map   init
	  initCityGuideMap()  

});
var appName=$('#appName').val();

//点击查询
function searchMap(){
	 var cityCode=$("#cityChoose").combobox('getValue');
	 if(cityCode==-1){
		 var params=""
	 }
	 else{
		 var params="cityCode="+cityCode
	 }
	initCityGuideMap(params);
	 console.log(params)
}

//地图marker 图线绘制坐标设置
function initCityGuideMap(params) {
 var markers = [];
 var marker1;
 var content;
 var content1="";
 var peopleTotle=0;
 var map= new AMap.Map('initMapData', {  
      resizeEnable: true,   
      center: [109.40088387868494, 24.361884570608733],//地图中心点
      zoom:13
     }); 
$.ajax({
		type:"POST",
		url:appName+"/stat/od",
		data:params,
		success:function(result){
			var data = $.parseJSON(result);
			if(data.success){
				console.log(data);
				//地图数据处理
				var obj=data.obj,len2;
				var arrPosition=[],start,end,content,angle,image;
			   for (var i = 0,len=obj.length; i <len; i++) {
				   if(!obj[i].ignore) {// 如果该导向图可被忽略，解析下一条
				    start = obj[i].start;//起点
				    end =  obj[i].end;//终点
				    angle= obj[i].angle;//旋转角度
				    peopleTotle+= parseInt(obj[i].persons);
				 
				    	 var loncenter=( parseFloat(start.lon)+parseFloat(end.lon))/2;//方向终点
						 var latcenter=(parseFloat(start.lat)+parseFloat(end.lat))/2;//方向终点

					
				    var polyline = new AMap.Polyline({
		                  path: [[start.lon,start.lat],[end.lon,end.lat]],            // 设置线覆盖物路径
		                  fillColor: "ee2200",
		                  fillOpacity: 0.35,
		                  radius:10000,
		                  strokeColor: '#52c4f7',   // 线颜色
		                  strokeOpacity: 1,         // 线透明度
		                  strokeWeight: 1,          // 线宽
		                  strokeStyle: 'solid',     // 线样式
		                  strokeDasharray: [10, 5], // 补充线样式
		                  geodesic: true            // 绘制大地线
                   });
               polyline.setMap(map);
               //start marker
				    if(start.startOrEnd==0) {
				    	icon = new AMap.Icon({
	                        image: appName+'/pic/icon_get_bus.png',
	                        size: new AMap.Size(24, 24)
                         });
				      arrPosition=[start.lon,start.lat];
				 	 content= "<div class = 'station  stationGreen radius'>"+
	              	 "<p class='stationName '>"+start.stationName+"</p>"+
	             	 "<p  class='count  '>"+start.startCount+" 人</p>"+
	            	 "</div>";
				    }
				    //start and end marker
				    else {
					    	icon = new AMap.Icon({
		                        image:  appName+'/pic/icon_starting_point.png',
		                        size: new AMap.Size(24, 24)
	                        });
				    	arrPosition=[start.lon,start.lat];
				    	if(start.startCount==null){
				    		start.startCount=0;
				    	}
				    	content = "<div class = 'station'>"+
              		"<p class='stationName stationGreen radiusTop'>"+start.stationName+"</p>"+
              		"<p class='count  stationRed'>"+start.endCount+"  人</p>"+
              		"<p class='count  stationGreen radiusBottom'>"+start.startCount+" 人</p>"+
             		 "</div>";	
				    }
				 //green marker  
				    greenMarker = new AMap.Marker({
                    icon: icon,
                    position:arrPosition,
                    offset: new AMap.Pixel(-35,-34),
                    zIndex: 100,
                    topWhenMouseOver:true,
                    //title:"sss",
                    map: map
                }); 
				    greenMarker.content=content;
	                //给Marker绑定单击事件
				    greenMarkerinfo= new AMap.Marker({
	  					content: content,
	  				    position:arrPosition,
	  				    topWhenMouseOver:true,
	  				    zIndex: 110,
	  				    offset: new AMap.Pixel(20, -60),//-113, -140
	  					map: map
	  				});
	              	markers.push(greenMarker);
				//end marker     
			  if(end.startOrEnd==1) {
				    	icon = new AMap.Icon({
                        image:  appName+'/pic/icon_on_bus.png',
                        size: new AMap.Size(24, 24)
                   });
				     arrPosition=[end.lon,end.lat];
				 	 content = "<div class = 'station stationRed radius'>"+
	              		"<p class='stationName'>"+end.stationName+"</p>"+
	              		"<p class='count '>"+end.endCount+"  人</p>"+
	             		 "</div>";	
				    }else {
				    	icon = new AMap.Icon({
                        image:  appName+'/pic/icon_starting_point.png',
                        size: new AMap.Size(24, 24)
                   });
				       arrPosition=[end.lon,end.lat];
				       
				       content = "<div class = 'station'>"+
              		"<p class='stationName stationGreen radiusTop'>"+end.stationName+"</p>"+
              		"<p class='count stationRed'>"+end.endCount+"  人</p>"+
              		"<p class='count stationGreen radiusBottom'>"+end.startCount+"  人</p>"+ 
             		 "</div>";	
				    }
			  
				  //  red and green marker  info
                rgmarker = new AMap.Marker({
                    icon: icon,
                    position:arrPosition,
                    offset: new AMap.Pixel(-35,-34),
                    zIndex: 100,
                    topWhenMouseOver:true,
                   // title:"sss",
                    map: map
                }); 
                rgmarker.content=content;
                //给Marker绑定单击事件
                rgmarkerinfo= new AMap.Marker({
  					content: content,
  				    position:arrPosition,
  				   topWhenMouseOver:true,
  				   zIndex: 110,
  				   offset: new AMap.Pixel(20, -60),//-113, -140
  					map: map
  				});
              	markers.push(rgmarkerinfo);
          	     //dricetion marker  
                  dricetmarker = new AMap.Marker({
                    icon: appName+'/pic/icon_direction_t.png',
                    position:[loncenter,latcenter],
                    offset: new AMap.Pixel(-14,-14),
                    zIndex: 100,
                    angle:angle,
                    topWhenMouseOver:true,
                    //title:"sss",
                    map: map
                }); 
                  //内容2
                content1 = "<div class = 'stationstic stationBlue '><p class='stationName radiusTop'>"+obj[i].persons+"  人</p></div>";  
              	dricetmarker.content=content1;
                //给dricetMarker info
              	dricetmarkerinfo= new AMap.Marker({
  					content: content1,
  				    position:[loncenter,latcenter],
  				    topWhenMouseOver:true,
  				    zIndex: 110,
  				    offset: new AMap.Pixel(20, -20),//-113, -140		
  					map: map
  				});
              	markers.push(dricetmarkerinfo);
              	dricetmarker.on('click', markerClick1);
            	function markerClick1(){	
            		$('.stationstic').toggle();
              	};

              }; 
              $('#totleNum').text(peopleTotle);
			 } 
			}
			else{
				$.messager.alert('系统提示',data.msg,'info');
			}
		},
	error:function(){
		$.messager.alert('系统提示','抱歉，出错了。','info');
	}
 });
 map.setFitView(); 

}

$('#cityChoose').combobox({
	url:appName+'/webapp/cities',
	valueField:'citycode',
	textField:'cityname',
	loadFilter:function(data){
		if(data.success) {
			data.obj[0].selected = true;
			return data.obj;
		}else{
			$.messager.alert('系统提示','抱歉，出错了。','info');
		}
	}
});

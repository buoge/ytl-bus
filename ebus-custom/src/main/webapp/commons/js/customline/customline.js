/*  wxl   2016 12/19 
 * Customline
 */
$(function(){
	//初始化initDatagridCustom表格
	initDatagridCustom();

//search make map   
	$(document).on('click','#query',function(){
		$('#gridCustomLine').datagrid("load",{
			startStation:$("#startStation").val(),
			endStation:$("#endStation").val(),
			status:$("#status").combobox('getValue')
		});
	});  
	// map   window
	$(document).on('click','#map',function(){
		var array = $("#gridCustomLine").datagrid("getChecked");
		console.log(array);
		var param="";
		for(var i=0;i<array.length;i++) {
			param += array[i].id+",";
		}
		if(param.length>1){
			param = param.substring(0,param.length-1);	
		}
		processMapData(param)
	});  
	// 详细  map2   window
	$(document).on('click','#map2',function(){
		var param=$('#singleLineId').val();
		processMapData(param)  
	});
});
var appName=$('#appName').val();

//初始化initDatagridCustom funtion
function initDatagridCustom(){
	  var height=setDatagirdTable();
	$('#gridCustomLine').datagrid({
	    //title:'普通表单-用键盘操作',
         method:'post',
	  url:appName+'/webapp/customlinelist',
	  toolbar: '#tb',
      align:'center',
      //toolbar: '#tb',     //工具栏 id为tb
      singleSelect:true,  //单选  false多选
      rownumbers:true,    //序号
      pagination:true,    //分页
     fitColumns:true,    //占满
      showFooter:true,
      pageNumber:1,
      pageSize:20,
      height:height,
      width:'100%',
      columns:[[
          {field:'ck',checkbox:true,frozen:true,},
          {field:'startstation',title:'起点',width:150,align:'center',frozen:true,},
          {field:'endstation',title:'终点',width:150,align:'center',editor:'textbox',frozen:true,},
          {field:'startworktime',title:'上班时间',width:120,align:'center',frozen:true,},
          {field:'offworktime',title:'下班时间',width:120,align:'center',frozen:true,},
          {field:'count',title:'人数',width:60,align:'center',frozen:true,
        	  formatter: function(value,row){
					return row.currentcount+'/'+value;
				},
          },
          {field:'status',title:'状态',width:80,align:'center',frozen:true,
        	  formatter: function(value){
					if(value==1) {
						return '众筹中';
					}else if(value == 2) {
						return '待处理';
					}else if(value == 3) {
						return '不开通';
					}else if(value == 4) {
						return '已开通';
					}else if(value == 5) {
						return '未开通';
					}
				},
          },
          {field:'createtime',title:'发起时间',width:120,align:'center',frozen:true,
        	  formatter:function(value) {
      			if(value != undefined&&value!=null&&value != '') {
      				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
      			}
        	  }
          },
      ]],
      loadFilter: function(data){
    	  if (data&&data.success){
    		
				return data.obj;
			} else {
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
     	}
	});
}

//地图marker 图线绘制坐标设置
function processMapData(param) {
 var markers = [];
 var marker1;
 var content;
 var content1="";
 var map= new AMap.Map('mapWin', {  
      resizeEnable: true,   
      center:[114.055782,22.591087],
      zoom:13
     }); 

$.ajax({
		type:"POST",
		url:appName+"/webapp/customlinemap",
		data:"lineId="+param,
		dataType:"json",
		success:function(data){
			if(data.success){
				
				//地图数据处理
				$('#mapWin').window('open');
				var obj=data.obj,len2;
				var arrPosition=[],start,end,content,angle,image;
			   for (var i = 0,len=obj.length; i <len; i++) {
				    start = obj[i].start;
				    end =  obj[i].end;
				    angle= obj[i].angle;
				    var lang=(start.lon+end.lon)/2;
				    var latitude=(start.lan+end.lan)/2;
				    var polyline = new AMap.Polyline({
		                  path: [[start.lon,start.lan],[end.lon,end.lan]],            // 设置线覆盖物路径
		                  fillColor: "ee2200",
		                  fillOpacity: 0.35,
		                  radius:10000,
		                  strokeColor: '#52c4f7',   // 线颜色
		                  strokeOpacity: 1,         // 线透明度
		                  strokeWeight: 2,          // 线宽
		                  strokeStyle: 'solid',     // 线样式
		                  strokeDasharray: [10, 5], // 补充线样式
		                  geodesic: true            // 绘制大地线
                   });
               polyline.setMap(map);
             /* 	var infoWindow = new AMap.InfoWindow({
              		isCustom: true,  //使用自定义窗体
              	    offset: new AMap.Pixel(50, -40)//-113, -140		
              	});*/
            /*	var infoWindowdir = new AMap.InfoWindow({
              		isCustom: true,  //使用自定义窗体
              	    offset: new AMap.Pixel(50, -20)//-113, -140		
              	});*/
              	
               //start marker
				    if(start.start_or_end==0) {
				    	icon = new AMap.Icon({
	                        image: appName+'/pic/icon_get_bus.png',
	                        size: new AMap.Size(24, 24)
                         });
				      arrPosition=[start.lon,start.lan];
				 	 content= "<div class = 'station  stationGreen radius'>"+
	              	 "<p class='stationName '>"+start.stationName+"</p>"+
	             	 "<p  class='count  '>"+start.start_count+"</p>"+
	            	 "</div>";
				    }
				    //start and end marker
				    else {
					    	icon = new AMap.Icon({
		                        image:  appName+'/pic/icon_starting_point.png',
		                        size: new AMap.Size(24, 24)
	                        });
				    	arrPosition=[start.lon,start.lan];
				    	content = "<div class = 'station'>"+
              		"<p class='stationName stationGreen radiusTop'>"+start.stationName+"</p>"+
              		"<p class='count  stationRed'>"+start.end_count+"</p>"+
              		"<p class='count  stationGreen radiusBottom'>"+start.start_count+"</p>"+
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
				  //  greenMarker.on('mouseover', markerClick);
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
			  if(end.start_or_end==1) {
				    	icon = new AMap.Icon({
                        image:  appName+'/pic/icon_on_bus.png',
                        size: new AMap.Size(24, 24)
                   });
				     arrPosition=[end.lon,end.lan];
				 	 content = "<div class = 'station stationRed radius'>"+
	              		"<p class='stationName'>"+end.stationName+"</p>"+
	              		"<p class='count '>"+end.end_count+"</p>"+
	             		 "</div>";	
				    }else {
				    	icon = new AMap.Icon({
                        image:  appName+'/pic/icon_starting_point.png',
                        size: new AMap.Size(24, 24)
                   });
				       arrPosition=[end.lon,end.lan];
				       
				       content = "<div class = 'station'>"+
              		"<p class='stationName stationGreen radiusTop'>"+end.stationName+"</p>"+
              		"<p class='count stationRed'>"+end.end_count+"</p>"+
              		"<p class='count stationGreen radiusBottom'>"+end.start_count+"</p>"+ 
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
              //  rgmarker.on('mouseover', markerClick);
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
                    position:[lang,latitude],
                    offset: new AMap.Pixel(-14,-14),
                    zIndex: 100,
                    angle:angle,
                    topWhenMouseOver:true,
                    //title:"sss",
                    map: map
                }); 
                 content1 = "<div class = 'stationstic stationBlue '>";
                 len2 = obj[i].time_person.length;
                 for(var j=0;j<len2;j++){
                   if(j<=1){
                	   content1 +=
        	               "<p class='stationName radiusTop'>"+obj[i].time_person[j].time+"&nbsp;&nbsp;&nbsp"+
        	               obj[i].time_person[j].count+"</p>";  
                   }
                  else{
                	   content1 +=
                		 "<p class='stationName radiusBottom'>"+obj[i].time_person[j].time+"&nbsp;&nbsp;&nbsp"+
           	            obj[i].time_person[j].count+"</p>"; 
                   }
                 } 
              	content1 += "</div>";
              	dricetmarker.content=content1;
                //给dricetMarker info
              //	dricetmarker.on('click', markerClick1);
              	dricetmarkerinfo= new AMap.Marker({
  					content: content1,
  				    position:[lang,latitude],
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
                //给Marker绑定单击事件
             /* 	function markerClick1(e){
              	    infoWindowdir.setContent(e.target.content);
              	    infoWindowdir.open(map, e.target.getPosition());
              	}*/
              	 //给Marker info
              /*	function markerClick(e){
              	    infoWindow.setContent(e.target.content);
              	    infoWindow.open(map, e.target.getPosition());
              	};*/
              }; 
     
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

//详情 detailInfo window

function detailInfo(){
	var array = $("#gridCustomLine").datagrid("getChecked");
	if(array.length<=0){
		$.messager.alert('系统提示','请选择要查看的记录！','info');
	}else if(array.length>=2){
		$.messager.alert('系统提示','只能选择一个记录！','info');
	}else{
		$("#detailWin").removeClass("hide");
		$("#detailWin").window("open");
		initDatagridCustomdg(array);	
	 }
}

//专车开通
function openCustomLine(){
	var array = $("#gridCustomLine").datagrid("getChecked");
	if(array.length<=0){
		$.messager.alert('系统提示','请选择要查看的记录！','info');
	}else if(array.length>=2){
		$.messager.alert('系统提示','只能选择一个记录！','info');
	}else{
		jQuery.ajax({
			url: appName+'/customLine/openCustomLine/'+array[0].id,
			type:"post",
			data: {},
			dataType:"json",
			success: function(msg){
				//处理回调
			},
			error:function (XMLHttpRequest, textStatus, errorThrown) {
				jQuery.messager.alert("错误",errorThrown,"error"); 
			}
		});
	}
}

//详情 initDatagridCustomdg 
function  initDatagridCustomdg (array){
	$('#gridCustomdg').datagrid({    
	    url:appName+'/webapp/customlinesublist', 
	    queryParams: {
	    	lineId: array[0].id
		},
		fitColumns:true,
		singleSelect:true,
		pagination:true,
		rownumbers:true,
		pageNumber:1,
		pageSize:10,
	    columns:[[    
	        {field:'sourcelocation',title:'起点',width:20},    
	        {field:'targetlocation',title:'终点',width:20},    
	        {field:'starttime',title:'上班时间',width:20},
	        {field:'backtime',title:'下班时间',width:20},    
	        {field:'username',title:'参与人',width:20},    
	        {field:'createtime',title:'提交时间',width:30,
	        	formatter: function(value){
	        		if(value!=undefined&&value!=''){
						return new Date(value).Format('yyyy-MM-dd hh:mm:ss');
					}
					return value;
				}
	        } 
	    ]],
	    loadFilter: function(data){
			if (data.success){
				$('#promoter').val(data.obj.promoter);
				$('#regPersons').val(array[0].currentcount);
				$('#promoteTime').val( new Date(array[0].createtime).Format('yyyy-MM-dd hh:mm:ss'));
				$('#subStartStation').val(array[0].startstation);
				$('#subEndStation').val(array[0].endstation);
				$('#onWorkTime').val(array[0].startworktime);
				$('#offWorkTime').val(array[0].offworktime);
				$('#singleLineId').val(array[0].id);
				$('#filteredResult').val("过滤了"+data.obj.filteredResult.length+"条数据");
				var start = data.obj.start;
				var end = data.obj.end;
				for (var i=0;i<3;i++) {
					$('#start'+i).val("");
					$('#end'+i).val("");
				}
				var len = start.length>=3?3:start.length;
				for(var i=0;i<len;i++){
					$('#start'+i).val(start[i].stationName+" "+start[i].count+"次");
				}
				len = end.length>=3?3:end.length;
				for(var i=0;i<len;i++){
					$('#end'+i).val(end[i].stationName+" "+end[i].count+"次");
				} 
				return data.obj.pageList;
			} else {
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
		}
	});
	
}
 


function updateInfo(){
$.messager.alert('系统提示','开发中......','info');
/* var array = $("#table").datagrid("getChecked");
if(array.length<=0){
	$.messager.alert('系统提示','请选择要修改的记录！','info');
}else if(array.length>=2){
	$.messager.alert('系统提示','只能选择一个记录！','info');
}else{
	$("#uroleId").val(array[0].roleId);
	$("#uroleName").val(array[0].roleName);
	$("#updateWin").window("open");
} */
}

function deleteInfo(){
$.messager.alert('系统提示','开发中......','info');
/* var array = $("#table").datagrid("getChecked");
if(array.length<=0){
	$.messager.alert('系统提示','请选择要修改的记录！','info');
}else if(array.length>=2){
	$.messager.alert('系统提示','只能选择一个记录！','info');
}else{
	$("#uroleId").val(array[0].roleId);
	$("#uroleName").val(array[0].roleName);
	$("#updateWin").window("open");
} */
}


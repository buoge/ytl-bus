$(function(){
	//初始化initDatagridCustom表格
	initDatagridCustom();
//search make map   
	$(document).on('click','#query',function(){
		$('#gridCarpoolRecord').datagrid("load",{
			startPlace:$("#qstartPlace").val(),
			endPlace:$("#qendPlace").val(),
			startTime:$("#qstartTime").val(),
			cityCode : $("#qcityChoose").combobox("getValue"),
		});
	});  
//	// map   window
//	$(document).on('click','#map',function(){
//		var array = $("#gridCarpoolRecord").datagrid("getChecked");
//		var param="";
//		for(var i=0;i<array.length;i++) {
//			param += array[i].matchId+",";
//		}
//		if(param.length>1){
//			param = param.substring(0,param.length-1);	
//		}
////		processMapData(param)
//	});  
});
var appName=$('#appName').val();
//初始化initDatagridCustom funtion
function initDatagridCustom(){
	  var height=setDatagirdTable();
	$('#gridCarpoolRecord').datagrid({
	    //title:'普通表单-用键盘操作',
//         method:'post',
      method:'get',
//	  url:appName+'/webapp/customlinelist',
      url:appName+'/webapp/carPoolMatch/list',
	  toolbar: '#tb',
      align:'center',
      toolbar: '#tb',     //工具栏 id为tb
      singleSelect:true,  //单选  false多选
      rownumbers:true,    //序号
      pagination:true,    //分页
   /*   fitColumns:true,    //占满
*/      showFooter:true,
      pageNumber:1,
      pageSize:20,
      height:height,
      width:'100%',
      columns:[[
					{field:'ck',checkbox:true,frozen:true,},
//					{ field: "id",title: "id", width: 100, hidden: true },
					{field:'startStation',title:'起点',width:200,align:'center',frozen:true,},
					{field:'endStation',title:'终点',width:200,align:'center',editor:'textbox',frozen:true,},
					{field:'carpoolRouteType',title:'类型',width:200,align:'center',editor:'textbox',frozen:true,
						formatter: function(value){
							if(value==1) {
								return '普通专线';
							}else if(value == 2) {
								return '直达专线';
							}
							} 
						
						},
					{field:'departTime',title:'出发时间',width:100,align:'center',frozen:true,
						formatter : function(value) {
							if (value != undefined && value != null
									&& value != '') {
								return new Date(value)
										.Format("hh:mm:ss");
							}
						}
						},
					{field:'arriveTime',title:'到达时间',width:100,align:'center',frozen:true,
						formatter : function(value) {
							 arriveTIME=value;
							if (value != undefined && value != null
									&& value != '') {
								return  new Date(value)
										.Format("hh:mm:ss");
							}
						}},
					{field:'matchPersons',title:'撮合人数',width:100,align:'center',frozen:true,},	
					{field:'gmtModified',title:'撮合时长',width:100,align:'center',frozen:true,
						formatter : function(value) {
							if (value != undefined && value != null
									&& value != '') {
								return new Date(value-arriveTIME)
										.Format("hh:mm:ss");
							}
						}
						},	
					{field:'matchTimes',title:'撮合次数',width:100,align:'center',frozen:true,},	
					{field:'status',title:'状态',width:100,align:'center',frozen:true,
						formatter: function(value){
							if(value==1) {
								return '拼车中';
							}else if(value == 2) {
								return '拼车成功';
							}else if(value == 3) {
								return '已发车';
							}else if(value == 4) {
								return '用户已上车';
							}else if(value == 5) {
								return '用户到达下车点';
							}else if(value == 0) {
								return '处理中';
							}else if(value == -1) {
								return '拼车失败';
							}else if(value == 9) {
								return '车到终点';
							}else if(value == 10) {
								return '用户已评价';
							}
							} 
						},	
				  {
						field : "process",
						title : "操作",
						width:150,
						align : 'center',
						formatter : function(value, row, index) {
							var str = "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
									+ index
									+ "' onclick='carpool(event) ;'>详情</a>"
							return str;
						}
				}]],      
        
      loadFilter: function(data){
    	  if (data&&data.success){
    		return data.obj;
			} else {
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
     	}
	});
}
//详细信息动态创建dialog
function carpool(event) {
	var array = $("#gridCarpoolRecord").datagrid("getChecked");
	console.log(array);
	if(array.length<=0){
		$.messager.alert('系统提示','请选择要查看的记录！','info');
	}else if(array.length>=2){
		$.messager.alert('系统提示','只能选择一个记录！','info');
	}else{
		$('#startStation').val(array[0].startStation);
		$('#gmtCreate').val(new Date(array[0].gmtCreate).Format('yyyy-MM-dd hh:mm:ss'));
		$('#matchTimes').val(array[0].matchTimes);
		$('#matchPersons').val(array[0].matchPersons);
		$('#endPlace').val(array[0].endStation);
		$('#gmtModified').val(new Date(array[0].gmtModified).Format('hh:mm:ss'));
		$('#matchExpectTime').val(array[0].matchExpectTime);
		$('#departTime').val(new Date(array[0].departTime).Format('hh:mm:ss'));
		$('#price').val(array[0].price);
		if(array[0].busType==1){
			var bustype='中巴 ';
		}
		$('#busType').val(bustype+ array[0].realDepartSeats+'坐  车牌号：'+array[0].busNumber +' '+'司机：'+array[0].driverName);
		$("#detailWin").removeClass("hide");
		$("#detailWin").window("open");
		$(document).on('click','#map',function(){
			var array = $("#gridCarpoolRecord").datagrid("getChecked");
//			var param="";
			var param={};
			for(var i=0;i<array.length;i++) {
//				param.id += array[i].matchId+",";
				param.id = array[i].carpoolRouteId;
				param.cityCode=array[i].cityCode
			}
//			if(param.length>1){
//				param = param.substring(0,param.length-1);	
//			}
			console.log(param);
			processMapData(param);
            $('#carpoolPeople').hide();
            $('#mapWin').show();
		}); 
	}

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
     var driving = new AMap.Driving({
         map: map,

     });

    $.ajax({
		type:"GET",
		url:appName+"/webapp/carPoolMatch/routeInfo",
		data:"carpoolRouteId="+param.id+"&cityCode="+param.cityCode,
		dataType:"json",
		success:function(data){
			 if(data.success){
			 $('#mapWin').window('open');
				console.log(data.obj.stationList)
				var stations=data.obj.stationList;
				var lnglats = [];
			    for(i=0;i<stations.length;i++) {
                      lnglats.push([stations[i].stationLat,stations[i].stationLon])
          	    	}
			    console.log(lnglats.length);
			     for(var i=0;i<lnglats.length-2;i++){
		        	driving.search(lnglats[i], lnglats[i+1]);
		        } 
		        //窗口
		        var infoWindow = new AMap.InfoWindow({offset:new AMap.Pixel(0,-30)});
			    for(var i= 0,marker;i<lnglats.length;i++){
			        var marker=new AMap.Marker({
			            icon :appName+'/pic/bus.jpg',//24px*24px
			            offset : new AMap.Pixel(-12,-12),
			            position:lnglats[i],
			            map:map
			        });
			        var time=new Date(stations[i].arriveTime).Format('hh:mm')
			        marker.content='站点：'+stations[i].stationName+'<br/>上车：'+stations[i].upNum+'人<br/> 下车：'+stations[i]. downNum+'人<br/> 时间：'+time+'';
		        marker.on('click',markerClick);
		        marker.emit('click',{target:marker});
			    }
			    function markerClick(e){
			        infoWindow.setContent(e.target.content);
			        infoWindow.open(map, e.target.getPosition());
			    }
		      
//			    driving.search
//			       ( [116.379028, 39.865042], [116.427281, 39.903719]);
//				  for(i=0;i<data.obj.stationList.length;i++){
//					  if(stations[i].stationType==1){
//						  var startlat=stations[i].stationLat;
//						  var startlon=stations[i].stationLon
//					  }
//					  if(stations[i].stationType==3){
//						  var endlat=stations[i].stationLat;
//						  var endlon=stations[i].stationLon;
//					  }
				  }
		}});
   
    // 根据起终点名称规划驾车导航路线


//             AMap.service(["AMap.Transfer"], function() {
//				     var transOptions = {
//				            map: map,
//				            city: '宝鸡市',                            //公交城市
//				            //cityd:'乌鲁木齐',
//				            policy: AMap.TransferPolicy.LEAST_TIME //乘车策略
//				        };
//				        /*公交路线查询服务返回数据解析概况*/
//				     var lineNum = data.obj.assistStation.split("|").length;
//				            //在地图上绘制折线
//				           var editor={};
//				           editor._line=(function(){
//				            var lineArr = data.obj.assistStation.split("|");
//				            for(i=0;i<lineArr.length;i++) {
//                               var lineAr = [];
//				            	for (var i = 0; i < lineArr.length; i++) {
//				            	  lineAr.push(lineArr[i].split(","))
//				            	       }
//				            	   }
//
//				            return new AMap.Polyline({
//				                    map: map,
//				                    path: lineAr,
//				                    strokeColor: "#4c98f8",//线颜色
//				                    strokeOpacity: 1,//线透明度
//				                    strokeWeight: 3,//线宽
//				                    strokeStyle: "solid"//线样式
//				                });
//				            })();
//				         /*   map.setFitView();*/
//				            editor._lineEditor= new AMap.PolyEditor(map, editor._line);
//				     });
//                  
//				    var lnglats = [];
//				    for(i=0;i<stations.length;i++) {
//                       lnglats.push([stations[i].stationLon,stations[i].stationLat])
//          	    	}
				  
//				 /*   map.setFitView();*/
//			         }
//			       else{
//				     $.messager.alert('系统提示',data.msg,'info');
//			        }
//		},
//	error:function(){
//		$.messager.alert('系统提示','抱歉，出错了。','info');
//	}
// });
// map.setFitView(); 
}

$(document).on('click','#carpoolDetail',function(){
	var array = $("#gridCarpoolRecord").datagrid("getChecked");
	console.log(array);
	var param="";
	for(var i=0;i<array.length;i++) {
		param += array[i].id+",";
	}
	if(param.length>1){
		param = param.substring(0,param.length-1);	
	}
//	processMapData(param);
	initDatagridCustomdg(array);	
}); 
	
//详情 initDatagridCustomdg 
function  initDatagridCustomdg (array){
	$('#mapWin').hide();
	$('#carpoolPeople').show();
	$('#gridCustomdg').datagrid({ 
		method:'get',
//	    url:appName+'/webapp/customlinesublist', 
	    url:appName+'/webapp/carPoolMatch/person/list', 
	    queryParams: {
//	    	lineId: array[0].id
	    	matchId:array[0].matchId,
	    	cityCode:array[0].cityCode,
	    
		},
	    cityCode:1,
		fitColumns:true,
		singleSelect:true,
		pagination:true,
		rownumbers:true,
		pageNumber:1,
		pageSize:10,
	    columns:[[    
	        {field:'realStartPlace',title:'起点',width:20},    
	        {field:'realEndPlace',title:'终点',width:20},    
	        {field:'expectAboardTime',title:'出发时间',width:20,
	        	formatter: function(value){
	        		if(value!=undefined&&value!=''){
						return new Date(value).Format('yyyy-MM-dd hh:mm:ss');
					}
					return value;
				}
	        	},
	        {field:'seats',title:'人数',width:20},    
	        {field:'userName',title:'参与人',width:20},    
	        {field:'applyTime',title:'提交时间',width:30,
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
                 return data.obj;
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
//获取城市列表
$('#qcityChoose').combobox({
	url : appName + '/webapp/cities',
	valueField : 'citycode',
	textField : 'cityname',
	loadFilter : function(data) {
		if (data.success) {
			data.obj[0].selected = true;
			return data.obj;
		} else {
			$.messager.alert('系统提示', '抱歉，出错了。', 'info');
		}
	}
});

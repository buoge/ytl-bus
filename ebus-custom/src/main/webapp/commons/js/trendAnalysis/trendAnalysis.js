/*  wxl   2017 2/23 
 * initDatagridTrendAnalysis
 */
$(function(){
	//初始化initDatagridTrendAnalysis表格
	//initDatagridTrendAnalysis();
	 $("#startDate").val(dateUtil.addEndTime(dateUtil.getCurrDayPreOrNextDay('prev',7)).Format("yyyy-MM-dd"));
     $("#endDate").val(dateUtil.addStartTime(dateUtil.getCurrentDate()).Format("yyyy-MM-dd"));
     initDataEchart($('.item-active'),'1');
});

var appName=$('#appName').val();


//点击查询
function initDataEchartQuery(){
	var len=$('.echart-header .datestatus').length;
	for(var i=0;i<len;i++){
		if($('.echart-header .datestatus').eq(i).hasClass('item-active')){
			var initNum=$('.echart-header .datestatus').eq(i).attr('dataNum');
			  initDataEchart($('.item-active'),initNum);
		}
	}
}

//点击日 月 年 三个切换状态
$(document).on('click','.datestatus',function(){
	$('.datestatus ').removeClass('item-active');
	$(this).addClass('item-active');
	var num= $(this).attr('dataNum');
	initDataEchart($(this),num);
})
//请求获取数据
function initDataEchart(obj,dataNum){
//获取当天数
   if(dataNum){
	   var dayNum=dataNum;
   }
   else{
	   var dayNum= $ ('.item-active').attr('dataNum');
   }
   var cityCode=$("#cityChoose").combobox('getValue');
   var startDate=$("#startDate").val();
   var endDate=$("#endDate").val();
   var params="?cityCode="+cityCode+"&startDate="+startDate+"&endDate="+endDate+"&statFrequency="+dayNum;
   console.log(params);
	$.ajax({
		url : appName+'/stat/trend',
		data :params,
		cache : false,
		type:'POST',
		success : function(result) {
			var result = $.parseJSON(result);
			if (result&&result.success) {
				initEchartgird(obj,result);
				initDatagridTrendAnalysis(result);
			}
			else{
				$.messager.alert('系统提示',result.msg,'info'); 
			}
		}
	});

}
//初始化initDatagridgirdTrendAnalysis 
function initDatagridTrendAnalysis(dataObj){
	//emptyHtml清空数据
	emptyHtml();
	var dataObjArr=dataObj.obj;
	console.log(dataObjArr);
	for(var i=0;i<dataObjArr.length;i++){
		  var html="<tr><td>"+dataObjArr[i].newusers+"</td><td>"+dataObjArr[i].activeusers+"</td><td>"+dataObjArr[i].starttimes+"</td><td>"+dataObjArr[i].totalusers+"</td></tr>";
	     $('#girdTrendAnalysis').append(html);
	}   
}
//emptyHtml清空数据
function emptyHtml(){
	 $('#girdTrendAnalysis').empty();
}

/*initEchartgird(obj,result); 
 * obj 传入当前点击dataNum
 * data 传入数据对象
 */
function initEchartgird(obj,data){
	// 基于准备好的dom，初始化echarts实例
	var dom = document.getElementById("gridEchartTrend");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	var type=$(obj).attr('dataNum');

	if(type==1){
		option=optionData(data);
		
	}
	else if(type==7){
		option=optionData(data);
		
	}
	else if(type==30){
		option=optionData(data);
		
	}
	if (option && typeof option === "object") {
	    myChart.setOption(option, true);
  }
}
function optionData(data){
	var dataDate=[];//定义x轴时间分割断
	var dataNewusers=[];//定义新增用户
	var dataStarttimes=[];//定义启动次数
	var dataActiveusers=[];//定义活跃用户
	var dataTotalusers=[];//定义累计次数

	for(var j=0;j<data.obj.length;j++){
		dataDate.push(data.obj[j].date);
		dataNewusers.push(data.obj[j].newusers);
		dataStarttimes.push(data.obj[j].starttimes);
		dataActiveusers.push(data.obj[j].activeusers);
		dataTotalusers.push(data.obj[j].totalusers);
	}
	console.log(dataDate);
	var option = {
		    title: {
		       
		    },
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		    	 orient: 'horizontal', // 'vertical'
		         x: 'left', // 'center' | 'left' | {number},
		         y: 'top', // 'center' | 'bottom' | {number}
		        data:['新增用户','活跃用户','启动次数','累计次数'],
		     
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    toolbox: {
		       
		    },
		    xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: dataDate,
		    },
		    yAxis: {
		        type: 'value',
		        max:400,
		        min:0,
		        splitNumber:4,
		    },
		    series: [
		        {
		            name:'新增用户',
		            type:'line',
		            stack: '总量',
		            data:dataNewusers,
		        },
		        {
		            name:'活跃用户',
		            type:'line',
		            stack: '总量',
		            data:dataActiveusers,
		        },
		        {
		            name:'启动次数',
		            type:'line',
		            stack: '总量',
		            data:dataStarttimes,
		        },
		        {
		            name:'累计次数',
		            type:'line',
		            stack: '总量',
		            data:dataTotalusers,
		        }
		    ]
		};
	return option
}
//地址下拉菜单
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
/*  wxl   2016 12/20 
 * Dataecharts
 */
$(function(){
   //初始化
	Dataecharts();
});
var appName=$('#appName').val();

//echarts 饼状图
function Dataecharts(){
	var dataS=[];
	$.ajax({
		type:"POST",
		url:appName+"/webapp/queryEvaluationPie",
		dataType:"json",
		success:function(data){
			if(data.success){
				console.log(data);
				for (var i = 0; i < data.obj.rows.length; i++) {
					dataS.push({
						"name" : data.obj.rows[i].name,
						"value" : data.obj.rows[i].count
					});
				}
				echarts(dataS);
			}
			else {
				$.messager.alert('系统提示', '抱歉，出错了。', 'info');
			}
		},
		error:function(result){ 
			$.messager.alert('系统提示', '抱歉，出错了。', 'info');
		}
	})

}
function echarts(dataS){
	// 路径配置
	require.config({
		paths: {
			echarts: appName+"/commons/lib/dist",
		}
	});
	// 使用
	require(
			[
			 'echarts',
			 'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
			 ],
			 function (ec) {
				var myChart = ec.init(document.getElementById('echartPie'));
				// 过渡---------------------
				myChart.showLoading({
					text: '正在努力的读取数据中...',    //loading话术
				});

				// ajax callback
				myChart.hideLoading();
				option = {
						title : {
							text: '乘客评价结果汇总',
							//subtext: '内部数据',
							x:'center',
							textStyle:{
								fontSize: 24,
							    fontWeight: 'bolder',
							    color: '#888'
							}
						},
						tooltip : {
							trigger: 'item',
							formatter: "{a} <br/>{b} : {c} ({d}%)"
						},
						legend: {
							orient : 'vertical',
							x : 'left',
							textStyle:{
								fontSize: 14,
							 	color: '#888'
							},
							data:['很不满意','不满意','一般','满意','很满意']
						},
						toolbox: {
							show : true,
							feature : {
								/* mark : {show: true}, */
								dataView : {show: false, readOnly: false},
								magicType : {
									/*  show: true,  */
									type: ['pie', 'funnel'],
									option: {
										funnel: {
											x: '25%',
											width: '50%',
											funnelAlign: 'left',
											max: 1548
										}
									}
								}
							}
						},
					
						series : [
						          {
						        	  name:'访问来源',
						        	  type:'pie',
						        	  radius : '55%',
						        	  center: ['50%', '60%'],
						        	  data:dataS.slice(0,5)
						          }
						          ]
				};				                    
			    // 为echarts对象加载数据 
                myChart.setOption(option); 
				//return data.obj;
			});
}

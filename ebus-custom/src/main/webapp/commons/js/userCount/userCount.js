/*  wxl   2017 2/21 
 * initDatagridUserCount
 */
$(function(){
	//初始化initDatagridUserCount表格
	initDatagridUserCount(1);
	$('.item-tabs').on('click',function(){
		$('.item-tabs').removeClass('item-click');
		$(this).addClass('item-click');
		var dataDate=$(this).attr('dataDate');
		initDatagridUserCount(dataDate);
	})
});

var appName=$('#appName').val();
//初始化initDatagridUserCount funtion
function initDatagridUserCount(dataDate){
	//清空数据
	emptyHtml();
	$.ajax({
		url : appName+'/stat/user',
		cache : false,
		type:'POST',
		success : function(result) {
			var result = $.parseJSON(result);
			console.log(result);
			if (result&&result.success) {
			    var datatoday=result.obj.todayAllCities;
				var datayesterday=result.obj.yesterdayAllCities;
				dataAllcity(datatoday,datayesterday);
				if(dataDate==1){
					var dataArr=result.obj.todayEachCity;
					for(var i=0;i<dataArr.length;i++){
						  var html="<tr><td>"+dataArr[i].order+"</td><td>"+dataArr[i].upordown+"</td><td>"+dataArr[i].citycode+"</td><td>"+dataArr[i].cityname+"</td><td>"+dataArr[i].newusers+"</td><td>"+dataArr[i].activeusers+"</td><td>"+dataArr[i].starttimes+"</td><td>"+dataArr[i].totalusers+"</td></tr>";
					     $('#girdUserCount').append(html);
					}   
				}else if(dataDate==2){
					var dataArr=result.obj.yesterdayEachCity;
					for(var i=0;i<dataArr.length;i++){
						  var html="<tr><td>"+dataArr[i].order+"</td><td>"+dataArr[i].upordown+"</td><td>"+dataArr[i].citycode+"</td><td>"+dataArr[i].cityname+"</td><td>"+dataArr[i].newusers+"</td><td>"+dataArr[i].activeusers+"</td><td>"+dataArr[i].starttimes+"</td><td>"+dataArr[i].totalusers+"</td></tr>";
					     $('#girdUserCount').append(html);
					}   
				}	
				
			}
			else{
				$.messager.alert('系统提示',result.msg,'info'); 
			}
		}
	});
}

//emptyHtml清空数据
function emptyHtml(){
	 $('#girdUserCount').empty();
}

//初始化头部今日  昨日信息
function dataAllcity(datatoday,datayesterday){
	console.log(datatoday);
	console.log(datayesterday)
	$('.nowNewusers').text(datatoday.newusers);
	$('.nowActiveusers').text(datatoday.activeusers);
	$('.nowStarttimes').text(datatoday.starttimes);
	$('.nowTotalusers').text(datatoday.totalusers);
	$('.todayNewusers').text(datayesterday.newusers);
	$('.todayActiveusers').text(datayesterday.activeusers);
	$('.todayStarttimes').text(datayesterday.starttimes);
	$('.todayTotalusers').text(datayesterday.totalusers);
}

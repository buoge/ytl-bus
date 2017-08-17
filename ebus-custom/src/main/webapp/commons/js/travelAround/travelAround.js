
$(function(){
	//初始化initDatagridAdvertManage表格
	initDatagridAdvertManage();
});
var appName=$('#appName').val();

var imgKeyValue = {
    imgKey:"",
    imgValue:"",
    imgArr:[],
};
//初始化initDatagridAdvertManage funtion
function initDatagridAdvertManage(){
	  var height=setDatagirdTable();
	$('#girdTravelAround').datagrid({
	    //title:'普通表单-用键盘操作',
        method:'get',
//	  url:appName+'/webapp/queryImageList',
      url:appName+'/neighbouringTour/list',
	  toolbar: '#tb',
      align:'center',
      //toolbar: '#tb',     //工具栏 id为tb
      singleSelect:true,  //单选  false多选
      rownumbers:true,    //序号
      pagination:true,    //分页
 /*     fitColumns:true,    //占满
*/      showFooter:true,
      pageNumber:1,
      pageSize:20,
      height:height,
      width:'100%',
      columns:[[
          {field : 'ck',checkbox : true},
          {field:'avdImage',title:'图片url',width:240,align:'center',hidden:true,},
          {field:'htmlUrl',title:'图片跳转url',width:240,align:'center',hidden:true,},
          {field:'title',title:'标题',width:250,align:'center',},
          {field:'startValidPeriod',title:'生效日期',width:150,align:'center',editor:'textbox',
        	 formatter:function(value) {
     			if(value != undefined&&value!=null&&value != '') {
     				return new Date(value).Format("yyyy-MM-dd ");
     			}
       	  }
        	  },
          {field:'endValidPeriod',title:'失效日期',width:150,align:'center',
        		  formatter:function(value) {
           			if(value != undefined&&value!=null&&value != '') {
           				enddate=new Date(value).Format("yyyy-MM-dd ")
           				return enddate ;
           			}
             	  }
         },
          {field:'ticketNum',title:'票数',width:100,align:'center',},
          {field:'originalPrice',title:'原价',width:80,align:'center',},
          {field:'currentPrice',title:'现价',width:80,align:'center',},
          {field:'pv',title:'浏览人数',width:100,align:'center'},
          {field:'location',title:'城市',width:100,align:'center'},
          {field:'isPermanentValid',title:'状态',width:80,align:'center',
       	  formatter:function(value) {
    			if(value == false  || value == 0) {
    				return '已经失效'
      			}else {
					return '进行中';
					}
        	  }
        	  },
          {field:'operate',title:'操作',width:250,align:'center',
//        	 
        	  formatter : function(value, row, index) {
        		  
					var str = "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
							+ index
							+ "' onclick='advertManageDetials(event);'>详情</a>"
							+ "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
							+ index
							+ "' onclick='advertManageEdit(event);'>编辑</a>"
							+ "<a class='item-span  f-blue fl'  href='javascript:void(0);' data-index='"
							+ index
							+ "' onclick='newsManageDelete(event);'>删除</a>";
					
					return str;
				}
          },
      ]],
      loadFilter: function(data){
    	  console.log(data)
    	  if (data.success){
				return data.obj;
			} else {
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
     	}
	});
}

//删除信息动态confirm一行
function newsManageDelete(event) {
	var index = $(event.target).attr('data-index');
	$("#girdTravelAround").datagrid('selectRow', index);
	var delrows = $('#girdTravelAround').datagrid('getSelected');
	if (delrows) {
		$.messager.confirm('询问', '<div class="messager-tip">您确定要删除【'
				+ delrows.title + '】？</div>', function(data) {
			if (data) {
				$.ajax({
					url : appName + '/neighbouringTour/delTravel'+'?id=' + delrows.id,
					cache : false,
					type : 'delete',
					dataType : 'JSON',
					success : function(r) {
						if (r.success) {
							$.messager.alert('系统提示', r.msg, 'info');
							$('#girdTravelAround').datagrid('reload');
						}
					}
				});
			}
		});
	}
}
//查询事件
$(document).on('click','#query',function(){
		$('#girdTravelAround').datagrid("load",{
			title : $("#title").val(),
			cityCode:$("#cityChoose").combobox('getValue'),
		});
});

//新增信息动态创建dialog
function advertManageAdd() {
var dialog=	$('<div/>').dialog({
		href : appName+'/webviews/advertManage/advertManageAdd.jsp',
		width :640,
		height :640,
		modal : true,
		title : '新增信息',
		onClose : function() {
			$(this).dialog('destroy');
		},
		onLoad : function() {
			//传对应dialog对象和按钮id
			 dialogCallback($(this));
		}
	});
  
}

//详细信息动态创建dialog
function advertManageDetials() {
	var index = $(event.target).attr('data-index');
	$("#girdTravelAround").datagrid('selectRow',index);
	var rows = $('#girdTravelAround').datagrid('getSelected');
	//日期格式化
	rows.startValidPeriod= formatDate(rows.startValidPeriod,'yyyy-MM-dd');
	rows.endValidPeriod= formatDate(rows.endValidPeriod,'yyyy-MM-dd');
	console.log(rows.startValidPeriod,rows.endValidPeriod);
	var city=rows.cityCode;
	
	var dialog=	$('<div/>').dialog({
			href : appName+'/webviews/travelAround/travelAroundDetial.jsp',
			width :640,
			height :600,
			modal : true,
			title : '详细信息',
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				$("#editAdvertFrom").form("load",rows);//填充数据
				if(rows.startValidPeriod==null || rows.endValidPeriod==null ){
					$("input[type='radio']")[0].checked = true;
				}else{
					$("input[type='radio']")[1].checked = true;
				}
				var strs= new Array();
				strs=rows.pics.split(",")
				for (var i = 0; i < strs.length; i ++) {
					if(strs[i] == "") {
						strs.splice(i,1);
						break;
					}
				}
				if( strs != undefined && strs.length > 0) {
					for(var i=0;i<strs.length;i++){
	        			$(".add-img"+(i+1)).attr('src',strs[i])
	    			};
				}
			 
       
				$("#actinfomation").html(rows.eventDetail);
				$("#activeDiv").html(rows.eventDetail);
				$("#ticketinfomation").html(rows.ticketNote)
				$("#ticketDiv").html(rows.ticketNote);
				//传对应dialog对象和按钮id
				 dialogCallback($(this));
				//禁止所有input  时间文本框编辑
				 publicDisabled('editAdvertFrom');
			}
		});
	console.log(rows.cityCode)
	$.ajax({
	url : appName+'/webapp/cities',
		data: {},
	    cache : false,
		type:'post',
	    dataType : 'JSON',
		success : function(data) {
			if(data.success) {
			    console.log(data.obj);
				for(i=0;i<data.obj.length;i++){
					if(data.obj.length<=1){
						$("#dtcityChoose").val(data.obj[0].cityname);
					}else if(city==-1){
						$("#dtcityChoose").val("所有城市");
					}else if(city==data.obj[i].citycode){
						 console.log( data.obj[i].cityname);
						 $("#dtcityChoose").val(data.obj[i].cityname);
					}  
				}
				return data.obj;
			}else{
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
		}
	});
}

//编辑信息动态创建dialog
function advertManageEdit(event) {
    var index = $(event.target).attr('data-index');
	$("#girdTravelAround").datagrid('selectRow',index);
	var rows = $('#girdTravelAround').datagrid('getSelected');
	//日期格式化
	rows.startValidPeriod= formatDate(rows.startValidPeriod,'yyyy-MM-dd');
	rows.endValidPeriod= formatDate(rows.endValidPeriod,'yyyy-MM-dd')
	console.log(rows);
	var ecitycode=rows.cityCode;
	var dialog=	$('<div/>').dialog({
			href : appName+'/webviews/travelAround/travelAroundEdit.jsp',
			width :640,
			height :600,
			modal : true,
			title : '详细信息',
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				$("#editAdvertFrom").form("load",rows);//填充数据
				$("#adImage").val(rows.pics);
			    var strs= new Array();
				strs=rows.pics.split(",")
					for (i = 0 ;i < strs.length; i ++) {
						if (strs[i] == "") {
							strs.splice(i,1);
							break;
						}
							
					}
					if (strs != undefined && strs.length > 0) {
						showImage(strs);
					}

				$("#actinfomation").html(rows.eventDetail);
				$("#ticketinfomation").html(rows.ticketNote);
				$("#activeDiv").html(rows.eventDetail);
				$("#ticketDiv").html(rows.ticketNote);
				console.log($("#addAcityChoose"));
				if(rows.startValidPeriod==null || rows.endValidPeriod==null ){
					$("input[type='radio']")[0].checked = true;
				}else{
					$("input[type='radio']")[1].checked = true;
				}
				
//				for(var i=0;i<strs.length;i++){
//        			$(".add-img"+(i+1)).attr('src',strs[i])
//    			}
				//传对应dialog对象和按钮id
	
				 
				 dialogCallback($(this));
				 createEditor();
				 
			}
		});
	
}
/*图片上传*/
function showImage (imgArr) {
	 var delParent;
	 var  nextSilb;
     var $srcImgDiv = null;
     var index1;
     var index2;
     
     /*点击图片的文本框*/
     var $newFile = $("#newfile");
	 var imgContainer = $newFile.parents(".z_photo"); //存放图片的父亲元素        var fileList = file.files; //获取的图片文件        console.log(fileList + "======filelist=====");
        var input = $newFile.parent(); //文本框的父亲元素
        //遍历得到的图片文件
        for (var i = 0; i < imgArr.length; i++) {
                var imgUrl = imgArr[i];
                imgKeyValue.imgArr[imgUrl]=imgUrl;
                var $section = $("<section class='up-section fl loading'>");
                imgContainer.prepend($section);
                var $span = $("<span class='up-span'>");
                $span.appendTo($section);

                var $img0 = $("<img class='close-upimg'>").on("click", function (event) {
                    event.preventDefault();
                    event.stopPropagation();
                    $("#newMask").show();
                    delParent = $(this).parent();
                    nextSilb = $(this).next()[0];
                });
                $img0.attr("src", "http://www.jq22.com/demo/imgUp201703281022/img/a7.png").appendTo($section);
                var $img = $("<img class='up-img up-opcity'>");
                $img.attr("src", imgArr[i]);
                $img.appendTo($section);
                var $p = $("<p class='img-name-p'>");
                $p.html(imgUrl).appendTo($section);
                var $input = $("<input id='taglocation' name='taglocation' value='' type='hidden'>");
                $input.appendTo($section);
                var $input2 = $("<input id='tags' name='tags' value='' type='hidden'/>");
                $input2.appendTo($section);

            }

        $(".up-img.up-opcity").bind("dragstart", function () {
            $srcImgDiv = $newFile.parent();
            index1 = $srcImgDiv.index();
        });
        $(".up-section.fl.loading").bind("dragover", function (event) {

            // 必须通过event.preventDefault()来设置允许拖放 
            event.preventDefault();
        });
        $(".up-section.fl.loading").bind("drop", function (event) {
            event.preventDefault();
            if ($srcImgDiv[0] != $newFile) {
                index2 = $newFile.index();
                if (index1 > index2) {
                	$newFile.before($srcImgDiv);
                } else {
                	$newFile.after($srcImgDiv);
                }

            }
        });

        setTimeout(function () {
            $(".up-section").removeClass("loading");
            $(".up-img").removeClass("up-opcity");
        }, 450);
        numUp = imgContainer.find(".up-section").length;
        if (numUp >= 5) {
        	$newFile.parent().hide();
        }

        //input内容清空
        $newFile.val("");
    $(".z_photo").delegate(".close-upimg", "click", function () {
        $("#newMask").show();
        delParent = $(this).parent();
    });

    $("#newOK").click(function () {
        $("#newMask").hide();
        var numUp = delParent.siblings().length;
        if (numUp < 6) {
            delParent.parent().find(".z_file").show();
        }
        delParent.remove();
        //这里加上删除成功的上传,上传对应的url
        var imageStrArr = $("#adImage").val();
        //先用逗号分割imageStrArr，获得一个数组，然后清楚对应的元素，最后再用逗号拼接成一个字符串，复制给$("#adImage")
        var arrimgs = imageStrArr.split(",");
        var delUrl;
        for (var key in imgKeyValue.imgArr) {
            if (key == nextSilb.src) {
                delUrl = imgKeyValue.imgArr[key];
            }
        }
        var str;
        for (var j = 0; j < arrimgs.length; j++) {
            if (arrimgs[j].indexOf(delUrl) != -1) {

            } else {
                if (str == undefined) {
                    str = arrimgs[j];
                } else {
                    str = str + "," + arrimgs[j];
                }
            }
            if (j == arrimgs.length - 1) {
//                if (str == undefined) {
             //                    str = "";
             //                }
                $("#adImage").val(str);
                
            }
            
        }
        console.log($("#adImage").val())
    });

    $(".wsdel-no").click(function () {
        $("#newMask").hide();
    });

 }
//生效信息动态confirm一行
/*function advertManageInvalid(index) {
	var index = $(event.target).attr('data-index');
	var rowid = $(event.target).attr('data-id');
	console.log(rowid);
	$("#girdTravelAround").datagrid('selectRow',index);
	var delrows = $('#girdTravelAround').datagrid('getSelected');
	if (delrows) {
		$.messager.confirm('询问', '<div class="messager-tip">您确定让该屏闪图生效？</div>', function(data) {
			if (data) {
				$.ajax({
					url : appName+'/webapp/modifyImageToValid',
					data : {id : rowid},
					cache : false,
					//dataType : 'JSON',
					type:'POST',
					success : function(result) {
						var result = $.parseJSON(result);
						if (result&&result.success) {
							$('#girdTravelAround').datagrid('reload');
						}
						$.messager.alert('系统提示',result.msg,'info'); 
					}
				});
			}
		});
	}
}*/
//失效信息动态confirm一行
/*function advertManageToInvalid(index) {
	var index = $(event.target).attr('data-index');
	var rowid = $(event.target).attr('data-id');
	$("#girdTravelAround").datagrid('selectRow',index);
	var delrows = $('#girdTravelAround').datagrid('getSelected');
	if (delrows) {
		$.messager.confirm('询问', '<div class="messager-tip">您确定让该屏闪图失效？</div>', function(data) {
			if (data) {
				$.ajax({
					url : appName+'/webapp/modifyImageToUnValid',
					data : {id : rowid},
					cache : false,
					type:'post',
					//dataType : 'JSON',
					success : function(result) {
						var result = $.parseJSON(result);
						if (result&&result.success) {
							$('#girdTravelAround').datagrid('reload');
						}
						$.messager.alert('系统提示',result.msg,'info'); 
					}
				});
			}
		});
	}
}*/


			/*	if($('#etitle').val() == undefined || $('#etitle').val().trim() == '') {
						$.messager.alert('系统提示','<div class="item-errortip">请输入标题</div>','info'); 
						return false;
					}
				if($('#ecurrentPrice').val() == undefined || $('#ecurrentPrice').val().trim() == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请输入现价</div>','info'); 
					return false;
				}
				if($('#eoriginalPrice').val() == undefined || $('#eoriginalPrice').val().trim() == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请输入原价</div>','info'); 
					return false;
				}
				if($('#eticketNum').val() == undefined || $('#eticketNum').val().trim() == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请输入票数</div>','info'); 
					return false;
				}
				
				if(activeDiv_val == undefined || activeDiv_val == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请输入活动详情</div>','info'); 
					return false;
				}
				if(ticketDiv_val == undefined || ticketDiv_val == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请输入购票需知</div>','info'); 
					return false;
				}*/
				//图片宽高
//				var height=$('.fileimg').height();
//				var width=$('.fileimg').width();
//				param.width=width;
//				param.height=height;
//	    	  },
//		 url:appName+'/neighbouringTour/updateTravel',    
//		 success:function(msg){
//			var result = $.parseJSON(msg);
//			if(result.success){
//				$.messager.alert('系统提示','编辑成功','info',function(){
//					$("#editAdvertFrom")[0].reset();
//					$('#girdTravelAround').datagrid("reload");
//					
//					publicClose();
//					
//				});
//			}else{
//				$.messager.alert('系统提示',result.msg,'info'); 
//			}
//		},
//		error:function(){
//			$.messager.alert('系统提示','抱歉，出错了。','info'); 
//		}
//	};
//}

//获取城市列表
$('#cityChoose').combobox({
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
//新增信息动态创建dialog
function advertManageAdd() {
var dialog=	$('<div/>').dialog({
		href : appName+'/webviews/travelAround/travelAroundAdd.jsp',
		width :640,
		height :500,
		modal : true,
		title : '新增信息',
		onClose : function() {
			$(this).dialog('destroy');
		},
		onLoad : function() {
			//传对应dialog对象和按钮id
			 dialogCallback($(this));
		}
	});
  
}

//编辑器的创建方法
function createEditor(type) {
	var rows = $('#girdTravelAround').datagrid('getSelected');
	// 编辑器初始化
    var editor = new wangEditor('editor-trigger');
    var editor2 = new wangEditor('editor-trigger2');
    // 上传图片
	// 上传图片
	editor.config.uploadImgUrl = appName + '/busnews/editorImage';
	editor2.config.uploadImgUrl = appName + '/busnews/editorImage';
	// 将上传的图片的名字改成fileName
	editor.config.uploadImgFileName = 'fileName';
	editor2.config.uploadImgFileName = 'fileName';
	// 普通的自定义菜单
	editor.config.menus = $.map(wangEditor.config.menus, function(item, key) {
		if (item === 'location') {
			return null;
		}
		return item;
	});
	editor2.config.menus = $.map(wangEditor.config.menus, function(item, key) {
          if (item === 'location') {
              return null;
          }
          return item;
      });
	editor.create();
	editor2.create();
	editor.onchange = function() {
	    var eventDetailtext = this.$txt.html();
	    $("#activeDiv").html(eventDetailtext);
	 }
	editor2.onchange = function() {
	   var ticketNotetext = this.$txt.html();
	   $("#ticketDiv").html(ticketNotetext);
	  }

}
//	$('#activeDiv').val(editor.$txt.html());
//	$('#ticketDiv').val(editor.$txt.html());
	
//	var rows = $('#girdTravelAround').datagrid('getSelected');
//	$.ajax({
//			url : appName + '/webapp/newsContent/',
//			cache : false,
//	        data : 'id=' + rows.id,
//			type : 'post',
//		dataType : 'JSON',
//			success : function(r) {
//			if (r.success) {
//					editor.$txt.html(r.obj);
//					$('#editContent').val(r.obj);
//				editor.onchange = function() {
//						var htmltext = this.$txt.html();
//						$('#activeDiv').val(htmltext);
//						$('#ticketDiv').val(htmltext);
//					}
//			} else {
//				$.messager.alert('系统提示', '抱歉，出错了。', 'info');
//			}
//			}
//		});
	
	// 获取编辑区域的html
//	if (type == 1) {// add
//		editor.$txt.html("");
//		// 配置 onchange 事件
//		editor.onchange = function() {
//			var html = this.$txt.html();
//			$('#addContent').val(html);
//		}
//	} else if (type == 2) {// detail
//		$(".wangEditor-container").css({"margin-top": "250px;"})
//		var rows = $('#girdNewsManage').datagrid('getSelected');
//		$.ajax({
//			url : appName + '/webapp/newsContent/',
//			cache : false,
//			data : 'id=' + rows.id,
//			type : 'post',
//			dataType : 'JSON',
//			success : function(r) {
//				if (r.success) {
//					editor.$txt.html(r.obj);
//					// 禁用
//					editor.disable();
//				} else {
//					$.messager.alert('系统提示', '抱歉，出错了。', 'info');
//				}
//			}
//		});
//
//	} else if (type == 3) {// edit
//		var rows = $('#girdNewsManage').datagrid('getSelected');
//		$.ajax({
//			url : appName + '/webapp/newsContent/',
//			cache : false,
//			data : 'id=' + rows.id,
//			type : 'post',
//			dataType : 'JSON',
//			success : function(r) {
//				if (r.success) {
//					editor.$txt.html(r.obj);
//					$('#editContent').val(r.obj);
//					editor.onchange = function() {
//						var htmltext = this.$txt.html();
//						$('#editContent').val(htmltext);
//					}
//				} else {
//					$.messager.alert('系统提示', '抱歉，出错了。', 'info');
//				}
//			}
//		});
//	}


// 编辑器的销毁方法
function deleteEditor() {
	var editor = new wangEditor('editor-trigger');
	editor.undestroy();
}
//周边游预览

function previewFrom() {
	var timeclock;
	$("#basicMessage").hide();
	$("#activeDetail").hide();
	$("#previewDialog").show();
	var path=$(".up-img").attr("src");
	$("#TicketInformation>img").attr("src",path);
    $("#ptitle").text($("#etitle").val());
    $("#poriginalPrice").text($("#eoriginalPrice").val());
    $("#pnewPrice").text($("#ecurrentPrice").val());
    $("#pplace").text($("#elocation").val());
    $("#pticket").text($("#eticketNum").val());
//	console.log(editor2.txt.text());
    $("#ptime").text($("#eendValidPeriod").val());
    //倒计时
    var endtime=new Date($("#eendValidPeriod").val());
//     var endtime = new Date(Date.parse($("#eendValidPeriod").val().replace(/-/g,"/")));
    var endyear=endtime.getFullYear();
    var endMonth=endtime.getMonth();
    var endDate=endtime.getDate(); 
    var interval = 1000; 
    function ShowCountDown(year,month,day,divname) 
    { 
    	//如果cc不存在，定时器关闭
  
    var now = new Date(); 
    var endDate = new Date(year, month, day); 
    var leftTime=endDate.getTime()-now.getTime(); 
    var leftsecond = parseInt(leftTime/1000); 
    //var day1=parseInt(leftsecond/(24*60*60*6)); 
    var day1=Math.floor(leftsecond/(60*60*24)); 
    var hour=Math.floor((leftsecond-day1*24*60*60)/3600); 
    var minute=Math.floor((leftsecond-day1*24*60*60-hour*3600)/60); 
    var second=Math.floor(leftsecond-day1*24*60*60-hour*3600-minute*60); 
    var cc = document.getElementById(divname); 
  	
	if (cc == undefined) {
		window.clearInterval(timeclock);
	}else {
	    cc.innerHTML = hour+":"+minute+":"+second; 

	}
    } 
      timeclock=window.setInterval(function(){ShowCountDown(endyear,endMonth+1,endDate,'divdown1');}, interval);
    //轮播图
    var pics_val=$('#adImage').val();
    var arr;
	console.log(pics_val);
    arr=pics_val.split(',');
    
    for (var i = 0; i<arr.length; i ++) {
    	if (arr[i] == "") {
			arr.splice(i,1);
			break;
		}
    }
	for( var i=0;i<arr.length;i++){
	
		var imgSrc = arr[i];
		var li = document.createElement("li");
		li.setAttribute('class','item ');
		li.innerHTML = "<img src=" +imgSrc + " width='300px'  height='200px'/>";
		$("#swiperimgs").append(li);
	}
	 var screen = document.getElementById("screen");
	 var ul = screen.children[0];
     var ulLis = ul.children;
    if (ulLis.length == 1) {
    	return;
    }
     var imgWidth = screen.offsetWidth; //减去border，按需要来

     var pic = 0;
     var timer = setInterval(function() {
         //如果是假图片（最后一张图片），瞬间变成真图片
         if (pic == ulLis.length - 1) {
             pic = 0;
             ul.style.left = "0px";
         }

         //不用干预这三行
         pic++;
         //移动ul
         var target = -pic * imgWidth;
         animate(ul, target);

     }, 2000);
     
     function animate(element, target) {
    	    if(element.timer) {
    	        clearInterval(element.timer);
    	    }

    	    element.timer = setInterval(function () {
    	        var leader = element.offsetLeft;
    	        var step = 30;
    	        if(target < leader) {
    	            //往左跑
    	            step = - step;
    	        }

    	        //只有到终点的距离大于一步的距离的时候，才跑
    	        //否则，就不跑了，清除定时器，并且抱到终点去
    	        var distance = Math.abs(target-leader);
    	        if(distance >= Math.abs(step)) {
    	            leader = leader + step;
    	            element.style.left = leader + "px";
    	        }else {
    	            clearInterval(element.timer);
    	            element.style.left = target + "px";
    	        }
    	        //console.log("代码还在执行吗");
    	    }, 15);
    	}

}
//编辑信息切换
function closeActiveDetail(){
	 $("#basicMessage").show();
	 $("#activeDetail").hide();
	 $("#previewDialog").hide();
	 $("#closeActive").css("background-color", "gray");
	 $("#closeBasic").css("background-color", "#52c4f7");
	 
}
function closeBasicMessage(){
	$("#basicMessage").hide();
	$("#activeDetail").show();
	$("#previewDialog").hide();
	$("#closeBasic").css("background-color", "gray");
	$("#closeActive").css("background-color", "#52c4f7");
	var addAcityChoose_val=$('#addAcityChoose').combobox('getValue');
	//获取城市列表
	$('#routeid').combobox({
		url : appName + '/neighbouringTour/specialLines',
		valueField : 'routeid',
		textField : 'routename',
		method:'get',
		onBeforeLoad: function(param){
			param.cityCode =addAcityChoose_val;
		},
		loadFilter : function(data) {
			if (data.success && data.obj.length!=0) {
				data.obj[0].selected = true;
				return data.obj;
			}
		}
	});
	
}
$('#cityChoose').combobox({
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
   $(document).ready(function () {
	   $('.tabtitle li').click(function () {
	   var index = $(this).index();
	   if(index==0){
		   $("#activeDiv").show();
		   $("#ticketDiv").hide();
	   }else{
		   $("#ticketDiv").show();
		   $("#activeDiv").hide();
	   }
	   });
	   })
//多个图片上传 
   function uploadfiles(id,formId,iconUrlId){
	    var imgPath=$('#'+id).val();
		var strExtension = imgPath.substr(imgPath.lastIndexOf('.') + 1).toLowerCase();
          $("#"+formId).form('submit',{
			url:appName+'/suggestion/uploadMultipartFiles',
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
//				    $("#avdImage").val(showUrl);
//					$("#adImage").val(showUrl);
					imgKeyValue.imgArr[imgKeyValue.imgKey] = showUrl;
					var $adImage = $("#adImage");
                    console.log($adImage.val());
		                if ($adImage.val() == "") {
		                    $adImage.val(showUrl);
		                }else {
		                    $adImage.val($adImage.val() + "," + showUrl);
		                }
		                pic_val=$adImage.val()
		           
		        }else{
					$.messager.alert('系统提示','info'); 
				}
			},
			error:function(){
				$.messager.alert('系统提示','抱歉，出错了。','info'); 
			}
		});
	}   	   
//新增保存按钮
function submitFrom(){
	        var addAcityChoose_val=$('#qcityChoose').combobox('getValue');
		    var atitle_val=$("#atitle").val();
		    var alocation_val=$("#alocation").val();
		    var abriefIntroduction_val=$("#abriefIntroduction").val();
			var startValidPeriod_val=$("#startValidPeriod").val();
			var endValidPeriod_val=$('#endValidPeriod').val();
			var yyTime_val=$('#yyTime').val();
			var acurrentPrice_val=$('#acurrentPrice').val();
			var aoriginalPrice_val=$('#aoriginalPrice').val();
			var aticketNum_val=$('#aticketNum').val();
			var activeDiv_val=$('#activeDiv').text();
			var ticketDiv_val=$('#ticketDiv').text();
			var isPermanentValid_val=$('input:radio:checked').val();
			var DATE_FORMAT = /^(\d{4})-(\d{2})-(\d{2})$/;
			/*var imgsStr="";
			for(i=0;i<$(".up-section>.up-img").length;i++){
				imgsStr += $(".up-section>.up-img")[i].src + ",";
			}*/
			var relatedCustomline_val=$('#routeid').combobox('getValue');
			var str=yyTime_val.split(",");
			for(i=0;i<str.length;i++){
				if(!DATE_FORMAT.test(str[i])){
					$.messager.alert('系统提示','<div class="item-errortip">请输入正确日期格式</div>','info'); 
					return false;
				}
			}
			if(!$("#addtravelFrom").form("validate")){
					return false;
				}
			 if(addAcityChoose_val == undefined || addAcityChoose_val == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请选择城市</div>','info'); 
					return false;
				}
			 if(isPermanentValid_val == undefined || isPermanentValid_val == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请选择有效期</div>','info'); 
					return false;
				}
			 if($('#atitle').val() == undefined || $('#atitle').val().trim() == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请输入标题</div>','info'); 
					return false;
				}
			 if(isPermanentValid_val==0 && $('#startValidPeriod').val().trim() == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请输入有效期起始时间</div>','info'); 
					return false;
				}
			if(isPermanentValid_val==0 && $('#endValidPeriod').val().trim() == '') {
					$.messager.alert('系统提示','<div class="item-errortip">请输入有效期结束时间</div>','info'); 
					return false;
				}
			if($('#yyTime').val() == undefined || $('#yyTime').val().trim() == '' ) {
				$.messager.alert('系统提示','<div class="item-errortip">请输入正确格式出行日期</div>','info'); 
				return false;
			}
			 
			
			if($('#acurrentPrice').val() == undefined || $('#acurrentPrice').val().trim() == '' || isNaN( acurrentPrice_val )) {
				$.messager.alert('系统提示','<div class="item-errortip">请输入正确格式现价</div>','info'); 
				return false;
			}
			if($('#aoriginalPrice').val() == undefined || $('#aoriginalPrice').val().trim() == '' || isNaN( aoriginalPrice_val )) {
				$.messager.alert('系统提示','<div class="item-errortip">请输入正确格式原价</div>','info'); 
				return false;
			}
			if($('#aticketNum').val() == undefined || $('#aticketNum').val().trim() == '' || isNaN( aticketNum_val )) {
				$.messager.alert('系统提示','<div class="item-errortip">请输入正确格式票数</div>','info'); 
				return false;
			}
			if(pic_val == undefined || pic_val == '') {
				$.messager.alert('系统提示','<div class="item-errortip">请选择图片</div>','info'); 
				return false;
			}
			if(activeDiv_val == undefined || activeDiv_val == '') {
				$.messager.alert('系统提示','<div class="item-errortip">请输入活动详情</div>','info'); 
				return false;
			}
			if(ticketDiv_val == undefined || ticketDiv_val == '') {
				$.messager.alert('系统提示','<div class="item-errortip">请输入购票需知</div>','info'); 
				return false;
			}
		    var params={
					cityCode:addAcityChoose_val,
					title:atitle_val,
					location:alocation_val,
					briefIntroduction:abriefIntroduction_val,
					startValidPeriod:startValidPeriod_val,
					endValidPeriod:endValidPeriod_val,
					tripDate:yyTime_val,
					currentPrice:acurrentPrice_val,
					originalPrice:aoriginalPrice_val,
					ticketNum:aticketNum_val,
				    pics:pic_val,
					relatedCustomline:relatedCustomline_val,
					eventDetail:activeDiv_val,
					ticketNote:ticketDiv_val,
					//isPermanentValid:isPermanentValid_val,
					isPermanentValid:true
			}
		   
			$.ajax({
				url : appName+'/neighbouringTour/addTravel',
				//url : appName+'/neighbouringTour/updateTravel',
				cache : false,
		        type : 'post',
//   			type : 'get',
//				data:params,
			    data:JSON.stringify(params),
			    contentType: "application/json; charset=utf-8",
				dataType : 'json',
				success : function(result) {
					if (result.success) {
						$.messager.alert('系统提示',result.msg,'info',function(){
							  publicClose();
						});
						$('#girdTravelAround').datagrid('reload');
					}else{
						$.messager.alert('系统提示',result.msg,'info'); 
					}
				}
			})
}
//周边游编辑提交
function submitEditFrom() {
	       var eid_val=$("#eid").val();
	       var eddAcityChoose_val=$('#addAcityChoose').combobox('getValue');
	       var etitle_val=$("#etitle").val();
	       var elocation_val=$("#elocation").val();
	       var ebriefIntroduction_val=$("#ebriefIntroduction").val();
		   var estartValidPeriod_val=$("#estartValidPeriod").val();
		   var eendValidPeriod_val=$('#eendValidPeriod').val();
		   var eyyTime_val=$('#yyTime').val();
		   var ecurrent_val=$("#ecurrentPrice").val();
		   var eoriginalPrice_val=$('#eoriginalPrice').val();
		   var eticketNum_val=$('#eticketNum').val();
		   var ectiveDiv_val=$('#activeDiv').html();
		   var eticketDiv_val=$('#ticketDiv').html();
		   var eisPermanentValid_val=$('input:radio:checked').val();
		   var relatedCustomline_val=$('#routeid').combobox('getValue');
		   var pics_val=$('#adImage').val();
		   var DATE_FORMAT = /^(\d{4})-(\d{2})-(\d{2})$/;
		   var arrTime=eyyTime_val.split(",");
			for(i=0;i<arrTime.length;i++){
				if(!DATE_FORMAT.test(arrTime[i])){
					$.messager.alert('系统提示','<div class="item-errortip">请输入正确日期格式</div>','info'); 
					return false;
				}
			}
		    
		   var params={
				    id:eid_val,
					cityCode:eddAcityChoose_val,
					title:etitle_val,
					location:elocation_val,
					briefIntroduction:ebriefIntroduction_val,
					startValidPeriod:estartValidPeriod_val,
					endValidPeriod:eendValidPeriod_val,
					tripDate:eyyTime_val,
					currentPrice:ecurrent_val,
					originalPrice:eoriginalPrice_val,
					ticketNum:eticketNum_val,
         		    pics:pics_val,
					relatedCustomline:relatedCustomline_val,
					eventDetail:ectiveDiv_val,
					ticketNote:eticketDiv_val,
					isPermanentValid:eisPermanentValid_val,
					isPermanentValid:true,
					
			}
		   
			if(!$('#editAdvertFrom').form("validate")){
					return false;
				}
		   if(eddAcityChoose_val == undefined || eddAcityChoose_val == '') {
				$.messager.alert('系统提示','<div class="item-errortip">请选择城市</div>','info'); 
				return false;
			}
		   if(pics_val == undefined || pics_val == '') {
				$.messager.alert('系统提示','<div class="item-errortip">请选择图片</div>','info'); 
				return false;
			}
		  if(eisPermanentValid_val == undefined || eisPermanentValid_val == '') {
				$.messager.alert('系统提示','<div class="item-errortip">请选择有效期</div>','info'); 
				return false;
			}
		  if($('#etitle').val() == undefined || $('#etitle').val().trim() == '') {
			$.messager.alert('系统提示','<div class="item-errortip">请输入标题</div>','info'); 
				return false;
			}
		  if(eisPermanentValid_val==0 && $('#estartValidPeriod').val().trim() == '') {
				$.messager.alert('系统提示','<div class="item-errortip">请输入有效期起始时间</div>','info'); 
				return false;
		 }
		 if(eisPermanentValid_val==0 && $('#eendValidPeriod').val().trim() == '') {
				$.messager.alert('系统提示','<div class="item-errortip">请输入有效期结束时间</div>','info'); 
				return false;
		 	}
	     if(eyyTime_val == undefined || eyyTime_val == '') {
			$.messager.alert('系统提示','<div class="item-errortip">请输入出行日期</div>','info'); 
			return false;
		}
         if(ecurrent_val == undefined || ecurrent_val == '' || isNaN( ecurrent_val )) {
		   $.messager.alert('系统提示','<div class="item-errortip">请输入现价</div>','info'); 
		   return false;
	    }
		 if($('#eoriginalPrice').val() == undefined || $('#eoriginalPrice').val().trim() == ''|| isNaN( $('#eoriginalPrice').val())) {
			$.messager.alert('系统提示','<div class="item-errortip">请输入原价</div>','info'); 
			return false;
		}
		 if($('#eticketNum').val() == undefined || $('#eticketNum').val().trim() == ''|| isNaN($('#eticketNum').val())) {
			$.messager.alert('系统提示','<div class="item-errortip">请输入票数</div>','info'); 
			return false;
		}
		
		 if(ectiveDiv_val == undefined || ectiveDiv_val == '') {
			$.messager.alert('系统提示','<div class="item-errortip">请输入活动详情</div>','info'); 
			return false;
		}
		 if(eticketDiv_val == undefined || eticketDiv_val == '') {
			$.messager.alert('系统提示','<div class="item-errortip">请输入购票需知</div>','info'); 
			return false;
		}
			$.ajax({
					url : appName+'/neighbouringTour/updateTravel',
					cache : false,
			        type : 'post',
//	   			    type : 'get',
//					data:params,
				    data:JSON.stringify(params),
				    contentType: "application/json; charset=utf-8",
					dataType : 'json',
					success : function(result) {
						if (result.success) {
							$.messager.alert('系统提示',result.msg,'info',function(){
								  publicClose();
							});
							$('#girdTravelAround').datagrid('reload');
						}else{
							$.messager.alert('系统提示',result.msg,'info'); 
						}
					}
				})
			
}

			
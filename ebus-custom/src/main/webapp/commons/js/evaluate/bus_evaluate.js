/*  wxl   2016 12/20 
 * initDatagridBusEvaluate
 */
$(function(){
	//初始化initDatagridBusEvaluate表格
	initDatagridBusEvaluate();
});
var appName=$('#appName').val();
//初始化initDatagridBusEvaluate funtion
function initDatagridBusEvaluate(){
	  var height=setDatagirdTable();
	$('#gridBusEvaluate').datagrid({
	    //title:'普通表单-用键盘操作',
         method:'post',
	  url:appName+'/webapp/queryBusEvaluationList',
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
          {field:'ck',checkbox:true},
          {field:'routename',title:'线路',width:80,align:'center'},
          {field:'evaluatobjname',title:'车牌号',width:80,align:'center',editor:'textbox'},
          {field:'username',title:'评价人',width:80,align:'center'},
          {field:'createtime',title:'评价时间',width:100,align:'center',
        	  formatter:function(value) {
        			if(value != undefined&&value!=null&&value != '') {
        				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
        			}
          	  }
          },
          {field:'type',title:'评价类型',width:80,align:'center',
        	  formatter: function(value){
					if(value==1) {
						return '未停靠途径站点';
					}else if(value == 2) {
						return '拥挤情况';
					}else if(value == 3) {
						return '突发事件';
					}
					else if(value == 4) {
						return '司机服务';
					}else if(value == 5) {
						return '整洁情况';
					}
					else if(value == 6) {
						return '车内温度';
					}else if(value == 7) {
						return '车站设施';
					}
					else if(value == 8) {
						return '大型活动';
					} 
				}
          },
          {field:'score',title:'评分',width:80,align:'center'},
          {field:'comment',title:'更多细节',width:240,align:'center',
        	  formatter: function(value){
					if(value.substr(0,2)== 11) {
						return value.substr(3);
					}else if(value.substr(0,2)== 21) {
						return '宽敞'+value.substr(2);
					} else if(value.substr(0,2)== 22) {
						return '半满'+value.substr(2);
					} else if(value.substr(0,2)== 23) {
						return '满座'+value.substr(2);
					} else if(value.substr(0,2)== 24) {
						return '拥挤'+value.substr(2);
					} else if(value.substr(0,2)== 31) {
						return '安全事故'+value.substr(2);
					} else if(value.substr(0,2)== 32) {
						return '医疗紧急情况'+value.substr(2);
					} else if(value.substr(0,2)== 33) {
						return '火警'+value.substr(2);
					} else if(value.substr(0,2)== 34) {
						return '其他'+value.substr(2);
					}else if(value.substr(0,2)== 40) {
						return '0颗星'+value.substr(2);
					}else if(value.substr(0,2)== 41) {
						return '1颗星'+value.substr(2);
					}else if(value.substr(0,2)== 42) {
						return '2颗星'+value.substr(2);
					}else if(value.substr(0,2)== 43) {
						return '3颗星'+value.substr(2);
					}else if(value.substr(0,2)== 44) {
						return '4颗星'+value.substr(2);
					}else if(value.substr(0,2)== 45) {
						return '5颗星'+value.substr(2);
					}else if(value.substr(0,2)== 51) {
						return '非常整洁'+value.substr(2);
					}else if(value.substr(0,2)== 52) {
						return '整洁'+value.substr(2);
					}else if(value.substr(0,2)== 53) {
						return '脏乱'+value.substr(2);
					}else if(value.substr(0,2)== 54) {
						return '十分脏乱'+value.substr(2);
					}else if(value.substr(0,2)== 61) {
						return '很冷'+value.substr(2);
					}else if(value.substr(0,2)== 62) {
						return '凉快'+value.substr(2);
					}else if(value.substr(0,2)== 63) {
						return '适宜'+value.substr(2);
					}else if(value.substr(0,2)== 64) {
						return '温暖'+value.substr(2);
					}else if(value.substr(0,2)== 65) {
						return '炎热'+value.substr(2);
					}else if(value.substr(0,2)== 71) {
						return '站台'+value.substr(2);
					}else if(value.substr(0,2)== 72) {
						return '电子站牌'+value.substr(2);
					}else if(value.substr(0,2)== 73) {
						return '电梯'+value.substr(2);
					}else if(value.substr(0,2)== 74) {
						return '其他'+value.substr(2);
					}else if(value.substr(0,2)== 81) {
						return '表演'+value.substr(2);
					}else if(value.substr(0,2)== 82) {
						return '特卖'+value.substr(2);
					}else if(value.substr(0,2)== 83) {
						return '音乐'+value.substr(2);
					}else if(value.substr(0,2)== 84) {
						return '其他'+value.substr(2);
						}
					}
            },
      ]],
      loadFilter: function(data){
    	  console.log(data);
    	  if (data.success){
				return data.obj;
			} else {
				$.messager.alert('系统提示','抱歉，出错了。','info');
			}
     	}
	});
}
$(document).on('click','#query',function(){
		$('#gridBusEvaluate').datagrid("load",{
			routeName:$("#routeName").val(),
			evaluatObjName:$("#evaluatObjName").val(),
			userName:$("#userName").val(),
			startDate:$("#startDate").val(),
			endDate:$("#endDate").val()
		});
	});
//详情window
function detailInfo(){
	var array = $("#gridBusEvaluate").datagrid("getChecked");
	if(array.length<=0){
		$.messager.alert('系统提示','请选择要查看的记录！','info');
	}else if(array.length>=2){
		$.messager.alert('系统提示','只能选择一个记录！','info');
	}else{
		$('#droutename').val(array[0].routename);
			$('#dbusnumber').val(array[0].evaluatobjname);
			$('#dusername').val(array[0].username);
		    $('#devalutime').val(
			(array[0].createtime == undefined ||array[0].quotedtime == '')?
					array[0].createtime:
					new Date(array[0].createtime).Format("yyyy-MM-dd hh:mm:ss"));
			if(array[0].type==1) {
			$('#dtype').val('未停靠途径站点');
		}else if(array[0].type == 2) {
			$('#dtype').val( '拥挤情况');
		}else if(array[0].type == 3) {
			$('#dtype').val( '突发事件');
		}
		else if(array[0].type == 4) {
			$('#dtype').val( '司机服务');
		}else if(array[0].type == 5) {
			$('#dtype').val('整洁情况');
		}
		else if(array[0].type == 6) {
			$('#dtype').val('车内温度');
		}else if(array[0].type == 7) {
			$('#dtype').val( '车站设施');
		}
		else if(array[0].type == 8) {
			$('#dtype').val( '大型活动');
		} 
			          if(array[0].typedetail== 11) {
			$('#dtypetail').val('');
		}else if(array[0].typedetail== 21) {
			$('#dtypetail').val( '宽敞');
		} else if(array[0].typedetail== 22) {
			$('#dtypetail').val( '半满');
		} else if(array[0].typedetail== 23) {
			$('#dtypetail').val( '满座');
		} else if(array[0].typedetail== 24) {
			$('#dtypetail').val( '拥挤');
		} else if(array[0].typedetail== 31) {
			$('#dtypetail').val( '安全事故');
		} else if(array[0].typedetail== 32) {
			$('#dtypetail').val( '医疗紧急情况');
		} else if(array[0].typedetail== 33) {
			$('#dtypetail').val( '火警');
		} else if(array[0].typedetail== 34) {
			$('#dtypetail').val( '其他');
		}else if(array[0].typedetail== 40) {
			$('#dtypetail').val( '0颗星');
		}else if(array[0].typedetail== 41) {
			$('#dtypetail').val( '1颗星');
		}else if(array[0].typedetail== 42) {
			$('#dtypetail').val( '2颗星');
		}else if(array[0].typedetail== 43) {
			$('#dtypetail').val( '3颗星');
		}else if(array[0].typedetail== 44) {
			$('#dtypetail').val( '4颗星');
		}else if(array[0].typedetail== 45) {
			$('#dtypetail').val( '5颗星');
		}else if(array[0].typedetail== 51) {
			$('#dtypetail').val( '非常整洁');
		}else if(array[0].typedetail== 52) {
			$('#dtypetail').val( '整洁');
		}else if(array[0].typedetail== 53) {
			$('#dtypetail').val( '脏乱');
		}else if(array[0].typedetail== 54) {
			$('#dtypetail').val( '十分脏乱');
		}else if(array[0].typedetail== 61) {
			$('#dtypetail').val( '很冷');
		}else if(array[0].typedetail== 62) {
			$('#dtypetail').val( '凉快');
		}else if(array[0].typedetail== 63) {
			$('#dtypetail').val( '适宜');
		}else if(array[0].typedetail== 64) {
			$('#dtypetail').val( '温暖');
		}else if(array[0].typedetail== 65) {
			$('#dtypetail').val( '炎热');
		}else if(array[0].typedetail== 71) {
			$('#dtypetail').val( '站台');
		}else if(array[0].typedetail== 72) {
			$('#dtypetail').val( '电子站牌');
		}else if(array[0].typedetail== 73) {
			$('#dtypetail').val( '电梯');
		}else if(array[0].typedetail== 74) {
			$('#dtypetail').val( '其他');
		}else if(array[0].typedetail== 81) {
			$('#dtypetail').val( '表演');
		}else if(array[0].typedetail== 82) {
			$('#dtypetail').val( '特卖');
		}else if(array[0].typedetail== 83) {
			$('#dtypetail').val( '音乐');
		}else if(array[0].typedetail== 84) {
			$('#dtypetail').val( '其他');
		}
			$('#dscore').val(array[0].score);
			$('#dcomment').val(array[0].comment.substr(3));
			$("#detailWin").removeClass("hide");
		   $("#detailWin").window("open");
	}
}	 
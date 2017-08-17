<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
      <!-- common header -->
      <%@ include file="/webviews/common/header.jsp"%>
       <title>welcome</title>	
</head>
<body class="easyui-layout wrapper">   
   <!-- common header html -->
    <div class="header" data-options="region:'north'">
		<div class="appAfter">
		<a href="/ebus-custom/webviews/main.jsp">
		   <img class="logo" src="${appName}/pic/logo.png">
		   </a>
		</div>
		<div class="report">
			 <span><i class="repArw"></i>蓝泰源APP管理系统<i class="repArwline"></i></span>
			<div class="login" onclick="logout();">
		         <img  class="logoutImg fl" src="${appName}/pic/login.jpg">
		         <em class="logoutText">退出登录</em>
		   </div>
		</div>
	</div> 
	
  <!-- common menu html -->
    <div data-options="region:'west',title:' ',split:true"  class="navleft">
    	 <ul id="navMenu"  class="navTree" ></ul> 
    </div>  
  <!-- common content html -->
    <div data-options="region:'center'"> 
	    <div id="tab" class="easyui-tabs" data-options="region:'center',fit:true">
	    	<div title="Welcome" data-options="closable:true">   
		          welcome
		    </div>
	    </div>   
    </div>
   <!-- common header html -->
     <div class="footer" data-options="region:'south',title:'<div class=foottext>深圳市蓝泰源信息技术股份有限公司</div>',split:false,collapsible:false" ></div>  

</body>  
    <!-- common footer -->
    <%@ include file="/webviews/common/footer.jsp"%>
   <%--  <script type="text/javascript" src="${appName}/commons/js/system/main.js"></script>  --%>
	<script type="text/javascript">
		$(function(){
			var userCityCode = ${userSession.citycode};
			var data;
			if(userCityCode == -1) {
				data = 
					[
			           /* 	{"id": 1, "menuName": "定制公交","menuPath":"/webviews/customline.jsp","iconCls":"tree-area"},
			           	{"id": 2, "menuName": "专车管理","menuPath":"/webviews/bookbus.jsp","iconCls":"tree-busmange"}, */
			           	{"id": 1, "menuName": "订单中心","menuPath":"","iconCls":"tree-order",
			           		"children":[{    
				                "id":"1","menuName": "订单记录","menuPath":"/webviews/order_record.jsp","iconCls":"tree-record"
				            },{    
				                "id":"2","menuName": "订单审核","menuPath":"/webviews/order_verify.jsp","iconCls":"tree-check"
				            }]
			           	},
			           	{"id": 2, "menuName": "客服中心","menuPath":"/webviews/evaluation.jsp","iconCls":"tree-assess",
			           		"children":[   
				                {    
				                "id":"1","menuName": "客服问题","menuPath":"/webviews/station_evaluate.jsp","iconCls":"tree-bus-record"
				            },{"id": 2, "menuName": "评价管理","menuPath":"/webviews/suggestion.jsp","iconCls":"tree-suggest"},]
			           	},
			        
			        	{"id": 3, "menuName": "信息中心","menuPath":"/webviews/newsManage/newsManage.jsp","iconCls":"tree-news",
						"children":[{
						  "id":"1","menuName": "通知记录","menuPath":"/webviews/newsManage/noticeRecord.jsp","iconCls":"tree-evaluat-record"
						    },
						    {"id": 2, "menuName": "广告屏闪管理","menuPath":"/webviews/advertManage/advertManage.jsp","iconCls":"tree-advertise"},
						    {"id": 3, "menuName": "周边游","menuPath":"/webviews/travelAround/travelAround.jsp","iconCls":"tree-advertise"}, 
						   ]
			        	 },
			        	 
			        	
			        	{"id": 3, "menuName": "城市IP配置","menuPath":"/webviews/cityIpConfig/cityIpConfig.jsp",},
			        	{"id": 5, "menuName": " 用户统计","menuPath":"/webviews/userCount/userCount.jsp",
			        		"children":[{
			        			"id": 1, "menuName": "趋势分析","menuPath":"/webviews/trendAnalysis/trendAnalysis.jsp","iconCls":"tree-trend "},
			        			{"id": 2, "menuName": "城市od导向图","menuPath":"/webviews/cityGuideMap/cityGuideMap.jsp","iconCls":"tree-dx "},
								]	
			        	},
			  /*       	{"id": 10, "menuName": "趋势分析","menuPath":"/webviews/trendAnalysis/trendAnalysis.jsp","iconCls":"tree-trend "},
			        	{"id": 11, "menuName": "城市od导向图","menuPath":"/webviews/cityGuideMap/cityGuideMap.jsp","iconCls":"tree-dx "}, */
			        	{"id": 6, "menuName": "驾校管理","menuPath":"/webviews/drivingDecords/drivingDecords.jsp","iconCls":"tree-dx ",
			        		"children":[{    
				                "id":"1","menuName": "驾校信息发布","menuPath":"/webviews/drivingDecords/drivingPublish.jsp","iconCls":"tree-account"
				            }]
			        	},
			        	{"id": 7, "menuName": "账目统计","menuPath":"/webviews/accountStatistics/accountStatistics.jsp","iconCls":"tree-wallt",
			        		"children":[{    
				                "id":"1","menuName": "应收应付统计","menuPath":"/webviews/accountStatistics/receivableStatistics.jsp","iconCls":"tree-account"
				            },{    
				                "id":"2","menuName": "充值记录","menuPath":"/webviews/accountStatistics/rechargeRecord.jsp","iconCls":"tree-cz"
				            }]
			        	} ,
			        	{"id": 8, "menuName": "拼车管理","iconCls":"tree-busmange",
			        		"children":[{    
				                "id":"1","menuName": "拼车管理-拼车记录","menuPath":"/webviews/carpoolManage/carpoolRecord.jsp","iconCls":"tree-account"
				            },{    
				                "id":"2","menuName": "拼车管理-撮合设置","menuPath":"/webviews/carpoolManage/carpoolMatch.jsp","iconCls":"tree-cz"
				            }]
			        	} ,
			        	/*{"id": 9, "menuName": "app版本管理","menuPath":"/webviews/baseVersion/baseVersion.jsp","iconCls":"tree-complain "}  */
			        ];
			}else {
				data = 
					[
			           /* 	{"id": 1, "menuName": "定制公交","menuPath":"/webviews/customline.jsp","iconCls":"tree-area"},
			           	{"id": 2, "menuName": "专车管理","menuPath":"/webviews/bookbus.jsp","iconCls":"tree-busmange"}, */
			           	{"id": 1, "menuName": "订单中心","menuPath":"","iconCls":"tree-order",
			           		"children":[{    
				                "id":"1","menuName": "订单记录","menuPath":"/webviews/order_record.jsp","iconCls":"tree-record"
				            }]
			           	},
			           	{"id": 2, "menuName": "客服中心","menuPath":"/webviews/evaluation.jsp","iconCls":"tree-assess",
			           		"children":[{    
				                "id":"1","menuName": "客服问题","menuPath":"/webviews/station_evaluate.jsp","iconCls":"tree-bus-record"
				            },
				        	{"id": 2, "menuName": "评价管理","menuPath":"/webviews/suggestion.jsp","iconCls":"tree-suggest"}]
			           	},
			        	{"id": 3, "menuName": "信息中心","menuPath":"/webviews/newsManage/newsManage.jsp","iconCls":"tree-news",
							"children":[{
								"id":"1","menuName": "通知记录","menuPath":"/webviews/newsManage/noticeRecord.jsp","iconCls":"tree-evaluat-record"
							},{"id": 2, "menuName": "广告屏闪管理","menuPath":"/webviews/advertManage/advertManage.jsp","iconCls":"tree-advertise"},
							{"id": 3, "menuName": "周边游","menuPath":"/webviews/travelAround/travelAround.jsp","iconCls":"tree-advertise"}, 
							]
		                },
		                {"id": 4, "menuName": "拼车管理","iconCls":"tree-busmange",
			        		"children":[{    
				                "id":"1","menuName": "拼车管理-拼车记录","menuPath":"/webviews/carpoolManage/carpoolRecord.jsp","iconCls":"tree-account"
				            },{    
				                "id":"2","menuName": "拼车管理-撮合设置","menuPath":"/webviews/carpoolManage/carpoolMatch.jsp","iconCls":"tree-cz"
				            }]
			        	} ,

			        ];
			}
			
			
			$('#navMenu').tree({
	            data:data,
	            onClick: function (node) {
	                var tb = $("#tab").tabs("getTab", node.menuName);
	                if (tb == 'undefined' || tb == null) {
	                	if(node.menuPath == undefined || node.menuPath == 'undefined' || node.menuPath == ''){
	                		return false;
	                	}
	                    $("#tab").tabs("add", { fit: true, title: node.menuName, selected: true, content: '<iframe src="${appName}' + node.menuPath + '"  height="99%" width="99%" frameborder="0"/>', closable: true });
	                } else {
	                    $("#tab").tabs("select", node.menuName);
						 tb.panel('refresh');
	                }
	            },
	            formatter: function (node) {
	                return "<div style='height:39px,text-align:center'>" + node.menuName + "</div>";
	            }
	        });
	       
	       $('#tab').tabs({
			tools:[{
					iconCls:'icon-clear',
					handler:function(){
						var tabs = $("#tab").tabs("tabs");
						var len = tabs.length;
						for(var i=0;i<len;i++){
							$("#tab").tabs("close",0);
						}
					}
				}]
			});
			
		  });
		function logout() {
			$.ajax({
		   		type:"get",
		   		url:"${appName}/webapp/logout",
		   		dataType:"json",
		   		success:function(data){
	   				if(data.success){
		   				window.location.href="${appName}/login.jsp";
		   			}else{
		   				$.messager.alert('系统提示',data.msg,'info');
		   			}
		   		},
				error:function(){
					$.messager.alert('系统提示','抱歉，出错了。','info');
				}
			 });
		}

	</script>
</html>
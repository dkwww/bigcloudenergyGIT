$(function(){
	querySell();
	queryRepertory();
	queryMedicinal();
});
//查询药品销量
function querySell(){
	var url="/Drug/main/queryList.action";
	var data=null
	$.post(url,data,function(mes){
		showSell(mes);
	},"json");
}
//查询药品
function queryRepertory(){
	var url="/Drug/main/queryRepertory.action";
	var data=null;
	$.post(url,data,function(mes){
		queryStatistics(mes);
	},"json");
}
/**
 * 查询药材
 * @returns
 */
function queryMedicinal(){
	var url="/Drug/main/queryMaterials.action";
	var data=null;
	$.post(url,data,function(mes){
		queryMaterials(mes);
	},"json");
}
function showSell(mes){
	console.log(mes);
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('sales'));
    option = {
    	    title: {
    	        text: '零售最受欢迎统计'
    	    },
    	    tooltip : {
    	        trigger: 'axis',
    	        axisPointer: {
    	            type: 'cross',
    	            label: {
    	                backgroundColor: '#6a7985'
    	            }
    	        }
    	    },
    	    legend: {
    	        data:mes.name
    	    },
    	    toolbox: {
    	        feature: {
    	            saveAsImage: {}
    	        }
    	    },
    	    grid: {
    	        left: '3%',
    	        right: '4%',
    	        bottom: '3%',
    	        containLabel: true
    	    },
    	    xAxis : [
    	        {
    	            type : 'category',
    	            boundaryGap : false,
    	            data : ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value'
    	        }
    	    ],
    	    series :mes.data
    	};

	// 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}
function queryStatistics(mes){
	console.log(mes);
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('repertory'));
	option = {
		    title : {
		        text: '药品库存预警',
		        subtext: '',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        x : '10',
		        y : '30'
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {
		                show: true,
		                type: ['pie', 'funnel']
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    series : [
		        {
		            name:'库存预警',
		            type:'pie',
		            radius : [20, 110],
		            center : ['50%', '50%'],
		            roseType : 'radius',
		            label: {
		                normal: {
		                    show: false
		                },
		                emphasis: {
		                    show: true
		                }
		            },
		            lableLine: {
		                normal: {
		                    show: false
		                },
		                emphasis: {
		                    show: true
		                }
		            },
		            data:mes
		        }
		    ]
		};
	 myChart.setOption(option);
}
function queryMaterials(mes){
	console.log(mes);
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('materials'));
	option = {
		    title : {
		        text: '药材库存预警',
		        subtext: '',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        x : '10',
		        y : '30'
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {
		                show: true,
		                type: ['pie', 'funnel']
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    series : [
		        {
		            name:'药材库存预警',
		            type:'pie',
		            radius : [20, 110],
		            center : ['50%', '50%'],
		            roseType : 'radius',
		            label: {
		                normal: {
		                    show: false
		                },
		                emphasis: {
		                    show: true
		                }
		            },
		            lableLine: {
		                normal: {
		                    show: false
		                },
		                emphasis: {
		                    show: true
		                }
		            },
		            data:mes
		        }
		    ]
		};
	 myChart.setOption(option);
}
$(function(){
	querySell();
});
function querySell(){
	var url="/Drug/main/queryList.action";
	var data=null
	$.post(url,data,function(mes){
		showSell(mes);
	},"json");
}
function queryRepertory(){
	var url="/Drug/main/queryRepertory.action";
	var data=null;
	$.post(url,data,function(mes){
		
	},"json");
}
function showSell(mes){
	console.log(mes);
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('sales'));
    option = {
    	    title: {
    	        text: '堆叠区域图'
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
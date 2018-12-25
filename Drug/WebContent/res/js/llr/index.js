$(function(){
	getSession();
})

/**
 *获取Session
 */
function getSession(){
	$.ajaxSetup({
		async:false,
	})
	//得到Session
	var url = "admin/getSessions.action";
	var data = null;
	var ids=null;
	$.post(url,data,function(mes){
		var urls = "module/findByModule.action";
		var datas = {"adminId":mes.adminId};                                      
		$.post(urls,datas,function(mes){
			$.each(mes,function(index,item){
				$("#LAY-system-side-menu").append('<li class="layui-nav-item">'
				+'<a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span> '+item.modeName+'</span></a>'
	            +'<dl id="'+item.modeId+'" class="layui-nav-child">'
	            +'</dl>'
	            +'</li>');
				var urlss = "module/findByZiModule.action";
				var datass = {"modeId":item.modeId};
				$.post(urlss,datass,function(mes){
					$.each(mes,function(indexs,items){
						$("#"+item.modeId).append("<dd><a href='javascript:;' kit-target data-options={url:'./"+items.modeUrl+"',icon:'&#xe658;',title:'"+items.modeName+"',id:'"+items.modeId+"'}><i class='layui-icon'>&#xe614;</i><span> "+items.modeName+"</span></a></dd>")
					})
				},"json")
			});
			layui.use('element', function() { var element = layui.element; element.init();});
		},"json")
	},"json")
	$.ajaxSetup({
		async:true,
	})
}
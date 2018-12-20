$(function(){
	getSession();
})

/**
 *获取Session
 */
function getSession(){
	//得到Session
	var url = "admin/getSessions.action";
	var data = null;
	var ids=null;
	$.post(url,data,function(mes){
		var urls = "module/findByModule.action";
		var datas = {"adminId":mes.adminId};
		$.post(urls,datas,function(mes){
			$.each(mes,function(index,item){
				if(item.druModeId==null){
					$("#LAY-system-side-menu").append('<li class="layui-nav-item">'
					+'<a  href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span>' +item.modeName+'</span></a>'
		            +'<dl id="dle'+item.modeId+'" class="layui-nav-child">'
		            +'</dl>'
		            +'</li>');
					ids=item.modeId;
				}else{
					$("#dle"+ids).append("<dd><a href='javascript:;' kit-target data-options='{url:"+item.modeUrl+",icon:'&#xe614;',title:"+item.modeName+",id:"+item.modeId+"}'><i class='layui-icon'>&#xe614;</i><span>"+item.modeName+"</span></a></dd>");
				}
			});
			layui.use('element', function() { var element = layui.element; element.init(); });
		},"json")
	},"json")
}
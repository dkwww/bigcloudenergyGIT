$(function(){
	showMenu();
})

function getSession(){
	var admin = null;
	$.ajax({ 
    	url:"./admin/getSession.action",
        type:'post',
        async:false,
        dataType:'json',
        success:function(mes){
        	if (mes!=null && mes!="") {
        		admin = mes;
			} else {
				location.href = "./pages/admin/login.html";
			}
        },
        error: function(){
        	location.href = "./pages/admin/login.html";
        }
	});
	return admin;
}

/**
 *获取Session
 */
function showMenu(){
	
	var admin = getSession();
	if (admin != null) {
		$("#sessionShowId>a").html('<img src="./'+admin.adminPictrue+'" class="layui-nav-img"> '+admin.adminName);
	} else {
		return false;
	}
	$.ajaxSetup({
		async:false,
	})
	
	$.post("./module/findByModule.action",{"adminId":admin.adminId},function(mes){
		$.each(mes,function(index,item){
			$("#LAY-system-side-menu").append('<li class="layui-nav-item">'
			+'<a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span> '+item.modeName+'</span></a>'
            +'<dl id="'+item.modeId+'" class="layui-nav-child">'
            +'</dl>'
            +'</li>');
			$.post("./module/findByZiModule.action",{"modeId":item.modeId,"adminId":admin.adminId},function(mess){
				$.each(mess,function(indexs,items){
					$("#"+item.modeId).append("<dd><a href='javascript:;' kit-target data-options={url:'./"+items.modeUrl+"',icon:'&#xe658;',title:'"+items.modeName+"',id:'"+items.modeId+"'}><i class='layui-icon'>&#xe614;</i><span> "+items.modeName+"</span></a></dd>")
				})
			},"json")
		});
		layui.use('element', function() { var element = layui.element; element.init();});
	},"json");
	
}
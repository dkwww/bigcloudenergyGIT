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
	$.post(url,data,function(mes){
		//根据SessionID查询到子节点
		var urls = "SELECT mo.* FROM drug_module mo,drug_role ro,drug_module_role mr,drug_admin ad,drug_admin_role ar WHERE ad.admin_id = ar.admin_id AND ar.role_id = ro.role_id AND ro.role_id = mr.role_id AND mr.mode_id = mo.mode_id AND ad.admin_id = 11 ;";
		var datas = "父节点ID";
		$.post(url,data,function(mes){
			$.each(mes,function(index,){
				
				//根据父节点节点ID查询模块
				var urls = "SELECT* FROM drug_module WHERE mode_id = 4";
				var datas = "";
				$.post(url,data,function(mes){
					$.each(mes,function(index,){
						
					})
				},"json")
			})
		},"json")
	},"json")
}
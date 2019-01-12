function getSession(str){
	var admin = null;
	$.ajax({ 
		url:str+"admin/getSession.action",
		type:'post',
		async:false,
		dataType:'json',
		success:function(mes){
			if (mes!=null && mes!="") {
				admin = mes;
			} else {
				parent.location.href = str+"pages/admin/login.html";
			}
		},
		error:function(){
			parent.location.href = str+"pages/admin/login.html";
		}
	});
	return admin;
}

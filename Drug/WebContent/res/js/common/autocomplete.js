function autocomplete(formId,data){
	for(var k in data){
		var type = $("#"+formId+" [name="+k+"]").prop("type");

		$("#"+formId+" textarea[name="+k+"]").val(data[k]);
		$("#"+formId+" img[name="+k+"]").attr("src","../../"+data[k]);
		if (type!=undefined&&type!=null) {
			if (type=="text"||type=="hidden") {
				if(data[k]!=""&&data[k]!=null){
					$("#"+formId+" [name="+k+"]").val(data[k]);
				}
			} else if (type=="radio"){
				if (data[k]!=""&&data[k]!=null) {
					$("#"+formId+" [name="+k+"][value="+data[k]+"]").attr("checked","true");
				}
			} else if (type=="checkbox") {
				var ckeckboxVal = data[k];
				if (ckeckboxVal!=""&&ckeckboxVal!=undefined&&ckeckboxVal!=null) {
					if (ckeckboxVal.length==1) {
						$("#"+formId+" [name="+k+"][value="+ckeckboxVal+"]").attr("checked","true");
					} else {
						var str = ckeckboxVal.split(",");
						for (var i = 0; i < str.length; i++) {
							$("#"+formId+" [name="+k+"][value="+str[i]+"]").attr("checked","true");
						}
					}
				}
			}
		}
	}
}

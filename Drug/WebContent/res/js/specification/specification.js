$(function(){
	$.post("../../spec/findById.action",{"drugId":getParameter("id")},function(mes){
		var d = mes.data;
		if (d!=null) {
			$("#page").show();
			$(".header-title>h2").text(d.specName+"说明书");
			$("#main-content").append('<li><h4>【药品名称】</h4><p class="li-context">'+d.specName+'</p></li><li><h4>【成份】</h4><p class="li-context">'+d.specComponent+'</p></li><li><h4>【性状】</h4><p class="li-context">'+d.specTrait+'</p></li><li><h4>【功能主治】</h4><p class="li-context">'+d.specPurpose+'</p></li><li><h4>【适用症状】</h4><p class="li-context">'+d.specPurpose+'</p></li><li><h4>【规格】</h4><p class="li-context">'+d.specSize+'</p></li><li><h4>【用法用量】</h4><p class="li-context">'+d.specUse+'</p></li><li><h4>【不良反应】</h4><p class="li-context">'+d.specEffect+'</p></li><li><h4>【禁忌】</h4><p class="li-context">'+d.specTaboo+'</p></li><li><h4>【注意事项】</h4><p class="li-context">'+d.specNotice+'</p></li><li><h4>【药物相互作用】</h4><p class="li-context">'+d.specInteract+'</p></li><li><h4>【贮藏】</h4><p class="li-context">'+d.specDepot+'</p></li><li><h4>【包装】</h4><p class="li-context">'+d.specPack+'</p></li><li><h4>【有效期】</h4><p class="li-context">'+d.specValidity+'</p></li>');
		} else {
			$("#error").show();
		}
	},"json");
});
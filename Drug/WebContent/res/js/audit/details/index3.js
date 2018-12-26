var pmcId = getParameter("id");
var audState = getParameter("state");
if (audState == "10010" || audState == "10011") {
	$.post("../../../../audit/findByFk.action",{"audFkId": pmcId,"type": 1},function (mes){
		var state = "";
		if (mes.audState == "10010") {
			state = "不通过";
		} else if (mes.audState == "10011") {
			state = "通过";
		}
		$("#property").append('<div class="layui-form-item" style="padding: 8px 0px 0px 8px;color: #FF5722;"><h3>财物审核</h3></div><div class="layui-form-item"><label class="layui-form-label">审核人：</label><div class="layui-input-block" style="line-height: 35px;padding-left: 8px;"><div>'+mes.audName+'</div></div></div><div class="layui-form-item"><label class="layui-form-label">审核状态：</label><div class="layui-input-block" style="line-height: 35px;padding-left: 8px;"><div>'+state+'</div></div></div><div class="layui-form-item"><label class="layui-form-label">审核意见：</label><div class="layui-input-block" style="line-height: 35px;padding-left: 8px;"><div>'+mes.audIdea+'</div></div></div><div class="layui-form-item"><label class="layui-form-label">审核时间：</label><div class="layui-input-block" style="line-height: 35px;padding-left: 8px;"><div>'+mes.audTimes+'</div></div></div>');
	},"json");
} else if(audState == "10110" || audState == "10111") {
	$.post("../../../../audit/findByFk.action",{"audFkId": pmcId,"type": 1},function (mes){
		var state = "";
		if (mes.audState == "10010") {
			state = "不通过";
		} else if (mes.audState == "10011") {
			state = "通过";
		}
		$("#property").append('<div class="layui-form-item" style="padding: 8px 0px 0px 8px;color: #FF5722;"><h3>财物审核</h3></div><div class="layui-form-item"><label class="layui-form-label">审核人：</label><div class="layui-input-block" style="line-height: 35px;padding-left: 8px;"><div>'+mes.audName+'</div></div></div><div class="layui-form-item"><label class="layui-form-label">审核状态：</label><div class="layui-input-block" style="line-height: 35px;padding-left: 8px;"><div>'+state+'</div></div></div><div class="layui-form-item"><label class="layui-form-label">审核意见：</label><div class="layui-input-block" style="line-height: 35px;padding-left: 8px;"><div>'+mes.audIdea+'</div></div></div><div class="layui-form-item"><label class="layui-form-label">审核时间：</label><div class="layui-input-block" style="line-height: 35px;padding-left: 8px;"><div>'+mes.audTimes+'</div></div></div>');
	},"json");
	$.post("../../../../audit/findByFk.action",{"audFkId": pmcId,"type": 0},function (mes){
		var state = "";
		if (mes.audState == "10110") {
			state = "不通过";
		} else if (mes.audState == "10111") {
			state = "通过";
		}
		$("#manager").append('<div class="layui-form-item" style="padding: 8px 0px 0px 8px;color: #FF5722;"><h3>经理审核</h3></div><div class="layui-form-item"><label class="layui-form-label">审核人：</label><div class="layui-input-block" style="line-height: 35px;padding-left: 8px;"><div>'+mes.audName+'</div></div></div><div class="layui-form-item"><label class="layui-form-label">审核状态：</label><div class="layui-input-block" style="line-height: 35px;padding-left: 8px;"><div>'+state+'</div></div></div><div class="layui-form-item"><label class="layui-form-label">审核意见：</label><div class="layui-input-block" style="line-height: 35px;padding-left: 8px;"><div>'+mes.audIdea+'</div></div></div><div class="layui-form-item"><label class="layui-form-label">审核时间：</label><div class="layui-input-block" style="line-height: 35px;padding-left: 8px;"><div>'+mes.audTimes+'</div></div></div>');
	},"json");
}
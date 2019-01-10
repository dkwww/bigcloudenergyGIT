layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    
    var admin;
    //查询个人资料信息
    $.ajax({ url:"../../admin/getSession.action",
        type:'post',//method请求方式，get或者post
        async: false,//同步
        dataType:'json',//预期服务器返回的数据类型
        success:function(mes){//res为相应体,function为回调函数
        	admin = mes;
        	$("input[name=adminName]").val(mes.adminName);
        	$("input[name=adminId]").val(mes.adminId);
        },
        error:function(mes){
        	parent.location.href="../../pages/admin/login.html";
        }
    });

    //添加验证规则
    form.verify({
        oldPwd : function(value, item){
            if(value != admin.adminPwd){
                return "密码错误，请重新输入！";
            }
        },
        newPwd : function(value, item){
            if(value.length < 6){
                return "密码长度不能小于6位";
            }
        },
        confirmPwd : function(value, item){
            if(!new RegExp($("#oldPwd").val()).test(value)){
                return "两次输入密码不一致，请重新输入！";
            }
        }
    });
    
    form.on('submit(changePwd)', function(data) {
        $.ajax({ 
        	url:"../../admin/update.action",
        	data: JSON.stringify(data.field),
            type:'post',//method请求方式，get或者post
            async: false,//同步
            dataType:'json',//预期服务器返回的数据类型
            contentType: "application/json; charset=utf-8",
            success:function(mes){//res为相应体,function为回调函数
            	layer.msg(mes.msg);
        		if (mes.status=="1") {
    				$.post("../../admin/clearSession.action",null,function(mess){
    					 setTimeout(function(){
    						 parent.location.href="../../"+mes.url;
    			         }, 1500);
    				})
        		}
            }
        });
    	return false;
    });
})
//ajax加载动画
$(function () {
    $.ajaxSetup({
        layerIndex:-1,
        beforeSend: function () {
            this.layerIndex = layer.load(1, { shade: [0.8, '#ffffff'] });
        },
        complete: function () {
            layer.close(this.layerIndex);
        },
        error: function () {
            layer.alert('部分数据加载失败，可能会导致页面显示异常，请刷新后重试', {
                skin: 'layui-layer-molv'
               , closeBtn: 0
               , shift: 4 //动画类型
            });
        }
    });
});
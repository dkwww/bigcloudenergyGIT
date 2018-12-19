//显示表格数据

		    layui.use(['table','upload','form'], function() {
		        var table = layui.table,
		            $ = layui.jquery,
		            layer = layui.layer,
		            form = layui.form,
		            laytpl = layui.laytpl;
		        
		        var tableIns = table.render({
		            elem: '#demo',
		            height: '449px', //容器高度
		            url: '../../role/queryList.action',
		            page: true,
		            id: 'demo',
		            cols: [
		                [{checkbox: true,fixed: true},
		                {field: 'roleId',title: 'ID', width: 273},
		                {field: 'roleName',title: '角色名称',width: 145},
		                {field: 'roleCode',title: '角色编号',width: 150},
		                {field: 'roleDescribe',title: '角色描述',width: 150},
		                {field: 'isva',title: '是否有效',width: 90},
		                {field: 'optime',title: '操作时间',width: 60},
		                {field: 'oper',title: '操作者',width: 150},
		                {fixed: 'right',title: '操作',width: 180,align: 'center',toolbar: '#barDemo'}]
		            ],
		            done: function(res, curr, count) {
		                $("[data-field = 'drugProp']").children().each(function(){
						    if($(this).text() == '1'){
						    	$(this).text("处方药");
						    } else if ($(this).text() == '0') {
						    	$(this).text("非处方药");
						    }
					  	});
		                /* $("[data-field = 'drugPictrue']").children().each(function(){
						    if($(this).text() == 'null'||$(this).text() == ''){
						    	$(this).text("暂无");
						    }
					  	}); */
		            },
		            loading: true
		        });
				//查询类型下拉框数据
		        var staticData = null;
		        $.ajax({ url:"../../drugType/showList.action",
                    type:'post',//method请求方式，get或者post
                    cache: false,//同步
                    dataType:'json',//预期服务器返回的数据类型
                    success:function(mes){//res为相应体,function为回调函数
                    	//增加及修改类型下拉框内的数据
                    	staticData = mes;
                    	//循环添加类型搜索框内的数据
                    	$.each(mes.types,function(index,item){
                    		$("#drug-type").append("<option value="+item.dtId+">"+item.dtName+"</option>");
                    	});
                    	//渲染类型搜索框内的下拉框
                    	renderForm();
                    }
                 });
		        
		        //监听搜索表单提交
		        form.on('submit(search)', function(data) {  
		            //带条件查询
		            tableIns.reload({
		                where: data.field,
		                page: { curr: 1 }
		            });
		            $('.kit-search-mored').hide();
		            return false;
		        });
		        
		        //渲染 修改和增加弹出层
			    function showlayer(d){
			    	laytpl($('#edit-tpl').html()).render(d,function(html) {
	                    layer.open({
	                        type: 1,
	                        title: '表单',
	                        content: html,
	                        area: ['800px', '430px'],
	                        btn: ['提交', '重置', '取消'],
	                        yes: function(index, layero) {
	                            editIndex = index;
	                            $('form[lay-filter="form-edit"]').find('button[lay-submit]').click();
	                        },
	                        btn2: function(index, layero) {
	                            $('form[lay-filter="form-edit"]').find('button[type="reset"]').click();
	                            return false;
	                        },
	                        success: function() {
	                            form.render(null, 'form-edit');
	                        }
	                    });
	                    layui.config({
	                        base: '../../res/layui-config/js/'
	                    }).use(['ztree', 'layer'], function() {
	                    	var url="../../role/queryModule.action";
	                    	var data=null;
	                    	$.post(url,data,function(mes){
	                		 var $ = layui.jquery,
	                         layer = layui.layer;
	                         var zNodes = mes;
	                         var setting = {
	                             view: {
	                                 addHoverDom: addHoverDom,
	                                 removeHoverDom: removeHoverDom,
	                                 selectedMulti: false
	                             },
	                             check: {
	                                 enable: true
	                                 
	                             },
	                             data: {
	                                 simpleData: {
	                                     enable: true
	                                 }
	                             },
	                             edit: {
	                                 enable: true
	                             },
	                             callback: {
	                                 onClick: function(e, treeId, treeNode) {
	                                     console.log(treeNode);
	                                 }
	                             }
	                         };


	                         $(document).ready(function() {
	                             $.fn.zTree.init($("#ztree"), setting, zNodes);
	                         });
	                         setAllId($("#roleId").val());
	                         var newCount = 1;

	                         function addHoverDom(treeId, treeNode) {
	                             var sObj = $("#" + treeNode.tId + "_span");
	                             if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
	                                 return;
	                             var addStr = "<span class='button add' id='addBtn_" + treeNode.tId +
	                                 "' title='add node' onfocus='this.blur();'></span>";
	                             sObj.after(addStr);
	                             var btn = $("#addBtn_" + treeNode.tId);
	                             if (btn) {
	                                 btn.bind("click", function() {
	                                     var zTree = $.fn.zTree.getZTreeObj("ztree");
	                                     zTree.addNodes(treeNode, {
	                                         id: (100 + newCount),
	                                         pId: treeNode.id,
	                                         name: "new node" + (newCount++)
	                                     });
	                                     return false;
	                                 });
	                             }
	                         };

	                         function removeHoverDom(treeId, treeNode) {
	                             $("#addBtn_" + treeNode.tId).unbind().remove();
	                         };
	                    	},"json");
	                    });
	                    upload();
	                   
	                });
			    }
		        
		        //监听工具条按钮点击
		        table.on('tool(demo)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		            var data = obj.data; //获得当前行数据
		            var layEvent = obj.event; //获得 lay-event 对应的值
		            var tr = obj.tr; //获得当前行 tr 的DOM对象
		
		            if (layEvent === 'detail') { //查看
		            	maxlayer();
		                console.log(table.checkStatus('demo'));
		            } else if (layEvent === 'del') { //删除
		                layer.confirm('真的删除行么', function(index) {
		                	layer.close(index);
		                    update("../../role/delete.action",{"roleId":data.roleId,"isva":"否"});
		                });
		            } else if (layEvent === 'edit') { //编辑
		                var d = {
		                	rowdata: data,
		                    types: staticData.types
		                };
		                showlayer(d);
		            }
		        });
		        //表单渲染
		        form.render(null, 'kit-search-form');
		        //更多筛选点击事件
		        $('#kit-search-more').on('click', function() {
		            $('.kit-search-mored').toggle();
		        });
		        var editIndex;
		        
		    //增加和修改弹出层   提交按钮点击事件
		        form.on('submit(formEdit)', function(data) {
		        	$("#moduleId").val(getAllId());
		        	alert(getAllId());
		        	data.field.moduleId=getAllId();
                	update("../../role/updateId.action",data.field);
                	if (close) editIndex && layer.close(editIndex); //关闭弹出层
                	return false;
		        });
		        
		        //增加、批量删除 按钮点击事件
		        $('.kit-search-btns').children('a').off('click').on('click', function() {
		            var $that = $(this),
		                action = $that.data('action');
		            switch (action) {
		            	//点击的是 增加按钮
		                case 'add':
		                    var d = {
		                		//替换增加页面文本框内出现的undefine
		                        rowdata: {
		                        	roleId:'',roleName: '',roleDescribe: ''
		                        },
		                        //类型下拉框数据
		                        types: staticData.types
		                    };
		                    showlayer(d);
		                    break;
		                    
		                //点击的是 批量删除按钮
		                case 'del-bulk':
		                    var d = table.checkStatus('demo');
		                    if (d.data.length === 0) {
		                        layer.msg('请选择要删除的数据');
		                        return;
		                    }
		                    var data = d.data,
		                        names = [],
		                        ids = [];
		                    layui.each(data, function(index, item) {
		                        names.push(item.roleName);
		                        ids.push(item.roleId);
		                    });
		                    layer.confirm('真的删除行么', function(index) {
		                    	layer.close(index);
		                    	update("../../role/batchdelete.action",ids);
			                });
		                    break;
		                    
		            }
		        });
		    });
			
		  	//全屏弹窗
			function maxlayer(){
				var index = layer.open({
				  type: 2,
				  title: '药品配置',
				  content: 'https://www.baidu.com',
				  area: ['800px', '430px']
				  //maxmin: true
				});
				layer.full(index);
			}
		    
		    //增加、修改、删除、批量删除 都是用的这一个方法
		    function update(url,data){
		    	$.ajax({
		    		url: url,
                    type:'post',//method请求方式，get或者post
                    cache: false,//同步
                    dataType:'json',//预期服务器返回的数据类型
                    data: JSON.stringify(data),//表格数据序列化
                    contentType: "application/json; charset=utf-8",
                    success:function(mes){//res为相应体,function为回调函数
                    	$(".layui-laypage-btn")[0].click();//当前表格刷新
                        if(mes.status==1){ 
                        	var close = true;//有弹出层时是关闭弹出层 false不关闭
	                        $("#res").click();//调用重置按钮将表单数据清空
                        }
                        layer.msg(mes.msg);
                    },
                   	error:function(){layer.alert('数据异常，请稍后重试！！！',{icon:5});}
                 });
		    }
		    
		    //上传文件
		    function upload(){
		    	layui.upload.render({
	                elem: '#fileBtn'
	                ,url: '../../drug/upload.action'
	                ,accept: 'file'
	                ,auto: false
	                ,bindAction: '#uploadBtn'
	                ,before: function(){
	                	layer.load(2,{shade:false});
	                }
	                ,done: function(res){
	                	layer.closeAll("loading");
	                	layer.msg(res.msg);
	                	if (res.status=="1") {
	                		 $("[name=drugPictrue]").val(res.obj);
	                		 $("#fileBtn").html('<i class="layui-icon">&#xe67c;</i>选择文件');
	                		 form.render('form-edit');
	                	}
	                }
	            });
		    }
		    
		  	//重新渲染表单
		  	function renderForm(){ 
	  			layui.use('form', function(){ 
		  			var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加() 
		  			form.render(); 
	  			}); 
	  		}
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
		    
		    
		    function getAllId(){
		    	　var treeObj = $.fn.zTree.getZTreeObj("ztree");
		    	　　var nodes = treeObj.getCheckedNodes(true);//在提交表单之前将选中的checkbox收集
		    	　　var array = new Array();
		    	　　for(var i=0;i<nodes.length;i++){
		    			array.push(nodes[i].id);
		    	　　}
		    	　　var functionIds = array.join(",");
		    	return functionIds;
		    }
		    function setAllId(id){
		    	　var zTree = $.fn.zTree.getZTreeObj("ztree");
		    	  var url="../../moduleRole/queryIdModule.action";
		    	  var data={"drugId":id}
		    	  $.post(url,data,function(mes){
		    		  var node=null;
		    		  $.each(mes,function(index,a){
		    			   	node= zTree.getNodeByParam("id",a.id);
		    			   	
		    			   	console.info(node);
		    			   	zTree.selectNode(node);
		    			   	node.checked = true;
		    			   	node.halfCheck=true;
		    				zTree.updateNode(node);   //异步加载成功后刷新树节点
		    		  })
		    	  },"json");
		    }
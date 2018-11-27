/**
 * 页面刷新显示进度条 更新于2018-11-01
 */
(function(){ document.onreadystatechange = function(){
	/*
	$(document).on('page:fetch',   function() { NProgress.start(); }); //页面刷新
	$(document).on('page:change',  function() { NProgress.done(); }); //页面加载中
	$(document).on('page:restore', function() { NProgress.remove(); }); //页面加载完成
	*/
	NProgress.start();
	console.log(document.readyState);
	if (document.readyState == "Uninitialized") {
		NProgress.set(1);
	}
	if (document.readyState == "Interactive") {
		NProgress.set(0.5);
	}
	if (document.readyState == "complete") {
		NProgress.done();
	}
	$(document).ajaxStart(function(){//ajax开始全局函数
		NProgress.start();
	}).ajaxSend(function(){//ajax发送全局函数
		NProgress.set(0.2);
	}).ajaxSuccess(function(){//ajax成功全局函数
		NProgress.set(0.4);
	}).ajaxError(function(){//ajax失败全局函数
		NProgress.set(0.6);
	}).ajaxComplete(function(){//ajax完成全局函数
		NProgress.set(0.8);
	}).ajaxStop(function(){//ajax停止全局函数
		NProgress.done();
	});
}
})();
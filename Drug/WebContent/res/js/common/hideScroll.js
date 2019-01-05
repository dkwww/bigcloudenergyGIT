$(function(){
	hidenScroll($(".layui-side-scroll"));
});

function getScrollWidth() {
  var noScroll, scroll, oDiv = document.createElement("DIV");
  oDiv.style.cssText = "position:absolute; top:-1000px; width:100px; height:100px; overflow:hidden;";
  noScroll = document.body.appendChild(oDiv).clientWidth;
  oDiv.style.overflowY = "scroll";
  scroll = oDiv.clientWidth;
  document.body.removeChild(oDiv);
  return noScroll-scroll;
}

function setScroll(obj) {
	obj.css("cssText","overflow-y:scroll;width:calc(100% + "+getScrollWidth()+"px)!important");
}

function hidenScroll(obj) {
	setScroll(obj);
	$(window).resize(function () {
		setScroll(obj);
	});
}
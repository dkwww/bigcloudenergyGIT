$(function() {
	$(document).ready(function() {
		$(".loader").delay(800).fadeOut("slow", function() {
			$(this).remove();
		});
	});
})

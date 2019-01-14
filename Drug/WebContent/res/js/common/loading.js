$(function() {
	$(document).ready(function() {
		$(".loader").delay(500).fadeOut("slow", function() {
			$(this).remove();
		});
	});
})

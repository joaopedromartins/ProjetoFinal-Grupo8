/*$(function() {
	$('.monthYearPicker').datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		dateFormat: 'MM-yyyy'
	}).focus(function() {
		var thisCalendar = $(this);
		$('.ui-datepicker-calendar').detach();
		$('.ui-datepicker-close').click(function() {
var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
thisCalendar.datepicker('setDate', new Date(year, month, 1));
		});
	});
});*/

$(document).ready(function()
		{   
		    $(".monthPicker").datepicker({
		        dateFormat: 'yy-mm',
		        changeMonth: true,
		        changeYear: true,
		        showButtonPanel: true,

		        onClose: function(dateText, inst) {
		            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
		            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
		            $(this).val($.datepicker.formatDate('yy-mm', new Date(year, month, 1)));
		        }
		    });

		    $(".monthPicker").focus(function () {
		        $(".ui-datepicker-calendar").hide();
		        $("#ui-datepicker-div").position({
		            my: "center top",
		            at: "center bottom",
		            of: $(this)
		        });
		    });
		});
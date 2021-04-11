/**
 * sample_XXXXX
 */
$(document).ready(function() {
	
	var SampleForm = $("#SampleFormID");
	var path = $("#hidPathID").val();
	
    var hiddenForm = $("#hiddenFormID");
	
	$("#searchID").click(function() {
		SampleForm.attr("action", path + "/SCRC/SampleAction!toSearch.action");
		SampleForm.submit();
	});
	
});

    function toLoginPage() {
        with (document.forms[0]) {
            action = "./LoginAction.action";
            submit();
        }
        return false;
    }
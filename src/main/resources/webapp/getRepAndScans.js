function modalRepAndScans(domain_name) {
//###Clear Modal Box first
    $("#domainid").html('Domain ID: ');
    $("#repscandate").html('Reputation last scan: ');
    $("#repandscanTitle").html('Reputation and Scanning results for: '+domain_name);
    $("#sslissues").html('SSL Issues: ')
    $("#isblacklisted").html('Blacklisted: ')
    $("#webinspector").html('WebInspector Scan: ')
    $("#malwarescandate").html('Files last scan: ');
    $("#ismalware").html('Malware found: ')
    $("#isinjectedcode").html('Injected Code found: ')
    $("#isinsecureperms").html('Insecure Permissions found: ')
//########################
$.ajax({
    url: '/repandscans?domain='+domain_name,
    type: "GET",
    dataType: "JSON",
    success: function(repandscans) {
    var content = [];
    repandscansInfo = repandscans.content;
    drawModalRepAndScans(repandscansInfo, domain_name);
    }
});
}

function getFontColor(status) {
    var colorType = "<font color=\"green\">";
    if (status==true){colorType="<font color=\"red\">"};
    return colorType;
}

function drawModalRepAndScans(repandscansInfo, domain_name) {
    for (var i = 0; i < repandscansInfo.length; i++) {
        var sslDate = new Date(repandscansInfo[i].reputation_last_scan_date)
        var malwareDate = new Date(repandscansInfo[i].malware_last_scan_date)
        $("#domainid").html('Domain ID: ' + '<b>' + repandscansInfo[i].domain_id + '</b>');
        $("#repscandate").html('Reputation last scan: ' + '<b>' + formatDateString(sslDate) + '</b>')
        $("#sslissues").html('SSL Issues: ' +getFontColor(repandscansInfo[i].ssl_issues)+'<b>' +repandscansInfo[i].ssl_issues+'</b>'+'</font>')
        $("#isblacklisted").html('Blacklisted: '+getFontColor(repandscansInfo[i].is_blacklisted) +'<b>'+repandscansInfo[i].is_blacklisted+'</b>'+'</font>')
        $("#webinspector").html('WebInspector Scan: '+getFontColor(repandscansInfo[i].phishing_detected)+'<b>'+repandscansInfo[i].phishing_detected+'</b>'+'</font>')
        $("#malwarescandate").html('Files last scan: ' + '<b>' + formatDateString(malwareDate) + '</b>')
        $("#ismalware").html('Malware found: '+getFontColor(repandscansInfo[i].malware_detected) +'<b>'+repandscansInfo[i].malware_detected+'</b>'+'</font>')
        $("#isinjectedcode").html('Injected Code found: '+getFontColor(repandscansInfo[i].injected_code_found)+'<b>'+repandscansInfo[i].injected_code_found+'</b>'+'</font>')
        $("#isinsecureperms").html('Insecure Permissions found: '+getFontColor(repandscansInfo[i].insecure_permissions)+'<b>'+repandscansInfo[i].insecure_permissions+'</b>'+'</font>')
    };
}

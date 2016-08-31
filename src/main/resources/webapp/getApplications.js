function tableApplications(host_id, host_name) {
$.ajax({
    url: '/applications?host_id='+host_id,
    type: "GET",
    dataType: "JSON",
    success: function(applications) {
    var content = [];
    applicationsInfo = applications.content;
    drawTableApplications(applicationsInfo, host_name);
    }
});
}

function drawTableApplications(applicationsInfo, host_name) {
    $("#applications tbody").remove();
    $("#appPanel").html('Apps on '+host_name);
    for (var i = 0; i < applicationsInfo.length; i++) {
        drawRowApplications(applicationsInfo[i]);
    };
}

function drawRowApplications(rowDataApplications) {
    var appStatus = "<font color=\"green\">ON</font>";
    if (!rowDataApplications.running) {appStatus = "<font color=\"red\">OFF</font>"};

    var rowApplications = $("<tr />");

    $("#applications").append(rowApplications);
    rowApplications.append($("<td>" + rowDataApplications.name + "</td>"));
    rowApplications.append($("<td>" + rowDataApplications.version + "</td>"));
    rowApplications.append($("<td>" + appStatus + "</td>"));
}
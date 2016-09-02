function tableLicenses(host_id, host_name) {
$.ajax({
    url: '/lbh?host_id='+host_id,
    type: "GET",
    dataType: "JSON",
    success: function(licenses) {
    var content = [];
    licensesInfo = licenses.content;
    drawTableLicenses(licensesInfo, host_name);
    }
});
}

function drawTableLicenses(licensesInfo, host_name) {
    $("#licenses tbody").remove();
    $("#licPanel").html('Licenses on host '+host_name);
    for (var i = 0; i < licensesInfo.length; i++) {
        drawRowLicenses(licensesInfo[i]);
    };
}

function drawRowLicenses(rowDataLicenses) {
    var licStatus = "<font color=\"green\">OK</font>";
    if (rowDataLicenses.license_status_id==0) {licStatus = "<font color=\"red\">EXPIRED</font>"};
    var expired = new Date(rowDataLicenses.expired_at);
//    expiredString = expired.getHours() + ":" + expired.getMinutes() +
//                        " " + expired.getDate()+"/"+expired.getMonth()+"/"+expired.getFullYear();

    expiredString = expired.getDate()+"/"+expired.getMonth()+"/"+expired.getFullYear();

    var rowLicenses = $("<tr />");

    $("#licenses").append(rowLicenses);
    rowLicenses.append($("<td>" + rowDataLicenses.domain + "</td>"));
    rowLicenses.append($("<td>" + rowDataLicenses.license_key + "</td>"));
    rowLicenses.append($("<td>" + rowDataLicenses.product + "</td>"));
    rowLicenses.append($("<td>" + licStatus + "</td>"));
    rowLicenses.append($("<td>" + expiredString + "</td>"));
}
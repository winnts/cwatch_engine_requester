function tableAgents() {
$.ajax({
    url: '/agents',
    type: "GET",
    dataType: "JSON",
    success: function(agents) {
    var content = [];
    agentsInfo = agents.content;
    drawTableAgents(agentsInfo);
    }
});
}

function drawTableAgents(agentsInfo) {
    $("#agents tbody").remove();
    $("#agents").append("<tbody id=\"agentsBody\"></tbody>");
    for (var i = 0; i < agentsInfo.length; i++) {
        drawRowAgents(agentsInfo[i]);
    };
}

function drawRowAgents(rowDataAgents) {
    var status = "<font color=\"green\">ONLINE</font>";
    var lastSeen = new Date(rowDataAgents.updated_at);
    var nowDate = new Date();
    nowDate.setMinutes(nowDate.getMinutes() - 30);
    nowDate.setHours(nowDate.getUTCHours());
    if (lastSeen < nowDate) {status = "<font color=\"red\">OFFLINE</font>"};
    lastSeenString = lastSeen.getHours() + ":" + lastSeen.getMinutes() +
                        " " + lastSeen.getDate()+"/"+lastSeen.getMonth()+"/"+lastSeen.getFullYear();

//    console.log (nowDate.getHours() + ":" + nowDate.getMinutes() +
//                                         " " + nowDate.getDate()+"/"+nowDate.getMonth()+"/"+nowDate.getFullYear())
    var rowAgents = $("<tr />");

    $("#agents").append(rowAgents);
    rowAgents.append($("<td>" + rowDataAgents.id + "</td>"));
    rowAgents.append($("<td>" + rowDataAgents.hostname + "</td>"));
    rowAgents.append($("<td>" + rowDataAgents.public_ip + "</td>"));
    rowAgents.append($("<td>" + rowDataAgents.version + "</td>"));
    rowAgents.append($("<td>" + status + "</td>"));
    rowAgents.append($("<td>" + lastSeenString + "</td>"));
}
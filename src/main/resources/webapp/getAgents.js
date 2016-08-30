$.ajax({
    url: '/agents',
    type: "GET",
    dataType: "JSON",
    success: function(agents) {
    var content = [];
    agentsInfo = agents.content;
    drawTable(agentsInfo);
    }
});

function drawTableAgents(agentsInfo) {
    for (var i = 0; i < agentsInfo.length; i++) {
        drawRow(agentsInfo[i]);
    }
}

function drawRowAgents(rowDataAgents) {
    var rowAgents = $("<tr />");
    $("#agents").append(rowAgents);
    rowAgents.append($("<td>" + rowDataAgents.id + "</td>"));
    rowAgents.append($("<td>" + rowDataAgents.hostname + "</td>"));
    rowAgents.append($("<td>" + rowDataAgents.public_ip + "</td>"));
    rowAgents.append($("<td>" + "</td>"));
    rowAgents.append($("<td>" + rowDataAgents.updated_at + "</td>"));
}
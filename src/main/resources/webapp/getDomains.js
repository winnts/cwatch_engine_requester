$.ajax({
    url: '/domains?name=global-8000.com',
    type: "GET",
    dataType: "JSON",
    success: function(data) {
    var content = [];
    content = data.content;
    drawTable(content);
    }
});

function drawTable(content) {
    for (var i = 0; i < content.length; i++) {
        drawRow(content[i]);
    }
}

function drawRow(rowData) {
    var row = $("<tr />");
    $("#domains").append(row);
    row.append($("<td>" + rowData.getFieldId + "</td>"));
    row.append($("<td>" + rowData.getFieldDomain + "</td>"));
    row.append($("<td>" + rowData.getFieldDir + "</td>"));
}
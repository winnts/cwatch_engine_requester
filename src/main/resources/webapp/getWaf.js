function tableWaf(domain_name) {
    $("#ipWhiteList tbody").remove();
    $("#ipBlackList tbody").remove();
    $.ajax({
        url: '/waf/whitelist?domain='+domain_name,
        type: "GET",
        dataType: "JSON",
        success: function(whitelist) {
            var content = [];
            whiteListInfo = whitelist.content;
            drawTableWhiteList(whiteListInfo);
        }
    });
    $.ajax({
        url: '/waf/blacklist?domain='+domain_name,
        type: "GET",
        dataType: "JSON",
        success: function(blacklist) {
            var content = [];
            blackListInfo = blacklist.content;
            drawTableBlackList(blackListInfo);
        }
    });
}

function drawTableWhiteList(whiteListInfo) {
    for (var i = 0; i < whiteListInfo.length; i++) {
        drawRowWhiteList(whiteListInfo[i]);
    };
}

function drawRowWhiteList(rowDataWhiteList) {
    var rowWhiteList = $("<tr />");
    $("#ipWhiteList").append(rowWhiteList);
    rowWhiteList.append($("<td>" + rowDataWhiteList.ip + "</td>"));
}

function drawTableBlackList(blackListInfo) {
    for (var i = 0; i < blackListInfo.length; i++) {
        drawRowBlackList(blackListInfo[i]);
    };
}

function drawRowBlackList(rowDataBlackList) {
    var rowBlackList = $("<tr />");
    $("#ipBlackList").append(rowBlackList);
    rowBlackList.append($("<td>" + rowDataBlackList.ip + "</td>"));
}
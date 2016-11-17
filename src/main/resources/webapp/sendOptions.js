function switchEnv() {
environment=$("#envSelection").val();
$.ajax({
    url: '/options?env='+environment,
    type: "POST",
    dataType: String,
    success: function(senv) {
    var content = [];
//    agentsInfo = agents.content;
//    drawTableAgents(agentsInfo);
    }
});
}

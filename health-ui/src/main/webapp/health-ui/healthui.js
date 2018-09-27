/* 
 * Javascript file for health UI
 * Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */

var tiles = document.getElementById("tiles");
var stateItem = document.getElementById("state");
var xmlhttp = new XMLHttpRequest();
var url = "/health"; // TODO - This will be a posible problem if you proxy.

xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4) {
        var healthprobes = JSON.parse(this.responseText);
        processRequest(healthprobes);
    }
};
xmlhttp.open("GET", url, true);
xmlhttp.send();

function processRequest(healthprobes) {
    var state = healthprobes.outcome;
    
    if(state === "DOWN"){
        stateItem.innerHTML = "<h3><span class='badge badge-danger'>Down</span></h3>";
    }else{
        stateItem.innerHTML = "<h3><span class='badge badge-success'>Up</span></h3>";
    }
    
    var checks = healthprobes.checks;
    
    var text = ""; 
    var i;
    for (i = 0; i < checks.length; i++) {
        var check = checks[i];
        var name = check.name;
        var updown = check.state;
        var headingclass = "bg-success";
        if(updown === "DOWN")headingclass = "bg-danger";
        
        text += "<div class='col-sm-4'>" +
                "<div class='shadow-lg p-3 mb-5 bg-white rounded'>" +
                "<table class='table'>" +
            "<thead>" +
                "<tr class='" + headingclass+ "'>" +
                    "<th colspan='2'>" + name + "</th>" +
                "</tr>" +
            "</thead>" +
            "<tbody>";
        
        var meta = check.data;
        
        for (var k in meta) {
            var v = meta[k];
            
            text += "<tr>" + 
                        "<td>" + k +"</td>" + 
                        "<td>" + v + "</td>" + 
                    "</tr>";
        }
                
        text += "</tbody>" +
        "</table>" +
        "</div>" +
        "</div>";
        
    } 
    tiles.innerHTML = text;
}
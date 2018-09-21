/* 
 * Javascript file for health UI
 * Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */

var tiles = document.getElementById("tiles");
var stateItem = document.getElementById("state");
var xmlhttp = new XMLHttpRequest();
var url = "/health";

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
        stateItem.innerHTML = "<i class='big red exclamation circle icon'>Down</i> ";
    }else{
        stateItem.innerHTML = "<i class='big green check circle icon'>Up</i> ";
    }
    
    var checks = healthprobes.checks;
    
    var text = ""; 
    var i;
    for (i = 0; i < checks.length; i++) {
        var check = checks[i];
        var name = check.name;
        var updown = check.state;
        var ribboncolor = "green";
        if(updown === "DOWN")ribboncolor = "red";
        
        text += "<div class='eight wide column'>" +
                
                    "<div class='ui raised segment'>" + 
                        "<a class='ui " + ribboncolor + " ribbon label'>" + name + "</a>" + 
                        "<table class='ui very basic collapsing celled table'>" + 
                            "<tbody>";
        
        var meta = check.data;
        
        for (var k in meta) {
            var v = meta[k];
            
            text += "<tr>" + 
                        "<td data-label='key'>" + k +"</td>" + 
                        "<td data-label='value'>" + v + "</td>" + 
                    "</tr>";
        }
        
        text += "</tbody>" + 
                "</table>" + 
                "</div>" +
                "</div>";
                
    } 
    tiles.innerHTML = text;
}
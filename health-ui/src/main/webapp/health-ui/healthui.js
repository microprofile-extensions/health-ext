/* 
 * Javascript file for health UI
 * Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */
var refreshTimer;

function processSettings(){
    
    // Title
    var title = localStorage.getItem("title");
    if(title === null || title === '')title = "MicroProfile Health UI";
    $("#navbar_title").html(title);
    $("#settings_form_title").val(title);
    document.title = title;
    
    // Poll
    var poll = localStorage.getItem("poll");
    $("#settings_form_poll").val(poll);
    if(poll === null || poll === '' || poll === 'off'){
        clearInterval(refreshTimer);
    }else{
        var interval = getInterval(poll);
        clearInterval(refreshTimer);
        if(interval>0){
            refreshTimer = setInterval(function(){ 
                loadHealthData(); 
            }, interval);
        }
    }
    
}

function loadHealthData(){
    var xmlhttp = new XMLHttpRequest();
    var url = getUrl();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState === 4) {
            if (xmlhttp.status === 200) {  
                var healthprobes = JSON.parse(this.responseText);
                process200Data(healthprobes);
                initLayout(); 
            }else if(xmlhttp.status === 503) {
                var healthprobes = JSON.parse(this.responseText);
                process503Data(healthprobes);
                initLayout();
            }else {  
                processError(xmlhttp);
            } 
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();   
}

function process200Data(healthprobes){
    var state = healthprobes.outcome;
    
    if(state === "DOWN"){
        $('#state').html("<h3><span class='badge badge-danger'><i class='fa fa-refresh' aria-hidden='true'></i> Down</span></h3>");
    }else{
        $('#state').html("<h3><span class='badge badge-success'><i class='fa fa-refresh' aria-hidden='true'></i> Up</span></h3>");
    }
    processData(healthprobes);
}

function process503Data(healthprobes){
    $('#state').html("<h3><span class='badge badge-warning'>Error fetching data</span></h3>");
    processData(healthprobes);
}

function processData(healthprobes) {
    
    var checks = healthprobes.checks;
    
    var text = ""; 
    var i;
    for (i = 0; i < checks.length; i++) {
        var check = checks[i];
        var name = check.name;
        var updown = check.state;
        var headingclass = "bg-success";
        if(updown === "DOWN")headingclass = "bg-danger";
   
        text += "<div class='grid-item'>";
        text += "<div class='shadow-lg p-3 mb-5 bg-white rounded'>" +
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
    
    
    $('#grid').html(text);
}


function processError(xmlhttp){
    $('#state').html("<h3><span class='badge badge-warning'>Error fetching data</span></h3>");
    $('#grid').html("<blockquote class='blockquote text-center'>" +
                        "<p class='mb-0'> Error while fetching data from [" + getUrl() +"]</p>" + 
                        "<footer class='blockquote-footer'>" + xmlhttp.responseText + "</footer>" +
                        "</blockquote>");
    
}

function getUrl(){
    var url = localStorage.getItem("url");
    if(url === null || url === '')url = "/health";
    return url;
}

function changeSettings(){
    // Title
    var title = $('#settings_form_title').val();
    localStorage.setItem("title", title);
    
    // URL (If the url changed we need to reload)
    var newurl = $('#settings_form_url').val();
    var oldurl = localStorage.getItem("url");
    if(newurl !== oldurl){
        localStorage.setItem("url", newurl);
        loadHealthData();
    }
    
    // Poll
    var poll = $('#settings_form_poll').val();
    localStorage.setItem("poll", poll);
    
    $('#settingsModal').modal('hide');
    
    processSettings();
}

function initLayout(){
    
    var grid = document.getElementById('grid');
    var pckry = new Packery( grid, {
        // options
        itemSelector: '.grid-item',
        gutter: 30
    });
}

function getInterval(text){

    if(text === "off"){
        return 0;
    }else if(text === "every 5 seconds"){
        return 5 * 1000;
    }else if(text === "every 10 seconds"){
        return 10 * 1000;
    }else if(text === "every 30 seconds"){
        return 30 * 1000;
    }else if(text === "every minute"){
        return 60 * 1000;    
    }else if(text === "every 5 minutes"){
        return 60 * 5 * 1000; 
    }else if(text === "every 10 minutes"){
        return 60 * 10 * 1000;        
    }else {
        return 0;
    }
    
}


(function() {
    processSettings();
    loadHealthData();
})();
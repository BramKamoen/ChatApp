var button = document.getElementById("buttonChange");
button.onclick = getNewStatus;

document.getElementById("buttonChange").onclick = function () {

}

var statusRequest = new XMLHttpRequest();

function getNewStatus () {
    statusRequest.open("GET", "StatusServlet", true);
    statusRequest.onreadystatechange = getData;
    statusRequest.send(null);
}

function getData () {
    if (statusRequest.status == 200) {
        if (statusRequest.readyState == 4) {
            var div = document.getElementById("statusP");
            var p = document.createElement("p");
            var text = document.createTextNode(statusRequest.responseText);
            p.appendChild(text);
            div.appendChild(p);
        }
    }

}
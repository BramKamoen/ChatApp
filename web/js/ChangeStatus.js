var statusRequest = new XMLHttpRequest();
window.onload = function(){
    statusRequest.open("GET", "Controller?action=GetStatus", true);
    statusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    statusRequest.onreadystatechange = getData;
    statusRequest.send(null);
}

var button = document.getElementById("buttonChange").onclick = function () {
    var statusText = document.getElementById("selectStatus2").value;
    var status = "status=" + encodeURIComponent(statusText);
    statusRequest.open("Post", "Controller?action=StatusServlet", true);

    statusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    statusRequest.onreadystatechange = getData;
    statusRequest.send(status);
}

function getData () {
    if (statusRequest.status == 200) {
        if (statusRequest.readyState == 4) {

            alert("getdata");
            var statusResponseText = statusRequest.responseText;
            var div = document.getElementById("statusP");
            var p = div.childNodes[0];
            if (p == null){
                p = document.createElement("p");
                p.id = "statusText"
                var text = document.createTextNode(statusResponseText);
                p.appendChild(text);
                div.appendChild(p);
            }
            else{
                var text = document.createTextNode(statusResponseText);
                p.removeChild(p.childNodes[0]);
                p.appendChild(statusResponseText);
            }


        }
    }

}
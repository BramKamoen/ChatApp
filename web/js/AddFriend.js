var newVriend = new XMLHttpRequest();
window.onload = getVriendenlijst;
document.getElementById("buttonVriend").onclick = function(){
    nieuweVriend = document.getElementById("naamVriend").value;
    var vriend = "nieuweVriend=" + encodeURIComponent(nieuweVriend);
    newVriend.open("POST","Controller?action=VoegVriendToe", true);
    newVriend.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    newVriend.send(vriend);
}

var vriendenlijst = new XMLHttpRequest();
function getVriendenlijst(){
    vriendenlijst.open("GET", "Controller?action=getVriendenLijst", true);
    vriendenlijst.onreadystatechange = verkrijgVriendenlijst;
    //vriendenlijst.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    vriendenlijst.send();

}
function verkrijgVriendenlijst(){
    if(vriendenlijst.readyState == 4){
        if(vriendenlijst.status == 200){
            var serverresponse = JSON.parse(vriendenlijst.responseText);
            updateTable(serverresponse);
            setTimeout(getVriendenlijst, 1000);

        }
    }

}
function updateTable(Json){
    var vriendDiv = document.getElementById("vrienden");
    if(vriendDiv.getElementsByClassName("Vriend") != null){
        while (vriendDiv.firstChild) {
            vriendDiv.removeChild(vriendDiv.firstChild);
        }

    }
    Json.forEach(function(value){
            vriendDiv.insertAdjacentHTML("beforeend", "<form><p class = 'Vriend'>" + value.firstName + " " + value.lastName + " " + value.status + "</p>")
        }
    )

}
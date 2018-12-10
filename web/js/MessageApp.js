/*function StuurBericht(i) {
    var id = i.toString();

    $anderevriend = id;
    var textboxdiv = document.getElementById("textboxes");
    textboxdiv.insertAdjacentHTML("beforeend", "<form class='" + id + "\'><p>" + " Chat met " + id + "<div id='messages" + id + "'></div></p><input type='text' id='textbox" + id + "'></input><input type='button' onclick=\"StuurBerichtFunctie(\'" + id + "\');\" value='Send' id='button" + id + "\'></form>")
    window.alert("hey")
    verkrijglijst(id)

}
function verkrijglijst(id){
    $.get("Controller?action=MessageLijst", {id: id}, function (data){
        getmessages(data, id);
    });
    setTimeout(verkrijglijst.bind(this, id), 1000);
    //setTimeout(function() {verkrijglijst(id);}, 10000);
}
function getmessages (data, id){
    //window.alert("messages" + id)
    var chatdiv = document.getElementById("messages" + id);
    if(chatdiv.getElementsByClassName("message") != null){
        while (chatdiv.firstChild) {
            chatdiv.removeChild(chatdiv.firstChild);
        }

    }
    data.forEach(function (response) {
        // window.alert(response.message);
        //var chatdiv = document.getElementById("messages" + id);

        chatdiv.insertAdjacentHTML("beforeend", "<p class='message'>" + response.sender + " - " + response.message + " - " + response.tijd + "</p>")


    })

}

function StuurBerichtFunctie(userId){
    //window.alert("textbox" + userId);
    userrId = userId.toString();
    //window.alert(userId);
    //console.log(userId);
    $berichtje = document.getElementById("textbox" + userId).value;
    //window.alert($berichtje)
    $.post("Controller?action=Messages", {bericht:$berichtje, anderevriend:userId})
    verkrijglijst(userId);
}
*/
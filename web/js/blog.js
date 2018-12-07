var webSocket;
var messages;

    function openSocket() {
    webSocket = new WebSocket("ws://localhost:8080/echo");

    webSocket.onopen = function (event) {
        //    writeResponse("Connection opened")
    };

    webSocket.onmessage = function (event) {
        if (event.data == null) {

        }
        else {
            var nummer = JSON.parse(event.data).number;
            var text = JSON.parse(event.data).text;
            var rating = JSON.parse(event.data).rating;
            var naam = JSON.parse(event.data).naam;

            messages = document.getElementById("Comments" + nummer);
            messages.innerHTML += "<p>" + naam + "-" + text + "-" + rating + "</p>";
        }
    };

    webSocket.onclose = function (event) {
        //  writeResponse("Connection closed");
    };
}

window.onload = openSocket;
function send(i) {
    var text = document.getElementById("comment" + i).value;
    var naam = document.getElementById("naamcomment" + i).value;
    var rating = document.getElementById("rating" + i).value;
    webSocket.send("{\"text\": \"" + text + "\", \"number\": \"" + i + "\", \"naam\": \"" + naam + "\", \"rating\":\"" + rating + "\"}");
    //console.log("{\"text\": \"" + text +  "\", \"number\": \"" + i + "\"}");
    //console.log("{\"text\": \"" + text +  "\", \"number\": \"" + i + "\", \"naam\": \"" + naam + "\", \"rating\":\"" + rating + "\"}")
}

function closeSocket() {
    webSocket.close();
}
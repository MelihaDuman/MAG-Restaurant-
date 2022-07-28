var contextPath = "http://127.0.0.1:8080/wa2122-mag-1.0"

function sanitize(str) {
    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
}



function genericGETRequest(url, callback, m){
    var httpRequest = new XMLHttpRequest();
    var m="?email="+encodeURIComponent(m);
    try{
        if (!httpRequest) {
          alert('Cannot create an XMLHTTP instance');
          return false;
        }
        httpRequest.onreadystatechange = function (){ callback(httpRequest)};
        httpRequest.open('GET', url+m);
        httpRequest.send();
        }
        catch(e){
        alert(e.message)
        }
}



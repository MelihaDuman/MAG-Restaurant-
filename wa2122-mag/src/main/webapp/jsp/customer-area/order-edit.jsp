
// self executing function here
document.addEventListener('DOMContentLoaded', function(event) {
    // your page initialization code here
    // the DOM will be available here
    document.getElementById("delete-button").addEventListener('click', deleteorder);
    console.log(document.getElementById("delete-button"));
});


function deletePark (){
    var url = new URL(contextPath+"/order/edit/delete/");
    url.searchParams.set('order_id', document.getElementById('order_id').value);
    console.log(url);

    var httpRequest = new XMLHttpRequest();


    if (!httpRequest) {
      alert('Cannot create an XMLHTTP instance');
      return false;
    }
    httpRequest.onreadystatechange = function(){deletedOrder(httpRequest)};
    httpRequest.open('DELETE', url);
    httpRequest.send();

}

function deletedOrder(req){
    if (req.readyState === XMLHttpRequest.DONE) {
        if (req.status == 200) {
             alert("order deleted correctly");
             // Simulate a mouse click:
             window.location.href = (contextPath+"/jsp/homepage.jsp");
        }
        else {
            console.log(req.responseText);
            alert("problem processing the request");
        }
    }
}
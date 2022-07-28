

var contextPath = "http://127.0.0.1:8080/wa2122-mag-1.0";
// self executing function here
document.addEventListener('DOMContentLoaded', function(event) {
    // your page initialization code here
    // the DOM will be available here
    document.getElementById("email").innerHTML=getUrlVars()["email"];
    getHomepageContent();
    document.getElementById("pay").addEventListener('click',paymentmessage);

});



function getHomepageContent() {
    var url = new URL(contextPath+'/cart/overview/');
    var email=getUrlVars()["email"]
    genericGETRequest(url, createOverviewPage, m=email);

}

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}

function createOverviewPage(req){
 if (req.readyState === XMLHttpRequest.DONE) {
        if (req.status == 200) {
            var jsonData = JSON.parse(req.responseText);
            var Orders = jsonData['data'];


            var hpcontent = "";
            hpcontent+="<iframe name='dummyframe' id='dummyframe' style='display: none'></iframe>";
            hpcontent+="<div class='col-md-6'>";
            hpcontent+="<div class='row'>";
            for(let i=0; i<Orders.length; i++){

                    product_id=sanitize(Orders[i]['id']);
                    hpcontent+="<div class='single_menu'>";
                    hpcontent+="<a >  <img src="+sanitize(Orders[i]['url'])+" style='width: 150px; height: 150px;'  alt=''> </a>";
                    hpcontent+="<div class='menu_content'>";
                    hpcontent += "<h4>"+sanitize(Orders[i]['name'])+"<span>"+sanitize(Orders[i]['price'])+"€</span></h4>";
                    hpcontent += "<h6>Quantity :<span>"+sanitize(Orders[i]['number'])+"</span></h6>";
                    hpcontent += "<p>"+sanitize(Orders[i]['description'])+"</p>";

                    hpcontent += "<form method='POST' action="+contextPath+"/product/delete/ target='dummyframe'>";

                    hpcontent +=  "<input hidden name='product_id' type='number' value="+product_id+"><br/>";
                    hpcontent +=  "<input hidden name='email' type='TEXT' value="+getUrlVars()["email"]+"><br/>";
                    hpcontent += "<button type='submit' class='delete' >Delete product</button><br/>";
                    hpcontent +=  "</form>";
                    hpcontent+= "</div>";
                    hpcontent+= "</div>";


                }
                    hpcontent+= "</div>";
                    hpcontent+= "</div>";
            document.getElementById("product-content").innerHTML = hpcontent;
  }
        else {
            console.log(httpRequest.responseText);
            alert("problem processing the request");
        }
       }
  }


    function paymentmessage(){
        var m="?email="+encodeURIComponent(getUrlVars()["email"]);
        var url = new URL(contextPath+"/cart/payment");
        var httpRequest = new XMLHttpRequest();
        if (!httpRequest) {
          alert('Cannot create an XMLHTTP instance');
          return false;
        }
        httpRequest.onreadystatechange = function(){messagesent(httpRequest)};
        httpRequest.open('POST', url+m);

        httpRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
        httpRequest.send();

    }

    function messagesent(req){
        if (req.readyState === XMLHttpRequest.DONE) {
            if (req.status == 200) {
                 alert("message sent correctly");
                 // Simulate a mouse click:
                 window.location.href = (contextPath+"/jsp/homepage.jsp");
            }
            else {
                console.log(req.responseText);
                alert("problem processing the request");
            }
        }
 }

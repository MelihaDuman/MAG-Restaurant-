

var contextPath = "http://127.0.0.1:8080/wa2122-mag-1.0";
// self executing function here
document.addEventListener('DOMContentLoaded', function(event) {
    // your page initialization code here
    // the DOM will be available here
    getHomepageContent();
    document.getElementById("pay").addEventListener('click',payementmessage);

});

function getHomepageContent() {

    var url = new URL(contextPath+'/categorie/overview/');
    genericGETRequest(url, createOverviewPage);
}
function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
function AlertFunction() {
 alert("product added successfully")
 }
function createOverviewPage(req){

            var jsonData = JSON.parse(req.responseText);
            var categories = jsonData["data"];
            console.log(categories);


            var hpcontent = "";
            hpcontent+="<iframe name='dummyframe' id='dummyframe' style='display: none'></iframe>";
            hpcontent+="<div class='col-md-6'>";
            for(let i=0; i<categories.length; i++){
                hpcontent+="<div class='tab-pane fade show active' id='#"+sanitize(categories[i]['description'])+"' role='tabpanel' aria-labelledby="+sanitize(categories[i]['description'])+">";
                hpcontent+="<div class='row'>";
                for(let j=0; j<categories[i]['products'].length; j++){

                    product_id=sanitize(categories[i]['products'][j]['id']);
                    hpcontent+="<div class='single_menu'>";
                    hpcontent+="<a >  <img src="+sanitize(categories[i]['products'][j]['url'])+" style='width: 150px; height: 150px;'  alt=''> </a>";
                    hpcontent+="<div class='menu_content'>";
                    hpcontent += "<h4>"+sanitize(categories[i]['products'][j]['name'])+"<span>"+sanitize(categories[i]['products'][j]['price'])+"€</span></h4>";
                    hpcontent += "<p>"+sanitize(categories[i]['products'][j]['description'])+"</p>";

                    hpcontent += "<form method='POST' action="+contextPath+"/product/add/ target='dummyframe'>";

                    hpcontent +=  "<input hidden name='product_id' type='number' value="+product_id+"><br/>";
                    hpcontent +=  "<input hidden name='email' type='TEXT' value="+getUrlVars()["email"]+"><br/>";
                    hpcontent += "<button type='submit' class='add' >Add to cart</button><br/>";
                    hpcontent +=  "</form>";
                    hpcontent+= "</div>";
                    hpcontent+= "</div>";


                }
                hpcontent+= "</div>";
                hpcontent+= "</div>";
            }
            hpcontent+= "</div>";
            document.getElementById("product-content").innerHTML = hpcontent;

        }
    

    function paymentmessage(){
        var url = new URL(contextPath+"/user/payment");

        var httpRequest = new XMLHttpRequest();


        if (!httpRequest) {
          alert('Cannot create an XMLHTTP instance');
          return false;
        }
        httpRequest.onreadystatechange = function(){messagesent(httpRequest)};
        httpRequest.open('POST', url);
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

var contextPath = "http://127.0.0.1:8080/wa2122-mag-1.0"


// self executing function here
document.addEventListener('DOMContentLoaded', function(event) {
    // your page initialization code here
    // the DOM will be available here

    getHomepageContent();
});


function getHomepageContent() {
    var url = new URL(contextPath+'/categorie/overview/');
    genericGETRequest(url, createOverviewPage);
}

function createOverviewPage(req){
    if (req.readyState === XMLHttpRequest.DONE) {
        if (req.status == 200) {
            var jsonData = JSON.parse(req.responseText);
            var categories = jsonData['data'];


            var hpcontent = "";
            for(let i=0; i<categories.length; i++){
                hpcontent += "<h1>"+sanitize(categories[i]['name'])+"</h1>";
                hpcontent += "<p>description: "+sanitize(categories[i]['description'])+"</p>";

                for(let j=0; j<categories[i]['products'].length; j++){
                    hpcontent += "<h3> product "+sanitize(categories[i]['products'][j]['name'])+"</h3>";
                    hpcontent += "<p>product description: "+sanitize(categories[i]['products'][j]['description'])+"</p>"
                    hpcontent += "<p>product price: "+sanitize(categories[i]['products'][j]['price'])+"</p>";

                }

            }
            document.getElementById("homepage-content").innerHTML = hpcontent;
        }
        else {
            console.log(httpRequest.responseText);
            alert("problem processing the request");
        }
    }
}
$(document).ready(function () {
    $.ajax({
        url: "findplaces-web/rest/place/listBySeller/100001401841332",
        //data: { "socialid": "100001401841332" },
        method: 'GET',
        success: function (result) {
            console.log(result);            
        }
    });
});
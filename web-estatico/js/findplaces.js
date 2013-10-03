$.StringFormat = function () {
    var s = arguments[0];
    for (var i = 0; i < arguments.length - 1; i++) {
        var reg = new RegExp("\\{" + i + "\\}", "gm");
        s = s.replace(reg, arguments[i + 1]);
    }
    return s;
};

$.consultaCidade = function (ufSigla, target) {
    $(target).empty();
    $.each(uf_cidade.estados, function (u, uf) {
        if (ufSigla === uf.sigla) {
            $.each(uf.cidades, function (c, cidades) {
                $(target).append('<option value="' + cidades + '">' + cidades + '</option>');
            });
        }
    });
};

$.consultaMapa = function (lat, lng,markers) {

   //$('#map > div').remove();

   var formulario = $('#buscaRapida').clone(); //fixme

    $('#map').gmap3({
        map:{
            options:{
                center:[lat,lng],
                zoom:15
            },
        },
        marker:{
        values:[
//customizavel por variavel      
          {
            latLng:[-22.912532, -47.0607349],
            events:{
              click:function(){
                $.showDetailsAboutPlace();
              }
            }
          },
          {
            latLng: [-22.902532, -47.0607349],
            events:{
              click:function(){
                $.showDetailsAboutPlace();
              }
            }
          },
          {
            latLng:[-22.904852, -47.0607349],
            events:{
              click:function(){
                $.showDetailsAboutPlace();
              }
            }
          },
          {
            latLng:[-22.903692, -47.0607349],
            events:{
              click:function(){
                $.showDetailsAboutPlace();
              }
            }
          }
        ]
//end customização
        ,
            events:{ // events trigged by markers
          click: function(){
            alert("Here is the default click event");
          }
            },
           cluster:{
          radius: 100,
          events:{ 
            click: function(cluster){
                $("#map").gmap3("get").setZoom(18);
            }
          },
          0: {
            content: "<div class='cluster cluster-1'>CLUSTER_COUNT</div>",
            width: 53,
            height: 52
          },
          20: {
            content: "<div class='cluster cluster-2'>CLUSTER_COUNT</div>",
            width: 56,
            height: 55
          },
          50: {
            content: "<div class='cluster cluster-3'>CLUSTER_COUNT</div>",
            width: 66,
            height: 65
          }
            }
        },
/*
        overlay:{
            latLng: [-22.904852, -47.0607349],
            options:{
                content:  '<div style="color:#000000; border:1px solid #FF0000; ' +
                    'background-color: #00FF00; width:200px; line-height:20px; ' +
                    'height: 20px; text-align:center">Hello World !</div>',
                offset:{
                    y:-33,
                    x:18
                }
            }
        }
  */  
    
    });
    //$('#map').addSimpleMarker(397, '14 Elm Place, Prahran Vic', '-22.902532', '-47.0607349', 'http://live.btoa.com.au/rentbuy/wp-content/uploads/2013/03/pin-red1.png', 'http://live.btoa.com.au/rentbuy/property/14-elm-place/', 'http://live.btoa.com.au/rentbuy/wp-content/uploads/2013/03/main45-170x154.jpg', '14 Elm Place', '3', '1', '3', 'Renovation Inspiration An alluring mix of a prime 375sqm (approx) block, a peaceful cul-de-sac setting an [...]', '$720,000');
    $('#map').append(formulario);


};

$.showDetailsAboutPlace = function(id) {
  $('#detalhesApartamento').show();
}

$.openURLContent = function (target, anchor) {
    $(target).load($.StringFormat('_{0}.html', anchor));
    return false;
};

$.searchPlace = function(field){
    var input = document.getElementById(field);
    var options = {
              componentRestrictions: {country: 'br'}
        };

    var autocomplete = new google.maps.places.Autocomplete(input);


    google.maps.event.addListener(autocomplete, 'place_changed', function() {

        var place = autocomplete.getPlace();
        $('#lat').val(place.geometry.location.lb);
        $('#lng').val(place.geometry.location.mb);
        
    });

}

$.criaPeso = function(campo){

    campo.slider({ //DRY???? MOTHERFUCKER
        animate: true,
         min: 1,
        max: 10,
        range: "min",
    });

}
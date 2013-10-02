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

$.consultaMapa = function (lat, lng) {

   //$('#map > div').remove();

   var formulario = $('#buscaRapida').clone(); //fixme

    $('#map').gmap3({
        map:{
            options:{
            center:[lat,lng],
            zoom:15
        }}
    });

    $('#map').append(formulario);
};



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
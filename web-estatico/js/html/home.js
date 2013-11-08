//Carga dinâmica dos slides
$.homeSlide = function (json) {
    var li = '',
        onclick = '',
        marker = '[';
    $.each(json.slides, function (i, key) {
        onclick = $.StringFormat("$.openURLContent('{0}', '{1}', '{2}');", key.target, key.partial, key.id);
        li += $.StringFormat('<li id="{0}" onclick="{1}"><img src="{2}" /><span>{3}</span><h3>{4}</h3><p>{5}</p></li>', key.id, onclick, key.img, key.placetype, key.neighborhood, key.details);
        marker += $.StringFormat('{0}{ latLng: [{1}, {2}], events: { click: function () { $.showPlaceInFlexslider("{3}"); }  } }', i !== 0 ? ',' : '', key.lat, key.lng, key.id);
    });

    marker += ']';

    $('.flexslider ul').empty().append(li);

    //Flexslider
    $('.flexslider').flexslider({
        selector: ".homeSlides > li",
        animation: "slide",
        slideshow: false,
        itemWidth: 520,
        keyboard: false,
        mousewheel: false,
        animationLoop: false,
        controlNav: false,
        move: 1
    });

    var lat = -22.977281,
        lng = -47.14822;

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            lat = position.coords.latitude;
            lng = position.coords.longitude;
        });
    }

    console.log(lat);
    console.log(lng);

    $.consultaMapa(lat, lng, "#map", marker);
};

$.homeSlide(home_slide);

//Autocomplete google places
$.searchPlace('endereco');

//Caixa de detalhes
$('#advancedSearch').tooltip();
$('#fastSearch').tooltip();
$('#hidePanel').tooltip();
$('#showPanel').tooltip();
$('.peso').tooltip();

//Aplica o efeito ui slide
$.criaSlider([$("#pesoAquisicao"), $('#pesoTipoImovel'), $('#pesoPreco'), $('#pesoBairro'), $('#pesoRaio'), $('#pesoDormitorios'), $('#pesoGaragens')]);

//Máscara
$("#precoDe").maskMoney({
    symbol: "R$ ",
    thousands: ".",
    precision: 0,
    allowZero: false,
    allowNegative: false
});
$("#precoAte").maskMoney({
    symbol: "R$ ",
    thousands: ".",
    precision: 0,
    allowZero: false,
    allowNegative: false
}).attr('style', 'display: none !important;');
$("#raio").maskMoney({
    thousands: ".",
    precision: 0,
    allowZero: false,
    allowNegative: false
});

//Eventos de click
$("#hidePanel").click(function () {
    $("#buscaRapida").hide(0, function () {
        $("#showSearch").show();
    });
});
$('#showPanel').click(function () {
    $('#showSearch').slideUp('fast', function () {
        $('#buscaRapida').show();
    });
});
$('.slides > li').click(function () {
    $.openURLContent('#content', 'detailsproperty', $.StringFormat('id={0}', $(this).attr('id')));
});
$('#advancedSearch').click(function () {
    $('#buscaRapida').hide(0, function () {
        $('#buscaAvancada').slideDown('slow');
    });
    $('#map').css('height', '330px');
});
$('#fastSearch').click(function () {
    $('#buscaAvancada').slideUp('slow', function () {
        $('#buscaRapida').show();
    });
    $('#map').css('height', '450px');
});
$('#buscarRapido').click(function () {    
    $('#map').gmap3({
        getlatlng:{
            address:  $('#endereco').val(),
            callback: function(results){
                if ( !results ) return;                
                $('#map').gmap3({
                    map: {
                        options: {
                            center: results[0].geometry.location,
                            zoom: 15,
                            scrollwheel: true
                        }
                    }                
                });
                
                //Autocomplete google places
                //$.searchPlace('endereco');
            }
        }
    });

    return false;
});

//Eventos de foco
$('#precoDe').focus(function () {
    $('#precoAte').removeAttr('style');
});
$('#bairro').focus(function () {
    $(this).removeClass('inputSizeMediumSmaller').addClass('inputSizeMedium');
}).blur(function () {
    $(this).removeClass('inputSizeMedium').addClass('inputSizeMediumSmaller');
});
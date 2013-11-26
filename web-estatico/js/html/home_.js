// Carga dinâmica dos slides
$.homeSlide = function (lat, lng) {
    var json = { slides: [{ id: "slide1", target: "#content", partial: "detailsproperty", img: "img/photography/1_0.jpg", placetype: "APARTAMENTO", neighborhood: "Cambuí", details: "Condomínio fechado, com piscina, academia e churrasqueira a 10 minutos do centro...", lat: -22.892799, lng: -47.049557 }, { id: "slide2", target: "#content", partial: "detailsproperty", img: "img/photography/2_0.jpg", placetype: "APARTAMENTO", neighborhood: "Centro", details: "Condomínio fechado, com piscina, academia e churrasqueira a 10 minutos do centro...", lat: -22.902044, lng: -47.060871 }, { id: "slide3", target: "#content", partial: "detailsproperty", img: "img/photography/3_0.jpg", placetype: "APARTAMENTO", neighborhood: "Nova Campinas", details: "Condomínio fechado, com piscina, academia e churrasqueira a 10 minutos do centro...", lat: -22.900161, lng: -47.041736 }, { id: "slide4", target: "#content", partial: "detailsproperty", img: "img/photography/4_0.jpg", placetype: "CASA", neighborhood: "Alphavile", details: "Condomínio fechado, com piscina, academia e churrasqueira a 10 minutos do centro...", lat: -22.82772, lng: -47.030369 }, { id: "slide5", target: "#content", partial: "detailsproperty", img: "img/photography/5_0.jpg", placetype: "CASA", neighborhood: "Valinhos", details: "Condomínio fechado, com piscina, academia e churrasqueira a 10 minutos do centro...", lat: -22.970114, lng: -46.99682 }, { id: "slide6", target: "#content", partial: "detailsproperty", img: "img/photography/6_0.jpg", placetype: "APARTAMENTO", neighborhood: "Sumaré", details: "Condomínio fechado, com piscina, academia e churrasqueira a 10 minutos do centro...", lat: -22.82059, lng: -47.270378 }, { id: "slide7", target: "#content", partial: "detailsproperty", img: "img/photography/7_0.jpg", placetype: "APARTAMENTO", neighborhood: "Valinhos", details: "Condomínio fechado, com piscina, academia e churrasqueira a 10 minutos do centro...", lat: -22.968736, lng: -46.994567 }] };

    jsonFind = {};
    //jsonFind.token = 'CAACEdEose0cBAAZAnD9sZCjqxMhPweg2YO8nETSY1R43xN9SMs5wH97D9XRgCdzF0q6ad2xHwVnLb0OsE7qKtyqz5LSt8AjmdGOInOwA3tf1R2yD6OXKR2kyCQis60HaoUVRwWTQC1RmUM0mui0ChWJplsSwZC8Y6CsATcYJ8csCdhoYs40kNahvevEC60ZD'
    jsonFind.lat = lat;
    jsonFind.lng = lng;
    jsonFind.distance = 30000;
    $.ajax({
        url: "findplaces-web/rest/place/search/bylatlong",
        data: jsonFind,
        method: 'GET',
        success: function (result) {
            console.log(result);
        }
    });

    var li = '',
        onclick = '',
        marker = '[';
    $.each(json.slides, function (i, key) {
        onclick = $.StringFormat("$.openURLContent('{0}', '{1}', 'id={2}');", key.target, key.partial, key.id);
        li += $.StringFormat('<li id="{0}" onclick="{1}"><img src="{2}" /><span>{3}</span><h3>{4}</h3><p>{5}</p></li>', key.id, onclick, key.img, key.placetype, key.neighborhood, key.details);
        marker += $.StringFormat('{0}{ latLng: [{1}, {2}], events: { click: function () { $.showPlaceInFlexslider("{3}"); }  } }', i !== 0 ? ',' : '', key.lat, key.lng, key.id);
    });

    marker += ']';

    if ($('.flexslider').length > 0) {
        $('.flexslider').remove();
    }

    $('#map').after('<div class="flexslider"><ul class="homeSlides">' + li + '</ul></div>');
    
    // Flexslider
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

    //lat = -22.977281;
    //lng = -47.14822;

    //if (navigator.geolocation) {
    //    navigator.geolocation.getCurrentPosition(function (position) {
    //        lat = position.coords.latitude;
    //        lng = position.coords.longitude;
    //    });
    //}

    //console.log(lat);
    //console.log(lng);

    $.consultaMapa(lat, lng, "#map", marker);
};

$(document).ready(function () {    
    $.homeSlide(-22.9071048, -47.06323910000003);

    // Autocomplete google places
    $.searchPlace('endereco');
    $.searchPlace('enderecoAvancado');

    // Caixa de detalhes
    $('#advancedSearch').tooltip();
    $('#fastSearch').tooltip();
    $('#hidePanel').tooltip();
    $('#showPanel').tooltip();
    $('#sliderHelp').tooltip();

    // Aplica o efeito ui slide
    $.criaSlider([$("#pesoAquisicao"), $('#pesoTipoImovel'), $('#pesoPreco'), $('#pesoRaio'), $('#pesoDormitorios'), $('#pesoGaragens')]);

    // Máscara
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

    // Eventos de click
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
            $('#map').css('height', '480px');
        });
    });
    $('#fastSearch').click(function () {
        $('#buscaAvancada').slideUp('slow', function () {
            $('#buscaRapida').show();
            $('#map').css('height', '600px');
        });
    });
    $('#buscarRapido').click(function () {
        $('#map').gmap3({
            getlatlng: {
                address: $('#endereco').val(),
                callback: function (results) {
                    if (!results) return;
                    $('#hidePanel').click();

                    //Adicionar busca aqui
                    $.homeSlide(results[0].geometry.location.ob, results[0].geometry.location.pb);
                }
            }
        });

        return false;
    });

    // Eventos de foco
    $('#precoDe').focus(function () {
        $('#precoAte').removeAttr('style');
    });
    $('#bairro').focus(function () {
        $(this).removeClass('inputSizeMediumSmaller').addClass('inputSizeMedium');
    }).blur(function () {
        $(this).removeClass('inputSizeMedium').addClass('inputSizeMediumSmaller');
    });
}); 
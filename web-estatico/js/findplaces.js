/*!
 * FINDPLACES V1.00
 * Copyright 2013
 */
/* ## MÉTODOS MINIMIFICADOS ## */
//Método para serializar um form ou grupo fields values
$.fn.serializeObject = function () { var e = {}; var t = this.serializeArray(); $.each(t, function () { if (e[this.name] !== undefined) { if (!e[this.name].push) e[this.name] = [e[this.name]]; e[this.name].push(this.value || ""); } else e[this.name] = this.value || ""; }); return e; };
//Método para recuperar parametros de url
$.getUrlParam = function (e, t) { var n = (new RegExp("[\\?&]" + e + "=([^&#]*)")).exec(t); if (n !== null) { return n[1]; } else { return 0; } };
//Método para simular método StringFormat de algumas linguagens
$.StringFormat = function () { var e = arguments[0]; for (var t = 0; t < arguments.length - 1; t++) { var n = new RegExp("\\{" + t + "\\}", "gm"); e = e.replace(n, arguments[t + 1]); } return e; };
//Método para verificar se o campo é nulo ou vazio
$.IsNullOrEmpty = function (e, t) { if (e == "null" || e == null || e == "" || e == "undefined") return t; return e; };
//Método para criar um slide (utilizado nos pesos da busca avançada)
$.criaSlider = function (e) { $.each(e, function (t, n) { n.slider({ animate: true, min: 1, max: 10, range: "max" }); }); };
//Método para abrir uma url, aplicar #nomepágina e enviar paramentros
$.openURLContent = function (e, t, n) { window.history.pushState(null, null, $.StringFormat("index.html#{0}{1}", t, $.IsNullOrEmpty(n, null) === null ? "" : "?" + n)); $(e).load($.StringFormat("_{0}.html", t.split('?')[0])); return false; };
//Método para esconder um grupo de objetos ou arrays de fields (id ou class) [a variável t é um id ou classe que não deve ser oculto (exceção)] [a variável n é um id ou classe que deve ser exibido]
$.hideFields = function (e, t, n) { if (e.length > 0) { $(e).each(function (r, i) { if (!$(i).attr("id") === t || !$(i).hasClass(t)) $(i).hide(); $(i).find('input').val(''); }); } if ($.IsNullOrEmpty(n, null) !== null) { $(n).show(); } };
//Método para exibir um grupo de objetos ou arrays de fields (id ou class) [a variável t é um id ou classe que não deve ser exibido (exceção)] [a variável n é um id ou classe que deve ser oculto]
$.showFields = function (e, t, n) { if (e.length > 0) { $(e).each(function (r, i) { if (!$(i).attr("id") === t || !$(i).hasClass(t)) $(i).show(); }); } if ($.IsNullOrEmpty(n, null) !== null) { $(n).hide(); } };
//Método para calcular o valor de um grupo de objetos ou arrays de fields (id ou class) [a variável t é um grupo de arrays de fields que deve ser ignorado na soma]
$.sumInputGroup = function (e, t) { var n; var r = []; $(e).each(function (i, s) { r.push(s.id); }); $(t).each(function (o, u) { n = r.indexOf(u); r.splice(n, 1); }); var a; var f = 0; $(r).each(function (l, c) { a = $("#" + c).val(); if ($.IsNullOrEmpty(a, null) !== null) { if (a.indexOf("R$ ") >= 0) a = a.replace("R$ ", ""); if (a.indexOf(".") >= 0) a = a.replace(".", ""); f += parseFloat(a); } }); $("#totalPrice").val(f).maskMoney("mask"); };
/* ## MÉTODOS MINIMIFICADOS ## */

//Remover e utilizar google
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

$.consultaMapa = function (latStart, lngStart, target, marker) {
    var formulario = $('#buscaRapida').clone();

    $(target).gmap3({
        map: {
            options: {
                center: [latStart, lngStart],
                zoom: 15,
                scrollwheel: true
            }
        },
        marker: {
            values: eval(marker),
            options: {
                icon: new google.maps.MarkerImage("img/pointer-house.png", new google.maps.Size(32, 37, "px", "px"))
            },
            cluster: {
                radius: 100,
                events: {
                    click: function (cluster) {
                        var map = $(target).gmap3("get");
                        map.setZoom(16);
                        map.setCenter(cluster.main.getPosition());
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
        }
    });

    $(target).append(formulario);
};

$.showPlaceInFlexslider = function (id) {
    $('.homeSlides > li').each(function (i, item) {
        $(item).removeClass('flexsliderSelectByMap');
        if ($(item).attr('id') === id) {
            $('.flexslider').flexslider(i);
            $('#' + id).addClass('flexsliderSelectByMap');
        }
    });
};

$.openHashTagContent = function () {
    var hash = window.location.hash.substring(1);
    $.openURLContent('#content', hash, null);
};

$.searchPlace = function (field) {
    var input = document.getElementById(field);
    var options = {
        componentRestrictions: {
            country: 'br'
        }
    };

    var autocomplete = new google.maps.places.Autocomplete(input);

    if ($('#lat').length > 0 && $('#lng').length > 0) {
        google.maps.event.addListener(autocomplete, 'place_changed', function () {
            var place = autocomplete.getPlace();
            $('#lat').val(place.geometry.location.lat());
            $('#lng').val(place.geometry.location.lng());
        });
    }
};

$.initLogin = function () {
    FB.Event.subscribe('auth.authResponseChange', function (response) {
        console.log(response);
        if (response.status == 'connected') {
            findplaces.webservice.user.loginWithFacebook(response.authResponse.accessToken, response.authResponse.userID);
            window.window.location = findplaces.constantes.LOGIN_FB_URL + "?token=" + response.authResponse.accessToken + "&userID=" + response.authResponse.userID;
        }
    });
};

$.geocodePlace = function (address, callback) {
    var geocoder = new google.maps.Geocoder();
    geocoder.geocode({ 'address': address }, function (response) {
        var place = {};
        place.address = response[0].formatted_address;
        place.lat = response[0].geometry.location.lb;
        place.lng = response[0].geometry.location.mb;
        callback(place);
    });

};
/*!
 * FINDPLACES V1.00
 * Copyright 2013
 */
/* ## MÉTODOS MINIMIFICADOS ## */
//Método para serializar um form ou grupo fields values
$.fn.serializeObject = function () { var e = {}; var t = this.serializeArray(); $.each(t, function () { if (e[this.name] !== undefined) { if (!e[this.name].push) e[this.name] = [e[this.name]]; e[this.name].push(this.value || ""); } else e[this.name] = this.value || ""; }); return e; };
//Método para recuperar parametros de url
$.getUrlParam = function (e, t) { var n = (new RegExp("[\\?&]" + e + "=([^&#]*)")).exec(t); return n[1] || 0; };
//Método para simular método StringFormat de algumas linguagens
$.StringFormat = function () { var e = arguments[0]; for (var t = 0; t < arguments.length - 1; t++) { var n = new RegExp("\\{" + t + "\\}", "gm"); e = e.replace(n, arguments[t + 1]); } return e; };
//Método para verificar se o campo é nulo ou vazio
$.fn.IsNullOrEmpty = function (e, t) { if (e == "null" || e == null || e == "" || e == "undefined") return t; return e; };
//Método para criar um slide (utilizado nos pesos da busca avançada)
$.criaSlider = function (e) { $.each(e, function (t, n) { n.slider({ animate: true, min: 1, max: 10, range: "min" }); }); };
//Método para abrir uma url, aplicar #nomepágina e enviar paramentros
$.openURLContent = function (e, t, n) { window.history.pushState(null, null, $.StringFormat("index.html#{0}{1}", t, n === null ? "" : "?" + n)); $(e).load($.StringFormat("_{0}.html", t.split('?')[0])); return false; };
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

$.consultaMapa = function (lat, lng, markers) {
    var formulario = $('#buscaRapida').clone(); //fixme
    $('#map').gmap3({
        map: {
            options: {
                center: [lat, lng],
                zoom: 15
            },
        },
        marker: {
            values: [
                {
                    latLng: [-22.970949, -47.150844],
                    events: {
                        click: function () {
                            $.showPlaceInFlexslider('slide1');
                        }
                    }
                }, {
                    latLng: [-22.970228, -47.145608],
                    events: {
                        click: function () {
                            $.showPlaceInFlexslider('slide7');
                        }
                    }
                }, {
                    latLng: [-22.972085, -47.149588],
                    events: {
                        click: function () {
                            $.showPlaceInFlexslider('slide2');
                        }
                    }
                }, {
                    latLng: [-22.972905, -47.141788],
                    events: {
                        click: function () {
                            $.showPlaceInFlexslider('slide6');
                        }
                    }
                }
            ]
            ,
            options: {
                icon: new google.maps.MarkerImage(
                    "img/pointer-house.png",
                    new google.maps.Size(32, 37, "px", "px")
                )
            }
            ,
            //events trigged by markers
            events: {
                click: function () {
                    alert("Here is the default click event");
                }
            },
            cluster: {
                radius: 100,
                events: {
                    click: function (cluster) {
                        var map = $("#map").gmap3("get");
                        map.setZoom(17);
                        //cluster.main.getPosition();
                        map.setCenter(cluster.main.getPosition());
                    }
                },
                0: {
                    content: "<div>CLUSTER_COUNT</div>",
                    width: 53,
                    height: 52
                },
                20: {
                    content: "<div>CLUSTER_COUNT</div>",
                    width: 56,
                    height: 55
                },
                50: {
                    content: "<div>CLUSTER_COUNT</div>",
                    width: 66,
                    height: 65
                }
            }
        }
    });
    $('#map').append(formulario);
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

    google.maps.event.addListener(autocomplete, 'place_changed', function () {
        var place = autocomplete.getPlace();
        $('#lat').val(place.geometry.location.lb);
        $('#lng').val(place.geometry.location.mb);
    });
};



$.initLogin = function () {
    FB.Event.subscribe('auth.authResponseChange', function (response) {
        console.log(response);
        if (response.status === 'connected') {
            findplaces.webservice.user.loginWithFacebook(response.authResponse.accessToken, response.authResponse.userID);
            window.window.location = findplaces.constantes.LOGIN_FB_URL + "?token=" + response.authResponse.accessToken + "&userID=" + response.authResponse.userID;
        }
    });
};
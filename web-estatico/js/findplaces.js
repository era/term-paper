$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

$.StringFormat = function () {
    var s = arguments[0];
    for (var i = 0; i < arguments.length - 1; i++) {
        var reg = new RegExp("\\{" + i + "\\}", "gm");
        s = s.replace(reg, arguments[i + 1]);
    }
    return s;
};

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
            //customizavel por variavel      
            values: [
                {
                    latLng: [-22.912532, -47.0607349],
                    events: {
                        click: function () {
                            $.showDetailsAboutPlace();
                        }
                    }
                }, {
                    latLng: [-22.902532, -47.0607349],
                    events: {
                        click: function () {
                            $.showDetailsAboutPlace();
                        }
                    }
                }, {
                    latLng: [-22.904852, -47.0607349],
                    events: {
                        click: function () {
                            $.showDetailsAboutPlace();
                        }
                    }
                }, {
                    latLng: [-22.903692, -47.0607349],
                    events: {
                        click: function () {
                            $.showDetailsAboutPlace();
                        }
                    }
                }
            ]
            //end customização
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
    });
    $('#map').append(formulario);
};

$.showDetailsAboutPlace = function (id) {
    $('#detalhesApartamento').show();
};

$.openHashTagContent = function () {
    var hash = window.location.hash.substring(1);
    $.openURLContent('#content', hash);
};

$.openURLContent = function (target, anchor) {
    window.history.pushState(null, null, "index.html#" + anchor); //objState, title, page
    $(target).load($.StringFormat('_{0}.html', anchor));
    return false;
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

$.criaSlider = function (objects) {
    $.each(objects, function (i, item) {
        item.slider({
            animate: true,
            min: 1,
            max: 10,
            range: "min",
        });
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
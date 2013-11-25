$(document).ready(function () {
    var id = 210;

    var idImages = ['1_1.jpg', '1_2.jpg', '1_3.jpg', '1_4.jpg'];

    var li = '';

    if (idImages.length === 0) {
        $(idImages).each(function (i, img) {
            li += $.StringFormat("<li data-thumb='img/photography/{0}'><img src='img/photography/{0}' alt='{0}' title='{0}' /></li>", img);
        });

        $('#detailsProperty').before('<div id="detailsAlbum" class="flexslider"><ul class="slides">' + li + '</ul></div>');
    } else {
        $('#detailsProperty').before('<div id="detailsAlbum" class="flexslider"><ul class="slides"><li data-thumb="img/no-img.jpg"><img src="img/no-img.jpg" alt="no-img.jpg" title="no-img.jpg" /></li></ul></div>');
    }

    $('.flexslider').flexslider({
        animation: "slide",
        controlNav: "thumbnails",
        slideshow: false
    });

    $("#tabs").tabs();

    $('#save_comment_user').click(function() {
        $.ajax({
            url: '',
            data: '',
            method: 'POST',
            success: function (result) {
                console.log('SUCESSO[SAVE_COMMENT]: ' + JSON.stringify(result));
                return false;
            },
            error: function (result) {
                console.log('ERRO[SAVE_COMMENT]: ' + JSON.stringify(result));
                return false;
            }
        });
    });
    
    return false;

    //alert($.getUrlParam('id', location.href));

    $.ajax({
        url: "findplaces-web/rest/place/" + id,
        method: 'GET',
        success: function (result) {
            console.log(JSON.stringify(result));

            var places = result.places[0];

            $('#top-title').append((places.type.id === 1 ? 'Apartamento • ' : 'Casa • ') + places.address.substring(0, 25) + '...');

            var valuesHTML;
            if (places.sellType[0] === 1) {
                valuesHTML = $.StringFormat('<div id="imovel-valor-titulo">Valor total<span>R$ {0}</span></div><br class="clr" />', places.price);
                $('#tabs-1').empty().append(valuesHTML);
            } else {
                var rent = places.rent !== null ? places.rent : 0;
                var iptu = places.iptu !== null ? places.iptu : 0;
                var condominiumPrice = places.condominiumPrice !== null ? places.condominiumPrice : 0;
                var internet = places.internet !== null ? places.internet : 0;
                var tv = places.tv !== null ? places.tv : 0;

                var totalPrice = rent + iptu + condominiumPrice + internet + tv;

                valuesHTML = $.StringFormat('<div id="imovel-valor-titulo">Valor total<span>R$ {0}</span></div><br class="clr" />', totalPrice);
                valuesHTML += $.StringFormat('<div class="imovel-valor-outros">Aluguel<span>R$ {0}</span></div><br class="clr" />', rent);
                valuesHTML += $.StringFormat('<div class="imovel-valor-outros">IPTU<span>R$ {0}</span></div><br class="clr" />', iptu);
                valuesHTML += $.StringFormat('<div class="imovel-valor-outros">Condomínio<span>R$ {0}</span></div><br class="clr" />', condominiumPrice);
                valuesHTML += $.StringFormat('<div class="imovel-valor-outros">Banda larga<span>R$ {0}</span></div><br class="clr" />', internet);
                valuesHTML += $.StringFormat('<div class="imovel-valor-outros">TV por assinatura<span>R$ {0}</span></div><br class="clr" />', tv);

                $('#tabs-1').empty().append(valuesHTML);
            }

            var infoHTML = $.StringFormat('<div id="imovel-detalhes">{0}</div>', places.description);
            infoHTML += '<span>Comodidades</span>';
            infoHTML += '<table id="lista-comodidades"><tr><th>Do imóvel</th></tr>';
            infoHTML += $.StringFormat('<tr><td class="{0}">Acesso à internet incluso</td></tr>', places.facilities.internet === true ? 'list-ok' : 'list-no-ok');
            infoHTML += $.StringFormat('<tr><td class="{0}">Armários embutido no quarto</td></tr>', places.facilities.bedroomCloset === true ? 'list-ok' : 'list-no-ok');
            infoHTML += $.StringFormat('<tr><td class="{0}">Armários na cozinha</td></tr>', places.facilities.kitchenCabinet === true ? 'list-ok' : 'list-no-ok');
            infoHTML += $.StringFormat('<tr><td class="{0}">Banheira hidromassagem</td></tr>', places.facilities.hidromassage === true ? 'list-ok' : 'list-no-ok');
            infoHTML += $.StringFormat('<tr><td class="{0}">Varanda</td></tr>', places.facilities.terrace === true ? 'list-ok' : 'list-no-ok');
            infoHTML += '</table>';

            infoHTML += '<table><tr><th>Do condomínio</th></tr>';
            infoHTML += $.StringFormat('<tr><td class="{0}">Porteiro</td></tr>', places.facilities.gatekeeper === true ? 'list-ok' : 'list-no-ok');
            infoHTML += $.StringFormat('<tr><td class="{0}">Churrasqueira</td></tr>', places.facilities.townBarbecue === true ? 'list-ok' : 'list-no-ok');
            infoHTML += $.StringFormat('<tr><td class="{0}">Gás encanado</td></tr>', places.facilities.gasTubing === true ? 'list-ok' : 'list-no-ok');
            infoHTML += $.StringFormat('<tr><td class="{0}">Piscina</td></tr>', places.facilities.townPool === true ? 'list-ok' : 'list-no-ok');
            infoHTML += $.StringFormat('<tr><td class="{0}">Portão automático</td></tr>', places.facilities.automaticDoor === true ? 'list-ok' : 'list-no-ok');
            infoHTML += '</table>';

            $('#tabs-2').empty().append(infoHTML);

            var localHTML = '<div id="map-details"></div>';
            localHTML += $.StringFormat('<div id="imovel-detalhes" style="border-top: 1px dotted #999; margin-top: 7px;">{0}</div>', places.address);


            $('#tabs-3').empty().append(localHTML);

            $('#show-map-details').click(function () {
                $('#map-details').width('390px').height('250px').gmap3({
                    map: {
                        options: {
                            center: [places.lat, places.lng],
                            zoom: 15,
                            scrollwheel: false,
                            streetViewControl: false,
                            navigationControl: false,
                            zoomControl: false,
                            mapTypeControl: false
                        }
                    },
                    marker: {
                        values: [{
                            latLng: [places.lat, places.lng]
                        }],
                        options: {
                            icon: new google.maps.MarkerImage("img/pointer-house.png", new google.maps.Size(32, 37, "px", "px"))
                        }
                    }
                });
            });

            var detailsHTML = '<div>DETALHES</div><ul>';

            detailsHTML += $.StringFormat('<li>Tipo de imóvel: {0}</li>', places.type.id === 1 ? 'Apartamento' : 'Casa');

            if (places.type.id) {
                detailsHTML += $.StringFormat('<li>Apartamentos por andar: {0}</li>', places.qtdPlaceFloor);
                detailsHTML += $.StringFormat('<li>Andar em que se localiza: {0}º</li>', places.placeFloor);
            }

            detailsHTML += $.StringFormat('<li>Área útil: {0} m²</li>', places.m2);
            detailsHTML += $.StringFormat('<li>Dormitórios: {0}</li>', places.bedroom);
            detailsHTML += $.StringFormat('<li>Suítes: {0}</li>', places.suite);
            detailsHTML += $.StringFormat('<li>Sala: {0}</li>', places.room);
            detailsHTML += $.StringFormat('<li>Banheiros: {0}</li>', places.bathroom);
            detailsHTML += $.StringFormat('<li>Vagas de Garagem: {0}</li>', places.garage);
            detailsHTML += '</ul>';


            $('#account-actions').empty().append(detailsHTML);
        }
    });
});
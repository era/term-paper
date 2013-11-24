﻿// Gráficos
$.placeChart = function () {
    var placeChart = { month: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio'], values: [Math.ceil(Math.random() * 100), Math.ceil(Math.random() * 100), Math.ceil(Math.random() * 100), Math.ceil(Math.random() * 100), Math.ceil(Math.random() * 100)] };
    var placeCtx = document.getElementById("placeChart").getContext("2d");
    var placeData = {
        labels: placeChart.month,
        datasets: [
            {
                fillColor: "rgba(151,187,205,0.5)",
                strokeColor: "rgba(151,187,205,1)",
                pointColor: "rgba(151,187,205,1)",
                pointStrokeColor: "#fff",
                data: placeChart.values
            }
        ]
    };
    new Chart(placeCtx).Line(placeData);
};

$.neighborhoodChart = function () {
    var neighborhoodChart = { month: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio'], values: [Math.ceil(Math.random() * 100), Math.ceil(Math.random() * 100), Math.ceil(Math.random() * 100), Math.ceil(Math.random() * 100), Math.ceil(Math.random() * 100)] };
    var neighborhoodCtx = document.getElementById("neighborhoodChart").getContext("2d");
    var neighborhoodData = {
        labels: neighborhoodChart.month,
        datasets: [
            {
                fillColor: "rgba(151,187,205,0.5)",
                strokeColor: "rgba(151,187,205,1)",
                data: neighborhoodChart.values
            }
        ]
    };
    new Chart(neighborhoodCtx).Bar(neighborhoodData);
};

$.ageOfUsersChart = function () {
    var ageOfUsersChart = [{ value: Math.ceil(Math.random() * 100), color: "#F38630" }, { value: Math.ceil(Math.random() * 100), color: "#E0E4CC" }, { value: Math.ceil(Math.random() * 100), color: "#69D2E7" }];
    var ageOfUsersCtx = document.getElementById("ageOfUsersChart").getContext("2d");
    new Chart(ageOfUsersCtx).Pie(ageOfUsersChart);
};

// Simula o click no input file
$.addPhoto = function () {
    $('#photo').click();
};

// Perguntas
$.placeQuestions = function () {
    var placeQuestions = { questions: [{ id: 1, date: '10/10/2013', user: 'Roberto', question_text: 'O portão é automático? Se não for ao ser seu inquilino você aceita que seja colocado e descontado do aluguel?', reply_text: '' }, { id: 2, date: '09/11/2013', user: 'Ana', question_text: 'Como é o movimento no condomínio? Você morou no local?', reply_text: 'O movimento no condomínio é bem tranquilo. Eu morei por 3 anos no local e mudamos em função do trabalho. Excelente lugar para crianças e toda a família, o condominio é amplo e com diversar opções de lazer.' }] };
    var tr = $.StringFormat('<tr><th>{0}</th><th>{1}</th><th>{2}</th><th>{3}</th><th></th></tr>', 'Data da pergunta', 'Status', 'Usuário', 'Pergunta');
    $.each(placeQuestions.questions, function (i, key) {
        var onclick = '', img = '', reply = '';
        if ($.IsNullOrEmpty(key.reply_text, null) === null) {
            onclick = $.StringFormat("$.responseQuestion('#response_{0}')", key.id);
            img = $.StringFormat('<img id="response_{0}" src="img/response.png" alt="Responder pergunta" title="Responder pergunta" onclick="{1}" />', key.id, onclick);
        } else {
            reply = $.StringFormat("<tr style='background-color: #D7FCDD;'><td colspan='5' style='font-style: italic;'>{0}</td></tr>", key.reply_text);
        }
        tr += $.StringFormat("<tr><td>{0}</td><td>{1}</td><td>{2}</td><td>{3}</td><td>{4}</td></tr>{5}", key.date, ($.IsNullOrEmpty(key.reply_text, null) !== null ? 'Não respondida' : 'Respondida'), key.user, key.question_text, img, reply);
    });
    $('#property-questions').append(tr);
};

// Resposta
$.responseQuestion = function (fieldName) {
    var _input = $.StringFormat('<textarea id={0} cols="109" rows="2" maxlength="1000" style="vertical-align: middle;" />', 'response_text_' + fieldName.split('_')[1]);
    var _responseButton = $.StringFormat('<a id={0} href="#" style="vertical-align: bottom;margin-left: 5px;">Responder</a>', 'response_button_' + fieldName.split('_')[1]);
    var _cancelResponseButton = $.StringFormat('<a href="#" onclick="$(this).parent().parent().remove();" style="vertical-align: bottom;margin-left: 5px;">Cancelar</a>');

    if ($('#response_text_' + fieldName.split('_')[1]).length === 0)
        $(fieldName).parent().parent().after($.StringFormat('<tr style="background-color: #D7FCDD;"><td colspan="5" style="text-align: left;">{0}{1}{2}</td></tr>', _input, _responseButton, _cancelResponseButton));
};

$(document).ready(function () {
    // Autocomplete google places
    $.searchPlace('address1');

    // Verifica se é uma edição, adicionar aqui validação imóvel x id_usuario
    var id = $.getUrlParam('id', location.href);
    if ($.IsNullOrEmpty(id, null) !== null) {
        $.ajax({
            url: "findplaces-web/rest/place/" + id,
            data: { "socialid": "100001401841332" },
            method: 'GET',
            success: function (result) {
                //console.log(result);
                var places = result.places[0];

                console.log(JSON.stringify(places));
                $('#sellType').val(places.sellType[0]).trigger("change");
                $('#placetype').val(places.type.id).trigger("change");
                $('#address1').val(places.address);

                // Mostra as abas e atualiza os gráficos
                $('#tabs-2-title').show();
                $('#tabs-3-title').show();
                $.placeChart();
                $.neighborhoodChart();
                $.ageOfUsersChart();
                $.placeQuestions();
            }
        });
    } else {
        $('#tabs-2-title').hide();
        $('#tabs-3-title').hide();
    }

    // Seta as máscaras da tela
    $("#price").maskMoney({ symbol: "R$ ", thousands: ".", precision: 0, allowNegative: false });
    $("#deposit").maskMoney({ symbol: "R$ ", thousands: ".", precision: 0, allowNegative: false });
    $("#rent").maskMoney({ symbol: "R$ ", thousands: ".", precision: 0, allowNegative: false });
    $("#contract_time").maskMoney({ thousands: ".", precision: 0, allowNegative: false });
    $("#pack_time").maskMoney({ thousands: ".", precision: 0, allowNegative: false });
    $("#period").maskMoney({ symbol: "R$ ", thousands: ".", precision: 0, allowNegative: false });
    $("#iptu").maskMoney({ symbol: "R$ ", thousands: ".", precision: 0, allowNegative: false });
    $("#complexPrice").maskMoney({ symbol: "R$ ", thousands: ".", precision: 0, allowNegative: false });
    $("#internetPrice").maskMoney({ symbol: "R$ ", thousands: ".", precision: 0, allowNegative: false });
    $("#tv").maskMoney({ symbol: "R$ ", thousands: ".", precision: 0, allowNegative: false });
    $("#totalPrice").maskMoney({ symbol: "R$ ", thousands: ".", precision: 0, allowNegative: false });
    $("#qtdPlaceFloor").maskMoney({ precision: 0, allowNegative: false });
    $("#placeFloor").maskMoney({ precision: 0, allowNegative: false });
    $("#m2").maskMoney({ precision: 0, allowNegative: false });
    $("#bedroom").maskMoney({ precision: 0, allowNegative: false });
    $("#suite").maskMoney({ precision: 0, allowNegative: false });
    $("#room").maskMoney({ precision: 0, allowNegative: false });
    $("#bathroom").maskMoney({ precision: 0, allowNegative: false });
    $("#garage").maskMoney({ precision: 0, allowNegative: false });

    // Esconde todos os campos do grupo Valores e Detalhes que dependem de um valor de seleção antes (Tipo de anúnio e imóvel)
    $.hideFields('#values-details > div', 'msg_fieldset', null);
    $.hideFields([$('#valid_of').parent()], null, null);
    $.hideFields('#details > div', 'msg_fieldset', null);

    // Habilita a dica para o id informado
    $('#help_valid_of').tooltip();

    // Habilita as abas para o id informado
    $("#tabs").tabs();

    // Observa a seleção Tipo de anúncio, esconde todos os campos e exibe com base no tipo de seleção. Em caso de troca de seleção os valores dos campos são limpos.
    $('#sellType').change(function () {
        $.hideFields('#values-details > div', null, '#values-details > .msg_fieldset');
        $.hideFields($('#valid_of').parent(), null, null);
        switch ($(this).find(":selected").text()) {
            case 'Venda':
                $.showFields([$('#price').parent(), $('#totalPrice').parent()], null, '#values-details > .msg_fieldset');
                break;
            case 'Aluguel':
                $.showFields([$('#deposit').parent(), $('#rent').parent(), $('#contract_time').parent(), $('#iptu').parent(), $('#complexPrice').parent(), $('#internetPrice').parent(), $('#tv').parent(), $('#totalPrice').parent()], null, '#values-details > .msg_fieldset');
                break;
            case 'Temporada':
                $.showFields([$('#deposit').parent(), $('#rent').parent(), $('#pack_time').parent(), $('#totalPrice').parent(), $('#valid_of').parent()], null, '#values-details > .msg_fieldset');
                $.showFields($('#valid_of').parent(), null, null);
                break;
        }
    });

    // Observa a seleção Tipo de imóvel, esconde todos os campos e exibe com base no tipo de seleção. Em caso de troca de seleção os valores dos campos são limpos.
    $('#placetype').change(function () {
        $.hideFields('#details > div', null, '#details > .msg_fieldset');
        switch ($(this).find(":selected").text()) {
            case 'Apartamento':
                $.showFields(['#details > div'], null, '#details > .msg_fieldset');
                break;
            case 'Casa':
                $.showFields(['#details > div'], null, '#details > .msg_fieldset');
                $.hideFields([$('#qtdPlaceFloor').parent(), $('#placeFloor').parent()], 'msg_fieldset', null);
                break;
        }
    });

    // Observa a saída do campo informado e executa a soma de seus valores
    $('#values-details > div > input').blur(function () {
        $.sumInputGroup('#values-details > div > input', ['deposit', 'contract_time', 'totalPrice']);
    });

    // Lista os estados
    $.each(uf_cidade.estados, function (key, val) {
        $('#region_name').append('<option value="' + val.sigla + '">' + val.sigla + '</option>');
    });

    // Lista as cidades com base no estado default
    $.consultaCidade($('#region_name :selected').text(), '#city_name');

    // Thumb de fotos
    $('#photo').change(function (e) {
        if ($('.img_upload').length < 5) {
            var selectedFile = e.target.files[0];
            var reader = new FileReader();
            var imageName = $(this).val().split('.')[0];
            var imageSize = this.files[0].size;

            if ($('#img_' + imageName).length === 0 && imageSize < 1000000) {
                reader.onload = function (e) {
                    $('#div_link_photo').before($.StringFormat('<img alt="Clique para remover" src="{0}" class="img_upload" id="img_{1}" onclick="{2}" title="Clique para remover">', e.target.result, imageName, '$(this).remove();'));
                };

                reader.readAsDataURL(selectedFile);
            } else {
                alert("Verifique se a imagem não é maior que 1Mb ou se já não foi adicionada.");
            }
        } else {
            alert("O número máximo de imagens já foi adicionada.");
        }
    });

    // Eventos de click
    $('#save_property').click(function () {
        $('#form_property').validate({
            errorElement: "span",
            rules: {
                adtype: 'required',
                placetype: 'required',
                address1: 'required',
                phone1: 'required',
                price: 'required',
                rent: 'required'
            },
            submitHandler: function () {
                var jsonForm = $('#form_property').serializeObject();
                var jsonPost = {};

                jsonPost.id = $.IsNullOrEmpty(id, null) !== null ? parseInt(id) : null;
                jsonPost.address = jsonForm.address1;
                jsonPost.sellType = [];
                jsonPost.sellType.push(parseInt(jsonForm.sellType));
                jsonPost.seller = {};
                jsonPost.seller.id = 2;
                jsonPost.placetype = {};
                jsonPost.placetype.id = parseInt(jsonForm.placetype);
                jsonPost.lat = jsonForm.lat;
                jsonPost.lng = jsonForm.lng;
                jsonPost.bathroom = parseInt(jsonForm.bathroom);
                jsonPost.bedroom = parseInt(jsonForm.bedroom);
                jsonPost.complexPrice = $.IsNullOrEmpty(jsonForm.complexPrice, null);
                jsonPost.description = jsonForm.description;
                jsonPost.garage = parseInt(jsonForm.garage);
                jsonPost.m2 = parseInt(jsonForm.m2);
                jsonPost.price = $.IsNullOrEmpty(jsonForm.price, null);
                jsonPost.deposit = $.IsNullOrEmpty(jsonForm.deposit, null);
                jsonPost.rent = $.IsNullOrEmpty(jsonForm.rent, null);
                jsonPost.contract_time = $.IsNullOrEmpty(jsonForm.contract_time, null);
                jsonPost.iptu = $.IsNullOrEmpty(jsonForm.iptu, null);
                jsonPost.internet = $.IsNullOrEmpty(jsonForm.internetPrice, null);
                jsonPost.tv = $.IsNullOrEmpty(jsonForm.tv, null);
                jsonPost.room = parseInt(jsonForm.room);
                jsonPost.suite = parseInt(jsonForm.suite);
                jsonPost.placeFloor = parseInt(jsonForm.placeFloor);
                jsonPost.qtdPlaceFloor = parseInt(jsonForm.qtdPlaceFloor);
                jsonPost.totalPrice = jsonForm.totalPrice;
                jsonPost.cellphone = jsonForm.cellphone;
                jsonPost.cellphone2 = jsonForm.cellphone2;
                jsonPost.socialid = '100001401841332';
                jsonPost.token = 'CAACEdEose0cBACv8zPk2H8YKFUYZCwhKZCfZAeiFfZCYU3Al0qI5ZBnJuNBqYUtZAynVnIkOQJCBWB7bfr2Bu0n28eoJqaE6sEP5HM9HeVhoNTXYpewn9OOQ4dnsEV7aZCWEb3NVwezPiUoTdTnWrm7OV7JRBnB2rvh9fOxGnLZAWG9IpzSiLUZCLZBukG5ZCxQbjrlF4djUBu6ZBAZDZD';
                jsonPost.facilities = {};
                jsonPost.facilities.name = null;
                jsonPost.facilities.gatekeeper = $('#gatekeeper').is(':checked');
                jsonPost.facilities.gym = false;
                jsonPost.facilities.townBarbecue = $('#townBarbecue').is(':checked');
                jsonPost.facilities.gasTubing = $('#gasTubing').is(':checked');
                jsonPost.facilities.laundry = false;
                jsonPost.facilities.townPool = $('#townPool').is(':checked');
                jsonPost.facilities.playground = false;
                jsonPost.facilities.automaticDoor = $('#automaticDoor').is(':checked');
                jsonPost.facilities.sportArea = false;
                jsonPost.facilities.partyRoom = false;
                jsonPost.facilities.sauna = false;
                jsonPost.facilities.internet = $('#internet').is(':checked');
                jsonPost.facilities.air = false;
                jsonPost.facilities.kitchenCabinet = $('#kitchenCabinet').is(':checked');
                jsonPost.facilities.hidromassage = $('#hidromassage').is(':checked');
                jsonPost.facilities.bedroomCloset = $('#bedroomCloset').is(':checked');
                jsonPost.facilities.bathroomCloset = false;
                jsonPost.facilities.bathBoxGlass = false;
                jsonPost.facilities.barbecue = false;
                jsonPost.facilities.gasShower = false;
                jsonPost.facilities.roofing = false;
                jsonPost.facilities.pool = false;
                jsonPost.facilities.terrace = $('#terrace').is(':checked');

                console.log('place = ' + JSON.stringify(jsonPost));

                $.ajax({
                    url: "findplaces-web/rest/place/",
                    data: 'place=' + JSON.stringify(jsonPost),
                    method: 'POST',
                    success: function (json) {
                        alert("Propriedade inserida com sucesso!");
                        $('#form_property').get(0).reset();
                        console.log(JSON.stringify(json));
                        return false;
                    },
                    error: function (json) {
                        alert("Erro ao inserir propriedade!");
                        $('#form_property').get(0).reset();
                        console.log(JSON.stringify(json));
                        return false;
                    }
                });
            }
        });
    });
});

//{'token':'CAACEdEose0cBAKdyGHLNu3DCJtWbdDygQ1N8xpMn0NAnXFO7gyU8lZBQralkLwwZCMJU9gqjD9BsGR5pFqeqKj9tgk6UacP4ixrrIpNsxXI5VomT6FUKGeJQOMsbGKXzmJydkCpRMA29TGqgK1OqPUS9JBrmKsH7L9PtM7ZCHZBBBGG76oexEpdvtg5icLEHXdxA34UVswZDZD', 'socialid':"100000485880931", 'address': "rua do bosque",  'lat': "-22.913051",  'log': "-47.054745", 'city':{'name':'Monte Santo', 'region':{'alias':'MG'}}, 'street':{'name':'bla bla'}, 'country':{'name':'Brazil'}, 'neighborhood':{'name':'Centro'}, 'placetype':{'id':'1'}}        

//if($('#userID').val()==""){
//    $.openURLContent('#content', 'login', null); //FIXME
//} 
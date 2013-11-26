// Gráficos
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

// Salvar e Atualizar
var imgList = [];
var totalImg = $('#place-images img').length;
$.ajaxPost = function (url, data, successCallBackPost, errorCallBackPost) {
    $.ajax({
        url: url,
        data: data,
        method: 'POST',
        success: $.successCallBackPost,
        error: $.errorCallBackPost
    });
};

$.successCallBackPost = function (result) {
    //console.log('SUCESSO[PLACE]: ' + JSON.stringify(result));
    alert("Propriedade salva com sucesso!");
};

$.errorCallBackPost = function (result) {
    console.log('ERRO[PLACE]: ' + JSON.stringify(result));
    imgList = [];
    totalImg = 0;
    alert("Erro ao salvar propriedade!");
};

$.ajaxPostImg = function (url, data, successCallBackImg, errorCallBackImg) {
    $.ajax({
        url: url,
        data: data,
        method: 'POST',
        success: $.successCallBackImg,
        error: $.errorCallBackImg
    });
};

$.successCallBackImg = function (result) {
    //console.log('SUCESSO[IMAGE]: ' + JSON.stringify(result));
    if ($.IsNullOrEmpty(result.imageID, null) !== null) {
        imgList.push(result.imageID);
    }

    if (totalImg == imgList.length) {
        jsonPost.idImages = imgList;

        if (jsonPost.id === null) {
            $.ajaxPost('findplaces-web/rest/place/', 'place=' + JSON.stringify(jsonPost));
        } else {
            $.ajaxPost('findplaces-web/rest/place/' + jsonPost.id, 'place=' + JSON.stringify(jsonPost));
        }
    }
};

$.errorCallBackImg = function (result) {
    console.log('ERRO[IMAGE]: ' + JSON.stringify(result));
    imgList = [];
    totalImg = 0;
    alert("Erro ao salvar propriedade!");
};

$.ajaxGet = function (url, data, successCallBackPost, errorCallBackPost) {
    $.ajax({
        url: url,
        data: data,
        method: 'POST',
        success: $.successCallBackPost,
        error: $.errorCallBackPost
    });
};

$.successCallBackGet = function (result) {
    //console.log('SUCESSO[GET_PLACE]: ' + JSON.stringify(result));
    var places = result.places[0];

    //Anuncio
    $('#sellType').val(places.sellType[0]).trigger("change");
    $('#placetype').val(places.type.id).trigger("change");
    $('#address1').val(places.address);
    $('#cellphone').val(places.cellphone);
    $('#cellphone2').val(places.cellphone2);

    //Valores
    $('#price').val(places.price).maskMoney('mask').trigger("blur");
    $('#deposit').val(places.deposit).maskMoney('mask').trigger("blur");
    $('#rent').val(places.rent).maskMoney('mask').trigger("blur");
    $('#contract_time').val(places.contract_time).trigger("blur");
    $('#iptu').val(places.iptu).maskMoney('mask').trigger("blur");
    $('#condominiumPrice').val(places.condominiumPrice).maskMoney('mask').trigger("blur");
    $('#internetPrice').val(places.internet).maskMoney('mask').trigger("blur");
    $('#tv').val(places.tv).maskMoney('mask').trigger("blur");

    //Detalhes
    $('#qtdPlaceFloor').val(places.qtdPlaceFloor);
    $('#placeFloor').val(places.placeFloor);
    $('#m2').val(places.m2);
    $('#bedroom').val(places.bedroom);
    $('#suite').val(places.suite);
    $('#room').val(places.room);
    $('#bathroom').val(places.bathroom);
    $('#garage').val(places.garage);

    //Informações
    $('#description').val(places.description);

    //Comodidades
    $('#internet').prop('checked', places.facilities.internet);
    $('#gatekeeper').prop('checked', places.facilities.gatekeeper);
    $('#bedroomCloset').prop('checked', places.facilities.bedroomCloset);
    $('#townBarbecue').prop('checked', places.facilities.townBarbecue);
    $('#kitchenCabinet').prop('checked', places.facilities.kitchenCabinet);
    $('#gasTubing').prop('checked', places.facilities.gasTubing);
    $('#hidromassage').prop('checked', places.facilities.hidromassage);
    $('#townPool').prop('checked', places.facilities.townPool);
    $('#terrace').prop('checked', places.facilities.terrace);
    $('#automaticDoor').prop('checked', places.facilities.automaticDoor);

    //Hidden
    $('#lat').val(places.lat);
    $('#lng').val(places.lng);

    // Mostra as abas e atualiza os gráficos
    $('#tabs-2-title').show();
    $('#tabs-3-title').show();
    $.placeChart();
    $.neighborhoodChart();
    $.ageOfUsersChart();
    $.placeQuestions();

    //var idImages = ['1_1.jpg', '1_2.jpg', '1_3.jpg', '1_4.jpg'];

    //$(idImages).each(function (i, img) {
    //    $.ajaxGetImg($.StringFormat('http://www.findplaces.com.br/findplaces-web/rest/images/{0}', img), null);
    //});
};

$.errorCallBackGet = function (result) {
    console.log('ERRO[EDIT]: ' + JSON.stringify(result));
    alert("Erro ao carregar propriedade!");
};

$.ajaxGetImg = function (url, data, successCallBackGetImg, errorCallBackGetImg) {
    $.ajax({
        url: url,
        data: data,
        method: 'GET',
        success: $.successCallBackGetImg,
        error: $.errorCallBackGetImg
    });
};

$.successCallBackGetImg = function (result) {
    console.log('SUCESSO[IMAGE]: ' + JSON.stringify(result));
};

$.errorCallBackGetImg = function (result) {
    console.log('ERRO[IMAGE]: ' + JSON.stringify(result));
};

$(document).ready(function () {
    // Autocomplete google places
    $.searchPlace('address1');

    // Verifica se é uma edição, adicionar aqui validação imóvel x id_usuario
    var id = $.getUrlParam('id', location.href);
    if ($.IsNullOrEmpty(id, null) !== null) {
        $.ajaxGet("findplaces-web/rest/place/" + id, { "socialid": "100001401841332" });
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
    $("#condominiumPrice").maskMoney({ symbol: "R$ ", thousands: ".", precision: 0, allowNegative: false });
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

    $('#cellphone').focusout(function () {
        var phone, element;
        element = $(this);
        element.unmask();
        phone = element.val().replace(/\D/g, '');
        if (phone.length > 10) {
            element.mask("(99) 99999-999?9");
        } else {
            element.mask("(99) 9999-9999?9");
        }
    }).trigger('focusout');

    $('#cellphone2').focusout(function () {
        var phone, element;
        element = $(this);
        element.unmask();
        phone = element.val().replace(/\D/g, '');
        if (phone.length > 10) {
            element.mask("(99) 99999-999?9");
        } else {
            element.mask("(99) 9999-9999?9");
        }
    }).trigger('focusout');

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
                $.showFields([$('#deposit').parent(), $('#rent').parent(), $('#contract_time').parent(), $('#iptu').parent(), $('#condominiumPrice').parent(), $('#internetPrice').parent(), $('#tv').parent(), $('#totalPrice').parent()], null, '#values-details > .msg_fieldset');
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
            var imageExt = $(this).val().split('.')[1];
            var imageSize = this.files[0].size;

            if ($('#img_' + imageName).length === 0 && imageSize < 1000000) {
                reader.onload = function (e) {
                    $('#div_link_photo').before($.StringFormat('<img alt="Clique para remover" src="{0}" class="img_upload" id="img_{1}" onclick="{2}" title="Clique para remover" ext="{3}">', e.target.result, imageName, '$(this).remove();', imageExt));
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
                // adtype: 'required',
                // placetype: 'required',
                // address1: 'required',
                // phone1: 'required',
                // price: 'required',
                // rent: 'required'
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
                jsonPost.condominiumPrice = $.IsNullOrEmpty(jsonForm.condominiumPrice.replace('.', ''), null);
                jsonPost.description = jsonForm.description;
                jsonPost.garage = parseInt(jsonForm.garage);
                jsonPost.m2 = parseInt(jsonForm.m2);
                jsonPost.price = $.IsNullOrEmpty(jsonForm.price.replace('.', ''), null);
                jsonPost.deposit = $.IsNullOrEmpty(jsonForm.deposit.replace('.', ''), null);
                jsonPost.rent = $.IsNullOrEmpty(jsonForm.rent.replace('.', ''), null);
                jsonPost.contract_time = $.IsNullOrEmpty(jsonForm.contract_time, null);
                jsonPost.iptu = $.IsNullOrEmpty(jsonForm.iptu.replace('.', ''), null);
                jsonPost.internet = $.IsNullOrEmpty(jsonForm.internetPrice.replace('.', ''), null);
                jsonPost.tv = $.IsNullOrEmpty(jsonForm.tv.replace('.', ''), null);
                jsonPost.room = parseInt(jsonForm.room);
                jsonPost.suite = parseInt(jsonForm.suite);
                jsonPost.placeFloor = parseInt(jsonForm.placeFloor);
                jsonPost.qtdPlaceFloor = parseInt(jsonForm.qtdPlaceFloor);
                jsonPost.totalPrice = jsonForm.totalPrice;
                jsonPost.cellphone = jsonForm.cellphone;
                jsonPost.cellphone2 = jsonForm.cellphone2;
                jsonPost.socialid = '100001401841332';
                jsonPost.token = 'CAACEdEose0cBAB9ZCueng6dBpGlbXAZC0olGrw7Y8yuKUZCu3gcXb8giJye49WM8JcJ22y53Ne0kZAzJQQCQEY6hZC2AKA5DNqF7vCUIHHXRLqgRAYLcFRzaB0PLn6D6UCUXq7NOkZCpDExe3mZC0c7nz0ZAPrifNybb8sMeUInErcVJTJ1xXYCLQUisy7Tre58ZD';
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

                if ($('#place-images img').length > 0) {
                    $('#place-images img').each(function (i, img) {
                        var jsonImg = {};
                        jsonImg.userID = jsonPost.socialid;
                        jsonImg.token = jsonPost.token;
                        jsonImg.base64IMG = $(img).attr('src').split(',')[1];
                        jsonImg.format = $(img).attr('ext');

                        $.ajaxPostImg('findplaces-web/rest/image/', 'image=' + JSON.stringify(jsonImg));
                    });
                } else {
                    if (jsonPost.id === null) {
                        $.ajaxPost('findplaces-web/rest/place/', 'place=' + JSON.stringify(jsonPost));
                    } else {
                        $.ajaxPost('findplaces-web/rest/place/' + jsonPost.id, 'place=' + JSON.stringify(jsonPost));
                    }
                }

                return false;
            }
        });
    });
});

//{'token':'CAACEdEose0cBAKdyGHLNu3DCJtWbdDygQ1N8xpMn0NAnXFO7gyU8lZBQralkLwwZCMJU9gqjD9BsGR5pFqeqKj9tgk6UacP4ixrrIpNsxXI5VomT6FUKGeJQOMsbGKXzmJydkCpRMA29TGqgK1OqPUS9JBrmKsH7L9PtM7ZCHZBBBGG76oexEpdvtg5icLEHXdxA34UVswZDZD', 'socialid':"100000485880931", 'address': "rua do bosque",  'lat': "-22.913051",  'log': "-47.054745", 'city':{'name':'Monte Santo', 'region':{'alias':'MG'}}, 'street':{'name':'bla bla'}, 'country':{'name':'Brazil'}, 'neighborhood':{'name':'Centro'}, 'placetype':{'id':'1'}}        

//if($('#userID').val()==""){
//    $.openURLContent('#content', 'login', null); //FIXME
//} 
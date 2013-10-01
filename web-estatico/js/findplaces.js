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

    var map = L.map('map').setView([lat, lng], 15);

        L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
            attribution: '&copy; Findplaces.com.br | &copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
       }).addTo(map);

    /*$('#map > div').remove();

    var map = new OpenLayers.Map("map");
    var layer = new OpenLayers.Layer.OSM("Simple OSM Map");
    var vector = new OpenLayers.Layer.Vector('vector');
    var controls = map.getControlsByClass('OpenLayers.Control.Navigation');

    for (var i = 0; i < controls.length; ++i)
        controls[i].disableZoomWheel();

    map.addLayers([layer, vector]);

    map.setCenter(
        new OpenLayers.LonLat(lng, lat).transform(
            new OpenLayers.Projection("EPSG:4326"),
            map.getProjectionObject()
        ), 15
    );*/
};

$.openURLContent = function (target, anchor) {
    $(target).load($.StringFormat('_{0}.html', anchor));
    return false;
};
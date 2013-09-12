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
    $('#map > div').remove();

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
    );
};
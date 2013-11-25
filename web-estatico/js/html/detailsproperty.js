$(document).ready(function () {
	json = {}    
	json.place_type = 2
	json.address = 'Rua Aguapé, 392, Pq. Universitário de Viracopos, Campinas, São Paulo, Republica Federavita do Brasil'
	json.images = ['']
	$('#top-title').append((json.place_type === 1 ? 'Apartamento • ' : 'Casa • ') + json.address.substring(0, 30) + '...');
});
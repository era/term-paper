package br.com.findplaces.ejb;

import java.io.Serializable;

import br.com.findplaces.model.to.PhotoTO;

public interface ImageConfigurations extends Serializable {
	
	PhotoTO findPhotoById(Long id);
	
	PhotoTO savePhoto(PhotoTO photoTO);
	
	PhotoTO deletePhoto(Long id);
	

}

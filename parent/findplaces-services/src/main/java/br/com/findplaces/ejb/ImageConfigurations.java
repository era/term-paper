package br.com.findplaces.ejb;

import java.io.Serializable;

import br.com.findplaces.model.to.PhotoTO;

public interface ImageConfigurations extends Serializable {
	
	PhotoTO findPhotoById(Long id);
	
	void deletePhoto(Long id);  //TODO Refact to throw exception

	PhotoTO savePhoto(PhotoTO photoTO, String type);
	

}

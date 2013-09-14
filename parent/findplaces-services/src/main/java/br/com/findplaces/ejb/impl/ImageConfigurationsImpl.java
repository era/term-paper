package br.com.findplaces.ejb.impl;

import java.io.Serializable;

import javax.ejb.EJB;

import org.apache.log4j.Logger;

import br.com.findplaces.ejb.ImageConfigurations;
import br.com.findplaces.jpa.dao.interfaces.ImageDAO;
import br.com.findplaces.jpa.entity.Image;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.to.PhotoTO;
import br.com.findplaces.util.ConverterTO;

public class ImageConfigurationsImpl implements ImageConfigurations,
		Serializable {
	
	@EJB
	private ImageDAO imageDAO;

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(ImageConfigurationsImpl.class);

	@Override
	public PhotoTO findPhotoById(Long id) {
		try {
			Image image = imageDAO.findById(id);
			
			return ConverterTO.converter(image);
			
		} catch (DAOException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public PhotoTO savePhoto(PhotoTO photoTO) {
		
		Image image = ConverterTO.converter(photoTO);
		try {
			Long create = imageDAO.create(image);
			
			return ConverterTO.converter(imageDAO.findById(create));
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		return null;
	}

	@Override
	public PhotoTO deletePhoto(Long id) {
		try {
			imageDAO.delete(id);
		} catch (DAOException e) {
			logger.error(e);
		}
		return null;
	}

}

package br.com.findplaces.ejb.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import br.com.findplaces.commons.constants.Constants;
import br.com.findplaces.ejb.ImageConfigurations;
import br.com.findplaces.jpa.dao.interfaces.ImageDAO;
import br.com.findplaces.jpa.entity.Image;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.to.PhotoTO;
import br.com.findplaces.util.ConverterTO;

@Stateless(name = "ImagemConfigurationsImpl", mappedName = "ImageConfigurations")
@Remote(ImageConfigurations.class)
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
			return null; //TODO Refact to throw exception
		}
	}

	@Override
	public PhotoTO savePhoto(PhotoTO photoTO, String type) {
		
		Image image = ConverterTO.converter(photoTO);
		try {
			
			String newFileName = Constants.getInstance().pathToImageFolder()
					+ new Date().toString() + String.valueOf(Math.random())+"."+type;
			
			saveImageOnDisk(photoTO, newFileName); //TODO If something happen here, we must stop and throw exception
			
			image.setPath(newFileName);
			
			Long create = imageDAO.create(image);
			
			
			
			return ConverterTO.converter(imageDAO.findById(create));
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		return null; //TODO Refact to throw exception
	}

	private void saveImageOnDisk(PhotoTO photoTO, String newFileName)
			throws IOException, FileNotFoundException {
		File file = new File( newFileName );
		
		file.createNewFile();
		
		byte[] base64Decoded;
		base64Decoded =  DatatypeConverter.parseBase64Binary(photoTO.getFile());
		FileOutputStream osf = new FileOutputStream(file);  
		osf.write(base64Decoded);  
		osf.flush();
		osf.close();
		
	}

	@Override
	public void deletePhoto(Long id) {
		try {
			imageDAO.delete(id);
		} catch (DAOException e) {
			logger.error(e);
		}
	}

}

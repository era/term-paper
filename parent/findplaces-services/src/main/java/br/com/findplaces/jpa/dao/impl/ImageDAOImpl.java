package br.com.findplaces.jpa.dao.impl;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.findplaces.jpa.dao.interfaces.ImageDAO;
import br.com.findplaces.jpa.entity.Image;

@Stateless
@Remote(ImageDAO.class)
public class ImageDAOImpl extends BaseDAOImpl<Image, Long> implements ImageDAO,
		Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="FindPlaces")
	private EntityManager em;
	
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	

}

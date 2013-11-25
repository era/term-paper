package br.com.findplaces.jpa.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.findplaces.jpa.dao.interfaces.PlaceDAO;
import br.com.findplaces.jpa.entity.Coment;
import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.entity.spatial.PlaceSpatial;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
@Remote(PlaceDAO.class)
public class PlaceDAOImpl extends BaseDAOImpl<Place, Long> implements PlaceDAO {

	private static final long serialVersionUID = -2569793427518741401L;

	@Resource
	@PersistenceContext(unitName = "FindPlaces")
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> findAll() {
		Query query = em.createQuery("SELECT p FROM Place p");
	    return (List<Place>) query.getResultList();
	}

	@Override
	public Place save(Coment coment) {
		em.merge(coment);
		return em.find(Place.class, coment.getPlace().getId());
	}

	@Override
	public Coment findComentById(Long id) {
		return em.find(Coment.class, id);
	}

	@Override
	public Place findBySpatial(PlaceSpatial spatial) {
		String sql = "SELECT * FROM tb_place p WHERE p.spatial_id = ?";
		Query query = getEntityManager().createNativeQuery(sql, Place.class);	
		query.setParameter(1, spatial.getId());
		List<Place> places = query.getResultList();
		if(places != null && places.isEmpty()){
			return null;
		} if(places == null){
			return null;
		}else{
			for(Place result: places){
				return result;
			}
		}
		return null;
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> findByUserID(Long id) {
		Query query = getEntityManager().createNamedQuery(Place.findBysellerID);
		query.setParameter("id", id);
		return query.getResultList();
	}


}

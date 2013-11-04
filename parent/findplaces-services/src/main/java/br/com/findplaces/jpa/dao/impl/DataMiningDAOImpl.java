package br.com.findplaces.jpa.dao.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.findplaces.jpa.dao.interfaces.DataMiningDAO;
import br.com.findplaces.jpa.entity.User;
import br.com.findplaces.jpa.entity.datamining.PlaceViewed;
import br.com.findplaces.jpa.entity.datamining.TestAB;

@Stateless
@Remote(DataMiningDAO.class)
public class DataMiningDAOImpl extends BaseDAOImpl<PlaceViewed, Long> implements
		DataMiningDAO {

	private static final long serialVersionUID = -3930350826588590793L;
	
	@PersistenceContext(unitName="FindPlaces")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<PlaceViewed> whoSawThisAlsoSaw(Long placeID, Long userID) {
		Query query = em.createNamedQuery(PlaceViewed.whoSawThisAlsoSaw);
		
		query.setParameter("userID", userID);
		query.setParameter("placeID", placeID);
		
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlaceViewed> findPlacesWithSameType(String type, Long userID) {
		Query query = em.createNamedQuery(PlaceViewed.findPlacesWithSameType);
		
		query.setParameter("userID", userID);
		query.setParameter("type", type);
		
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlaceViewed> findPlacesWithSameRelationship(User user) {
		
		Query query = em.createNamedQuery(PlaceViewed.findPlacesWithSameRelationship);
		
		query.setParameter("userID", user.getId());
		query.setParameter("relantionship", user.getRelationship());
		
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlaceViewed> findPlacesWithSameStudyAt(User user) {

		Query query = em.createNamedQuery(PlaceViewed.findPlacesWithSameStudyAt);
		
		query.setParameter("userID", user.getId());
		query.setParameter("studyAt", user.getStudyAt());
		
		
		return query.getResultList();
	}

	@Override
	public TestAB saveResultFromTest(TestAB test) {
		return  em.merge(test);
	}

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
	public List<PlaceViewed> getUsersFromPlace(Long placeID) {
		Query query = em.createNamedQuery(PlaceViewed.findViewsByPlace);
		query.setParameter("placeID", placeID);
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlaceViewed> getUsersFromNeighboord(String name) {
		Query query = em.createNamedQuery(PlaceViewed.findViewsByNeighborhood);
		query.setParameter("hoodname", name);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlaceViewed> findPlacesWithSameUserAge(User user) {
		Query query = em.createNamedQuery(PlaceViewed.findPlacesWithSameUserAge);
		query.setParameter("userID", user.getId());
		query.setParameter("age", user.getAge());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlaceViewed> findPlacesWithSameLikes(User user) {
		Query query = em.createNamedQuery(PlaceViewed.findPlacesWithSameUserAge);
		query.setParameter("userID", user.getId());
		return query.getResultList();
	}

}

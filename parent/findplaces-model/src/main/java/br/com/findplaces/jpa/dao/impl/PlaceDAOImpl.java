package br.com.findplaces.jpa.dao.impl;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import br.com.findplaces.jpa.dao.interfaces.PlaceDAO;
import br.com.findplaces.jpa.entity.BaseEntity;
import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.entity.PlaceType;
import br.com.findplaces.jpa.entity.geographic.City;
import br.com.findplaces.jpa.entity.geographic.Country;
import br.com.findplaces.jpa.entity.geographic.Neighborhood;
import br.com.findplaces.jpa.entity.geographic.Region;
import br.com.findplaces.jpa.entity.geographic.Street;
import br.com.findplaces.jpa.exception.DAOException;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
@Local(PlaceDAO.class)
public class PlaceDAOImpl extends BaseDAOImpl<Place, Long> implements PlaceDAO {

	private static final long serialVersionUID = -2569793427518741401L;

	@Resource
	@PersistenceUnit(unitName = "FindPlaces")
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
	public Long createPlace(Place entity) throws DAOException {
		try {

			Place entityTest = new Place();

			PlaceType type = new PlaceType();
			type.setId(1L);

			Country country = new Country();
			country.setId(1L);
			Region region = new Region();
			region.setId(1L);
			region.setCountry(country);
			City city = new City();
			city.setId(1L);
			city.setRegion(region);
			Neighborhood hood = new Neighborhood();
			hood.setId(1L);
			hood.setCity(city);
			Street street = new Street();
			street.setId(1L);
			street.setHood(hood);

			entityTest
					.setAddress("Rua Barão de Jaguará, 141, Campinas - São Paulo");
			entityTest.setCity(city);
			entityTest.setNeighborhood(hood);
			entityTest.setStreet(street);
			entityTest.setType(type);
			entityTest.setDescription("blablabla");
			this.getEntityManager().persist(entity);
			return (Long) ((BaseEntity) entity).getPrimaryKey();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}

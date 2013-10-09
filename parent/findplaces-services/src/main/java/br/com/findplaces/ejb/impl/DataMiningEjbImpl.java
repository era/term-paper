package br.com.findplaces.ejb.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.findplaces.ejb.DataMiningEJB;
import br.com.findplaces.jpa.dao.interfaces.DataMiningDAO;
import br.com.findplaces.jpa.entity.datamining.PlaceViewed;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.model.to.Viewed;

@Stateless(name = "DataMiningEJB", mappedName = "DataMining")
@Remote(DataMiningEJB.class)
public class DataMiningEjbImpl implements DataMiningEJB {
	
	private static final long serialVersionUID = 2910805335687356463L;
	
	@EJB
	private DataMiningDAO dao;
	

	@Override
	public PlaceTO sugestPlaceByUser(UserTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveResultFromTest(String algorithm, Integer liked, UserTO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void savePlaceViewed(PlaceViewed pv) {
		try {
			dao.save(pv);
		} catch (DAOException e) {
			//FIXME
		}
	}

	@Override
	public List<Viewed> getNeighboordViews(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Viewed> getPlaceViews(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

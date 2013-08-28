package br.com.findplaces.usermodule.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import br.com.findplaces.jpa.dao.impl.interfaces.ApartmentDAO;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.to.ApartmentTO;
import br.com.findplaces.usermodule.ejb.Apartment;
import br.com.findplaces.usermodule.exceptions.CouldNotFindAddressException;
import br.com.findplaces.usermodule.utils.ConverterTO;

@Stateless(name="ApartmentEJB", mappedName = "ApartmentImpl")
@Remote(Apartment.class)
public class ApartmentImpl implements Apartment{
	
	private static final long serialVersionUID = 647971073214946678L;
	
	private static final Logger logger = Logger.getLogger(ApartmentImpl.class);

	@EJB
	private ApartmentDAO apartmentDAO;
	
	

	@Override
	public ApartmentTO findAdressByString(String address) throws CouldNotFindAddressException {
		return new ApartmentTO();
	
	}

	@Override
	public ApartmentTO saveApartment(ApartmentTO apart) throws CouldNotFindAddressException {
		try {
			Long id = apartmentDAO.create(ConverterTO.converter(apart));
			return this.findApartmentById(id);
		} catch (DAOException e) {
			throw new CouldNotFindAddressException(e);
		}
		
	}

	private ApartmentTO findApartmentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

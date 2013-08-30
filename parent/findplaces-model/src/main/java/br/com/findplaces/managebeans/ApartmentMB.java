package br.com.findplaces.managebeans;

import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.findplaces.model.impl.Apartment;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@ManagedBean(name="ApartmentMB")
@RequestScoped
public class ApartmentMB {

    @Inject
    private Logger log;

    @Inject
    @PersistenceContext(name="FindPlaces")
    private EntityManager em;

    @Inject
    private Event<Apartment> memberEventSrc;

    public void register(Apartment apartment) throws Exception {
        log.info("Registering " + apartment.getName());
        em.persist(apartment);
        memberEventSrc.fire(apartment);
    }
}

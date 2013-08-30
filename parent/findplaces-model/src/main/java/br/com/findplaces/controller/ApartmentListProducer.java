package br.com.findplaces.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.findplaces.model.impl.Apartment;

@RequestScoped
public class ApartmentListProducer {

    @Inject
    private ApartmentRepository apartmentRepository;

    private List<Apartment> apartments;

    // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
    // Facelets or JSP view)
    @Produces
    @Named
    public List<Apartment> getMembers() {
        return apartments;
    }

    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Apartment member) {
        retrieveAllMembersOrderedByName();
    }

    @PostConstruct
    public void retrieveAllMembersOrderedByName() {
    	apartments = apartmentRepository.findAllOrderedByName();
    }
}

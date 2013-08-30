package br.com.findplaces.controller;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.findplaces.model.impl.Apartment;

@ApplicationScoped
public class ApartmentRepository {

    @Inject
    private EntityManager em;

    public Apartment findById(Long id) {
        return em.find(Apartment.class, id);
    }

    public Apartment findByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Apartment> criteria = cb.createQuery(Apartment.class);
        Root<Apartment> apartment = criteria.from(Apartment.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(apartment).where(cb.equal(apartment.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Apartment> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Apartment> criteria = cb.createQuery(Apartment.class);
        Root<Apartment> apartment = criteria.from(Apartment.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(apartment).orderBy(cb.asc(apartment.get("name")));
        return em.createQuery(criteria).getResultList();
    }
}

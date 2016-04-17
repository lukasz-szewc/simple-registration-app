package org.luksze;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class ApplicationUserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void persistWithinTransaction(Object o) {
        entityManager.persist(o);
    }

    @Transactional
    public ApplicationUser findById(Long id) {
        return entityManager.find(ApplicationUser.class, id);
    }
}

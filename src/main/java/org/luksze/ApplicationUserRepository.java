package org.luksze;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ApplicationUserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Object o) {
        entityManager.persist(o);
    }

    public ApplicationUser findById(Long id) {
        return entityManager.find(ApplicationUser.class, id);
    }
}

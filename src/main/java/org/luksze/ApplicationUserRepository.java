package org.luksze;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

    public boolean checkUserExist(UserName userName) {
        String query = "select u from ApplicationUser u where UPPER(u.name.name) = :name";
        TypedQuery<ApplicationUser> typedQuery = entityManager.createQuery(query, ApplicationUser.class);
        typedQuery.setParameter("name", userName.getName().toUpperCase());
        return !typedQuery.getResultList().isEmpty();
    }
}

package org.luksze;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class ApplicationUserTransactionalRepository {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Transactional
    public void persistWithinTransaction(ApplicationUser applicationUser) {
        applicationUserRepository.persist(applicationUser);
    }

    @Transactional
    public ApplicationUser findByIdInSeparateTransaction(Long id) {
        return applicationUserRepository.findById(id);
    }
}

package org.luksze

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [UserRegistrationApplication.class], loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
class PersistenceTest extends Specification {

    @Autowired
    private ApplicationUserTransactionalRepository repository

    def "application can persists users into database"() {
        given: "transient entity object"
        def user = new ApplicationUser("Thomas", "passwordA1")

        when: "object is saved"
        repository.persistWithinTransaction(user)

        then: "object is present in database"
        def retrievedUser = repository.findByIdInSeparateTransaction(user.id)
        retrievedUser.equals(user)
    }

    def "application will prevent to add second user with the same name."() {
        given: "user Chris already in the database"
        userAlreadyPersistedInTheDatabase()

        when: "new user with the same name is saved"
        repository.persistWithinTransaction(new ApplicationUser("Chris", "passwordA1"))

        then: "operation is not successful"
        def throwable = thrown(DataIntegrityViolationException)

    }

    private userAlreadyPersistedInTheDatabase() {
        repository.persistWithinTransaction(new ApplicationUser("Chris", "passwordA1"))
    }
}

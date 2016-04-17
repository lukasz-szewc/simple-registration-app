package org.luksze

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [SimpleSpringApp.class], loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
class PersistenceTest extends Specification {

    @Autowired
    private TransactionalRepository repository

    def "application can perists objects into database"() {
        given: "transient entity object"
        def user = new ApplicationUser("Chris", "password")

        when: "object is saved"
        repository.persistWithinTransaction(user)

        then: "object is present in database"
        def retrievedUser = repository.findByIdInSeparateTransaction(user.id)
        retrievedUser.equals(user)
    }
}

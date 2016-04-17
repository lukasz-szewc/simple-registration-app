package org.luksze

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator

class UserNameTest extends Specification {
    private Validator validator;

    void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Unroll
    def "verify that userName: '#username.name' is allowed in application"() {
        expect:
        validator.validate(username).size() == expectedViolations

        where:
        username                   | expectedViolations
        new UserName("Chris")      | 0
        new UserName("Peter")      | 0
        new UserName("Jack1")      | 0
        new UserName("12345")      | 0
    }

    @Unroll
    def "verify that username: '#username.name' does not meet criteria because #reason"() {
        expect:
        !validator.validate(username).isEmpty()

        where:
        username                       | reason
        new UserName(null)             | "it is null"
        new UserName("Abcd")           | "it is too short"
        new UserName("peter&")         | "contains not alpha numeric character"
        new UserName("pet er")         | "contains space"
    }

}

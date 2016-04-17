package org.luksze

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator

class PasswordPatternTest extends Specification {
    private Validator validator;

    void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Unroll
    def "verify that password: '#password.password' is allowed in application"() {
        expect:
        validator.validate(password).size() == expectedViolations

        where:
        password                       | expectedViolations
        new Password("Passwor1")       | 0
        new Password("Password1")      | 0
        new Password("VeryLongPass32") | 0
    }

    @Unroll
    def "verify that password: '#password.password' does not meet criteria because #reason"() {
        expect:
        !validator.validate(password).isEmpty()

        where:
        password                       | reason
        new Password(null)             | "it is null"
        new Password("Ab1")            | "it is too short"
        new Password("password1")      | "it does not contain uppercase character"
        new Password("PASSWORD1")      | "it does not contain lowercase character"
        new Password("Password")       | "it does not contain numeric character"
    }

}

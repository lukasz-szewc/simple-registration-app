package org.luksze

import spock.lang.Specification

class FirstTest extends Specification {

    def "test with java class"() {
        given:
        def object = new SimpleJavaObject()

        when:
        object.actionPerformed()

        then:
        object.operationIsSuccessful()
    }
}

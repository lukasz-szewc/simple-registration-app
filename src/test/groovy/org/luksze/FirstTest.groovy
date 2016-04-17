package org.luksze

import spock.lang.Specification

class First extends Specification {
    def "let's try this!"() {
        expect:
        Math.max(1, 2) == 2
    }

    def "second test"() {
        expect: 1 + 1 == 2
    }
}

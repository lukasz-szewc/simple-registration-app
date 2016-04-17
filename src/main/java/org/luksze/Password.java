package org.luksze;

import javax.persistence.Embeddable;

@Embeddable
public class Password {

    private String password;

    public Password(String password) {
        this.password = password;
    }

    @SuppressWarnings("unused")
    public Password() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password1 = (Password) o;
        return !(password != null ? !password.equals(password1.password) : password1.password != null);

    }

    @Override
    public int hashCode() {
        return password != null ? password.hashCode() : 0;
    }
}

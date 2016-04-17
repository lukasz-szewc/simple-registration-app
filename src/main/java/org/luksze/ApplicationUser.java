package org.luksze;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String password;

    public ApplicationUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @SuppressWarnings("unused")
    ApplicationUser() {}

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationUser that = (ApplicationUser) o;
        return name.equals(that.name) && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}

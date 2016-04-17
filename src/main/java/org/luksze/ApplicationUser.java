package org.luksze;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @NotNull
    @Valid
    private UserName name;

    @Embedded
    @NotNull
    @Valid
    private Password password;

    public ApplicationUser(String name, String password) {
        this.name = new UserName(name);
        this.password = new Password(password);
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

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(password != null ? !password.equals(that.password) : that.password != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public void setName(UserName name) {
        this.name = name;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public UserName getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }
}

package org.luksze;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Embeddable
public class Password {

    public static final String PASSWORD_REGEXP = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$";

    @NotNull
    @Size(min = 8)
    @Pattern(regexp= PASSWORD_REGEXP)
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

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Password{" +
                "password='" + password + '\'' +
                '}';
    }
}

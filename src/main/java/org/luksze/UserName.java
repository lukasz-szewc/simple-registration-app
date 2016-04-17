package org.luksze;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Embeddable
public class UserName {

    public static final String ALPHA_NUMERIC_PATTERN = "^[a-zA-Z0-9_]*$";

    @Column(unique=true)
    @NotNull
    @Pattern(regexp= ALPHA_NUMERIC_PATTERN)
    @Size(min = 5)
    private String name;

    public UserName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public UserName() {}

    @Override
    public String toString() {
        return "UserName{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return name.equals(userName.name);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

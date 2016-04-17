package org.luksze;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserName {

    @Column(unique=true)
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
        return name.hashCode();
    }
}

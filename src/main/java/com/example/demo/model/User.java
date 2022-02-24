package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Objects;
import static java.util.Objects.hash;


@Table(name = "users")
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "pass")
    private String pass;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User user = (User) obj;
        return
                (Objects.equals(getName(), user.getName())
                        || (getName() != null && getName().equals(user.getName())))
                        && (Objects.equals(getEmail(), user.getEmail())
                        || (getEmail() != null && getEmail().equals(user.getEmail())
                ));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = (prime * result + (hash(getName()) + hash(getEmail())));
        result = prime * result + ((getEmail() == null) ? 0 : (getEmail().hashCode() >>> 31));
        return result;
    }


}

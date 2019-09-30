package com.didispace.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public Long getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public Integer getAge () {
        return age;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setAge (Integer age) {
        this.age = age;
    }

    public void update(User user) {
        this.name = user.name;
        this.age = user.age;
    }
}

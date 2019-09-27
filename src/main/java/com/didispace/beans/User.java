package com.didispace.beans;

public class User {
    private Long id;
    private String name;
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

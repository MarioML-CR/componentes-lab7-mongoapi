package com.cenfotec.mongoapi.domian;

import org.springframework.data.annotation.Id;

public class Professional {
    @Id
    public String id;
    public String name;

    public Professional() {
    }

    public Professional(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Colleague{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

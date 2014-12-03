package com.volnoboy.jb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Reuven on 12/3/14.
 */
@Entity
public class User {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Integer id;
}

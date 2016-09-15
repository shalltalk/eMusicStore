package com.emusicstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zhy on 2016/9/11.
 * Used with Users.java to validate credentials
 */
@Entity
public class Authorities {

    @Id
    @GeneratedValue
    private int autoritiesId;
    private String username;
    private String authority;

    public int getAutoritiesId() {
        return autoritiesId;
    }

    public void setAutoritiesId(int autoritiesId) {
        this.autoritiesId = autoritiesId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

package com.groupproject.boomerang.model;

// Entity  if need Hibernate framework

/**
 * to do:
 * 1. password need md5 hash (copy from Twitch)
 * ( 2. may need hibernate)

 */

public class User {

    // private static final long serialVersionUID = 2681531852204068105L; // 这东西是 uuid

    private long id;
    private String password;  // need
    private String userName ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

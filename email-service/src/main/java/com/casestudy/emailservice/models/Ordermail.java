package com.casestudy.emailservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Ordermail {
    @Id
    private String id;
    @Field
    private String email;
    @Field
    private String message;
    @Field
    private Boolean read;

    public Ordermail() {
    }

    public Ordermail(String email, String message, Boolean read) {
        this.email = email;
        this.message = message;
        this.read = read;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return String.format("Ordermail[id='%s', email='%s',message='%s',read='%s']", id,email,message,read);
    }
}

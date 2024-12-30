package com.dto;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class CreateManejementAksesDTO {

    private String role_code;

    private String role_name;

    private String uri;
    
    // Getters and Setters

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}

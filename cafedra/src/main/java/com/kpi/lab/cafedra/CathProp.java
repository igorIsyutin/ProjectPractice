package com.kpi.lab.cafedra;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "my")
public class CathProp {
    private String message;
    private String allMessage;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAllMessage() {
        return allMessage;
    }

    public void setAllMessage(String allMessage) {
        this.allMessage = allMessage;
    }
}

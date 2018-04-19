package com.kpi.lab.faculty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "my")
public class FacultyProp {
    private String message;

    public String getPropety() {
        return message;
    }

    public void setPropety(String propety) {
        this.message = propety;
    }
}


package com.freelancer.Freelancerbe.model.entities;

import javax.persistence.*;

@Entity
public class Exposure {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "exposure")
    private String exposure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobLocation() {
        return exposure;
    }

    public void setJobLocation(String jobLocation) {
        this.exposure = jobLocation;
    }
}
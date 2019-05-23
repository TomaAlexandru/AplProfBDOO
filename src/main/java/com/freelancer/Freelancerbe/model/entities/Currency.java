package com.freelancer.Freelancerbe.model.entities;

import org.hibernate.annotations.Type;
import javax.persistence.*;

@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    @Type(type="currency")
    private String currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

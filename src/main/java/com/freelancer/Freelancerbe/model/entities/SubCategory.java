package com.freelancer.Freelancerbe.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "required_skill",
        joinColumns = @JoinColumn(name = "id"),
        inverseJoinColumns = @JoinColumn(name = "subcategory_id")
    )
    private List<Job> requiredInJobs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Job> getRequiredInJobs() {
        return requiredInJobs;
    }

    public void setRequiredInJobs(List<Job> requiredInJobs) {
        this.requiredInJobs = requiredInJobs;
    }
}
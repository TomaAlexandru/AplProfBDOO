package com.freelancer.Freelancerbe.model.entities;

import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="create_date")
    @Type(type="timestamp")
    private Date createDate;

    @Column(name = "days_available")
    private Integer daysAvailable;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "payment_method", length = 1)
    private Character paymentMethod;

    @Column(name = "estimated_budget_currency")
    private Integer estimatedBudgetCurrency;

    @Column(name = "estimated_budget")
    private Integer estimatedBudget;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_location", nullable = false)
    private JobLocation specificLocationJob;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exposure", nullable = false)
    private Exposure exposure;

    @Column(name="startDate")
    @Type(type="timestamp")
    private Date startDate;

    @Column(name="duration")
    private Integer duration;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "invited_freelancer",
        joinColumns = @JoinColumn(name = "id"),
        inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private List<User> invitedFreelancer;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "required_skill",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private List<SubCategory> requiredSkill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Integer daysAvailable) {
        this.daysAvailable = daysAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Character paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getEstimatedBudgetCurrency() {
        return estimatedBudgetCurrency;
    }

    public void setEstimatedBudgetCurrency(Integer estimatedBudgetCurrency) {
        this.estimatedBudgetCurrency = estimatedBudgetCurrency;
    }

    public Integer getEstimatedBudget() {
        return estimatedBudget;
    }

    public void setEstimatedBudget(Integer estimatedBudget) {
        this.estimatedBudget = estimatedBudget;
    }

    public JobLocation getSpecificLocationJob() {
        return specificLocationJob;
    }

    public void setSpecificLocationJob(JobLocation specificLocationJob) {
        this.specificLocationJob = specificLocationJob;
    }

    public Exposure getExposure() {
        return exposure;
    }

    public void setExposure(Exposure exposure) {
        this.exposure = exposure;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<User> getInvitedFreelancer() {
        return invitedFreelancer;
    }

    public void setInvitedFreelancer(List<User> invitedFreelancer) {
        this.invitedFreelancer = invitedFreelancer;
    }

    public List<SubCategory> getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(List<SubCategory> requiredSkill) {
        this.requiredSkill = requiredSkill;
    }
}
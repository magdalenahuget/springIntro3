package com.company.bezkoderonetoone.model;

import jakarta.persistence.*;

import java.util.Date;

//The TutorialDetails class has the @OneToOne annotation for one-to-one relationship
// with the Tutorial entity and @MapsId annotation that makes the id field serve
// as both Primary Key and Foreign Key (shared primary key).
// We set the shared primary key column name by using @JoinColumn annotation.

@Entity
@Table(name = "tutorial_details")
public class TutorialDetails {

    @Id
    private Long id;

    @Column
    private Date createdOn;

    @Column
    private String createdBy;

    @OneToOne(fetch= FetchType.LAZY)
    @MapsId
    @JoinColumn(name ="tutorial_id")
    private Tutorial tutorial;

    public TutorialDetails() {
    }

    public TutorialDetails(String createdBy) {
        this.createdOn = new Date();
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }

    public Tutorial getTutorial() {
        return tutorial;
    }
}

package it.tafaq.springboot.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "job_seeker_profile")
    private JobSeekerProfile jobSeekerProfile;

    @Size(max = 255)
    @Column(name = "experience_level")
    private String experienceLevel;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Size(max = 255)
    @Column(name = "years_of_experience")
    private String yearsOfExperience;

    public Skills() {
    }

    public Skills(Integer id, JobSeekerProfile jobSeekerProfile, String experienceLevel, String name, String yearsOfExperience) {
        this.id = id;
        this.jobSeekerProfile = jobSeekerProfile;
        this.experienceLevel = experienceLevel;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", jobSeekerProfile=" + jobSeekerProfile +
                ", experienceLevel='" + experienceLevel + '\'' +
                ", name='" + name + '\'' +
                ", yearsOfExperience='" + yearsOfExperience + '\'' +
                '}';
    }
}
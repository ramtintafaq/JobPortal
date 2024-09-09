package it.tafaq.springboot.jobportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "job_seeker_save" , uniqueConstraints = @UniqueConstraint(columnNames = {"userId" , "job"}))
public class JobSeekerSave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "userId" , referencedColumnName = "user_account_id")
    private JobSeekerProfile userId;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "job" , referencedColumnName = "jobPostId")
    private JobPostActivity job;

    public JobSeekerSave() {
    }

    public JobSeekerSave(Integer id, JobSeekerProfile userId, JobPostActivity job) {
        this.id = id;
        this.userId = userId;
        this.job = job;
    }



    public JobPostActivity getJob() {
        return job;
    }

    public void setJob(JobPostActivity job) {
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JobSeekerProfile getUserId() {
        return userId;
    }

    public void setUserId(JobSeekerProfile user) {
        this.userId = user;
    }


    @Override
    public String toString() {
        return "JobSeekerSave{" +
                "id=" + id +
                ", userId=" + userId +
                ", job=" + job +
                '}';
    }
}
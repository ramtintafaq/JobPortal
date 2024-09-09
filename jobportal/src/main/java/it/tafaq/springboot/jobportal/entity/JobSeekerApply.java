package it.tafaq.springboot.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "job_seeker_apply" , uniqueConstraints = {@UniqueConstraint(columnNames = {"userId" , "job"})})
public class JobSeekerApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "userId" , referencedColumnName = "user_account_id")
    private JobSeekerProfile userId;

    @Column(name = "apply_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date applyDate;

    @Size(max = 255)
    @Column(name = "cover_letter")
    private String coverLetter;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "job" , referencedColumnName = "jobPostId")
    private JobPostActivity job;

    public JobSeekerApply() {
    }

    public JobSeekerApply(Integer id, JobSeekerProfile userId, Date applyDate, String coverLetter, JobPostActivity job) {
        this.id = id;
        this.userId = userId;
        this.applyDate = applyDate;
        this.coverLetter = coverLetter;
        this.job = job;
    }



    public JobPostActivity getJob() {
        return job;
    }

    public void setJob(JobPostActivity job) {
        this.job = job;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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
        return "JobSeekerApply{" +
                "id=" + id +
                ", userId=" + userId +
                ", applyDate=" + applyDate +
                ", coverLetter='" + coverLetter + '\'' +
                ", job=" + job +
                '}';
    }
}
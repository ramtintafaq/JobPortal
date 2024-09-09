package it.tafaq.springboot.jobportal.repository;

import it.tafaq.springboot.jobportal.entity.JobPostActivity;
import it.tafaq.springboot.jobportal.entity.JobSeekerApply;
import it.tafaq.springboot.jobportal.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply , Integer> {

    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);

    List<JobSeekerApply> findByJob(JobPostActivity job);



}

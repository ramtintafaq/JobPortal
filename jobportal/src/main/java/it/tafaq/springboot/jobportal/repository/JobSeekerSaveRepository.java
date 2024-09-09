package it.tafaq.springboot.jobportal.repository;

import it.tafaq.springboot.jobportal.entity.JobPostActivity;
import it.tafaq.springboot.jobportal.entity.JobSeekerProfile;
import it.tafaq.springboot.jobportal.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave , Integer> {

    List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);

}

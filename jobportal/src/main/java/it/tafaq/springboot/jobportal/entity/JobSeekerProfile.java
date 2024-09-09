package it.tafaq.springboot.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "job_seeker_profile")
public class JobSeekerProfile {

    @Id
    @Column(name = "user_account_id", nullable = false)
    private Integer userAccountId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false)
    private Users userId;

    @Size(max = 255)
    @Column(name = "city")
    private String city;

    @Size(max = 255)
    @Column(name = "country")
    private String country;

    @Size(max = 255)
    @Column(name = "employment_type")
    private String employmentType;

    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;

    @Size(max = 255)
    @Column(name = "profile_photo")
    private String profilePhoto;

    @Size(max = 255)
    @Column(name = "resume")
    private String resume;

    @Size(max = 255)
    @Column(name = "state")
    private String state;

    @Size(max = 255)
    @Column(name = "work_authorization")
    private String workAuthorization;

    @OneToMany(mappedBy = "userId")
    private Set<JobSeekerApply> jobSeekerApplies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userId")
    private Set<JobSeekerSave> jobSeekerSaves = new LinkedHashSet<>();

    @OneToMany(mappedBy = "jobSeekerProfile"  , cascade = CascadeType.ALL)
    private List<Skills> skills = new ArrayList<>();

    public JobSeekerProfile() {
    }

    public JobSeekerProfile(Users userId) {
        this.userId = userId;
    }

    public JobSeekerProfile(Integer userAccountId, Users userId, String city, String country, String employmentType, String firstName, String lastName, String profilePhoto, String resume, String state, String workAuthorization, Set<JobSeekerApply> jobSeekerApplies, Set<JobSeekerSave> jobSeekerSaves, List<Skills> skills) {
        this.userAccountId = userAccountId;
        this.userId = userId;
        this.city = city;
        this.country = country;
        this.employmentType = employmentType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePhoto = profilePhoto;
        this.resume = resume;
        this.state = state;
        this.workAuthorization = workAuthorization;
        this.jobSeekerApplies = jobSeekerApplies;
        this.jobSeekerSaves = jobSeekerSaves;
        this.skills = skills;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public Set<JobSeekerSave> getJobSeekerSaves() {
        return jobSeekerSaves;
    }

    public void setJobSeekerSaves(Set<JobSeekerSave> jobSeekerSaves) {
        this.jobSeekerSaves = jobSeekerSaves;
    }

    public Set<JobSeekerApply> getJobSeekerApplies() {
        return jobSeekerApplies;
    }

    public void setJobSeekerApplies(Set<JobSeekerApply> jobSeekerApplies) {
        this.jobSeekerApplies = jobSeekerApplies;
    }

    public String getWorkAuthorization() {
        return workAuthorization;
    }

    public void setWorkAuthorization(String workAuthorization) {
        this.workAuthorization = workAuthorization;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users users) {
        this.userId = users;
    }

    public Integer getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Integer id) {
        this.userAccountId = id;
    }

    public String getPhotosImagePath() {
        if (profilePhoto == null || userAccountId == null) {
            return null;
        }
        return "/photos/candidates/" + userAccountId + "/" + profilePhoto;
    }


    @Override
    public String toString() {
        return "JobSeekerProfile{" +
                "userAccountId=" + userAccountId +
                ", userId=" + userId +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", resume='" + resume + '\'' +
                ", state='" + state + '\'' +
                ", workAuthorization='" + workAuthorization + '\'' +
                ", jobSeekerApplies=" + jobSeekerApplies +
                ", jobSeekerSaves=" + jobSeekerSaves +
                '}';
    }
}

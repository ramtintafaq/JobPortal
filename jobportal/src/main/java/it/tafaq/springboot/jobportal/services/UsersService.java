package it.tafaq.springboot.jobportal.services;

import it.tafaq.springboot.jobportal.entity.JobSeekerProfile;
import it.tafaq.springboot.jobportal.entity.RecruiterProfile;
import it.tafaq.springboot.jobportal.entity.Users;
import it.tafaq.springboot.jobportal.repository.JobSeekerProfileRepository;
import it.tafaq.springboot.jobportal.repository.RecruiterProfileRepository;
import it.tafaq.springboot.jobportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersService(UsersRepository usersRepository , JobSeekerProfileRepository jobSeekerProfileRepository , RecruiterProfileRepository recruiterProfileRepository , PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users addNew(Users users) {
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Users savedusers = usersRepository.save(users);
        int userTypeId = users.getUserTypeId().getUserTypeId();
        if (userTypeId == 1){
            recruiterProfileRepository.save(new RecruiterProfile(savedusers));
        }
        else{
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedusers));
        }
        return savedusers;
    }


    public Object getCurrentUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            Users users = usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            int userId = users.getUserId();
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("Recruiter"))) {
                return recruiterProfileRepository.findById(userId).orElse(new RecruiterProfile());
            }
            else {
                return jobSeekerProfileRepository.findById(userId).orElse(new JobSeekerProfile());
            }
        }
        return null;
    }

    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public Users getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            return usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        }
        return null;
    }

    public Users findByEmail(String currentUsername) {
        return usersRepository.findByEmail(currentUsername).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}

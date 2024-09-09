# Spring Boot Job Portal Web Application

## Project Description
This project is a full-stack web application built using **Spring Boot** that serves as a job portal platform. The platform allows recruiters to post job opportunities and job seekers to apply for them. The project is built with a responsive UI and offers functionalities such as job searching, resume upload, and profile management for both recruiters and job seekers.

## Features

### Recruiter:
- Create and manage job postings.
- View job applications from job seekers.
- Manage recruiter profile.

### Job Seeker:
- Create and manage job seeker profiles with skills and experience.
- Upload resumes in PDF format.
- Search and apply for job opportunities.
- Save job postings for future applications.

### General:
- Job search functionality with filters based on job type, location, etc.
- REST API to download resumes.

## Technologies Used
- **Java 17**
- **Spring Boot 3.0**
- **Spring Data JPA**
- **Thymeleaf** for templating
- **MySQL** for database management
- **Spring Security** for authentication and role-based access control
- **Maven** for dependency management
- **Bootstrap** for responsive UI design
- **WebJars** for front-end libraries

## Installation and Setup

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/job-portal-web-app.git
    cd job-portal-web-app
    ```

2. **Configure the database**:
   - Edit the `src/main/resources/application.properties` file with your MySQL database credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/job_portal_db
     spring.datasource.username=yourUsername
     spring.datasource.password=yourPassword
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

4. **Access the application**:
   Open a browser and navigate to `http://localhost:8080`.

## Usage

### For Recruiters:
- Sign up as a recruiter.
- Create a recruiter profile and start posting job opportunities.
- Manage the posted jobs and view job seekers who have applied.

### For Job Seekers:
- Sign up as a job seeker.
- Create a job seeker profile, upload your resume, and manage skills.
- Browse available jobs, apply for jobs, or save them for later.

## Screenshots
Here are a few screenshots of the application:

1. **Recruiter Dashboard**:
   ![Recruiter Dashboard](screenshots/recruiter-dashboard.png)

2. **Job Seeker Profile**:
   ![Job Seeker Profile](screenshots/job-seeker-profile.png)

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contribution
Feel free to open an issue or submit a pull request if you'd like to contribute to this project.

## Contact
For any questions or feedback, please contact [your-email@example.com].

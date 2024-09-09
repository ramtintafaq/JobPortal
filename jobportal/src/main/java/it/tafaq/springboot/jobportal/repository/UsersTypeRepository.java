package it.tafaq.springboot.jobportal.repository;

import it.tafaq.springboot.jobportal.entity.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersTypeRepository extends JpaRepository<UsersType, Integer> {
}

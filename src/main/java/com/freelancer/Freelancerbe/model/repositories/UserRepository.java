package com.freelancer.Freelancerbe.model.repositories;

import com.freelancer.Freelancerbe.model.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findFirstById(Long id);
    User findFirstByEmail(String email);
}
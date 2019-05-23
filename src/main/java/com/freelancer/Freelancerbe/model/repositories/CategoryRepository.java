package com.freelancer.Freelancerbe.model.repositories;

import com.freelancer.Freelancerbe.model.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
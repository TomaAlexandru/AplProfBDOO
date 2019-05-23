package com.freelancer.Freelancerbe.model.repositories;


import com.freelancer.Freelancerbe.model.entities.SubCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {
    List<SubCategory> findAllByIdGreaterThan(long subcategoryId);
}
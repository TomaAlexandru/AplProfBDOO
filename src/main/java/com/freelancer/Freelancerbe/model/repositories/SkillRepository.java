package com.freelancer.Freelancerbe.model.repositories;

import com.freelancer.Freelancerbe.model.entities.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {
}
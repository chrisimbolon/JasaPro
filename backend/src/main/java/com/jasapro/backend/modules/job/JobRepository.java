package com.jasapro.backend.modules.job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByStatus(JobStatus status);

    List<Job> findByServiceCategoryIdAndStatus(Long serviceCategoryId, JobStatus status);
}

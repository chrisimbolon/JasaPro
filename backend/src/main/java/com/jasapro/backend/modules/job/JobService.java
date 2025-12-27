package com.jasapro.backend.modules.job;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jasapro.backend.exception.ResourceNotFoundException;
import com.jasapro.backend.modules.job.dto.JobRequest;
import com.jasapro.backend.modules.job.dto.JobResponse;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Transactional
    public JobResponse createJob(JobRequest request) {
        Job job = new Job(
                request.getUserId(),
                request.getServiceCategoryId(),
                request.getTitle(),
                request.getDescription(),
                request.getLocation(),
                request.getBudget(),
                request.getScheduledAt());

        Job saved = jobRepository.save(job);
        return mapToResponse(saved);
    }

    @Transactional(readOnly = true)
    public JobResponse getJobById(Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));
        return mapToResponse(job);
    }

    @Transactional(readOnly = true)
    public List<JobResponse> listOpenJobs(Long serviceCategoryId) {
        List<Job> jobs;

        if (serviceCategoryId != null) {
            jobs = jobRepository.findByServiceCategoryIdAndStatus(serviceCategoryId, JobStatus.OPEN);
        } else {
            jobs = jobRepository.findByStatus(JobStatus.OPEN);
        }

        return jobs.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private JobResponse mapToResponse(Job job) {
        return new JobResponse(
                job.getId(),
                job.getUserId(),
                job.getServiceCategoryId(),
                job.getTitle(),
                job.getDescription(),
                job.getLocation(),
                job.getBudget(),
                job.getStatus(),
                job.getScheduledAt(),
                job.getCreatedAt());
    }
}

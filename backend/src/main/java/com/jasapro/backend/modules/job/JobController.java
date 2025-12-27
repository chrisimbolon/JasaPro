package com.jasapro.backend.modules.job;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jasapro.backend.common.ApiResponse;
import com.jasapro.backend.modules.job.dto.JobRequest;
import com.jasapro.backend.modules.job.dto.JobResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ApiResponse<JobResponse> createJob(@Valid @RequestBody JobRequest request) {
        JobResponse response = jobService.createJob(request);
        return ApiResponse.success("Job created successfully", response);
    }

    @GetMapping("/{id}")
    public ApiResponse<JobResponse> getJobById(@PathVariable Long id) {
        JobResponse response = jobService.getJobById(id);
        return ApiResponse.success("Success", response);
    }

    @GetMapping
    public ApiResponse<List<JobResponse>> listOpenJobs(
            @RequestParam(name = "serviceCategoryId", required = false) Long serviceCategoryId) {
        List<JobResponse> jobs = jobService.listOpenJobs(serviceCategoryId);
        return ApiResponse.success("Success", jobs);
    }
}

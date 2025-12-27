package com.jasapro.backend.modules.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jasapro.backend.common.ApiResponse;
import com.jasapro.backend.modules.provider.dto.ProviderRequest;
import com.jasapro.backend.modules.provider.dto.ProviderResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/providers")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping("/register")
    public ApiResponse<ProviderResponse> registerProvider(@Valid @RequestBody ProviderRequest request) {
        ProviderResponse response = providerService.registerProvider(request);
        return ApiResponse.success("Provider registered successfully", response);
    }

    @GetMapping("/{id}")
    public ApiResponse<ProviderResponse> getProviderById(@PathVariable Long id) {
        ProviderResponse response = providerService.getProviderById(id);
        return ApiResponse.success("Success", response);
    }
}

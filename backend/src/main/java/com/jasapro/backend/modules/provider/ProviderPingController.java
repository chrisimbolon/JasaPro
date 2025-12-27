package com.jasapro.backend.modules.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderPingController {

    @GetMapping("/providers/ping")
    public String ping() {
        return "provider-ping";
    }
}

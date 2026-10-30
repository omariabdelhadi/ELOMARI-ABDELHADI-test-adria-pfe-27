package com.abdelhadielomari.transactionservice.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.UUID;
import java.util.Map;
@Component
@FeignClient(name = "account-service")
public interface AccountClient {
    @GetMapping("/api/accounts/{id}")
    Map<String, Object> getAccount(@PathVariable UUID id);
}

package com.nicolascruz.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nicolascruz.hrpayroll.entities.Worker;
//Interface para permitir a comunicação com o microsserviço de workers
@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

	@GetMapping("/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}

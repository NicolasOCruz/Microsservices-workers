package com.nicolascruz.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolascruz.hrworker.entities.Worker;
import com.nicolascruz.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
@RefreshScope
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment env; //informações do contexto da aplicação

	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping("/configs")
	public ResponseEntity<Void> testeConfigs(){
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		logger.info("PORT=" + env.getProperty("local.server.port"));
		Worker worker = workerRepository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
}

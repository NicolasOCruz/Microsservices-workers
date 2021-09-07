package com.nicolascruz.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolascruz.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}

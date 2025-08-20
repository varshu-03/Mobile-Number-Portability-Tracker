package com.mnptracker.trigger.repository;
import com.mnptracker.trigger.domain.APIRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APIRequestLogRepository extends JpaRepository<APIRequestLog, Long> { }


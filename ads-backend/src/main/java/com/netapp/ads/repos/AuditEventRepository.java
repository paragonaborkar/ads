package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.netapp.ads.models.AuditEvent;

public interface AuditEventRepository extends CrudRepository<AuditEvent, Long> {
	AuditEvent findByEventName(String eventName);
	List<AuditEvent> findByHttpMethodAndResourcePattern(String httpMethod, String resourcePattern);
}

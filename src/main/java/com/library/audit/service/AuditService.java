package com.library.audit.service;

import java.util.List;

import com.library.audit.domain.Audit;

public interface AuditService {
	public Audit getById(String id);
	
	public List<Audit> getList();
	
	public Audit create(String orderId, String userId, String transactionId, String creationDate);
}

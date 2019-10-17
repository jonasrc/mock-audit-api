package com.library.audit.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.library.audit.domain.Audit;
import com.library.audit.service.AuditService;

@Service
public class AuditServiceImpl implements AuditService{
	
	private List<Audit> auditList;

	@Override
	public Audit getById(String id) {
		Audit audit = auditList
				.stream()
				.filter(element -> element.getId().equals(id))
				.findAny()
				.orElse(null);
		
		if(audit == null) {
			throw new NoSuchElementException("Audit log not found.");
		}
		
		return audit;
	}

	@Override
	public List<Audit> getList() {
		return auditList;
	}

	@Override
	public Audit create(String orderId, String userId, String transactionId, String creationDate) {
		if(auditList == null) {
			auditList = new ArrayList<>();
		}
		
		Audit audit = new Audit(orderId, userId, transactionId, creationDate);
		auditList.add(audit);
		
		return audit;
	}
}

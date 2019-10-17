package com.library.audit.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.audit.domain.Audit;
import com.library.audit.service.AuditService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/audit/api/v1")
@Api(tags = "Auditoria de operações com transações via cartão de crédito")
public class AuditController {
	@Autowired
	private AuditService auditService;
	
	@PostMapping("/log")
	@ApiOperation(value = "Criar novo log de auditoria de transação com cartão de crédito")
	public ResponseEntity<Audit> logTransaction(
			@ApiParam(value = "ID do pedido de compra", required = true)
			@RequestBody String orderId,
			@ApiParam(value = "ID do comprador", required = true)
			@RequestBody String userId,
			@ApiParam(value = "ID da transação", required = true)
			@RequestBody String transactionId,
			@ApiParam(value = "Data de criação da transação", required = true)
			@RequestBody String creationDate){
		Audit transaction = auditService.create(
				orderId, 
				userId, 
				transactionId, 
				creationDate);
		return ResponseEntity.created(URI.create(transaction.getId())).body(transaction);
	}
	
	@GetMapping("/log")
	@ApiOperation(value = "Recuperar log de transações marcadas na auditoria")
	public ResponseEntity<List<Audit>> getList(){
		return ResponseEntity.ok().body(auditService.getList());
	}
}

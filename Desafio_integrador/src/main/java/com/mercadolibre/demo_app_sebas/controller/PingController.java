package com.mercadolibre.demo_app_sebas.controller;

import com.fury.api.exceptions.FuryDecryptException;
import com.fury.api.exceptions.FuryNotFoundAPPException;
import com.fury.api.exceptions.FuryUpdateException;
import com.mercadolibre.demo_app_sebas.config.ConnectionDB;
import com.mercadolibre.demo_app_sebas.dtos.NormalDataDTO;
import com.mercadolibre.demo_app_sebas.service.PingService;
import com.newrelic.api.agent.NewRelic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class PingController {

	private PingService pingService;

	public PingController(PingService pingService) {
		this.pingService = pingService;
	}

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}

	@PostMapping("/test")
	public ResponseEntity<NormalDataDTO> insertarYConsultar(@RequestBody NormalDataDTO insert){
		return ResponseEntity.ok(pingService.insertarYConsultar(insert));
	}

	@GetMapping("/{id}")
	public ResponseEntity<NormalDataDTO> consultar(@PathVariable Integer id){
		return ResponseEntity.ok(pingService.consultar(id));
	}
}

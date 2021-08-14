package com.padillatomas.tpfinal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/url/inicio")
public class ApiController {

	@GetMapping
	public ResponseEntity<String> mensaje(){
		String message = "<h1>Hola</h1>";
		return ResponseEntity.ok(message);
	}
}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResisterDto;
import com.example.demo.service.ContractorService;

@RestController
@RequestMapping("/contractor")
public class ContractorController {
   @Autowired
	private ContractorService contractorservice;

	@PostMapping("/resister")
	public ResponseEntity<String> resister(@RequestBody ResisterDto resisterdto)
	{
		return new ResponseEntity<>(contractorservice.resister(resisterdto),HttpStatus.OK);
	}
	
	@PutMapping("/verify-account")
	public ResponseEntity<String>verifyAccount(@RequestParam("email") String email,@RequestParam("otp") String otp) {
		return new ResponseEntity<String>(contractorservice.verifyAccount(email,otp),HttpStatus.OK);
	}
	
	@PutMapping("/regenerate-otp")
	public ResponseEntity<String> regenerateOtp(@RequestParam("email") String email)
	{
		return new ResponseEntity<>(contractorservice.regenerateOtp(email),HttpStatus.OK);
	}
	
	@PutMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDto logindto)
	{
		return new ResponseEntity<>(contractorservice.login(logindto),HttpStatus.OK);
	}
	
}

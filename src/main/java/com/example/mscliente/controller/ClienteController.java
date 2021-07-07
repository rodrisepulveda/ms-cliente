package com.example.mscliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mscliente.jsm.Producer;
import com.example.mscliente.to.DatoTo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/")
public class ClienteController {

	@Autowired
	private Producer producer;

	@GetMapping("operacion")
	private String operacion() {

		try {

			DatoTo datoTo = new DatoTo();

			datoTo.setDato1("El dato 1");
			datoTo.setDato2("El dato 2");

			producer.sendObjectMessage("colaBloqueos", new ObjectMapper().writeValueAsString(datoTo));

			return "ok";

		} catch (JsonProcessingException e) {
			return "failed";
		}

	}

}

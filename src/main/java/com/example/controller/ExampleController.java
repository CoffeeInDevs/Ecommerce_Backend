package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Example;
import com.example.service.ExampleService;

@RestController
@RequestMapping(path = "/example/")
// @CrossOrigin(origins = "*")
public class ExampleController {

	private final ExampleService exampleService;

	@Autowired
	public ExampleController(ExampleService exampleService) {
		this.exampleService = exampleService;
	}

	// GET
	// Por defecto, obtiene todolos elementos de la tabla
	// Return los elemento
	@GetMapping
	public List<Example> getExamples() {
		return exampleService.getExamples();
	}

	// Obtiene un elemento de la tabla por el id
	// Regresa
	@GetMapping(path = "{id}")
	public Example getExample(@PathVariable("id") Long id) {
		return exampleService.getExample(id);
	}

	// POST
	// Crea un elemento
	@PostMapping()
	public Example addExample(@RequestBody Example example) {
		return exampleService.addExample(example);
	}

	// PUT
	// Actualiza o crea un elemento
	@PutMapping(path = "{id}")
	Example updateExampleJSON(@RequestBody Example example, @PathVariable("id") Long id) {
		return exampleService.updateExample(example, id);
	}

	@PutMapping(path = "url/{id}")
	public void updateExampleURL(@PathVariable("id") Long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String info) {
		exampleService.updateExample(id, name, info);
	}

	// DELETE
	// Elimina un elemento de la tabla
	@DeleteMapping(path = "{id}")
	public void deleteExample(@PathVariable("id") Long id) {
		exampleService.deleteExample(id);
	}

}
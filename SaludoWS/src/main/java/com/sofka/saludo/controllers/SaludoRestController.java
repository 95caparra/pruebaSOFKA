package com.sofka.saludo.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.saludo.entity.Usuario;
import com.sofka.saludo.services.ISaludoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/saludo")
public class SaludoRestController {

	@Autowired
	private ISaludoService saludoService;

	@GetMapping("/espanol/{nombre}")
	public ResponseEntity<?> saludoEspanol(@PathVariable String nombre) {
		Map<String, Object> response = new HashMap<>();

		Usuario objeto = new Usuario();

		try {
			objeto = saludoService.findByNombre(nombre);
			if(objeto != null) {
				response.put("saludo", "Hola ".concat(objeto.getNombre().concat(" ").concat(objeto.getApellido())));
				response.put("detalles", objeto);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			} else {
				response.put("mensaje", "Error al realizar la consulta en la base de datos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		
	}

	@GetMapping("/ingles/{nombre}")
	public ResponseEntity<?> saludoIngles(@PathVariable String nombre) {
		Map<String, Object> response = new HashMap<>();
		Usuario objeto = new Usuario();

		try {
			objeto = saludoService.findByNombre(nombre);
			if(objeto != null) {
				response.put("saludo", "Hello ".concat(objeto.getNombre().concat(" ").concat(objeto.getApellido())));
				response.put("detalles", objeto);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			} else {
				response.put("mensaje", "Error al realizar la consulta en la base de datos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	@GetMapping("/frances/{nombre}")
	public ResponseEntity<?> saludoFrances(@PathVariable String nombre) {
		Map<String, Object> response = new HashMap<>();
		Usuario objeto = new Usuario();

		try {
			objeto = saludoService.findByNombre(nombre);
			if(objeto != null) {
				response.put("saludo", "Salut ".concat(objeto.getNombre().concat(" ").concat(objeto.getApellido())));
				response.put("detalles", objeto);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			} else {
				response.put("mensaje", "Error al realizar la consulta en la base de datos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	@GetMapping("/usuarios")
	public ResponseEntity<?> usuarios() {
		Map<String, Object> response = new HashMap<>();

		List<Usuario> objeto = new ArrayList<Usuario>();

		try {
			objeto = saludoService.findAllUsuarios();
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("objeto", objeto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}

package com.br.zup.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.models.Rapper;
import com.br.zup.services.RapperService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/rappers")
public class RapperController {
	@Autowired
	private RapperService rapperService;

	@GetMapping
	public ResponseEntity<?> allRapper() {
		return ResponseEntity.ok().body(rapperService.allRapper());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> rapperId(@PathVariable int id) {
		try {
			Rapper rapper = rapperService.rapperId(id);
			return ResponseEntity.ok(rapper);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@PostMapping("/new")
	public ResponseEntity<?> createRapper(@Valid @RequestBody Rapper rapper) {
		try {
			rapperService.createRapper(rapper);
			return ResponseEntity.status(HttpStatus.CREATED).body(rapper);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateRapper(@PathVariable int id, @RequestBody Rapper newRapper) {
		try {
			return ResponseEntity.ok().body(rapperService.updateRapper(id, newRapper));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRapper(@PathVariable int id) {
		rapperService.deleteRapper(id);
		return ResponseEntity.ok().build();
	}

}

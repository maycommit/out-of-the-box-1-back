package com.br.zup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.models.Rapper;
import com.br.zup.services.RapperService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/zup/rapper")
public class RapperController {
	@Autowired
	private RapperService rapperService;
	
	@GetMapping("/all/rapper")
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

}
package com.example.Predator.controllers;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Predator.model.DeptModel;
import com.example.Predator.services.DepartmentService;

@RestController
public class DepartmentController {

	private final DepartmentService deptService;

	public DepartmentController(DepartmentService deptService) {
		this.deptService = deptService;
	}

	@GetMapping("/list")
	public List<DeptModel> getAll() {
		List<DeptModel> data = deptService.getAll();
		return data;
	}

	@GetMapping("list/{id}")
	public Optional<DeptModel> getById(@PathVariable Long id) {
		Optional<DeptModel> data = deptService.getById(id);
		return data;
	}

	@PostMapping("/list")
	public ResponseEntity<?> saveDetails(@RequestBody DeptModel request) {
		try {
			DeptModel save = deptService.saveDetails(request);
			return ResponseEntity.ok(save);
		} catch (RuntimeException run) {
			return ResponseEntity.badRequest().body(Map.of("status", "Failed", "message", run.getMessage()));
		}
	}

	@PutMapping("/list/{id}")
	public ResponseEntity<?> updateDetails(@PathVariable Long id, @RequestBody DeptModel request) {
		try {
			DeptModel updated = deptService.updateDetails(id, request);
			return ResponseEntity.ok(updated);
		} catch (RuntimeException ex) {
			return ResponseEntity.badRequest().body(Map.of("status", "Failed", "message", ex.getMessage()));
		}
	}

	@DeleteMapping("list/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
		try {
			deptService.deleteById(id);
			return ResponseEntity.ok(Map.of("status", "Success", "message", "Department deleted successfully"));
		} catch (RuntimeException ex) {
			return ResponseEntity.badRequest().body(Map.of("status", "Failed", "message", ex.getMessage()));
		}
	}

}

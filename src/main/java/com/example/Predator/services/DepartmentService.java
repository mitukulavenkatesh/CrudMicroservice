package com.example.Predator.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Predator.model.DeptModel;
import com.example.Predator.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private final DepartmentRepository repository;

	public DepartmentService(DepartmentRepository repository) {
		this.repository = repository;
	}

	public List<DeptModel> getAll() {
		List<DeptModel> data = repository.findAll();
//		List<DeptModel> op = data.stream().filter(a -> a.getAge() <= 29).collect(Collectors.toList());
//		op.forEach(a -> {
//			a.setAge(138);
//			a.setNames("Srujana Nadimetla");
//			a.setCity("Armoor");
//		});
		return data;
	}

	public Optional<DeptModel> getById(long id) {
		Optional<DeptModel> data = repository.findById(id);
		return data;
	}

	public DeptModel saveDetails(DeptModel request) {
//		DeptModel user = new DeptModel();
//		user.setNames(request.getNames());
//		user.setState(request.getState());
//		user.setAge(request.getAge());
//		user.setCity(request.getCity());
//		user.setDep_name(request.getDep_name());
//		user.setDep_salary(request.getDep_salary());
		DeptModel user = repository.save(request);
		System.out.println("---service-----  " + user);
		return user;
	}

	public DeptModel updateDetails(Long id, DeptModel request) {
		DeptModel existing = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Department not found with id: " + id));

		// Update fields
		existing.setDep_name(request.getDep_name());
		existing.setNames(request.getNames());
		existing.setDep_salary(request.getDep_salary());
		existing.setAge(request.getAge());
		existing.setCity(request.getCity());
		existing.setState(request.getState());

		return repository.save(existing);
	}

	public void deleteById(Long id) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("Department not found with id: " + id);
		}
		repository.deleteById(id);
	}

}

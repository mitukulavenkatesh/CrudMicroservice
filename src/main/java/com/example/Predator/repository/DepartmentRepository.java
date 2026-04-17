package com.example.Predator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Predator.model.DeptModel;

public interface DepartmentRepository extends JpaRepository<DeptModel, Long> {

}

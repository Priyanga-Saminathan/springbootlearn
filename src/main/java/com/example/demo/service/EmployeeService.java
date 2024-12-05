package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo emprepo;

	public EmployeeEntity saveEmployee(EmployeeEntity empentity) {
		// TODO Auto-generated method stub
		return emprepo.save(empentity);
	}

	public Optional<EmployeeEntity> findById(int id) {
		// TODO Auto-generated method stub
		return emprepo.findById(id);
	}

	public List<EmployeeEntity> getAllEmp() {
		// TODO Auto-generated method stub
		return emprepo.findAll();
	}
	public String deleteById(int id) {
		emprepo.deleteById(id);
		return "Deleted Successfully";
	}

	public ResponseEntity<List<EmployeeEntity>> getEmpByPosition(String position) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(emprepo.getByPosition(position),HttpStatus.OK);
	}

}

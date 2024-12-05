package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empservice;
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Optional<EmployeeEntity>> getemployee(@PathVariable("id") int id) {
		Optional<EmployeeEntity> getName=empservice.findById(id);
		return ResponseEntity.ok(getName);
	} 
	@PostMapping("/addEmployee")
	public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity empentity){
		EmployeeEntity saveEmp=empservice.saveEmployee(empentity);
		return new ResponseEntity<>(saveEmp,HttpStatus.CREATED);
	}
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployee(){
		return new ResponseEntity<>(empservice.getAllEmp(),HttpStatus.OK);
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		String res= empservice.deleteById(id);
		return res;
	}
	@GetMapping("/getEmpByPosition/{position}")
	public ResponseEntity<List<EmployeeEntity>> getEmpByPosition(@PathVariable("position") String position){
		return empservice.getEmpByPosition(position);
	}
}

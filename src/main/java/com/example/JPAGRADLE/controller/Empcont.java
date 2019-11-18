package com.example.JPAGRADLE.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAGRADLE.pojo.Employee;
import com.example.JPAGRADLE.repo.EmpRepo;

@RestController("/emp")
public class Empcont {

	@GetMapping(value = "/")
	public String index() {
		return "index.jsp";

	}

	private static final Logger logger = LoggerFactory.getLogger(Empcont.class);
	@Autowired
	EmpRepo repo;

	@PostMapping(value = "/create")
	public void create(Employee emp) {
		try {
			repo.save(emp);
			logger.info("Employee saved");
		} catch (Exception e) {
			logger.error("Error");
		}
	}
	@PostMapping(value = "/delete")
	public void delete(Employee emp) {
		try {
			repo.delete(emp);
			logger.info("Employee deleted");
		} catch (Exception e) {
			logger.error("Error");
		}
	}
}

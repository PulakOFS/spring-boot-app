package com.example.demoSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoSpring.dao.EmployeeJDBCDao;
import com.example.demoSpring.dao.EmployeeObjectMapper;
import com.example.demoSpring.dao.EmployeeOrgRepository;
import com.example.demoSpring.dao.EmployeeRepository;
import com.example.demoSpring.dao.ExternalSourceRepository;
import com.example.demoSpring.model.Employee;
import com.example.demoSpring.model.EmployeeJobProfile;
import com.example.demoSpring.model.ExternalSource;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeOrgRepository empOrgRepository;
	
	@Autowired
	EmployeeJDBCDao employeeJdbcDao;
	
	@Autowired
	ExternalSourceRepository externalSourceRepository;
	
	public void addEmployee(Employee emp) {
		employeeRepository.save(emp);
	}
	
	public void addEmployeeDetails(Employee empDetail) {
		employeeRepository.save(empDetail);
	}
	
	public ArrayList<Employee> getAllEmployees() {
		return (ArrayList<Employee>) employeeRepository.findAll();
	}
	
	public EmployeeObjectMapper getEmployeeById(String eid) {
		return employeeRepository.findByEid(eid);
	}
	
	public Employee getEmployeeSpecificById(String eid) {
		return employeeRepository.findEmpByEid(eid);
	}
	
	public void addEmployeeJobProfile(EmployeeJobProfile empJob) {
		empOrgRepository.save(empJob);
	}
	
	public ArrayList<Employee> filterEmployeeByBand(String band) {
//		return (ArrayList<Employee>) employeeRepository.findEmpByBand(band);
		return (ArrayList<Employee>) employeeJdbcDao.findEmployeesByBand(band);
	}

	@Override
	public Optional<ExternalSource> getExternalSource(Integer id) {
		// TODO Auto-generated method stub
		return externalSourceRepository.findById(id);
	}

	@Override
	public List<ExternalSource> getAllMetricSources() {
		// TODO Auto-generated method stub
		return externalSourceRepository.findAll();
	}
}

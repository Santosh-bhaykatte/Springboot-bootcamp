package com.santodev.springrest.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.santodev.springrest.cruddemo.dao.EmployeeDao;
import com.santodev.springrest.cruddemo.entity.Employee;
import com.santodev.springrest.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    // define dependency for service layer
    private EmployeeService employeeService;

    // define dependency for ObjectMapper       - Helper class for JSON processing
    private ObjectMapper objectMapper;

    // best practice: inject employee service
    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    // delegating calls to service layer

    // mapping for GET -> expose "/employees" - return a list of employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    // mapping for GET -> expose "/employees/{id}" - return a single employee
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if (employee != null) {
            return employee;
        } else {
            throw new RuntimeException("Employee id not found: "+ id);
        }
    }

    // mapping for POST -> expose "/employees" - insert new single employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // set id to 0 just in case they pass an id in JSON
        // this is to force a save of new item... instead of update
        employee.setId(0);

        Employee employee1 = employeeService.save(employee);
        return employee1;
    }

    // mapping for PUT -> expose "/employees" - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.save(employee);
        return employee1;
    }

    // mapping for PATCH -> expose "/employees/{id}" - partial updates on existing employee
    @PatchMapping("/employees/{id}")
    public Employee partialUpdateEmployee(@PathVariable int id, @RequestBody Map<String, Object> patchPayload) {
        // get employee by id
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found: "+ id);
        }

        // throw exception if request body contains "id" key
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body: "+ id);
        }

        // apply patchPayload to employee
        Employee patchedEmployee = appply(patchPayload, employee);

        // return updated employee
        return employeeService.save(patchedEmployee);
    }

    private Employee appply(Map<String, Object> patchPayload, Employee employee) {
        // convert employee object to JSON object node
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);

        // convert patchPayload map to JSON object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        // merge OR applay patch updates to employeeNode
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    // mapping for DELETE -> expose "/employees/{id}" - delete existing employee
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = getEmployee(id);

        employeeService.deleteById(id);
        return "Deleted employee id: "+ id;
    }
}

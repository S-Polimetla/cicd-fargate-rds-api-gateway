package de.polimetla.springboot.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{employeeId}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Long employeeId) {
        employeeService.updateEmployee(employee, employeeId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}

package com.example.demo.Employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeBsl {
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    public Employee getEmployee(String name, String email, String dob, long age) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name) && employee.getEmail().equals(email) &&
                    employee.getDob().equals(dob) && employee.getAge() == age) {
                return employee;
            }
        }
        return null;
    }

    // Add an employee
    public void addEmployee(int id, String name, String email, String dob, long age) {
        employees.add(
                new Employee(id, name, email, dob, age)
        );
    }

    // Search for an employee
    public String getEmployeeNameById(int id) {
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                return employee.getName();
            }
        }
        return null;
    }

    // CREATE an employee
    public String createNewEmployee(Employee employee) {
        employee.setId(employees.size() + 1);
        Employee emp = getEmployee(employee.getName(), employee.getEmail(), employee.getDob(), employee.getAge());
        if (emp == null) {
            addEmployee(
                    employee.getId(),
                    employee.getName(),
                    employee.getEmail(),
                    employee.getDob(),
                    employee.getAge()
            );
            return "Added Successfully";
        } else {
            return "Already Registered";
        }
    }

    // READ an employee
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                return employee;
            }
        }
        return null;
    }

    // DELETE an employee
    public String deleteEmployee(int id) {
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                employees.remove(employee);
                return "Employee Deleted";
            }
        }
        // TODO: Shifting ID after Deleting an account

        return "Employee doesn't exist";
    }

    // UPDATE an Employee
    public String updateEmployee(Employee employee) {
        for (Employee emp : employees) {
            if (emp.getId() == employee.getId()) {
                Employee newEmployee;
                newEmployee = new Employee(
                        employee.getId(),
                        employee.getName(),
                        employee.getEmail(),
                        employee.getDob(),
                        employee.getAge()
                );
                employees.set(emp.getId() - 1, newEmployee);
                return "Employee Updated";
            }
        }
        return "Employee doesn't exist";
    }

    // View all representatives
    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }
}

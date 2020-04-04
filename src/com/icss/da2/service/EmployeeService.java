package com.icss.da2.service;

import com.icss.da2.dao.EmployeeDao;
import com.icss.da2.pojo.Employee;

import java.util.List;

public class EmployeeService {
    private EmployeeDao ed = new EmployeeDao();

    public List<Employee> getAllEmployees(){
        return ed.getAll();
    }

    public void addEmployee(Employee employee){
        ed.add(employee);
    }

    public void deleteEmployee(Employee employee){
        ed.delete(employee);
    }

    public void updateEmployee(Employee employee){
        ed.update(employee);
    }
}

package com.example.universitytesttask.service;

import com.example.universitytesttask.exception.NoSuchDataException;
import com.example.universitytesttask.model.Department;

public interface DepartmentService {
    Department save(Department department);

    Department getByName(String name) throws NoSuchDataException;

    Integer getCountOfEmployeeByDepartment(String departmentName);

    Double getAverageSalaryByDepartment(String departmentName);
}

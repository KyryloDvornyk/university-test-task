package com.example.universitytesttask.service.impl;

import java.util.NoSuchElementException;
import com.example.universitytesttask.exception.NoSuchDataException;
import com.example.universitytesttask.model.Department;
import com.example.universitytesttask.repository.DepartmentRepository;
import com.example.universitytesttask.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getByName(String name) throws NoSuchDataException {
        return departmentRepository.getByName(name).orElseThrow(() ->
                new NoSuchDataException("Department with name " + name + " doesn't exist"));
    }

    @Override
    public Integer getCountOfEmployeeByDepartment(String departmentName) {
        return departmentRepository.getCountOfEmployeeByDepartment(departmentName);
    }

    @Override
    public Double getAverageSalaryByDepartment(String departmentName) {
        return departmentRepository.getAverageSalaryByDepartment(departmentName);
    }
}

package com.example.universitytesttask.repository;

import java.util.Optional;
import com.example.universitytesttask.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> getByName(String name);

    @Query("SELECT AVG(l.salary) FROM Lector l INNER JOIN l.departments d WHERE d.name = :departmentName")
    Double getAverageSalaryByDepartment(String departmentName);

    @Query("SELECT COUNT(l.id) FROM Lector l INNER JOIN l.departments d WHERE d.name = :departmentName")
    Integer getCountOfEmployeeByDepartment(String departmentName);
}

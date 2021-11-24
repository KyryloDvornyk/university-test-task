package com.example.universitytesttask.repository;

import java.util.List;
import java.util.Optional;
import com.example.universitytesttask.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("SELECT d.headOfDepartment FROM Department d WHERE d.name = :departmentName")
    Optional<Lector> findHeadOfDepartment(String departmentName);

    @Query("SELECT l FROM Lector l INNER JOIN l.departments d WHERE d.name = :departmentName")
    List<Lector> findByDepartment(String departmentName);

    @Query("SELECT l FROM Lector l WHERE l.name LIKE %:template%")
    List<Lector> getByTemplate(String template);
}

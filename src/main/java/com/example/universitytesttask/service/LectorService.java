package com.example.universitytesttask.service;

import java.util.List;
import com.example.universitytesttask.exception.NoSuchDataException;
import com.example.universitytesttask.model.Lector;
import org.springframework.stereotype.Service;

public interface LectorService {
    Lector save(Lector lector);

    Lector findHeadOfDepartment(String departmentName) throws NoSuchDataException;

    List<Lector> findByDepartment(String departmentName);

    List<Lector> getByTemplate(String template);
}

package com.example.universitytesttask.service.impl;

import java.util.List;
import com.example.universitytesttask.exception.NoSuchDataException;
import com.example.universitytesttask.model.Lector;
import com.example.universitytesttask.repository.LectorRepository;
import com.example.universitytesttask.service.LectorService;
import org.springframework.stereotype.Service;

@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public Lector save(Lector lector) {
        return lectorRepository.save(lector);
    }

    @Override
    public Lector findHeadOfDepartment(String departmentName) throws NoSuchDataException {
        return lectorRepository.findHeadOfDepartment(departmentName).orElseThrow(() ->
                new NoSuchDataException("Department " + departmentName + " have no head of department"));
    }

    @Override
    public List<Lector> findByDepartment(String departmentName) {
        return lectorRepository.findByDepartment(departmentName);
    }

    @Override
    public List<Lector> getByTemplate(String template) {
        return lectorRepository.getByTemplate(template);
    }
}

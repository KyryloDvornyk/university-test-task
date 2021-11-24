package com.example.universitytesttask.service.impl;

import java.util.List;
import com.example.universitytesttask.meta.Degree;
import com.example.universitytesttask.model.Department;
import com.example.universitytesttask.model.Lector;
import com.example.universitytesttask.service.DepartmentService;
import com.example.universitytesttask.service.LectorService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class DataInitializerService {
    private final LectorService lectorService;
    private final DepartmentService departmentService;

    public DataInitializerService(LectorService lectorService, DepartmentService departmentService) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
    }

    @PostConstruct
    public void testData() {
        Department departmentOfBiology = new Department();
        departmentOfBiology.setName("Biology");
        departmentOfBiology = departmentService.save(departmentOfBiology);
        Lector lectorJackSmith = createNewLector("Jack Smith", Degree.ASSISTANT,
                400d, List.of(departmentOfBiology));
        lectorService.save(lectorJackSmith);
        Lector lectorBobLiskov = createNewLector("Bob Liskov", Degree.ASSOCIATE_PROFESSOR,
                700d, List.of(departmentOfBiology));
        lectorService.save(lectorJackSmith);
        Lector lectorJhonJackson = createNewLector("Jhon Jackson", Degree.PROFESSOR,
                900d, List.of(departmentOfBiology));
        lectorJhonJackson = lectorService.save(lectorJhonJackson);
        departmentOfBiology.setHeadOfDepartment(lectorJhonJackson);
        departmentService.save(departmentOfBiology);

        Department departmentOfHistory = new Department();
        departmentOfHistory.setName("History");
        departmentOfHistory = departmentService.save(departmentOfHistory);
        Lector lectorAnnaNolan = createNewLector("Anna Nolan", Degree.ASSISTANT,
                300d, List.of(departmentOfHistory));
        lectorService.save(lectorAnnaNolan);
        Lector lectorRichardPomeranz = createNewLector("Richard Pomeranz", Degree.ASSOCIATE_PROFESSOR,
                600d, List.of(departmentOfHistory));
        lectorService.save(lectorRichardPomeranz);
        Lector lectorEmilyLiman = createNewLector("Emily Liman", Degree.PROFESSOR,
                800d, List.of(departmentOfHistory));
        lectorEmilyLiman = lectorService.save(lectorEmilyLiman);
        departmentOfHistory.setHeadOfDepartment(lectorEmilyLiman);
        departmentService.save(departmentOfHistory);

        Department departmentOfScience = new Department();
        departmentOfScience.setName("Science");
        departmentService.save(departmentOfScience);
    }

    private Lector createNewLector(String name, Degree degree, Double salary, List<Department> departments) {
        Lector lector = new Lector();
        lector.setName(name);
        lector.setDegree(degree);
        lector.setSalary(salary);
        lector.setDepartments(departments);
        return lector;
    }
}

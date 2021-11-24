package com.example.universitytesttask.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import com.example.universitytesttask.exception.NoSuchDataException;
import com.example.universitytesttask.meta.Degree;
import com.example.universitytesttask.model.Lector;
import com.example.universitytesttask.service.AnswerParserService;
import com.example.universitytesttask.service.DepartmentService;
import com.example.universitytesttask.service.LectorService;
import org.springframework.stereotype.Service;

@Service
public class AnswerParserServiceImpl implements AnswerParserService {
    private final LectorService lectorService;
    private final DepartmentService departmentService;

    public AnswerParserServiceImpl(LectorService lectorService, DepartmentService departmentService) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
    }

    @Override
    public String headOfDepartmentAnswer(String line, Pattern pattern) {
        Matcher matcher = pattern.matcher(line);
        String name = null;
        if (matcher.find()) {
            name = matcher.group(1);
        }
        try {
            return "Head of " + name + " department is "
                    + lectorService.findHeadOfDepartment(name).getName();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    @Override
    public String departmentStatisticAnswer(String line, Pattern pattern) {
        Matcher matcher = pattern.matcher(line);
        String name = null;
        if (matcher.find()) {
            name = matcher.group(1);
        }
        List<Lector> lectors = lectorService.findByDepartment(name);
        return createStatistic(lectors);
    }

    @Override
    public String averageSalaryAnswer(String line, Pattern pattern) {
        Matcher matcher = pattern.matcher(line);
        String name = null;
        if (matcher.find()) {
            name = matcher.group(1);
        }
        Double average = departmentService.getAverageSalaryByDepartment(name);
        if (average == null) {
            return "Department " + name + " has no employees";
        }
        return "The average salary of " + name + " department is " + String.format("%,.2f", average);
    }

    @Override
    public String countOfEmployeeAnswer(String line, Pattern pattern) {
        Matcher matcher = pattern.matcher(line);
        String name = null;
        if (matcher.find()) {
            name = matcher.group(1);
        }
        return String.valueOf(departmentService.getCountOfEmployeeByDepartment(name));
    }

    @Override
    public String globalSearchAnswer(String line, Pattern pattern) {
        Matcher matcher = pattern.matcher(line);
        String template = null;
        if (matcher.find()) {
            template = matcher.group(1);
        }
        List<Lector> lectors = lectorService.getByTemplate(template);
        if (lectors.size() == 0) {
            return "Template " + template + " has no any matches";
        }
        return lectors.stream()
                .map(Lector::getName)
                .collect(Collectors.joining(", "));
    }

    private String createStatistic(List<Lector> lectors) {
        return "assistants - "
                + countLectorsByDegree(lectors, Degree.ASSISTANT)
                + System.lineSeparator()
                + "associate professors - "
                + countLectorsByDegree(lectors, Degree.ASSOCIATE_PROFESSOR)
                + System.lineSeparator()
                + "professors - "
                + countLectorsByDegree(lectors, Degree.PROFESSOR);
    }

    private long countLectorsByDegree(List<Lector> lectors, Degree degree) {
        return lectors.stream()
                .filter(l -> l.getDegree().equals(degree))
                .count();
    }
}

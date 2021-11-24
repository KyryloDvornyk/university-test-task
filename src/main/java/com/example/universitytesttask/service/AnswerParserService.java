package com.example.universitytesttask.service;

import java.util.regex.Pattern;

public interface AnswerParserService {
    String headOfDepartmentAnswer(String line, Pattern pattern);

    String departmentStatisticAnswer(String line, Pattern pattern);

    String averageSalaryAnswer(String line, Pattern pattern);

    String countOfEmployeeAnswer(String line, Pattern pattern);

    String globalSearchAnswer(String line, Pattern pattern);
}

package com.example.universitytesttask;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.universitytesttask.exception.NoSuchDataException;
import com.example.universitytesttask.service.AnswerParserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityTestTaskApplication implements CommandLineRunner {
    private final static Pattern HEAD_OF_DEPARTMENT_PATTERN = Pattern.compile("^Who is head of department (.+)$");
    private final static Pattern DEPARTMENT_STATISTIC_PATTERN = Pattern.compile("^Show (.+) statistics$");
    private final static Pattern AVERAGE_SALARY_PATTERN = Pattern.compile("^Show the average salary for the department (.+)$");
    private final static Pattern COUNT_OF_EMPLOYEE_PATTERN = Pattern.compile("^Show count of employee for (.+)$");
    private final static Pattern GLOBAL_SEARCH_PATTERN = Pattern.compile("^Global search by (.+)$");
    private final AnswerParserService answerParserService;

    public UniversityTestTaskApplication(AnswerParserService answerParserService) {
        this.answerParserService = answerParserService;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniversityTestTaskApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your command:");
            String line = scanner.nextLine();
            if (HEAD_OF_DEPARTMENT_PATTERN.matcher(line).matches()) {
                System.out.println(answerParserService.headOfDepartmentAnswer(line, HEAD_OF_DEPARTMENT_PATTERN));
            } else if (DEPARTMENT_STATISTIC_PATTERN.matcher(line).matches()) {
                System.out.println(answerParserService.departmentStatisticAnswer(line, DEPARTMENT_STATISTIC_PATTERN));
            } else if (AVERAGE_SALARY_PATTERN.matcher(line).matches()) {
                System.out.println(answerParserService.averageSalaryAnswer(line, AVERAGE_SALARY_PATTERN));
            } else if (COUNT_OF_EMPLOYEE_PATTERN.matcher(line).matches()) {
                System.out.println(answerParserService.countOfEmployeeAnswer(line, COUNT_OF_EMPLOYEE_PATTERN));
            } else if (GLOBAL_SEARCH_PATTERN.matcher(line).matches()) {
                System.out.println(answerParserService.globalSearchAnswer(line, GLOBAL_SEARCH_PATTERN));
            } else if (line.equals("exit")) {
                break;
            } else {
                System.out.println("Wrong command!");
            }
        }
    }
}

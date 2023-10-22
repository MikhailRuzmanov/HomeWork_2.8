package ru.pro.sky.Homework_28.Homework_28.service;

import ru.pro.sky.Homework_28.Homework_28.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);

    Collection<Employee> findAll()
    ;

}

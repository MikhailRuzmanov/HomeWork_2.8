package ru.pro.sky.Homework_28.Homework_28.service;

import ru.pro.sky.Homework_28.Homework_28.Employee;
import ru.pro.sky.Homework_28.Homework_28.exeption.EmployeeAlreadyAddedException;
import ru.pro.sky.Homework_28.Homework_28.exeption.EmployeeNotFoundException;

import java.util.*;

public class EmployeeServiceImpl implements EmployeeService{
    private final Map<String, Employee> employeeMap;


    public EmployeeServiceImpl(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;


        //new Employee("Олег", "Васильев"),
        //new Employee("Олим", "Воронов"),
        //new Employee("Анна", "Цветкова"),
        //new Employee("Анастасия", "Крылова"),
        //new Employee("Антон", "Скворцова"),
        //new Employee("Демьян ", "Репин"),
        //new Employee("Екатерина", "Вастльева"),
        //new Employee("Валентина", "Стружкина"),
        //new Employee("Валерьян", "Крючкова"),
        //new Employee("Роман", "Ильин")

    }

    @Override
    public Employee add (String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        String s= firstName + lastName;
        if (employeeMap.containsKey(s)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(s, employee);
        return employee;
    }

    @Override
    public Employee remove (String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsValue(employee)) {
            String s= firstName + lastName;
            employeeMap.remove(s);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find (String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        String s= firstName + lastName;
        if (employeeMap.containsKey(s)) {
            return employee;
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Map<String, Employee> findAll () {
        return employeeMap;
    }
}

package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.Objects;

//Name: Jonah Dalton
//Assignment: HW1
//Date: 9/17/2025
abstract class Employee implements Comparable<Employee>{
    private String name;
    private LocalDate hireDate;

    public Employee(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }
    public LocalDate getHireDate() {
        return hireDate;
    }

    abstract double getMonthlyPay();

    @Override
    public int compareTo(Employee emp2) {
        return Double.compare(this.getMonthlyPay(), emp2.getMonthlyPay());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(hireDate, employee.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hireDate);
    }
}


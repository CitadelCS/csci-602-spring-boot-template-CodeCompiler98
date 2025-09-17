package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
//Name: Jonah Dalton
//Assignment: HW1
//Date: 9/17/2025
public class InheritanceDemo {
    public static void main(String[] args) {
        //add test employees
        ArrayList<Employee> employeeArrayList = new ArrayList<>();

        HourlyEmployee John = new HourlyEmployee(50.5, 160.0, "John Doe", LocalDate.of(2009, 5, 21));
        HourlyEmployee Jane = new HourlyEmployee(150.5, 80.0, "Jane Doe", LocalDate.of(2005, 9, 1));

        employeeArrayList.add(John);
        employeeArrayList.add(Jane);

        SalariedEmployee Moe = new SalariedEmployee(75000.0, "Moe Howard", LocalDate.of(2004, 1, 1));
        SalariedEmployee Curly = new SalariedEmployee(105000.0, "Curly Howard", LocalDate.of(2018, 1, 1));

        employeeArrayList.add(Moe);
        employeeArrayList.add(Curly);

        //print out before and after sorted list
        System.out.println("List of Employees (before sorting)");
        for (Employee emp : employeeArrayList) {
            System.out.println(emp.toString());
        }
        System.out.println();

        Collections.sort(employeeArrayList);

        System.out.println("List of Employees (after sorting)");
        for (Employee emp : employeeArrayList) {
            System.out.println(emp.toString());
        }

        //print out monthly pay(still in order) + total monthly pay
        System.out.println();
        System.out.println("Monthly Pay");
        double totalPay = 0;
        for (Employee emp : employeeArrayList) {
            totalPay += emp.getMonthlyPay();
            System.out.printf("%s: $%,.2f\n", emp.getName(), emp.getMonthlyPay());
        }

        System.out.printf("Total Monthly Pay: $%,.2f", totalPay);




    }
}

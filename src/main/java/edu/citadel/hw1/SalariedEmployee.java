package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.Objects;

//Name: Jonah Dalton
//Assignment: HW1
//Date: 9/17/2025
public class SalariedEmployee extends Employee {
    private double annualSalary;

    SalariedEmployee(double annualSalary, String name, LocalDate hireDate) {
        super(name, hireDate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public double getMonthlyPay(){
       return annualSalary / 12;
    }

    public String toString(){
        return "SalariedEmployee[name=" + this.getName() + ", hireDate=" + this.getHireDate() + ", annualSalary=" + this.getAnnualSalary() + "]";
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == null || getClass() != ob.getClass()) return false;
        if (!super.equals(ob)) return false;
        SalariedEmployee that = (SalariedEmployee) ob;
        return Double.compare(annualSalary, that.annualSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), annualSalary);
    }
}

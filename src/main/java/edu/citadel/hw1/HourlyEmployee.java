package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.Objects;

//Name: Jonah Dalton
//Assignment: HW1
//Date: 9/17/2025
public class HourlyEmployee extends Employee{
    private double wageRate;
    private double hoursWorked;

    public HourlyEmployee(double wageRate, double hoursWorked, String name, LocalDate hireDate) {
        super(name, hireDate);
        this.wageRate = wageRate;
        this.hoursWorked = hoursWorked;
    }

    public double getWageRate() {
        return wageRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double getMonthlyPay(){
      return wageRate * hoursWorked;
    }

    public String toString(){
        return "HourlyEmployee[name=" + this.getName() + ", hireDate=" + this.getHireDate() + ", wageRate=" + this.getWageRate() + ", hoursWorked=" + this.getHoursWorked() + "]";
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == null || getClass() != ob.getClass()) return false;
        if (!super.equals(ob)) return false;
        HourlyEmployee that = (HourlyEmployee) ob;
        return Double.compare(wageRate, that.wageRate) == 0 && Double.compare(hoursWorked, that.hoursWorked) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wageRate, hoursWorked);
    }
}

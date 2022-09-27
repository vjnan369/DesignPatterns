package com.DesignPatterns.structural.Bridge;

//https://medium.com/@mertgltekin_58750/structural-design-patterns-2-bridge-pattern-7ee8d240ab59
public class Medium2 {
}

interface Employee{
    public void myJob();
}

class Developer implements Employee{

    @Override
    public void myJob() {
        System.out.println(" and i am working there as a developer!");
    }
}

class HR implements Employee{

    @Override
    public void myJob() {
        System.out.println(" and i am working there as a HR!");
    }
}

abstract class Company{
    Employee employee;

    public Company(Employee employee) {
        this.employee = employee;
    }

    abstract void worksFor();
}

class SoftwareCompany extends Company{

    public SoftwareCompany(Employee employee) {
        super(employee);
    }

    @Override
    void worksFor() {
        System.out.print("I am working at software company");
        employee.myJob();
    }
}

class HardwareCompany extends Company{

    public HardwareCompany(Employee employee) {
        super(employee);
    }

    @Override
    void worksFor() {
        System.out.print("I am working at hardware company");
        employee.myJob();
    }
}

class Tester{
    public static void main(String[] args) {
        Company softwareDeveloper = new SoftwareCompany(new Developer());
        softwareDeveloper.worksFor();

        Company hardwareHr = new HardwareCompany(new HR());
        hardwareHr.worksFor();

        Company hardwareDeveloper = new HardwareCompany(new Developer());
        hardwareDeveloper.worksFor();
    }
}
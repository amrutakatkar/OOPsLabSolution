package com.glearning.pg.client;

public class HR extends Department {
    public String generateDomainAddress(empDepartment department) {
        return ("@" + department.toString() + ".abc.com");
    }
}
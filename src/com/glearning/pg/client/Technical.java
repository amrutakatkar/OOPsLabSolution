package com.glearning.pg.client;

public class Technical extends Department {
    public String generateDomainAddress(empDepartment department) {
        return ("@" + department.toString() + ".abc.com");
    }
}
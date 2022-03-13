package com.glearning.pg.client;
import com.glearning.pg.model.Employee;
import com.glearning.pg.service.CredentialService;
import com.glearning.pg.service.InvalidLengthException;

import java.util.Scanner;

public class ProfileGeneratorClient {

    public static void main(String[] args) {

        String empDepartment;
        String domainAddress;
        String password;
        String emailAddress;

        // Input from the user - Firstname and Lastname
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter Firstname of the Employee: ");
        String firstname = sc.nextLine();

        System.out.print("Please Enter Lastname of the Employee: ");
        String lastname = sc.nextLine();

        System.out.print("Please Enter Length of the password to be generated: ");
        int length = sc.nextInt();

        Employee e = new Employee(firstname, lastname);

        // Input from the Employee - Department
        System.out.println("Please Enter the Department from the following :");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");

        // Accept the Emp_Department Choice
        int choice = sc.nextInt();
        Department dept;
        empDepartment empDept;

        switch (choice) {

            case 1:
                empDept = com.glearning.pg.client.empDepartment.TECHNICAL;
                dept = new Technical();
                break;

            case 2:
                empDept = com.glearning.pg.client.empDepartment.ADMIN;
                dept = new Admin();
                break;

            case 3:
                empDept = com.glearning.pg.client.empDepartment.HR;
                dept = new HR();
                break;

            case 4:
                empDept = com.glearning.pg.client.empDepartment.LEGAL;
                dept = new Legal();
                break;

            default:
                System.out.println("Please Enter Correct Choice");
                return;
        }

        //Generate Domain Address
        domainAddress = dept.generateDomainAddress(empDept);
        //Generate Email Address
        emailAddress = CredentialService.generateEmailAddress(e.getFirstname(), e.getLastname(), domainAddress);
        e.setEmailAddress(emailAddress);

        //Generate password
        try {
            password = String.valueOf(CredentialService.generatePassword(length));
            e.setPassword(password);
        } catch (InvalidLengthException exception) {
            System.err.println("Length entered to generate password in less than 8. Please enter length Greater than 8");
            return;
        }

        //Show Credentials
        CredentialService.showCredentials(e);

        // scanner.close();
        sc.close();
    }
}


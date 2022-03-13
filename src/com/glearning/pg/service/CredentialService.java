package com.glearning.pg.service;

import com.glearning.pg.model.Employee;

import java.util.Random;

public class CredentialService {

    public static final char[] generatePassword(int len) throws InvalidLengthException {

        if (len< 8) {
            throw new InvalidLengthException("Length entered to generate password in less than 8");
        }

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String values = Capital_chars + Small_chars + numbers + symbols;
        // Using random method
        Random rndm_method = new Random();
        char[] password = new char[len];
        for (int i = 0; i < len; i++) {
            password[i] = values.charAt(rndm_method.nextInt(values.length()));
        }
        return password;
    }

    public static String generateEmailAddress(String firstname, String lastname, String DomainAddress) {
        return ((firstname.toLowerCase() + lastname.toLowerCase() + DomainAddress).replaceAll("\\s", ""));
    }

    public static void showCredentials(Employee e) {
        System.out.println("Dear " + e.getFirstname() + " your generated credentials are as follows :");
        System.out.println("Email        ---> " + e.getEmailAddress());
        System.out.println("Password     ---> " + e.getPassword());
    }
}
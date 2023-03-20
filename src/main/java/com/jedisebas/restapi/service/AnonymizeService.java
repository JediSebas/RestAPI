package com.jedisebas.restapi.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnonymizeService {


    public static String anonymizeLastName(final String lastName) {
        return lastName.charAt(0) + "*".repeat(lastName.length() - 1);
    }

    public static String anonymizeEmail(final String email) {
        final StringBuilder emailBuilder = new StringBuilder();
        emailBuilder.append(email.charAt(0));
        emailBuilder.append("***");

        int i = 4;
        while (email.charAt(i + 1) != '@') {
            i++;
        }

        for (int j = 0; j < 3; j++) {
            emailBuilder.append(email.charAt(i));
            i++;
        }

        emailBuilder.append("***");

        while (email.charAt(i + 1) != '.') {
            i++;
        }

        for (int j = 0; j < 2; j++) {
            emailBuilder.append(email.charAt(i));
            i++;
        }

        while (i < email.length()) {
            emailBuilder.append(email.charAt(i));
            i++;
        }

        return emailBuilder.toString();
    }
}

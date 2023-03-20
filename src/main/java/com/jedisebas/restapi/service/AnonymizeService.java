package com.jedisebas.restapi.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnonymizeService {

    public static String anonymizeLastName(String lastName) {
        throwWhenNullOrEmpty(lastName);

        lastName = lastName.trim();

        return lastName.charAt(0) + "*".repeat(lastName.length() - 1);
    }

    public static String anonymizeEmail(String email) {
        throwWhenNullOrEmpty(email);

        email = email.trim();

        final String[] splitEmail = email.split("@");

        final String local = splitEmail[0];
        final String domain = splitEmail[1];

        final StringBuilder emailBuilder = new StringBuilder();
        emailBuilder.append(local.charAt(0));
        emailBuilder.append("***");
        emailBuilder.append(local.charAt(local.length() - 1));
        emailBuilder.append("@");

        final String[] splitDomain = domain.split("\\.");

        final String lastPart = splitDomain[splitDomain.length - 1];

        for (int i = 0; i < splitDomain.length - 1; i++) {
            final String part = splitDomain[i];
            emailBuilder.append(part.charAt(0));
            emailBuilder.append("***");
            emailBuilder.append(part.charAt(part.length() - 1));
            emailBuilder.append(".");
        }
        emailBuilder.append(lastPart);

        return emailBuilder.toString();
    }

    private static void throwWhenNullOrEmpty(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}

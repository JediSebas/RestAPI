package com.jedisebas.restapi.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnonymizeService {

    public static String anonymizeLastName(final String lastName) {
        return lastName.charAt(0) + "*".repeat(lastName.length() - 1);
    }

    public static String anonymizeEmail(final String email) {
        final String[] splitEmail = email.split("@");

        final String local = splitEmail[0];
        final String domain = splitEmail[1];

        final StringBuilder emailBuilder = new StringBuilder();
        emailBuilder.append(local.charAt(0));
        emailBuilder.append("***");
        emailBuilder.append(local.charAt(local.length() - 1));
        emailBuilder.append("@");

        final String[] splitDomain = domain.split("\\.");

        final String beforeDot = splitDomain[0];
        final String afterDot = splitDomain[1];

        emailBuilder.append(beforeDot.charAt(0));
        emailBuilder.append("***");
        emailBuilder.append(beforeDot.charAt(beforeDot.length() - 1));
        emailBuilder.append(".");
        emailBuilder.append(afterDot);

        return emailBuilder.toString();
    }
}

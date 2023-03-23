package com.jedisebas.restapi.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnonymizeService {

    public static String anonymizeAllWithoutFirstLetter(String string) {
        throwWhenNullOrEmpty(string);

        string = string.trim();

        return string.charAt(0) + "*".repeat(string.length() - 1);
    }

    public static String anonymizeMiddleOfString(String string) {
        throwWhenNullOrEmpty(string);

        string = string.trim();

        final String[] splitString = string.split("@");

        final String local = splitString[0];

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(local.charAt(0));
        stringBuilder.append("***");
        stringBuilder.append(local.charAt(local.length() - 1));

        if (splitString.length == 1) {
            return stringBuilder.toString();
        }

        stringBuilder.append("@");
        final String domain = splitString[1];
        final String[] splitDomain = domain.split("\\.");

        final String lastPart = splitDomain[splitDomain.length - 1];

        for (int i = 0; i < splitDomain.length - 1; i++) {
            final String part = splitDomain[i];
            stringBuilder.append(part.charAt(0));
            stringBuilder.append("***");
            stringBuilder.append(part.charAt(part.length() - 1));
            stringBuilder.append(".");
        }
        stringBuilder.append(lastPart);

        return stringBuilder.toString();
    }

    public static String anonymizeEntireString(String string) {
        throwWhenNullOrEmpty(string);

        string = string.trim();

        return "*".repeat(string.length());
    }

    private static void throwWhenNullOrEmpty(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}

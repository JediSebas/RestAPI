package com.jedisebas.restapi.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnonymizeServiceTest {

    @Test
    void givenLastName_whenAnonymized_thenReturnResult() {
        assertEquals("A***", AnonymizeService.anonymizeLastName("Aqwe"));
        assertEquals("P*****", AnonymizeService.anonymizeLastName("Pqwert"));
        assertEquals("V", AnonymizeService.anonymizeLastName("V"));
        assertEquals("q*****", AnonymizeService.anonymizeLastName("qwerty"));
        assertEquals("**", AnonymizeService.anonymizeLastName("**"));
    }

    @Test
    void givenEmail_whenAnonymized_thenReturnResult() {
        assertEquals("a***a@a***a.a", AnonymizeService.anonymizeEmail("a@a.a"));
        assertEquals("*****@*****.*", AnonymizeService.anonymizeEmail("*@*.*"));
        assertEquals("p***r@k***s.com", AnonymizeService.anonymizeEmail("patryk.jar@kainos.com"));
    }
}
package com.jedisebas.restapi.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnonymizeServiceTest {

    @Test
    void givenLastName_whenAnonymized_thenReturnResult() {
        assertEquals("A***", AnonymizeService.anonymizeLastName("Aqwe"));
        assertEquals("P*****", AnonymizeService.anonymizeLastName("Pqwert"));
        assertEquals("V", AnonymizeService.anonymizeLastName("V"));
        assertEquals("q*****", AnonymizeService.anonymizeLastName("qwerty"));
        assertEquals("**", AnonymizeService.anonymizeLastName("**"));
        assertEquals("A***", AnonymizeService.anonymizeLastName("   Adam    "));
        assertThrows(IllegalArgumentException.class, () -> AnonymizeService.anonymizeLastName(""));
        assertThrows(IllegalArgumentException.class, () -> AnonymizeService.anonymizeLastName(null));
    }

    @Test
    void givenEmail_whenAnonymized_thenReturnResult() {
        assertEquals("a***a@a***a.a", AnonymizeService.anonymizeEmail("a@a.a"));
        assertEquals("*****@*****.*", AnonymizeService.anonymizeEmail("*@*.*"));
        assertEquals("p***r@k***s.com", AnonymizeService.anonymizeEmail("patryk.jar@kainos.com"));
        assertEquals("s***n@z***t.e***u.pl", AnonymizeService.anonymizeEmail("sebastian@zst.edu.pl"));
        assertEquals("s***n@z***w.pl", AnonymizeService.anonymizeEmail("sebastian@zst-edu-ostrow.pl"));
        assertEquals("a***d@a***d.asd", AnonymizeService.anonymizeEmail("    asd@asd.asd "));
        assertThrows(IllegalArgumentException.class, () -> AnonymizeService.anonymizeEmail(""));
        assertThrows(IllegalArgumentException.class, () -> AnonymizeService.anonymizeEmail(null));
    }
}
package com.jedisebas.restapi.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnonymizeServiceTest {

    @Test
    void givenLastName_whenAnonymized_thenReturnResult() {
        assertEquals("A***", AnonymizeService.anonymizeAllWithoutFirstLetter("Aqwe"));
        assertEquals("P*****", AnonymizeService.anonymizeAllWithoutFirstLetter("Pqwert"));
        assertEquals("V", AnonymizeService.anonymizeAllWithoutFirstLetter("V"));
        assertEquals("q*****", AnonymizeService.anonymizeAllWithoutFirstLetter("qwerty"));
        assertEquals("**", AnonymizeService.anonymizeAllWithoutFirstLetter("**"));
        assertEquals("A***", AnonymizeService.anonymizeAllWithoutFirstLetter("   Adam    "));
        assertThrows(IllegalArgumentException.class, () -> AnonymizeService.anonymizeAllWithoutFirstLetter(""));
        assertThrows(IllegalArgumentException.class, () -> AnonymizeService.anonymizeAllWithoutFirstLetter(null));
    }

    @Test
    void givenEmail_whenAnonymized_thenReturnResult() {
        assertEquals("a***a@a***a.a", AnonymizeService.anonymizeMiddleOfString("a@a.a"));
        assertEquals("*****@*****.*", AnonymizeService.anonymizeMiddleOfString("*@*.*"));
        assertEquals("p***r@k***s.com", AnonymizeService.anonymizeMiddleOfString("patryk.jar@kainos.com"));
        assertEquals("s***n@z***t.e***u.pl", AnonymizeService.anonymizeMiddleOfString("sebastian@zst.edu.pl"));
        assertEquals("s***n@z***w.pl", AnonymizeService.anonymizeMiddleOfString("sebastian@zst-edu-ostrow.pl"));
        assertEquals("a***d@a***d.asd", AnonymizeService.anonymizeMiddleOfString("    asd@asd.asd "));
        assertThrows(IllegalArgumentException.class, () -> AnonymizeService.anonymizeMiddleOfString(""));
        assertThrows(IllegalArgumentException.class, () -> AnonymizeService.anonymizeMiddleOfString(null));
    }
}
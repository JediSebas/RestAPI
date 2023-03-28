package com.jedisebas.restapi.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonRequestProvider {

    public static final String eventJson = """

                {
                    "title": "Tech3camp",
                    "date": "2023-03-23 17:35:00",
                    "description": "Lorem ipsum dolor sentio amo is"
                }
                """;
}

package com.jedisebas.restapi.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonRequestProvider {

    public static final String EVENT_JSON = """

                {
                    "title": "Tech3camp",
                    "date": "2023-03-23 17:35:00",
                    "description": "Lorem ipsum dolor sentio amo is"
                }
                """;

    public static final String EVENT_PERSONAL_DETAILS = """
				{
				    "first_name": "Szymon",
				    "last_name": "Marciniak",
				    "email": "szymonmarciniak@gmail.com",
				    "address": {
				        "city": "Gdansk",
				        "street": "Jana z Kolna",
				        "house_number": "11"
				    }
				}
				""";
}

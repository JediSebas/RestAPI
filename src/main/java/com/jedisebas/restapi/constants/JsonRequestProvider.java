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

    public static final String PERSONAL_DETAILS_JSON = """
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

	public static final String PERSONAL_DETAILS_JSON2 = """
				{
				    "first_name": "Marcin",
				    "last_name": "Szymoniak",
				    "email": "asdqwerty@gmail.com",
				    "address": {
				        "city": "Gdynia",
				        "street": "Jana z Kolna",
				        "house_number": "15"
				    }
				}
				""";

	public static final String EMPTY_PERSONAL_DETAILS_JSON =  """
				{
				    "first_name": "",
				    "last_name": "",
				    "email": "",
				    "address": {
				        "city": "",
				        "street": "",
				        "house_number": ""
				    }
				}
				""";
}

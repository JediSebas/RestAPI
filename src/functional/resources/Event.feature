Feature: Test end to end Event
  Scenario: POST request
    When post request is sent to "/v1/events"
    Then return 201 CREATE code

  Scenario: GET request
    When get request is sent to "/v1/events"
    Then return 200 OK code
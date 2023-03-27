Feature: Testing Event POST
  Scenario: POST request to /v1/events returns 201 CREATED
    Given a POST request to "/v1/events"
    Then the response status code should be 201 CREATED
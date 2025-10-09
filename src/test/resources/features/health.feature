Feature: Health check
  Scenario: The application health is checked
    When the client calls /health
    Then the client receives status code of 200
    And the client receives a status of "ok"

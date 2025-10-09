Feature: the version can be retrieved
  Scenario: client makes call to GET /info to get version
    When the client calls /info
    Then the client receives status code of 200
    And the client receives server version 1.0.0

  Scenario: client makes call to GET /info to get description
    When the client calls /info
    Then the client receives status code of 200
    And the client receives server Description "Template Spring Boot API for use of CSCI 602"

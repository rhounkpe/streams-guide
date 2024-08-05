Feature: Post management API
  Background:
    * endpointPath 'http://locahost:8080/posts/10'

  Scenario: Get post informations by id
    Given path endpointPath
    When metho GET
    Then status 200
    And match response == 'Arno'
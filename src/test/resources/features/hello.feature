Feature: My Name Endpoint

  Scenario: Client sends a POST request to /my-name with a name
    Given the client sets the request body to
      """
      {
        "name": "Hussain"
      }
      """
    When the client sends a POST request to "/my-name"
    Then the response status should be 200
    And the response body should be
      """
      {
        "id": 1,
        "name": "Hussain"
      }
      """
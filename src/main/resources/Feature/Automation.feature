Feature: Automation Assessment

  @SmokeTest
  Scenario: Create Post Request
    Given I have a payload name "Automated testing" completed "true"
    When I hit the post method
    Then I verify response headers
    And I verify response data
    And I Verify the status code 405
    And I verify response time does not exceed 5000ms
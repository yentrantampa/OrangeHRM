Feature: This feature is to verify user can login

  Background:
    Given User is on login page

  Scenario Outline: Verify User Can Login Valid Credentials
    Given verify user is on login page
    When user login with valid "<username>" and "<password>"
    Then verify user in on homepage
    Examples:
      | username | password |
      | Admin    | admin123 |

  Scenario Outline: Verify User Cannot Login with Invalid Credentials and received error message
    Given verify user is on login page
    When user login with valid "<username>" and "<password>" and "<requiredError>"
    Then verify user is on login page
    Examples:
      | username | password | requiredError |
      |          |          | Required      |
      |          | admin123 | Required      |
      | admin    |          | Required      |

  @smoke
  Scenario: Verify user receives error message with invalid log in
    Given verify user is on login page
    When user log in with invalid credentials
    Then user receives required error message
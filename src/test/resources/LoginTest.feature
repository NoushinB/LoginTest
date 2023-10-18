Feature: Login Functionality

  Scenario: Successful login
    Given the user is on the login page
    When they enter a valid username and password
    And they click the login button
    Then they should be logged in

  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When they enter an invalid username and password
    And they click the login button
    Then they should see an error message

  Scenario: Forgot password
    Given the user is on the login page
    When they click the "Forgot Password" button
    Then they should be taken to the password recovery page
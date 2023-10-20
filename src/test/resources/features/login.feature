Feature: Login Functionality

  Background: User is on the login page
    Given the user is on the login page

  Scenario: Successful login
    When they enter a valid username and password
    And they click the login button
    Then they should be logged in

  @todo
  Scenario: Unsuccessful login with invalid credentials
    When they enter an invalid username and password
    And they click the login button
    Then they should see an error message

  @todo
  Scenario: Forgot password
    When they click the "Forgot Password" button
    Then they should be taken to the password recovery page
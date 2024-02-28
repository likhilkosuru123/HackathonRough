Feature: Zig Wheels

  Scenario: Upcoming bikes
    Given the user navigates to zigwheels home page
    When the user hover on the new Bikes
    And click on upcoming bikes
    Then select manufacturur and click on read more
    And get all the details of upcoming bikes below four lakhs

  Scenario: Used Cars in Chennai
    When the user hovers on used cars
    And clicked on chennai
    Then get the popular models of the cars
    

  Scenario: login with wrong email
    When the user clicks on zigwheels logo
    And the user clicks on login
    And the user clicks on google
    Then enter the wrong email and gets the error message
    And send data to the excel
@calculator
Feature: Calculator
   This feature file covers scenarios that test various functionalities of the Calculator.

  Background: 
    Given the user navigates to the Google home page
    And the user searches for "Calculator"

  @smoke @regression
  Scenario Outline: TC728401 Verify number button inputs display correct values
    When the user enters "<number>"
    Then "<expected>" is displayed in result pane

    Examples: 
      | number | expected |
      |      0 |        0 |
      |      1 |        1 |
      |      2 |        2 |
      |      3 |        3 |
      |      4 |        4 |
      |      5 |        5 |
      |      6 |        6 |
      |      7 |        7 |
      |      8 |        8 |
      |      9 |        9 |

  @smoke @regression
  Scenario Outline: TC728402 Verify arithmatic operations that result in positive values
    When the user enters "<number1>"
    And the user selects "<operation>"
    And the user enters "<number2>"
    And the user confirms the calculation
    Then "<expected>" is displayed in result pane

    Examples: 
      | number1 | number2 | operation      | expected |
      |       2 |       3 | addition       |        5 |
      |      17 |      11 | subtraction    |        6 |
      |      24 |      28 | multiplication |      672 |
      |     375 |       5 | division       |       75 |

  @regression 
  Scenario Outline: TC728403 Verify arithmetic operations with large integer inputs resulting in exponential output
    When the user enters "<number1>"
    And the user selects "<operation>"
    And the user enters "<number2>"
    And the user confirms the calculation
    Then "<expected>" is displayed in result pane

    Examples: 
      | number1            | number2         | operation      | expected      |
      |    999999999999999 | 999999999999999 | addition       | 2e+15         |
      |    999999999999999 | 888888888888888 | subtraction    | 1.1111111e+14 |
      |    123456789012345 | 987654321098765 | multiplication | 1.2193263e+29 |
      | 999999999999999999 |          999999 | division       | 1.000001e+12  |

  @regression
  Scenario Outline: TC728404 Verify arithmatic operations that result in negative values
    When the user enters "<number1>"
    And the user selects "<operation>"
    And the user enters "<number2>"
    And the user confirms the calculation
    Then "<expected>" is displayed in result pane

    Examples: 
      | number1 | number2 | operation      | expected |
      |      -5 |       3 | addition       |       -2 |
      |     -17 |      11 | subtraction    |      -28 |
      |     -24 |      28 | multiplication |     -672 |
      |    -375 |       5 | division       |      -75 |

  @smoke @regression
  Scenario: TC728405 Verify “All Clear” resets the calculator display
    When the user enters "17"
    And the user selects "addition"
    And the user enters "15"
    And the user confirms the calculation
    Then "32" is displayed in result pane
    When the user clears all
    Then "0" is displayed in result pane

  @smoke @regression
  Scenario: TC728406 Verify “Clear Entry” removes the last digit entered
    When the user enters "71"
    Then "71" is displayed in result pane
    When the user clears entry
    Then "7" is displayed in result pane

  @regression
  Scenario Outline: TC728407 Verify correctness of decimal arithmetic operations
    When the user enters "<number1>"
    And the user selects "<operation>"
    And the user enters "<number2>"
    And the user confirms the calculation
    Then "<expected>" is displayed in result pane

    Examples: 
      | number1 | number2 | operation      | expected      |
      |     2.1 |     3.1 | addition       |           5.2 |
      |    17.7 |    11.8 | subtraction    |           5.9 |
      |    24.9 |    28.1 | multiplication |        699.69 |
      |   375.1 |     4.2 | division       | 89.3095238095 |

  @regression
  Scenario: TC728408 Verify correct result for chained arithmetic operations
    When the user enters "9.7"
    And the user selects "addition"
    And the user enters "3"
    And the user selects "multiplication"
    And the user enters "5.1"
    And the user selects "division"
    And the user enters "5"
    And the user selects "subtraction"
    And the user enters "7.7"
    And the user confirms the calculation
    Then "5.06" is displayed in result pane

  @regression
  Scenario: TC728409 Verify full expression is shown in display pane
    When the user enters "9.7"
    And the user selects "addition"
    And the user enters "3"
    And the user selects "multiplication"
    And the user enters "5.1"
    And the user selects "division"
    And the user enters "5"
    And the user selects "subtraction"
    And the user enters "7.7"
    Then "9.7 + 3 × 5.1 ÷ 5 - 7.7" is displayed in result pane

  @regression
  Scenario: TC728410 Verify "Infinity" is displayed when dividing by zero
    When the user enters "17"
    And the user selects "division"
    And the user enters "0"
    And the user confirms the calculation
    Then "Infinity" is displayed in result pane

  @regression
  Scenario: TC728411 Verify last operator overrides previous when multiple operators are entered without a number
    When the user enters "8"
    And the user selects "division"
    And the user selects "addition"
    And the user selects "multiplication"
    Then "8 ×" is displayed in result pane

  @regression
  Scenario: TC728412 Verify leading multiple zeros result in a single zero displayed
    When the user enters "0"
    And the user enters "0"
    And the user enters "0"
    And the user confirms the calculation
    Then "0" is displayed in result pane

  @regression
  Scenario: TC728413 Verify pressing "=" multiple times, keeps result unchanged
    When the user enters "11"
    And the user selects "addition"
    And the user enters "2"
    And the user confirms the calculation
    Then "13" is displayed in result pane
    When the user confirms the calculation again
    Then "13" is displayed in result pane

  @regression
  Scenario: TC728414 Verify result pane remains unchanged when "=" is pressed without second operand
    When the user enters "11"
    And the user selects "addition"
    And the user confirms the calculation
    Then "11 +" is displayed in result pane

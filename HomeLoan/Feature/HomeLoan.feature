@test
Feature: Home Loan Assessment
	Background: Load home loan calculator URL.
		Given Navigate to home loan calculator
	
  @test1
  Scenario: Testing borrowing estimate calculation in home loan calculator.
    Given Enter the person details in home loan calculator
    Then Verify that borrowing estimate is displayed as "$479,000"
    
  @test2
  Scenario: Testing start over button in home loan calculator.
    Given Enter the person details in home loan calculator
    And Click the start over button
    Then Verify that clicking start over button clears the form

  @test3
  Scenario: Testing borrowing estimate calculation by entering value only for living expenses and leaving all other fields as zero in home loan calculator will result in displaying error message.
    Given Enter the person living expenses as one in home loan calculator and Leave all other fields as zero
    And Click the "Work out how much I could borrow" button
    Then Verify that error message is displayed in home loan calculator upon entering value only for living expenses and leaving all other fields as zero
   
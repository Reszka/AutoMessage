Feature: MessageReceivedConfirm
  This feature allows panel administrator to confirmed that he received user's message.

  Scenario: After I send message from widget as a user and then log in to the panel page as an admin, I will be able to
  confirm that I received the message.

    Given I navigate to widget page
    And I navigate to the login page
    And I enter the username as "mart.kulig@gmail.com" and password as "Password1" and log in
    And I send message on widget page




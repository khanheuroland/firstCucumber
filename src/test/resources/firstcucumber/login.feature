Feature: Login
  @Sprint1
  Scenario: Show Homepage after login with valid credentials
    Given The login screen is displayed on browser
    When The User attempt to login with his credentials is "khanh.tx@live.com" and "abc123"
    Then The homepage will be showed
  @Sprint2
  Scenario Outline: Show error message after login with invalid credentials
    Given The login screen is displayed on browser
    When The user attempt to login with <username> and invalid <password>
    Then The error <message> is showed
    Examples:
    |username         |password |message                                    |
    |khanh.tx@live.com| abc     | The message must be more than 6 characters|
    |khanh.tx         | abc123  | The email is invalid      |
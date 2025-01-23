Feature: Validate Coindesk API 
@coindesk

  Scenario: Verify coindesk Get response
  Given user send a GET request to "https://api.coindesk.com/v1/bpi/currentprice.json"
    Then the response status code should be 200
    And the response should contain BPIs "USD", "GBP", "EUR"
    And the GBP description should be "British Pound Sterling"
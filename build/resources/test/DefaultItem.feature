Feature: Verify default item behaviour

  Scenario: Quality should never be negative
    Given item named "testItem" with quality 0 and sellIn 5
    When 1 days pass
    Then quality should be 0 and sellIn should be 4

  Scenario: Quality should degrade by 1 before expiration
    Given item named "testItem" with quality 50 and sellIn 5
    When 1 days pass
    Then quality should be 49 and sellIn should be 4

  Scenario: Quality should degrade by 2 after expiration
    Given item named "testItem" with quality 50 and sellIn 0
    When 1 days pass
    Then quality should be 48 and sellIn should be -1

  Scenario: Quality should degrade by 2 after expiration
    Given item named "testItem" with quality 55 and sellIn 10
    When 1 days pass
    Then quality should be 50 and sellIn should be 9
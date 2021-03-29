Feature: Verify conjured item behaviour

  Scenario: Quality should never be negative
    Given item named "Conjured" with quality 0 and sellIn 5
    When 1 days pass
    Then quality should be 0 and sellIn should be 4

  Scenario: Quality should degrade by 2 before expiration
    Given item named "ConjuredBow" with quality 50 and sellIn 5
    When 1 days pass
    Then quality should be 48 and sellIn should be 4

  Scenario: Quality should degrade by 4 after expiration
    Given item named "ConjuredTest" with quality 50 and sellIn 0
    When 1 days pass
    Then quality should be 46 and sellIn should be -1
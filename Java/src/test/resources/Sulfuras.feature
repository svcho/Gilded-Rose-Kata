Feature: Verify Sulfuras behaviour

  Scenario: Sulfuras always has the value of 80 and sellIn doesn't change
    Given item named "Sulfuras, Hand of Ragnaros" with quality 80 and sellIn 0
    When 1 days pass
    Then quality should be 80 and sellIn should be 0

Feature: Verify Aged Brie behaviour

  Scenario: Aged brie increases in quality by 1 before sellIn
    Given item named "Aged Brie" with quality 10 and sellIn 2
    When 1 days pass
    Then quality should be 11 and sellIn should be 1

  Scenario: Aged brie increases in quality by 2 after sellIn
    Given item named "Aged Brie" with quality 10 and sellIn -1
    When 1 days pass
    Then quality should be 12 and sellIn should be -2

  Scenario: Aged brie quality does not rise over 50
    Given item named "Aged Brie" with quality 50 and sellIn 5
    When 1 days pass
    Then quality should be 50 and sellIn should be 4
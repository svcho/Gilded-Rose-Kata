Feature: Verify backstage pass behaviour

  Scenario: Double quality increase within 10 days of expiration for sellIn 10
    Given item named "Backstage passes to a TAFKAL80ETC concert" with quality 10 and sellIn 10
    When 1 days pass
    Then quality should be 12 and sellIn should be 9

  Scenario: Double quality increase within 10 days of expiration for sellIn 7
    Given item named "Backstage passes to a TAFKAL80ETC concert" with quality 10 and sellIn 7
    When 1 days pass
    Then quality should be 12 and sellIn should be 6

  Scenario: Triple quality increase within 5 days of expiration for sellIn 5
    Given item named "Backstage passes to a TAFKAL80ETC concert" with quality 10 and sellIn 5
    When 1 days pass
    Then quality should be 13 and sellIn should be 4

  Scenario: Triple quality increase within 5 days of expiration for sellIn 2
    Given item named "Backstage passes to a TAFKAL80ETC concert" with quality 10 and sellIn 2
    When 1 days pass
    Then quality should be 13 and sellIn should be 1

  Scenario: Loose quality when pass is expired
    Given item named "Backstage passes to a TAFKAL80ETC concert" with quality 10 and sellIn 0
    When 1 days pass
    Then quality should be 0 and sellIn should be -1

  Scenario: Backstage pass quality does not rise over 50
    Given item named "Backstage passes to a TAFKAL80ETC concert" with quality 50 and sellIn 5
    When 1 days pass
    Then quality should be 50 and sellIn should be 4

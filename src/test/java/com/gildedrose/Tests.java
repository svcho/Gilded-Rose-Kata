package com.gildedrose;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    Item[] items;

    @Given("item named {string} with quality {int} and sellIn {int}")
    public void item_named_with_quality_and_sell_in(String name, Integer quality, Integer sellIn) {
        items = new Item[]{
                new Item(name,sellIn,quality)
        };
    }

    @When("{int} days pass")
    public void days_pass(Integer days) {
        GildedRose app = new GildedRose(items);
        for(int i = 0; i < days; i++)
            app.updateQuality();
    }

    @Then("quality should be {int} and sellIn should be {int}")
    public void quality_should_be_and_sell_in_should_be(Integer quality, Integer sellIn) {
        assertEquals(quality, items[0].quality);
        assertEquals(sellIn, items[0].sellIn);
    }

}

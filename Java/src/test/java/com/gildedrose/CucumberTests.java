/* Copyright (C) 2020 Jacob Suchorabski - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the GNU General Public license
 *
 * You should have received a copy of the GNU General Public license with
 * this file.
 */
package com.gildedrose;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CucumberTests {
    Item[] items;

    @Given("item named {string} with quality {int} and sellIn {int}")
    public void Given_Item_With_Name_Quality_And_SellIn(String name, Integer quality, Integer sellIn){
        items = new Item[]{
                new Item(name,sellIn,quality)
        };
    }

    @When("{int} days pass")
    public void When_Day_Passes(Integer days){
        GildedRose app = new GildedRose(items);

        for(int i = 0; i < days; i++)
            app.updateQuality();
    }

    @Then("quality should be {int} and sellIn should be {int}")
    public void Then_Quality_And_SellIn_Should_Equal(Integer quality, Integer sellIn){
        assertEquals(quality, items[0].quality);
        assertEquals(sellIn, items[0].sellIn);
    }
}

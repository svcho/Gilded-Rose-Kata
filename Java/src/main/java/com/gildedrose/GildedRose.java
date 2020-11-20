/* Copyright (C) 2020 Jacob Suchorabski - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the GNU General Public license
 *
 * You should have received a copy of the GNU General Public license with
 * this file.
 */
package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality(){
        for (Item item : items) {
            int degradationAmount = -1;

            //Set the initial degradation amount base on the item name
            switch (item.name){
                case "Aged Brie":
                    degradationAmount = 1;
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    item.quality = 80;
                    return;
                case "Backstage passes to a TAFKAL80ETC concert":
                    degradationAmount = evaluateBackstagePassesValue(item);
                    break;
            }

            //adjust the amount by a set factor based on the quality or when the item is special
            degradationAmount *= adjustDegradation(item);

            //Perform the degradation and check the edge cases
            degradeItem(item, degradationAmount);
        }
    }

    private int evaluateBackstagePassesValue(Item item){
        int value = 1;

        if(item.sellIn <= 10 && item.sellIn > 5){
            value = 2;
        }else if(item.sellIn == 0){
            value = -item.quality;
        }

        return value;
    }

    private int adjustDegradation(Item item){
        if(item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.sellIn <= 5 && item.sellIn > 0){
            return 3;
        }else if(item.name.toLowerCase().contains("conjured") && item.sellIn > 0){
            return 2;
        }else if(item.name.toLowerCase().contains("conjured") && item.sellIn <= 0){
            return 4;
        }else if(item.sellIn <= 0){
            return 2;
        }else{
            return 1;
        }
    }

    private void degradeItem(Item item, int value){
        item.sellIn -= 1;
        item.quality += value;

        if(item.quality < 0){
            item.quality = 0;
        }else if(item.quality > 50){
            item.quality = 50;
        }
    }
}
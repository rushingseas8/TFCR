# TFCR
An (unofficial) port of TerraFirmaCraft for version 1.12 (with additional features).


# TL;DR of how to mod Minecraft in 1.12

## Overall notes

* Shortcuts used in this page
  * \<root\>       == "src/main/java"
  * \<package\>    == "<root>/com.pffft.tfcr"
  * \<resources\>  == "src/main/resources/assets.tfcr".

## How to add an item

### Create new item

1. In ModItems.java, create an instance of your new item.
  * E.g., "public static final Item \<youritem\> = new Item()..."
  * Or, create "YourItem.class" in \<package\>.items, and
    "public static final YourItem \<youritem\> = new YourItem()..."

2. Add your item to the "itemsList" variable. This will register it with Forge and add its model to the game for you.

3. Name it: Go into <resources>.lang, into "en_us.lang", and add:
  * \<youritem\>.name=\<Name in-game, without quotes\>
  * E.g., "item.ore_copper.name=Copper Ore"

4. Inventory model: Go into \<resources\>/models.item and copy the format for "ore_copper".json. Change the "layer0" property for simple items; the json controls the model's details. 

5. Texture: Add in a file named "\<youritem\>.png" to \<resources\>/textures.items. It needs to be a power of 2 square image with the same name as your item.

### Create new block

1. In ModBlocks.java, create an instance of your new block (like with items).

2. Add your block to the "blocksList" variable.

3. Add blockstate. This explains every possible way your block can appear in the world, and describes what models it should use in every case. In \<resources\>.blockstates, add \<yourblock\>.json. 

4. Add an item (inventory) model. This is how your block looks in the inventory, and refers to some model. In \<resources\>.models.item, add \<yourblock\>.json.

5. Add a block (world) model. This is how your block looks in the real world. In \<resources\>.models.block, add \<yourblock\>.json.

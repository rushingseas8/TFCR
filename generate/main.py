# TODO: This should all be auto-generated at some point.
# For now it's all pre-written here.
langfileText = '''item.ore_copper_poor.name=Copper Ore
item.ore_iron_poor.name=Iron Ore
item.ore_bismuth_poor.name=Bismuth Ore

itemGroup.tab_custom_ores=TFC Ores
itemGroup.tab_custom_blocks=TFC Blocks

tile.block_barrel.name=Barrel
tile.block_firepit.name=Firepit
tile.block_half_grass.name=Half-Tall Grass
tile.block_branch.name=Branch
tile.weak_stone.name=Weak Stone

generator.TerraFirmaCraft=TFC Default
'''

langfile = open("../main/resources/assets/tfcr/lang/en_us.lang", "w")
langfile.write(langfileText)
langfile.close()

import blocks.main

from __future__ import print_function
from wood import *

print("Generating logs... ", end='')

MODID = "tfcr:"
modelPath = "wood/logs/"
barkTexturePath = "blocks/wood/bark/"
logTexturePath = "blocks/wood/log/"
itemModelPath = "block/" + modelPath

blockstateOutput = "../main/resources/assets/tfcr/blockstates/wood/logs/"
modelOutput = "../main/resources/assets/tfcr/models/block/wood/logs/"
itemModelOutput = "../main/resources/assets/tfcr/models/item/wood/logs/"

# Get all the wood names
leaves = ["wood_" + l for l in getWoodTypes()]

rawBlockStateJSON = '''{
    "forge_marker": 1,
    "defaults": {
        "model": "tfcr:wood/block_log",
        "textures": {
            "side": "tfcr:blocks/wood/bark/NAME",
            "end": "tfcr:blocks/wood/log/NAME"
        }
    },
    "variants": {
        "normal": [ { } ],
        "inventory": [ { } ]
    }
}
'''

# TODO make this append to the lang file
# for now it just prints out all the tile name
langfile = open("../main/resources/assets/tfcr/lang/en_us.lang", "a")
langfile.write("\n")
for l in leaves:
    words = l.split("_")[1:]
    prettyName = ''.join(w.capitalize() + " " for w in words)
    #prettyS = s.replace("_", " ").capitalize()
    langName = "tile." + l + ".name=" + prettyName + "Log"

    #print("Created block \"" + prettyName.strip() + "\" (langfile: " + langName + ")")
    langfile.write(langName + "\n")
langfile.close()

# actual json output
for s in leaves:
    json = rawBlockStateJSON.replace('NAME', s)
    
    f = open(blockstateOutput + s + ".json", "w")
    f.write(json)
    f.close()

    '''   
    json = rawModelJSON.replace('NAME', s)
    
    f = open(modelOutput + s + ".json", "w")
    f.write(json)
    f.close()

    json = rawItemModelJSON.replace('NAME', s)
    
    f = open(itemModelOutput + s + ".json", "w")
    f.write(json)
    f.close()
    '''

print("successfully created " + str(len(leaves)) + " logs.")

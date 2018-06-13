from __future__ import print_function
from wood import *

print("Generating leaves... ", end='')

MODID = "tfcr:"
modelPath = "wood/leaves/"
texturePath = "blocks/" + modelPath
itemModelPath = "block/" + modelPath

blockstateOutput = "../main/resources/assets/tfcr/blockstates/wood/leaves/"
modelOutput = "../main/resources/assets/tfcr/models/block/wood/leaves/"
itemModelOutput = "../main/resources/assets/tfcr/models/item/wood/leaves/"

# Get all the wood names
leaves = ["leaves_" + l for l in getWoodTypes()]

rawBlockStateJSON = '''{
    "variants": {
        "normal": [{
            "model": "''' + MODID + modelPath + '''NAME"
        }]
    }
}
'''

rawModelJSON = '''{
    "parent": "block/cube_all",
    "textures": {
        "all": "''' + MODID + texturePath + '''NAME"
    },
    "elements": [
         {
             "from": [ 0, 0, 0 ],
             "to": [ 16, 16, 16 ],
             "faces": {
                "down":  { "tintindex": 0, "texture": "#all", "cullface": "down" },
                "up":    { "tintindex": 0, "texture": "#all", "cullface": "up" },
                "north": { "tintindex": 0, "texture": "#all", "cullface": "north" },
                "south": { "tintindex": 0, "texture": "#all", "cullface": "south" },
                "west":  { "tintindex": 0, "texture": "#all", "cullface": "west" },
                "east":  { "tintindex": 0, "texture": "#all", "cullface": "east" }
            }
         }
    ]
}
'''

rawItemModelJSON = '''{
    "parent": "''' + MODID + itemModelPath + '''NAME"
}
'''

# TODO make this append to the lang file
# for now it just prints out all the tile names
langfile = open("../main/resources/assets/tfcr/lang/en_us.lang", "a")
langfile.write("\n")
for l in leaves:
    words = l.split("_")[1:]
    prettyName = ''.join(w.capitalize() + " " for w in words)
    #prettyS = s.replace("_", " ").capitalize()
    langName = "tile." + l + ".name=" + prettyName + "Leaves"

    #print("Created block \"" + prettyName.strip() + "\" (langfile: " + langName + ")")
    langfile.write(langName + "\n")
langfile.close()

# actual json output
for s in leaves:
    json = rawBlockStateJSON.replace('NAME', s)
    
    f = open(blockstateOutput + s + ".json", "w")
    f.write(json)
    f.close()
   
    json = rawModelJSON.replace('NAME', s)
    
    f = open(modelOutput + s + ".json", "w")
    f.write(json)
    f.close()

    json = rawItemModelJSON.replace('NAME', s)
    
    f = open(itemModelOutput + s + ".json", "w")
    f.write(json)
    f.close()

print("successfully created " + str(len(leaves)) + " leaves.")

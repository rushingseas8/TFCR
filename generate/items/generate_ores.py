from __future__ import print_function
from ores import *

print("Generating ore items... ", end='')

MODID = "tfcr:"
texturePath = "items/ore/normal/"

itemModelOutput = "../main/resources/assets/tfcr/models/item/ore/"

ores = getOreTypes()
#for ore in sorted(ores):
#    print(ore.upper() + ",")

rawItemJSON = '''{
    "parent": "item/generated",
    "textures": {
        "layer0": "''' + MODID + texturePath + '''NAME"
     },

    "display": {
        "thirdperson": {
            "rotation": [-90,0,0],
            "translation": [0,1,-3],
            "scale": [0.55,0.55,0.55]
        },
        "firstperson": {
            "rotation": [0,-135,25],
            "translation": [0,4,2],
            "scale": [1.7,1.7,1.7]
        }
    }
}
'''
langfile = open("../main/resources/assets/tfcr/lang/en_us.lang", "a")
langfile.write("\n")
for ore in ores:
    words = ore.split("_")
    prettyName = ''.join(w.capitalize() + " " for w in words)
    langName = "item.ore_" + ore + "_normal.name=" + prettyName + "Ore"

    #print("Generated " + langName)
    langfile.write(langName + "\n")
langfile.close()

for ore in ores:
    json = rawItemJSON.replace('NAME', ore)

    fileLocation = itemModelOutput + "ore_" + ore + "_normal.json"
    #print("Saving to " + fileLocation)
    f = open(fileLocation, "w")
    f.write(json)
    f.close()

print("successfully created " + str(len(ores)) + " ore items.")

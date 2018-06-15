from __future__ import print_function
from metals import *

print("Generating ingot items... ", end='')

MODID = "tfcr:"
texturePath = "items/ingot/"

itemModelOutput = "../main/resources/assets/tfcr/models/item/ingot/"

metals = getMetalTypes()
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
for metal in metals:
    words = metal.split("_")
    prettyName = ''.join(w.capitalize() + " " for w in words)
    langName = "item.ingot_" + metal + ".name=" + prettyName + "Ingot"

    #print("Generated " + langName)
    langfile.write(langName + "\n")
langfile.close()

for metal in metals:
    json = rawItemJSON.replace('NAME', metal)

    fileLocation = itemModelOutput + "ingot_" + metal + ".json"
    #print("Saving to " + fileLocation)
    f = open(fileLocation, "w")
    f.write(json)
    f.close()

print("successfully created " + str(len(metals)) + " ingot items.")

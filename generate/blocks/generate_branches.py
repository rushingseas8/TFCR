from __future__ import print_function
from wood import *

print("Generating branches... ", end='')

MODID = "tfcr:"
modelPath = "wood/logs/"
barkTexturePath = "blocks/wood/bark/"
logTexturePath = "blocks/wood/log/"
itemModelPath = "block/" + modelPath

blockstateOutput = "../main/resources/assets/tfcr/blockstates/wood/branches/"

# Get all the wood names
logs = [l for l in getWoodTypes()]

rawBlockStateJSON = '''{
  "forge_marker": 1,
  "defaults": {
    "textures": {
      "side": "tfcr:blocks/wood/bark/wood_NAME",
      "end": "tfcr:blocks/wood/log/wood_NAME",
      "particle": "tfcr:blocks/wood/bark/wood_NAME"
    },
    "model": "tfcr:wood/branches/block_branch_4"
  },
    "variants": {
    "width": {
      "four": {
        "model": "tfcr:wood/branches/block_branch_4"
      },
      "six": {
        "model": "tfcr:wood/branches/block_branch_6"
      },
      "eight": {
        "model": "tfcr:wood/branches/block_branch_8"
      },
      "ten": {
        "model": "tfcr:wood/branches/block_branch_10"
      },
      "twelve": {
        "model": "tfcr:wood/branches/block_branch_12"
      }
    },
    "axis": {
      "y": {},
      "z": {
        "x": 90
      },
      "x": {
        "x": 90,
        "y": 90
      }
    }
    }
}
'''

langfile = open("../main/resources/assets/tfcr/lang/en_us.lang", "a")
langfile.write("\n")
for l in logs:
    words = l.split("_")[0:]
    prettyName = ''.join(w.capitalize() + " " for w in words)
    #prettyS = s.replace("_", " ").capitalize()
    langName = "tile.block_branch_" + l + ".name=" + prettyName + "Branch"

    #print("Created block \"" + prettyName.strip() + "\" (langfile: " + langName + ")")
    langfile.write(langName + "\n")
langfile.close()

# actual json output
for s in logs:
    json = rawBlockStateJSON.replace('NAME', s)
    
    f = open(blockstateOutput + "block_branch_" + s + ".json", "w")
    f.write(json)
    f.close()
  
print("successfully created " + str(len(logs)) + " branches.")

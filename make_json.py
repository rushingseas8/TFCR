filenames = "wood_acacia.png      wood_birch.png       wood_douglas_fir.png wood_maple.png       wood_pine.png        wood_spruce.png      wood_white_elm.png   wood_ash.png         wood_blackwood.png   wood_hickory.png     wood_oak.png         wood_rosewood.png    wood_sycamore.png    wood_willow.png   wood_aspen.png       wood_chestnut.png    wood_kapok.png       wood_palm.png        wood_sequoia.png     wood_white_cedar.png"

filenames = filenames.split(' ')
filenames = filter(None, filenames)
filenames = [x[0 : x.index('.')] for x in filenames]
#print(filenames)

rawBlockStateJSON = '''{
    "forge_marker": 1,
    "defaults": {
        "model": "minecraft:cube_column",
        "textures": {
            "side": "tfcr:blocks/wood/bark/WOODNAME",
            "end": "tfcr:blocks/wood/log/WOODNAME"
        }
    },
    "variants": {
        "normal": [ { } ],
        "inventory": [ { } ]
    }
}'''

rawModelJSON = '''{
    "parent": "block/cube_column",
    "textures": {
        "side": "tfcr:blocks/wood/bark/WOODNAME",
        "end": "tfcr:blocks/wood/log/WOODNAME"
    }
}'''

rawItemModelJSON = '''{
    "parent": "tfcr:block/WOODNAME"
}
'''


for s in filenames:
    words = s.split("_")[1:]
    prettyS = ''.join(w.capitalize() + " " for w in words)
    #prettyS = s.replace("_", " ").capitalize()
    print("tile." + s + ".name=" + prettyS + "Log")


#for s in filenames:
    #json = rawItemModelJSON.replace('WOODNAME', s)
    
    #f = open("./main/resources/assets/tfcr/models/item/" + s + ".json", "w")
    #f.write(json)
    #f.close()

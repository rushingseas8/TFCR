filenames = "wood_acacia.png      wood_birch.png       wood_douglas_fir.png wood_maple.png       wood_pine.png        wood_spruce.png      wood_white_elm.png   wood_ash.png         wood_blackwood.png   wood_hickory.png     wood_oak.png         wood_rosewood.png    wood_sycamore.png    wood_willow.png   wood_aspen.png       wood_chestnut.png    wood_kapok.png       wood_palm.png        wood_sequoia.png     wood_white_cedar.png"

filenames = filenames.split(' ')
filenames = filter(None, filenames)
filenames = [x[0 : x.index('.')].replace("wood_", "leaves_") for x in filenames]
#print(filenames)

basePath = "tfcr:"
texturePath = "blocks/wood/leaves/"

rawBlockStateJSON = '''{
    "variants": {
        "normal": [{
            "model": "''' + basePath + '''wood/leaves/NAME"
        }]
    }
}
'''

rawModelJSON = '''{
    "parent": "block/cube_all",
    "textures": {
        "all": "tfcr:''' + texturePath + '''NAME"
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
    "parent": "tfcr:block/wood/leaves/NAME"
}
'''


for s in filenames:
    words = s.split("_")[1:]
    prettyS = ''.join(w.capitalize() + " " for w in words)
    #prettyS = s.replace("_", " ").capitalize()
    print("tile." + s + ".name=" + prettyS + "Log")


for s in filenames:
    json = rawBlockStateJSON.replace('NAME', s)
    
    f = open("./main/resources/assets/tfcr/blockstates/wood/leaves/" + s + ".json", "w")
    f.write(json)
    f.close()
   
    '''
    json = rawModelJSON.replace('NAME', s)
    
    f = open("./main/resources/assets/tfcr/models/block/" + s + ".json", "w")
    f.write(json)
    f.close()
    '''

    json = rawItemModelJSON.replace('NAME', s)
    
    f = open("./main/resources/assets/tfcr/models/item/wood/leaves/" + s + ".json", "w")
    f.write(json)
    f.close()

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
            "model": "''' + basePath + '''NAME"
        }]
    }
}
'''

rawModelJSON = '''{
    "parent": "block/cube_all",
    "textures": {
        "all": "''' + basePath + texturePath + '''NAME"
    }
}'''

rawItemModelJSON = '''{
    "parent": "tfcr:block/NAME"
}
'''


for s in filenames:
    words = s.split("_")[1:]
    prettyS = ''.join(w.capitalize() + " " for w in words)
    #prettyS = s.replace("_", " ").capitalize()
    print("tile." + s + ".name=" + prettyS + "Leaves")


for s in filenames:
    json = rawBlockStateJSON.replace('NAME', s)
    
    f = open("./main/resources/assets/tfcr/blockstates/" + s + ".json", "w")
    f.write(json)
    f.close()
    
    json = rawModelJSON.replace('NAME', s)
    
    f = open("./main/resources/assets/tfcr/models/block/" + s + ".json", "w")
    f.write(json)
    f.close()

    json = rawItemModelJSON.replace('NAME', s)
    
    f = open("./main/resources/assets/tfcr/models/item/" + s + ".json", "w")
    f.write(json)
    f.close()

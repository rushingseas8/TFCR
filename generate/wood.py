def getWoodTypes():
    filenames = "wood_acacia.png      wood_birch.png       wood_douglas_fir.png wood_maple.png       wood_pine.png        wood_spruce.png      wood_white_elm.png   wood_ash.png         wood_blackwood.png   wood_hickory.png     wood_oak.png         wood_rosewood.png    wood_sycamore.png    wood_willow.png   wood_aspen.png       wood_chestnut.png    wood_kapok.png       wood_palm.png        wood_sequoia.png     wood_white_cedar.png"
    
    filenames = filenames.split(' ')
    filenames = filter(None, filenames)
    filenames = [x[0 : x.index('.')].replace("wood_", "") for x in filenames]
    
    return filenames

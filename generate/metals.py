def getMetalTypes():
    filenames = "bismuth.png         black_steel.png     bronze.png          lead.png            platinum.png        silver.png          tin.png             zinc.png bismuth_bronze.png  blue_steel.png      copper.png          nickel.png          red_steel.png       steel.png           unknown.png black_bronze.png    brass.png           gold.png            pig_iron.png        rose_gold.png       sterling_silver.png wrought_iron.png"
    
    filenames = filenames.split(' ')
    filenames = filter(None, filenames)
    filenames = [x[0 : x.index('.')] for x in filenames]
    
    return filenames

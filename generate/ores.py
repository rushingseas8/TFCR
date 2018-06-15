def getOreTypes():
    filenames = "bismuthinite.png    cinnabar.png        graphite.png        kaolinite.png       limonite.png        native_copper.png   olivine.png         satinspar.png       sulfur.png bituminous_coal.png cryolite.png        gypsum.png          kimberlite.png      magnetite.png       native_gold.png     petrified_wood.png  selenite.png        sylvite.png borax.png           galena.png          hematite.png        lapis_lazuli.png    malachite.png       native_platinum.png pitchblende.png     serpentine.png      tetrahedrite.png cassiterite.png     garnierite.png      jet.png             lignite.png         microcline.png      native_silver.png   saltpeter.png       sphalerite.png"
    
    filenames = filenames.split(' ')
    filenames = filter(None, filenames)
    filenames = [x[0 : x.index('.')] for x in filenames]
    
    return filenames

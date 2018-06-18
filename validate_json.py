from os import listdir
from os.path import isfile, join, dirname

import json

directories = [
    "main/resources/assets/tfcr/blockstates",
    "main/resources/assets/tfcr/blockstates/wood/branches",
    "main/resources/assets/tfcr/blockstates/wood/leaves",
    "main/resources/assets/tfcr/blockstates/wood/logs",
    "main/resources/assets/tfcr/models/block/wood",
    "main/resources/assets/tfcr/models/block",
    "main/resources/assets/tfcr/models/item"
]

errorString = ""
numErrors = 0

for dirName in directories:
    localDirName = join(dirname(__file__), dirName)
    files = [f for f in listdir(localDirName) if isfile(join(localDirName, f))]
    for f in files:
        if ".json" not in f:
            continue

        fullFileName = join(localDirName, f)
        with open(fullFileName) as fileObj:
            try:
                j =json.loads(fileObj.read())
            except ValueError as e:
                if errorString is not "":
                    errorString += "\n"
                errorString += "Failed to read " + fullFileName + "\n"
                errorString += "\tReason: " + str(e)

                numErrors+=1

if errorString is "":
    print("JSON validation succeeded. No errors found.")
else:
    print("JSON validation failed! " + str(numErrors) + " errors found.");
    print("--------------------------------------------------------------------------------")
    print(errorString)

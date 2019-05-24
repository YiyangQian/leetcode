// file for generating the TODO list

with open("Amazon.md") as inFile, open("Amazon1.md", "w") as outFile:
    lineNum = 1
    currentLine = inFile.readline()
    toWrite = ""
    while currentLine:
        if (lineNum % 2 == 0):
            toWrite += " " + currentLine
            outFile.write(toWrite)
            toWrite = ""
        else:
            toWrite = "- [] " + currentLine[:-1]
        lineNum = lineNum + 1
        currentLine = inFile.readline()


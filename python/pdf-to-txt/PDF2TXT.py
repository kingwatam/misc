from pdfminer.pdfinterp import PDFResourceManager, PDFPageInterpreter
from pdfminer.converter import TextConverter
from pdfminer.layout import LAParams
from pdfminer.pdfpage import PDFPage
import os
import sys, getopt
import io

#converts pdf, returns its text content as a string
def convert(fname, pages=None):
    if not pages:
        pagenums = set()
    else:
        pagenums = set(pages)

    output = io.StringIO()
    manager = PDFResourceManager()
    converter = TextConverter(manager, output, laparams=LAParams())
    interpreter = PDFPageInterpreter(manager, converter)

    infile = open(fname, 'rb')
    for page in PDFPage.get_pages(infile, pagenums, check_extractable=False, password=""):
        interpreter.process_page(page)

    infile.close()
    converter.close()
    text = output.getvalue()
    output.close
    return text

#converts all pdfs in directory pdfDir, saves all resulting txt files to txtdir
def convertMultiple(pdfDir, txtDir):
    if pdfDir == "": pdfDir = os.getcwd() + "\\" #if no pdfDir passed in 
    for pdf in os.listdir(pdfDir): #iterate through pdfs in pdf directory
        fileExtension = pdf.split(".")[-1]
        if fileExtension == "pdf":
            try:            
                pdfFilename = pdfDir + pdf 
                text = pdfparser(pdfFilename) #get string of text content of pdf
                textFilename = txtDir + pdf + ".txt"
                textFile = open(textFilename, "w", encoding='UTF-8' ) #make text file
                textFile.write(text) #write text to text file
                print (textFilename)
            except:
                print (txtDir + pdf + " ERROR!!!")
                pass

'''
"Comparative Law eJournal"
"LSN International Human Rights Issues (Topic)"
"LSN Investment (Topic)"
"LSN Securities Law U.S. (Topic)"
"Property, Land Use & Real Estate Law eJournal"
"Torts & Products Liability Law eJournal"


subFolders = [
        "LSN International Human Rights Issues (Topic)"]
for sub in subFolders:
    pdfDir = "C:/Users/kingw/Desktop/Law Papers/" + sub + "/"
    txtDir = "C:/Users/kingw/Desktop/Law Papers txt/" + sub + "/"
    
    convertMultiple(pdfDir, txtDir)
'''
'''
subFolders2 = [
    "Comparative Law eJournal",
    "LSN International Human Rights Issues (Topic)",
    "LSN Investment (Topic)",
    "Property, Land Use & Real Estate Law eJournal",
    "Torts & Products Liability Law eJournal"]

for sub in subFolders2:
    pdfDir = "C:/Users/kingw/Desktop/Law Papers/" + sub + "/foreign papers/"
    txtDir = "C:/Users/kingw/Desktop/Law Papers txt/" + sub + "/foreign papers/"
    convertMultiple(pdfDir, txtDir)

pdfDir = "C:/Users/kingw/Desktop/Law Papers/LSN Securities Law U.S. (Topic)/old versions/"
txtDir = "C:/Users/kingw/Desktop/Law Papers txt/LSN Securities Law U.S. (Topic)/old versions/"
convertMultiple(pdfDir, txtDir)

'''
pdfDir = "C:/Users/kingw/Desktop/Law Papers/test/"
txtDir = "C:/Users/kingw/Desktop/Law Papers/test/"

convertMultiple(pdfDir, txtDir)


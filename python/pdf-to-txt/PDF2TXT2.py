import sys
from pdfminer.pdfinterp import PDFResourceManager, PDFPageInterpreter
from pdfminer.pdfpage import PDFPage
from pdfminer.converter import TextConverter
from pdfminer.layout import LAParams
import io
import os

def pdfparser(data):

    fp = open(data, 'rb')
    rsrcmgr = PDFResourceManager()
    retstr = io.StringIO()
    codec = 'utf-8'
    laparams = LAParams()
    device = TextConverter(rsrcmgr, retstr, codec=codec, laparams=laparams)
    # Create a PDF interpreter object.
    interpreter = PDFPageInterpreter(rsrcmgr, device)
    # Process each page contained in the document.

    password = ""
    for page in PDFPage.get_pages(fp, check_extractable=False, password=password):
            interpreter.process_page(page)
    data = retstr.getvalue()
    return data


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


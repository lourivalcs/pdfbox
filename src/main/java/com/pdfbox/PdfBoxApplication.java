package com.pdfbox;

import com.pdfbox.features.*;

import java.util.ArrayList;

public class PdfBoxApplication {
    public static void main(String[] args) {
        String path = "C:\\temp\\";

        //create files
        NewPdf newpdf = new NewPdf(path);
        newpdf.createEmptyFile("TestEmpty");
        newpdf.createFileWithPageEmpty("TestWithPageEmpty");
        newpdf.createFileWithManyPagesEmpty("TestWithManyPages", 10);

        //load files from disc
        LoadPdf loadPdf = new LoadPdf(path);
        loadPdf.loadPdfAndAddPages("TestWithManyPages"); //15 pages
        loadPdf.removePage("TestWithManyPages"); // 14 pages

        //get properties of pdf
        PdfProperties pdfProperties = new PdfProperties(path);
        pdfProperties.addPropertiesPdf("AddPropertiesPDF");
        pdfProperties.loadPdfProperties("AddPropertiesPDF");

        //load and save text in pdf
        TextPdf textPdf = new TextPdf(path);
        textPdf.addTextInPdf("AddTextPDF");
        textPdf.loadTextFromPDF("AddTextPDF");

        //save image in pdf
        ImagePdf imagePdf = new ImagePdf(path);
        imagePdf.addImageInPdf("AddImagePDF", "C:\\temp\\img\\img.png");

        //save pdf with permissions and password
        SecurityPdf securityPdf = new SecurityPdf(path);
        securityPdf.addPasswordAndPermissionPdf("PdfWithPassword");

        //split document
        SplitPdf splitPdf = new SplitPdf(path);
        splitPdf.splitPdf("TestWithManyPages"); //generate 14 files

        //Merge multiples PDFs
        MergePdf mergePdf = new MergePdf(path);
        ArrayList<String> listPdf = new ArrayList<String>(){
            {
                add("AddTextPDF");
                add("AddImagePDF");
                add("TestWithManyPages");
            }
        };
        mergePdf.mergeMultiplesPdf("PdfMerge", listPdf);
    }
}

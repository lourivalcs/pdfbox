package com.pdfbox.features;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PdfProperties extends BasePdf {
    public PdfProperties(String path) {
        super(path);
    }

    public void addPropertiesPdf(String filename) {
        String pathWithName = fullPath(filename);
        try {
            PDDocument document = new PDDocument();

            PDPage page = new PDPage();
            document.addPage(page);

            PDDocumentInformation info = document.getDocumentInformation();
            info.setAuthor("Test add author");
            Calendar date = new GregorianCalendar();
            date.set(2021, 01, 03, 01, 00);
            info.setCreationDate(date);
            info.setCreator("Test add creator");

            document.save(pathWithName);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPdfProperties(String filename) {
        File file = new File(fullPath(filename));
        try {
            PDDocument document = PDDocument.load(file);
            PDDocumentInformation info = document.getDocumentInformation();

            System.out.println("Author: " + info.getAuthor());
            System.out.println("Creator: " + info.getCreator());
            System.out.println("Create Date: " + info.getCreationDate().getTime());

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.pdfbox.features;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class LoadPdf extends BasePdf {

    public LoadPdf(String path) {
        super(path);
    }

    public void loadPdfAndAddPages(String filename) {
        File file = new File(fullPath(filename));
        try {
            PDDocument document = PDDocument.load(file);
            addPages(document, createManyPagesEmpty(5));
            document.save(fullPath(filename));
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removePage(String filename){
        File file = new File(fullPath(filename));

        try {
            PDDocument document = PDDocument.load(file);
            document.removePage(5);
            document.save(fullPath(filename));
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

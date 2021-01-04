package com.pdfbox.features;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;
import java.util.List;

public class NewPdf extends BasePdf {

    public NewPdf(String path){
        super(path);
    }

    public void createEmptyFile(String fileName) {
        String pathWithName = fullPath(fileName);
        try {
            PDDocument document = new PDDocument();
            document.save(pathWithName);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFileWithPageEmpty(String fileName) {
        String pathWithName = fullPath(fileName);
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);
            document.save(pathWithName);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFileWithManyPagesEmpty(String fileName, int q){
        saveDocument(createManyPagesEmpty(q), fileName);
    }

    private void saveDocument(List<PDPage> pages, String fileName){
        String pathWithName = fullPath(fileName);
        try {
            PDDocument document = new PDDocument();
            addPages(document, pages);
            document.save(pathWithName);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

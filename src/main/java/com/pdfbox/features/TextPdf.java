package com.pdfbox.features;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class TextPdf extends BasePdf {

    public TextPdf(String path) {
        super(path);
    }

    public void addTextInPdf(String filename) {
        String pathWithName = fullPath(filename);
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            addText(document, page);
            document.addPage(page);
            document.save(pathWithName);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTextFromPDF(String filename) {
        File file = new File(fullPath(filename));
        try {
            PDDocument document = PDDocument.load(file);
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            System.out.println("Text PDF\n" +text);

            document.save(fullPath(filename));
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PDPageContentStream addText(PDDocument document, PDPage page) throws IOException {
        PDPageContentStream content = new PDPageContentStream(document, page);
        content.beginText();
        content.setFont(PDType1Font.TIMES_BOLD, 40);

        content.setLeading(40);
        content.newLineAtOffset(25, 500);
        //add line
        content.showText("This is a test");

        //add new line
        content.newLine();

        //add new text
        content.showText("This is another text");


        content.endText();
        content.close();
        return content;
    }
}

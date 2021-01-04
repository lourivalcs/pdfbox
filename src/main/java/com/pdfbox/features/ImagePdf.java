package com.pdfbox.features;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ImagePdf extends BasePdf {
    public ImagePdf(String path) {
        super(path);
    }

    public void addImageInPdf(String filename, String pathImage) {
        String pathWithName = fullPath(filename);
        try {
            PDDocument document = new PDDocument();

            PDPage page = new PDPage();
            document.addPage(page);

            PDImageXObject pdImage = PDImageXObject.createFromFile(pathImage, document);
            PDPageContentStream contents = new PDPageContentStream(document, page);


            contents.drawImage(pdImage, 70, 550);
            contents.close();

            document.save(pathWithName);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

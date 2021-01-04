package com.pdfbox.features;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class SplitPdf extends BasePdf {
    public SplitPdf(String path) {
        super(path);
    }

    public void splitPdf(String filename) {
        File file = new File(fullPath(filename));
        try {
            PDDocument document = PDDocument.load(file);

            Splitter splitter = new Splitter();
            List<PDDocument> Pages = splitter.split(document);
            Iterator<PDDocument> iterator = Pages.listIterator();

            //Saving each page as an individual document
            int i = 1;
            while (iterator.hasNext()) {
                PDDocument pd = iterator.next();
                pd.save(fullPath("split\\" + filename + i++));
            }

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

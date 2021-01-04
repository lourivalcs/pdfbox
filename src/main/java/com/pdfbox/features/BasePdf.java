package com.pdfbox.features;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePdf {

    private String path;

    public BasePdf(String path) {
        this.path = path;
    }

    protected PDDocument addPages(PDDocument document, List<PDPage> pages) {
        pages.forEach(document::addPage);
        return document;
    }

    protected String fullPath(String fileName) {
        return String.format("%s%s.pdf", this.path, fileName);
    }

    protected List<PDPage> createManyPagesEmpty(int q) {
        List<PDPage> pages = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            pages.add(new PDPage());
        }
        return pages;
    }
}

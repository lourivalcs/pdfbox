package com.pdfbox.features;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MergePdf extends BasePdf {
    public MergePdf(String path) {
        super(path);
    }

    public void mergeMultiplesPdf(String filenameMerge, List<String> filesName) {
        try {
            PDFMergerUtility merge = new PDFMergerUtility();
            merge.setDestinationFileName(fullPath(filenameMerge));

            filesName.forEach(
                    file -> {
                        try {
                            merge.addSource(new File(fullPath(file)));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    });


            merge.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

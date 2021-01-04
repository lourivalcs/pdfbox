package com.pdfbox.features;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import java.io.IOException;

public class SecurityPdf extends BasePdf {

    public SecurityPdf(String path) {
        super(path);
    }

    public void addPasswordAndPermissionPdf(String filename) {
        String pathWithName = fullPath(filename);
        try {
            PDDocument document = new PDDocument();

            PDPage page = new PDPage();
            document.addPage(page);

            AccessPermission accessPermission = new AccessPermission();
            accessPermission.setCanPrint(false);
            accessPermission.setReadOnly();

            StandardProtectionPolicy spp = new StandardProtectionPolicy("123", "123", accessPermission);
            spp.setEncryptionKeyLength(256);

            document.protect(spp);
            document.save(pathWithName);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

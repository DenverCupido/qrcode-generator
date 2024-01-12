package com.dfc.qrcodegenerator.util;

import com.dfc.qrcodegenerator.entity.QRData;
import net.glxn.qrgen.core.scheme.Schema;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.util.Base64;

@Service
public class QRCodeUtil {

    public String generatePlainTextQRCode(QRData qrData) throws Exception {
        File file = QRCode.from(qrData.getInputText())
                .withSize(500, 500)
                .file();

        return getBase64ImageFromFile(file);
    }

    public String generateVCardQRCode(QRData qrData) throws Exception {

        File file = getQRCodeFileFromSchema(qrData.getvCard());
        return getBase64ImageFromFile(file);
    }

    public String generateEMailQRCode(QRData qrData) throws Exception {
        File file = getQRCodeFileFromSchema(qrData.geteMail());

        return getBase64ImageFromFile(file);
    }

    public String generateTelephoneQRCode(QRData qrData) throws Exception {
        File file = getQRCodeFileFromSchema(qrData.getTelephone());

        return getBase64ImageFromFile(file);
    }

    private String getBase64ImageFromFile(File file) throws Exception {
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
    }

    private File getQRCodeFileFromSchema(Schema schema) {
        return QRCode.from(schema)
                .withSize(500, 500)
                .file();
    }

}
